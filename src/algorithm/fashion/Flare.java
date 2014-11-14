package algorithm.fashion;

import java.awt.image.BufferedImage;

import util.ImgUtil;
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
		BufferedImage flareImage = ImgUtil.getImg("res/glass.jpg");
		
		return AlphaMerge.getImage(flareImage,image,0.2f);
	}
}
