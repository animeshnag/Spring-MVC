package com.java.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.employee.Employee;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestCalling {

    private static final String GET_ALL_URL = "http://localhost:8081/spring/rest/emps";
    private static final String CREATE_EMP_URL = "http://localhost:8081/spring/rest/emp/create";
    private Scanner sc = new Scanner(System.in);
    public  void callMethods(){
        while (true) {
            int option = 1;
            System.out.println("Press 1.for Employee List\nPress 2.For create Employee");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    getAllEmployee();
                    break;
                case 2:
                    createEmployee();
                    break;
                default:
                    return;
            }
        }
    }

    private void getAllEmployee() {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(restTemplate.getForObject(GET_ALL_URL, String.class));
    }

    private void createEmployee() {
        RestTemplate restTemplate = new RestTemplate();
        Employee emp = new Employee();
        emp.setId(2);
        emp.setName("Animesh");
        emp.setDepartment("CS");
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        HttpEntity request = new HttpEntity(emp, headers);
        restTemplate.postForObject(CREATE_EMP_URL, request, String.class);
    }

    private void printEmpData(Employee emp){
        System.out.println("ID="+emp.getId()+",Name="+emp.getName()+",Department Name : = "+emp.getDepartment());
    }
}