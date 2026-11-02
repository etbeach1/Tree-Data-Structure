/*
Name: Ethan Beach
Assignment: Human Resources Part 3 (SortedTreeSet)
Purpose: To read a .txt file of names, heights, and weights, and store the Person objects in a self-sorting binary tree set (SortedTreeSet). The tree stays alphabetized by name and never holds duplicate names. The tree is written to an output file and displayed on the screen.
Sources: https://www.geeksforgeeks.org/dsa/introduction-to-tree-data-structure/
https://www.geeksforgeeks.org/java/java-program-to-remove-duplicate-entries-from-an-array-using-treeset/

*/

//Imported Java classes for file handling and user input
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main
{
	private static final String HEADER = "Name\tHeight (cm)\tWeight (kg)";

	public static void main(String[] args)
	{
		System.out.println();

		//Reads the .txt file, defaults to hr.txt if no other is found
		String fileName = "hr.txt";
		if (args.length > 0)
		{
			fileName = args[0];
		}

		//Creates a try/catch block to handle potential file errors
		try
		{
			//Initializes the Scanner to read the file
			Scanner fileReader = new Scanner(new File(fileName));

			//Skips the header line of the input file
			fileReader.nextLine();

			//The tree sorts itself and ignores duplicate names as items are added
			SortedTreeSet tree = new SortedTreeSet();

			//hasNext() is true while there is more data to read
			while (fileReader.hasNext())
			{
				//Each row is: name, height, weight
				String name = fileReader.next();
				double height = fileReader.nextDouble();
				double weight = fileReader.nextDouble();

				tree.add(new Person(name, height, weight));
			}

			//Closes the file reader
			fileReader.close();

			//Writes the tree (header + data) to an output file
			writeToFile("hr_tree_output.txt", tree);

			//Displays the tree on the screen
			System.out.println("Sorted tree set (alphabetical, no duplicate names):");
			System.out.print(HEADER + "\n" + tree);
		}
		catch (FileNotFoundException e)
		{
			//Throws an error if a file can't be found/created
			System.out.println("Could not find or create a file: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
	}

	//Writes the header and the tree's in-order data to the named file
	private static void writeToFile(String outputName, SortedTreeSet tree) throws FileNotFoundException
	{
		PrintWriter writer = new PrintWriter(outputName);
		writer.print(HEADER + "\n" + tree);
		writer.close();
	}
}
