package Parser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by JackSparrow on 4/3/2017.
 */
public class UserKeyword {

    static  String userKeyWord;

    public static void userKeyWord(){
        System.out.println("Enter Key For Search");
        Scanner scan = new Scanner(System.in);
        userKeyWord = scan.nextLine();
    }
}
