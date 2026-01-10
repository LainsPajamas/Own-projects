class string_stackADT {
    int size;
    String [] stack;
}

class string_stack {
    public static void main (String [] args) {
        string_manager();
    return;
    }

    public static string_stackADT new_string () {
        string_stackADT s = new string_stackADT();

        final int max_size = 50;
        s.size = 0;
        s.stack = new String[max_size];
    return s;
    }

    public static String choose_operation () {
        Scanner scanner = new Scanner(System.in);
        String choice = "";

        while (!choice.equalsIgnoreCase("exit")) {
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("push")) {
                return choice;
            }
            else if (choice.equalsIgnoreCase("pop")) {
                return choice;
            }
            else if (choice.equalsIgnoreCase("print")) {
                return choice;
            }
            else if (choice.equalsIgnoreCase("exit")) {
                break;
            }
            else {
                System.out.println("Please choose one of the avaliable operation (push, pop, print, exit)");
            }
        }
    return choice;
    }


    public static String push_value () {
        Scanner scanner = new Scanner(System.in);
        String value;
            
        System.out.println("Non-empty String value?");
        value = scanner.nextLine();
        while (value.equals("")) {
            if (value.equals("")) {
                System.out.println("This string value is emmpty");
                }
            value = scanner.nextLine();
        }
    return value;
    }
    
    public static void push_operation (string_stackADT current, String value) {
        if (current.size < 50) {
            for (int i = 0; i < current.size; i++) {
                current.stack[current.size - i] = current.stack[current.size - 1 - i];
            }
            current.stack[0] = value;
            current.size++;
        }
        else {
            System.out.println("The maximum amount of values can be stored is 50, unable to add string");
        }
    }

        
    public static String pop_operation (string_stackADT current) {
        String removed = "";
        
        if (current.size == 0) {
            System.out.println("Cannot pop empty stack.");
        }
        else {
            removed = current.stack[0];

            for (int i = 0; i < current.size; i++) {
                current.stack[i] = current.stack[i + 1];
            }
            current.size--;
        }
    return removed;
    }


    public static void print_operation (string_stackADT current) {
        for (int i = 0; i < current.size; i++) {
            System.out.print(current.stack[i] + " ");
        }
        System.out.println();
    }   
    

    public static void string_manager() {
        string_stackADT s = new_string();

        String operation = "";
        while (!operation.equalsIgnoreCase("exit")) {
            System.out.println("Push, Pop, Print, or Exit?");
            operation = choose_operation();

            if (operation.equalsIgnoreCase("push")) {
                String value = push_value();
                if (value.equalsIgnoreCase("exit")) {
                    break;
                }
                push_operation(s, value);
            }
                
            else if (operation.equalsIgnoreCase("pop")) {
                String removed = pop_operation(s);
                System.out.println(removed);
            }
                
            else if (operation.equalsIgnoreCase("print")) {
                print_operation(s);
            }
                
            else if (operation.equalsIgnoreCase("exit")) {
                break;
            }
        }
    }
}
        
