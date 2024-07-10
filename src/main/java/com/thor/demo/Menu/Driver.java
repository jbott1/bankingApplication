package com.thor.demo.Menu;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thor.demo.User;

public class Driver {

    static File  file = new File ("src/main/resources/userData.txt");

    public static User startGame() throws IOException {
        User user = new User();

        //TODO how to avoid needing to declare here

        Scanner sc = new Scanner(System.in);
        //no data create new char defaults

        if (file.length() == 0) {
            System.out.println("What would you like to name your character?");
            String name = sc.next();
            user.setName(name);
            System.out.println("you have chosen: " + name);

            user.setName(name);
            user.setHealth(user.getHealth());
            user.setStrength(user.getStrength());

            saveProgress(user);
            System.out.println("SavedProgress");
            return user;
        } else {


            System.out.println("Select Character or create new: ");
            user = getExistingUsers();
           listExistingUsers(user);
            //TODO Select User
            user = selectUser(user, sc);
            //TODO return User
        }

        //TODO have player select existing user or make new
        return user;
    }


    public static void playGame(User user){

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        Scanner sc = new Scanner(System.in);
        String play = "yes";
        String continueplay = "yes";
        while (play.equalsIgnoreCase(continueplay)){
            System.out.println("Continue playing?");
            continueplay = sc.nextLine();



        }
        System.out.println("Thank you for playing");
        System.out.println(user.getName());

        writer.println("Name:" + user.getName());
        writer.println("Health:" + user.getHealth());
        writer.println("Strength:" + user.getStrength());
        writer.println();
         writer.close();
    }

    private static <exception extends Throwable> void saveProgress(User user) throws IOException {

        try {

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, user);
            FileWriter fw = new FileWriter(file);
            PrintWriter writer = new PrintWriter(
                                        new BufferedWriter(fw));
            writer.println(user.toString());
            System.out.println("name:" + user.getName());
            writer.println(user.getName());
            System.out.println("health:" + user.getHealth());
            writer.println(user.getHealth());
            System.out.println("strength:" + user.getStrength());
            writer.println(user.getStrength());

            fw.close();
            writer.close();
        }
        catch (Exception e){
           System.out.println("Error saving progress");
        }

    }
    private static User getExistingUsers() throws IOException {

        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(file.getPath());
            return mapper.readValue(inputStream,User.class);


            } catch (Exception e) {
            //test
        }
        /*
        try {
        //TODO Find data type to read users back into from file.

            ArrayList<User> userList = (ArrayList<User>);
            for (User u : userList) {
                System.out.println(u.toString());
                System.out.println();
            }
            fis.close();
            ois.close();
            System.out.println("returned within try");
            return userList;

        }catch (EOFException e){
                //Exception
                System.out.println("Catch for getExistingUsers");
            } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        */

        System.out.println("returned end of getExistingUsers method");
        //TODO how to get user list in scope to return here
        return null;
    }





    private static User selectUser(ArrayList<User> userList, Scanner sc) {
        System.out.println("Input selection for user: ");
        int selection = sc.nextInt();
        System.out.println(userList.get(selection));
        return userList.get(selection);
    }

    private static void listExistingUsers(ArrayList<User> users){
        for (User user : users) {
            System.out.println(user + "\n");
        }

    }

}
