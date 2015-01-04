package gui.jigsaw;

import gui.base.BaseImagePanel;

import java.awt.image.BufferedImage;

import util.image.AlphaMerge;

/**
 * Æ´Í¼Í¼ÏñÃæ°å
 * */
public class JigsawImagePanel extends BaseImagePanel
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

	public void updateImage(int dir)
	{

		displayImage = AlphaMerge.getImageByDir(firstImage, secondImage, dir);

		repaint();
	}
}
