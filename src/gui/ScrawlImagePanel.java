package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class ScrawlImagePanel extends ImagePanel implements MouseListener,MouseMotionListener
{

	int x1,x2,y1,y2;
	
	public ScrawlImagePanel(BufferedImage image)
	{
		super(image);
		// TODO Auto-generated constructor stub
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		x1 = arg0.getX();
		y1 = arg0.getY();
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
//		Graphics graphics = getGraphics();
		
		x2 = arg0.getX();
		y2 = arg0.getY();
		
		Graphics2D g2d = (Graphics2D)getGraphics();
		g2d.setPaint(new Color(0,0,0));
		g2d.setStroke(new BasicStroke(5.0f,
		                BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL));
		g2d.drawLine(x1,y1,x2,y2);
		
		x1= x2;
		y1 = y2;
	}

	@Override
	public void mouseMoved(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

}
