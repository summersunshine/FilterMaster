package gui.partcolor;

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
import algorithm.basic.Gray;

public class PartColorImagePanel extends ImagePanel implements MouseListener, MouseMotionListener
{
	// �Ҷ�ͼ��
	public BufferedImage grayImage;


	// ��ʾ��x����
	private int displayX;

	// ��ʾ��y����
	private int displayY;

	public PartColorImagePanel(BufferedImage image)
	{

		super(Gray.getImage(image));

		sourceImage = image;

		grayImage = Gray.getImage(image);


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
	public void updateImage(int x, int y)
	{
		displayX = (int) (x / ratio);
		displayY = (int) (y / ratio);

		if (PartColorSetting.type == Constants.TYPE_ERASE)
		{
			this.updateImage(Erase.getImage(displayImage, sourceImage, displayX, displayY, PartColorSetting.sizeValue));
		}
		else
		{
			this.updateImage(Erase.getImage(displayImage, grayImage, displayX, displayY, PartColorSetting.sizeValue));
		}

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
