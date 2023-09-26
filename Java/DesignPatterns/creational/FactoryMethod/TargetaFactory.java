package FactoryMethod;

import java.util.Random;

public class TargetaFactory {
	public Targeta getTargeta(Client c) {
		if (c.getTargeta() == null) {
			if (c.Salari > 425) {
				return new TargetaCredit(GenerarNum());
			} else if (c.Salari > 0) {
				return new TargetaDebit(GenerarNum());
			} else {
				System.out.println("Salari insuficient!");
				return null;
			}
		}else {
			System.out.println("Ja tens associada una targeta");
			return null;
		}

	}

	public int GenerarNum() {
		return new Random().nextInt(10000000, 99999999);
	}

}
