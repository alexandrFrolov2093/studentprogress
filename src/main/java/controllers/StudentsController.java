package controllers;

import database.DBManager;
import entity.Discipline;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentsController", urlPatterns = "/students")

public class StudentsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = DBManager.getAllActiveStudents();
        req.setAttribute("list", students);
        req.getRequestDispatcher("/WEB-INF/jsp/students.jsp").forward(req, resp);
    }
}
