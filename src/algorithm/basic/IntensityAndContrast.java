package algorithm.basic;

import java.awt.image.BufferedImage;

import util.ImageUtil;

/**
 * ͼ������ȺͶԱȶ�
 * */
public class IntensityAndContrast
{

	/**
	 * ����ͼ������ȺͶԱȶ�
	 * 
	 * @param image
	 * @param intensity
	 * @param contrast
	 * @param threshod
	 * */
	public static BufferedImage getImage(BufferedImage image, int intensity, int contrast)
	{
		// Ϊ0��ʱ��ֱ�ӷ���ԭͼ�ͺ���
		if (intensity == 0 && contrast == 0)
		{
			return image;
		}

		int width = image.getWidth();
		int height = image.getHeight();
		int threshold = 50;

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		float bv = intensity <= -255 ? -1.0f : intensity / 255.0f;

		if (intensity > 0 && intensity < 255)
		{
			bv = 1.0f / (1.0f - bv) - 1.0f;
		}

		float cv = contrast <= -255 ? -1.0f : contrast / 255.0f;
		if (contrast > 0 && contrast < 255)
		{
			cv = 1.0f / (1.0f - cv) - 1.0f;
		}

		int[] values = new int[256];
		for (int i = 0; i < 256; i++)
		{
			int v = contrast > 0 ? ImageUtil.clampIn255((i + (int) (i * bv + 0.5f))) : i;
			if (contrast >= 255)
			{
				v = v >= threshold ? 255 : 0;
			}
			else
			{
				v = ImageUtil.clampIn255(v + (int) ((v - threshold) * cv + 0.5f));
			}
			values[i] = contrast <= 0 ? ImageUtil.clampIn255(v + (int) (v * bv + 0.5f)) : v;
		}

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				int[] rgb = ImageUtil.getSplitRGB(image.getRGB(x, y));
				int r = values[rgb[0]];
				int g = values[rgb[1]];
				int b = values[rgb[2]];
				outputImage.setRGB(x, y, ImageUtil.getRGB(r, g, b));
			}
		}

		return outputImage;
	}
}
