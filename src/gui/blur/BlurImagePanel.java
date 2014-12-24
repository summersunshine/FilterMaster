package gui.blur;

import gui.ImagePanelWithCursor;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import util.ImgUtil;
import algorithm.basic.Clone;
import algorithm.basic.Erase;
import algorithm.blur.DoubleGuassBlur;
import algorithm.blur.InteractiveBlur;
import app.Constants;

public class BlurImagePanel extends ImagePanelWithCursor
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// 高斯模糊图像
	public BufferedImage		guassBlurImage;

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
		displayImage = DoubleGuassBlur.getImage(image, BlurSetting.levelValue);
		// displayImage = InteractiveBlur.getImage(image, 400,400,
		// 200,InteractiveBlur.TYPE_RADIAL);
		// MainFrame.getInstance().setDisplayImage(Clone.getImage(displayImage));
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
		guassBlurImage = DoubleGuassBlur.getImage(sourceImage, level);

		displayImage = Clone.getImage(guassBlurImage);

		repaint();
	}

	/**
	 * 控制图像
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
	 * 根据涂抹的位置更新图像
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
	 * 设置光标为圆形
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
	public void setCursorImage()
	{
		// TODO Auto-generated method stub
		cursorImage = ImgUtil.getImg("res/circle.png");
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
		if (BlurSetting.type == Constants.TYPE_DOUBLE_GUASS_BLUR || BlurSetting.type == Constants.TYPE_ERASE)
		{
			super.mouseDragged(e);

		}

	}

	/**
	 * 切换模式
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
	 * 切换到adjust模式
	 * */
	private void switchToAdjust()
	{
		updateBlurLevel(3);
	}

	/**
	 * 切换到控制模式
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
