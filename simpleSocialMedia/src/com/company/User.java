package com.company;

import java.io.*;
import java.util.Scanner;

public class User {
    private String name;
    private String surname;
    private String email;
    private String userName;
    private String password;
    private String address;
    private File userFile;
    private File postFile;
    public boolean hasLogin;

    public User(String name, String surname, String email, String userName, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.userName = userName;
        this.password = password;

        try {
            userFile = new File(email + ".txt");
            postFile = new File(email + "_post.txt");
            if (!userFile.exists()) {
                userFile.createNewFile();
            }
            if (!postFile.exists()) {
                postFile.createNewFile();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void viewProfile() {

        System.out.println("\n \t" + this.name + "'s profile.");

        try {
            Scanner reader = new Scanner(postFile);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void addPost(String post) {
        if (hasLogin) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(postFile, true));
                writer.write(post);
                writer.newLine();
                writer.close();
                System.out.println("Post uploaded.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("You must be logged in to post.");
        }

    }

    public void login(String password) {
        try {
            Scanner reader = new Scanner(userFile);
            String psw = reader.nextLine();
            reader.close();

            if (psw.equals(password)) {
                System.out.println("Login successfully.");
                hasLogin = true;
            } else {
                hasLogin = false;
                System.out.println("Wrong password. Login unsuccessfully.");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void signUp() {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(userFile));
            writer.write(this.password);
            writer.newLine();
            writer.write(this.name);
            writer.newLine();
            writer.write(this.surname);
            writer.newLine();
            writer.write(this.email);
            writer.newLine();
            writer.write(this.userName);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
