package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Wandeling {
	private int wandelingId;
	private List<Hond> honden = new ArrayList<>();
	private LocalDate uitlaatDatum;
	private double duur;
	private Medewerker uitlaatMedewerker;


	public Wandeling(int wandelingId, LocalDate uitlaatDatum, double duur, Medewerker uitlaatMedewerker) {
		this.wandelingId = wandelingId;
		this.uitlaatDatum = uitlaatDatum;
		this.duur = duur;
		this.uitlaatMedewerker = uitlaatMedewerker;
	}

	public Wandeling(LocalDate uitlaatDatum, double duur, Medewerker uitlaatMedewerker) {
		this(0, uitlaatDatum, duur, uitlaatMedewerker);
	}

	public List<Hond> getHonden() {
		return honden;
	}

	public void setHonden(List<Hond> honden) {
		this.honden = honden;
	}

	public int getWandelingId() {
		return wandelingId;
	}

	public void setWandelingId(int wandelingId) {
		this.wandelingId = wandelingId;
	}

	public LocalDate getUitlaatDatum() {
		return uitlaatDatum;
	}

	public double getDuur() {
		return duur;
	}

	public Medewerker getUitlaatMedewerker() {
		return uitlaatMedewerker;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Wandeling " + wandelingId + " op ");
		result.append(uitlaatDatum.toString());
		result.append(" van ").append(duur).append(" uur\n");
		result.append(uitlaatMedewerker.toString());
		result.append("\nHonden:\n");
		for (Hond hond: honden) {
			result.append(hond).append("\n");
		}
		return result.toString();
	}
}
