package swingProject;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class EmployeDAOImp implements EmployeDAO {

	@Override
	public int chercher(int id, JTable table) throws SQLException {
		Connection connection = Database.getConnection();
		String sql = "select employe_id  AS ID, last_name AS Nom, first_name AS Prénom, dept_id AS ID_département , email AS Email, phone_number AS Téléphone, salary AS Salaire, hire_date AS Date_Embauche from employe WHERE employe_id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet res = ps.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(res));

		String countQuery = "SELECT COUNT(employe_id) AS count from employe WHERE employe_id = ? ";
		PreparedStatement psCount = connection.prepareStatement(countQuery);
		psCount.setInt(1, id);
		ResultSet countRes = psCount.executeQuery();
		countRes.next();

		int count = countRes.getInt("count");
		if (count == 0)
			JOptionPane.showMessageDialog(table, "L'ID : " + id + " n'existe pas");
		
		return count;
	}

	@Override
	public void getAll(JTable table) throws SQLException {
		Connection connection = Database.getConnection();
		String sql = "select employe_id  AS ID, last_name AS Nom, first_name AS Prénom, dept_id AS ID_Département , email AS Email, phone_number AS Téléphone, salary AS Salaire, hire_date AS Date_Embauche from employe";

		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet res = ps.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(res));
	}


	@Override
	public int ajouter(Employe employe) throws SQLException {
		Connection connection = Database.getConnection();
		String sql = "INSERT INTO employe(employe_id, last_name, first_name, dept_id, email, phone_number, salary, hire_date) values (?, ?,?, ?,?, ?,?, ?)";

		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, employe.getId());
		ps.setString(2, employe.getNom());
		ps.setString(3, employe.getPrenom());
		ps.setInt(4, employe.getDepId());
		ps.setString(5, employe.getEmail());
		ps.setString(6, employe.getTel());
		ps.setInt(7, employe.getSalaire());
		ps.setDate(8, employe.getDateEmbauche());

		int res = ps.executeUpdate();

		Database.closePreparedStatement(ps);
		Database.closeConnection(connection);

		return res;
	}

	@Override
	public void modifier(int id, Employe employe) throws SQLException {
		Connection connection = Database.getConnection();
		String sql = "UPDATE employe set last_name = ?, first_name = ?, dept_id = ?, email = ?, phone_number = ?, salary = ?, hire_date = ? where employe_id = ?";

		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, employe.getNom());
		ps.setString(2, employe.getPrenom());
		ps.setInt(3, employe.getDepId());
		ps.setString(4, employe.getEmail());
		ps.setString(5, employe.getTel());
		ps.setInt(6, employe.getSalaire());
		ps.setDate(7, employe.getDateEmbauche());
		ps.setInt(8, employe.getId());

		ps.executeUpdate();

		Database.closePreparedStatement(ps);
		Database.closeConnection(connection);

	}

	@Override
	public int supprimer(int id) throws SQLException {
		Connection connection = Database.getConnection();

		String sql = "DELETE FROM employe WHERE employe_id = ?";

		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);

		int res = ps.executeUpdate();

		Database.closePreparedStatement(ps);
		Database.closeConnection(connection);

		if (res == 1) {
			JOptionPane.showMessageDialog(null, "Employé supprimé");
		}
		return res;
	}

	@Override
	public void annuler() throws SQLException {
		Connection connection = Database.getConnection();
		connection.setAutoCommit(false);
		connection.rollback();
		Database.closeConnection(connection);

	}

	@Override
	public void sauvegarder() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Employe getInfo(int id) throws SQLException {
		Connection connection = Database.getConnection();
		String sql = "SELECT * FROM employe WHERE employe_id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		Employe employe = null;
		while (rs.next()) {
			int empid = rs.getInt("employe_id");
			String nom = rs.getString("last_name");
			String prenom = rs.getString("first_name");
			int deptId = rs.getInt("dept_id");
			String email = rs.getString("email");
			String tel = rs.getString("phone_number");
			int salaire = rs.getInt("salary");
			Date dateEmbauche = rs.getDate("hire_date");
			employe = new Employe(empid, nom, prenom, deptId, email, tel, salaire, dateEmbauche);
		}

		return employe;
	}

	@Override
	public void clear(JTable table) {
		String[] cols = { "ID", "Nom", "Prénom", "ID_Département", "Email", "Téléphone", "Salaire", "Date_Embauche" };
		table.setModel(new DefaultTableModel(cols, 0));
	}
	
	public void addDeptId(JComboBox<Integer> comboBox) throws SQLException {
		Connection connection = Database.getConnection();
		String sql = "SELECT DISTINCT dept_id FROM employe";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			int id = rs.getInt("dept_id");
			comboBox.addItem(id);
		}
		
		
	}

	@Override
	public int save(Employe t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
