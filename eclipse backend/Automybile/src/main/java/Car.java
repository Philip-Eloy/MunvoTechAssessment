import java.sql.*;

public class Car {
	
	public void deleteCar(int idDel) {
		
		String deletion = "DELETE FROM cars WHERE "
			    + " CarID ="
			    + idDel
			    + "";
		
		try {
            String url = "jdbc:mysql://localhost:3306/automybile";
            Connection conn = DriverManager.getConnection(url,"root","djinni");
            PreparedStatement stmt = conn.prepareStatement(deletion);
 
            stmt.executeUpdate();
            System.out.println("Car with ID " + idDel + " deleted!");
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
	 
	            rs = stmt.executeQuery("SELECT CarID FROM cars");
	            while ( rs.next() ) {
	                
	            	int OutCarId = rs.getInt("CarID");
	            	return OutCarId;
	            }
	            conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	            return -1;
	        }
		 return -1;
	}
	
	public String getMake() {
		
		//If fails, return -1, look into how to break gracefully when methods demands return of a variable
		
		try {
	            String url = "jdbc:mysql://localhost:3306/automybile";
	            Connection conn = DriverManager.getConnection(url,"root","djinni");
	            Statement stmt = conn.createStatement();
	            ResultSet rs;
	 
	            rs = stmt.executeQuery("SELECT Make FROM cars"); //And lastname where Id = same
	            while ( rs.next() ) {
	                
	            	String OutMake = rs.getString("Make");
	            	return OutMake;
	            }
	            conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	            return "Error";
	        }
		 return "Error";
	}
	
	public String getModel() {
		
		//If fails, return -1, look into how to break gracefully when methods demands return of a variable
		
		try {
	            String url = "jdbc:mysql://localhost:3306/automybile";
	            Connection conn = DriverManager.getConnection(url,"root","djinni");
	            Statement stmt = conn.createStatement();
	            ResultSet rs;
	 
	            rs = stmt.executeQuery("SELECT Model FROM cars"); //And lastname where Id = same
	            while ( rs.next() ) {
	                
	            	String outModel = rs.getString("Model");
	            	return outModel;
	            }
	            conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	            return "Error";
	        }
		 return "Error";
	}
	
	public String getPlate() {
		
		//If fails, return -1, look into how to break gracefully when methods demands return of a variable
		
		try {
	            String url = "jdbc:mysql://localhost:3306/automybile";
	            Connection conn = DriverManager.getConnection(url,"root","djinni");
	            Statement stmt = conn.createStatement();
	            ResultSet rs;
	 
	            rs = stmt.executeQuery("SELECT Plate FROM cars"); //And lastname where Id = same
	            while ( rs.next() ) {
	                
	            	String outPlate = rs.getString("Plate");
	            	return outPlate;
	            }
	            conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	            return "Error";
	        }
		 return "Error";
	}
	
	
	public void setCar(int iId, String iMake, String iModel, String iPlate) {
		
		String query = "INSERT INTO cars ("
			    + " CarID,"
			    + " Make,"
			    + " Model,"
			    + " Plate) VALUES ("
			    + "?, ?, ?, ?)";
		 
		try {
			
			String url = "jdbc:mysql://localhost:3306/automybile";
	        Connection conn = DriverManager.getConnection(url,"root","djinni");
	        
			    PreparedStatement st = conn.prepareStatement(query);
			    st.setInt(1, iId);
			    st.setString(2, iMake);
			    st.setString(3, iModel);
			    st.setString(4, iPlate);
			    
			    // execute the preparedstatement insert
			    st.executeUpdate();
			    st.close(); 
			    
			    System.err.println("Added New Car!  ID: " + iId + ", Make: " + iMake + ", Model: " + iModel + ", License plate: " + iPlate);
			    
			} catch (Exception e) {
        System.err.println("Got an exception! ");
        System.err.println(e.getMessage());
			  }
	 
	}
	
public void updateCar(int iId, String iModel, String iMake, String iPlate) {
		
		String updater = "UPDATE cars SET"
				+ " Model = ?,"
			    + " Make = ?,"
			    + " Plate = ?"
			    + " WHERE CarID = ?";
		 
		try {
			
			String url = "jdbc:mysql://localhost:3306/automybile";
	        Connection conn = DriverManager.getConnection(url,"root","djinni");
	        
			    PreparedStatement st = conn.prepareStatement(updater);
			    st.setString(1, iModel);
			    st.setString(2, iMake);
			    st.setString(3, iPlate);
			    st.setInt(4, iId);
			    
			    // execute the preparedstatement insert
			    st.executeUpdate();
			    st.close(); 
			    
			    System.err.println("Updated Car with ID: " + iId + " to: | Model: " + iModel + ", Make" + iMake + " License Plate: " + iPlate);
			    
			} catch (Exception e) {
        System.err.println("Got an exception! ");
        System.err.println(e.getMessage());
			  }
	}
}
