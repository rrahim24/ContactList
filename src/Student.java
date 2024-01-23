public class Student extends Person {
    private int grade;

    // Constructor
    public Student(String firstName, String lastName, String phoneNumber, int grade) {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    // Getter method
    public int getGrade() {
        return grade;
    }

    // toString method
    @Override
    public String toString() {
        return super.toString() + " Grade: " + grade;
    }
}