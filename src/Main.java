public class Main {

    private static char[][] grid;

    private static void print() {
        for (int i = 0; i < grid.length; i++) {
            System.out.print("[");
            for (int j = 0; j < grid[i].length; j++) {
                System.out.printf("%c ", grid[i][j]);
            }
            System.out.println("]");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        
        String fileName = "";
        if (args.length > 0) {
            fileName = args[0];
        }


        grid = Setup.setup(fileName);
        System.out.println("Generation 1");
        print();

        for (int i = 2; i <= 5; i++) {
            grid = Cell.evaluate(grid);
            System.out.printf("Generation %d\n", i);
            print();
        }
    }
}