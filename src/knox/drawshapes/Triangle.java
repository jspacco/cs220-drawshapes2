package knox.drawshapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Triangle extends AbstractShape{
	
	protected int height;
	protected int width;
	
	public Triangle(Point center, int height, int width, Color color) {
		super(new Point(center.x, center.y), color);
		 boundingBox = new BoundingBox(center.x - width/2, center.x + width/2, center.y - height/2, center.y + height/2);
		 this.height = height; 
		 this.width = width;
	}

	@Override
	public void draw(Graphics g) {
		
		int[] xArr = new int[] {(int)getAnchorPoint().getX(), (int)getAnchorPoint().getX() + width, (int)getAnchorPoint().getX() + width/2};
		int[] yArr = new int[] {(int)getAnchorPoint().getY(), (int)getAnchorPoint().getY(),(int)getAnchorPoint().getY() + height};
		
		 if (isSelected()){
	            g.setColor(color.darker());
	        } else {
	            g.setColor(getColor());
	        }
		 System.out.println(getAnchorPoint().getX());
		 System.out.println(getAnchorPoint().getY());
		 System.out.println(height);
		 System.out.println(width);
		 g.fillPolygon(xArr, yArr, 3);
	}


	
	@Override
	public void scale(double factor) {
		this.height = (int) (this.height * factor);
		this.width = (int) (this.width * factor);
		
	}
	
	public String toString() {
        return String.format("TRIAGLE %d %d %d %s %s", 
                this.getAnchorPoint().x, 
                this.getAnchorPoint().y,
                this.height,
                Util.colorToString(this.getColor()),
                this.isSelected());
    }

}
