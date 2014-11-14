package algorithm.basic;

import java.awt.image.BufferedImage;

import util.ColorUtil;
import util.HSL;
import util.HSV;
import util.LAB;
import util.RGB;

/**
 * 图像的色相和饱和度
 * */
public class SaturationAndHue
{
	/**
	 * 调节图像的色相和饱和度
	 * 
	 * @param image
	 * @param saturation
	 * @param hue
	 * */
	public static BufferedImage getImage(BufferedImage image, int saturation, int hue)
	{
		

		int width = image.getWidth();
		int height = image.getHeight();

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);


		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				RGB rgb = new RGB(image.getRGB(x, y));
//				HSL hsl = ColorUtil.getHSL(rgb);
//				hsl.h += hue;
//				hsl.s += saturation;
				HSV hsv = ColorUtil.getHSV(rgb);
				hsv.h += hue;
				hsv.s += saturation;
				hsv.clamp();
				
//				LAB value = ColorUtil.getLAB(rgb);
//				value.a +=hue;
//				value.b += saturation;
//				value.clamp();
				
				outputImage.setRGB(x, y, ColorUtil.getRGB(hsv).getRGB());
				
			}
		}

		return outputImage;
	}
}
