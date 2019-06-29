package entity;

import java.util.Date;
import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private String sername;
    private String group;
    private Date date;

    public Student() {
    }

    public Student(String name, String sername, String group, Date date, int id) {
        this.name = name;
        this.sername = sername;
        this.group = group;
        this.date = date;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSername() {
        return sername;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sername='" + sername + '\'' +
                ", group='" + group + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name) &&
                Objects.equals(sername, student.sername) &&
                Objects.equals(group, student.group) &&
                Objects.equals(date, student.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sername, group, date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSername(String sername) {
        this.sername = sername;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
