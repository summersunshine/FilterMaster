package gui.backgroundblur;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import algorithm.basic.Erase;
import algorithm.blur.DoubleGuassBlur;
import util.Geometry;
import gui.MainImagePanel;

public class BackgroundBlurImagePanel extends MainImagePanel implements MouseMotionListener, MouseListener
{

	public BufferedImage sourceImage;
	public boolean isMouseEntered;

	private int x;
	private int y;

	public BackgroundBlurImagePanel(BufferedImage image)
	{

		super(DoubleGuassBlur.getImage(image));
		sourceImage = image;

		// TODO Auto-generated constructor stub

		isMouseEntered = false;

		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();

		if (isMouseEntered)
		{
			int[] xPoints = Geometry.getXPoints(x, BackgroundBlurFrame.sizeValue);
			int[] yPoints = Geometry.getYPoints(y, BackgroundBlurFrame.sizeValue);
			// getGraphics().clearRect(0, 0, width, height);
			// /paint(getGraphics());
			// getGraphics().drawPolyline(xPoints, yPoints, 100);
		}
		// System.out.println("mouse move" + x + "  " + y);
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		// displayImage =
		// DoubleGuassBlur.getImage(displayImage,x,y,BackgroundBlurFrame.sizeValue);
		displayImage = Erase.getImage(displayImage, sourceImage, x, y, BackgroundBlurFrame.sizeValue);
		paint(getGraphics());
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		isMouseEntered = true;

		System.out.println("mouse enter");
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		isMouseEntered = false;
		System.out.println("mouse exit");
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

}
