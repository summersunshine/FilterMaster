package algorithm.basic;

import java.awt.image.BufferedImage;

import util.ImgUtil;


/**
 * 缩放图片到制定大小
 * */
public class Scale
{
	public static BufferedImage getImage(BufferedImage image,int width,int height)
	{
		int sourceWidth = image.getWidth();
		int sourceHeight = image.getHeight();
		float ratioWidth = sourceWidth*1.0f/image.getWidth();
		float ratioHeight = sourceHeight*1.0f/image.getHeight();
		
		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				int outX = (int) (x*ratioWidth);
				int outY = (int) (y*ratioHeight);
				outputImage.setRGB(x, y, image.getRGB(outX, outY));
			}
		}

		return outputImage;
	}
}
