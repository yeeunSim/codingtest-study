package week2.sooyeonz;

import java.util.Arrays;
import java.util.Stack;

public class n14_TableEdit {

	public static void main(String[] args) {
		int n1 = 8;
		int k1 = 2;
		String[] cmd1 = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
		int n2 = 8;
		int k2 = 2;
		String[] cmd2 = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};

		System.out.println(solution(n1, k1, cmd1));
		System.out.println(solution(n2, k2, cmd2));
	}

	private static String solution(int n, int k, String[] cmd) {
		Stack<Integer> deleted = new Stack<>();

		int[] up = new int[n + 2];
		int[] down = new int[n + 2];

		for (int i = 0; i < n + 2; i++) {
			up[i] = i - 1;
			down[i] = i + 1;
		}

		k++;

		for (String c : cmd) {
			if (c.startsWith("C")) {
				deleted.push(k);
				up[down[k]] = up[k];
				down[up[k]] = down[k];
				k = n < down[k] ? up[k] : down[k];
			} else if (c.startsWith("Z")) {
				int restore = deleted.pop();
				down[up[restore]] = restore;
				up[down[restore]] = restore;
			} else {
				String[] s = c.split(" ");
				int x = Integer.parseInt(s[1]);
				for (int i = 0; i < x; i++) {
					k = s[0].equals("U") ? up[k] : down[k];
				}
			}
		}

		char[] answer = new char[n];
		Arrays.fill(answer, 'O');

		for (int i : deleted) {
			answer[i - 1] = 'X';
		}

		return new String(answer);
	}
}
