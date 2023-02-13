package model;

public class Medewerker {
	private String medewerkerCode;
	private String voornaam;
	private String achternaam;
	private int startjaar;

	public Medewerker(String medewerkerCode, String voornaam, String achternaam, int startjaar) {
		this.medewerkerCode = medewerkerCode;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.startjaar = startjaar;
	}

	public String getMedewerkerCode() {
		return medewerkerCode;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public int getStartjaar() {
		return startjaar;
	}

	@Override
	public String toString() {
		return String.format("Medewerker %s - %s", medewerkerCode, voornaam);
	}
}
