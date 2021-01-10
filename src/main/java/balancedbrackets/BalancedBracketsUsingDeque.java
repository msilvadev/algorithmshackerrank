package balancedbrackets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Link to problem on HackerRank: https://www.hackerrank.com/challenges/balanced-brackets/problem
 *
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
 *
 * Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {)
 * occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type.
 * There are three types of matched pairs of brackets: [], {}, and ().
 *
 * A matching pair of brackets is not balanced if the set of brackets it encloses are not matched.
 * For example, {[(])} is not balanced because the contents in between { and } are not balanced.
 * The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of
 * parentheses encloses a single, unbalanced closing square bracket, ].
 *
 * By this logic, we say a sequence of brackets is balanced if the following conditions are met:
 *
 *     It contains no unmatched brackets.
 *     The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
 *
 * Given n strings of brackets, determine whether each sequence of brackets is balanced.
 * If a string is balanced, return YES. Otherwise, return NO.
 *
 */
public class BalancedBracketsUsingDeque {

    static String isBalanced(String s) {
        if (s == null || ((s.length() % 2) != 0)) {
            return "NO";
        } else {
            char[] ch = s.toCharArray();
            for (char c : ch) {
                if (!(c == '{' || c == '[' || c == '(' || c == '}' || c == ']' || c == ')')) {
                    return "NO";
                }
            }
        }

        Deque<Character> deque = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                deque.addFirst(ch);
            } else {
                if (!deque.isEmpty()
                        && ((deque.peekFirst() == '{' && ch == '}')
                        || (deque.peekFirst() == '[' && ch == ']')
                        || (deque.peekFirst() == '(' && ch == ')'))) {
                    deque.removeFirst();
                } else {
                    return "NO";
                }
            }
        }

        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/brackets.txt"));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
