package Todo_Manager;
import java.util.Scanner;

public class Todo_Manager {

	public static void main(String[] args) {

		System.out.println("Welcome to your Todo Manager!\n");
		System.out.println("Please Enter your Name: ");
		Scanner in = new Scanner(System.in);
		String name = in.next();
		System.out.println("Hello "+name);
		
		String choice = null;
		String[] task = new String[10];
		Scanner input = new Scanner(System.in);
		
		do {
			//Display the Menu
			System.out.println("Please choose an option\n");
			System.out.println("1. Enter a task ");
			System.out.println("2. Remove a task ");
			System.out.println("3. Update a task ");
			System.out.println("4. List all tasks ");
			System.out.println("5. Exit");
			choice = input.nextLine();
			
			switch(choice) {
			case "1":        
				System.out.println("Enter number of tasks: ");
				task = input.nextInt();
				System.out.println("Enter a task ");
				choice = input.nextLine();
				break;
			case "2":
				System.out.println("Remove a task ");
				choice = input.nextLine();
				break;
			case "3":
				System.out.println("Remove a task ");
				choice = input.nextLine();
				break;
			case "4":
				System.out.println("Remove a task ");
				choice = input.nextLine();
				break;
			case "5":
				System.out.println("Remove a task ");
				choice = input.nextLine();
				break;
			}
		} while ( Integer.parseInt(choice)>0);		
	}
}
