package Parcial;
import static org.junit.Assert.*;
import org.junit.Test;

public class Parcial {
		public static int potencia(int b, int e) {
		    if (e < 0) {
		        throw new IllegalArgumentException("El exponente no puede ser negativo. (Daria un decimal y no seria entero)");
		    }
		    if (b == 0 && e == 0) {
		        throw new IllegalArgumentException("0^0 es una indeterminación.");
		    }
		    if (b!=0 && e == 0) {
	            return 1;
	        }
		    if (b==0 && e!= 0) {
		    	return 0;
		    }

		    int resultado = 1;

		    for (int i = 0; i < e; i++) {
		        if (b != 0 && Math.abs(resultado) > Integer.MAX_VALUE / Math.abs(b)) {
		            throw new IllegalArgumentException("El resultado de " + b + "^" + e + " excede el valor máximo de un entero.");
		        }
		        resultado *= b;
		    }

		    return resultado;
		}
}

