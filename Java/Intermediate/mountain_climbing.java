class climbingADT {
    String [] mountain;
    int [] height;
    int [] hours;
    int [] minutes;

    int size;
}

class climbing {
    public static void main (String [] args) {
        climb_manager();
    }

    public static climbingADT new_climb () {
        climbingADT c = new climbingADT();
        final int max_climb = 6000;

        c.mountain = new String[max_climb];
        c.height = new int[max_climb];
        c.hours = new int[max_climb];
        c.minutes = new int[max_climb];

        c.size = 0;
    return c;
    }


    public static String choose_operation () {
        Scanner scanner = new Scanner(System.in);
        String choice = "";

        while (!choice.equals("E")) {
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("A")) {
                return choice;
            }
            else if (choice.equalsIgnoreCase("T")) {
                return choice;
            }
            else if (choice.equalsIgnoreCase("H")) {
                return choice;
            }
            else if (choice.equalsIgnoreCase("E")) {
                return choice;
            }
            else {
                System.out.println("Please choose one of the avaliable operations ((A)dd, (T)imes, (H)ighest, (E)xit)");
            }
        }
    return "E";
    }

    public static void add_operation(climbingADT c) {
        Scanner scanner = new Scanner(System.in);
        c.mountain[c.size] = "";
        c.height[c.size] = 0;
        c.hours[c.size] = 0;
        c.minutes[c.size] = 0;
        
        while (c.mountain[c.size].length() == 0) {
            System.out.println("Which mountain did you climb?");
            c.mountain[c.size] = scanner.nextLine();
            if (c.mountain[c.size].length() == 0) {
                System.out.println("The name of the mountain cannot be left empty");
            }
        }
        while (c.height[c.size] <= 0) {
            System.out.println("How high is it? (m>0):");
            c.height[c.size] = Integer.parseInt(scanner.nextLine());
            if (c.height[c.size] <= 0) {
                System.out.println("The height of the mountain cannot be lower or be equal to 0");
            }
        }
        while (c.hours[c.size] <= 0) {
            System.out.println("How many hours?");
            c.hours[c.size] = Integer.parseInt(scanner.nextLine());
            if (c.hours[c.size] <= 0) {
                System.out.println("The hours it took cannot be lower or be equal to 0");
            }
        }
        while (c.minutes[c.size] <= 0) {
            System.out.println("And how many minutes?");
            c.minutes[c.size] = Integer.parseInt(scanner.nextLine());
            if (c.minutes[c.size] <= 0) {
                System.out.println("The minutes it took cannot be lower or be equal to 0");
            }
        }
    c.size++;
    }

    public static void times_operation (climbingADT c) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (input.equals("")) {
            System.out.println("Which mountain to look up?");
            input = scanner.nextLine();
            if (!input.equals("")) {
                for (int i = 0; i < c.size; i++) {
                    if (c.mountain[i].equalsIgnoreCase(input)) {
                        System.out.println("Recorded climb #" + (i + 1) + ": " + c.hours[i] + " hours " + c.minutes[i] + " minutes");
                    }
                }
            break;
            }
            else {
                System.out.println("The name of the mountain cannot be left empty");
            }
        }
    }

    public static void highest_operation (climbingADT c) {
        int highest_height = 0;
        String highest_mountain = "";
        for (int i = 0; i < c.size; i++) {
            if (c.height[i] > highest_height) {
                highest_height = c.height[i];
                highest_mountain = c.mountain[i];
            }
        }
    System.out.println("Highest mountain climbed: " + highest_mountain + " (" + highest_height + ")");
    }

        

    public static void climb_manager () {
        climbingADT c = new_climb();

        String operation = "";
        while (!operation.equalsIgnoreCase("exit")) {
            System.out.println("Enter: (A)dd climb, Print (T)times, Print (H)ighest, (E)xit");
            operation = choose_operation();

            if (operation.equalsIgnoreCase("A")) {
                add_operation(c);
            }
            else if (operation.equalsIgnoreCase("T")) {
                times_operation(c);
            }
            else if (operation.equalsIgnoreCase("H")) {
                highest_operation(c);
            }
            else if (operation.equalsIgnoreCase("E")) {
                break;
            }
        }
    }
}
            
