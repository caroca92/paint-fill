import java.util.*;

public class FillingScreenApplication {
    public static void main(String[] args) {
        FillingScreenApplication fillingScreenApplication = new FillingScreenApplication();
        Scanner in = new Scanner(System.in);

        Enum [][] screen = new Enum[][]{
                { Colors.BLACK, Colors.RED, Colors.RED, Colors.RED, Colors.BLACK, Colors.BLUE},
                { Colors.BLACK, Colors.RED, Colors.RED, Colors.BLACK, Colors.GREEN, Colors.RED },
                { Colors.WHITE, Colors.BLACK, Colors.YELLOW, Colors.RED, Colors.WHITE, Colors.BLACK}
        };
        System.out.println("Array built");
        fillingScreenApplication.printArray(screen);

        System.out.println("Point in Y axis:");
        int pointI = in.nextInt();
        System.out.println("Point in X axis:");
        int pointJ = in.nextInt();
        System.out.println("New Color:");
        int newColor = in.nextInt();
        System.out.println("Color chosen:");
        System.out.println(Colors.valueOf(newColor).orElse(Colors.BLACK));

        fillingScreenApplication.changeColor(pointI, pointJ, screen, Colors.valueOf(newColor).orElse(Colors.BLACK));


    }
    public void changeColor(int i, int j, Enum[][] array, Enum color){
        if(i < array.length && i >= 0 && j < array[i].length && j >= 0 && array[i][j] != color){
            array[i][j] = color;

            printArray(array);

            changeColor(i -1, j, array, color);
            changeColor(i, j - 1, array, color);
            changeColor(i + 1, j, array, color);
            changeColor(i, j + 1, array, color);

        }

    }
    public void printArray(Enum [][] screen){
        System.out.println("Result:");
        for (Enum[] enums : screen) {
            for (Enum anEnum : enums) {
                System.out.print(anEnum + " \t");
            }
            System.out.println();
        }
    }
    public Enum [][] builderArray(int i, int j){
        Enum [][] screen = new Enum[i][j];
        for(int x = 0; x < i; x++){
            for(int y = 0; y < j; y++){
                screen[x][y] = Colors.valueOf((int)(Math.random() * 5) + 1).orElse(Colors.BLACK);
            }
        }
        return screen;
    }
}
