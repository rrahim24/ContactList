public class Employee extends Person {
    private String department;

    // Constructor
    public Employee(String firstName, String lastName, String phoneNumber, String department) {
        super(firstName, lastName, phoneNumber);
        this.department = department;
    }

    // Getter method
    public String getDepartment() {
        return department;
    }

    // toString method
    @Override
    public String toString() {
        return super.toString() + " Department: " + department;
    }
}
