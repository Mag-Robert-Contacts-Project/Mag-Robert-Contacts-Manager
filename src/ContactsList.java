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


    public static void main(String[] args) throws IOException {

        

        //Writes new info in list
        Files.write(
                Paths.get("src", "contacts.txt"),
                Arrays.asList("Person Realname  |  6783459844"),
                StandardOpenOption.APPEND
        );

//reads all info from text file
        Path contactsPath = Paths.get("src", "contacts.txt");
        List<String> contactsList = Files.readAllLines(contactsPath);
        System.out.println(contactsList);
        for (int i = 0; i < contactsList.size(); i += 1) {
            System.out.println((i + 1) + ": " + contactsList.get(i));
        }

        //this deletes whatever is typed verbatim
        contactsList = Files.readAllLines(contactsPath);
        List<String> newList = new ArrayList<>();

        for (String line : contactsList) {
            if (line.equalsIgnoreCase("Person Realname  |  6783459844")) {
                newList.remove("Person Realname  |  6783459844");
                continue;
            }
            newList.add(line);
        }
        System.out.println(newList);
        Files.write(contactsPath, newList);

    }
}
