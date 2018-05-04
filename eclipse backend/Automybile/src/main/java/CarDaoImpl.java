import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CarDaoImpl implements CarDao {

	@Override
	public void getAllCars() {
		 
		
		try {
	            String url = "jdbc:mysql://localhost:3306/automybile";
	            Connection conn = DriverManager.getConnection(url,"root","djinni");
	            Statement stmt = conn.createStatement();
	            ResultSet rs;
	 
	            rs = stmt.executeQuery("SELECT CarID, Make, Model, Plate FROM cars");
	            while ( rs.next() ) {
	                String userData = "Car ID: " + rs.getString("CarID") + ", Make: " + rs.getString("Make") + ", Model: " + rs.getString("Model") + ", Plate: " + rs.getString("Plate"); 
	                System.out.println(userData);
	            }
	            conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	        }
	        
	}

}
