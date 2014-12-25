package filter.Blur;

import java.awt.Color;

import util.image.ImageUtil;
import filter.Filter;

public class LaserFilter extends Filter
{
	private static float	threshold	= 0.5f;
	private static float	strength	= 0.3f;

	@Override
	public void processor()
	{
		int[] pixels = new int[width];
		int[] srcPixels = new int[width];

		// TODO Auto-generated method stub
		int threshold3 = (int) (threshold * 3 * 255);
		for (int y = 0; y < height; y++)
		{
			ImageUtil.getRGB(image, pixels, 0, y, width, 1);
			for (int x = 0; x < width; x++)
			{
				Color color = new Color(pixels[x]);
				int l = color.getRed() + color.getGreen() + color.getBlue();
				if (l < threshold3)
				{
					pixels[x] = 0xff000000;
				}
				else
				{
					l /= 3;
					pixels[x] = color.getAlpha() | (l << 16) | (l << 8) | l;
				}
			}
			ImageUtil.setRGB(outputImage, pixels, 0, y, width, 1);
		}

		MotionBlurFilter motionBlurFilter = new MotionBlurFilter();

		outputImage = motionBlurFilter.getImage(outputImage);

		for (int y = 0; y < height; y++)
		{
			ImageUtil.getRGB(outputImage, pixels, 0, y, width, 1);
			ImageUtil.getRGB(image, srcPixels, 0, y, width, 1);
			for (int x = 0; x < width; x++)
			{
				int rgb = pixels[x];
				int rgb2 = srcPixels[x];
				Color color1 = new Color(rgb);
				Color color2 = new Color(rgb2);

				if (color1.getRed() > 0)
				{
					int r = (int) (color1.getRed() * strength) + color2.getRed();
					int g = (int) (color1.getGreen() * strength) + color2.getGreen();
					int b = (int) (color1.getBlue() * strength) + color2.getBlue();

					r = ImageUtil.clampIn255(r);
					g = ImageUtil.clampIn255(g);
					b = ImageUtil.clampIn255(b);

					color1 = new Color(r, g, b, color1.getAlpha());
				}
				else
				{
					color1 = color2;
				}

				pixels[x] = color1.getRGB();
			}
			ImageUtil.setRGB(outputImage, pixels, 0, y, width, 1);
		}
	}

}
