package pokemon.pokemon;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class MoteurDeJeuTest {
	
	/*
	 * Test qui vérifie que l'attaque générée existe bien
	 */

	@Test
	public void testRandomAttack() {
		// salameche, vitesse = 30
		Pokemon poke1 = new Pokemon(1);
		// salameche, vitesse = 56
		Pokemon poke2 = new Pokemon(2);
		MoteurDeJeu moteur = new MoteurDeJeu(poke1, poke2);
		Attack a = moteur.IARandomAttack();
		assertNotNull(a);
	}
	
	/*
	 * Test d'émulation d'une attaque
	 * 
	 */

	@Test
	public void testAttack() {
		// salameche, vitesse = 30
		Pokemon poke1 = new Pokemon(1);
		// salameche, vitesse = 56
		Pokemon poke2 = new Pokemon(2);
		MoteurDeJeu moteur = new MoteurDeJeu(poke1, poke2);
		moteur.attaquer(poke1.getAtta().get(0), poke1, poke2);
		assertEquals(poke2.getHp(), 32);
		
	}
	
	/*
	 * Test combat, le 2eme pokemon doit avoir 0 HP
	 */
	@Test
	public void testFight() {
		// salameche, vitesse = 30
		Pokemon poke1 = new Pokemon(1);
		// salameche, vitesse = 56
		Pokemon poke2 = new Pokemon(2);
		MoteurDeJeu moteur = new MoteurDeJeu(poke1, poke2);
		for (int i = 0; i < 5; i++)
			moteur.attaquer(poke1.getAtta().get(0), poke1, poke2);
		assertEquals(poke2.getHp(), 0);
		
	}
	
	@Test
	public void testGameOver() {
		// salameche, vitesse = 30
		Pokemon poke1 = new Pokemon(1);
		// salameche, vitesse = 56
		Pokemon poke2 = new Pokemon(2);
		MoteurDeJeu moteur = new MoteurDeJeu(poke1, poke2);
		for (int i = 0; i < 5; i++)
			moteur.attaquer(poke1.getAtta().get(0), poke1, poke2);
		assertTrue(moteur.gameOver());
		
	}
	
}
