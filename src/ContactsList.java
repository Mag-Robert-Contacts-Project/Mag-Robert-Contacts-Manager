import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ContactsList {

    public static void showContacts() throws IOException{
        Path contactsPath = Paths.get("src", "contacts.txt");
        List<String> contactsList = Files.readAllLines(contactsPath);
//        System.out.println(contactsList);
        for (int i = 0; i < contactsList.size(); i += 1) {
            System.out.println((i + 1) + ": " + contactsList.get(i));
        }

    }

    public static void addContact() throws IOException{
        Files.write(
                Paths.get("src", "contacts.txt"),
                Arrays.asList("Person Realname  |  6783459844"),
                StandardOpenOption.APPEND
        );
    }

    public static void deleteContact() throws IOException{
        Path contactsPath = Paths.get("src", "contacts.txt");
        List<String> contactsList = Files.readAllLines(contactsPath);
//        contactsList = Files.readAllLines(contactsPath);
        List<String> newList = new ArrayList<>();

        Scanner userDelete = new Scanner(System.in);
        String deleteName = userDelete.next();


        for (String line : contactsList) {
            if (line.equalsIgnoreCase(deleteName)) {
                newList.remove(deleteName);
                continue;
            }
            newList.add(line);
        }
//        System.out.println(newList);
        Files.write(contactsPath, newList);
    }


    public static void main(String[] args) throws IOException {

        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");

        Scanner userInput = new Scanner(System.in);
        String choice = userInput.next();

        int caseSwitch = Integer.parseInt(choice);

        switch (caseSwitch) {
            case 1:
                showContacts();
                break;
            case 2:
                addContact();
                break;
            case 3:
                System.out.println("search method");
                break;
            case 4:
                deleteContact();
                break;
            case 5:
                System.out.println("exit method");
            default:
                System.out.println("Default case");
        }


        //Writes new info in list
//        Files.write(
//                Paths.get("src", "contacts.txt"),
//                Arrays.asList("Person Realname  |  6783459844"),
//                StandardOpenOption.APPEND
//        );

//reads all info from text file
//        Path contactsPath = Paths.get("src", "contacts.txt");
//        List<String> contactsList = Files.readAllLines(contactsPath);
//        System.out.println(contactsList);
//        for (int i = 0; i < contactsList.size(); i += 1) {
//            System.out.println((i + 1) + ": " + contactsList.get(i));
//        }

        //this deletes whatever is typed verbatim
//        contactsList = Files.readAllLines(contactsPath);
//        List<String> newList = new ArrayList<>();
//
//        for (String line : contactsList) {
//            if (line.equalsIgnoreCase("Person Realname  |  6783459844")) {
//                newList.remove("Person Realname  |  6783459844");
//                continue;
//            }
//            newList.add(line);
//        }
//        System.out.println(newList);
//        Files.write(contactsPath, newList);

    }
}
