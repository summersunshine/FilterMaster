package algorithm;

import java.awt.image.BufferedImage;

import util.ImgUtil;

public class Pencil
{
	public static BufferedImage getImage(BufferedImage image,int sensitivity)
	{
		int width = image.getWidth();
		int height = image.getHeight();

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);


		int m,n;
		for (int i = 0; i < height - 1; i++)
		{
			n = i + 1;
			for (int j = 0; j < width - 1; j++)
			{
				m = j + 1;
				//当前灰度
				int color = getColor(image.getRGB(j, i));
				
				//下一个点的灰度
				int nextColor = getColor(image.getRGB(m, n));
				
				
				if (color - nextColor > sensitivity)
				{
					outputImage.setRGB(j, i, ImgUtil.getRGB(0, 0, 0));
				}
				else
				{
					outputImage.setRGB(j, i, ImgUtil.getRGB(255, 255, 255));
				}
			}
		}

		return outputImage;
	}
	
	
	public static int getColor(int rgb)
	{
		int[] rgbColor = ImgUtil.getSplitRGB(rgb);
		int color = (int) ((rgbColor[0]*3 + rgbColor[1]*6 + rgbColor[2])/10.0);
		return color;
	}
}
