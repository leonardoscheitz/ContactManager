package contactmanager;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ContactManager {
    private final String filePath = "contacts.json";
    private final Gson gson = new Gson();
    private List<Contact> contacts = new ArrayList<>();

    public ContactManager() {
        loadContacts();
    }

    private void loadContacts() {
        try (Reader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<ArrayList<Contact>>() {}.getType();
            contacts = gson.fromJson(reader, listType);
            if (contacts == null) contacts = new ArrayList<>();
        } catch (IOException e) {
            contacts = new ArrayList<>();
        }
    }

    private void saveContacts() {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(contacts, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar contatos.");
        }
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        saveContacts();
    }

    public void listContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Nenhum contato.");
            return;
        }
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i+1) + ". " + contacts.get(i));
        }
    }

    public void deleteContact(int index) {
          if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            saveContacts();
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void editContact(int index, Contact updatedContact) {
        if (index >= 0 && index < contacts.size()) {
            contacts.set(index, updatedContact);
            saveContacts();
        } else {
            System.out.println("Índice inválido.");
        }
    }
}