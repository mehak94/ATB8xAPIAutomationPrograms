package org.theAPITesting27112024;

public class BuilderDesignPattern {
// We have to follow the three rules as follows
        // Change the return type of each method as class type.
        // "this" always points to current/calling object.
        //Returning the same to have same reference.

         public BuilderDesignPattern step1(){
            System.out.println("Step 1 is started");
            System.out.println("Step 1 is done");
            return this;
        }
    public BuilderDesignPattern step2(){
        System.out.println("Step 2 is started");
        System.out.println("Step 2 is done");
        return this;
    }
    public BuilderDesignPattern step3(String name) {
        System.out.println("Step 3 is started");
        System.out.println("Step 3 is done -> " + name);
        return this;
    }

    public static void main(String[] args) {
BuilderDesignPattern bp = new BuilderDesignPattern();
bp.step1().step2().step3("Mehak"); // Thus we can combine by using builder design pattern
    }}

