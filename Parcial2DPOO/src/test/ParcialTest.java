package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import Parcial.Parcial;

public class ParcialTest {
	@Test
	public void TestExponenteNegativo () {
		try {
            Parcial.potencia(5, -1);
            fail("Se esperaba una excepción");
        } catch (IllegalArgumentException e) {
            assertEquals("El exponente no puede ser negativo. (Daria un decimal y no seria entero)", e.getMessage());
        }
		try {
            Parcial.potencia(7, -2);
            fail("Se esperaba una excepción");
        } catch (IllegalArgumentException e) {
            assertEquals("El exponente no puede ser negativo. (Daria un decimal y no seria entero)", e.getMessage());
        }
    }
	
	@Test
	public void TestBaseExponenteCero () {
		try {
            Parcial.potencia(0, 0);
            fail("Se esperaba una excepción");
        } catch (IllegalArgumentException e) {
            assertEquals("0^0 es una indeterminación.", e.getMessage());
        }
	}
	
	@Test
	public void TestExponenteCeroValido () {
	        assertEquals(1, Parcial.potencia(5, 0));
	        assertEquals(1, Parcial.potencia(-5, 0));
	        assertEquals(1, Parcial.potencia(1, 0));
	    }
	
	@Test
    public void testPotenciaBasica() {
        assertEquals(8, Parcial.potencia(2, 3));
        assertEquals(25, Parcial.potencia(5, 2));
        assertEquals(1, Parcial.potencia(1, 10));
        assertEquals(0, Parcial.potencia(0, 5));
    }
	
	@Test
    public void testBaseNegativa() {
        assertEquals(-8, Parcial.potencia(-2, 3));
        assertEquals(16, Parcial.potencia(-2, 4)); 
        assertEquals(-1, Parcial.potencia(-1, 1));
        assertEquals(1, Parcial.potencia(-1,8));
    }
	
	@Test
	public void testDesbordamiente() {
		try {
			Parcial.potencia(2, 45);
            fail("Se esperaba una excepción");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("excede el valor máximo de un entero"));
        }
        
        try {
        	Parcial.potencia(100, 11);
            fail("Se esperaba una excepción");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("excede el valor máximo de un entero"));
        }
        try {
        	Parcial.potencia(-2, 45);
            fail("Se esperaba una excepción");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("excede el valor máximo de un entero"));
        }
        
        try {
        	Parcial.potencia(-100, 11);
            fail("Se esperaba una excepción por overflow");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("excede el valor máximo de un entero"));
        }
	}
	
	@Test
    public void testBaseCero() {
        assertEquals(0, Parcial.potencia(0, 1));
        assertEquals(0, Parcial.potencia(0, 5));
        assertEquals(0, Parcial.potencia(0, Integer.MAX_VALUE));
    }
}

