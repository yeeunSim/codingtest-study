package week2.sooyeonz;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class n12_StockPrice {

	public static void main(String[] args) {
		int[] prices1 = {1, 2, 3, 2, 3};

		// 추가 테스트 케이스
		int[] prices2 = {1, 6, 9, 5, 3, 2, 7};

		System.out.println(Arrays.toString(solution(prices1)));
		System.out.println(Arrays.toString(solution(prices2)));
	}

	private static int[] solution(int[] prices) {
		int n = prices.length;
		int[] answer = new int[n];

		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(0);

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
				int j = stack.pop();
				answer[j] = i - j;
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int j = stack.pop();
			answer[j] = n - 1 - j;
		}

		return answer;
	}
}
