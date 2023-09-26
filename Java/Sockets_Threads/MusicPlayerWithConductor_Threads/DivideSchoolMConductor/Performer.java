package DivideSchoolMConductor;

import javax.sound.midi.Instrument;

public class Performer implements Runnable {
	Note[] partitura;
	Conductor conductor;
	int instrumento;

	Performer(Note[] notesRythm, Conductor con) {
		partitura = notesRythm;
		conductor = con;
	}

	@Override
	public   void run() {
		for (int i = 0; i < partitura.length; i++) {
			MidiPlayer.play( partitura[i]);

			for (int x = 0; x < partitura[i].getDuration(); x++) {
				synchronized (conductor) {
					try {
						conductor.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
			MidiPlayer.stop(0, partitura[i]);
		}
	}

}
