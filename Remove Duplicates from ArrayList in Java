// Java program to remove duplicates from ArrayList 

import java.util.*; 

public class GFG { 

	// Function to remove duplicates from an ArrayList 
	public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) 
	{ 

		// Create a new ArrayList 
		ArrayList<T> newList = new ArrayList<T>(); 

		// Traverse through the first list 
		for (T element : list) { 

			// If this element is not present in newList 
			// then add it 
			if (!newList.contains(element)) { 

				newList.add(element); 
			} 
		} 

		// return the new list 
		return newList; 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 

		// Get the ArrayList with duplicate values 
		ArrayList<Integer> 
			list = new ArrayList<>( 
				Arrays 
					.asList(1, 10, 1, 2, 2, 3, 3, 10, 3, 4, 5, 5)); 

		// Print the Arraylist 
		System.out.println("ArrayList with duplicates: "
						+ list); 

		// Remove duplicates 
		ArrayList<Integer> 
			newList = removeDuplicates(list); 

		// Print the ArrayList with duplicates removed 
		System.out.println("ArrayList with duplicates removed: "
						+ newList); 
	} 
} 
