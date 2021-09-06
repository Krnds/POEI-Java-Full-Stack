package com.karinedias.model;

public class ProductOwner implements Employee{

    private String name;


    @Override
    public void getTask() {
        System.out.println("I have to prioritize all new functionnalities!");

    }
}
