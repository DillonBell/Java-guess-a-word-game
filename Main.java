// Code by Dillon bell
// 2025-01-12

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        char[] brokenDownWord, hiddenWord;
        char guess;
        int numGuesses = 0;
        boolean matchFound = false;
        do {
            System.out.println("Welcome to my Guess a Word Game!,\n" +
                    "Please select a topic\n" +
                    "1) Minecraft\n" +
                    "2) Va-11 Hall-A Drinks\n" +
                    "3) Plants vs Zombies (Plants)");


            String[] minecraft = {"creeper", "ender", "pickaxe", "steve", "diamond", "nether", "block"};

            String[] vallHalla = {"bluefairy", "moonblast", "badtouch", "sugarrush", "beer", "brandtini", "bleedingjane"};

            String[] pvz = {"peashooter", "sunflower", "wallnut", "chomper", "cactus", "showpea", "cherrybomb"};
            byte choice = input.nextByte();
            input.nextLine();

            String[] words = switch (choice) {
                case 1 -> minecraft;
                case 2 -> vallHalla;
                default -> pvz;
            };

            brokenDownWord = words[r.nextInt(words.length)].toCharArray();
            //words[0-6] words[0] -> bluefairy.toCharArray() - > ['b']['l']['u']['e']['f']['a']['i']['r']['y']
            hiddenWord = new char[brokenDownWord.length]; // - > ['']['']['']['']['']['']['']['']['']
            Arrays.fill(hiddenWord, '*');//              - >  ['*']['*']['*']['*']['*']['*']['*']['*']['*']


            do {
                System.out.println("Enter a letter in the word " + new String(hiddenWord) + ">");
                guess = input.nextLine().trim().toLowerCase().charAt(0);
                //" HeLLo " -> "hello" -> "h" -> "h"
                for (int i = 0; i < brokenDownWord.length; i++) {
                    if (brokenDownWord[i] == guess) {
                        hiddenWord[i] = guess;
                        matchFound = true;
                    }
                }
                if (!matchFound) {
                    numGuesses++;
                }
                System.out.println(guess + " was " + (matchFound ? "found" : "not found"));
                matchFound = false;
            } while (!Arrays.equals(brokenDownWord, hiddenWord));
            System.out.println("The word is " + new String(hiddenWord) + " You missed " + numGuesses + " time(s)");
            System.out.println("Would you like play again? Enter y or n");
            guess = input.nextLine().trim().toLowerCase().charAt(0);
            numGuesses = 0;

        }while (guess == 'y');
        input.close();
    }

}