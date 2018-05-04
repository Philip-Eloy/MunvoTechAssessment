import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReservationDaoImpl implements ReservationDao {

	@Override
	public void getAllReservations() {
		try {
            String url = "jdbc:mysql://localhost:3306/automybile";
            Connection conn = DriverManager.getConnection(url,"root","djinni");
            Statement stmt = conn.createStatement();
            ResultSet rs;
            ResultSet userSet;	
            
            //Need a view or query that matches reservations to their user ID and car ID.
            rs = stmt.executeQuery("SELECT ReservationID, UserID, CarID, DateReserved, TimeReserved, DateReturn FROM reservations");
            while ( rs.next() ) {
                String userData = "Reservation ID: " + rs.getString("ReservationID") + ", User ID: " + rs.getString("UserID") + ", Car ID: " + rs.getString("CarID") + ", Date Reserved: " + rs.getString("DateReserved") + ", Time Reserved: " + rs.getString("TimeReserved") + ", Date to Return: " + rs.getString("DateReturn"); 
                System.out.println(userData);

            }

            System.out.println("-");
            
            userSet = stmt.executeQuery("SELECT users.FirstName, users.LastName, reservations.DateReserved, reservations.DateReturn FROM users INNER JOIN reservations ON users.UserID = reservations.UserID");
            while (userSet.next() ) {
                String userSetString = "User " + userSet.getString("FirstName") + " " + userSet.getString("LastName") + " Reserved a Car from: " + userSet.getString("DateReserved") + " to " + userSet.getString("DateReturn"); 
                System.out.println(userSetString);
                
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
		
	}

}
