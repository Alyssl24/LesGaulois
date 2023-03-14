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
		Equipement[] lesTrophees = romain.recevoirCoup((force / 3) *
		effetPotion);
		for (int i = 0; lesTrophees != null && i < lesTrophees.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = lesTrophees[i];
		}
	}

	
	public void boirePotion(int forcePotion) {
		effetPotion *= forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée.");
	}
	
	
	public static void main(String[] args) {
		Gaulois gertrude = new Gaulois ("Gertrude", 8);
		System.out.println(gertrude);
		System.out.println(gertrude.prendreParole());
		gertrude.parler("Holla que tal?");
		Romain romano = new Romain ("Romano", 7);
		gertrude.frapper(romano);
		gertrude.boirePotion(5);
	}


}
