package gui.magicmirror;

import gui.ImagePanel;

import java.awt.image.BufferedImage;

import algorithm.FunImageFactory;

public class MagicMirrorImagePanel extends ImagePanel
{

	public MagicMirrorImagePanel(BufferedImage image)
	{
		super(image);
		// TODO Auto-generated constructor stub

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
