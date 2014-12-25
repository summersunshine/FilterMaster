package gui.blur;

import filter.Filter;
import filter.Blur.GuassBlurFilter;
import filter.factory.FilterFactory;
import gui.ImagePanelWithCursor;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import util.ImageUtil;
import algorithm.basic.Clone;
import algorithm.basic.Erase;
import algorithm.blur.InteractiveBlur;
import app.Constants;

public class BlurImagePanel extends ImagePanelWithCursor
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// ��˹ģ��ͼ��
	public BufferedImage		guassBlurImage;

	private Filter				filter;

	private int					lastMouseX;

	private int					lastMouseY;

	public BlurImagePanel(BufferedImage image)
	{

		super(image);

		initGuassBlurImage(image);
	}

	@Override
	protected void initDisplayImage(BufferedImage image)
	{
		// TODO Auto-generated method stub
		GuassBlurFilter.MASKSIZE = 5;

		filter = FilterFactory.getFilter(Constants.TYPE_GUASS_BLUR);

		displayImage = filter.getImage(image);

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
		guassBlurImage = Clone.getImage(displayImage);
	}

	/**
	 * ����ģ���̶�
	 * 
	 * @param level
	 * */
	public void updateBlurLevel(int level)
	{
		GuassBlurFilter.MASKSIZE = level;

		guassBlurImage = filter.getImage(sourceImage);

		displayImage = Clone.getImage(guassBlurImage);

		repaint();
	}

	/**
	 * ����ͼ��
	 * */
	public void updateClearRange()
	{
		int x = BlurSetting.x;
		int y = BlurSetting.y;
		int range = BlurSetting.rangeValue;
		displayImage = InteractiveBlur.getImage(sourceImage, x, y, range, BlurSetting.type);
		repaint();
	}

	/**
	 * ����ͿĨ��λ�ø���ͼ��
	 * 
	 * @param x
	 * @param y
	 * */
	public void updateImage(int x, int y)
	{
		super.updateImage(x, y);

		System.out.println("update image");
		if (BlurSetting.type == Constants.TYPE_ERASE)
		{
			updateImage(Erase.getImage(displayImage, sourceImage, displayX, displayY, BlurSetting.sizeValue));
		}
		else
		{
			updateImage(Erase.getImage(displayImage, guassBlurImage, displayX, displayY, BlurSetting.sizeValue));
		}

	}

	/**
	 * ���ù��ΪԲ��
	 * */
	public void setCircleCursor()
	{
		// TODO Auto-generated method stub
		System.out.println("change cursor");

		BufferedImage image = ImageUtil.getImage("res/circle.png");

		Toolkit tk = Toolkit.getDefaultToolkit();

		Cursor cursor = tk.createCustomCursor(image, new Point(16, 16), "blur");

		setCursor(cursor);
	}

	@Override
	public void setCursorImage()
	{
		// TODO Auto-generated method stub
		cursorImage = ImageUtil.getImage("res/circle.png");
	}

	@Override
	public void setCursorRadius()
	{
		radius = BlurSetting.sizeValue;
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		lastMouseX = e.getX();
		lastMouseY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		int moveX = e.getX() - lastMouseX;
		int moveY = e.getY() - lastMouseY;

		updateCenter(moveX, moveY);

		lastMouseX = e.getX();
		lastMouseY = e.getY();
	}

	public void mouseDragged(MouseEvent e)
	{
		// TODO Auto-generated method stub
		if (BlurSetting.type == Constants.TYPE_GUASS_BLUR || BlurSetting.type == Constants.TYPE_ERASE)
		{
			super.mouseDragged(e);

		}

	}

	/**
	 * �л�ģʽ
	 * */
	public void switchModel()
	{
		if (BlurSetting.model == BlurSetting.ADJUST_MODEL)
		{
			switchToAdjust();
		}
		else
		{
			switchToControl();
		}
	}

	/**
	 * �л���adjustģʽ
	 * */
	private void switchToAdjust()
	{
		updateBlurLevel(3);
	}

	/**
	 * �л�������ģʽ
	 * */
	private void switchToControl()
	{
		int x = sourceImage.getWidth() / 2;
		int y = sourceImage.getHeight() / 2;
		BlurSetting.x = x;
		BlurSetting.y = y;

		displayImage = InteractiveBlur.getImage(sourceImage, x, y, BlurSetting.rangeValue, BlurSetting.type);
		repaint();
	}

	public void updateCenter(int moveX, int moveY)
	{
		BlurSetting.x += moveX;
		BlurSetting.y += moveY;

		displayImage = InteractiveBlur.getImage(sourceImage, BlurSetting.x, BlurSetting.y, BlurSetting.rangeValue, BlurSetting.type);
		repaint();
	}

}
