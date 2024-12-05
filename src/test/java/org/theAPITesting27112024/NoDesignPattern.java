package org.theAPITesting27112024;

public class NoDesignPattern {
    public void step1(){
        System.out.println("Step 1");
    }
    public void step2(){
        System.out.println("Step 2");
    }
    public void step3(String Parameter1){
        System.out.println("Step 3 ->"+ Parameter1); // Here we will write only step 3 if we are using constructors
  //  }
//static String Parameter1;
  //  NoDesignPattern( String Parameter1){
     //   this.Parameter1=Parameter1;}
      //  protected void step3(){
      //      System.out.println("Mehak");
        }

    public static void main(String[] args) { // If we donot use any BDD then we need to create an object
        NoDesignPattern np = new NoDesignPattern();// In bracket we can write Parameter1
        np.step1();
        np.step2();
        np.step3("Mehak");// Here we pass nothing if we are making use of constructors

        }}

// But if I want to combine them like
        // np.step1().step2().step3("Mehak")
        // This is not possible, it is possible only by using builder design pattern



