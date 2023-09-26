package Decorator2;

public class Test2 {

	public static void main(String[] args) {
		System.out.println("Creant formes simples...");
		Forma rombe1 = new Rombe();
		Forma pentagon1 = new Pentagon();

		System.out.println("Dibuixant formes simples...");
		rombe1.dibuixar();
		System.out.println();
		pentagon1.dibuixar();
		System.out.println();

		System.out
				.println("Creant un pentagon decorat amb color Aqua, línies de guions de color Lime i gruix de 2 ...");

		Forma pentagon2 = new ColorEmplenamentDecorator(new ColorLiniaDecorator(
				new EstilLiniaDecorator(new GruixLiniaDecorator(new Pentagon(), 2.0d), TipusLinia.GUIONS), Color.LIME),
				Color.AQUA);
		pentagon2.dibuixar();
		System.out.println();
		System.out.println("creant un objecte amb funcionalitats similars però amb diverses linies de codi.");
		Pentagon pentagon3 = new Pentagon();
		GruixLiniaDecorator lt = new GruixLiniaDecorator(pentagon3, 2.0d);
		EstilLiniaDecorator ls = new EstilLiniaDecorator(lt, TipusLinia.GUIONS);
		ColorLiniaDecorator lc = new ColorLiniaDecorator(ls, Color.LIME);
		ColorEmplenamentDecorator fc = new ColorEmplenamentDecorator(lc, Color.AQUA);
		Forma pentagon4 = fc;
		pentagon4.dibuixar();
		System.out.println();

		System.out.println("Creant un pentagon decorat de color cyan amb linies fuchsia ...");
		Forma pentagon5 = new ColorEmplenamentDecorator(new ColorLiniaDecorator(new Pentagon(), Color.FUCHSIA),
				Color.CYAN);
		pentagon5.dibuixar();
		System.out.println();

		System.out.println("Creant d'un rombe decorat de color yellow amb línies de doble guions de color aqua...");
		Forma rombe2 = new ColorEmplenamentDecorator(new ColorLiniaDecorator(new Rombe(), Color.AQUA), Color.YELLOW);
		rombe2.dibuixar();
		System.out.println();
	}

}
