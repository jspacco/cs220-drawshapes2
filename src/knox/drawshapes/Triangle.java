package knox.drawshapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class Triangle extends AbstractShape {
    private int length;
    private Point p;
    
    public Triangle(Color color, Point p, int length) {
    	super(p, color);
        boundingBox = new BoundingBox(p.x, p.x + length, p.y+length, p.y);
        this.length = length;
        this.p = p;
    }

    @Override
    public void draw(Graphics g) {
        if (isSelected()){
            g.setColor(getColor().darker());
        } else {
            g.setColor(getColor());
        }
        int[] xpoint = new int[] {p.x, p.x + length, p.x + length/2};
        int[] ypoint = new int[] {p.y, p.y, p.y + length};
        g.fillPolygon(xpoint, ypoint, 3);
    }
    
    public String toString() {
        return String.format("TRIANGLE %d %d %d %s %s", 
                this.getAnchorPoint().x, 
                this.getAnchorPoint().y,
                this.length,
                Util.colorToString(this.getColor()),
                this.isSelected());
    }

	@Override
	public void scale(double factor) {
		this.length = (int)(factor * this.length);
	}

}
