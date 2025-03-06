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

}
