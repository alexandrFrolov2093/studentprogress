package database;

import entity.Discipline;
import entity.Student;
import entity.Term;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBManager {
    public static List<Discipline> getAllActiveDisciplines() {
        ArrayList<Discipline> disciplines = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/syudents?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "C00PKmnBV112");
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM disciplines where status = '1'");

            while (result.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(result.getInt("id"));
                discipline.setDiscipline(result.getString("discipline"));
                disciplines.add(discipline);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;
    }

    public static void addNewDiscipline(String newDiscipline) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/syudents?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "C00PKmnBV112");
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `disciplines` (`discipline`) VALUES (' " + newDiscipline + " ');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Student> getAllActiveStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/syudents?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "C00PKmnBV112");
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM student where status = '1'");

            while (result.next()) {
                Student student = new Student();
                student.setId(result.getInt("id"));
                student.setName(result.getString("name"));
                student.setSername(result.getString("sername"));
                student.setGroup(result.getString("group"));
                student.setDate(result.getDate("date"));
                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;

    }

    public static void addNewStudent(Student student) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/syudents?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "C00PKmnBV112");
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `student` (`name`, `sername`, `group`, `date`) VALUES ('" + student.getName() + student.getSername() + student.getGroup() + student.getDate() + "');");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteDisciplines(String[] ids) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/syudents?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "C00PKmnBV112");
            Statement stmt = con.createStatement();
            for (String id : ids) {
                stmt.execute("UPDATE `disciplines` SET `status` = '0' WHERE (`id` = '" + id + "');");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Discipline getDisciplineById(String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/syudents?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "C00PKmnBV112");
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM disciplines where status = '1' and id = " + id);

            while (result.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(result.getInt("id"));
                discipline.setDiscipline(result.getString("discipline"));
                return discipline;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Discipline();
    }

    public static void modifyDisciplines(String id, String newDisc) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/syudents?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "C00PKmnBV112");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `disciplines` SET `discipline` = '" + newDisc + "' WHERE (`id` = " + id + ");");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<Term> getAllActiveTerm() {
        ArrayList<Term> terms = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/syudents?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "C00PKmnBV112");
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM term where status = '1'");

            while (result.next()) {
                Term term = new Term();
                term.setId(result.getInt("id"));
                term.setName(result.getString("term"));
                term.setDuration(result.getString("duration"));
                terms.add(term);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return terms;

    }

    public static List<Discipline> getAllDisciplinesByTerm(int idTerm) {

        ArrayList<Discipline> disciplines = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/syudents?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "C00PKmnBV112");
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM term_discipline\n" +
                    "left join disciplines on term_discipline.id_discipline = disciplines.id\n" +
                    "where term_discipline.id_term = 1 and disciplines.status = '1'");

            while (result.next()) {
               Discipline discipline = new Discipline();
               discipline.setId(result.getInt("id_discipline"));
               discipline.setDiscipline(result.getString("discipline"));
               disciplines.add(discipline);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;

    }


    public static void main(String[] args) {
        getAllActiveDisciplines();
    }
}




