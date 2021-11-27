package emailapp;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int defaultPasswordLength = 10;
    private String email;
    private int mailboxCapacity;
    private String alternateEmail;
    private String companySuffix = "xyzcompany.com";

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is " + this.password);

        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        System.out.println("Your email is " + email);
    }

    private String setDepartment() {
    System.out.println("DEPARTMENT CODES\n1 for Sales\n2 for Developement\n3 for Accounting\n0 for none\nEnter code for department: ");
    Scanner in = new Scanner(System.in);
    int depChoice = in.nextInt();
    if (depChoice == 1) {return "sales";}
    else if (depChoice == 2) {return "dev";}
    else if (depChoice == 3) {return "accounting";}
    else {return "";}
    }

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ012356789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void setMailboxCapacity(int capacityMB) {
        this.mailboxCapacity = capacityMB;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {return this.mailboxCapacity;}

}
