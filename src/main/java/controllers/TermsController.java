package controllers;

import database.DBManager;
import entity.Discipline;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TermsController", urlPatterns = "/terms")


public class TermsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Term> terms = DBManager.getAllActiveTerm();
        req.setAttribute("terms", terms);

        Object idSelectedTerm = req.getAttribute("idSelectedTerm");
        if(idSelectedTerm != null){
            int idSelectedTermInt = Integer.parseInt((String) idSelectedTerm);
            for(Term term : terms){
                if(term.getId() == idSelectedTermInt){
                    req.setAttribute("selectedTerm", term);
                }
            }
            req.setAttribute("selectedTerm", terms.get(0));
        }else {
            if(terms.size() != 0){
                Term selectedTerm = terms.get(0);
                List<Discipline> disciplines = DBManager.getAllDisciplinesByTerm(selectedTerm.getId());
                req.setAttribute("disciplines", disciplines);
                req.setAttribute("selectedTerm", selectedTerm);
            }
        }
        req.getRequestDispatcher("/WEB-INF/jsp/terms.jsp").forward(req, resp);

    }
}
