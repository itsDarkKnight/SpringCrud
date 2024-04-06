package com.demo.crud.Service;

import java.util.List;

import com.demo.crud.entity.Employee;


public interface EmpServie {

        public Employee saveStudent(Employee employee);
        public  Employee deleteuser(Long id);
        public  Employee deletealluser();
        public List<Employee> getUser();
        public Employee getbyid(Long id);
    }
