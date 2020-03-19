package com.crud.controller;

import com.crud.configuration.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;



import java.util.Scanner;

public class EmployeeController {
    public static void main(String args[])
    {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        JdbcTemplate template = (JdbcTemplate) ac.getBean("template");
        Scanner sc=new Scanner(System.in);
        System.out.println("Press 1 to insert data\nPress 2 to view data\nPress 3 to update data\nPress 4 to delete data");
        int ch=sc.nextInt();

        switch(ch)
        {
            case 1:
            System.out.println("Enter id");
            int id=sc.nextInt();
            System.out.println("Enter name");
            String name=sc.next();
            System.out.println("Enter Department");
            String department=sc.next();
            String insertSql = "insert into employee values(?,?,?)";
            int row = template.update(insertSql, id,name,department);
            System.out.println(row + " row inserted.");
            break;

            case 2:
            String selectSql = "SELECT * FROM employee";
            //System.out.println(template.query(selectSql,new BeanPropertyRowMapper(Student.class)));
            break;

            case 3:
                System.out.println("Enter id");
                id=sc.nextInt();
                System.out.println("Enter name");
                name=sc.next();
                System.out.println("Enter Department");
                department=sc.next();
                //String updatesql=UPDATE employee SET name = name, department= department WHERE CustomerID = id;
                //row = template.update(updateSql, id,name,department);
                //System.out.println(row + " row updated");
                break;
            default:
                System.out.println("Enter between 1-3");
                break;
        }
    }
}
