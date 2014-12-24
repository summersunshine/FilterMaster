package gui.magicmirror;

import gui.ImagePanel;

import java.awt.image.BufferedImage;

import algorithm.factory.FunImageFactory;

public class MagicMirrorImagePanel extends ImagePanel
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	public MagicMirrorImagePanel(BufferedImage image)
	{
		super(image);
		// TODO Auto-generated constructor stub
		sourceImage = image;
	}

	/**
	 * 依据type和radius更新图像
	 * 
	 * @param type
	 *            类型
	 * @param radius
	 *            半径
	 * */
	public void updateImage(int type, float radius)
	{

		System.out.println("Type " + type + " radius " + radius);

		displayImage = FunImageFactory.getImage(type, sourceImage, radius);

		repaint();
	}
}
