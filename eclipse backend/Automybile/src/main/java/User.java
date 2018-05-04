import java.sql.*;
public class User {
	
	//SQL Getters and Setters for users go here.
	
	
	public void deleteUser(int idDel) {
		
		String deletion = "DELETE FROM users WHERE "
			    + " UserID ="
			    + idDel
			    + "";
		
		try {
            String url = "jdbc:mysql://localhost:3306/automybile";
            Connection conn = DriverManager.getConnection(url,"root","djinni");
            PreparedStatement stmt = conn.prepareStatement(deletion);
 
            //stmt.executeUpdate("DELETE FROM users WHERE UserID = idDel");
            stmt.executeUpdate();
            System.out.println("User with ID " + idDel + " deleted!");
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
          
        }
	}
	
	
	public int getId() {
		
		//If fails, return -1, look into how to break gracefully when methods demands return of a variable
		
		try {
	            String url = "jdbc:mysql://localhost:3306/automybile";
	            Connection conn = DriverManager.getConnection(url,"root","djinni");
	            Statement stmt = conn.createStatement();
	            ResultSet rs;
	 
	            rs = stmt.executeQuery("SELECT UserID FROM users");
	            while ( rs.next() ) {
	                
	            	int OutUserId = rs.getInt("UserID");
	            	return OutUserId;
	            }
	            conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	            return -1;
	        }
		 return -1;
	}
	
	public String getName() {
		
		//If fails, return -1, look into how to break gracefully when methods demands return of a variable
		
		try {
	            String url = "jdbc:mysql://localhost:3306/automybile";
	            Connection conn = DriverManager.getConnection(url,"root","djinni");
	            Statement stmt = conn.createStatement();
	            ResultSet rs;
	 
	            rs = stmt.executeQuery("SELECT FirstName, LastName FROM users"); //And lastname where Id = same
	            while ( rs.next() ) {
	                
	            	String OutUserName = rs.getString("FirstName") + " " + rs.getString("LasttName");
	            	return OutUserName;
	            }
	            conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	            return "Error";
	        }
		 return "Error";
	}
	
	public String getPhone() {
		
		//If fails, return -1, look into how to break gracefully when methods demands return of a variable
		
		try {
	            String url = "jdbc:mysql://localhost:3306/automybile";
	            Connection conn = DriverManager.getConnection(url,"root","djinni");
	            Statement stmt = conn.createStatement();
	            ResultSet rs;
	 
	            rs = stmt.executeQuery("SELECT PhoneNum FROM users"); //And lastname where Id = same
	            while ( rs.next() ) {
	                
	            	String outPhoneNum = rs.getString("PhoneNum");
	            	return outPhoneNum;
	            }
	            conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	            return "Error";
	        }
		 return "Error";
	}
	
	
	public void setUser(int iId, String iFirstName, String iLastName, String iPhone) {
		
		String query = "INSERT INTO Users ("
			    + " UserID,"
			    + " FirstName,"
			    + " LastName,"
			    + " PhoneNum) VALUES ("
			    + "?, ?, ?, ?)";
		 
		try {
			
			String url = "jdbc:mysql://localhost:3306/automybile";
	        Connection conn = DriverManager.getConnection(url,"root","djinni");
	        
			    PreparedStatement st = conn.prepareStatement(query);
			    st.setInt(1, iId);
			    st.setString(2, iFirstName);
			    st.setString(3, iLastName);
			    st.setString(4, iPhone);
			    
			    // execute the preparedstatement insert
			    st.executeUpdate();
			    st.close(); 
			    
			    System.err.println("Added New user!  ID: " + iId + ", Name: " + iFirstName + " " + iLastName + ", Phone number: " + iPhone);
			    
			} catch (Exception e) {
        System.err.println("Got an exception! ");
        System.err.println(e.getMessage());
			  }
	 
	}
	
	public void updateUser(int iId, String iFirstName, String iLastName, String iPhone) {
		
		String updater = "UPDATE Users SET"
				+ " FirstName = ?,"
			    + " LastName = ?,"
			    + " PhoneNum = ?"
			    + " WHERE UserID = ?";
		 
		try {
			
			String url = "jdbc:mysql://localhost:3306/automybile";
	        Connection conn = DriverManager.getConnection(url,"root","djinni");
	        
			    PreparedStatement st = conn.prepareStatement(updater);
			    st.setString(1, iFirstName);
			    st.setString(2, iLastName);
			    st.setString(3, iPhone);
			    st.setInt(4, iId);
			    
			    // execute the preparedstatement insert
			    st.executeUpdate();
			    st.close(); 
			    
			    System.err.println("Updated user with ID: " + iId + " to: | Name: " + iFirstName + " " + iLastName + ", Phone number: " + iPhone);
			    
			} catch (Exception e) {
        System.err.println("Got an exception! ");
        System.err.println(e.getMessage());
			  }
	}
	
	
}
