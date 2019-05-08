package com.java.springboot04webrestfulcrud.controller;

import com.java.springboot04webrestfulcrud.dao.DepartmentDao;
import com.java.springboot04webrestfulcrud.dao.EmployeeDao;
import com.java.springboot04webrestfulcrud.entities.Department;
import com.java.springboot04webrestfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

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
    public String toAddPage(Model model){

        // 添加的时候把部门带上
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    // 添加员工
    @PostMapping("/emp")
    public String addEmp( Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable(value = "id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("emp",employee);
        // 添加的时候把部门带上
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
