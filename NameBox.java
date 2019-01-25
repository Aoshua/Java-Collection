import javax.swing.*;
//import java.util.Scanner;


public class NameBox
{
    public static void main(String[] args)
    {
        // The commented out code is to use the console
        /*if(args.length == 0)
        {
            System.err.println("USAGE: java NameBox <name>");
            System.exit(1);
        }
        int count = 0;
        *//*for(int i = 0; i < args.length; i++)
            count += args[1].length();*//*

        for(String s : args)
            count += s.length();
        count += args.length - 1;*/

        // The following code uses a scanner
        /*Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = input.nextLine();*/

        String name = JOptionPane.showInputDialog(null,
                "Please enter your name", "Data Input",
                JOptionPane.QUESTION_MESSAGE);

        if(name == null)
        {
            System.err.println("Failed to enter a name.");
            System.exit(1);
        }

        int count = name.length();

        // Top:
        System.out.print("+");
        for(int i = 0; i < count; i ++)
            System.out.print("-");
        System.out.println("+");

        /*// Write the name (using console):
        System.out.print("|");
        for(int i = 0; i < args.length - 1; i++)
            System.out.print(args[i] + " ");
        System.out.println(args[args.length - 1] + "|");*/

        // Write the name (using scanner):
        System.out.println("|" + name + "|");

        // Bottom:
        System.out.print("+");
        for(int i = 0; i < count; i ++)
            System.out.print("-");
        System.out.println("+");
    }
}
