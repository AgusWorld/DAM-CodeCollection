package FactoryMethod;

public class TargetaDebit implements Targeta {
	int codi;
	
	public TargetaDebit(int c) {
		super();
		codi = c;
	}
	
	@Override
	public int getCodi() {
		return codi;
	}

	@Override
	public String toString() {
		return "TargetaDebit [codi=" + codi + "]";
	}

}
