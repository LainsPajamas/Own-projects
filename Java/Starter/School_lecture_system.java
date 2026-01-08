class school
{
    public static void main (String [] args)
    {
        controller();
    return;
    }

    public static String lecture_type(int x)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Student " + x + ": what subject are you studying?");
    return scanner.nextLine();
    }


    public static String lecture_time(String lecture_t)
    {
        String time = "";

        if (lecture_t.equalsIgnoreCase("Robotics"))
        {
            time = "Your next lecture is at 1pm";
        }            
        else if (lecture_t.equalsIgnoreCase("Computer Science"))
        {
            time = "Your next lecture is at 2pm";
        }        
        else if (lecture_t.equalsIgnoreCase("Electronic Engineering"))
        {
            time = "Your next lecture is at 3pm";
        }        
    return time;
    }

    public static double calc_percentage (double count, int student_num)
    {
        double raw_percentage = (count / student_num)  * 100;
        double percentage = Math.round(raw_percentage * 10) / 10;
        
    return percentage;
    }

        
        

    public static void controller()
    {
        final int student_count = 700;
        String lecture;
        String lecture_hour;
        double robotic_count = 0.0;
        double cs_count = 0.0;
        double ee_count = 0.0;
        double percentage = 0.0;

        for (int i = 1; i <= student_count; i++)
            {
                lecture = lecture_type(i);
                lecture_hour = lecture_time(lecture);

                System.out.println(lecture_hour);

                if (lecture.equalsIgnoreCase("Robotics"))
                {
                    robotic_count += 1;
                }
                else if (lecture.equalsIgnoreCase("Computer Science"))
                {
                    cs_count += 1;
                }
                else if (lecture.equalsIgnoreCase("Electronic Engineering"))
                {
                    ee_count += 1;
                }
            

                if ((i + 1) <= student_count)
                {
                    System.out.println("Next student:");
                }

            }
        percentage = calc_percentage(cs_count, student_count);
        System.out.println("\n" + percentage + "% of student are studying Computer Scienece.");

        percentage = calc_percentage(ee_count, student_count);
        System.out.println("\n" + percentage + "% of student are studying Electronic Engineering.");

        percentage = calc_percentage(robotic_count, student_count);
        System.out.println("\n" + percentage + "% of student are studying Robotics.");
        
    }
    
}
