package algorithm.fashion;

import java.awt.image.BufferedImage;

import util.ImageUtil;
import algorithm.basic.Sharpen;
import algorithm.fun.AlphaMerge;

/**
 * ÑòÆ¤Ö½
 * */
public class Parchment
{
	/**
	 * ±Ê´¥ÂË¾µ
	 * 
	 * @param image
	 * */
	public static BufferedImage getImage(BufferedImage image)
	{
		BufferedImage paperImage = ImageUtil.getImage("res/paper.jpg");

		return AlphaMerge.getImage(paperImage, Sharpen.getImage(image), 0.5f);
	}
}
