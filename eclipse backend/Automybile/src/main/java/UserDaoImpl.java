import java.sql.*;


public class UserDaoImpl implements UserDao {

		//Implement the methods for the operations here.
	//This is probably where the Read SQL queries, go, not the ones that change the DB.
	

	@Override
	public void getAllUsers() {
		 
		
		try {
	            String url = "jdbc:mysql://localhost:3306/automybile";
	            Connection conn = DriverManager.getConnection(url,"root","djinni");
	            Statement stmt = conn.createStatement();
	            ResultSet rs;
	 
	            rs = stmt.executeQuery("SELECT UserID, FirstName, LastName, PhoneNum FROM users");
	            while ( rs.next() ) {
	                String userData = "User ID: " + rs.getString("UserID") + ", Name: " + rs.getString("FirstName") + " " + rs.getString("LastName") + ", Phone #: " + rs.getString("PhoneNum"); 
	                System.out.println(userData);
	            }
	            conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	        }
	        
	}
	
}
