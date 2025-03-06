package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.auth.Usuario;

class UsuarioTest {

	@Test
	void testModificarPassword() {
		Usuario paco = new Usuario("Paco", "Martinez", "Hola1234");
		assertTrue(paco.modificarPassword("Hola1234", "Hola1234", "Adios1234", "Adios1234"));
		assertFalse(paco.modificarPassword("Hola1234", "Hola1234", "Adios1234", "Adios4321"));
		assertFalse(paco.modificarPassword("Hola1234", "Hola4321", "Adios1234", "Adios1234"));
		assertFalse(paco.modificarPassword("Hola1234", "Hola1234", "Hola1234", "Hola1234"));
		assertFalse(paco.modificarPassword("Hola4321", "Hola4321", "Hola4321", "Hola4321"));
	}

	
	@Test
	void testCreacionUsuarioConEmail() {
	    Usuario usuario = new Usuario("Paco", "Martinez", "Paco@example.com", "987654");

	    assertNotNull(usuario);
	    assertEquals("Paco", usuario.getNombre());
	    assertEquals("Martinez", usuario.getApellidos());
	    assertEquals("Paco@example.com", usuario.getEmail());
	}
	
	
	

	   @Test
	   void testCreacionUsuarioSinEmail() {
	        Usuario usuario = new Usuario("Paco", "chocolatero", "1234567A");

	        assertNotNull(usuario);
	        assertEquals("Paco", usuario.getNombre());
	        assertEquals("chocolatero", usuario.getApellidos());
	    }
	
	   @Test
	   void testLoginBien() {
	       Usuario usuario = new Usuario("Paco", "chocolatero", "1234567A");

	       boolean resultado = usuario.hacerLogin("Paco Chocolatero", "1234567A");

	       assertTrue(resultado, "El login tendria que ser exitoso con las credenciales correctas.");
	   }
	
}
