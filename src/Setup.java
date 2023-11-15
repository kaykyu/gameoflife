import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Setup {

    private static List<String> instructions = new ArrayList<>();
    private static char[][] grid;
    private static int startRow;
    private static int startCol;

    
    public static char[][] setup(String fileName) {

        try (FileReader fr = new FileReader(fileName)) {

            BufferedReader br = new BufferedReader(fr);
            instructions = br.lines()
                .filter(line -> !line.trim().startsWith("#"))
                .collect(Collectors.toList());

            for (int i = 0; i < instructions.size(); i++) {
                switch (i) {
                    case 0: {
                        String[] line = instructions.get(0).trim().split(" ");
                        int rows = Integer.parseInt(line[2]);
                        int cols = Integer.parseInt(line[1]);
                        grid = new char[rows][cols];
                        for (int j = 0; j < rows; j++) {
                            for (int k = 0; k < cols; k++) {
                                grid[j][k] = ' ';
                            }
                        }
                    }
                        break;
                    case 1: {
                        String[] line = instructions.get(1).trim().split(" ");
                        startRow = Integer.parseInt(line[1]);
                        startCol = Integer.parseInt(line[2]);
                    }   
                        break;
                    case 2: break;
                    default: {
                        char[] cells = instructions.get(i).toCharArray();
                        int temp = startCol;
                        for (char c : cells) {
                            grid[startRow][startCol] = c;
                            startCol++;
                        }
                        startCol = temp;
                        startRow++;
                    }
                        break;
                }
            }

        } catch (IOException e) {
            System.out.println("Error!");
        }

        return grid;
    }
}
