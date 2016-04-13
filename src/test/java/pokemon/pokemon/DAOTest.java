package pokemon.pokemon;

import static junit.framework.Assert.assertTrue;

import org.junit.Test;

public class DAOTest {
	
	/*
	 * On vérifie que la 1ere boule tirée est bien un int positif 
	 */
	
	@Test
	public void testDAOboule1() {
		EuromillionDAO euro = new EuromillionDAO();
		assertTrue(euro.boule1Aleatoire() > -1);
	}
	
	/*
	 * On vérifie que la 2eme boule tirée est bien un int positif 
	 */
	
	@Test
	public void testDAOboule2() {
		EuromillionDAO euro = new EuromillionDAO();
		assertTrue(euro.boule2Aleatoire() > -1);
	}
	
}
