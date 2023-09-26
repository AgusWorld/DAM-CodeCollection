package DivideSchoolMConductor;

public class Conductor extends Thread {
	float tempoMet;

	Conductor(int tempo) {
		tempoMet=tempo;
	}

	public void run() {
		float tempoS=tempoMet/60;//cuantos tempos tengo por segundo
		float tiempo=1000/tempoS;//cuanto dura cada tempo
		tiempo=tiempo/16;//cuanto dura 1 semifusa

		try {
			while (true) {
				Thread.sleep((long) tiempo);

				synchronized (this) {
					this.notifyAll();
				}
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
