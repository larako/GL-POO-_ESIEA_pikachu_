package pokemon.pokemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class EuromillionDAO {
	
    private final static String ELEVES_FILE_NAME = "euromillions_3.csv";
    private final static char SEPARATOR = ';';
	public int rand=(int) (Math.random()*221+2);
	public int compteur=0;
	public int boule1;
	public int boule2;
    
	public List<Euromillion> findEurom(){

		final List<String[] > data = new ArrayList<String[] >();

        try {
            final File file = new File(ELEVES_FILE_NAME);
            final FileReader fr = new FileReader(file);

            final CSVReader csvReader = new CSVReader(fr, SEPARATOR);

            String[] nextLine = null;
            while ((nextLine = csvReader.readNext()) != null) {
                final int size = nextLine.length;

                // ligne vide
                if (size == 0) {
                    continue;
                }
                final String debut = nextLine[0].trim();
                if (debut.length() == 0 && size == 1) {
                    continue;
                }

                // ligne de commentaire
                if (debut.startsWith("#")) {
                    continue;
                }
  
                data.add(nextLine);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        List<Euromillion> eurom = new ArrayList<Euromillion>();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (String[] oneData : data) {
            String date = oneData[0];
            String Sboule1 = oneData[4];
            String Sboule2 = oneData[5];
            String Sboule3 = oneData[6];
            String Sboule4 = oneData[7];
            String Sboule5 = oneData[8];
            String Setoile1 = oneData[9];
            String Setoile2= oneData[10];

            Integer boule1 = Integer.parseInt(Sboule1);
            Integer boule2 = Integer.parseInt(Sboule2);
            Integer boule3 = Integer.parseInt(Sboule3);
            Integer boule4 = Integer.parseInt(Sboule4);
            Integer boule5 = Integer.parseInt(Sboule5);
            Integer etoile1 = Integer.parseInt(Setoile1);
            Integer etoile2 = Integer.parseInt(Setoile2);
          //  Date date = dateFormat.parse(Sdate);

            Euromillion Eurom = new Euromillion(date,boule1,boule2,boule3,boule4,boule5,etoile1,etoile2);
            eurom.add(Eurom);
            
        }

        return eurom;
	}
	
	public int boule1Aleatoire(){
		List<Euromillion> boules=findEurom();
		compteur=0;
		for (Euromillion b: boules){
			compteur++;
			if (compteur==rand){ //des que le compteur est egal au nombre aléatoire choisit alors on recupere la boule
				boule1=b.getBoule1();
			}
			//System.out.println(b.getBoule1()); //pour acceder a la boule1
		}
		return boule1;	
	}
	
	public int boule2Aleatoire(){
		compteur=0;
		List<Euromillion> boules=findEurom();
		for (Euromillion b: boules){
			compteur++;
			if (compteur==rand){ //des que le compteur est egal au nombre aléatoire choisit alors on recupere la boule
				boule2=b.getBoule2();
			}
			//System.out.println(b.getBoule2()); //pour acceder a la boule1
		}
		//System.out.println("test:"+boule2);
		return boule2;	
	}

}
