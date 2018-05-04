import java.sql.*;


public class DaoPatternDemo {
	
	 public static void main(String[] args) {
		 
		 UserDao userDao = new UserDaoImpl();
		 User user = new User();
		 
		 CarDao carDao = new CarDaoImpl();
		 Car car = new Car();
		 
		 ReservationDao reservationDao = new ReservationDaoImpl();
		 Reservation reservation = new Reservation();
		 
		 userDao.getAllUsers();
		 carDao.getAllCars();
		 reservationDao.getAllReservations();
		 
		 System.out.println("---");
		 
		 user.setUser(4, "Jim", "Sterling", "4445557777");
		 user.updateUser(2, "Futaba", "Sakurai", "4445557897");
		 car.setCar(4, "Rolls-Royce", "Classic", "P5G 4RV");
		 reservation.setReservation(3, 2, 1, "2018-4-6", "12:12:00", "2018-4-10");
		 
		 System.out.println("---");		 
		 
		 userDao.getAllUsers();
		 carDao.getAllCars();
		 reservationDao.getAllReservations();
		 
		 System.out.println("---");		 
		 
		 user.deleteUser(4);
		 reservation.deleteReservation(3);
		 user.updateUser(2, "Ann", "Takamaki", "4445551324");
		 car.deleteCar(4);
		 
	}
}
