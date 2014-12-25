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

	// ԭʼͼ��
	private BufferedImage		sourceImage;

	public PartMosaicImagePanel(BufferedImage image)
	{

		super(image);

		sourceImage = image;
	}

	/**
	 * ���ù��ΪԲ��
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
	 * ����ͿĨ��λ�ø���ͼ��
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
	 * ����patchValue����ͼ��
	 * 
	 * @param patchValue
	 *            �����˿�Ĵ�С
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
