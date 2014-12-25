package algorithm.style;

import java.awt.image.BufferedImage;

import util.color.ColorUtil;
import util.color.HSV;
import util.color.RGB;

/**
 * �ƻ�
 * */
public class DuskStyle
{
	public static int		TARGET_HUE			= 60;

	public static final int	MAX_HUE				= 80;

	public static final int	MIN_HUE				= 20;

	public static final int	TARGET_SATURATION	= 30;

	public static final int	MAX_SATURATION		= 50;

	public static final int	MIN_SATURATION		= 10;

	public static BufferedImage getImage(BufferedImage image)
	{
		int height = image.getHeight();
		int width = image.getWidth();

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				RGB rgbValue = new RGB(image.getRGB(x, y));
				HSV hsvValue = ColorUtil.getHSV(rgbValue);
				hsvValue.h = getHue(hsvValue.h);
				// hsvValue.s = getSaturation(hsvValue.s);
				rgbValue = ColorUtil.getRGB(hsvValue);
				outputImage.setRGB(x, y, rgbValue.getRGB());
			}
		}
		return outputImage;

	}

	public static int getHue(int h)
	{

		if (h - TARGET_HUE > 180)
		{
			h -= 360;
		}
		else if (h - TARGET_HUE < -180)
		{
			h += 360;
		}

		if (h > TARGET_HUE)
		{
			return (TARGET_HUE + (MAX_HUE - TARGET_HUE) * ((h - TARGET_HUE)) / (180)) % 360;
		}
		else
		{
			return (TARGET_HUE + (TARGET_HUE - MIN_HUE) * ((h - TARGET_HUE)) / (180)) % 360;
		}

	}

	public static int getSaturation(int s)
	{
		if (s > TARGET_SATURATION)
		{
			return TARGET_SATURATION + (MAX_SATURATION - TARGET_SATURATION) * ((s - TARGET_SATURATION)) / (100 - TARGET_SATURATION);
		}
		else
		{
			return TARGET_SATURATION + (TARGET_SATURATION - MIN_SATURATION) * ((s - TARGET_SATURATION)) / (TARGET_SATURATION);
		}
	}
}