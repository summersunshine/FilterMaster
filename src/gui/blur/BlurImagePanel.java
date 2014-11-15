package gui.blur;

import gui.ImagePanel;
import gui.main.MainFrame;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import util.ImgUtil;
import algorithm.Constants;
import algorithm.basic.Clone;
import algorithm.basic.Erase;
import algorithm.blur.DoubleGuassBlur;

public class BlurImagePanel extends ImagePanel implements MouseListener, MouseMotionListener
{
	
	// ��˹ģ��ͼ��
	public BufferedImage guassBlurImage;

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

		super(image);


		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		setCircleCursor();
	}

	@Override
	protected void initDisplayImage(BufferedImage image)
	{
		// TODO Auto-generated method stub
		displayImage = DoubleGuassBlur.getImage(image,BlurSetting.levelValue);
		
		MainFrame.getInstance().setDisplayImage(Clone.getImage(displayImage));
	}

	@Override
	protected void initSourceImage(BufferedImage image)
	{
		// TODO Auto-generated method stub
		sourceImage = Clone.getImage(image);
	}

	protected void initGuassBlurImage(BufferedImage image)
	{
		// TODO Auto-generated method stub
		guassBlurImage = DoubleGuassBlur.getImage(image,BlurSetting.levelValue);
	}
	


	
	/**
	 * ����ģ���̶�
	 * @param level
	 * */
	public void updateImage(int level)
	{
		guassBlurImage = DoubleGuassBlur.getImage(sourceImage,level);
		
		displayImage = Clone.getImage(guassBlurImage);
		
		repaint();
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
		updateImage(e.getX(), e.getY());
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
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
