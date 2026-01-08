class game
{
    public static void main (String [] args)
    {
        controller();
    return;
    }


    public static int num_rounds ()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many rounds?");

    return scanner.nextInt();
    }

    public static String user_guess ()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Guess (a)pple, (b)anana, (c)herry or (d)ate? [Enter a/b/c/d]");
    return scanner.nextLine();
    }
        

    public static String random_fruit ()
    {
        String fruit_random = "";
        Random fruit = new Random();

        int random_num = fruit.nextInt(4);

        if (random_num == 0)
        {
            fruit_random = "apple";
        }
        else if (random_num == 1)
        {
            fruit_random = "banana";
        }
        else if (random_num == 2)
        {
            fruit_random = "cherry";
        }
        else if (random_num == 3)
        {
            fruit_random = "date";
        }
    return fruit_random;
    }

    public static String initial_fruit (String r_fruit)
    {
        String initial = "";
        
        if (r_fruit.equalsIgnoreCase("apple"))
        {
            initial = "a";
        }
        else if (r_fruit.equalsIgnoreCase("banana"))
        {
            initial = "b";
        }     
        else if (r_fruit.equalsIgnoreCase("cherry"))
        {
            initial = "c";
        }        
        else if (r_fruit.equalsIgnoreCase("date"))
        {
            initial = "d";
        }
    return initial;
    }

    public static void controller ()
    {
        int rounds;
        String guess;
        String fruit;
        String f_initial;
        int correct_round = 0;

        rounds = num_rounds();

        for (int i = 1; i <= rounds; i++)
            {
                guess = user_guess();
                fruit = random_fruit();
                f_initial = initial_fruit(fruit);
                    
                if (guess.equalsIgnoreCase(f_initial))
                {
                    System.out.println("Yes! It was " + fruit);
                    correct_round += 1;
                }
                else
                {
                    System.out.println("No! It was " + fruit);
                }
                double percentage = ((double)correct_round / i);
                System.out.println("You were correct " + correct_round + "/" + i + " times = " + percentage + "\n");
                
            }
    return;
    }
}
