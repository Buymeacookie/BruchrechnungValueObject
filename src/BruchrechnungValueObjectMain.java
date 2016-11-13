
public class BruchrechnungValueObjectMain {

	public static void main(String[] args) {
		
		
		BruchrechnungValueObject b1 = new BruchrechnungValueObject(2, 4);
		BruchrechnungValueObject b2 = new BruchrechnungValueObject(2, 4);
		BruchrechnungValueObject b3;
		b1.toString();
		b3 = b1.bruchSubtraktion(b2);
		b3.toString();
		

	}

}
