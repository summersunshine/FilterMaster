package algorithm.fashion;

import java.awt.image.BufferedImage;

import util.ImageUtil;
import algorithm.basic.Sharpen;
import algorithm.fun.AlphaMerge;

/**
 * ��Ƥֽ
 * */
public class Parchment
{
	/**
	 * �ʴ��˾�
	 * 
	 * @param image
	 * */
	public static BufferedImage getImage(BufferedImage image)
	{
		BufferedImage paperImage = ImageUtil.getImage("res/paper.jpg");

		return AlphaMerge.getImage(paperImage, Sharpen.getImage(image), 0.5f);
	}
}
