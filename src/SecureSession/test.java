package SecureSession;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class test {

	@Test
	void testSecSessionControllerIsPossible() {
		HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();;
		SecSessionController sesionController = new SecSessionController(map);
		sesionController.addRute("/home", "/home");
		SecSession sesion = new SecSession("sesionUno","/home");
		assertTrue(sesionController.isPossible("/home", sesion));
		sesionController.addRute("/home", "/home1");
		assertTrue(sesionController.isPossible("/home1", sesion));
		sesion.setLastURI("/home");
		sesionController.removeRute("/noExist","...");
		assertTrue(sesionController.isPossible("/home", sesion));
		assertTrue(sesionController.isPossible("/home1", sesion));
		sesion.setLastURI("/home");
		sesionController.removeRute("/home","/home1");
		assertFalse(sesionController.isPossible("/home1", sesion));
		sesionController.removeAllRutes("/noExist");
		sesionController.addRute("/home", "/home1");
		sesionController.removeAllRutes("/noExist");
		assertTrue(sesionController.isPossible("/home", sesion));
		assertTrue(sesionController.isPossible("/home1", sesion));
		sesion.setLastURI("/home");
		sesionController.removeAllRutes("/home");
		assertFalse(sesionController.isPossible("/home", sesion));
		assertFalse(sesionController.isPossible("/home1", sesion));
	}
	@Test
	void testSecSessionControllerMap() {
		SecSessionController sesionController = new SecSessionController();
		ArrayList<String> rutes = new ArrayList<String>();
		rutes.add("/home");
		rutes.add("/home1");
		rutes.add("/home2");
		sesionController.addRutes("/home", rutes);
		SecSession sesion = new SecSession("sesionUno","/home");
		assertTrue(sesionController.isPossible("/home", sesion));
		assertTrue(sesionController.isPossible("/home1", sesion));
		sesion.setLastURI("/home");
		assertTrue(sesionController.isPossible("/home2", sesion));
		sesion.setLastURI("/home");
		assertFalse(sesionController.isPossible("/home3", sesion));
		sesionController.removeAllRutes("/home");
		assertFalse(sesionController.isPossible("/home", sesion));
		assertFalse(sesionController.isPossible("/home1", sesion));
		sesionController.addRute("/home", "/home");
		sesionController.addRute("/home", "/home1");
		sesionController.addRute("/home", "/home2");
		assertTrue(sesionController.isPossible("/home", sesion));
		assertTrue(sesionController.isPossible("/home1", sesion));
		sesion.setLastURI("/home");
		assertTrue(sesionController.isPossible("/home2", sesion));
	}

}
