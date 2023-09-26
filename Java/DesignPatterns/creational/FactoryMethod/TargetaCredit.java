package FactoryMethod;



public class TargetaCredit implements Targeta{
	@Override
	public String toString() {
		return "TargetaCredit [codi=" + codi + "]";
	}

	int codi;
	
	public TargetaCredit(int c) {
		super();
		codi = c;
	}

	@Override
	public int getCodi() {
		return codi;
	}

}
