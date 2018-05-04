import java.sql.*;

public class Reservation {
	
	public void deleteReservation(int idDel) {
		
		String deletion = "DELETE FROM reservations WHERE "
			    + " ReservationID ="
			    + idDel
			    + "";
		
		try {
            String url = "jdbc:mysql://localhost:3306/automybile";
            Connection conn = DriverManager.getConnection(url,"root","djinni");
            PreparedStatement stmt = conn.prepareStatement(deletion);
 
            stmt.executeUpdate();
            System.out.println("Reservation with ID " + idDel + " deleted!");
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
	 
	            rs = stmt.executeQuery("SELECT ReservationID FROM reservations");
	            while ( rs.next() ) {
	                
	            	int OutResId = rs.getInt("ReservationID");
	            	return OutResId;
	            }
	            conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	            return -1;
	        }
		 return -1;
	}
	
	public String getUserID() {
		
		//If fails, return -1, look into how to break gracefully when methods demands return of a variable
		
		try {
	            String url = "jdbc:mysql://localhost:3306/automybile";
	            Connection conn = DriverManager.getConnection(url,"root","djinni");
	            Statement stmt = conn.createStatement();
	            ResultSet rs;
	 
	            rs = stmt.executeQuery("SELECT UserID FROM reservations"); //And lastname where Id = same
	            while ( rs.next() ) {
	                
	            	String OutUID = rs.getString("UserID");
	            	return OutUID;
	            }
	            conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	            return "Error";
	        }
		 return "Error";
	}
	
	public String getCarID() {
		
		//If fails, return -1, look into how to break gracefully when methods demands return of a variable
		
		try {
	            String url = "jdbc:mysql://localhost:3306/automybile";
	            Connection conn = DriverManager.getConnection(url,"root","djinni");
	            Statement stmt = conn.createStatement();
	            ResultSet rs;
	 
	            rs = stmt.executeQuery("SELECT CarID FROM resevations"); //And lastname where Id = same
	            while ( rs.next() ) {
	                
	            	String outCarId = rs.getString("CarID");
	            	return outCarId;
	            }
	            conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	            return "Error";
	        }
		 return "Error";
	}
	
	public String getDateReserved() {
		
		//If fails, return -1, look into how to break gracefully when methods demands return of a variable
		
		try {
	            String url = "jdbc:mysql://localhost:3306/automybile";
	            Connection conn = DriverManager.getConnection(url,"root","djinni");
	            Statement stmt = conn.createStatement();
	            ResultSet rs;
	 
	            rs = stmt.executeQuery("SELECT DateReserved FROM reservations"); //And lastname where Id = same
	            while ( rs.next() ) {
	                
	            	String outDateReserved = rs.getString("DateReserved");
	            	return outDateReserved;
	            }
	            conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	            return "Error";
	        }
		 return "Error";
	}
	
	public String getTimeReserved() {
		
		//If fails, return -1, look into how to break gracefully when methods demands return of a variable
		
		try {
	            String url = "jdbc:mysql://localhost:3306/automybile";
	            Connection conn = DriverManager.getConnection(url,"root","djinni");
	            Statement stmt = conn.createStatement();
	            ResultSet rs;
	 
	            rs = stmt.executeQuery("SELECT TimeReserved FROM reservations"); //And lastname where Id = same
	            while ( rs.next() ) {
	                
	            	String outTimeReserved = rs.getString("TimeReserved");
	            	return outTimeReserved;
	            }
	            conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	            return "Error";
	        }
		 return "Error";
	}
	
	public String getDateReturn() {
		
		//If fails, return -1, look into how to break gracefully when methods demands return of a variable
		
		try {
	            String url = "jdbc:mysql://localhost:3306/automybile";
	            Connection conn = DriverManager.getConnection(url,"root","djinni");
	            Statement stmt = conn.createStatement();
	            ResultSet rs;
	 
	            rs = stmt.executeQuery("SELECT DateReturn FROM reservations"); //And lastname where Id = same
	            while ( rs.next() ) {
	                
	            	String outDateReturn = rs.getString("DateReturn");
	            	return outDateReturn;
	            }
	            conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	            return "Error";
	        }
		 return "Error";
	}
	
	public void setReservation(int rId, int uId, int cId, String iDateRes, String iTimeRes, String iDateRet) {
		
		String query = "INSERT INTO reservations ("
			    + " ReservationID,"
			    + " UserID,"
			    + " CarID,"
			    + " DateReserved,"
			    + " TimeReserved,"
			    + " DateReturn) VALUES ("
			    + "?, ?, ?, ?,?,?)";
		 
		try {
			
			String url = "jdbc:mysql://localhost:3306/automybile";
	        Connection conn = DriverManager.getConnection(url,"root","djinni");
	        
			    PreparedStatement st = conn.prepareStatement(query);
			    st.setInt(1, rId);
			    st.setInt(2, uId);
			    st.setInt(3, cId);
			    st.setString(4, iDateRes);
			    st.setString(5, iTimeRes);
			    st.setString(6, iDateRet);
			    // execute the preparedstatement insert
			    st.executeUpdate();
			    st.close(); 
			    
			    System.err.println("Added New Reservation!  ID: " + rId + ", User ID: " + uId + ", Car ID: " + cId 
			    		+ " Reserved on: " + iDateRes + " At this time: " + iTimeRes+ " To be returned by: " + iDateRet);
			   
	            conn.close();
			} catch (Exception e) {
        System.err.println("Got an exception! ");
        System.err.println(e.getMessage());
			  }
	 
	}
	
public void updateReservation(int rId, int uId, int cId, String iDateRes, String iTimeRes, String iDateRet) {
		
		String updater = "UPDATE reservations SET"
				    + " UserID = ?,"
				    + " CarID = ?,"
				    + " DateReserved =?,"
				    + " TimeReserved =?,"
				    + " DateReturn =?"
			    + " WHERE ReservationID = ?";
		 
		try {
			
			String url = "jdbc:mysql://localhost:3306/automybile";
	        Connection conn = DriverManager.getConnection(url,"root","djinni");
	        
			    PreparedStatement st = conn.prepareStatement(updater);
			    st.setInt(1, uId);
			    st.setInt(2, cId);
			    st.setString(3, iDateRes);
			    st.setString(4, iTimeRes);
			    st.setString(5, iDateRet);
			    st.setInt(6, rId);
			    
			    // execute the preparedstatement insert
			    st.executeUpdate();
			    st.close(); 
			    
			    System.err.println("Updated Reservation with ID: " + rId + " to: | User ID: " + uId + ", Car ID: " + cId 
			    		+ " Reserved on: " + iDateRes + " At this time: " + iTimeRes+ " To be returned by: " + iDateRet);
			    
			} catch (Exception e) {
        System.err.println("Got an exception! ");
        System.err.println(e.getMessage());
			  }
	}
}
