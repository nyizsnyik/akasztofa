/**
 * 
 * @author nyizsnyik
 *
 */

package akasztofa;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Akasztófa játék 8. rossz tippnél vége.
 */
public class Akasztofa {

	private static Logger logger = LoggerFactory.getLogger(Akasztofa.class);

	/**
	 * Ebből a String tömbből választ feladványt a gép.
	 */
	private static String[] szavak = { "INTEL", "ECLIPSE", "MAVEN", "JAVA",
			"AKASZTÓFA", "GIT", "TANKCSAPDA", "KARTHAGO", "PUF", "METALLICA",
			"SUPERNEM" };

	private static char[] megfkar = "QWERTZUIOPŐÚŰÓÜÖÁÉLKJHGFDSAÍYXCVBNM"
			.toCharArray();
	/**
	 * Scanner object-um ennek segitségével olvasok be karaktereket a standard
	 * input-ról.
	 */
	private static Scanner sc;

	/**
	 * A metódus eldönti hogy benne van e a paraméterként kapott karakter a
	 * paraméterként kapott char tömbben.
	 * 
	 * @param c az a karakter amit keresünk a <code>ct</code> tömbben
	 * @param ct az a char tömb amiben keressük a <code>c</code> karaktert
	 * @return <code>true</code> ha benne van <code>false</code> ha nincs benne
	 */
	public static boolean bennevane(char c, char[] ct) {
		logger.debug("Metódus meghívás megtörtént");
		for (int i = 0; i < ct.length; i++)
			if (c == ct[i])
				return true;
		return false;
	}

	/**
	 * A metódus kiírja a paraméterként kapott char tömb tartalmát.
	 * 
	 * @param ct ennek a tömbnek a tartalmát iratja ki
	 */
	public static void kiir(char[] ct) {
		logger.debug("Metódus meghívás megtörtént");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ct.length; i++) {
			sb.append(ct[i]);
			if (i + 1 != ct.length)
				sb.append(' ');
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		logger.debug("main elindult");
		int nemnyert = 0;
		int maxhiba = 8;
		char[] voltmar = new char[maxhiba];
		char[] szo = szavak[(int) ((Math.random() * 10000) % szavak.length)].toCharArray();
		char[] megoldas = new char[szo.length];
		for (int i = 0; i < szo.length; i++)
			megoldas[i] = '_';
		char[] betu;

		sc = new Scanner(System.in);
		while (nemnyert < maxhiba && bennevane('_', megoldas)) {

			System.out.print("Amik már voltak és nem talált: ");
			kiir(voltmar);
			System.out.print("Feladvány: ");
			kiir(megoldas);
			System.out.print("Tipp: ");
			betu = sc.next().toUpperCase().toCharArray();
			logger.debug("Beolvasás megvolt");
			
			while (!bennevane(betu[0], megfkar) || bennevane(betu[0], voltmar) || bennevane(betu[0], megoldas)) {
				if (!bennevane(betu[0], megfkar)) {
					System.out.print("Nem érvényes karakter kéren adjon meg másikat: ");
					betu = sc.next().toUpperCase().toCharArray();
				}

				if (bennevane(betu[0], voltmar) || bennevane(betu[0], megoldas)) {
					System.out.print("Volt már adjon meg másik betüt: ");
					betu = sc.next().toUpperCase().toCharArray();
				}
			}
			logger.debug("Tipp vizsgálat megvolt.");
			for (int i = 0; i < szo.length; i++) 
				if (betu[0] == szo[i]) 
					megoldas[i] = betu[0];
			
			if (!bennevane(betu[0], szo))
				voltmar[nemnyert++] = betu[0];
			logger.debug("Töbmok frissitése megtörtént.");
		}
		if (!bennevane('_', megoldas)) {
			kiir(megoldas);
			System.out.println("Gratulálok ön nyert!!!!!!4444négy :D");
		} else {
			System.out.println("Sajnos ön vesztett!!! :(");
			System.out.print("A helyes megfejtés: ");
			kiir(szo);
		}
	}
}
