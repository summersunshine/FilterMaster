package algorithm.fashion;

import java.awt.image.BufferedImage;

import util.ImageUtil;
import algorithm.fun.AlphaMerge;

/**
 * ¹âÔÎ
 * */
public class Flare
{
	/**
	 * ±Ê´¥ÂË¾µ
	 * 
	 * @param image
	 * */
	public static BufferedImage getImage(BufferedImage image)
	{
		BufferedImage flareImage = ImageUtil.getImage("res/flare.jpg");
		
		return AlphaMerge.getImage(flareImage,image,0.5f);
	}
}
