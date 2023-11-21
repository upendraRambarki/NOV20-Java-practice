package com.Upendra.Day2;

public class FinalOutput {

	public static void main(String[] args) {
		String name = "NTR";
		int yearBorn = 1980;
		int age = 2023-1980;
		
		String[] movieNames = { "RRR","simhadri","Dammu"};
		
		float[] rating = { 9.5F,6.7F,6.2F};
		System.out.println(movieNames.length);
		System.out.println("the name of the Hero is:" +" " + name);
		System.out.println("year born"+ " "+yearBorn + " "+age + " "+" old");
		String str = "";
		{
		for(int i=0 ;i<movieNames.length;i++)
			{
				str += movieNames[i]+ " ";
			}
		System.out.println(str);
		}
		for(int i=0 ;i<movieNames.length;i++)
		{
			System.out.println("movies name are:" +" "+ movieNames[i]+" "+" "+"getRatings "+rating[i]);
		}
//		System.out.println("the all movies of the hero name is " + " "+ name + " "+ "list was" +" " + movieNames);;
		System.out.println(rating.length);
		
		
		for(int i=0 ;i<rating.length;i++)
		{
			extracted(rating, i);
		}
		
	}

	private static void extracted(float[] rating, int i) {
		if(rating[i]<=5.0)
		{
			System.out.println("bad");
		}
		else if (rating[i] >5.0 && rating[i]<=6.5)
		{
			System.out.println("average");
		}
		else if (rating[i] >6.5 && rating[i]<=7.0)
		{
			System.out.println("good");
		}
		else if (rating[i] >7.0 && rating[i]<=8.0)
		{
			System.out.println("very good");
		}
		else
		{
			System.out.println("amazing");
		}
	}
	
//	static void getRating(float[] rating)
//	{
//		for(int i=0 ;i<rating.length;i++)
//		{
//			if(rating[i]<=5.0)
//			{
//				System.out.println("bad");
//			}
//			else if (rating[i] >5.0 && rating[i]<=6.5)
//			{
//				System.out.println("average");
//			}
//			else if (rating[i] >6.5 && rating[i]<=7.0)
//			{
//				System.out.println("good");
//			}
//			else if (rating[i] >7.0 && rating[i]<=8.0)
//			{
//				System.out.println("very good");
//			}
//			else
//			{
//				System.out.println("amazing");
//			}
//		}
//	}

}
