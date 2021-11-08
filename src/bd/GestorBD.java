package bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.*;

import jdo.Usuario;



public class GestorBD {
	
	protected static Connection conn = null;
	private PreparedStatement pStatement = null;
	private static final Logger logger = LogManager.getLogger(GestorBD.class);
	// Conectar BD
	public static void cargarConectarDriver() {
		try {
			Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
			System.out.println("No se ha podido cargar el driver de la base de datos");
			}
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:UDFestival.db");
			// aquí podemos realizar operaciones sobre la base de datos conectada
			} catch (SQLException e) {
			
			}
	}
	//Desconectar BD
	public void desconectar() throws BDException {
		try {
			if (conn != null) {
				conn.close();
				logger.info("Desconectado de la base de datos");
			}
		} catch (SQLException e) {
			throw new BDException("No se ha podido cerrar la conexion con la BD.", e);
		}
	}
	
	//REGISTRAR EN LA BD UN CLIENTE NUEVO
		public void insertaUsuario(Usuario u) {
			try {			
				pStatement = conn.prepareStatement("INSERT INTO usuario VALUES (default,?,?,?,?,?)");
				
				pStatement.setString(1, u.getNombre());
				pStatement.setString(2, u.getNickname());
				pStatement.setString(3, u.getMail());
				pStatement.setString(4, u.getPassword());
				pStatement.setInt(5, u.getPhoneNumber());


				//...
				pStatement.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				logger.warn(e.getMessage());
			} 	
		}
		//Crear tablas en la bd (usuario, producto, cartelera y concierto)
		public static void crearTablas(Connection con) {
			String sent1 = "CREATE TABLE IF NOT EXISTS Usuario(id long, nom String, nick String, mail String, password String, phone int)";
			String sent2 = "CREATE TABLE IF NOT EXISTS Producto(id long, nombre String, descripcion String, precio long, url String)";
			String sent3 = "CREATE TABLE IF NOT EXISTS Cartelera(id long, artista String, descripcion String, capacidad int, url String)";
			String sent4 = "CREATE TABLE IF NOT EXISTS Concierto(id long, artista String, descripcion String, capacidad int, url String)";
			
			Statement st = null;
			
			try {
				st = con.createStatement();
				st.executeUpdate(sent1);
				st.executeUpdate(sent2);
				st.executeUpdate(sent3);
				st.executeUpdate(sent4);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(st!=null) {
					try {
						st.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	
	
}
