package pokemon.pokemon;
import java.sql.*;

public class SQLManager {
	
	private Connection c = null;
    private Statement s = null;
	
	/*
	 * Méthode pour se connecter à la base de données
	 * Retourne l'objet nous permettant de faire des requêtes
	 * SQL sur la BDD
	 */
	public SQLManager() {
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:pokemon.db");
          s = c.createStatement();
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
	}
	
	/*
	 * Ferme la connexion avec la BDD
	 */
	public void close() {
        try {
            c.close();
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	/*
	 * Execute une requête de type SELECT
	 * Retourne le résultat de la requête
	 */
	public ResultSet query(String req) {
	   ResultSet r = null;
	   try {
	       r = s.executeQuery(req);
	   } catch (SQLException e) {
	       e.printStackTrace();
	       System.out.println("Erreur dans la requete SQL : " + req);
	   }
	   return r;
	 
	}

	
	
}
