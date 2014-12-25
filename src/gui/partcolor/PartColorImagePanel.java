package gui.partcolor;

import filter.Filter;
import filter.factory.FilterFactory;
import gui.ImagePanelWithCursor;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import util.ImageUtil;
import algorithm.basic.Erase;
import algorithm.basic.Gray;
import app.Constants;

public class PartColorImagePanel extends ImagePanelWithCursor
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	// 灰度图像
	private BufferedImage		grayImage;

	private Filter				filter;

	public PartColorImagePanel(BufferedImage image)
	{

		super(Gray.getImage(image));

		sourceImage = image;

		filter = FilterFactory.getFilter(Constants.TYPE_GRAY);
		grayImage = filter.getImage(image);
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
		radius = PartColorSetting.sizeValue;
	}

	/**
	 * 根据涂抹的位置更新图像
	 * 
	 * @param x
	 * @param y
	 * */
	@Override
	public void updateImage(int x, int y)
	{
		super.updateImage(x, y);

		if (PartColorSetting.type == Constants.TYPE_ERASE)
		{
			this.updateImage(Erase.getImage(displayImage, sourceImage, displayX, displayY, PartColorSetting.sizeValue));
		}
		else
		{
			this.updateImage(Erase.getImage(displayImage, grayImage, displayX, displayY, PartColorSetting.sizeValue));
		}

	}

}
