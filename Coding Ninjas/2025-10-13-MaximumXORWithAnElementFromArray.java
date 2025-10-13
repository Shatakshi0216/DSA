import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[2];
}

class Trie {
    TrieNode root = new TrieNode();

    // Insert a number into the Trie
    public void insert(int num) {
        TrieNode node = root;
        for (int i = 30; i >= 0; i--) { // 31 bits for numbers up to 10^9
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    // Query max XOR for a given number
    public int query(int num) {
        TrieNode node = root;
        if (node == null) return -1;
        int maxXor = 0;
        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int toggledBit = 1 - bit;
            if (node.children[toggledBit] != null) {
                maxXor |= (1 << i);
                node = node.children[toggledBit];
            } else if (node.children[bit] != null) {
                node = node.children[bit];
            } else {
                return -1; // No number in Trie
            }
        }
        return maxXor;
    }
}

public class Solution {

    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
        int n = arr.size();
        int m = queries.size();
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(m, 0));

        // Sort the array
        Collections.sort(arr);

        // Store queries with their original index
        ArrayList<int[]> newQueries = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int xi = queries.get(i).get(0);
            int ai = queries.get(i).get(1);
            newQueries.add(new int[]{ai, xi, i});
        }

        // Sort queries by Ai
        newQueries.sort(Comparator.comparingInt(q -> q[0]));

        Trie trie = new Trie();
        int idx = 0;

        for (int[] q : newQueries) {
            int ai = q[0];
            int xi = q[1];
            int originalIndex = q[2];

            // Insert all arr elements <= Ai into Trie
            while (idx < n && arr.get(idx) <= ai) {
                trie.insert(arr.get(idx));
                idx++;
            }

            // If no elements ? Ai, answer is -1
            if (idx == 0) {
                res.set(originalIndex, -1);
            } else {
                int maxXor = trie.query(xi);
                res.set(originalIndex, maxXor);
            }
        }

        return res;
    }

    // Example usage
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        ArrayList<ArrayList<Integer>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(Arrays.asList(1, 3)));
        queries.add(new ArrayList<>(Arrays.asList(5, 6)));

        ArrayList<Integer> ans = maxXorQueries(arr, queries);
        System.out.println(ans); // Output: [3, 7]
    }
}
