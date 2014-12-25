package gui.blur;

import filter.Filter;
import filter.Blur.GuassBlurFilter;
import filter.Blur.InteractiveBlurFilter;
import filter.factory.FilterFactory;
import gui.base.ImagePanelWithCursor;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import util.image.Clone;
import util.image.Erase;
import util.image.ImageUtil;
import app.Constants;

public class BlurImagePanel extends ImagePanelWithCursor
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// 高斯模糊图像
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
	 * 更新模糊程度
	 * 
	 * @param level
	 * */
	public void updateBlurLevel(int level)
	{
		GuassBlurFilter.MASKSIZE = level;

		setFilter(BlurSetting.type);

		guassBlurImage = filter.getImage(sourceImage);

		displayImage = Clone.getImage(guassBlurImage);

		repaint();
	}

	/**
	 * 更新模糊的范围
	 * */
	public void updateClearRange()
	{
		setFilter(BlurSetting.type);

		InteractiveBlurFilter.centerX = BlurSetting.x;
		InteractiveBlurFilter.centerY = BlurSetting.y;
		InteractiveBlurFilter.size = BlurSetting.rangeValue;

		System.out.println("range" + InteractiveBlurFilter.size);

		displayImage = filter.getImage(sourceImage);

		repaint();
	}

	/**
	 * 根据涂抹的位置更新图像
	 * 
	 * @param x
	 * @param y
	 * */
	public void updateImage(int x, int y)
	{
		super.updateImage(x, y);

		System.out.println("update image");
		if (BlurSetting.type == Constants.TYPE_GUASS_BLUR)
		{
			updateImage(Erase.getImage(displayImage, sourceImage, displayX, displayY, BlurSetting.sizeValue));
		}
		if (BlurSetting.type == Constants.TYPE_ERASE)
		{
			updateImage(Erase.getImage(displayImage, guassBlurImage, displayX, displayY, BlurSetting.sizeValue));
		}

	}

	/**
	 * 设置光标为圆形
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

		if (BlurSetting.model == BlurSetting.CONTORL_MODEL)
		{
			updateCenter(moveX, moveY);
		}
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

	public void setFilter(int type)
	{
		filter = FilterFactory.getFilter(type);
		filter.setImage(sourceImage);
	}

	/**
	 * 切换模式
	 * */
	public void switchModel()
	{
		if (BlurSetting.model == BlurSetting.ADJUST_MODEL)
		{
			switchToSmear();
		}
		else
		{
			switchToTemplete();
		}
	}

	/**
	 * 切换到涂抹模式
	 * */
	private void switchToSmear()
	{
		BlurSetting.type = Constants.TYPE_GUASS_BLUR;
		updateBlurLevel(3);
	}

	/**
	 * 切换到模板模式
	 * */
	private void switchToTemplete()
	{
		BlurSetting.x = sourceImage.getWidth() / 2;
		BlurSetting.y = sourceImage.getHeight() / 2;

		updateClearRange();
	}

	public void updateCenter(int moveX, int moveY)
	{
		BlurSetting.x += moveX;
		BlurSetting.y += moveY;

		updateClearRange();
	}

}
