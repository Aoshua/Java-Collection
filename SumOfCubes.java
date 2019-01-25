public class SumOfCubes
{
    public static void main(String args[])
    {
        for (int number = 100; number < 1000; number++)
        {
            int n3 = number / 100;
            int n2 = (number / 10) % 10;
            int n1 = number % 10;

            if (cube(n3) + cube(n2) + cube(n1) == number)
                System.out.println(number);
        }
    }


    public static int cube(int n)
    {
        return n * n * n;
    }
}
