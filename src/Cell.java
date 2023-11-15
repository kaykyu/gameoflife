import java.util.ArrayList;
import java.util.List;

public class Cell {

    public static char[][] evaluate(char[][] grid) {

        char[][] newGrid = new char[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                List<String> neighbours = new ArrayList<>();
                neighbours.add(String.format("%d %d", i-1, j-1));
                neighbours.add(String.format("%d %d", i-1, j));
                neighbours.add(String.format("%d %d", i-1, j+1));
                neighbours.add(String.format("%d %d", i, j-1));
                neighbours.add(String.format("%d %d", i, j+1));
                neighbours.add(String.format("%d %d", i+1, j-1));
                neighbours.add(String.format("%d %d", i+1, j));
                neighbours.add(String.format("%d %d", i+1, j+1));

                int sum = 0;

                for (String n : neighbours) {
                    String[] nums = n.split(" ");
                    int row = Integer.parseInt(nums[0]);
                    int col = Integer.parseInt(nums[1]);

                    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
                        switch (grid[row][col]) {
                            case ' ': break;
                            case '*': sum++;
                                break;
                        }
                    }
                }

                if (grid[i][j] == '*') {
                    switch (sum) {
                        case 2:
                        case 3: newGrid[i][j] = '*';
                            break;
                        default: newGrid[i][j] = ' ';
                            break;
                    }
                } else {
                    switch (sum) {
                        case 3: newGrid[i][j] = '*';                                
                            break;
                        default: newGrid[i][j] = ' ';
                    }
                }
            }
        }

        return newGrid;
    }
}
