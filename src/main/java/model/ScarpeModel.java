package model;

import java.sql.SQLException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Scarpe;

public class ScarpeModel implements ClassModel<Scarpe> {

	@Override
	public Scarpe findByKey(String id) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatemet = null;
		Scarpe s = new Scarpe();
		String selectSQL = "SELECT * FROM scarpeArticolo WHERE id=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatemet = connection.prepareStatement(selectSQL);
			preparedStatemet.setString(1, id);

			System.out.println("ScarpeArticoloModel -- findByKey" + preparedStatemet.toString());
			ResultSet rs = preparedStatemet.executeQuery();

			while (rs.next()) {
				s.setId(rs.getInt("id"));
				s.setNome(rs.getString("nomeS"));
				s.setDescrizione(rs.getString("descrizioneS"));
				s.setColore(rs.getString("coloreS"));
				s.setTaglia(rs.getString("tagliaS"));
				s.setNuovo(rs.getBoolean("nuovoS"));
				s.setPrezzo(rs.getDouble("prezzoS"));
			}
		} finally {
			try {
				if (preparedStatemet != null) {
					preparedStatemet.close();
				}

			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return s;
	}

	@Override
	public ArrayList<Scarpe> findAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Scarpe> scarpe = new ArrayList<Scarpe>();
		String selectSQL = "SELECT * FROM scarpeArticolo";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			System.out.println("ScarpeModel: findAll:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Scarpe s = new Scarpe();

				s.setId(rs.getInt("id"));
				s.setNome(rs.getString("nomeS"));
				s.setDescrizione(rs.getString("descrizioneS"));
				s.setColore(rs.getString("coloreS"));
				s.setTaglia(rs.getString("tagliaS"));
				s.setPrezzo(rs.getDouble("prezzoS"));
				s.setNuovo(rs.getBoolean("nuovoS"));
				scarpe.add(s);
			}
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return scarpe;
	}

	public ArrayList<Scarpe> findAllTaglie(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Scarpe> scarpe = new ArrayList<Scarpe>();
		String selectSQL = "SELECT * FROM scarpeArticolo";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			System.out.println("ScarpeModel: findAll:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Scarpe s = new Scarpe();

				s.setId(rs.getInt("id"));
				s.setNome(rs.getString("nomeS"));
				s.setDescrizione(rs.getString("descrizioneS"));
				scarpe.add(s);
			}
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return scarpe;
	}

	@Override
	public void newProdotto(Scarpe s) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		byte[] bt = null;
		String updateSQL = "UPDATE scarpeArticolo SET nuovoS=? WHERE id=?";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);

			System.out.println(s.isNuovo()+"---"+ s.getId());
			if (s.isNuovo() == false) {
				System.out.println("Entro 0");
				preparedStatement.setBoolean(1, true);
				preparedStatement.setInt(2, s.getId());
			} else {
				System.out.println("Entro 1");
				preparedStatement.setBoolean(1, false);
				preparedStatement.setInt(2, s.getId());
			}
			preparedStatement.executeUpdate();
			connection.commit();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	@Override
	public void save(Scarpe s) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO scarpeArticolo(nomeS, descrizioneS, coloreS, tagliaS, prezzoS) VALUES (?,?,?,?,?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, s.getNome());
			preparedStatement.setString(2, s.getDescrizione());
			preparedStatement.setString(3, s.getColore());
			preparedStatement.setString(4, s.getTaglia());
			preparedStatement.setDouble(5, s.getPrezzo());

			System.out.println("ScarpeaModel-Save:" + preparedStatement.toString());
			preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	@Override
	public void update(Scarpe s) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE scarpeArticolo SET prezzoS=? , tagliaS=? WHERE id=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);

			preparedStatement.setDouble(1, s.getPrezzo());
			preparedStatement.setString(2, s.getTaglia());
			preparedStatement.setInt(3, s.getId());

			System.out.println("ScarpeaModel-Update:" + preparedStatement.toString());
			preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	public void delete(Scarpe s) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM scarpeArticolo WHERE id=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);

			preparedStatement.setInt(1, s.getId());

			System.out.println("ScarpeaModel-Delete:" + preparedStatement.toString());
			preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}

	}

	public boolean checkName(String n) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Scarpe s = new Scarpe();
		String selectSQL = "SELECT * FROM scarpeArticolo WHERE nomes=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, n);

			System.out.println("ScarpeModel-checkName:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				s.setNome(rs.getString("nomeS"));
			}
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return s.getNome() == null;
	}

	public boolean checkCode(String i) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "SELECT * FROM scarpeArticolo WHERE id=?";

		Scarpe s = new Scarpe();

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, i);

			System.out.println("ScarpeeModel-checkCode:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				s.setNome(rs.getString("nome"));
			}
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}

		return s.getNome() == null;
	}

	public synchronized static void updateCopertina(String id, String copertinaSM) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE scarpeArticolo SET copertinaSM = ? WHERE id=? ";
		System.out.println(updateSQL);
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);

			File file = new File(copertinaSM);
			try {
				FileInputStream fis = new FileInputStream(file);
				preparedStatement.setBinaryStream(1, fis, fis.available());
				preparedStatement.setString(2, id);

				preparedStatement.executeUpdate();
				connection.commit();
				System.out.println("commit immagine");
			} catch (FileNotFoundException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			}
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException sqlException) {
				System.out.println(sqlException);
			} finally {
				if (connection != null)
					DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	public synchronized static void updateCopertina2(String id, String copertinaSM) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE scarpeArticolo SET copertinaSM2 = ? WHERE id=? ";
		System.out.println(updateSQL);
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);

			File file = new File(copertinaSM);
			try {
				FileInputStream fis = new FileInputStream(file);
				preparedStatement.setBinaryStream(1, fis, fis.available());
				preparedStatement.setString(2, id);

				preparedStatement.executeUpdate();
				connection.commit();
				System.out.println("commit immagine");
			} catch (FileNotFoundException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			}
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException sqlException) {
				System.out.println(sqlException);
			} finally {
				if (connection != null)
					DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	public synchronized static void updateCopertina3(String id, String copertinaSM) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE scarpeArticolo SET copertinaSM3 = ? WHERE id=? ";
		System.out.println(updateSQL);
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);

			File file = new File(copertinaSM);
			try {
				FileInputStream fis = new FileInputStream(file);
				preparedStatement.setBinaryStream(1, fis, fis.available());
				preparedStatement.setString(2, id);

				preparedStatement.executeUpdate();
				connection.commit();
				System.out.println("commit immagine");
			} catch (FileNotFoundException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			}
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException sqlException) {
				System.out.println(sqlException);
			} finally {
				if (connection != null)
					DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	public synchronized static byte[] loadCopertina(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		byte[] bt = null;
		String selectSQL = "SELECT copertinaSM FROM scarpeArticolo WHERE id = ? ";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);

			System.out.println("VinileModel: loadCopertina:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				bt = rs.getBytes("copertinaSM");
			}
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException sqlException) {
				System.out.println(sqlException);
			} finally {
				if (connection != null)
					DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return bt;
	}

	public synchronized static byte[] loadCopertina2(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		byte[] bt = null;
		String selectSQL = "SELECT copertinaSM2 FROM scarpeArticolo WHERE id = ? ";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);

			System.out.println("VinileModel: loadCopertina:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				bt = rs.getBytes("copertinaSM2");
			}
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException sqlException) {
				System.out.println(sqlException);
			} finally {
				if (connection != null)
					DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return bt;
	}

	public synchronized static byte[] loadCopertina3(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		byte[] bt = null;
		String selectSQL = "SELECT copertinaSM3 FROM scarpeArticolo WHERE id = ? ";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);

			System.out.println("VinileModel: loadCopertina:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				bt = rs.getBytes("copertinaSM3");
			}
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException sqlException) {
				System.out.println(sqlException);
			} finally {
				if (connection != null)
					DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return bt;
	}

}
