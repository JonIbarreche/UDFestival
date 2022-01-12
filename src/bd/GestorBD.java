package bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import org.apache.log4j.*;

import jdo.Producto;
import jdo.Usuario;
import jdo.Cartelera;
import jdo.Concierto;
import jdo.Pedido;
import jdo.Inventario;
import jdo.Ticket;



public class GestorBD {
	
	protected static Connection conn = null;
	private static PreparedStatement pStatement = null;
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
	
	public static void guardarUsuario(Usuario j) throws BDException {
		cargarConectarDriver();
        try {
              pStatement = conn.prepareStatement("INSERT INTO usuario(nombre, nickname, mail, password, phoneNumber, isAdmin) VALUES (?, ?, ?, ?, ?, ?)");

              pStatement.setString(1, j.getNombre());
              pStatement.setString(2, j.getNickname());
              pStatement.setString(3, j.getMail());
              pStatement.setString(4, j.getPassword());
              pStatement.setInt(5, j.getPhoneNumber());
              pStatement.setInt(6, j.getIsAdmin());
             

              logger.info("Guardado el usuario " + j.getNombre() + "en la BD");

              pStatement.executeUpdate();
            } catch (SQLException e) {
                throw new BDException("Error al guardar el usuario", e);
            }
    }
	
		//Crear tablas en la bd (usuario, producto, cartelera y concierto)
		public static void crearTablas(Connection con) {
			
			String sent1 = "CREATE TABLE \"usuario\" (\r\n"
					+ "	\"idUsuario\"	INTEGER,\r\n"
					+ "	\"nombre\"	TEXT,\r\n"
					+ "	\"nickname\"	TEXT,\r\n"
					+ "	\"mail\"	TEXT,\r\n"
					+ "	\"password\"	TEXT,\r\n"
					+ "	\"phoneNumber\"	INTEGER,\r\n"
					+ "	\"isAdmin\"	INTEGER,\r\n"
					+ "	PRIMARY KEY(\"idUsuario\" AUTOINCREMENT)\r\n"
					+ ");";
	String sent2 = "CREATE TABLE \"ticket\" (\r\n"
					+ "	\"id\"	INTEGER,\r\n"
					+ "	\"concierto\"	INTEGER,\r\n"
					+ "	\"precio\"	INTEGER,\r\n"
					+ "	\"sesion\"	TEXT,\r\n"
					+ "	PRIMARY KEY(\"id\" AUTOINCREMENT),\r\n"
					+ "	FOREIGN KEY(\"concierto\") REFERENCES \"concierto\"(\"id\")\r\n"
					+ ");";
	String sent3 = "CREATE TABLE \"cartelera\" (\r\n"
					+ "	\"id\"	INTEGER,\r\n"
					+ "	\"artista\"	TEXT,\r\n"
					+ "	\"descripcion\"	TEXT,\r\n"
					+ "	\"capacidad\"	INTEGER,\r\n"
					+ "	\"url\"	TEXT,\r\n"
					+ "	PRIMARY KEY(\"id\")\r\n"
					+ ");";
	String sent4 = "CREATE TABLE \"concierto\" (\r\n"
					+ "	\"id\"	INTEGER,\r\n"
					+ "	\"artista\"	TEXT,\r\n"
					+ "	\"descripcion\"	TEXT,\r\n"
					+ "	\"capacidad\"	INTEGER,\r\n"
					+ "	\"url\"	TEXT,\r\n"
					+ "	PRIMARY KEY(\"id\")\r\n"
					+ ");";
	
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
		public static void insertarTicket(Ticket t) throws BDException {
			cargarConectarDriver();
	        try {
	              pStatement = conn.prepareStatement("INSERT INTO ticket(concierto, precio, sesion) VALUES (?, ?, ?)");

	              pStatement.setInt(1, t.getConcierto().getId());
	              pStatement.setLong(2, t.getPrecio());
	              pStatement.setString(3, t.getSesion());


	              logger.info("Guardado el usuario " + t.getPrecio() + "en la BD");

	              pStatement.executeUpdate();
	            } catch (SQLException e) {
	                throw new BDException("Error al guardar el usuario", e);
	            }
	    }
		
		public static ResultSet llenarTablaTickets() throws SQLException {
			cargarConectarDriver();

			pStatement = conn.prepareStatement("SELECT * FROM ticket");

			try {
				ResultSet rs = pStatement.executeQuery();
				logger.info("Obtenida la información de los tickets");
				return rs;
			} catch (SQLException e) {
				logger.error("Imposible obtener la información de los tickets" , e);
			}
			return null;
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
		
		public static Producto obtenerDatosProducto(long id) {
			String sentSQL = "select * from Producto where id="+id+";";
			Producto pro = null;
			try {
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sentSQL);
				System.out.println(sentSQL);
				if(rs.next()) {
					System.out.println("PRODUCTO ENCONTRADO");
					
					String nom = rs.getString("nombre");
					String des = rs.getString("descripcion");
					long pre = rs.getLong("precio");
					String url =  rs.getString("url");
					int isAdmin = rs.getInt("1");
					pro = new Producto(id, nom, des, pre, url);
				}else {

					System.out.println("PRODUCTO NO ENCONTRADO");
				}
				rs.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return pro;
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
		/**
		 * 
		public static Cartelera obtenerDatosCartelera(long id) {
			String sentSQL = "select * from Cartelera where id="+id+";";
			Cartelera car = null;
			try {
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sentSQL);
				System.out.println(sentSQL);
				if(rs.next()) {
					System.out.println("CARTELERA ENCONTRADA");
					
					String art = rs.getString("artista");
					String des = rs.getString("descripcion");
					int cap = rs.getInt("cap");
					String url =  rs.getString("url");
					int isAdmin = rs.getInt("1");
					car = new Cartelera(id, art, des, cap, url);
				}else {

					System.out.println("PRODUCTO NO ENCONTRADO");
				}
				rs.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return car;
		}
		*/
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
		/*
		public static Concierto obtenerDatosConcierto(long id) {
			String sentSQL = "select * from Concierto where id="+id+";";
			Concierto con = null;
			try {
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sentSQL);
				System.out.println(sentSQL);
				if(rs.next()) {
					System.out.println("CONCIERTO ENCONTRADO");
					
					String art = rs.getString("artista");
					String des = rs.getString("descripcion");
					int cap = rs.getInt("cap");
					String url =  rs.getString("url");
					int isAdmin = rs.getInt("1");
					con = new Concierto(id, art, des, cap, url);
				}else {

					System.out.println("PRODUCTO NO ENCONTRADO");
				}
				rs.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
		}
		*/
	
}
