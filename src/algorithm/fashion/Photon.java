package algorithm.fashion;

import java.awt.image.BufferedImage;

import util.ImageUtil;
import algorithm.fun.AlphaMerge;



/**
 * ����
 * */
public class Photon
{
	/**
	 * �ʴ��˾�
	 * 
	 * @param image
	 * */
	public static BufferedImage getImage(BufferedImage image)
	{
		BufferedImage paperImage = ImageUtil.getImage("res/photon.jpg");
		
		return AlphaMerge.getImage(paperImage,image,0.5f);
	}
}
