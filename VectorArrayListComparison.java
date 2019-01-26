// The purpose of this program is to illustrate the time difference between vectors and array lists.

import	java.util.*;    // Asterisk means import on demand

public class VectorArrayListComparison
{
    public static void main(String[] args)
    {
        ArrayList<Integer>	list1 = new ArrayList<Integer>(1000000);    // Not thread-safe
        Vector<Integer>		list2 = new Vector<Integer>(1000000);       // "Synchronized thread-safe

        long	start = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++)
            list1.add(i);			// auto boxing:
        //list1.add(new Integer(i));

        long	middle = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++)
            list2.add(i);			// auto boxing:
        //list2.add(new Integer(i));

        long	end = System.currentTimeMillis();

        System.out.println("ArrayList time: " + (middle - start));
        System.out.println("Vector time:    " + (end - middle));
    }
}
