import	java.util.*;

public class ParseDemo
{
	public static void main(String[] args)
	{
		String		test1 = "See the quick red fox jump over the lazy brown dog";
		StringTokenizer	parser1 = new StringTokenizer(test1);

		while (parser1.hasMoreTokens())
			System.out.println(parser1.nextToken());

		System.out.println("--------");

		String		test2 = "See:the;quick.red,fox.jump:over;the!lazy:brown#dog";
		StringTokenizer	parser2 = new StringTokenizer(test2, ":;.,#!");

		while (parser2.hasMoreTokens())
			System.out.println(parser2.nextToken());

		System.out.println("--------");

		StringTokenizer	parser3 = new StringTokenizer(test2, ":;.,#!", true);

		while (parser3.hasMoreTokens())
			System.out.println(parser3.nextToken());
	}
}

