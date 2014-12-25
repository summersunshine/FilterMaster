package gui.partcolor;

import filter.Filter;
import filter.factory.FilterFactory;
import gui.base.ImagePanelWithCursor;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import util.image.Clone;
import util.image.Erase;
import util.image.ImageUtil;
import app.Constants;

public class PartColorImagePanel extends ImagePanelWithCursor
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	// �Ҷ�ͼ��
	private BufferedImage		grayImage;

	private Filter				filter;

	public PartColorImagePanel(BufferedImage image)
	{

		super(image);

		sourceImage = image;

		filter = FilterFactory.getFilter(Constants.TYPE_GRAY);
		grayImage = filter.getImage(image);

		displayImage = Clone.getImage(grayImage);
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
		radius = PartColorSetting.sizeValue;
	}

	/**
	 * ����ͿĨ��λ�ø���ͼ��
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
