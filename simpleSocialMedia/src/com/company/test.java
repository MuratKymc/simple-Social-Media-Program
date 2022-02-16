package com.company;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {

        User u = new User("Ahmet", "Aytemiz", "ahmeta@gmail.com", "ahmta", "a1234");

        u.signUp();
        u.login("a1234");
        u.addPost("post1");
        u.addPost("post2");
        u.addPost("post3");
        u.viewProfile();

        System.out.println("\n------------------------------\n");

        User u2 = new User("Ali", "Veli", "aliveli@gmail.com", "aliveli", "12345");
        u2.signUp();
        u2.login(" 123");
        u2.addPost("post1");
        u2.addPost("post2");
        u2.addPost("post3");
        u2.viewProfile();
    }
}
