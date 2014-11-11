package gui.jigsaw;

import gui.ImagePanel;

import java.awt.image.BufferedImage;

import algorithm.FunImageFactory;
import algorithm.fun.AlphaMerge;

/**
 * ƴͼͼ�����
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

	public void updateImage(int type)
	{
		displayImage = FunImageFactory.getImage(type, firstImage, secondImage);

		repaint();
	}
}
