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
import algorithm.Constants;
import algorithm.basic.Erase;
import algorithm.blur.DoubleGuassBlur;

public class BlurImagePanel extends ImagePanel implements MouseListener, MouseMotionListener
{
	

	// ��˹ģ��ͼ��
	public BufferedImage guassBlurImage;

	// ����Ƿ����
	public boolean isMouseEntered;

	// ��ʾ��x����
	private int displayX;

	// ��ʾ��y����
	private int displayY;
	
	//�ϴε�x����
	private int lastX;
	
	//�ϴε�y����
	private int lastY;

	public BlurImagePanel(BufferedImage image)
	{

		super(DoubleGuassBlur.getImage(image));

		guassBlurImage = DoubleGuassBlur.getImage(image);
		
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
		
		if (lastX == x && lastY == y)
		{
			return ;
		}
		
		displayX = (int) (x / ratio);
		displayY = (int) (y / ratio);

		
		if(BlurSetting.type == Constants.TYPE_ERASE)
		{
			updateImage(Erase.getImage(displayImage, sourceImage, displayX, displayY, BlurSetting.sizeValue));
		}
		else
		{
			updateImage(Erase.getImage(displayImage,guassBlurImage, displayX, displayY, BlurSetting.sizeValue));
		}
		
		lastX = x;
		lastY = y;

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
