package com.epic.excel_uploader.repository;

import com.epic.excel_uploader.entities.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee findById(int id);

    void saveEmployee(Employee employee);

    void deleteEmployeeBySsn(String ssn);

    List<Employee> findAllEmployees();

    Employee findEmployeeBySsn(String ssn);

}
