package com.lxh.controller;

import com.lxh.service.StudentService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/student.do")
public class StudentController {

    private StudentService studentService;

    public void queryList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("StudentController.queryList()...");
    }

}
