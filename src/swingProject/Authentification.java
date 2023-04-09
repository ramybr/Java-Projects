package swingProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class Authentification {

	public boolean adminAuthentification(JTextField login, JPasswordField password) throws SQLException {
		Connection connection = Database.getConnection();
		String sql = "SELECT * from admin WHERE userName = ? AND password = ?";

		PreparedStatement ps = connection.prepareStatement(sql);
		String loginTxt = login.getText();
		String passwordTxt = new String(password.getPassword());
		ps.setString(1, loginTxt);
		ps.setString(2, passwordTxt);

		ResultSet rs = ps.executeQuery();
		return rs.next();
	}

	public boolean ajoutUser(JTextField login, JPasswordField password, JPasswordField cnfPassword)
			throws SQLException {
		Connection connection = Database.getConnection();
		String sql = "INSERT INTO users values (?, ?)";

		String loginTxt = login.getText();
		String passwordTxt = new String(password.getPassword());
		String passwordCnf = new String(cnfPassword.getPassword());

		boolean ok = false;

		if (passwordTxt.equals(passwordCnf)) {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, loginTxt);
			ps.setString(2, passwordTxt);
			int res = ps.executeUpdate();
			ok = (res == 1);
			Database.closePreparedStatement(ps);
			JOptionPane.showMessageDialog(null, "Utilisateur ajouté");
		} else {
			JOptionPane.showMessageDialog(null, "Les deux mots de passe ne se correspondent pas");
		}
		Database.closeConnection(connection);

		return ok;
	}
	
	public boolean userAuthentification (JTextField login, JPasswordField password) throws SQLException {
		Connection connection = Database.getConnection();
		String sql = "SELECT * from users WHERE userName = ? AND password = ?";

		PreparedStatement ps = connection.prepareStatement(sql);
		String loginTxt = login.getText();
		String passwordTxt = new String(password.getPassword());
		ps.setString(1, loginTxt);
		ps.setString(2, passwordTxt);

		ResultSet rs = ps.executeQuery();
		return rs.next();
		
	}
	
	public void getAllUsers(JTable table) throws SQLException {
		Connection connection = Database.getConnection();
		String sql = "select userName  AS Utlisateur from users";

		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet res = ps.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(res));
	}
	
	public int supprmierUtilisateur(JTable table) throws SQLException {
		Connection connection = Database.getConnection();
		String sql = "DELETE from users where userName = ?";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		String cellule = table.getValueAt(table.getSelectedRow(), 0).toString();
		ps.setString(1, cellule);
		
		int res = ps.executeUpdate();
		
		int result = JOptionPane.showConfirmDialog(table, "Êtes-vous sûrs de vouloir supprimer l'utilisateur ?", "Supprimer Utilisateur", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if (result == JOptionPane.YES_OPTION) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.removeRow(table.getSelectedRow());
		}
		
		
		return res;
	}

}
