package knox.drawshapes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Oval extends AbstractShape{
	//private int x;
	//private int y;
	private int width;
	private int height;
	
	public Oval(Color color, Point center, int width, int height) {
    	super(center, color);
        boundingBox = new BoundingBox(center.x - width/2, center.x + width/2, center.y - height/2, center.y + height/2);
        this.width = width;
        this.height = height;
    }
	
	
	 @Override
	    public void draw(Graphics g) {
	        if (isSelected()){
	            g.setColor(getColor().darker());
	        } else {
	            g.setColor(getColor());
	        }
	        g.fillOval((int)getAnchorPoint().getX() - width/2,
	                (int)getAnchorPoint().getY() - height/2,
	                width, height);
	    }

	 public String toString() {
	        return String.format("OVAL (%d, %d) width=%d height=%d color=%s selected? %s", 
	                getAnchorPoint().x,
	                getAnchorPoint().y,
	                width,
	                height,
	                Util.colorToString(getColor()),
	                selected);
	    }
	 
	 public String encode() {
	    	return String.format("OVAL %d %d %d %d %s %s", 
	                getAnchorPoint().x,
	                getAnchorPoint().y,
	                width,
	                height,
	                Util.colorToString(getColor()),
	                selected);
	    }
	 
	 @Override
		public void scale(double factor) {
			this.width = (int)(this.width * factor);
			this.height = (int)(this.height * factor);
		}
}
