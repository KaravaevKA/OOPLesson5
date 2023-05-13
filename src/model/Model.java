package model;

import model.base.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.prefs.BackingStoreException;

public class Model {
    public boolean addContact(User contact) {
        return book.addContact(contact);
    }

    public boolean removeContact(String phoneNumber) {
        return book.removeContact(phoneNumber);
    }

    public int updateContact(String phoneNumber, User contact) {
        return book.updateContact(phoneNumber, contact);
    }

    public User findContact(String phoneNumber) {
        return book.findContact(phoneNumber);
    }

    public void exportCSV(String filename) throws BackingStoreException, IOException, ParserConfigurationException, TransformerException, SAXException {
        book.exportData(new CSVExport(filename));
    }

    public void exportXML(String filename) throws BackingStoreException, IOException, ParserConfigurationException, TransformerException, SAXException {
        book.exportData(new XMLExport(filename));
    }

    public void importCSV(String filename) throws FileNotFoundException {
        book.importData(new CSVParse(filename));
    }

    public void importXML(String filename) throws FileNotFoundException {
        book.importData(new XMLParse(filename));
    }

    @Override
    public String toString() {
        return book.toString();
    }

    private PhoneBook book = new PhoneBook();
}
