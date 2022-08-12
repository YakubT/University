package com.solvd.laba.university;

import com.solvd.laba.university.enums.TypeOfStudy;
import com.solvd.laba.university.exceptions.IncorrectDepartmentException;
import com.solvd.laba.university.exceptions.IncorrectEduProgramException;
import com.solvd.laba.university.exceptions.IncorrectStartYearOfStudyException;
import com.solvd.laba.university.exceptions.IncorrectStudentDataException;

import java.time.LocalDate;

public class StudentCard {
    private String group;
    private String studentCardId;
    private String img;
    private Faculty faculty;
    private TypeOfStudy typeOfStudy;
    private EducationalProgram eduProgram;
    private Department department;

    private int startYearOfStudy;
    public StudentCard(String studentCardId,String img,Faculty faculty,TypeOfStudy typeOfStudy,EducationalProgram EduProgram,int startYearOfStudy){
        this.studentCardId = studentCardId;
        this.img = img;
        this.faculty = faculty;
        this.typeOfStudy = typeOfStudy;
        this.eduProgram = EduProgram;
        this.startYearOfStudy = startYearOfStudy;
        getCourseOfStudy();
    }
    public StudentCard(){

    }

    public String getStudentCardId() {
        return studentCardId;
    }

    public String getImg() {
        return img;
    }


    public Faculty getFaculty() {
        return faculty;
    }

    public TypeOfStudy getTypeOfStudy() {
        return typeOfStudy;
    }

    private boolean isDepartmentHasEduProgram(EducationalProgram educationalProgram){
        return department.getListOfEduPrograms().stream().anyMatch(ed->ed.equals(educationalProgram));
    }
    private boolean isFacultyHasDepartment (Department department){
        return faculty.getListOfDepartments().stream().anyMatch(dep->dep.equals(department));
    }
    public EducationalProgram getEduProgram() {
        if (department==null)
            throw new IncorrectStudentDataException("Department is not assigned");
        if (!isDepartmentHasEduProgram(eduProgram))
            throw new IncorrectEduProgramException();
        return eduProgram;
    }

    public int getStartYearOfStudy() {
        return startYearOfStudy;
    }

    public String getGroup() {
        return group;
    }

    public Department getDepartment() {
        if (faculty==null)
            throw new IncorrectStudentDataException("Faculty is not assigned");
        if (!isFacultyHasDepartment(department))
            throw new IncorrectDepartmentException();
        return department;
    }

    public void setStudentCardId(String studentCardId) {
        this.studentCardId = studentCardId;
    }

    public void setDepartment(Department department) {
        if (this.faculty==null) {
            throw new IncorrectDepartmentException("Faculty doesn't assigned: at first assign faculty");
        }
        this.department = department;
        if (!isFacultyHasDepartment(department)) {
            throw new IncorrectDepartmentException();
        }
        eduProgram = null;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setFaculty(Faculty faculty) {

        this.faculty = faculty;
        department = null;
        eduProgram = null;
    }

    public void setTypeOfStudy(TypeOfStudy typeOfStudy) {
        this.typeOfStudy = typeOfStudy;
    }

    public void setEduProgram(EducationalProgram EduProgram) {
        if (this.department==null) {
            throw new IncorrectEduProgramException("Department doesn't assigned: at first assign department");
        }
        this.eduProgram = EduProgram;
        if (!isDepartmentHasEduProgram(EduProgram)) {
            throw new IncorrectEduProgramException();
        }
    }

    public void setStartYearOfStudy(int startYearOfStudy) {
        this.startYearOfStudy = startYearOfStudy;
        getCourseOfStudy();
    }

    public void setGroup(String group) {
        this.group = group;
    }
    public int getCourseOfStudy(){
        int yearNow = LocalDate.now().getYear();
        int monthNow = LocalDate.now().getMonthValue();
        int course = yearNow-getStartYearOfStudy()+1;
        if (monthNow<9) {
            course--;
        }
        if (course<=0) {
            throw new IncorrectStartYearOfStudyException("The year of study is higher than current");
        }
        return course;
    }
}
