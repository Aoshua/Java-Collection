// Associated file: StopWatch.java

import	java.util.Scanner;

public class StopWatchUI
{
    public static void main(String[] args)
    {
        StopWatch	sw = new StopWatch();
        Scanner		input = new Scanner(System.in);
        char		op;

        do
        {
            System.out.println("S\tStart/Stop");
            System.out.println("R\tReset");
            System.out.println("E\tExit");

            op = input.nextLine().toCharArray()[0];

            switch (op)
            {
                case 'S' :
                case 's' :
                    sw.time();
                    System.out.println("-------------\n" +
                            sw.getElapsed() +
                            "\n-------------");
                    break;

                case 'R' :
                case 'r' :
                    sw.reset();
                    break;

                case 'E' :
                case 'e' :
                    break;

                default:
                    System.err.println("Unrecognized operation");
                    break;
            }
        } while (op != 'E' && op != 'e');
    }
}