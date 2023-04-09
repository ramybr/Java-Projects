package swingProject;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public interface DAO<T> {
	int chercher(int id, JTable table) throws SQLException;

	void getAll( JTable table) throws SQLException;

	int save(T t) throws SQLException;

	int ajouter(T t) throws SQLException;

	void modifier(int id, T t) throws SQLException;

	int supprimer(int id) throws SQLException;

}
