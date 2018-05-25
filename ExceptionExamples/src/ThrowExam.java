
public class ThrowExam {

	public static void arrayMethod() throws ArrayIndexOutOfBoundsException {
		String[] irum = new String[3];
		irum[3] = "È«±æµ¿";
	}
	public static void main(String[] args) {
		ThrowExam ts = new ThrowExam();
		try {
			arrayMethod();
		} catch(ArrayIndexOutOfBoundsException e){
			
		}
		System.out.println("³»°¡ °©ÀÌ´Ù.");
	}
}