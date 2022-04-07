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

import bean.Abbigliamento;


public class AbbigliamentoModel implements ClassModel<Abbigliamento>{

	@Override
	public Abbigliamento findByKey(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatemet = null;
		Abbigliamento a = new Abbigliamento();
		String selectSQL = "SELECT * FROM abbigliamentoArticolo WHERE id=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatemet = connection.prepareStatement(selectSQL);
			preparedStatemet.setString(1, id);

			System.out.println("abbigliamentoArticolooModel -- findByKey" + preparedStatemet.toString());
			ResultSet rs = preparedStatemet.executeQuery();

			while (rs.next()) {
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nomeA"));
				a.setDescrizione(rs.getString("descrizioneA"));
				a.setColore(rs.getString("coloreA"));
				a.setTaglia(rs.getString("tagliaA"));
				a.setTipo(rs.getString("tipoA"));
				a.setNuovo(rs.getBoolean("nuovoA"));
				a.setPrezzo(rs.getDouble("prezzoA"));
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

	@Override
	public ArrayList<Abbigliamento> findAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Abbigliamento> abbigliamento = new ArrayList<Abbigliamento>();
		String selectSQL = "SELECT * FROM abbigliamentoArticolo";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			System.out.println("ScarpeModel: findAll:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Abbigliamento a = new Abbigliamento();

				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nomeA"));
				a.setDescrizione(rs.getString("descrizioneA"));
				a.setTipo(rs.getString("tipoA"));
				a.setColore(rs.getString("coloreA"));
				a.setTaglia(rs.getString("tagliaA"));
				a.setPrezzo(rs.getDouble("prezzoA"));
				a.setNuovo(rs.getBoolean("nuovoA"));
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

	public ArrayList<Abbigliamento> findAllMaglia(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Abbigliamento> abbigliamento = new ArrayList<Abbigliamento>();
		String selectSQL = "SELECT * FROM abbigliamentoArticolo WHERE tipoA='Maglia'";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			System.out.println("ScarpeModel: findAll:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Abbigliamento a = new Abbigliamento();

				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nomeA"));
				a.setDescrizione(rs.getString("descrizioneA"));
				a.setTipo(rs.getString("tipoA"));
				a.setColore(rs.getString("coloreA"));
				a.setTaglia(rs.getString("tagliaA"));
				a.setPrezzo(rs.getDouble("prezzoA"));
				a.setNuovo(rs.getBoolean("nuovoA"));
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
	
	public ArrayList<Abbigliamento> findAllPantaloni(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Abbigliamento> abbigliamento = new ArrayList<Abbigliamento>();
		String selectSQL = "SELECT * FROM abbigliamentoArticolo WHERE tipoA='Pantaloni'";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			System.out.println("ScarpeModel: findAll:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Abbigliamento a = new Abbigliamento();

				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nomeA"));
				a.setDescrizione(rs.getString("descrizioneA"));
				a.setTipo(rs.getString("tipoA"));
				a.setColore(rs.getString("coloreA"));
				a.setTaglia(rs.getString("tagliaA"));
				a.setPrezzo(rs.getDouble("prezzoA"));
				a.setNuovo(rs.getBoolean("nuovoA"));
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
	
	public ArrayList<Abbigliamento> findAllDress(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Abbigliamento> abbigliamento = new ArrayList<Abbigliamento>();
		String selectSQL = "SELECT * FROM abbigliamentoArticolo WHERE tipoA='Dress'";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			System.out.println("ScarpeModel: findAll:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Abbigliamento a = new Abbigliamento();

				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nomeA"));
				a.setDescrizione(rs.getString("descrizioneA"));
				a.setTipo(rs.getString("tipoA"));
				a.setColore(rs.getString("coloreA"));
				a.setTaglia(rs.getString("tagliaA"));
				a.setPrezzo(rs.getDouble("prezzoA"));
				a.setNuovo(rs.getBoolean("nuovoA"));
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
	public ArrayList<Abbigliamento> findAllShort(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Abbigliamento> abbigliamento = new ArrayList<Abbigliamento>();
		String selectSQL = "SELECT * FROM abbigliamentoArticolo WHERE tipoA='Shorts'";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			System.out.println("ScarpeModel: findAll:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Abbigliamento a = new Abbigliamento();

				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nomeA"));
				a.setDescrizione(rs.getString("descrizioneA"));
				a.setTipo(rs.getString("tipoA"));
				a.setColore(rs.getString("coloreA"));
				a.setTaglia(rs.getString("tagliaA"));
				a.setPrezzo(rs.getDouble("prezzoA"));
				a.setNuovo(rs.getBoolean("nuovoA"));
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
	
	public ArrayList<Abbigliamento> findAllGiacche(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Abbigliamento> abbigliamento = new ArrayList<Abbigliamento>();
		String selectSQL = "SELECT * FROM abbigliamentoArticolo WHERE tipoA='Giacche'";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			System.out.println("ScarpeModel: findAll:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Abbigliamento a = new Abbigliamento();

				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nomeA"));
				a.setDescrizione(rs.getString("descrizioneA"));
				a.setTipo(rs.getString("tipoA"));
				a.setColore(rs.getString("coloreA"));
				a.setTaglia(rs.getString("tagliaA"));
				a.setPrezzo(rs.getDouble("prezzoA"));
				a.setNuovo(rs.getBoolean("nuovoA"));
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
	
	public ArrayList<Abbigliamento> findAllNuoviArrivi(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Abbigliamento> abbigliamento = new ArrayList<Abbigliamento>();
		String selectSQL = "SELECT * FROM abbigliamentoArticolo WHERE nuovoA=1";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			System.out.println("ScarpeModel: findAll:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Abbigliamento a = new Abbigliamento();

				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nomeA"));
				a.setDescrizione(rs.getString("descrizioneA"));
				a.setTipo(rs.getString("tipoA"));
				a.setColore(rs.getString("coloreA"));
				a.setTaglia(rs.getString("tagliaA"));
				a.setPrezzo(rs.getDouble("prezzoA"));
				a.setNuovo(rs.getBoolean("nuovoA"));
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


	@Override
	public void save(Abbigliamento a) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO abbigliamentoArticolo(nomeA, tipoA ,descrizioneA, coloreA, tagliaA, prezzoA) VALUES (?,?,?,?,?,?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, a.getNome());
			preparedStatement.setString(2, a.getTipo());
			preparedStatement.setString(3, a.getDescrizione());
			preparedStatement.setString(4, a.getColore());
			preparedStatement.setString(5, a.getTaglia());
			preparedStatement.setDouble(6, a.getPrezzo());

			System.out.println("AbbigliamentoModel-Save:" + preparedStatement.toString());
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
	public void update(Abbigliamento a) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE abbigliamentoArticolo SET prezzoA=? , tagliaA=? WHERE id=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);

			preparedStatement.setDouble(1, a.getPrezzo());
			preparedStatement.setString(2, a.getTaglia());
			preparedStatement.setInt(3, a.getId());

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

	@Override
	public void delete(Abbigliamento a) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM abbigliamentoArticolo WHERE id=?";

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

	public void newProdotto(Abbigliamento a) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		byte[] bt = null;
		String updateSQL = "UPDATE abbigliamentoArticolo SET nuovoA=? WHERE id=?";
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

		String updateSQL = "UPDATE abbigliamentoArticolo SET copertinaAM = ? WHERE id=? ";
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

		String updateSQL = "UPDATE abbigliamentoArticolo SET copertinaAM2 = ? WHERE id=? ";
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

		String updateSQL = "UPDATE abbigliamentoArticolo SET copertinaAM3 = ? WHERE id=? ";
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
		String selectSQL = "SELECT copertinaAM FROM abbigliamentoArticolo WHERE id = ? ";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);

			System.out.println("VinileModel: loadCopertina:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				bt = rs.getBytes("copertinaAM");
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
		String selectSQL = "SELECT copertinaAM2 FROM abbigliamentoArticolo WHERE id = ? ";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);

			System.out.println("VinileModel: loadCopertina:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				bt = rs.getBytes("copertinaAM2");
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
		String selectSQL = "SELECT copertinaAM3 FROM abbigliamentoArticolo WHERE id = ? ";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);

			System.out.println("VinileModel: loadCopertina:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				bt = rs.getBytes("copertinaAM3");
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