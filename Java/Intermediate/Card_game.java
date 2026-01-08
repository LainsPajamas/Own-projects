import java.util.Random;
import java.util.Scanner;

class gameADT {
    int[] cards;
    int scored;
    int size;
}

class game {
    public static void main (String[] args) {
        game_controller();
    }


    public static gameADT game_data () {
        gameADT g = new gameADT();
        
        g.size = 40;
        g.cards = new int[g.size];
        g.scored = 0;

        int index = 0;
        for (int value = 1; value <= 10; value++) {
            for (int count = 1; count <= 4; count++) {
                g.cards[index] = value;
                index++;
            }
        }       
    return g;
    }


    public static int target_score() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Target score?");
    return scanner.nextInt();
    }

    public static String high_or_low(int n) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Round " + n + ": Hihger or Lower? (h/l)");
    return scanner.nextLine();
    }

    // Return a random int between 0 (inclusive) and bound (exclusive) */
    public static int rand_index(gameADT game) {
        Random r = new Random();
    return r.nextInt(game.size);
    }

    public static void remove_card(gameADT game, int index) {
        for (int i = index; i < game.size - 1; i++) {
            game.cards[i] = game.cards[i + 1];
        }
        game.size--;
    }

    public static Boolean test (String user_answer, int last, int current) {
        if (current > last && user_answer.equalsIgnoreCase("H")) {
            return true;
        }
        else if (current < last && user_answer.equalsIgnoreCase("L")) {
            return true;
        }
        else {
            return false;
        }
    }
        
    public static void game_controller() {
        gameADT g = game_data();
        
        int round = 1;
        int last_draw;
        String action;
        Boolean is_right;
        
        int target = target_score();
        int index = rand_index(g);
        int draw = g.cards[index];
        while (true) {
            System.out.println("I drew a " + draw);
            action = high_or_low(round);
            remove_card(g, index);

            last_draw = draw;
            index = rand_index(g);
            draw = g.cards[index];

            is_right = test(action, last_draw, draw);
            if (is_right == true) {
                g.scored += 1;
            }
            else {
                System.out.println("I drew a " + draw);
                System.out.println("Nice try, you scored " + g.scored + ".");
                break;
            }

            if (g.scored >= target) {
                System.out.println("You Win!");
                break;
            }  
            round += 1;

        }
    return;    
    }
}
