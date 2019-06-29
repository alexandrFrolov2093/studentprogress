package controllers;

import database.DBManager;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ModifyDisciplineController", urlPatterns = "/discipline-modify")


public class ModifyDisciplineController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("modifyId");
        Discipline discipline = DBManager.getDisciplineById(id);
        req.setAttribute("disc", discipline);
        req.getRequestDispatcher("/WEB-INF/jsp/discipline-modify.jsp").forward(req ,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String newDisc = req.getParameter("disName");
        DBManager.modifyDisciplines(id, newDisc);
        resp.sendRedirect("/disciplines");
    }
}
