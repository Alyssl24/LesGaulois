package personnages;

import java.util.Iterator;

public class Village {
	private String nom;
	private Chef chef;
	private int nbrVillageois = 0;
	private Gaulois [] villageois;
	
	public Village(String nom, int nbVillageoisMaximun) {
		this.nom = nom;
		this.villageois = new Gaulois [nbVillageoisMaximun];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		if (nbrVillageois < villageois.length) {
			villageois[nbrVillageois] = gaulois;
			nbrVillageois++;
		}
	}
	
	public Gaulois trouverHabitant(int numVillageois) {
		return villageois[numVillageois];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le vilage du chef " + chef.getNom() + " vivent les légendaires gaulois: ");
		for (int i = 0; i < nbrVillageois; i++) {
			System.out.println("- " + villageois[i].getNom());
		}
	}
	

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30);
//		car le tableau ne possède aucun élément donc on ne peut pas accéder à l'élément 30...
		Chef abraracourcix = new Chef("Abraracourcix", 6, 1, village);
		village.chef =  abraracourcix;
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		renvoie null car il y a 1 gaulois mais il est à la place 0...
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
	
}
