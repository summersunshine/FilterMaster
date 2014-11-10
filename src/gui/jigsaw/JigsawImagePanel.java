package gui.jigsaw;

import java.awt.image.BufferedImage;

import algorithm.FunImageFactory;
import algorithm.ImageFactory;
import algorithm.fun.AlphaMerge;
import gui.ImagePanel;

/**
 * Æ´Í¼Í¼ÏñÃæ°å
 * */
public class JigsawImagePanel extends ImagePanel
{

	private BufferedImage firstImage;
	private BufferedImage secondImage;

	public JigsawImagePanel(BufferedImage firstImage, BufferedImage secondImage)
	{
		super(AlphaMerge.getImage(firstImage, secondImage));
		// TODO Auto-generated constructor stub

		this.firstImage = firstImage;
		this.secondImage = secondImage;

	}

	public void setImage(int type)
	{
		displayImage = FunImageFactory.getImage(type, firstImage, secondImage);

		repaint();
	}
}
