package concat;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Link to problem on HackerRank: https://www.hackerrank.com/challenges/contacts/problem
 *
 * We're going to make our own Contacts application! The application must perform two types of operations:
 *
 *  1- add name, where is a string denoting a contact name. This must store as a new contact in the application.
 *  2- find partial, where is a string denoting a partial name to search the application for.
 *     It must count the number of contacts starting with and print the count on a new line.
 *
 * Given n sequential add and find operations, perform each operation in order.
 *
 * Input Format
 *  The first line contains a single integer, denoting the number of operations to perform.
 *  Each line of the subsequent lines contains an operation in one of the two forms defined above.
 *
 * Example:
 *      Input (stdin):
 *          4
 *          add hack
 *          add hackerrank
 *          find hac
 *          find hak
 *      Expected Output:
 *          2
 *          0
 *
 * @author msilvadev
 */
public class Contacts {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            String operation = scan.next();
            String contact   = scan.next();
            if (operation.equals("add")) {
                trie.add(contact);
            } else if (operation.equals("find")) {
                System.out.println(trie.find(contact));
            }
        }
        scan.close();
    }
}

class TrieNode {
    private HashMap<Character, TrieNode> children = new HashMap<>();
    public int size = 0; // this was the main trick to decrease runtime to pass tests.

    public void putChildIfAbsent(char ch) {
        children.putIfAbsent(ch, new TrieNode());
    }

    public TrieNode getChild(char ch) {
        return children.get(ch);
    }
}

class Trie {
    TrieNode root = new TrieNode();

    public void add(String str) {
        TrieNode curr = root;
        for (char ch : str.toCharArray()) {
            curr.putChildIfAbsent(ch);
            curr = curr.getChild(ch);
            curr.size++;
        }
    }

    public int find(String prefix) {
        TrieNode curr = root;

        for (char ch : prefix.toCharArray()) {
            curr = curr.getChild(ch);
            if (curr == null) {
                return 0;
            }
        }
        return curr.size;
    }
}