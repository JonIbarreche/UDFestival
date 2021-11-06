package bd;

import org.apache.log4j.*;

public class BDException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(BDException.class);
	
	public BDException(String mensaje) { 
		super(mensaje);
		logger.warn(mensaje);
	}
	
	public BDException(String message, Throwable e) {
		super(message, e);
		logger.warn(message, e);
	}
	//prueba de push
}