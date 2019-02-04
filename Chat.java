/* 
 * J'adore le BTS SIO
 */
public class Chat {
	private final String nom;
	private final int poids;
	private final int age;
	
	public Chat() {
		nom = "Félix";
		poids = 200000000;
		age = 3;
	}
	
	public Chat(final String nom, final int poids, final int age) {
		this.nom = nom;
		this.poids = poids;
		this.age = age;
	}
	
	public void miauler() {
		System.out.println("Je miaule !");
	}
}
