package gui;

import gui.partcolor.PartColorSetting;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import algorithm.Constants;
import algorithm.basic.Erase;
import algorithm.fashion.Rainbow;

public class ImagePanelWithCursor extends ImagePanel implements MouseListener, MouseMotionListener
{
	// 显示的x坐标
	protected int displayX = 0;

	// 显示的y坐标
	protected int displayY = 0;

	// 鼠标的x坐标
	private int mouseX;

	// 鼠标的y坐标
	private int mouseY;

	// cursor的x坐标
	private int cursorX;

	// cursor的y坐标
	private int cursorY;

	protected int radius;

	private boolean isMouseEntered;

	protected BufferedImage cursorImage;

	public ImagePanelWithCursor(BufferedImage image)
	{
		super(image);
		// TODO Auto-generated constructor stub
		setCursorImage();
		setCursorRadius();
		isMouseEntered = false;

		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	/**
	 * 设置光标的半径
	 * 
	 * @param radius
	 * */
	public void setCursorRadius(int radius)
	{
		this.radius = radius;
	}

	/**
	 * 设置光标的半径
	 * 
	 * 通常需要在子类中继承
	 * */
	public void setCursorRadius()
	{

	}

	/**
	 * 设置光标的图像
	 * */
	public void setCursorImage()
	{

	}

	/**
	 * 根据涂抹的位置更新图像
	 * 
	 * @param x
	 * @param y
	 * */
	public void updateImage(int x, int y)
	{
		displayX = (int) (x / ratio);
		displayY = (int) (y / ratio);
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;

		// System.out.println("paint component");
		paintImage(g2);

		// 只有在鼠标进入图像区域时才会绘制
		if (isMouseEntered)
		{
			paintCursor(g2);
		}
	}

	protected void paintImage(Graphics2D g2)
	{
		g2.drawImage(displayImage, 0, 0, canvasWidth, canvasHeight, null);

	}

	protected void paintCursor(Graphics2D g2)
	{

		// System.out.println("paint cursor " + cursorX + "  " + cursorY);
		g2.drawImage(cursorImage, cursorX, cursorY, radius, radius, null);
	}

	public void setPosition(int x, int y)
	{
		mouseX = x;
		mouseY = y;
		cursorX = mouseX - radius / 2;
		cursorY = mouseY - radius / 2;
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		// TODO Auto-generated method stub
		if (isMouseEntered)
		{
			setCursorRadius();

			setPosition(e.getX(), e.getY());
		}

		updateImage(e.getX(), e.getY());

		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		// TODO Auto-generated method stub
		if (isMouseEntered)
		{
			setCursorRadius();

			setPosition(e.getX(), e.getY());

		}

		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		updateImage(e.getX(), e.getY());
		repaint();
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
		repaint();
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
