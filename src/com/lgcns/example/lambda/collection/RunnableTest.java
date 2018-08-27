package com.lgcns.example.lambda.collection;

/**
 * @author MikeW
 */
public class RunnableTest {

    // Lambda Runnable
    public static Runnable r3 = () -> { System.out.println("Hello world three!"); };

	public static void main(String[] args) {
    
    System.out.println("=== RunnableTest ===");
    
    // Anonymous Runnable
    Runnable r1 = new Runnable(){
      
      @Override
      public void run(){
        System.out.println("Hello world one!");
      }
    };
    
    // Lambda Runnable
    Runnable r2 = () -> { System.out.println("Hello world two!"); };
    
    // Run em!
    r1.run();
    r2.run();
    r3.run();
  }
}
