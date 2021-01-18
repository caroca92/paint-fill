import java.util.*;

public class FillingScreenApplication {
    public static void main(String[] args) {
        FillingScreenApplication fillingScreenApplication = new FillingScreenApplication();
        Scanner in = new Scanner(System.in);

        System.out.println("Size in Y:");
        int i = in.nextInt();
        System.out.println("Size in X:");
        int j = in.nextInt();

        Enum [][] screen = fillingScreenApplication.builderArray(i,j);
        System.out.println("Array built");

        printArray(screen);

        System.out.println("Point in Y axis:");
        int pointI = in.nextInt();
        System.out.println("Point in X axis:");
        int pointJ = in.nextInt();
        System.out.println("New Color:");
        int newColor = in.nextInt();
        System.out.println("Color chosen:");
        System.out.println(Colors.valueOf(newColor).orElse(Colors.BLACK));

        FunctionChangeColor changeColorDefinition = (pointIValue, pointJValue, screenValue, colorValue, func) -> {
            FunctionChangeColor functionChangeColor = (FunctionChangeColor) func;
            if(pointIValue < screenValue.length && pointIValue >= 0 && pointJValue < screenValue[pointIValue].length && pointJValue >= 0 && screenValue[pointIValue][pointJValue] != colorValue){
                screenValue[pointIValue][pointJValue] = colorValue;

                printArray(screenValue);

                functionChangeColor.changeColor(pointIValue -1, pointJValue, screenValue, colorValue, functionChangeColor);
                functionChangeColor.changeColor(pointIValue, pointJValue - 1, screenValue, colorValue, functionChangeColor);
                functionChangeColor.changeColor(pointIValue + 1, pointJValue, screenValue, colorValue, functionChangeColor);
                functionChangeColor.changeColor( pointIValue, pointJValue + 1, screenValue, colorValue, functionChangeColor);
            }
        };

        changeColorDefinition.changeColor( pointI, pointJ, screen, Colors.valueOf(newColor).orElse(Colors.BLACK), changeColorDefinition);

    }

    public static void printArray(Enum [][] screen){
        System.out.println("Result:");
        Arrays.stream(screen)
                .forEach((simpleArray) -> {
                    Arrays.stream(simpleArray)
                        .forEach(anEnum -> System.out.print(anEnum + " \t"));
                    System.out.println();
                });
    }
    public Enum [][] builderArray(int i, int j){
        Enum [][] screen = new Enum[i][j];
        for(int x = 0; x < i; x++){
            for(int y = 0; y < j; y++){
                screen[x][y] = Colors.valueOf((int)(Math.random() * 9) + 1).orElse(Colors.BLACK);
            }
        }
        return screen;
    }
}
