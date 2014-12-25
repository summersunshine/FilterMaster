package algorithm.fashion;

import java.awt.image.BufferedImage;

import util.ImageUtil;
import algorithm.fun.AlphaMerge;

/**
 * ����
 * */
public class Flare
{
	/**
	 * �ʴ��˾�
	 * 
	 * @param image
	 * */
	public static BufferedImage getImage(BufferedImage image)
	{
		BufferedImage flareImage = ImageUtil.getImage("res/flare.jpg");
		
		return AlphaMerge.getImage(flareImage,image,0.5f);
	}
}
