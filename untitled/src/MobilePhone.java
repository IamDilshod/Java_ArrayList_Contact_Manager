import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> contactList;

    public MobilePhone() {
        this.contactList = new ArrayList<>();
    }

    public boolean addContact(Contact contact) {
        String targetName = contact.getName();
        int foundedIndex = findContact(targetName);

        if (foundedIndex != -1) {
            return false;
        }

        contactList.add(contact);
        return true;
    }

    public boolean removeContact(String name) {
        int foundedIndex = findContact(name);
        if (foundedIndex != -1) {
            contactList.remove(foundedIndex);
            return true;
        }

        return false;
    }

    public boolean editContact(int existingIndex, Contact contact) {
        Contact targetContact = contactList.get(existingIndex);
        if (targetContact == null){
            return false;
        }

        targetContact.setName(contact.getName());
        targetContact.setPhoneNumber(contact.getPhoneNumber());
        return true;
    }

    public int searchContact(String name) {
        int foundedIndex = findContact(name);
        return foundedIndex;
    }

    public void printContacts() {
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println("-----------------------------------------");
            System.out.println(i+1 + ": "  + contactList.get(i));
        }
    }

    private int findContact(String name) {
        for (int i = 0; i < contactList.size(); i++) {
            if(contactList.get(i).getName().equals(name)){
                return i;
            }
        }

        return -1;
    }
}
