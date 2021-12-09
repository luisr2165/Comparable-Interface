package com.mycompany.hwthree;
import java.util.ArrayList;

public class HWThree {
    
    public static Student createStudent(String firstName, String lastName,int[] grades) {
        return new Student(new String(firstName), new String(lastName), grades);
    }
    
    public static void main(String[] args) {
        Student[] studentsOne = {createStudent("Raul", "Zee",
            new int[]{77, 85, 94}),
            createStudent("Gita", "Elle",
            new int[]{20, 82, 77, 16, 95}),
            createStudent("Pilar", "Zee",
            new int[]{86, 82, 93, 76}),
            new Student("Gillian", "H", new int[]{45, 87, 90})
        };
        
        Student[] studentsTwo = {createStudent("Vanessa", "El",
            new int[]{99, 78, 80, 99}),
            createStudent("Rick", "Jackson",
            new int[]{11, 93, 100}),
            createStudent("Camille", "Ess",
            new int[]{47, 12, 81, 88, 72}),
            new Student("Alison", "Jay", new int[]{65, 90, 89})
        };
        
        Person instructorOne = new Person("Bridgette", "Smith", 38);
        Person instructorTwo = new Person("Leo", "Monday", 43);

        // Create three CollegeClass objects
        CollegeClass ccOne = new CollegeClass(instructorOne, 11, studentsOne,
                "Mathematics", "SWC");
        CollegeClass ccTwo = new CollegeClass(instructorTwo, 15, studentsTwo,
                new String("Music"), new String("UCSD"));
        CollegeClass ccThree = new CollegeClass(instructorTwo, 15, studentsTwo,
                new String("Music"), new String("UCSD"));
        
        System.out.println("Display toString from the CollegeClass class");
        System.out.println("Class 1\n" + ccOne + "\n");
        System.out.println("Class 2\n" + ccTwo + "\n");
        System.out.println("Class 3\n" + ccThree + "\n");
        
        System.out.println("\nDisplay Student object with highest grade "
                + "in class 1:");
        System.out.println(ccOne.getStudentWithHighestGrade());
        System.out.println("\nDisplay Student object with highest average "
                + "in class 1:");
        System.out.println(ccOne.getStudentWithHighestAverage());
        
        System.out.println("\nDetermine if two CollegeClass objects are equal to "
                + "each other");
        
        System.out.println("Course 1 equals Course 2 " + ccTwo.equals(ccOne));    // false
        System.out.println("Course 3 equals Course 2 " + ccThree.equals(ccTwo));  // true

        System.out.println("\nCompare CollegeClass object to a different type"
                + " of objects - should always be false");
        System.out.println("Compare to null:" + ccOne.equals(null)); //false
        System.out.println("Compare to a Person object: " 
                + ccTwo.equals(instructorOne)); //false

        System.out.println("\nDisplay Students for ccOne");
        System.out.println("Number of Students in ccOne: " + 
                ccOne.getNumberOfStudents());
        System.out.println(ccOne.getStudentList());
        System.out.println("\nDisplay Students for ccTwo");
        System.out.println("Number of Students in ccTwo: " + 
                ccTwo.getNumberOfStudents());
        System.out.println(ccTwo.getStudentList());

        System.out.println("\nDisplay results of CollegeCourse "
                + "compareTo method");
        
        int compare = ccOne.compareTo(ccTwo);
        if (compare > 0) {
            System.out.println("ccOne > ccTwo");
        } else if (compare == 0) {
            System.out.println("ccOne = ccTwo");
        } else {
            System.out.println("ccOne < ccTwo");   //displays ccOne < ccTWo
        }

        compare = ccThree.compareTo(ccTwo);
        if (compare > 0) {
            System.out.println("ccThree > ccTwo");
        } else if (compare == 0) {
            System.out.println("ccThree = ccTwo");   // displays ccThree = ccTwo
        } else {
            System.out.println("ccThree < ccTwo");
        }

        System.out.println("\nDisplay results of greaterThan method");
        System.out.println("The list includes all last names from class 1"
                + " with last names greater than Gita Zee: ");
        ArrayList<Student> arrList
                = ccOne.greaterThan(createStudent("Gita", "Zee",
                        new int[]{15, 82, 77, 16, 91}));
        for (Student x : arrList) {
            System.out.println(x);
        }
        
        System.out.println("\nCreate a CollegeClass object called ccFour with constructor 2");
        CollegeClass ccFour = new CollegeClass(instructorOne, 12, studentsOne);
        System.out.println("\nDisplay toString for ccFour");
        System.out.println(ccFour);
        System.out.println("\nDisplay Students for ccFour");
        System.out.println(ccFour.getStudentList());
        System.out.println("\n---------------");
        System.out.println("\nVerify that changing data in the main method"
                + " doesn't change the contents of the instance variables");
        

        Person p = ccFour.getInstructor();
        Student[] studentArr = ccFour.getStudents();
        p.setFirstName(new String("Pilar"));
        p.setLastName(new String("Thompson"));
        p.setAge(56);
        studentArr[0] = createStudent("James", "Enn",
                new int[]{100, 82, 89});
        studentsOne[1] = createStudent("Ava", "Monday",
                new int[]{99, 88, 79});
        
        System.out.println("\nDisplay data for ccFour a 2nd time.  The data "
                + " shouldn\'t change.\n");
        System.out.println("Display toString for ccFour:");
        System.out.println(ccFour);
        System.out.println("\nDisplay Students for ccFour:");
        System.out.println(ccFour.getStudentList());
        System.out.println("\n---------------");
        System.out.println("\nSecond verification test that changing data in "
                + "the main method doesn't change the contents of the "
                + "instance variables");
        System.out.println("\nCreate a new CollegeClass object called ccFive");
        Person instructorThree = new Person("Mars", "Tuesday", 33);
        Student[] studentsThree = {createStudent("Vanessa", "El",
            new int[]{100, 78, 80, 99}),
            createStudent("Rick", "Jackson",
            new int[]{11, 93, 100}),
            createStudent("Camille", "Ess",
            new int[]{47, 12, 81, 88, 72}),
            new Student("Alison", "Jay", new int[]{65, 90, 89})
        };
        
        CollegeClass ccFive = new CollegeClass(instructorThree, 20, studentsThree,
                "German", "Univ of Michigan");
        System.out.println("Display  toString for  ccFive:");
        System.out.println(ccFive);
        System.out.println("\nDisplay Students for ccFive:");
        System.out.println(ccFive.getStudentList());
        System.out.println("\nUpdate input data to ccFive.");
        instructorThree.setFirstName("Chris");
        instructorThree.setLastName("Enns");
        instructorThree.setAge(65);
        studentsThree[0] = studentsThree[1];  // Student 0 = Rick Jackson
        System.out.println("\nDisplay data for ccFive a 2nd time.  The data "
                + " shouldn\'t change.\n");
        System.out.println("Display toString for ccFive:");
        System.out.println(ccFive);
        System.out.println("\nDisplay Students for ccFive:");
        System.out.println(ccFive.getStudentList());
        System.out.println("\nVerify setStudents protects data");
        studentsThree = new Student[]{createStudent("Amii", "Tuesday",
                new int[]{87, 71, 80}),
                createStudent("Jim", "Jackson",
                new int[]{12, 91, 100}),
            };
        
        ccFive.setStudents(studentsThree);
        System.out.println("\nDisplay Students for ccFive:");
        System.out.println(ccFive.getStudentList());
        studentsThree[0] = createStudent("Shaun", "Mills",
                new int[]{47, 12, 72});
        System.out.println("\nDisplay Students for ccFive a second time.  The should be no change:");
        System.out.println(ccFive.getStudentList());
        
        System.out.println("\nThe list includes all last names from ccTwo"
                + " with last names greater than Camille Ess: ");
        arrList = ccTwo.greaterThan(createStudent("Camille", "Ess",
                new int[]{100, 82, 77, 100, 91}));
        for (Student x : arrList) {
            System.out.println(x);
        }
        Student tmp = arrList.get(0);
        tmp.setLastName("YYYYYYYYYYYYYYYYYY");
        
        System.out.println("\nThe list includes all last names from ccTwo"
                + " with last names greater than Camille Ess: ");
        System.out.println("Verify the previous list didn't change: ");
        arrList = ccTwo.greaterThan(createStudent("Camille", "Ess",
                new int[]{100, 82, 77, 100, 91}));
        for (Student x : arrList) {
            System.out.println(x);
        }
        
        System.out.println("\nVerify getStudentWithHighestGrade method protects data ");
        tmp = ccTwo.getStudentWithHighestGrade();
        System.out.println(tmp);
        tmp.setFirstName("Bjorn");
        tmp = ccTwo.getStudentWithHighestGrade();
        System.out.println("\nThere should be no change in the previous output ");
        System.out.println(tmp);

        System.out.println("\nVerify getStudentWithHighestAverage method protects data ");
        tmp = ccTwo.getStudentWithHighestAverage();
        System.out.println(tmp);
        tmp.setFirstName("Ami");
        tmp = ccTwo.getStudentWithHighestAverage();
        System.out.println("\nThere should be no change in the previous output ");
        System.out.println(tmp);
        
    }
        
}
