package com.mycompany.hwthree;
import java.util.ArrayList;

/*
 
 * Author: Luis Reynoso
 
 * Date: 03/28/21
 
 * Purpose: To implement school data for the student inputs in the main class.
 
 */
public class CollegeClass implements Comparable<CollegeClass>{
    
    private Person instructor;
    private int section;
    private Student[] students;
    private String subject;
    private String school;
    
    /*
    
        Purpose: To declare and initialize the instance variables.
        Parameters: Their purpose is to pass especific data to this method.
        Return: Nothing is returned.
    
    */
    public CollegeClass(Person instructor, int section, Student[] students, String subject, String school){
        this.instructor = new Person(instructor.getFirstName(), instructor.getLastName(), instructor.getAge());
        this.section = section;
        setStudents(students);
        this.subject = subject;
        this.school = school;
    }
    
    /*
    
        Purpose: To generate a copy of the input parameters and declare a specific parameter.
        Parameters: To generate a copy of the input parameter and add an additional parameter.
        Return: Nothing is returned.
    
    */
    public CollegeClass(Person instructor, int section, Student[] students){
        this(instructor, section, students, "Botany", "Michigan State University");
    }
    
    /*
    
        Purpose: To access the specific input parameter from constructor.
        Parameter: No parameter used.
        Return: Helps to pass the input parameter from constructor into main method.
    
    */
    public Person getInstructor(){
        return new Person(instructor.getFirstName(), instructor.getLastName(), instructor.getAge());
    }
    
    /*
    
        Purpose: To instantiate the input parameter to the instance variable to pass data to main method.
        Parameter: Its purpose is to pass specific data to this method.
        Return: Nothing is returned.
    
    */
    
    public void setInstructor(Person instructor){
        this.instructor = new Person(instructor.getFirstName(), instructor.getLastName(), instructor.getAge());
    }
    
    /*
    
        Purpose: To access the specific input parameter from constructor.
        Parameter: No parameter used.
        Return: Helps to pass the input parameter from constructor into main method.
    
    */
    public int getSection(){
        return section;
    }
    
    /*
    
        Purpose: To instantiate the input parameter to the instance variable to pass data to main method.
        Parameter: Its purpose is to pass specific data to this method.
        Return: Nothing is returned.
    
    */
    public void setSection(int section){
        this.section = section;
    }
    
    /*
        Purpose: To access the specific input parameter from constructor.
        Parameter: No parameter used.
        Return: Helps to pass the input parameter from constructor into main method.
    */
    public Student[] getStudents(){
        Student[] temp = new Student[students.length];
        for(int i = 0; i < students.length; i++){
            temp[i] = new Student(students[i]);
        }
	return temp;
    }
    
    /*
    
        Purpose: To instantiate the input parameter to the instance variable to pass data to main method.
        Parameter: Its purpose is to pass specific data to this method.
        Return: Nothing is returned.
    
    */
    public void setStudents(Student[] students){
        this.students = new Student[students.length];
        for(int i = 0; i < students.length; i++){
            this.students[i] = new Student(students[i]);
        }
        
    }
    
    /*
    
        Purpose: To access the specific input parameter from constructor.
        Parameter: No parameter used.
        Return: Helps to pass the input parameter from constructor into main method.
    
    */
    public String getSubject(){
        return subject;
    }
    
    /*
    
        Purpose: To instantiate the input parameter to the instance variable to pass data to main method.
        Parameter: Its purpose is to pass specific data to this method.
        Return: Nothing is returned.
    
    */
    public void setSubject(String subject){
        this.subject = subject;
    }
    
    /*
    
        Purpose: To access the specific input parameter from constructor.
        Parameter: No parameter used.
        Return: Helps to pass the input parameter from constructor into main method.
    
    */
    public String getSchool(){
        return school;
    }
    
    /*
    
        Purpose: To instantiate the input parameter to the instance variable to pass data to main method.
        Parameter: Its purpose is to pass specific data to this method.
        Return: Nothing is returned.
    
    */
    public void setSchool(String school){
        this.school = school;
    }

    /*
    
        Purpose: Decides whether the parameter o is a CollegeClass object with the same instructor, section, subject, and school as the current object.
        Parameter: Its purpose is to pass data of object created into method.
        Return: It helps to pass the true or false data output into main method.
    
    */
    @Override
    public boolean equals(Object o) {
        boolean flag = false;
        if (o != null && getClass() == o.getClass()) {
            if (this == o) {
                flag = true;
            } 
            
            else {
              	CollegeClass s = (CollegeClass) o;
		flag = instructor.equals(s.instructor) && section == (s.section)
			&& subject.equals(s.subject) && school.equals(s.school);
		}
            }
        return flag;
    }
    
    /*
    
        Purpose: To return a String that constains the instructor, school, subject, and section.
        Parameter: No parameter used.
        Return: It helps to pass the String into main method when this particular method is invoked.
    
    */
    @Override
    public String toString(){
        return "Instructor: " + instructor + " School: " + school + " Subject: " + subject + " Section: " + section;
    }
    
    /*
    
        Purpose: To compare the highest grade earned by a student in the course.
        Parameter: Its purpose is to pass data of object created into method. 
        Return: It helps to pass the desired data into main method when this particular method is invoked.
    
    */
    @Override
    public int compareTo(CollegeClass uc){
        return this.getStudentWithHighestGrade().getHighestGrade() - uc.getStudentWithHighestGrade().getHighestGrade();
    }
    
    /*
    
        Purpose: To return a String that constains a list of the students in the CollegeClass object.
        Parameters: No parameters used.
        Return: It helps to pass the String into main method when this particular method is invoked.
    
    */
    public String getStudentList(){
        String temp = "";
        for(int i = 0; i < students.length; i++){
            temp += students[i].toString() + "\n";
        }
        return temp;
    }
    
    /*
    
        Purpose: To return a Student object with the highest average.
        Parameters: No parameters used.
        Return: It helps to pass the data into main method when this particular method is invoked.
    
    */
    public Student getStudentWithHighestAverage(){
        Student greatest = students[0];
        for(int i = 0; i < students.length; i++){
            if(students[i].getAverageGrade() > greatest.getAverageGrade()){
                greatest = students[i];
            }
        }
        return new Student(greatest);
    }
    
    /*
    
        Purpose: To return a Student object with the highest grade.
        Parameters: No paramteters used.
        Return: It helps to pass the data into main method when this particular method is invoked.
    
    */
    public Student getStudentWithHighestGrade(){
        Student grade = students[0];
        for(int i = 0; i < students.length; i++){
            if(students[i].getHighestGrade() > grade.getHighestGrade()){
                grade = students[i];
            }
        }
        return new Student(grade);
    }
    
    /*
    
        Purpose: To return the number of students in the class.
        Parameters: No parameters used.
        Return: It helps to pass the data into the main method when this particular method is invoked.
    
    */
    public int getNumberOfStudents(){
       return students.length;  
    }
    
    /*
    
        Purpose: To return an ArrayList object that contains a list of the Student objects greater than the input parameter.
        Parameter: Its purpose is to pass specific data to this method.
        Return: It helps to pass the data into the main method when this particular method is invoked.
    
    */
    public ArrayList<Student> greaterThan(Student student){
        ArrayList<Student> arr = new ArrayList<>();
        for(int i = 0; i < students.length; i++){
            if(students[i].compareTo(student) > 0){
                arr.add(new Student(students[i]));
            }
        }
        return arr;
    }
        
}
        

