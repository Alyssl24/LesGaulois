package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement [] equipements;
	private int nbEquipements = 0;
	
public Romain(String nom, int force) {
	assert force >= 0 : "force du Romain négative";
	this.nom = nom;
	this.force = force;
	this.equipements = new Equipement [2];
}
	
public String getNom() {
	return nom;
}

public void parler(String texte) {
	System.out.println(prendreParole() + "«" + texte + "»");
}

private String prendreParole() {
	return "Le romain " + nom + ": ";
}

public void recevoirCoup(int forceCoup) {
	assert forceCoup > 0 : "la force du Romain n'est pas positive";
	int forceDebut = force;
	force -= forceCoup;
	if (force > 0) {
		parler("Aïe");
	} else {
		parler("J'abandonne...");
	}
	assert forceDebut > force : "la force n'as pas diminué après le coup";
}

	private void mettreEquipement(Equipement equipement) {
		equipements[nbEquipements] = equipement;
		nbEquipements++;
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + "!");
	}
	

	public void sEquiper(Equipement equipement) {
		switch (nbEquipements) {
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé!");
			break;
		case 1:
			if (equipements[0] == equipement) System.out.println("Le soldat " + nom + " possède déjà un " + equipement + "!");
			else {
				mettreEquipement(equipement);
			}
			break;
		case 0:
			mettreEquipement(equipement);
			break;
		}
	}


public static void main(String[] args) {
	Romain minus = new Romain ("Minus", 6);
	minus.sEquiper(Equipement.CASQUE);
	minus.sEquiper(Equipement.CASQUE);
	minus.sEquiper(Equipement.BOUCLIER);
	minus.sEquiper(Equipement.CASQUE);
}

}
