package com.mycompany.hwthree;

public class Person {   // File for HW3
    
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    /* The Override annotation means the class is overriding a method from a
       parent class. 
     */
    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + " age: " + age;
    }

    @Override
    public boolean equals(Object obj) {
        boolean flag = false; // assume objects aren't equal
        
        /* flag is false if the input object is null or if the input
           object isn't a Person object.
        */
        if (obj != null && getClass() == obj.getClass()) {
            if (this == obj) {
                flag = true;
            }
            else{
                Person p = (Person) obj;   // cast parameter to Person
                flag = age == p.age && firstName.equals(p.firstName)&&
                        lastName.equals(p.lastName);
            }
        }
        return flag;
    }

}
