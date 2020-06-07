package entities;

import org.javatuples.Pair;

public class PracticaValores {

	Pair limites;
	
	public PracticaValores(Object min, Object max) {
		limites.add(min, max);
	}
	
	public Pair getLimites() {
		return limites;
	}

	public void setLimites(Pair limites) {
		this.limites = limites;
	}
	
}
