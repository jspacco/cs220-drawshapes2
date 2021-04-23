package knox.drawshapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Triangle extends AbstractShape
{
    protected int length;

    
    public Triangle(Point center, int length, Color color){
    	super(new Point(center.x, center.y), color);
        boundingBox = new BoundingBox(center.x, center.x + length, center.y, center.y + length);
        this.length = length;
    }
    
    /* (non-Javadoc)
     * @see drawshapes.sol.Shape#draw(java.awt.Graphics)
     */
    @Override
    public void draw(Graphics g) {
        if (isSelected()){
            g.setColor(color.darker());
        } else {
            g.setColor(getColor());
        }
        int [] xpoint = new int [] {(int) getAnchorPoint().getX(), (int) getAnchorPoint().getX()+length, (int) getAnchorPoint().getX()+(length/2)};
        int [] ypoint = new int[] {(int) getAnchorPoint().getY(), (int) getAnchorPoint().getY(), (int) getAnchorPoint().getY()+length};
        g.fillPolygon(xpoint, ypoint, 3);
    }

    public String toString() {
        return String.format("TRIANGLE (%d, %d) length=%d color=%s selected? %s", 
                getAnchorPoint().x,
                getAnchorPoint().y,
                length,
                Util.colorToString(getColor()),
                selected);
    }
    
    public String encode() {
    	return String.format("TRIANGLE %d %d %d %s %s", 
                getAnchorPoint().x,
                getAnchorPoint().y,
                length,
                Util.colorToString(getColor()),
                selected);
    }
    
	@Override
	public void scale(double factor) {
		this.length = (int)(this.length * factor);
	}
    

}

