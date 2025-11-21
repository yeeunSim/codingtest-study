package week2.sooyeonz;

import java.util.ArrayDeque;
import java.util.Deque;

public class n10_RotateBracket {

	public static void main(String[] args) {
		String s1 = "[](){}";
		String s2 = "}]()[{";

		// 추가 테스트 케이스
		String s3 = "{[]}{{()[]}}";
		String s4 = "((){}(";

		System.out.println(solution(s1));
		System.out.println(solution(s2));

		System.out.println(solution(s3));
		System.out.println(solution(s4));
	}

	private static int solution(String s) {
		int result = 0;

		for (int x = 0; x < s.length(); x++) {
			Deque<Character> stack = new ArrayDeque<>();
			boolean isValid = true;

			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt((x + i) % s.length());

				if (ch == '(' || ch == '[' || ch == '{') {
					stack.push(ch);
				} else {
					if (stack.isEmpty()) {
						isValid = false;
						break;
					}

					char top = stack.pop();

					if ((ch == ')' && top != '(')
						|| (ch == ']' && top != '[')
						|| (ch == '}' && top != '{')) {
						isValid = false;
						break;
					}
				}
			}

			if (isValid && stack.isEmpty()) {
				result++;
			}
		}

		return result;
	}
}
