import java.util.Scanner; 


class cycleADT {
    String country;
    int relay;
    int size;
    int[] disability;
}
    
class cycle
{
    public static cycleADT cycle_data () {
        cycleADT c = new cycleADT();
        final int MAX_CYCLIST = 3; // Maximum number of cyclists allowed
        
        c.country = ""; // Country name
        c.relay = 0; // Relay point
        c.disability = new int [MAX_CYCLIST]; // 3 People array

    return c;
    }

    
    public static void main (String [] a)
    {
        cycleADT c = cycle_data();
        
        c.relay = Integer.parseInt(input("What is the point limit for the relay?")); // input for relay point
        while (c.relay < 3) {
            System.out.println("That is not a valid input. enter a value >= 3");
            c.relay = Integer.parseInt(input("What is the point limit for the relay?")); // input for relay point
        }
        c.country = input("What is the name of the country?"); // input for Country name

        int total_relay = 0;
        for (int i = 0; i < c.disability.length; i++) { // Gets 3 inputs for disability reating
            c.disability[i] = Integer.parseInt(input("What is the disability rating of cyclist " + (i + 1) + "? D"));
            while (c.disability[i] < 1 && c.disability[i] > 5) {
                System.out.println("That is not a valid input. Enter a value >=1 & <=5");
                c.disability[i] = Integer.parseInt(input("What is the disability rating of cyclist " + (i + 1) + "? D"));
            }
            total_relay += c.disability[i];
        }

        if (total_relay > c.relay) { // Tests to see if relay point is greater than allowed
            System.out.println(c.country + " has D" + c.disability[0] + ", D" + c.disability[1] + " and D" + c.disability[2] + " cyclists. That is NOT legal for a " + c.relay + " point race.");   
        }
        else {
            System.out.println(c.country + " has D" + c.disability[0] + ", D" + c.disability[1] + " and D" + c.disability[2] + " cyclists. That is legal for a " + c.relay + " point race.");   
        }
        return;
    } // END main



    public static String input(String question) { // Input method
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
    return scanner.nextLine();
    }
} // END class name
