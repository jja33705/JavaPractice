package ch06Practice;

public class ArrayProcTest {
	final static int STUDENT=5;
	public static void main(String[] args) {
		int[] scores=new int[STUDENT];
		ArrayProc obj=new ArrayProc();
		obj.getValues(scores);
		System.out.println("∆Ú±’¿∫= "+obj.getAverage(scores));

	}

}
