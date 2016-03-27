package pokemon.pokemon;




public class Euromillion{

	private String date;
	private int boule1;
	private int boule2;
	private int boule3;
	private int boule4;
	private int boule5;
	private int etoile1;
	private int etoile2;
	
	public Euromillion(String date,int boule1,int boule2,int boule3,int boule4,int boule5,int etoile1,int etoile2){
		this.date=date;
		this.boule1=boule1;
		this.boule2=boule2;
		this.boule3=boule3;
		this.boule4=boule4;
		this.boule5=boule5;
		this.etoile1=etoile1;
		this.etoile2=etoile2;
		
	}
	
	public int getBoule1(){
		return boule1;
	}
	public int getBoule2(){
		return boule2;
	}
	public int getBoule3(){
		return boule3;
	}
	public int getBoule4(){
		return boule4;
	}
	public int getBoule5(){
		return boule5;
	}
	public int getEtoile1(){
		return etoile1;
	}
	public int getEtoile2(){
		return etoile2;
	}



}



