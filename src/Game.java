import java.util.Random;
import java.util.Scanner;

public class Game{
    String INTROLINE = "Thank you for starting the game. Please type P for Paper, R for Rock" +
            " and S for Scissor. Type E to end the game. This is not case sensitive";
    String PLEASE_ENTER_CORRECT = "Please could you enter P, R, S or E";

    Scanner s;



    public Game(){
        s = new Scanner(System.in);
    }

    public String askAndGetString(int i){
        if(i == 0){
            System.out.println(PLEASE_ENTER_CORRECT);
        }
        else if(i == 1){
            System.out.println(INTROLINE);
        }
        String userName = s.nextLine();
        return userName;
    }


    public char retfixedResponse(String s){
        String hold = s;
        while(true){
            String cap = hold.toUpperCase();
            if(cap.equals("E") || cap.equals("R") || cap.equals("S") || cap.equals("P")) {
                return cap.charAt(0);
            }else {
                hold = askAndGetString(0);
            }
        }
    }

    public char getRandomChar(){
        Random random = new Random();
        int randomNum = random.nextInt((2 - 0) + 1) + 0;
        if (randomNum == 0){
            return 'P';
        }else if(randomNum == 1){
            return 'S';
        }else{
            return 'R';
        }

    }

    public int checkValue(char c){
        char randChar = getRandomChar();
        if (c == 'R' && randChar == 'R') {
            System.out.println("Tied game between Rock and Rock");
            return 0;
        }else if(c == 'S' && randChar == 'S'){
            System.out.println("Tied game between Scissor and Scissor");
            return 0;
        }else if(c == 'P' && randChar == 'P'){
            System.out.println("Tied game between Paper and Paper");
            return 0;
        }else if (c == 'R' && randChar == 'S') {
            System.out.println("You Win. You chose Rock and it chose Scissor");
            return 1;
        }else if (c == 'R' && randChar == 'P') {
            System.out.println("You Lost. You chose Rock and it chose Paper");
            return -1;
        }else if (c == 'S' && randChar == 'P') {
            System.out.println("You Win. You chose Scissor and it chose Paper");
            return 1;
        }else if (c == 'S' && randChar == 'R') {
            System.out.println("You Lost. You chose Scissor and it chose Rock");
            return -1;
        }else if (c == 'P' && randChar == 'R') {
            System.out.println("You Win. You chose Paper and it chose Rock");
            return 1;
        }else {
            System.out.println("You Lost. You chose Paper and it chose Scissor");
            return -1;
        }
    }

    public void inTheGame(){
        int win_tracker = 0;
        int lose_tracker = 0;
        while(true){
            String s = askAndGetString(1);
            char c = retfixedResponse(s);
            if(c == 'E'){
                break;
            }
            int b = checkValue(c);
            if( b < 0){
                lose_tracker++;
            }else if(b > 0){
                win_tracker++;
            }
            System.out.printf("You have %d wins and %d loses. ", win_tracker, lose_tracker);
        }
    }
}