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
	
	
	public static String[] inicioSesion(String usuario) throws BDException {
		cargarConectarDriver();
		try (PreparedStatement stmt = conn.prepareStatement("SELECT password FROM usuario WHERE nickname = ?")) {
			stmt.setString(1, usuario);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String[] datosInicio = new String[3];
				datosInicio[0] = rs.getString("password");

				logger.info("Obtenidos el prefijo, password y clave de cifrado del usuario " + usuario
						+ "para el inicio de sesión");
				return datosInicio;
			} else {
				return null;
			}
		} catch (SQLException e) {
			logger.error("Error al obtener la información del usuario " + usuario, e);
		}
		return null;
	}
	
	public void guardarUsuario(Usuario j) throws BDException {

        try {
              pStatement = conn.prepareStatement("INSERT INTO USUARIO VALUES (default, ?, ?, ?, ?, ?, ?)");

              pStatement.setString(1, j.getNombre());
              pStatement.setString(2, j.getNickname());
              pStatement.setString(3, j.getMail());
              pStatement.setString(4, j.getPassword());
              pStatement.setLong(5, j.getPhoneNumber());
              pStatement.setLong(6, j.getIsAdmin());
             

              logger.info("Guardado el usuario " + j.getNombre() + "en la BD");

              pStatement.executeUpdate();
            } catch (SQLException e) {
                throw new BDException("Error al guardar el usuario admin", e);
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
					int isAdmin = rs.getInt("1");
					usu = new Usuario(id, nom, nick, mail, pw, pho, isAdmin);
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
		
		// Insertar producto en la bd
		public static void insertarProducto(Connection con, long id, String nom, String des, long pre, String url) {
			String sentSQL = "INSERT INTO Producto VALUES('"+id+"','"+nom+"','"+des+"',"+pre+",'"+url+"')";
			
			try {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sentSQL);
				stmt.close();
			} catch (SQLException e) {
				logger.warn(e.getMessage());
			}
		}
		
		// Eliminar producto de la bd
		public static void eliminarProducto(Connection con, long id) {
			String sentSQL = "DELETE FROM Producto WHERE id ='"+id+"'";
			try {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sentSQL);
				stmt.close();
			} catch (SQLException e) {
				logger.warn(e.getMessage());
			}
		}
		
		//Insertar cartelera en la bd
		public static void insertarCartelera(Connection con, long id, String artista, String des, int cap, String url) {
			String sentSQL = "INSERT INTO Cartelera VALUES('"+id+"','"+artista+"','"+des+"',"+cap+",'"+url+"')";
			
			try {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sentSQL);
				stmt.close();
			} catch (SQLException e) {
				logger.warn(e.getMessage());
			}
		}
		
		//Eliminar cartelera de la bd
		public static void eliminarCartelera(Connection con, long id) {
			String sentSQL = "DELETE FROM Cartelera WHERE id ='"+id+"'";
			try {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sentSQL);
				stmt.close();
			} catch (SQLException e) {
				logger.warn(e.getMessage());
			}
		}
		
		//Insertar concierto en la BD
		public static void insertarConcierto(Connection con, long id, String artista, String des, int cap, String url) {
			String sentSQL = "INSERT INTO Concierto VALUES('"+id+"','"+artista+"','"+des+"',"+cap+",'"+url+"')";
			
			try {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sentSQL);
				stmt.close();
			} catch (SQLException e) {
				logger.warn(e.getMessage());
			}
		}
		//Eliminar concierto de la BD
		public static void eliminarConcierto(Connection con, long id) {
			String sentSQL = "DELETE FROM Concierto WHERE id ='"+id+"'";
			try {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sentSQL);
				stmt.close();
			} catch (SQLException e) {
				logger.warn(e.getMessage());
			}
		}
	
}
