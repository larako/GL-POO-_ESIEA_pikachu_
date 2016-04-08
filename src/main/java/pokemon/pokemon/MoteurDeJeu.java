package pokemon.pokemon;

import java.util.Random;

public class MoteurDeJeu {

	public Pokemon joueur;
	public Pokemon IA;
	public static Pokemon start;
	public static Pokemon turn;
	private int boule1, boule2;
	private int pokemonID1, pokemonID2;
	private Attack a;
	private Attack IAattack;
	public boolean gameOver = false;

	public MoteurDeJeu(Pokemon pokemon1, Pokemon pokemon2) {

		this.joueur = pokemon1;
		this.IA = pokemon2;
		// System.out.println(joueur);
		start = whoStart();

	}

	public boolean RapportSpeed() {
		double result = 0;
		result = (double) joueur.getSpeed() / IA.getSpeed();
		Random r = new Random();
		int random = (int) r.nextInt(10);
		// System.out.println("random: "+random);
		if (random < result)
			return true;
		else
			return false;
	}

	public Attack IARandomAttack() {
		Random r = new Random();
		int random = (int) r.nextInt(4);
		return IA.getAtta().get(random);
	}

	public void attaquer(Attack chosen, Pokemon pok1, Pokemon pok2) {
		
		// int division= ( 42*chosen.getValue()*pok2.getAtt() ) /
		// (pok1.getDef()*50);
           System.out.println("valeur de l'attaque " + chosen.getValue());
		if (chosen.getValue()>0) {
			int somme = (chosen.getValue() * pok2.getAtt()) / (pok1.getDef() * 50);

			/*
			 * if(division<1) somme= Math.abs(division*10+pok2.getAtt()%20);
			 * 
			 * else somme=Math.abs(division-pok2.getAtt()%20);
			 */

			chosen.setPp(chosen.getPp() - 1);
			int hp = pok2.getHp();
			pok2.setHp(hp - somme);

			if (pok2.getHp() <= 0) {
				gameOver = true;
				System.out.println("GAME OVER - " + pok1.getName()
						+ " win and " + pok2.getName() + " lose");

			}

		}

		else {
			Random r = new Random();
			int random = (int) r.nextInt(100);
			int resultat = random % 3 ;
			chosen.setPp(chosen.getPp() - 1);
			if(resultat==0) pok2.setAtt( (int) ((int) pok2.getAtt()*0.80));
			else if(resultat==1) pok2.setDef((int) ((int) pok2.getDef()*0.80));
			else pok2.setSpeed((int) ((int) pok2.getSpeed()*0.80));			
			
		}
	}

	public boolean gameOver() {
		return this.gameOver;
	}

	public void choiceAttaque(Attack a) {
		this.a = a;
		if (a.getPp() <= 0) {
			System.out
					.println("L'attaque n'est plus disponible! Veuillez rechoisir une attaque.");
		} else {
			JoueurPlay();
		}
	}

	public Pokemon whoStart() {
		boolean startI;
		Pokemon startP;
		/* pokemon qui commence */

		startI = RapportSpeed();
		if (startI)
			startP = joueur;
		else
			startP = IA;

		System.out.println("Pokemon start " + startP);
		turn = startP;
		if (startP == IA)
			JoueurPlay();
		return startP;

	}

	public void JoueurPlay() {

		if (turn == joueur) {

			// System.out.println("Voici les différentes attaques. Choisissez en une");
			// System.out.println(joueur.getAttacks());
			System.out.println("Vous avez Choisi" + a);
			attaquer(a, joueur, IA);
			System.out.println("HP de l'IA: " + IA.getHp());
			turn = IA;
			if (gameOver())
				return;
			JoueurPlay();
		}

		else {
			try {
				Thread.sleep(1000); // 1000 milliseconds is one second.
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			IAattack = IARandomAttack();
			attaquer(IAattack, IA, joueur);
			System.out.println("HP de joueur: " + joueur.getHp()
					+ " avec l'attaque: " + IAattack);
			if (gameOver())
				return;
			turn = joueur;
		}
	}

}
