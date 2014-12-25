package gui.partmosaic;

import filter.fun.MosaicFilter;
import filter.fun.PartMosaicFilter;
import gui.base.ImagePanelWithCursor;

import java.awt.image.BufferedImage;

import util.image.Erase;
import util.image.ImageUtil;
import app.Constants;

public class PartMosaicImagePanel extends ImagePanelWithCursor
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	private BufferedImage		circleImage;

	// 原始图像
	private BufferedImage		sourceImage;

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

		setCircleImage(ImageUtil.getImage("res/circle.png"));

	}

	@Override
	public void setCursorImage()
	{
		// TODO Auto-generated method stub
		cursorImage = ImageUtil.getImage("res/circle.png");
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
			PartMosaicFilter partMosaicFilter = new PartMosaicFilter();
			PartMosaicFilter.size = PartMosaicSetting.patchValue;
			PartMosaicFilter.radius = PartMosaicSetting.sizeValue;
			PartMosaicFilter.centerX = displayX;
			PartMosaicFilter.centerY = displayY;
			BufferedImage bufferedImage = partMosaicFilter.getImage(displayImage);
			updateImage(bufferedImage);
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
		MosaicFilter mosaicFilter = new MosaicFilter();
		MosaicFilter.size = patchValue;
		displayImage = mosaicFilter.getImage(sourceImage);

		repaint();
	}

	public BufferedImage getCircleImage()
	{
		return circleImage;
	}

	public void setCircleImage(BufferedImage circleImage)
	{
		this.circleImage = circleImage;
	}

}
