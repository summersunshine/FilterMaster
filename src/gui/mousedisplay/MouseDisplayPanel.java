package gui.mousedisplay;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MouseDisplayPanel extends JPanel implements MouseListener, MouseMotionListener
{
	public static final int TYPE_CIRCLE = 1;

	protected int mouseX;
	protected int mouseY;
	protected int type;

	public MouseDisplayPanel(Rectangle rectangle)
	{
		setBounds(rectangle);
		setOpaque(false);

		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setVisible(true);
	}

	public MouseDisplayPanel(int x, int y, int width, int height)
	{
		setBounds(x, y, width, height);
		setOpaque(false);

		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setVisible(true);
	}

	@Override
	public void mouseDragged(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		// TODO Auto-generated method stub
		mouseX = e.getX();
		mouseY = e.getY();

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

		System.out.println("mouse enter");

	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		System.out.println("mouse exit");
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

}
