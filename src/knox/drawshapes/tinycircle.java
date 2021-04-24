package knox.drawshapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class tinycircle extends AbstractShape
{
    private int diameter;
    
    public tinycircle(Color color, Point center, int diameter) {
    	super(center, color);
        boundingBox = new BoundingBox(center.x - diameter/3, center.x + diameter/3, center.y - diameter/3, center.y + diameter/3);
        this.diameter = diameter;
    }

    @Override
    public void draw(Graphics g) {
        if (isSelected()){
            g.setColor(getColor().darker());
        } else {
            g.setColor(getColor());
        }
        g.fillOval((int)getAnchorPoint().getX() - diameter/3,
                (int)getAnchorPoint().getY() - diameter/3,
                diameter,
                diameter);
    }
    
    public String toString() {
        return String.format("CIRCLE %d %d %d %s %s", 
                this.getAnchorPoint().x, 
                this.getAnchorPoint().y,
                this.diameter,
                Util.colorToString(this.getColor()),
                this.isSelected());
    }

	@Override
	public void scale(double factor) {
		this.diameter = (int)(factor * this.diameter);
	}

}
