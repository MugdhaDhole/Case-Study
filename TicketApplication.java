package trainticketgeneration;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class TicketApplication {

	public static void main(String[] args) {
		String name;
		int age;
		char c;
		int trainNo;
		int noOfPassengers;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Train Number : ");
		trainNo = sc.nextInt();
		System.out.println("Enter Travel Date : ");
		// Get date here
		System.out.println("Enter Number of Passengers : ");
		noOfPassengers = sc.nextInt();

		for (int i = 0; i < noOfPassengers; i++) {
			System.out.println("Enter Passeger Name : ");
			name = sc.next();
			System.out.println("Enter Age: ");
			age = sc.nextInt();
			System.out.println("Enter Gender : ");
			c = sc.next().charAt(0);
		}

	}

}
