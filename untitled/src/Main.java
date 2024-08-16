import java.util.Scanner;

public class Main{
    static Scanner sc = new Scanner(System.in);
    static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        boolean isQuit = false;
        selectOptions();

        while(!isQuit){
            int option = sc.nextInt();
            switch(option){
                case 1:
                    addContact();
                    break;
                case 2:
                    printContacts();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    editContact();
                    break;
                case 0:
                    isQuit=true;
                    break;
            }
        }
    }

    public static void addContact(){
        System.out.print("Enter your name: ");
        String name = sc.next();
        System.out.print("Enter your phone number: ");
        String phone = sc.next();

        Contact newContact = Contact.createContact(name, phone);
        if (mobilePhone.addContact(newContact)){
            System.out.println("Contact added!");
        }else {
            System.out.println("This contact is already exist!");
        }
    }

    public static void deleteContact(){
        System.out.print("Enter your name: ");
        String name = sc.next();

        if (mobilePhone.removeContact(name)){
            System.out.println(name + " deleted!");
        }else {
            System.out.println("This contact is not exist!");
        }
    }

    public static void editContact(){
        System.out.println("Enter existing contact name:");
        String existingName = sc.next();
        int existingIndex = mobilePhone.searchContact(existingName);
        if (existingIndex == -1){
            System.out.println(existingName + " does not exist!");
            return;
        }

        System.out.print("Enter your name: ");
        String name = sc.next();
        System.out.print("Enter your phone number: ");
        String phone = sc.next();
        Contact newContact = Contact.createContact(name, phone);
        mobilePhone.editContact(existingIndex, newContact);
        System.out.println("Contact updated!");
    }

    public static void printContacts(){
        mobilePhone.printContacts();
    }

    public static void selectOptions(){
        System.out.println("1 - Add Contact");
        System.out.println("2 - Print Contacts");
        System.out.println("3 - Delete Contact");
        System.out.println("4 - Edit Contact");
        System.out.println("0 - Quit");
    }
}

