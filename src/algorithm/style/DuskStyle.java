package algorithm.style;

import java.awt.Color;
import java.awt.image.BufferedImage;

import util.ColorUtil;
import util.HSV;
import util.ImgUtil;
import util.RGB;

/**
 * »Æ»è
 * */
public class DuskStyle
{
	public static int TARGET_HUE = 240;
	public static float ratio = 3f;
	
	public static BufferedImage getImage(BufferedImage image)
	{
		int height = image.getHeight();
		int width = image.getWidth();

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				RGB rgbValue =  new RGB(image.getRGB(x, y));
//				HSV hsvValue = ColorUtil.getHSV(rgbValue);
//				hsvValue.h = getHue(hsvValue.h);
//				rgbValue = ColorUtil.getRGB(hsvValue);
				rgbValue.r+=20;
				rgbValue.g
				
				+=20;
				outputImage.setRGB(x, y, rgbValue.getRGB());
			}
		}
		return outputImage;

	}
	
	
	public static int getHue(int h)
	{
		//return TARGET_HUE;
		return (int) (TARGET_HUE + (h-TARGET_HUE)/ratio);
	}
}