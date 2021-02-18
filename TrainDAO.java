package trainticketgeneration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TrainDAO {
	Train train;
	public Train findTrain() {
		try {
			/*
			 * // Step 1 Class.forName("com.mysql.cj.jdbc.Driver");
			 * System.out.println("Class found");
			 */

			// Step 2
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/traininfo?autoReconnect=true&useSSL=false", "root", "Whitebox@123");
			System.out.println("Connected");

			// Step 3
			Statement stmt = con.createStatement();			
			System.out.println("Record Inserted");

		} catch (Exception e) {
			System.out.println("Not found");
		}
		return train;
	}

}
