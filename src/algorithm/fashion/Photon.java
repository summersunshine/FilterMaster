package algorithm.fashion;

import java.awt.image.BufferedImage;

import util.ImgUtil;
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
		BufferedImage paperImage = ImgUtil.getImg("res/photon.jpg");
		
		return AlphaMerge.getImage(paperImage,image,0.5f);
	}
}
