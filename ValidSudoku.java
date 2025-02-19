// Time Complexity : O (1)
// Space Complexity : O (1)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Your code here along with comments explaining your approach
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // 1 set to check rows
        Set<Character> rowChecker = new HashSet<>();
        // 9 sets to check cols
        List<Set<Character>> colChecker = new ArrayList<>();
        // 3 sets to check boxes
        List<Set<Character>> boxChecker = new ArrayList<>();

        int i, j, k;
        for(j = 0; j < 9; j++) {
            colChecker.add(new HashSet<Character>());
        }
        for(k = 0; k < 3; k++) {
            boxChecker.add(new HashSet<Character>());
        }
        for(i = 0; i < 9; i++) {
            for(j = 0; j < 9; j++) {
                k = j/3;
                if(board[i][j] == '.') continue;
                Character n = board[i][j];

                //check respective sets to see if the value is already present
                //in the row/col/box

                if(rowChecker.contains(n)) return false;
                rowChecker.add(n);

                if(colChecker.get(j).contains(n)) return false;
                colChecker.get(j).add(n);

                if(boxChecker.get(k).contains(n)) return false;
                boxChecker.get(k).add(n);

            }

            //reset row set after each iteration
            rowChecker.clear();
            //reset 3 box sets after every 3 iterations
            if((i%3) == 2) {
                boxChecker.get(0).clear();
                boxChecker.get(1).clear();
                boxChecker.get(2).clear();
            }
        }
        return true;
    }
}
