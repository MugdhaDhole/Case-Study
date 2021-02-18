package trainticketgeneration;

import java.sql.Date;

public class Ticket {
	int countrer;
	String pnr;
	Date travelDate;

	double fare;
	double totalPrice;
	Train train;

	public Ticket(Date travelDate, Train train) {
		super();
		this.travelDate = travelDate;
		this.train = train;
	}

	public String generatePRN() {
		return pnr;
	}

	public double calcPassengerFare() {
		return fare;
	}

	public void addPassenger() {

	}

	public double calculateTotalTicketPrice() {
		return totalPrice;

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
