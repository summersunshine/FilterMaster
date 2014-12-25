package gui.partmosaic;

import gui.ImagePanelWithCursor;

import java.awt.image.BufferedImage;

import util.ImageUtil;
import algorithm.basic.Erase;
import algorithm.fun.Mosaic;
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
			updateImage(Mosaic.getImage(displayImage, PartMosaicSetting.patchValue, displayX, displayY, PartMosaicSetting.sizeValue));
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
		displayImage = Mosaic.getImage(sourceImage, patchValue);

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
