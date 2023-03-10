package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	
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
	return "Le gaulois " + nom + " : ";
}

public void frapper(Romain romain) {
	System.out.println((nom + "envoie un grand coup dans la machoire de " + romain.getNom()));
	romain.recevoirCoup((force / 3) * effetPotion);
}

@Override
public String toString() {
	return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
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
