package com.karinedias.model;

public class Manager implements Employee {

    private String name;


    @Override
    public void getTask() {
        System.out.println("I need to do a weekly planning with my team.");

    }
}
