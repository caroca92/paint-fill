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
        fillingScreenApplication.printArray(screen);

        System.out.println("Point in Y axis:");
        int pointI = in.nextInt();
        System.out.println("Point in X axis:");
        int pointJ = in.nextInt();
        System.out.println("New Color:");
        int newColor = in.nextInt();
        System.out.println("Color chosen:");
        System.out.println(Colors.valueOf(newColor).orElse(Colors.BLACK));

        FunctionChangeColor changeColorDefinition = (pointIValue, pointJValue, screenValue, colorValue, func) -> {
            Enum[][] array = (Enum[][]) screenValue;
            Enum color = (Enum) colorValue;
            FunctionChangeColor functionChangeColor = (FunctionChangeColor) func;
            Integer iValue = (Integer) pointIValue;
            Integer jValue = (Integer) pointJValue;
            if(iValue < array.length && iValue >= 0 && jValue < array[iValue].length && jValue >= 0 && array[iValue][jValue] != color){
                array[iValue][jValue] = color;

                printArray(array);

                functionChangeColor.changeColor(iValue -1, jValue, array, color, functionChangeColor);
                functionChangeColor.changeColor(iValue, jValue - 1, array, color, functionChangeColor);
                functionChangeColor.changeColor(iValue + 1, jValue, array, color, functionChangeColor);
                functionChangeColor.changeColor( iValue, jValue + 1, array, color, functionChangeColor);
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
