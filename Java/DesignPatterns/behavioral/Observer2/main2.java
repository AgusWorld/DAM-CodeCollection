package Observer2;

import java.util.Scanner;

public class main2 {

	public static void main(String[] args) {
		Xat grupoWhatsapp=new Xat();
		Vigilancia policia1=new Vigilancia("viatjar");
		Vigilancia policia2=new Vigilancia("bitllet");
		Vigilancia policia3=new Vigilancia("cotxe");
		Vigilancia policia4=new Vigilancia("frontera");
		grupoWhatsapp.addPropertyChangeListener(policia1);
		grupoWhatsapp.addPropertyChangeListener(policia2);
		grupoWhatsapp.addPropertyChangeListener(policia3);
		grupoWhatsapp.addPropertyChangeListener(policia4);
		Scanner src=new Scanner(System.in);
		while(true) {
			grupoWhatsapp.setMissatgeEnviat(src.nextLine());
		}

	}

}
