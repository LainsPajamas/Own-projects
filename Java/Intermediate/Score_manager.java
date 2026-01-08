import java.util.Scanner;

class scoreADT {
    int size;
    String [] names;
    int [] scores;
}

class score_system {
    public static void main (String[] args) {
        score_manager();
    return;
    }

    public static scoreADT new_score() {
        scoreADT s = new scoreADT();
        final int max_entry = 50;
        s.size = 0;
        s.names = new String[max_entry];
        s.scores = new int[max_entry];
    return s;
    }

    public static int options () {
        Scanner scanner = new Scanner(System.in);
        int answer = 0;
        while (true) {
            System.out.println("Select an option [1-3]:");
            answer = scanner.nextInt();
            if (answer <= 3 && answer >= 1) {
                return answer;
            }
            else {
                System.out.println("'" + answer + "' is not a valid input");
                }
        }
    }

    public static String get_name() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
    return scanner.nextLine();
    }


    public static int get_score() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter score:");
    return scanner.nextInt();
    }
            

    public static scoreADT list_order (scoreADT current, String name, int score) {
        int i = 0;
        while (i < current.size && current.scores[i] >= score) {
            i++;
        }

        for (int x = current.size; x > i; x--) {
            current.names[x] = current.names[x - 1];
            current.scores[x] = current.scores[x - 1];
        }
        current.names[i] = name;
        current.scores[i] = score;
        current.size += 1;
    return current;
    }

    public static int number() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many scores to list? (n>0):");
    return scanner.nextInt();
    }

    public static void print_order(scoreADT list, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("#" + (i + 1) + "   " + list.names[i] + "   " + list.scores[i]);
        }
    return;
    }   
        
    public static void score_manager() {
        scoreADT s = new_score();
        int action = 0;
        String c_name = "";
        int c_score = 0;
        int n = 0;
        
        System.out.println("Options: (1) Enter a new score (2) Print top n scores (3) Exit");
        while (true) {
            action = options();
            if (action == 1) {
                c_name = get_name();
                c_score = get_score();
                list_order(s, c_name, c_score);
            }
            else if (action == 2) {
                n = number();
                print_order(s, n);
                
            }
            else if (action == 3) {
                break;
            }
        }
    return;
    }
}
                
