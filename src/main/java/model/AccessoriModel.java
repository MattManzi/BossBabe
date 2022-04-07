package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import bean.Accessori;

public class AccessoriModel implements ClassModel<Accessori>{

	public Accessori findByKey(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatemet = null;
		Accessori a = new Accessori();
		String selectSQL = "SELECT * FROM accessoriArticolo WHERE id=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatemet = connection.prepareStatement(selectSQL);
			preparedStatemet.setString(1, id);

			System.out.println("abbigliamentoArticolooModel -- findByKey" + preparedStatemet.toString());
			ResultSet rs = preparedStatemet.executeQuery();

			while (rs.next()) {
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nomeAc"));
				a.setDescrizione(rs.getString("descrizioneAc"));
				a.setColore(rs.getString("coloreAc"));
				a.setTipo(rs.getString("tipoAc"));
				a.setQuantita(rs.getInt("quantitaAc"));
				a.setNuovo(rs.getBoolean("nuovoAc"));
				a.setPrezzo(rs.getDouble("prezzoAc"));
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
		return a;
	}

	
	public ArrayList<Accessori> findAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Accessori> abbigliamento = new ArrayList<Accessori>();
		String selectSQL = "SELECT * FROM accessoriArticolo";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			System.out.println("ScarpeModel: findAll:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Accessori a = new Accessori();

				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nomeAc"));
				a.setDescrizione(rs.getString("descrizioneAc"));
				a.setTipo(rs.getString("tipoAc"));
				a.setColore(rs.getString("coloreAc"));
				a.setQuantita(rs.getInt("quantitaAc"));
				a.setPrezzo(rs.getDouble("prezzoAc"));
				a.setNuovo(rs.getBoolean("nuovoAc"));
				abbigliamento.add(a);
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
		return abbigliamento;
	}
	
	public ArrayList<Accessori> findAllBijoux(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Accessori> abbigliamento = new ArrayList<Accessori>();
		String selectSQL = "SELECT * FROM accessoriArticolo where tipoAc='Bijoux'";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			System.out.println("ScarpeModel: findAll:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Accessori a = new Accessori();

				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nomeAc"));
				a.setDescrizione(rs.getString("descrizioneAc"));
				a.setTipo(rs.getString("tipoAc"));
				a.setColore(rs.getString("coloreAc"));
				a.setQuantita(rs.getInt("quantitaAc"));
				a.setPrezzo(rs.getDouble("prezzoAc"));
				a.setNuovo(rs.getBoolean("nuovoAc"));
				abbigliamento.add(a);
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
		return abbigliamento;
	}
	
	public ArrayList<Accessori> findAllCinture(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Accessori> abbigliamento = new ArrayList<Accessori>();
		String selectSQL = "SELECT * FROM accessoriArticolo where tipoAc='Cinture'";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			System.out.println("ScarpeModel: findAll:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Accessori a = new Accessori();

				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nomeAc"));
				a.setDescrizione(rs.getString("descrizioneAc"));
				a.setTipo(rs.getString("tipoAc"));
				a.setColore(rs.getString("coloreAc"));
				a.setQuantita(rs.getInt("quantitaAc"));
				a.setPrezzo(rs.getDouble("prezzoAc"));
				a.setNuovo(rs.getBoolean("nuovoAc"));
				abbigliamento.add(a);
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
		return abbigliamento;
	}
	
	public ArrayList<Accessori> findAllBorse(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Accessori> abbigliamento = new ArrayList<Accessori>();
		String selectSQL = "SELECT * FROM accessoriArticolo where tipoAc='Borse'";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			System.out.println("ScarpeModel: findAll:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Accessori a = new Accessori();

				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nomeAc"));
				a.setDescrizione(rs.getString("descrizioneAc"));
				a.setTipo(rs.getString("tipoAc"));
				a.setColore(rs.getString("coloreAc"));
				a.setQuantita(rs.getInt("quantitaAc"));
				a.setPrezzo(rs.getDouble("prezzoAc"));
				a.setNuovo(rs.getBoolean("nuovoAc"));
				abbigliamento.add(a);
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
		return abbigliamento;
	}


	public void save(Accessori a) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO accessoriArticolo(nomeAc, tipoAc ,descrizioneAc, coloreAc, prezzoAc) VALUES (?,?,?,?,?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, a.getNome());
			preparedStatement.setString(2, a.getTipo());
			preparedStatement.setString(3, a.getDescrizione());
			preparedStatement.setString(4, a.getColore());
			preparedStatement.setDouble(5, a.getPrezzo());

			System.out.println("accessoriArticolo-Save:" + preparedStatement.toString());
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
	public void update(Accessori a) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE accessoriArticolo SET prezzoAc=?, quantitaAc=? WHERE id=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);

			preparedStatement.setDouble(1, a.getPrezzo());
			preparedStatement.setInt(2, a.getQuantita());
			preparedStatement.setInt(3, a.getId());

			System.out.println("accessoriArticolo-Update:" + preparedStatement.toString());
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
	public void delete(Accessori a) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM accessoriArticolo WHERE id=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);

			preparedStatement.setInt(1, a.getId());

			System.out.println("AbbigliamentoModel-Delete:" + preparedStatement.toString());
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

	public void newProdotto(Accessori a) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		byte[] bt = null;
		String updateSQL = "UPDATE accessoriArticolo SET nuovoAc=? WHERE id=?";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);

			System.out.println(a.isNuovo()+"---"+ a.getId());
			if (a.isNuovo() == false) {
				System.out.println("Entro 0");
				preparedStatement.setBoolean(1, true);
				preparedStatement.setInt(2, a.getId());
			} else {
				System.out.println("Entro 1");
				preparedStatement.setBoolean(1, false);
				preparedStatement.setInt(2, a.getId());
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

	public static void updateCopertina(String id, String copertinaAM) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE accessoriArticolo SET copertinaAcM = ? WHERE id=? ";
		System.out.println(updateSQL);
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);

			File file = new File(copertinaAM);
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

	public static void updateCopertina2(String id, String copertinaAM)throws SQLException  {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE accessoriArticolo SET copertinaAcM2 = ? WHERE id=? ";
		System.out.println(updateSQL);
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);

			File file = new File(copertinaAM);
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

	public static void updateCopertina3(String id, String copertinaAM)throws SQLException  {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE accessoriArticolo SET copertinaAcM3 = ? WHERE id=? ";
		System.out.println(updateSQL);
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);

			File file = new File(copertinaAM);
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
		String selectSQL = "SELECT copertinaAcM FROM accessoriArticolo WHERE id = ? ";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);

			System.out.println("AccessoriModel: loadCopertina:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				bt = rs.getBytes("copertinaAcM");
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
		String selectSQL = "SELECT copertinaAcM2 FROM accessoriArticolo WHERE id = ? ";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);

			System.out.println("AccessoriModel: loadCopertina:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				bt = rs.getBytes("copertinaAcM2");
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
		String selectSQL = "SELECT copertinaAcM3 FROM accessoriArticolo WHERE id = ? ";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);

			System.out.println("AccessoriModel: loadCopertina:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				bt = rs.getBytes("copertinaAcM3");
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

