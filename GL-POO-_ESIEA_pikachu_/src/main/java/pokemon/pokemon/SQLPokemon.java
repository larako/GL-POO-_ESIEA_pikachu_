package pokemon.pokemon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLPokemon {

	public static ArrayList<String> getPokemonInfo(int id) {
		ArrayList<String> infoList = new ArrayList<String>();
		
		SQLManager sql = new SQLManager();
		ResultSet result = sql.query("SELECT * FROM pokemons WHERE id = " + id);
		
		try {
			while (result.next()) {
				//return result.getString("name");
				infoList.add(result.getString("name"));
				infoList.add(result.getString("sprite"));
				infoList.add(result.getString("attacks"));
				infoList.add(result.getString("hp"));
				infoList.add(result.getString("att"));
				infoList.add(result.getString("def"));
				infoList.add(result.getString("speed"));
				return infoList;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql.close();
		try {
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return infoList;
	}
	
	public static ArrayList<String> getAttackInfo(int id) {
ArrayList<String> infoList = new ArrayList<String>();
		
		SQLManager sql = new SQLManager();
		ResultSet result = sql.query("SELECT * FROM attacks WHERE id = " + id);
		
		try {
			while (result.next()) {
				infoList.add(result.getString("name"));
				infoList.add(result.getString("type"));
				infoList.add(result.getString("value"));
				infoList.add(result.getString("number"));
				return infoList;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql.close();
		try {
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return infoList;
	}
	
}
