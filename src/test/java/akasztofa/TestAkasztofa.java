package akasztofa;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAkasztofa {

	@Test
	public void testbennevane() {
		char[] ct = "alma".toCharArray();
		assertEquals(Akasztofa.bennevane('a', ct), true);
	}

	@Test
	public void testnbennevane2() {
		char[] ct = "alma".toCharArray();
		assertEquals(Akasztofa.bennevane('c', ct), false);
	}

	@Test
	public void testbennevane3() {
		char[] ct = "alma".toCharArray();
		assertEquals(Akasztofa.bennevane('A', ct), false);
	}

	@Test
	public void testbennevane4() {
		char[] ct = "Alma".toCharArray();
		assertEquals(Akasztofa.bennevane('A', ct), true);
	}
}
