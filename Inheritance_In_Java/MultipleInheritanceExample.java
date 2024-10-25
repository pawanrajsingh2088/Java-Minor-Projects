// Example: Solving Multiple Inheritance in Java using Interfaces

// Interface 1: Sports
// This interface represents sports-related activities and provides a method to display sports skills.
interface Sports {
    // Method declaration for displaying sports skills.
    void showSportsSkills();
}

// Interface 2: Academics
// This interface represents academic activities and provides a method to display academic achievements.
interface Academics {
    // Method declaration for displaying academic achievements.
    void showAcademicAchievements();
}

// Class: Student
// The Student class implements both Sports and Academics interfaces.
// By doing so, it "inherits" methods from both interfaces and can display skills from both areas.
class Student implements Sports, Academics {
    private String name;      // Student's name
    private String sport;     // Sport that the student excels in
    private String subject;   // Subject that the student excels in

    // Constructor to initialize the student's name, sport, and subject.
    public Student(String name, String sport, String subject) {
        this.name = name;
        this.sport = sport;
        this.subject = subject;
    }

    // Implementation of the showSportsSkills method from the Sports interface
    // This method displays the sport that the student excels in.
    @Override
    public void showSportsSkills() {
        System.out.println(name + " excels in the sport of " + sport + ".");
    }

    // Implementation of the showAcademicAchievements method from the Academics interface
    // This method displays the subject that the student excels in.
    @Override
    public void showAcademicAchievements() {
        System.out.println(name + " excels academically in " + subject + ".");
    }

    // Additional method to demonstrate both skills of a student.
    public void showAllAchievements() {
        System.out.println("Achievements of " + name + ":");
        showSportsSkills();           // Display sports skills
        showAcademicAchievements();    // Display academic achievements
    }
}

// Main class
// In this main class, we create a Student object that displays both sports and academic achievements.
public class MultipleInheritanceExample {
    public static void main(String[] args) {
        // Creating a Student object with a name, sport, and academic subject.
        Student student1 = new Student("Alice", "Basketball", "Mathematics");

        // Displaying all achievements of the student.
        student1.showAllAchievements();
        
        // Creating another Student object with different details to show versatility.
        Student student2 = new Student("Bob", "Swimming", "Physics");
        student2.showAllAchievements();
    }
}

/*
Output:
Achievements of Alice:
Alice excels in the sport of Basketball.
Alice excels academically in Mathematics.

Achievements of Bob:
Bob excels in the sport of Swimming.
Bob excels academically in Physics.
*/
