import java.util.*;

public class Array_Notes 
{

	public static void main(String[] args) 
	{
		int[] numbers = new int[10];
		
		//filling
		for (int i = 0; i < numbers.length; i++)
		{
			numbers[i] = (int) (Math.random() * (10 - 1 + 1)) + 1;
		}
		System.out.println(Arrays.toString(numbers));
		
		//Sum and Average
		double total = 0;
		for (double element: numbers)
		{
			total += element;
		}
		System.out.println("The average is: " + total / numbers.length);
		
		//Find the Maximum or Minimum
		int maximum = numbers[0];
		int minimum = numbers[0];
		for (int i = 1; i < numbers.length; i++)
		{
			if (numbers[i] > maximum)
			{
				maximum = numbers[i];
			}
			
			if (numbers[i] < minimum)
			{
				minimum = numbers[i];
			}
		}
		System.out.printf("The largest number is %d, and the smallest number is %d.\n", maximum, minimum);
		
		//Out put elements with separators
		for (int i = 0; i < numbers.length; i++)
		{
			if (i > 0)
			{
				System.out.print(" | ");
			}
			System.out.print(numbers[i]);
		}
		System.out.println();
		
		//Linear search
		int searchedValue = 7;
		int pos = 0;
		boolean found = false;
		while (pos < numbers.length && !found)
		{
			if (numbers[pos] == searchedValue)
			{
				found = true;
			}
			else
			{
				pos++;
			}
		}
		if (found)
		{
			System.out.println("Found at position: " + pos);
		}
		else 
		{
			System.out.println("Not Found");
		}
		
		//Swapping Elements
		int temp = numbers[9];
		numbers[9] = numbers[0];
		numbers[0] = temp;
		System.out.print(Arrays.toString(numbers));
		
		//Copying Arrays
		int[] newNumbers = Arrays.copyOf(numbers,  2 * numbers.length);
		System.out.println();
		System.out.println(Arrays.toString(newNumbers));
		
		//Reading Input
		System.out.println("Input 5 numbers:");
		Scanner in = new Scanner(System.in);
		double inputs[] = new double[5];
		for (int i = 0; i < inputs.length; i ++)
		{
			inputs[i] = in.nextDouble();
		}
		System.out.println(Arrays.toString(inputs));

	}

}
