import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Lab2 {


    static void reverse (ArrayList<Integer> a) {
        for (int j = 0 ; j < a.size() ; j++) {
            int temp = 0 ;
            int last = a.size()-1;
            for (int i = 0 ; i < a.size() ; i++){
                temp = a.get(last);
                a.set(last, a.get(i));
                a.set(i, temp);
            }
        }
    }

    /*We have three methods: checkLength, checkSpecialCharacters, and
    checkUpperCaseLowerCase, each of which assigns a score based on specific criteria.
            - The totalScore is calculated by adding the scores from these methods.
            - Classify the password as strong (8 or more), moderately strong (5 or more), or weak
              based on the totalScore.
            - The criteria for scoring:
            • Length: 0-5 characters (0 points), 6-7 characters (2 points), 8 or more characters
            (3 points).
            • Special characters: Absence (0 points), Presence (2 points).
            • Uppercase and lowercase letters: Absence of both (0 points), presence of both (3
              points).*/
    static int checkLength (String password){
        int points = 0;
        if (password.length() == 6 || password.length() == 7){
         points = 2;
        }else if (password.length() >= 8){
            points = 3;
        }
        return points;
    }
    static int checkSpecialCharacters (String password){
        int points = 0;
        for (int i = 0; i < password.length(); i++){
            if (Character.isLetterOrDigit(password.charAt(i))==false){
                points = 2;
                break;
            }
        }
        return points;
    }
    static int checkUpperCaseLowerCase(String password){
        int points = 0;
        boolean is_there_uppercase = false;
        boolean is_there_lowercase = false;
        for (int i = 0; i < password.length(); i++){
            if (Character.isUpperCase(password.charAt(i))){
                is_there_uppercase = true;
            }
            if (Character.isLowerCase(password.charAt(i))){
                is_there_lowercase = true;
            }
        }
        if (is_there_uppercase && is_there_lowercase){
            points = 3;
        }
        return points;
    }
    static int total_score(String password){
        return checkLength(password)+checkUpperCaseLowerCase(password)+checkSpecialCharacters(password);
    }






    static ArrayList<Integer> Fibonacci(int seq){
        ArrayList<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(0);
        fibonacci.add(1);
        for (int i = 2; i < seq; i++){
            fibonacci.add(fibonacci.get(i-1)+fibonacci.get(i-2));
        }
        return fibonacci;
    }



    static ArrayList<Integer> generation (int min , int max , int num){
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0 ; i < num ; i++){
            list.add(rand.ints(min,max).findFirst().getAsInt());
        }
        return list;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        //1.Write a program to find all of the longest word in a given dictionary.
        ArrayList<String> words = new ArrayList<>();
        words.add("cat");
        words.add("dog");
        words.add("red");
        words.add("is");
        words.add("am");
        String longer = words.get(0);
        ArrayList<String> longest = new ArrayList<>();
        for (String w : words) {
            if (w.length() > longer.length()) {
                longer = w;
            }
        }
        for (String w : words) {
            if (w.length() == longer.length()) {
                longest.add(w);
            }
        }
        System.out.println(longest);
        System.out.println("*********************************************");

        //2. Write a program that displays the number of occurrences of an element in the array
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(3);
        numbers.add(3);
        numbers.add(5);
        int occurrences = 0 ;
        System.out.println("Enter a number : ");
        int num_1 = sc.nextInt();
        for (int n : numbers){
            if (n == num_1){
                occurrences++;
            }
        }
        System.out.println(num_1+" occurs "+occurrences+" time");
        System.out.println("*********************************************");

        /*3.Write a program to find the k largest elements in a given array. Elements in the array can be in
        any order.*/

        ArrayList<Integer> numbers2 = new ArrayList<>();
        numbers2.add(1);
        numbers2.add(4);
        numbers2.add(17);
        numbers2.add(7);
        numbers2.add(25);
        numbers2.add(3);
        numbers2.add(100);
        System.out.println("Enter a key : ");
        int key = sc.nextInt();
        ArrayList<Integer> largest = new ArrayList<>();
        Collections.sort(numbers2, Collections.reverseOrder());
        for (int i = 0 ; i < key ; i++){
            largest.add(numbers2.get(i));
        }
        System.out.println(key+" largest numbers are: "+largest);
        System.out.println("*********************************************");

        //4. Create a method to reverse an array of integers. Implement the method without creating a new array.
        ArrayList<Integer> numbers3 = new ArrayList<>();
        numbers3.add(5);
        numbers3.add(4);
        numbers3.add(3);
        numbers3.add(2);
        numbers3.add(1);
        reverse(numbers3);
        System.out.println(numbers3);
        System.out.println("*********************************************");



        //5. Write a menu driven Java program with following option
        boolean stop = true;
        int input = 0 ;
        ArrayList<Integer> numbers4 = new ArrayList<>();
        do{
            System.out.println("1. Accept elements of an array");
            System.out.println("2. Display elements of an array");
            System.out.println("3. Search the element within array");
            System.out.println("4. Sort the array");
            System.out.println("5. To Stop");
            input = sc.nextInt();
            switch (input){
                case 1:
                    System.out.println("Enter the element to be accepted : ");
                    int num_input = sc.nextInt();
                    numbers4.add(num_input);
                    break;
                case 2:
                    System.out.println(numbers4);
                    break;
                case 3:
                    System.out.println("Enter the element to search : ");
                    int num_input2 = sc.nextInt();
                    System.out.println(numbers4.contains(num_input2));
                    break;
                case 4:
                    Collections.sort(numbers4);
                    break;
                case 5:
                    stop = false;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }while(stop);

        /*6. Create a method that generates a random number within a given range. Allow the user to
        specify the range and call the method to display random numbers.
                Hint: use Random class*/
        System.out.println("Enter the minimum value of the range: ");
        int min = sc.nextInt();
        System.out.println("Enter the maximum value of the range: ");
        int max = sc.nextInt();
        System.out.println("Enter the number of random numbers to generate: ");
        int rand_num = sc.nextInt();
        System.out.println(generation(min,max,rand_num));
        System.out.println("*********************************************");

        /*7. Write a program that checks the strength of a password. Create a method that evaluates a
        password based on criteria like length, inclusion of special characters, and uppercase/lowercase
        letters.*/
        System.out.println("Enter the password");
        String password = sc.next();
        int score = total_score(password);
        if (score >= 8){
            System.out.println("Your password is strong ");
        } else if (score >= 5 && score < 8) {
            System.out.println("Your password is moderately strong ");
        }else {
            System.out.println("Your password is weak ");
        }
        System.out.println("*********************************************");

        //8. Create a method that generates the Fibonacci sequence up to a specified number of terms
        System.out.println("Enter the number of Fibonacci terms to generate: ");
        int terms = sc.nextInt();
        System.out.println(Fibonacci(terms));



    }
}
