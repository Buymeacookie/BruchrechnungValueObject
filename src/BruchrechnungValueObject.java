
public final class BruchrechnungValueObject {

	final private int zaehler;
	final private int nenner;

	/**
	 * 
	 * 
	 * @param zaehler
	 *            - übergabe eines zaehlers
	 * @param nenner
	 *            - übergabe eines nenners
	 * @return
	 */
	public BruchrechnungValueObject(int zaehler, int nenner) {

		if (nenner == 0) {

			throw new IllegalArgumentException("Division durch 0");

		}

		int ggt = ggT(zaehler, nenner);
		this.zaehler = zaehler / ggt;
		this.nenner = nenner / ggt;

	}

	public BruchrechnungValueObject() {

		this.zaehler = 0;
		this.nenner = 1;

	}

	public int getZaehler() {

		return zaehler;

	}

	public int getNenner() {

		return nenner;

	}

	@Override
	public String toString() {
		System.out.println(zaehler + "/" + nenner);
		return zaehler + "/" + nenner;

	}

	/**
	 * Gibt die Summe zweier Brüche zurück.
	 * 
	 * @param bruch
	 *            zweiter Bruch
	 */
	public BruchrechnungValueObject bruchAddition(BruchrechnungValueObject bruch) {
        
		int erweiterung = nenner * bruch.nenner;
		

		return new BruchrechnungValueObject((zaehler * (erweiterung/nenner)) + (bruch.zaehler * (erweiterung / bruch.nenner)), erweiterung);
	}

	/**
	 * 
	 * Berechnet die Differenz zweier Brüche.
	 * 
	 * @param bruch
	 *            zweiter Bruch
	 */
	public BruchrechnungValueObject bruchSubtraktion(BruchrechnungValueObject bruch) {
        
		int erweiterung = nenner * bruch.nenner;
		
		return new BruchrechnungValueObject((zaehler * (erweiterung/nenner)) - (bruch.zaehler * (erweiterung / bruch.nenner)), erweiterung);
	}

	/**
	 * Berechnet das Produkt zweier Brüche.
	 * 
	 * @param bruch
	 *            zweiter Bruch
	 * 
	 */
	public BruchrechnungValueObject bruchMultiplikation(BruchrechnungValueObject bruch) {

		return new BruchrechnungValueObject(this.zaehler * bruch.getZaehler(), this.nenner * bruch.getNenner());
	}

	/**
	 * Berechnet den Quotienten zweier Brüche.
	 * 
	 * @param bruch
	 *            zweiter Bruch
	 */
	public BruchrechnungValueObject bruchDivision(BruchrechnungValueObject bruch) {

		return new BruchrechnungValueObject(this.zaehler * bruch.getNenner(), this.nenner * bruch.getZaehler());
	}

	/**
	 * Berechnet den ggt zweier Zahlen.
	 * 
	 * @return Gibt den grössten gemeinsamen Teiler aus.
	 */

	private int ggT(int a, int b) {

		while (b != 0) {
			int c = a % b;
			a = b;
			b = c;
		}
		return a;
	}

}
