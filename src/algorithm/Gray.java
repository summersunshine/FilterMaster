package algorithm;

import java.awt.image.BufferedImage;

import util.ImgUtil;

public class Gray
{
	public static BufferedImage getImage(BufferedImage rgbImage)
	{
		int width = rgbImage.getWidth();
		int height = rgbImage.getHeight();
		BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				int []rgb = ImgUtil.getSplitRGB(rgbImage.getRGB(j, i));
				int averageRgb = (rgb[0] + rgb[1] + rgb[2])/3;
				grayImage.setRGB(j, i, ImgUtil.getRGB(averageRgb,averageRgb,averageRgb));
			}
		}
		
		return grayImage;
	}
}
