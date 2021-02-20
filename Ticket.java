package trainticketgeneration;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Ticket {
	private int counter = 100;
	private String pnr = "";
	private LocalDate travelDate;
	private StringBuilder sb;

	private TreeMap<Passenger, Integer> passengers = new TreeMap<Passenger, Integer>();

	double fare = 0.0;
	double totalPrice = 0.0;
	Train train;

	public Ticket(LocalDate travelDate, Train train) {
		super();
		this.travelDate = travelDate;
		this.train = train;
	}

	private String generatePRN() {
		String source = train.getSource();
		String destination = train.getDestination();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String date = travelDate.format(formatter);

		pnr = pnr + source.charAt(0) + destination.charAt(0) + "_" + date + "_" + counter;
		this.counter++;
		System.out.println("Ticket Booked with PNR : " + pnr);
		return pnr;
	}

	private double calcPassengerFare(Passenger passenger) {// Calculating passenger fare according to age and gender
		fare = train.getTicketPrice();
		if (passenger.getAge() <= 12) {
			return fare = (fare * 50) / 100;

		} else if (passenger.getAge() >= 60) {
			return fare = (fare * 60) / 100;

		} else if (passenger.getGender() == 'F' || passenger.getGender() == 'f') {
			return fare = (fare * 25) / 100;

		} else {
			return fare;
		}
	}

	public void addPassenger(String name, int age, char gender) {// Add passenger and fare into the TreeMap

		fare = calcPassengerFare(new Passenger(name, age, gender));
		passengers.put(new Passenger(name, age, gender), (int) fare);
	}

	private double calculateTotalTicketPrice() {// Calculate Total Price according to number of passengers

		for (int values : passengers.values()) {
			totalPrice = totalPrice + values;

		}
		return (double) totalPrice;
	}

	private TreeMap display() {
		Set<Map.Entry<Passenger, Integer>> entries = passengers.entrySet();
		TreeMap tmdata = new TreeMap();
		for (Map.Entry<Passenger, Integer> entry : entries) {
			// System.out.println(entry.getKey() + "=>" + entry.getValue());
			tmdata.put(entry.getKey(), entry.getValue() + "\n");
		}
		return tmdata;
	}

	private StringBuilder generateTicket() {
		sb = new StringBuilder();
		sb = sb.append("PNR \t\t: " + getPnr()).append("\nTrain No \t\t: " + train.getTrainNo())
				.append("\nTrain Name \t: " + train.getTrainName()).append("\nFrom \t\t: " + train.getSource())
				.append("\nTo \t\t: " + train.getDestination()).append("\nTravel Date \t: " + this.travelDate)
				.append("\n\nPassengers : \n").append(this.display())
				.append("\nTotal Price : " + this.calculateTotalTicketPrice());
		return sb;
	}

	public void writeTicket() throws IOException {// Writing the file content to the file

		String fileName = this.generatePRN();// File name as PNR number
		// System.out.println(fileName);
		StringBuilder fileContent = this.generateTicket();// File content
		System.out.println(fileContent);

		FileWriter fw = new FileWriter(fileName, true);
		fw.write(fileContent.toString());

		fw.flush();
		fw.close();

	}

	public int getCountrer() {
		return counter;
	}

	public void setCountrer(int counter) {
		this.counter = counter;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

}
