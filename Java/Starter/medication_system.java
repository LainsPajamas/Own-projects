import java.util.Scanner;

class sicknessADT {
    int[] medication;
    String[] sickness;
    int[] quality;
    int count;
}

class allergy {
    public static void main (String[] agrs) {
        controller();
    }

    public static sicknessADT sickness_info () {
        sicknessADT s = new sicknessADT();
        
        s.medication = new int[100];
        s.sickness = new String[100];
        s.quality = new int[100];
        s.count = 0;
    return s;
    }

    public static String get_input(String question) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(question);
    return scanner.nextLine();
    }
        
    public static void controller() {
        sicknessADT s = sickness_info();
        final int MAX_MED = 60;

        int i = 0;
        while (true) {
            s.medication[i] = Integer.parseInt(get_input("How many medications have you taken today? (0-10)"));
            s.sickness[i] = get_input("What was the main cause of the attack? (cats / dust / nuts)");
            s.quality[i] = Integer.parseInt(get_input("Could you give a quality rating for today? 1(awful) 5(good)"));

            s.count += s.medication[i];
            i++;
            if (s.count >= MAX_MED) {
                for (int x = 0; x < i; x++) {
                    System.out.println(s.medication[x] + "   " + s.sickness[x] + "   " + s.quality[x]);
                }
                break;
            }
        }
    }
}
        
