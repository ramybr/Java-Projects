package swingProject;

import java.sql.Connection;
import java.sql.SQLException;

public class test {
	
	public static void main(String[] args) throws SQLException {
		Connection con = Database.getConnection();
		if (con != null) {
			System.out.println("connected!");
		}
		
		
		
		EmployeDAO employeDAO = new EmployeDAOImp();
		employeDAO.annuler();
			
	}

}
