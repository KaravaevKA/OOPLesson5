package model.base;

import model.User;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Map;
import java.util.prefs.BackingStoreException;

public class PhoneBook {
    public int getCount() {
        return count;
    }

    public boolean addContact(User newContact) {
        if (isSetContact(newContact))
            return false;
        contacts.put(newContact.getPhone().getData(), newContact);
        return true;
    }

    public boolean removeContact(String phoneNumber) {
        if (!contacts.containsKey(phoneNumber)) {
            return false;
        }
        contacts.remove(phoneNumber);
        return true;
    }

    public int updateContact(String phoneNumber, User updContact) {
        if (!contacts.containsKey(phoneNumber))
            return -1;
        if (updContact.equals(contacts.get(updContact.getPhone().getData())))
            return 0;
        contacts.remove(phoneNumber);
        contacts.put(updContact.getPhone().getData(), updContact);
        return 1;
    }

    public User findContact(String phoneNumber) {
        if (contacts.containsKey(phoneNumber))
            return contacts.get(phoneNumber);
        return null;
    }

    public void importData(Parser parser) {
        for (User user : parser) {
            this.addContact(user);
        }
    }

    public void exportData(Exporter exporter) throws BackingStoreException, IOException, ParserConfigurationException, TransformerException, SAXException {
        User[] usr = new User[contacts.size()];
        int cnt = 0;
        for (String ks : contacts.keySet()) {
            usr[cnt++] = contacts.get(ks);
        }
        exporter.export(usr);
    }

    private boolean isSetContact(User contact) {
        return contacts.containsKey(contact.getPhone().getData());
    }

    private Map<String, User> contacts;
    private int count;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String ks : contacts.keySet()){
            sb.append(contacts.get(ks).toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
