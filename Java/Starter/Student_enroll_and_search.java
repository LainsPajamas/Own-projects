// A student enroll and finding program

class Student {
    
    public static void main (String[] args) {
        student_manager();
    return;
    }

    // Prints the avaliable actions to the user
    // Takes an input from the user and returns it's first character
    public static char menu () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Menu: (A)dd, (P)rint year, (E)xit: ");
    
        String user_input = scanner.nextLine();
        char first_char;
        
        if (user_input.length() == 0) {
            return ' ';
        }
        first_char = user_input.charAt(0);
   
    return first_char;
    }
        
    // Asks and returns the new student's id
    public static String get_id() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Id (length 9): ");
    return scanner.nextLine();
    }


    // Asks and returns the new student's name
    public static String get_name() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name: ");
    return scanner.nextLine();
    }

    // Asks and returns the prefix of the year
    public static String prefix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Year prefix (length 2): ");
    return scanner.nextLine();
    }

    // Finds all the students with the given prefix and prints their names
    public static void student_print (String[] s_id, String[] s_names, String prefix, int count) {
        boolean found = false;
        
        for (int i = 0; i < count; i++) {
            if (s_id[i].startsWith(prefix)) {
                System.out.print(s_names[i] + " ");
                found = true;
            }
        }
        if (found == false) {
            System.out.println("No student found for the prefix '" + prefix + "'");
        }
    return;
    }
            
    // Controller method for all the actions
    public static void student_manager() {
        final int max_student = 3000; // Max number of students
        
        String[] ids = new String[max_student]; // Array for the student IDs
        String[] names = new String[max_student]; // Array for the student Names

        int student_count = 0; // Count to see how many students have been recorded

        char action = menu();
        // Controller depending on the user's action
        while (Character.toUpperCase(action) != 'E') {
            if (Character.toUpperCase(action) == 'A') {
                ids[student_count] = get_id();
                names[student_count] = get_name();
                student_count += 1;
            }
            else if (Character.toUpperCase(action) == 'P') {
                String year_prefix = prefix();
                student_print(ids, names, year_prefix, student_count);
            }
            else {
                System.out.println("Invalid input please choose one of the avaliable actions");
            }
            action = menu();
        }
    return;
    }
}
