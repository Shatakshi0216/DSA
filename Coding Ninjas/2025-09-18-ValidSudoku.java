public class Solution {

    // bitmasks for rows, cols, and 3x3 boxes (bits 1..9 used)
    private static int[] R, C, B;

    public static boolean isItSudoku(int matrix[][]) {
        R = new int[9];
        C = new int[9];
        B = new int[9];

        // initialize masks; validate given digits
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int v = matrix[r][c];
                if (v == 0) continue;
                int bit = 1 << v;
                int b = boxId(r, c);
                if ((R[r] & bit) != 0 || (C[c] & bit) != 0 || (B[b] & bit) != 0) {
                    return false; // inconsistent (problem says it won't happen)
                }
                R[r] |= bit;
                C[c] |= bit;
                B[b] |= bit;
            }
        }

        return solve(matrix);
    }

    private static boolean solve(int[][] a) {
        // MRV: find the empty cell with fewest candidates
        int bestR = -1, bestC = -1, bestMask = 0, bestCnt = 10;

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (a[r][c] != 0) continue;
                int used = R[r] | C[c] | B[boxId(r, c)];
                int cand = (~used) & 0x3FE; // bits for digits 1..9
                int cnt = Integer.bitCount(cand);
                if (cnt == 0) return false;   // dead end
                if (cnt < bestCnt) {
                    bestCnt = cnt;
                    bestMask = cand;
                    bestR = r;
                    bestC = c;
                    if (cnt == 1) break; // can't do better
                }
            }
            if (bestCnt == 1) break;
        }

        // no empties left => solved
        if (bestR == -1) return true;

        int r = bestR, c = bestC, b = boxId(r, c);
        int cand = bestMask;

        while (cand != 0) {
            int bit = cand & -cand;            // lowest set bit
            cand -= bit;
            int v = Integer.numberOfTrailingZeros(bit); // since bit = 1<<v

            // place
            R[r] |= bit; C[c] |= bit; B[b] |= bit;
            a[r][c] = v;

            if (solve(a)) return true;

            // undo
            R[r] ^= bit; C[c] ^= bit; B[b] ^= bit;
            a[r][c] = 0;
        }

        return false;
    }

    private static int boxId(int r, int c) {
        return (r / 3) * 3 + (c / 3);
    }
}
