package com.thor.demo.menu;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thor.demo.model.User;

public class Driver {

    static File file = new File("src/main/resources/userData.txt");

    public static User startGame() throws IOException {
        //User user = new User();
        //TODO how to avoid needing to declare here

        Scanner sc = new Scanner(System.in);
        //no data create new char defaults
        if (file.length() == 0) {
            System.out.println("What would you like to name your character?");
            String name = sc.next();
            user.setName(name);
            System.out.println("you have chosen: " + name);

            saveProgress(user);
            return user;
        } else {
            System.out.println("Select Character or create new: ");
            //TODO List Users
            listExistingUsers();
            //TODO Select User
            //user = selectUser(user, sc);
            //TODO return User
        }
        //TODO have player select existing user or make new
        return user;
    }


    public static void playGame(User user) throws IOException {

        Scanner sc = new Scanner(System.in);
        String play = "yes";
        while (play.equalsIgnoreCase("yes")) {
            System.out.println("Continue playing[yes/no]?");
            play = sc.nextLine();


        }
        System.out.println("Thank you for playing " + user.getName());

        saveProgress(user);

    }

    private static <exception extends Throwable> void saveProgress(User user) throws IOException {

        try {
                //TODO need to prevent overwritting of old characters
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, user);
            FileWriter fw = new FileWriter(file);
            PrintWriter writer = new PrintWriter(fw);

            writer.println(user.toString());

            fw.close();
            writer.close();
            System.out.println("SavedProgress");
        } catch (Exception e) {
            System.out.println("Error saving progress");
        }

    }



    private static User selectUser(ArrayList<User> userList, Scanner sc) {
        System.out.println("Input selection for user: ");
        int selection = sc.nextInt();
        System.out.println(userList.get(selection));
        return userList.get(selection);
    }

    private static void listExistingUsers() {
        try {

            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(file.getPath());



            byte[] array = new byte[inputStream.available()];
            inputStream.read(array);
            String data = new String(array);
            System.out.println(data + "From data");


            JsonFactory jfactory = new JsonFactory();
            JsonParser jParser = jfactory.createJsonParser(inputStream);

            ArrayList userList = new ArrayList<>();

            User user = mapper.readValue(jParser, User.class);
            userList.add(user);
            System.out.println("From Mapper" + mapper.readValue(inputStream, User.class));
            userList.add(mapper.readValue(inputStream, User.class));

            System.out.println("From User Array List" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));
            //Utils.stringToJSON(data);
            //ArrayList userList = new ArrayList<User>();
            //userList.add(mapper.readValue(json, User.class));
            // System.out.println(mapper.readValue(inputStream,User.class) + "From mapper");
            // System.out.println("check output of reading user list from file");
            //TODO Select user, assign and return here


        } catch (Exception e) {
            //test
        }

    }

}
