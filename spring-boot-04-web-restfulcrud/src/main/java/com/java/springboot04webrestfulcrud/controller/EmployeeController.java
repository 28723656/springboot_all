package com.java.springboot04webrestfulcrud.controller;

import com.java.springboot04webrestfulcrud.dao.EmployeeDao;
import com.java.springboot04webrestfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    // 查询所有的员工，返回列表页面
    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    /**
     * 添加页面
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(){

        return "emp/add";
    }
}
