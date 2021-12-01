package bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	
		//Crear tablas en la bd (usuario, producto, cartelera y concierto)
		public static void crearTablas(Connection con) {
			String sent1 = "CREATE TABLE IF NOT EXISTS Usuario(id long, nom String, nick String, mail String, password String, phone int)";
			String sent2 = "CREATE TABLE IF NOT EXISTS Producto(id long, nombre String, descripcion String, precio long, url String)";
			String sent3 = "CREATE TABLE IF NOT EXISTS Cartelera(id long, artista String, descripcion String, capacidad int, url String)";
			String sent4 = "CREATE TABLE IF NOT EXISTS Concierto(id long, artista String, descripcion String, capacidad int, url String)";
			
			Statement st = null;
			
			try {
				st = conn.createStatement();
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
						logger.warn(e.getMessage());
					}
				}
			}
		}
		
		//Insertar Usuario en la bd 
		
		public static void insertarUsuario(Connection con, long id, String nom, String nick, String mail, String pw, int pho) {
			String sentSQL = "INSERT INTO Usuario VALUES('"+id+"','"+nom+"','"+nick+"','"+mail+"','"+pw+"',"+pho+")";
			
			try {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sentSQL);
				stmt.close();
			} catch (SQLException e) {
				logger.warn(e.getMessage());
			}
		}
		
		//Eliminar usuario de la bd
		
		public static void eliminarUsuario(Connection con, long id) {
			String sentSQL = "DELETE FROM Usuario WHERE id ='"+id+"'";
			try {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sentSQL);
				stmt.close();
			} catch (SQLException e) {
				logger.warn(e.getMessage());
			}
		}
		
		public static Usuario obtenerDatosUsuario(long id) {
			String sentSQL = "select * from Usuario where id="+id+";";
			Usuario usu = null;
			try {
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sentSQL);
				System.out.println(sentSQL);
				if(rs.next()) {
					System.out.println("USUARIO ENCONTRADO");
					
					String nom = rs.getString("nombre");
					String nick = rs.getString("nick");
					String mail = rs.getString("mail");
					String pw =  rs.getString("pw");
					int pho = rs.getInt("pho");
					usu = new Usuario(id, nom, nick, mail, pw, pho);
				}else {

					System.out.println("USUARIO NO ENCONTRADO");
				}
				rs.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return usu;
		}
	
	
}
