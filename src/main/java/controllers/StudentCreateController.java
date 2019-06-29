package controllers;

import database.DBManager;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet (name = "StudentCreateController", urlPatterns = "/student-create")

public class StudentCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/student-create.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        SimpleDateFormat formatter2=new SimpleDateFormat("yy-mm-dd");
        Date date2= null;
        try {
            date2 = formatter2.parse(req.getParameter("newDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.setDate(date2);
        student.setGroup(req.getParameter("newGroup"));
        student.setSername(req.getParameter("newSername"));
        student.setName(req.getParameter("newName"));
        DBManager.addNewStudent(student);
        resp.sendRedirect("/students");
    }
}
