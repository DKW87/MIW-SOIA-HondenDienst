package controller;

import database.HondDAO;
import database.KlantDAO;
import database.DBaccess;
import model.Hond;
import model.Klant;
import java.util.List;

public class HondenDienstLauncher {
	
	public static void main(String[] args) {
		// Stap 1: Connectie testen
		DBaccess dBaccess =  new DBaccess("HondenDienst", "userHondenDienst", "pwHondenDienst");
		KlantDAO klantDAO = new KlantDAO(dBaccess);
		dBaccess.openConnection();
		List<Klant> klantenLijst = klantDAO.getKlanten();
		for (Klant klant : klantenLijst) {
			System.out.println(klant);
		}

//		 Stap 2: KlantDAO testen, klant opslaan
//		System.out.println("Testen van klantDAO methods: ");
//		klantDAO.slaKlantOp(new Klant("O.B.", null, "Bommel", "098712345"));

		// Stap 2: Klant ophalen
		Klant klant2 = klantDAO.getKlantPerId(1);
		System.out.println("Klant ophalen: " + klant2);
		System.out.println();


		// Stap 3: HondDAO testen, hond opslaan
		HondDAO hondDAO = new HondDAO(dBaccess);
//		System.out.println();
//		System.out.println("Testen van hondDAO methodes: ");
		Hond seda = new Hond("50-361-0", "Seda", "Zwitserse Herder", klant2);
//		hondDAO.slaHondOp(seda);

		// Stap 3: hond ophalen, verkeerd en goed chipnummer
		Hond hond3 = hondDAO.getHondPerId("x69");
		if (hond3 == null) {
			System.out.println("Hond met dit chipnummer bestaan niet");
		} else {
			System.out.println("Hond uit database: " + hond3);
		}

		Hond sedaUitDatabase = hondDAO.getHondPerId("50-361-0");
		System.out.println("Seda zit in de database: " + sedaUitDatabase);

		List<Hond> hondenLijst = hondDAO.getHondenPerKlant(klant2);
		System.out.println();

		// Stap 3: honden van klant ophalen
		System.out.println("Hond(en) van klant " + klant2.getAchternaam() + " ophalen");
		for (Hond hond : hondenLijst) {
			System.out.println(hond);
		}
		System.out.println();

		// Stap 3: alle honden ophalen
		System.out.println("Alle honden ophalen: ");
		hondenLijst = hondDAO.getHonden();
		for (Hond hond : hondenLijst) {
			System.out.println(hond);
		}

		// Tussenstap: MedewerkerDAO testen
//		MedewerkerDAO medewerkerDAO = new MedewerkerDAO(dBaccess);
//		System.out.println();
//		System.out.println("Testen van medewerkerDAO methods: ");
//		Medewerker medewerkerJC = medewerkerDAO.getMedewerkerPerId("JC");
//		System.out.println("Medewerker ophalen: " + medewerkerJC);

		// Stap 4: WandelingDAO testen, wandeling zonder honden opslaan
//		WandelingDAO wandelingDAO = new WandelingDAO(dBaccess);
//		Wandeling wandelingJC1 = new Wandeling(LocalDate.now(), 2.5, medewerkerJC);
//		wandelingDAO.slaWandelingOp(wandelingJC1);
//		System.out.println();

		// Stap 5: HondInWandelingDAO testen, honden van de wandeling opslaan
//		HondInWandelingDAO hondInWandelingDAO = new HondInWandelingDAO(dBaccess);
//		wandelingJC1.getHonden().add(hondDAO.getHondPerId("47-674-0"));
//		wandelingJC1.getHonden().add(hondDAO.getHondPerId("48-335-5"));
//		hondInWandelingDAO.slaHondenInWandelingOp(wandelingJC1);

		// Stap 5: WandelingDAO testen, wandeling met honden opslaan
//		Wandeling wandelingJC2 = new Wandeling(LocalDate.now(), 3, medewerkerJC);
//		wandelingJC2.getHonden().add(hondDAO.getHondPerId("48-986-0"));
//		wandelingJC2.getHonden().add(hondDAO.getHondPerId("48-345-5"));
//		wandelingDAO.slaWandelingOp(wandelingJC2);

		// Stap 5: WandelingDAO testen, honden in wandeling ophalen
//		List<Hond> honden = hondInWandelingDAO.getHondenPerWandeling(wandelingJC2);
//		for (Hond hond: honden){
//			System.out.println(hond);
//		}

		// Stap 6: WandelingDAO testen, wandeling met honden ophalen
//		System.out.println();
//		System.out.println("Wandelingen van Medewerker ophalen: ");
//		List<Wandeling> wandelingenLijstMedewerker = wandelingDAO.getWandelingenPerMedewerker(medewerkerJC);
//		for (Wandeling wandeling : wandelingenLijstMedewerker) {
//			System.out.println(wandeling);
//		}
		dBaccess.closeConnection();
	}
}
