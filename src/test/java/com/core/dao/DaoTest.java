package com.core.dao;
import com.core.model.Employee;
import com.core.repo.EmployeeRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DaoTest {

   @Autowired
    EmployeeDao employeeDao;

    @MockBean
    EmployeeRepo employeeRepo;

   @Test
    public void signUpTest(){

       Employee employee = new Employee(1,"ulkesh","pune","ulkesh@gmail.com","pass");

       employeeDao.signUp(employee);

       verify(employeeRepo).save(employee);

   }

   @Test
    public void getAll(){

       List list = new ArrayList();

      Employee employee = new Employee(1,"ulkesh","pune","ulkesh@gmail.com","pass");

      list.add(employee);

       when(employeeRepo.findAll()).thenReturn(list);
       assertEquals(1,employeeDao.getData().size());
   }

   @Test
    public void updatedataTest(){

       Employee em=null;

       Employee employee = new Employee(1,"ulkesh","pune","ulkesh@gmail.com","pass");

       Employee emply = new Employee(1,"ulkesh","pune","ulkesh@gmail.com","pass");

       employeeRepo.save(employee);

    // List<Employee> employe=  employeeRepo.findAll();

      // em=employee;
       employeeDao.updateData(employee);
      verify(employeeRepo,times(1)).save(emply);

    /* *//*  Employee em=null;

           if(employee.getEmpId()==emply.getEmpId()){
               employee.setEmpAddress(emply.getEmpAddress());

               em = employee;
       }*//*
           employeeDao.updateData(emply);
       verify(employeeRepo,times(1)).save(emply);

       //assertEquals(1,employeeDao.updateData(emply));*/
   }

   @Test
    public void deletTest(){

       Employee employee = new Employee(1,"ulkesh","pune","ulkesh@gmail.com","pass");

       employeeDao.deleteDataById(employee.getEmpId());

       verify(employeeRepo,times(1)).deleteById(employee.getEmpId());
   }



}
