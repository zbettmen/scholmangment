package se.ecutb.scholm;

import java.util.Scanner;

public class input {

   private static Scanner scan = new Scanner(System.in);
    public static String getString(){
        return scan.nextLine();
    }

    public static int getInt(){
        boolean valid = false;
        int number = 0;
        while(!valid){
            try{
                number = Integer.parseInt(getString());
                valid = true;
            }catch (NumberFormatException exceptionName){
                System.out.println("Press 1 to loop");
            }
        }
        return number;
    }

}
