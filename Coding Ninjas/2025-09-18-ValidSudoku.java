import sys

def can_solve(board):
    # bitmasks of used digits (bits 1..9) for rows, cols, boxes
    R = [0]*9
    C = [0]*9
    B = [0]*9

    def box_id(r, c): return (r//3)*3 + (c//3)

    # initialize masks; also collect empties
    empties = []
    for r in range(9):
        for c in range(9):
            v = board[r][c]
            if v == 0:
                empties.append((r, c))
            else:
                bit = 1 << v
                b = box_id(r, c)
                # Input guaranteed consistent per problem, but keep a quick guard:
                if (R[r] & bit) or (C[c] & bit) or (B[b] & bit):
                    return False
                R[r] |= bit; C[c] |= bit; B[b] |= bit

    # precompute order with MRV each step
    def solve():
        if not empties:
            return True

        # choose the empty cell with fewest candidates (MRV)
        best_i = -1
        best_mask = 0
        best_count = 10

        for i, (r, c) in enumerate(empties):
            mask_used = R[r] | C[c] | B[box_id(r, c)]
            # candidates: bits in 1..9 not used
            cand = (~mask_used) & 0x3FE  # 0b11_1111_1110 -> bits for 1..9
            cnt = cand.bit_count()
            if cnt == 0:
                return False
            if cnt < best_count:
                best_count, best_mask, best_i = cnt, cand, i
                if cnt == 1:
                    break  # can't do better

        # try candidates
        r, c = empties.pop(best_i)
        b = box_id(r, c)
        cand = best_mask
        while cand:
            v_bit = cand & -cand
            cand -= v_bit
            v = (v_bit.bit_length() - 1)  # since bit for digit d is 1<<d

            # place
            R[r] |= v_bit; C[c] |= v_bit; B[b] |= v_bit
            board[r][c] = v

            if solve():
                return True

            # undo
            R[r] ^= v_bit; C[c] ^= v_bit; B[b] ^= v_bit
            board[r][c] = 0

        # put the cell back for other branches
        empties.insert(best_i, (r, c))
        return False

    return solve()

def main():
    data = sys.stdin.read().strip().split()
    if not data:
        return
    t = int(data[0])
    idx = 1
    out = []
    for _ in range(t):
        board = []
        for _ in range(9):
            row = list(map(int, data[idx:idx+9]))
            idx += 9
            board.append(row)
        out.append("yes" if can_solve(board) else "no")
    print("\n".join(out))

if __name__ == "__main__":
    main()
