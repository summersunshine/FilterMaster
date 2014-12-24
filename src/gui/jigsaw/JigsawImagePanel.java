package gui.jigsaw;

import gui.ImagePanel;

import java.awt.image.BufferedImage;

import algorithm.factory.FunImageFactory;
import algorithm.fun.AlphaMerge;

/**
 * Æ´Í¼Í¼ÏñÃæ°å
 * */
public class JigsawImagePanel extends ImagePanel
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private BufferedImage		firstImage;
	private BufferedImage		secondImage;

	public JigsawImagePanel(BufferedImage firstImage, BufferedImage secondImage)
	{
		super(AlphaMerge.getImage(firstImage, secondImage));
		// TODO Auto-generated constructor stub

		this.firstImage = firstImage;
		this.secondImage = secondImage;

	}

	public void updateImage(int type)
	{
		displayImage = FunImageFactory.getImage(type, firstImage, secondImage);

		repaint();
	}
}
