
import java.util.Scanner;
public class SimpleCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int result = 0;
		Calculater c = new Calculater(input);
		try {
			result = c.claculate(input);
			System.out.println(result);
		}catch(AddZeroException e) {
			System.out.println("AddZeroException");
		}catch(SubtractZeroException e) {
			System.out.println("SubtractZeroException");
		}catch(OutOfRangeException e) {
			System.out.println("OutOfRangeException");
		}
		
		sc.close();
	}
}

class Calculater {
	String answer;
	Calculater(String answer){
		this.answer = answer;
	}
	int claculate (String ans) throws AddZeroException,SubtractZeroException, OutOfRangeException {
		String plus[] = ans.split("\\+");
		String minus[] = ans.split("\\-");
		int result;
		int a1,a2;
		if(plus.length == 2) {
			a1 = Integer.parseInt(plus[0]);
			a2 = Integer.parseInt(plus[1]);
			if(a1 == 0 || a2 == 0) {
				throw new AddZeroException(a1);
			}
			result = a1+a2;
			if((result > 1000 || result < 0) || (a1 > 1000 || a1 < 0) || (a2 > 1000 || a2 < 0)) {
				throw new OutOfRangeException(result);
			}
		}
		else {
			a1 = Integer.parseInt(minus[0]);
			a2 = Integer.parseInt(minus[1]);
			result = a1-a2;
			if(a1 == 0 || a2 == 0) {
				throw new SubtractZeroException(a1);
			}
			if((result > 1000 || result < 0) || (a1 > 1000 || a1 < 0) || (a2 > 1000 || a2 < 0)) {
				throw new OutOfRangeException(result);
			}
		}
		return result;
	}
}
class OutOfRangeException extends Exception{
	private int range;
	 OutOfRangeException(int range){
		this.range = range;
	}
	public int getrange() {
		return range;
	}
}

class AddZeroException extends Exception{
	private int zero;
	AddZeroException(int zero){
		this.zero = zero;
	}
	public int getzero() {
		return zero;
	}
	
}

class SubtractZeroException extends Exception{
	private int zero;
	SubtractZeroException(int zero){
		this.zero = zero;
	}
	public int getzero() {
		return zero;
	}
}