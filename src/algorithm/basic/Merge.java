package algorithm.basic;

import java.awt.image.BufferedImage;


/**
 * �򵥵ĸ�һ��ͼ�����һ��͸��ͼ��
 * */
public class Merge
{
	public static BufferedImage getImage(BufferedImage image,BufferedImage alphaImage)
	{
		int width = image.getWidth();
		int height = image.getHeight();

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				int rgb = alphaImage.getRGB(x, y);
				if (rgb>>24!=0)
				{
					image.setRGB(x, y, rgb);
				}
			}
		}

		return image;
	}
	
}
