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
	 * ����type��radius����ͼ��
	 * 
	 * @param type
	 *            ����
	 * @param radius
	 *            �뾶
	 * */
	public void updateImage(int type, float radius)
	{

		System.out.println("Type " + type + " radius " + radius);

		displayImage = FunImageFactory.getImage(type, sourceImage, radius);

		repaint();
	}
}
