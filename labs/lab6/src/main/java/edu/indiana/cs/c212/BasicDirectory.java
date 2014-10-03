package edu.indiana.cs.c212;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jacob on 10/1/14. All rights reserved.
 */
public class BasicDirectory implements Directory {

    private List<Person> persons;

    BasicDirectory(){
        persons = new ArrayList<Person>();
    }

    BasicDirectory(List<Person> persons){
        this.persons = persons;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Person> getPeople() {
        return null; //FIXME
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Student> getStudents() {
        return null; //FIXME
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Professor> getProfessors() {
        return null; //FIXME
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Professor> getProfsSortedByStartDate() {
        return null; //FIXME
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Student> getStudentsSortedByGradDate() {
        return null; //FIXME
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void addStudent(Student student) {
        //FIXME
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void addProfessor(Professor professor) {
        //FIXME
    }
}
