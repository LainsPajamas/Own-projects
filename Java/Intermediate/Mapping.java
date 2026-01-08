import java.util.Scanner

class mapADT {
    int size;
    String[] key;
    String[] map;
}


class mapping {
    
    public static void main (String[] args) {
        map_control();
    return;
    }


    // Declaration/Creation of the ADT
    public static mapADT newMap() {
        mapADT m = new mapADT();
        final int max_entry = 100;
        m.size = 0; // How many entries is there
        m.key = new String[max_entry]; // Array for keys
        m.map = new String[max_entry]; // Array for maps
        return m;
    }

    
    // Checks if the wanted key fits the criteria
    public static String mapkey_or() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter new map key or XXX to end:");
            String answer = scanner.nextLine();
            if (answer.length() == 0) { // No empty keys are allowed
                 System.out.println("The key cannot be empty");
            }
            else if (answer.contains(" ")) { // No keys containing spaces are allowed
                 System.out.println("The key cannot contain any space(s)");
            }
            else if (Character.isDigit(answer.charAt(0))) { // No keys starting with a number are allowed
                 System.out.println("The key cannot start with a number");
            }        
            else {
                return answer;
            }
        }
    }
    
    // Gets the map value for the entered key
    public static String get_map(String key) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter map value for key " +  key + ":");
    return scanner.nextLine();
    }

    // Checks to see if the user's key already exists
    public static int finding_index(mapADT m, String the_key) {
        for (int i = 0; i < m.size; i++) {
            if (m.key[i].equalsIgnoreCase(the_key)) {
                return i;
            }
        }
    return -1;
    }

    // Controller method for the program
    public static void map_control() {
        mapADT m = newMap();
        
        String action = mapkey_or();
        while (!action.equalsIgnoreCase("XXX")) { // Quit if wanted
            int index = finding_index(m, action);
            if (index >= 0) {
                System.out.println("The key value '" + action + "' already exists and has the map of '" + m.map[index] +"'");
            }
            else {
                m.key[m.size] = action;
                m.map[m.size] = get_map(action);
                m.size += 1;
            }
            action = mapkey_or();
        }
        System.out.println("Map contents:"); // Prints all the key/map values within the arrays
        for (int i = 0; i < m.size; i++) {
            System.out.println(m.key[i] + " --> " + m.map[i]);
        }
    return;
    }
}
