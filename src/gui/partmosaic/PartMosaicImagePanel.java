package gui.partmosaic;

import gui.ImagePanelWithCursor;

import java.awt.image.BufferedImage;

import util.ImgUtil;
import algorithm.basic.Erase;
import algorithm.fun.Mosaic;
import app.Constants;

public class PartMosaicImagePanel extends ImagePanelWithCursor
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	public BufferedImage		circleImage;

	// 原始图像
	public BufferedImage		sourceImage;

	public PartMosaicImagePanel(BufferedImage image)
	{

		super(image);

		sourceImage = image;
	}

	/**
	 * 设置光标为圆形
	 * */
	public void setCircleCursor()
	{
		// TODO Auto-generated method stub
		System.out.println("change cursor");

		circleImage = ImgUtil.getImg("res/circle.png");

		// Toolkit tk = Toolkit.getDefaultToolkit();

		// Cursor cursor = tk.createCustomCursor(circleImage, new Point(16, 16),
		// "blur");

		// setCursor(cursor);
	}

	@Override
	public void setCursorImage()
	{
		// TODO Auto-generated method stub
		cursorImage = ImgUtil.getImg("res/circle.png");
	}

	public void setCursorRadius()
	{
		radius = PartMosaicSetting.sizeValue;
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

		if (PartMosaicSetting.type == Constants.TYPE_ERASE)
		{
			updateImage(Erase.getImage(displayImage, sourceImage, displayX, displayY, PartMosaicSetting.sizeValue));
		}
		else
		{
			updateImage(Mosaic.getImage(displayImage, PartMosaicSetting.patchValue, displayX, displayY, PartMosaicSetting.sizeValue));
		}
	}

	/**
	 * 依据patchValue更新图像
	 * 
	 * @param patchValue
	 *            马赛克块的大小
	 * */
	public void updateImage(int patchValue)
	{
		displayImage = Mosaic.getImage(sourceImage, patchValue);

		repaint();
	}

}
