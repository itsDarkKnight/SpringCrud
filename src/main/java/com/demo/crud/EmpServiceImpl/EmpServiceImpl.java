package com.demo.crud.EmpServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.crud.Repository.EmpRepository;
import com.demo.crud.Service.EmpServie;
import com.demo.crud.entity.Employee;

@Service
public class EmpServiceImpl implements EmpServie {

    @Autowired
    private EmpRepository empRepository;
    @Override
    public Employee saveStudent(Employee employee) {
        return empRepository.save(employee);
    }
    @Override
    public List<Employee> getUser() {
       return empRepository.findAll();
    }
    @Override
    public Employee getbyid(Long id) {
        return empRepository.findById(id).orElse(null);
    }
    @Override
    public Employee deleteuser(Long id) {
        
        empRepository.deleteById(id);
        return null;
    }
    @Override
    public Employee deletealluser() {
        empRepository.deleteAll();
        return null;
    }
    
    
     
}
