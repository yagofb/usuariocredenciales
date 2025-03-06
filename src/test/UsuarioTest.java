package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.auth.Usuario;

class UsuarioTest {

	@Test
	void testModificarPassword() {
		Usuario paco = new Usuario("Paco", "chocolatero", "Hola1234");
		assertTrue(paco.modificarPassword("Hola1234", "Hola1234", "Adios1234", "Adios1234"));
		assertFalse(paco.modificarPassword("Hola1234", "Hola1234", "Adios1234", "Adios4321"));
		assertFalse(paco.modificarPassword("Hola1234", "Hola4321", "Adios1234", "Adios1234"));
		assertFalse(paco.modificarPassword("Hola1234", "Hola1234", "Hola1234", "Hola1234"));
		assertFalse(paco.modificarPassword("Hola4321", "Hola4321", "Hola4321", "Hola4321"));
	}

	
	@Test
	void testCreacionUsuarioConEmail() {
	    Usuario usuario = new Usuario("Paco", "chocolatero", "Paco@example.com", "987654");

	    assertNotNull(usuario);
	    assertEquals("Paco", usuario.getNombre());
	    assertEquals("chocolatero", usuario.getApellidos());
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
	   void testLoginFallaContraseñaIncorrecta() {
	       Usuario usuario = new Usuario("Paco", "chocolatero", "1234567A");

	       boolean resultado = usuario.hacerLogin("Paco chocolatero", "ContraseñaIncorrecta");

	       assertFalse(resultado, "El login tendria que ser posible porque es una contraseña incorrecta.");
	   }
	   
	   @Test
	   void testCuentaBloqueadaTresIntentosFallidos() {
	       Usuario usuario = new Usuario("Paco", "chocolatero", "1234567A");

	       usuario.hacerLogin("Paco chocolatero Perro", "Incorrecta1");
	       usuario.hacerLogin("Paco chocolatero", "Incorrecta2");
	       usuario.hacerLogin("Paco chocolatero", "Incorrecta3");

	       assertTrue(usuario.esCuentaBloqueada(), "La cuenta tendria que bloquearse tras tres intentos fallidos.");
	   }
	   
	   @Test
	   void testLoginDenegadoCuentaBloqueada() {
	       Usuario usuario = new Usuario("Paco", "chocolatero", "1234567A");

	       usuario.hacerLogin("Paco chocolatero", "Incorrecta1");
	       usuario.hacerLogin("Paco chocolatero", "Incorrecta2");
	       usuario.hacerLogin("Paco chocolatero", "Incorrecta3");

	       boolean resultado = usuario.hacerLogin("Paco chocolatero", "1234567A");

	       assertFalse(resultado, "No debería hacer el login si la cuenta está bloqueada.");
	   }
	   
}
