package knox.drawshapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Triangle extends AbstractShape{

	 private int width;
	 private int height;
	    
	    public Triangle(Color color, Point center, int width, int height) {
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
	        int[] x = {(int)getAnchorPoint().getX()+50, (int)getAnchorPoint().getX(),  (int)getAnchorPoint().getX()-50};
	        int[] y = {(int)getAnchorPoint().getY(), (int)getAnchorPoint().getY(),(int)getAnchorPoint().getY()+50};
	        g.fillPolygon(x,y,3);
	    }
	    
	    public String toString() {
	        return String.format("TRIANGLE %d %d d% d% %s %s", 
	                this.getAnchorPoint().x, 
	                this.getAnchorPoint().y,
	                width,
	                height,
	                Util.colorToString(this.getColor()),
	                this.isSelected());
	    }

		@Override
		public void scale(double factor) {
			this.width = (int)(this.width * factor);
			this.height = (int)(this.height * factor);
		}

    
}