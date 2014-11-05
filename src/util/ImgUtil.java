package util;

import java.awt.image.BufferedImage;

public class ImgUtil
{
	
	public static int[] getSplitRGB(int rgb)
	{
		int[] rgbs = new int[3];
		rgbs[0] = (rgb & 0xff0000) >> 16;
		rgbs[1] = (rgb & 0xff00) >> 8;
		rgbs[2] = (rgb & 0xff);
		return rgbs;
	}

	public static int getRGB(int r, int g, int b)
	{
		r = r << 16;
		g = g << 8;

		return (r | g | b);
	}
	
	public static int clamp(int c)
	{
		if (c < 0)
			return 0;
		if (c > 255)
			return 255;
		return c;
	}
	
	public static void getRGB(BufferedImage image,int[] inPixels)
	{
		// TODO Auto-generated method stub
		
		int count = 0;
		for (int y = 0; y < image.getHeight(); y++)
		{
			for (int x = 0; x < image.getWidth(); x++)
			{
				inPixels[count++] = image.getRGB(x, y);
			}
		}

	}  
	
	public static void getRGB(BufferedImage image,int[] inPixels,int startX,int startY,int width,int height)
	{
		// TODO Auto-generated method stub
		
		int count = 0;
		for (int y = startY; y < startY + height; y++)
		{
			for (int x = startX; x < startX + width; x++)
			{
				inPixels[count++] = image.getRGB(x, y);
			}
		}

	}  
	
	
	public static void setRGB(BufferedImage image,int[] outPixels)
	{
		// TODO Auto-generated method stub
		
		int count = 0;
		for (int y = 0; y < image.getHeight(); y++)
		{
			for (int x = 0; x < image.getWidth(); x++)
			{
				image.setRGB(x, y, outPixels[count++]);
			}
		}

	}  
	
	
	public static void setRGB(BufferedImage image,int[] outPixels,int startX,int startY,int width,int height)
	{
		// TODO Auto-generated method stub
		
		int count = 0;
		for (int y = startY; y < startY + height; y++)
		{
			for (int x = startX; x < startX + width; x++)
			{
				image.setRGB(x, y, outPixels[count++]);
			}
		}

	}  
	
}
