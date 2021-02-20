package trainticketgeneration;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TicketApplication {

	public static void main(String[] args) throws IOException {
		int trainNo;
		String travelDate;
		int noOfPassengers;
		String name;
		int age;
		char gender;

		Scanner sc = new Scanner(System.in);

		TrainDAO dao = new TrainDAO();
		dao.trainDetails();// Display all train details

		System.out.println("Enter Train Number : ");
		trainNo = sc.nextInt();

		Train train = dao.findTrain(trainNo);// Fetch a train number
		System.out.println("Trian Details : \n" + train);

		System.out.println("\nEnter Travel Date : ");
		travelDate = sc.next();

		DateTimeFormatter df = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate date = LocalDate.parse(travelDate, df);
		// System.out.println(date);

		Ticket ticket = new Ticket(date, train);

		System.out.println("Enter Number of Passengers : ");
		noOfPassengers = sc.nextInt();

		for (int i = 0; i < noOfPassengers; i++) {// loop to get the multiple passengers
			System.out.println("Enter Passeger Name : ");
			name = sc.next();
			System.out.println("Enter Age: ");
			age = sc.nextInt();
			System.out.println("Enter Gender : ");
			gender = sc.next().charAt(0);
			ticket.addPassenger(name, age, gender);
		}

		ticket.writeTicket();// Write the Ticket into the file
		sc.close();
	}

}
