package com.example;
import java.util.List;

public class Student
{
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades)
    {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

    public void setGroup(String group)
    {
        this.group = group;
    }
    public String getGroup()
    {
        return group;
    }

    public int getCourse()
    {
        return course;
    }
    public void setCourse(int course)
    {
        this.course = course;
    }

    public float getAverageGrade()
    {
        if(grades.isEmpty()) return 0;
        int sum = 0;
        for(int grade : grades)
        {
            sum += grade;
        }
        return (float)sum / grades.size();
    }

    public void toNextCourse()
    {
        course++;
    }

    @Override
    public String toString()
    {
        return name + " (Группа: " + group + ", Курс: " + course + ")";
    }

}
