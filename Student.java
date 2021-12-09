package com.mycompany.hwthree;

public class Student implements Comparable<Student>{
    
        private String firstName;
	private String lastName;
	private int[] grades;

	public Student(String firstName, String lastName, int[] grades) {
		this.firstName = firstName;
		this.lastName = lastName;
		setGrades(grades);  
	}

	/*  Copy constructor
	 *   This constructor allocates memory for a Student object where the 
	 *   instance variables have the same content as the input parameter.
	 *   
	 *   Use this to invoke the 1st constructor
	 */
	public Student(Student student) {
		this(student.firstName, student.lastName, student.grades); 
	}
        
        /*
    
            Purpose: To compare the which Student object is greater.
            Parameter: Its purpose is to pass data of object created into method. 
            Return: It helps to pass the desired data into main method when this particular method is invoked.
    
        */
        @Override
        public int compareTo(Student s){
            int tmp = lastName.compareTo(s.lastName);
            if(tmp == 0) {
                tmp = firstName.compareTo(s.firstName);
            }
            return tmp;
        }

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// return a memory address that is not equal to this.grades
	public int[] getGrades() {
		int[] temp = new int[grades.length];
		System.arraycopy(grades, 0, temp, 0, grades.length);
		return temp;
	}

	// address of this.grades not equal to the address of the parameter
	public void setGrades(int[] grades) {
		this.grades = new int[grades.length];
		System.arraycopy(grades, 0, this.grades, 0, grades.length);
	}
        
        @Override
        public boolean equals(Object o) {
            boolean flag = false;
            if (o != null && getClass() == o.getClass()) {
		if (this == o) {
                    flag = true;
		} 
                else {
			Student s = (Student) o;
			flag = firstName.equals(s.firstName) && lastName.equals(s.lastName)
						&& getHighestGrade() == s.getHighestGrade();
		}
            }
		return flag;
	}

        @Override
	public String toString() {
		return "Name: " + firstName + " " + lastName + "    Highest Grade " + getHighestGrade() + "  Average Grade: "
				+ String.format("%1.2f", getAverageGrade());
	}

	public void incrementAllGradesByOne() {
		for (int i = 0; i < grades.length; i++) {
			grades[i] += 1;
		}
	}

	public double getAverageGrade() {
		int sum = 0;
		for (int x : grades) {
			sum += x;
		}
		return (double) sum / grades.length;
	}

	public int getHighestGrade() {
		int greatest = Integer.MIN_VALUE;   
		for (int x : grades) {
			if (x > greatest) {
				greatest = x;
			}
		}
		return greatest;
	}
}
