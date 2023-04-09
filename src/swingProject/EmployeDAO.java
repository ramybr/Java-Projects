package swingProject;

import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JTable;

public interface EmployeDAO extends DAO<Employe> {

public	void annuler() throws SQLException;

public	void sauvegarder() throws SQLException;

public Employe getInfo(int id) throws SQLException;

public void clear(JTable table);
public void addDeptId(JComboBox<Integer> comboBox) throws SQLException;

}
