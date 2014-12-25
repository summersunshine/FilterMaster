package algorithm.fashion;

import java.awt.image.BufferedImage;

import util.ImageUtil;
import algorithm.fun.AlphaMerge;



/**
 * ¼«¹â
 * */
public class Photon
{
	/**
	 * ±Ê´¥ÂË¾µ
	 * 
	 * @param image
	 * */
	public static BufferedImage getImage(BufferedImage image)
	{
		BufferedImage paperImage = ImageUtil.getImage("res/photon.jpg");
		
		return AlphaMerge.getImage(paperImage,image,0.5f);
	}
}
