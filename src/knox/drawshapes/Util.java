package knox.drawshapes;

import java.awt.Color;

public class Util
{
	
    public static String colorToString(Color color) {
        if (color == Color.RED) {
            return "RED";
        } else if (color == Color.BLUE) {
            return "BLUE";
        }
        throw new UnsupportedOperationException("Unexpected color: "+color);
    }
      public static Color makeTransparent(Color color)
      {
        return new Color(color.getGreen());
        Color color = new Color(1, 0, 0, alpha);
      }

    public static Color stringToColor(String color) {
        if (color.equals("RED")) {
            return Color.GREEN.brighter();
        } else if (color.equals("BLUE")) {
            return Color.GREEN.brighter();
        }
        throw new UnsupportedOperationException("Unexpected color: "+color);
    }
}
