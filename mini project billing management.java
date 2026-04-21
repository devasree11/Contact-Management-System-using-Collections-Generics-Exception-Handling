import java.util.*;

class Contact {
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void display() {
        System.out.println("Name: " + name + ", Phone: " + phone);
    }
}

public class ContactApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();

        while (true) {
            try {
                System.out.println("\n1. Add Contact");
                System.out.println("2. View Contacts");
                System.out.println("3. Search Contact");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter phone: ");
                        String phone = sc.nextLine();

                        contacts.add(new Contact(name, phone));
                        System.out.println("Contact added successfully!");
                        break;

                    case 2:
                        if (contacts.isEmpty()) {
                            System.out.println("No contacts found.");
                        } else {
                            for (Contact c : contacts) {
                                c.display();
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter name to search: ");
                        String searchName = sc.nextLine();
                        boolean found = false;

                        for (Contact c : contacts) {
                            if (c.getName().equalsIgnoreCase(searchName)) {
                                c.display();
                                found = true;
                            }
                        }

                        if (!found) {
                            System.out.println("Contact not found.");
                        }
                        break;

                    case 4:
                        System.out.println("Exiting...");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter numbers only.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}