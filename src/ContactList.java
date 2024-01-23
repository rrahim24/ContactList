import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    private ArrayList<Person> contacts;
    private Scanner scanner;

    // Constructor
    public ContactList() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Add contact
    public void addContact(Person person) {
        contacts.add(person);
    }

    // Print contacts
    public void printContacts() {
        for (Person person : contacts) {
            System.out.println(person);
        }
    }

    // Bubble Sort for contacts
    public void sortContacts(int sortBy) {
        for (int i = 0; i < contacts.size() - 1; i++) {
            for (int j = 0; j < contacts.size() - i - 1; j++) {
                if (needToSwap(contacts.get(j), contacts.get(j + 1), sortBy)) {
                    Person temp = contacts.get(j);
                    contacts.set(j, contacts.get(j + 1));
                    contacts.set(j + 1, temp);
                }
            }
        }
    }

    // Helper method for bubble sort
    private boolean needToSwap(Person first, Person second, int sortBy) {
        if (sortBy == 1) { // Sort by First Name
            return first.getFirstName().compareTo(second.getFirstName()) > 0;
        } else if (sortBy == 2) { // Sort by Last Name
            return first.getLastName().compareTo(second.getLastName()) > 0;
        } else { // Sort by Phone Number
            return first.getPhoneNumber().compareTo(second.getPhoneNumber()) > 0;
        }
    }

    // Search by first name
    public Person searchByFirstName(String firstName) {
        for (Person person : contacts) {
            if (person.getFirstName().equalsIgnoreCase(firstName)) {
                return person;
            }
        }
        return null;
    }

    // Search by last name
    public Person searchByLastName(String lastName) {
        for (Person person : contacts) {
            if (person.getLastName().equalsIgnoreCase(lastName)) {
                return person;
            }
        }
        return null;
    }

    // Search by phone number
    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person person : contacts) {
            if (person.getPhoneNumber().equals(phoneNumber)) {
                return person;
            }
        }
        return null;
    }

    // List all students
    public void listStudents() {
        for (Person person : contacts) {
            if (person instanceof Student) {
                System.out.println(person);
            }
        }
    }

    // Run the application
    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nContact List Application");
            System.out.println("1. Add Contact");
            System.out.println("2. List All Contacts");
            System.out.println("3. Sort Contacts by First Name");
            System.out.println("4. Sort Contacts by Last Name");
            System.out.println("5. Sort Contacts by Phone Number");
            System.out.println("6. Search by First Name");
            System.out.println("7. Search by Last Name");
            System.out.println("8. Search by Phone Number");
            System.out.println("9. List All Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the remaining newline

            // Handling user input
            // Handling user input
            if (choice == 1) {
                // Add new contact
                System.out.print("Enter first name: ");
                String firstName = scanner.nextLine();
                System.out.print("Enter last name: ");
                String lastName = scanner.nextLine();
                System.out.print("Enter phone number: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Enter type (1 for Student, 2 for Employee): ");
                int type = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                Person person;
                if (type == 1) {
                    System.out.print("Enter grade: ");
                    int grade = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    person = new Student(firstName, lastName, phoneNumber, grade);
                } else if (type == 2) {
                    System.out.print("Enter department: ");
                    String department = scanner.nextLine();
                    person = new Employee(firstName, lastName, phoneNumber, department);
                } else {
                    System.out.println("Invalid type entered");
                    person = new Person(firstName, lastName, phoneNumber);
                }
                addContact(person);
                System.out.println("Contact added successfully.");
            } else if (choice == 2) {
                printContacts();
            } else if (choice >= 3 && choice <= 5) {
                sortContacts(choice - 2);
            } else if (choice == 6) {
                // Search by first name
                System.out.print("Enter first name to search: ");
                String firstName = scanner.nextLine();
                Person foundPerson = searchByFirstName(firstName);
                if (foundPerson != null) {
                    System.out.println("Contact found: " + foundPerson);
                } else {
                    System.out.println("No contact with the first name " + firstName + " found.");
                }
            } else if (choice == 7) {
                // Search by last name
                System.out.print("Enter last name to search: ");
                String lastName = scanner.nextLine();
                Person foundPerson = searchByLastName(lastName);
                if (foundPerson != null) {
                    System.out.println("Contact found: " + foundPerson);
                } else {
                    System.out.println("No contact with the last name " + lastName + " found.");
                }
            } else if (choice == 8) {
                // Search by phone number
                System.out.print("Enter phone number to search: ");
                String phoneNumber = scanner.nextLine();
                Person foundPerson = searchByPhoneNumber(phoneNumber);
                if (foundPerson != null) {
                    System.out.println("Contact found: " + foundPerson);
                } else {
                    System.out.println("No contact with the phone number " + phoneNumber + " found.");
                }
            } else if (choice == 9) {
                listStudents();
            } else if (choice == 0) {
                exit = true;
                System.out.println("Exiting");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        }
    }


}
class Main {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        // Populate the contact list with some sample data if necessary
        contactList.run();
    }
}