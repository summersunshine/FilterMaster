package algorithm.fashion;

import java.awt.image.BufferedImage;

import util.ImgUtil;
import algorithm.fun.AlphaMerge;

/**
 * ÄÞºç
 * */
public class Rainbow
{
	/**
	 * ±Ê´¥ÂË¾µ
	 * 
	 * @param image
	 * */
	public static BufferedImage getImage(BufferedImage image)
	{

		// return Frame.getImage(image, 2);

		BufferedImage paperImage = ImgUtil.getImg("res/rainbow.jpg");

		return AlphaMerge.getImage(paperImage, image, 0.5f);
	}
}
