package com.karinedias.model;

public class Developer implements Employee {

    private String name;


    @Override
    public void getTask() {

        System.out.println("I need to implement a new feature.");
    }
}
