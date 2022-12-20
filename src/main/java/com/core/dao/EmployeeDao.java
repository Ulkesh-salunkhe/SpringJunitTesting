package com.core.dao;
import com.core.model.Employee;
import com.core.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDao {

    @Autowired
    EmployeeRepo employeeRepo;

    public void signUp(Employee employee){

        employeeRepo.save(employee);
    }
    public List<Employee> getData(){

      return employeeRepo.findAll();
    }


    public Employee updateData(Employee  employee){

        Employee emp = null;

        for(Employee empl : employeeRepo.findAll()){

            if(empl.getEmpId()==employee.getEmpId()){

                empl.setEmpName(employee.getEmpName());
                empl.setEmpAddress(employee.getEmpAddress());

                emp = empl;
            }
        }
        return emp;
    }
    public void deleteDataById(int id){

         employeeRepo.deleteById(id);
    }

}
