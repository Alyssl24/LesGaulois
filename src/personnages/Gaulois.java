package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement [] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "«" + texte + "»");
	}
	
	
	private String prendreParole() {
		return ("Le gaulois " + nom + " : ");
	}
		
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement [] lesTrophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; lesTrophees != null && i < lesTrophees.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = lesTrophees[i];
		}
	}

	
	public void boirePotion(int forcePotion) {
		effetPotion *= forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée.");
	}
	
	
	public void faireUneDonnation(Gaulois gaulois, Musee musee) {
		parler("Je donne au musee tous mes trophees:");
		for (int i = 0; i < nbTrophees; i++) {
			System.out.println(trophees[i]);
			musee.donnerTrophees(gaulois, trophees[i]);
		}
		nbTrophees = 0;
	}
	
	
	public static void main(String[] args) {
		Gaulois gertrude = new Gaulois ("Gertrude", 8);
		gertrude.faireUneDonnation(gertrude, );
	}


}
