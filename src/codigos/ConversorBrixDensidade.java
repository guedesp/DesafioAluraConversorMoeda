package codigos;

public class ConversorBrixDensidade {

	public double calculabrix(Double valor) {
		return ((valor / (258.6 - ((valor / 258.2) * 227.1))) + 1);
		
	}
}
