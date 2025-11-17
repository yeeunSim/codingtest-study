package week2.sooyeonz;

public class n09_DecimalToBinary {

	public static void main(String[] args) {
		int decimal1 = 10;
		int decimal2 = 27;
		int decimal3 = 12345;

		// 추가 테스트 코드
		int decimal4 = 1;
		int decimal5 = 1024;

		System.out.println(solution(decimal1));
		System.out.println(solution(decimal2));
		System.out.println(solution(decimal3));
		System.out.println(solution(decimal4));
		System.out.println(solution(decimal5));
	}

	private static String solution(int decimal) {
		StringBuilder sb = new StringBuilder();

		while (decimal != 0) {
			sb.append(decimal % 2);
			decimal /= 2;
		}

		return sb.reverse().toString();
	}
}
