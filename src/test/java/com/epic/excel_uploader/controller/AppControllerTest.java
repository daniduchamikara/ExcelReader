package com.epic.excel_uploader.controller;

import com.epic.excel_uploader.entities.Employee;
import com.epic.excel_uploader.service.EmployeeService;
import org.joda.time.LocalDate;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class AppControllerTest {

    @Mock
    EmployeeService service;

    @Mock
    MessageSource message;

    @InjectMocks
    AppController appController;

    @Spy
    List<Employee> employees = new ArrayList<Employee>();

    @Spy
    ModelMap model;

    @Mock
    BindingResult result;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        employees = getEmployeeList();
    }

    public List<Employee> getEmployeeList() {
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("Axel");
        e1.setJoiningDate(new LocalDate());
        e1.setSalary(new BigDecimal(10000));
        e1.setSsn("XXX111");

        Employee e2 = new Employee();
        e2.setId(2);
        e2.setName("Jeremy");
        e2.setJoiningDate(new LocalDate());
        e2.setSalary(new BigDecimal(20000));
        e2.setSsn("XXX222");

        employees.add(e1);
        employees.add(e2);
        return employees;
    }
}
