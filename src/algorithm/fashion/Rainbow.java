package algorithm.fashion;

import java.awt.image.BufferedImage;

import util.ImageUtil;
import algorithm.fun.AlphaMerge;

/**
 * �޺�
 * */
public class Rainbow
{
	/**
	 * �ʴ��˾�
	 * 
	 * @param image
	 * */
	public static BufferedImage getImage(BufferedImage image)
	{

		// return Frame.getImage(image, 2);

		BufferedImage paperImage = ImageUtil.getImage("res/rainbow.jpg");

		return AlphaMerge.getImage(paperImage, image, 0.5f);
	}
}
