package gui.blur;

import gui.ImagePanel;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import util.ImgUtil;
import algorithm.basic.Erase;
import algorithm.blur.DoubleGuassBlur;

public class BlurImagePanel extends ImagePanel implements MouseListener, MouseMotionListener
{

	// ԭʼͼ��
	public BufferedImage sourceImage;

	// ����Ƿ����
	public boolean isMouseEntered;

	// ��ʾ��x����
	private int displayX;

	// ��ʾ��y����
	private int displayY;

	public BlurImagePanel(BufferedImage image)
	{

		super(DoubleGuassBlur.getImage(image));

		sourceImage = image;

		isMouseEntered = false;

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		setCircleCursor();
	}

	/**
	 * ���ù��ΪԲ��
	 * */
	public void setCircleCursor()
	{
		// TODO Auto-generated method stub
		System.out.println("change cursor");

		BufferedImage image = ImgUtil.getImg("res/circle.png");

		Toolkit tk = Toolkit.getDefaultToolkit();

		Cursor cursor = tk.createCustomCursor(image, new Point(16, 16), "blur");

		setCursor(cursor);
	}

	/**
	 * ����ͿĨ��λ�ø���ͼ��
	 * 
	 * @param x
	 * @param y
	 * */
	private void updateImage(int x, int y)
	{
		displayX = (int) (x / ratio);
		displayY = (int) (y / ratio);

		this.updateImage(Erase.getImage(displayImage, sourceImage, displayX, displayY, BlurFrame.sizeValue));
		// this.updateImage(Mosaic.getImage(displayImage, displayX, displayY,
		// BackgroundBlurFrame.sizeValue));
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		updateImage(e.getX(), e.getY());
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		isMouseEntered = true;
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		isMouseEntered = false;
		// System.out.println("mouse exit");
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
