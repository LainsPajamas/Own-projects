import java.io.IOException;
import java.util.*;
import java.util.Random;
import java.util.Scanner; 

// ADT for the program
class gameADT {
    String question; // Questions
    String answer; // Answers
    Boolean is_used; // Used status of the qusetion
}

class game {
    public static void main (String [] a) throws IOException {
        game_controller(); 
        return;
    } // END main

    // States the rules of the game
    public static gameADT quiz_data(String q, String a) {
        gameADT r = new gameADT();

        r.question = q; // Sets the question
        r.answer = a; // Sets the answer
        r.is_used = false; // Sets the question either used or not
    return r;
    }

    // Sets the answer
    public static String get_a(gameADT r) {
        return r.answer;
    }

    // Sets the question
    public static String get_q(gameADT r) {
        return r.question;
    }

    // Checks to see if the question is used
    public static boolean isUsed(gameADT r) {
        return r.is_used;
    }

    // Sets the question to be used so it is not used again
    public static void set_used(gameADT r) {
        r.is_used = true;
    }

    // The controller method for the program
    public static void game_controller() throws IOException {
        gameADT[] q = new gameADT[0];
        String choice = "";

        while (!choice.equalsIgnoreCase("E")) {
            choice = menu();
            if (choice.equalsIgnoreCase("P")) { // Play
                run_quiz(q);
            }
            else if (choice.equalsIgnoreCase("L")) { // Load
                create_add(true); // Append mode is on
            }
            else if (choice.equalsIgnoreCase("C")) { // Create
                create_add(false); // Append mode is off
            }
            else if (choice.equalsIgnoreCase("E")) { // Exit
                System.out.println("Exiting program...");
            }
            else { // Default
                System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // The menu of the game where the user can choose what to do
    public static String menu () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-----Double or Quit-----");
        System.out.println("(P)lay");
        System.out.println("(L)oad a quiz");
        System.out.println("(C)reate a quiz");
        System.out.println("(E)xit program");
    return scanner.nextLine();
    }

    // The rules of the game
    public static void rules() {
        System.out.println("Rules:");
        System.out.println("1) You have a starting pot of £500");
        System.out.println("2) Getting an answer right doubles your pot");
        System.out.println("3) Getting an answer wrong halves your pot");
        System.out.println("4) You can 'pass' a question");
        System.out.println("5) All questions have one word answers");
        System.out.println();
    return;
    }

    // Gets an answer from the user
    public static String get_ans () { 
        Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
    }

    // Reads the number of lines in a file to determine the total number of question
    public static int file_lines (String filename) throws IOException {
        int count = 0;

        Scanner file = new Scanner(new File(filename));
        while (file.hasNextLine()) {
            if (!file.nextLine().isEmpty()) {
                count++;
            }
        }
        file.close();
    return count;
    }
    
    // Creates a random index depending on the number of questions
    public static int rand_index (int array_length) {
        Random rand = new Random();
        int random = rand.nextInt(array_length);
    return random;
    }

    // Marks the user's answer and returns a boolean
    public static boolean mark_q (gameADT r, String input) { // Marks the user answer to see if it's correct or not
        return get_a(r).equalsIgnoreCase(input);
    }

    // Updates the winnings of the player(s)
    public static int winnings (Boolean q_mark, int current) { // Returns the new pot value of the user based on their answer
        if (q_mark)
            return current * 2; // true
        else
            return current / 2; // false
    }

    // Either creates or add new questions to a (pre-existed) file
    public static void create_add(Boolean append) throws IOException { // Creates a new quiz set
        Scanner scanner = new Scanner(System.in);
        
        if (append == true) {
            System.out.println("*Enter a name of the quiz you would like to add questions to (e.g history.txt)*");
        }
        else {
            System.out.println("*Enter a name for the quiz you would like to create (e.g history.txt)*");
        }
        
        System.out.println("*Please make sure the answers to the questions are one word*");
        String filename = scanner.nextLine().trim();
        while (!filename.contains(".txt")) {
            System.out.println("File name must end with .txt");
            filename = scanner.nextLine().trim();
        }
        PrintWriter writer = new PrintWriter(new FileWriter(filename, append)); // if append is true adds new lines at the end
        System.out.println("New questions for the file: " + filename);
        System.out.println("Type 'DONE' when finished");

        String question = "";
        while (!question.equalsIgnoreCase("DONE")) {
            System.out.print("Question: ");
            question = scanner.nextLine().trim();

            if (question.equalsIgnoreCase("DONE")) {
                break;
            }
            System.out.print("Correct answer: ");
            String answer = scanner.nextLine().trim();

            writer.println();
            writer.println(question + ":" + answer); // Seperates the question and the asnwer
            System.out.println("Question/answer saved");
        }
        writer.close();
        if (append == true) {
            System.out.println("The quiz set is updated");
        }
        else {
            System.out.println("A new quiz set is saved: " + filename);
        }
    }

    // Prepares the quiz for the player(s)
    public static gameADT[] get_ready() throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a file name to play");
        System.out.println("(H)istory");
        System.out.println("(S)cience");
        System.out.println("(G)eography");
        System.out.println("You can also play a custom file you named previously (if custom, don't forget .txt)");
        String filename = scanner.nextLine().trim();
        if (filename.equalsIgnoreCase("H")) {
            filename = "history.txt";
        }
        else if (filename.equalsIgnoreCase("S")) {
            filename = "science.txt";
        }
        else if (filename.equalsIgnoreCase("G")) {
            filename = "geography.txt";
        }
        int num_questions = file_lines(filename);
        gameADT[] q_array = new gameADT[num_questions];

        if (num_questions == 0) {
            System.out.println("The file is empty");
        return q_array;
        }
        Scanner file = new Scanner(new File(filename));
        int index = 0;
        System.out.println("Loaded " + num_questions + " questions");

        while (index < num_questions) {
            String line = file.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            // Puts the data into the gameADT array
            String[] q_a = line.split(":", 2);
            String question = q_a[0];
            String answer = q_a[1];

            q_array[index] = quiz_data(question, answer);
            index++;
        }
        file.close();
    return q_array;
    }

    // Runs the quiz of choice
    public static void run_quiz (gameADT[] r) throws IOException {
        r = get_ready(); // Prepares the quiz
        final int num_players = 2; // Number of players
        final int start_pot = 500;  // Starting pot of each player
        int[] pots = new int[num_players];
        
        for (int i = 0; i < num_players; i++) {
            pots[i] = start_pot;
        }

        rules();
        System.out.println("Starting the quiz...");
        for (int i = 0; i < r.length; i++) { // Displays all the questions
            int index = rand_index(r.length);
            
            while (isUsed(r[index]) == true) {
                index = rand_index(r.length);
            }
            for (int x = 0; x < num_players; x++) { // Each question repeats for each player
                
                System.out.println("\n Q" + (i + 1) + ": " + get_q(r[index]));
                System.out.println("Player " + (x + 1) + "'s turn:");

                String ans = "";
                boolean mark = false;
                while (mark == false && !ans.equalsIgnoreCase("PASS")) { // Repeats the question until the player passes or gets it right
                    ans = get_ans();
                    mark = mark_q(r[index], ans);
                    if (!ans.equalsIgnoreCase("PASS")) {
                        pots[x] = winnings(mark, pots[x]);
                    }

                    if (mark == false && !ans.equalsIgnoreCase("PASS")) {
                        System.out.println("Incorrect answer, try again (or pass).");
                    }
                }
                System.out.println("The correct answer was: " + get_a(r[index]));
                System.out.println();
                System.out.println("Player " + (x + 1) + " current pot is: £" + pots[x]);
                System.out.println();
            }

            set_used(r[index]); // Marks the used question so it won't be used twice
        }
        System.out.println("-----Final Winnings-----");
        for (int x = 0; x < num_players; x++) {
            System.out.println("Player " + (x + 1) + ": £" + pots[x]);
        }
    }
}
