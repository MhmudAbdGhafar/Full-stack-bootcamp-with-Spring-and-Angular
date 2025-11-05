package main.com.myApp.service;

import main.com.myApp.dao.EmployeeDao;
import main.com.myApp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    EmployeeService(EmployeeDao employeeDao){
        this.employeeDao=employeeDao;
    }

    public void saveEmplyee(Employee employee)
    {
        employeeDao.save(employee);
    }
}
