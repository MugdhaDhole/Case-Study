package trainticketgeneration;

import java.sql.Date;
import java.util.TreeMap;

public class Ticket {
	private int countrer;
	private String pnr;
	private Date travelDate;

	private TreeMap<Passenger, Integer> passengers = new TreeMap<Passenger, Integer>();

	double fare;
	double totalPrice;
	Train train;

	public Ticket(Date travelDate, Train train) {
		super();
		this.travelDate = travelDate;
		this.train = train;
	}

	private String generatePRN() {
		return pnr;
	}

	private double calcPassengerFare(Passenger passenger) {
		return fare;
	}

	public void addPassenger(String name, int age, char c) {
		Passenger passenger = new Passenger(name, age, c);
		passenger.getName();
		passenger.getAge();
		passenger.getGender();

	}

	private double calculateTotalTicketPrice() {
		return totalPrice;

	}

	private void generateTicket() {

	}

	@Override
	public String toString() {
		return "Ticket countrer=" + countrer + "\n PNR=" + pnr + "\n Travel Date=" + travelDate + "\n Passenger Fare="
				+ fare + "\n Total Price=" + totalPrice;
	}

	public int getCountrer() {
		return countrer;
	}

	public void setCountrer(int countrer) {
		this.countrer = countrer;
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
