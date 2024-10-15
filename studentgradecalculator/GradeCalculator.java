
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = scan.nextLine();
        // Enter total number of subjects to calculate their marks
        System.out.println("Enter total number of subjects: ");
        int numSubjects = scan.nextInt();

        int totalMarks = 0;

        for (int i = 1; i <= numSubjects; i++) {
            System.out.println("Enter marks for subject " + i + "(out of 100): ");
            int marks = scan.nextInt();

            // INPUT VALIDATION
            while (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. Please enter marks between 0 and 100.");
                System.out.println("Enter marks for subject " + i + "out of 100): ");
                marks = scan.nextInt();
            }
            totalMarks += marks;
        }
        System.out.println("Student Result: ");
        System.out.println("Total marks obtained in all subjects: " + totalMarks);

        int AveragePercentage = totalMarks / numSubjects;

        System.out.println("Average Percentage: " + AveragePercentage + "%");

        if (AveragePercentage >= 90) {
            System.out.println("Your grade: A+");

        }

        else if (AveragePercentage >= 80) {
            System.out.println("Your grade: B+");
        }

        else if (AveragePercentage >= 70) {
            System.out.println("Your grade: B");
        }

        else if (AveragePercentage >= 60) {
            System.out.println("Your grade: C+");
        }

        else if (AveragePercentage >= 50) {
            System.out.println("Your grade: C");
        }

        else if (AveragePercentage >= 40) {
            System.out.println("Your grade: D+");
        }

        else if (AveragePercentage >= 30) {
            System.out.println("Your grade: D");
        }

        else {
            System.out.println("Your grade is: E");
        }

        scan.close();
    }
}