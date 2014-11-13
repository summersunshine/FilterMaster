package algorithm.style;

import java.awt.image.BufferedImage;

import util.ColorUtil;
import util.HSV;
import util.RGB;


/**
 * Заґє
 * */
public class YouthStyle
{

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
				HSV hsvValue = ColorUtil.getHSV(rgbValue);
				hsvValue.h = (int) (120 + (hsvValue.h-120)/1.4f);
				hsvValue.s -= 5;
				rgbValue = ColorUtil.getRGB(hsvValue);
				outputImage.setRGB(x, y, rgbValue.getRGB());
			}
		}
		return outputImage;

	}
	
}
