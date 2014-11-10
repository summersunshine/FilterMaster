package gui.mousedisplay;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import util.Geometry;
import util.ImgUtil;

public class CircleMouseDisplayPanel extends MouseDisplayPanel
{

	int radius;

	public CircleMouseDisplayPanel(Rectangle rectangle)
	{
		super(rectangle);
		// TODO Auto-generated constructor stub
	}

	public CircleMouseDisplayPanel(int x, int y, int width, int height)
	{
		super(x, y, width, height);
	}

	@Override
	public void paint(Graphics graphics)
	{
		// TODO Auto-generated method stub
		System.out.println("paint called ");
	}

	public void drawCircle(int x, int y, int radius)
	{

		int[] xPoints = Geometry.getXPointsForCircle(x, radius);
		int[] yPoints = Geometry.getYPointsForCircle(y, radius);

		getGraphics().drawPolyline(xPoints, yPoints, 100);

	}

	public void setRadius(int radius)
	{
		this.radius = radius;

	}

}
