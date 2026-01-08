import java.util.Scanner; 

class counter // change the name
{
    public static void main (String [] a)
    {
        method_call(); 
        return;
    } // END main
    
    public static int get_sample(int sample_num)
    {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Water sample " + sample_num + ": Give the water quality measurement in CFU/100ml");
    
    return scanner.nextInt();
    }
    
    public static void pollution_count ()
    {
        final int sample_num = 5;
    
        int total = 0;
        int worst_cfu = 0;
        int average;
        int current_sample;
        String state;
        
        for (int i = 1; i <= sample_num; i++)
        {
            current_sample = get_sample(i);
            total = total + current_sample;
    
            if (current_sample > worst_cfu)
            {
                worst_cfu = current_sample;
            }
        }
    
        average = calc_avg(total, sample_num);
        state = calc_state(worst_cfu);
        print_result(worst_cfu, average, state);
    return;
    }
    
    public static int calc_avg (int total, int sample_num)
    {
        int avg_cfu;
    
        avg_cfu = total / sample_num;
    
    return avg_cfu;
    }
    
    public static String calc_state (int worst_cfu)
    {
        String quality;
    
        if (worst_cfu <= 150)
        {
            quality = "GOOD";
        }
        else if (worst_cfu <= 350)
        {
            quality = "SUFFICIENT";
        }
        else
        {
            quality = "POOR";
        }
        
    return quality;
    }
    
    public static void print_result (int worst_cfu, int average, String state)
    {
        System.out.println("Average water quality today: " + average + " CFU/100ml.");
        System.out.println("Worst water quality today " + worst_cfu + " CFU/100ml.");
        System.out.println("The water quality is " + state + " today.");
    
    return;
    }
    
    public static void method_call ()
    {
        pollution_count();
    return;
    } // END main

} // END class
