package org.theAPITesting27112024;

public class NoDesignPattern {
    public void step1(){
        System.out.println("Step 1");
    }
    public void step2(){
        System.out.println("Step 2");
    }
    public void step3(String Parameter1){
        System.out.println("Step 3");
    }

    public static void main(String[] args) { // I fwe donot use any BDD then we need to create an object
        NoDesignPattern np = new NoDesignPattern();
        np.step1();
        np.step2();
        np.step3("Mehak");

// But if I want to combine them like
        // np.step1().step2().step3("Mehak")
        // This is not possible, it is possible only by using builder  design pattern
    }

}
