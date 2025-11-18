package week2.yeeunSim;

import java.util.ArrayDeque;

public class n08_ValidBracket {

    public static void main(String[] args) {
        System.out.println(solution2(")))("));
        System.out.println(solution2(")))"));
        System.out.println(solution2("()()"));
        System.out.println(solution2("(())()"));
        System.out.println(solution2("(())("));

    }

    /**
     * 시간복잡도: O(N)
     */
    private static boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<Character>();

        char[] a = s.toCharArray();
        for (char c : a) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() == c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

    // stack 안 쓴 버전
    private static boolean solution2(String s) {
        boolean answer = true;

        int count = 0; // 열린 괄호 개수

        char[] arr = s.toCharArray();

        for (char c : arr) {

            // 열린 괄호인 경우
            if (c == '(') count++;

            // 닫힌 괄호인 경우
            else {
                if (count == 0) { // 열려있는 괄호가 없다면 올바르지 않은 괄호
                    answer = false;
                    break;
                }
                count--;
            }
        }

        // 괄호가 다 닫히지 않았다면 올바르지 않은 괄호
        if (count != 0) answer = false;
        return answer;
    }
}
