package model;

public class Hond {
	private String chipnummer;
	private String naam;
	private String ras;
	private Klant eigenaar;

	public Hond(String chipnummer, String naam, String ras, Klant eigenaar) {
		this.chipnummer = chipnummer;
		this.naam = naam;
		this.ras = ras;
		this.eigenaar = eigenaar;
	}

	public String getChipnummer() {
		return this.chipnummer;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public String getRas() {
		return ras;
	}

	public void setRas(String ras) {
		this.ras = ras;
	}

	public Klant getEigenaar() {
		return eigenaar;
	}

	public void setEigenaar(Klant eigenaar) {
		this.eigenaar = eigenaar;
	}

	public void setChipnummer(String chipnummer) {
		this.chipnummer = chipnummer;
	}

	@Override
	public String toString() {
		return String.format("Hond %s - %s, bezit van %s", this.chipnummer, this.naam, eigenaar);
	}
	
}
