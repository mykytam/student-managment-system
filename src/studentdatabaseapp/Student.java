package studentdatabaseapp;

import java.util.Scanner;

import static javafx.scene.input.KeyCode.Q;

public class Student {

    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000;



    // Constructor: prompt user to enter user's name and year
    public Student () {
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter student's first name: ");
        this.firstName = in.nextLine();

        System.out.println("Enter student's last name: ");
        this.lastName = in.nextLine();

        System.out.println("\nEnter student's grade (1 - Freshman, 2 - Sophomore, 3 - Junior, 4 - Senior): ");
        this.gradeYear = in.nextInt();

        setStudentID();
    }

    // Generate an Id
    private void setStudentID() {
        // Grade Level + ID
       id++;
       this.studentID = gradeYear + ""  + id;
    }

    // Enroll in courses
    public void enroll() {
        // Get inside a loop, user hits 0
        do {
            System.out.println("Write course to enroll (press 'Q' to quit selection): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("Q")) {
                courses = courses + "\n  " + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            }
            else { break; }
        } while (1 != 0);
    }

    // View balance
    public void viewBalance() {
        System.out.println("Left to pay: $" + tuitionBalance);
    }

    // Pay Tuition
    public void payTuition () {
        viewBalance();
        System.out.println("Enter your payment: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }

    // Show status
    public String toString() {
        return "\nName: " + firstName + " " + lastName +
                "\nGrade level: " + gradeYear +
                "\nStudent ID: " +studentID +
                "\nCourses Enrolled:" + courses +
                "\nLeft to pay: $" + tuitionBalance;

    }
}
