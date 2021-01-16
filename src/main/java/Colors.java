import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Colors {
    RED(1),
    BLUE(2),
    YELLOW(3),
    GREEN(4),
    BLACK(5),
    WHITE(6);

    private int value;
    private static Map<Integer, Colors> map = new HashMap<>();

    private Colors(int value){
        this.value = value;
    }

    static {
        for (Colors color : Colors.values()) {
            map.put(color.value, color);
        }
    }
    public static Optional<Colors> valueOf(int color) {
        return Optional.ofNullable(map.get(color));
    }

    public int getValue() {
        return value;
    }
}
