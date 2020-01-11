import java.util.*;
public class TaxesCalculator {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//value used to terminate program when user is finished
		boolean proceed = true;
		
		//number of students processed by program
		int processedStudents = 0;
		//number of eligible students
		int eligibleStudents = 0;
		
		//execute program if user wishes to proceed
		while (proceed)
		{
			//get studentID
			System.out.println("Enter Student ID:");
			String studentID = in.next();
			
			//get class level
			System.out.println("Enter student class (1 for Freshman, 2 for Sophmore, 3 for Junior):");
			int classLevel = GetIntegerInRange(1, 3);
			
			//get cumulative hours
			System.out.println("Enter total hours completed before this year:");
			int previousHours = GetIntegerInRange(0, 300);
			
			//value used to end loop when user if finished entering classes
			boolean stillEntering = true;
			//number of class hours student has in current year
			int cumulativeHours = 0;
			//number of quality points student has in current year
			double currentQualityPoints = 0;
			
			//get class information while user is still entering classes
			while (stillEntering)
			{
				System.out.println("Enter hours for class:");
				//amount of class hours for this iteration of loop
				int currentClassHours = GetIntegerInRange(0, 5);
				//add amount of class hours for this iteration of loop to global count of class hours for this student
				cumulativeHours += currentClassHours;
				
				System.out.println("Input class grade value (4 for A, 3 for B, 2 for C, 1 for D, and 0 for F):");
				currentQualityPoints += GetIntegerInRange(0, 4) * currentClassHours;
				
				System.out.println("Do you have more classes to enter for this student? (Y/N)");
				//check if user is still entering classes
				stillEntering = GetResponse();
				
				
			}
			//calculate cumulative GPA
			double cumulativeGPA = currentQualityPoints / cumulativeHours;
			
			//Print Results
			System.out.printf("**** Report for student %s ****\n", studentID);
			System.out.printf("%-25s%d\n", "Class:", classLevel);
			//Add class hours from previous years to cumulative hours
			cumulativeHours += previousHours;
			System.out.printf("%-25s%d\n", "Cumulative Hours:", cumulativeHours);
			System.out.printf("%-25s%.3f\n", "Current Year GPA:", cumulativeGPA);
			
			//increment number of processed students 
			processedStudents++;
			
			//check if student is eligible
			boolean isEligible = CalculateAndPrintEligibility(classLevel, cumulativeHours, cumulativeGPA);
			System.out.println();
			
			//if student is eligible add to list of eligible students calculated by the program
			if (isEligible)
			{
				eligibleStudents++;
			}
			
			System.out.println("Would you like to enter information for additional student(s)? (Y/N)");
			//if user wants to process more students restart program
			proceed = GetResponse();
		}
		//Print Summary Statistics
		System.out.println("********************************************");
		System.out.println("*            SUMMARY STATISTICS            *");
		System.out.println("********************************************");
		System.out.println();
		System.out.printf("%-35s%d\n", "NUMBER OF STUDENTS PROCESSED:", processedStudents);
		System.out.printf("%-35s%d\n", "NUMBER FOUND TO BE ELIGIBLE:", eligibleStudents);
	}

	/**
	 * Makes sure user enters a valid integer within a given range.
	 * Developed: 12/18/2019
	 * @author Savion Siner
	 * @param min minimum range value
	 * @param max maximum range value
	 * @return the valid integer within range
	 */
	public static int GetIntegerInRange(int min, int max) 
	{
		//create scanner variable
		Scanner in = new Scanner(System.in);
		//stores bad input to keep reader head in correct position
		String badInput = "";
		//Make sure user enters an integer
		while (!in.hasNextInt()) 
		{
			badInput = in.next();
			System.out.println("Invalid Entry");
			System.out.printf("Enter a valid integer between %d and %d:\n", min, max);
		}
		int integer = in.nextInt();
		
		//make sure integer is positive
		while (!(integer >= min && integer <= max)) 
		{
			badInput = "" + integer;
			System.out.println("Invalid Entry");
			System.out.printf("Enter a valid integer between %d and %d:\n", min, max);
			
			if (in.hasNextInt()) 
			{
				integer = in.nextInt();
			} else 
			{
				badInput = in.next();
			}
		}
		return integer;
	}
	
	/**
	 * Get a yes or no response from the user.
	 * Developed: 12/18/2019
	 * @author Savion Siner
	 * @return User's response ("Yes" or "No") in boolean form
	 */
	public static boolean GetResponse() 
	{
		boolean response = false;
		//create scanner variable
		Scanner in = new Scanner(System.in);
		String answer = in.next();
		//Make sure user enters an integer
		while (!(answer.toLowerCase().contentEquals("y")) && !(answer.toLowerCase().contentEquals("n")) ) 
		{
			System.out.println("Invalid Entry");
			System.out.println("Enter Y or N");
			answer = in.next();
		}
		answer = answer.toLowerCase();
		
		if (answer.contentEquals("n"))
		{
			response = false;
		} else
		{
			response = true;
		}
		return response;
	}
	
	/**
	 * Calculate and Print the Eligibility Status of a student given class level, cumulative hours, and cumulative GPA
	 * Developed: 12/18/2019
	 * @author Savion Siner
	 * @param classLevel class level of student (Freshmen (1), Sophomore (2), Junior (3))
	 * @param hours total number of class hours on student record
	 * @param gpa calculated GPA of student for current year
	 * @return student's eligibility status (true or false)
	 */
	public static boolean CalculateAndPrintEligibility (int classLevel, int hours, double gpa)
	{
		boolean isEligible = false;
		if (classLevel == 1)
		{
			if (hours >= 25 && gpa >= 1.7)
			{
				isEligible = true;
			}
		} else if (classLevel == 2)
		{
			if (hours >= 50 && gpa >= 1.85)
			{
				isEligible = true;
			}
		} else
		{
			if (hours >= 85 && gpa >= 1.95)
			{
				isEligible = true;
			}
		}
		
		if (isEligible)
		{
			System.out.println("*** ELIGIBLE ***");
		} else
		{
			System.out.println("*** INELIGIBLE ***");
		}
		return isEligible;
	}
}


