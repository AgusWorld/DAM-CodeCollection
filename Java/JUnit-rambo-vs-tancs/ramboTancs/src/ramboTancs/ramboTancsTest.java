package ramboTancs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ramboTancsTest {
	@Test
	public void testPublic() {
		assertEquals("Tancs impactats: 3", ramboTancs.elprograma("XOHHH", "OOHHH", "HHHHH", "HHHHH", "HHHHH"));
		assertEquals("Tancs impactats: 8", ramboTancs.elprograma("HHHHH", "HOOOH", "HOXOH", "HOOOH", "HHHHH"));
		assertEquals("Tancs impactats: 0", ramboTancs.elprograma("OOOOO", "OHHHO", "OHXHO", "OHHHO", "OOOOO"));
	}
	
	@Test
	public void testPrivat() {
		assertEquals("Tancs impactats: 0", ramboTancs.elprograma("HHHHH", "HHHHH", "HHXHH", "HHHHH", "HHHHH"));
		assertEquals("Tancs impactats: 8", ramboTancs.elprograma("OOOOO", "OOOOO", "OOXOO", "OOOOO", "OOOOO"));
		assertEquals("Tancs impactats: 0", ramboTancs.elprograma("HHHHH", "HHHHH", "HHHHH", "HHHHH", "HHHHH"));
	}
} 
