package model;

public class Klant {
	private int klantnummer;
	private String voorletters;
	private String tussenvoegsel;
	private String achternaam;
	private String telefoon;


	public Klant(int klantnummer, String voorletters, String tussenvoegsel, String achternaam, String telefoon) {
		this.klantnummer = klantnummer;
		this.voorletters = voorletters;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.telefoon = telefoon;
	}

	public Klant(String voorletters, String tussenvoegsel, String achternaam, String telefoon) {
		this(0, voorletters, tussenvoegsel, achternaam, telefoon);
	}
	
	public int getKlantnummer() {
		return klantnummer;
	}

	public void setKlantnummer(int klantnummer) {
		this.klantnummer = klantnummer;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getVoorletters() {
		return voorletters;
	}

	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}

	public String getTelefoon() {
		return telefoon;
	}

	public void setTelefoon(String telefoon) {
		this.telefoon = telefoon;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Klant ");
		result.append(klantnummer).append(" - ");
		result.append(voorletters).append(" ");
		if (tussenvoegsel != null) {
			result.append(tussenvoegsel).append(" ");
		}
		result.append(achternaam).append(" ");
		result.append(telefoon);
		return result.toString();
	}
}
