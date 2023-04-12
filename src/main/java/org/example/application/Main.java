package org.example.application;

import org.example.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full file path: ");
        String path = sc.nextLine();

        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                employees.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            System.out.print("Enter with salary: ");
            double avg = sc.nextDouble();

            List<String> eMails = employees.stream().filter(x -> x.getSalary() > avg).map(x -> x.getEMail()).sorted().collect(Collectors.toList());

            System.out.println();
            System.out.printf("E-mail of people whose salary is more than $%.2f:%n" , avg);
            eMails.forEach(System.out::println);

            Double m = employees.stream().filter(x -> x.getName().toUpperCase().charAt(0) == 'M').map(x -> x.getSalary()).reduce(0.0, (x, y) -> x + y);

            System.out.println();
            System.out.printf("Sum of salary of people whose name starts with 'M': $%.2f", m );



        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}