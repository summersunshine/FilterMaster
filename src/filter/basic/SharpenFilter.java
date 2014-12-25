package filter.basic;

import util.ImageUtil;
import util.color.RGB;
import filter.Filter;

public class SharpenFilter extends Filter
{

	@Override
	public void processor()
	{
		// TODO Auto-generated method stub
		RGB[][] imageMatrix = new RGB[width][height];
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				RGB rgb = new RGB(image.getRGB(j, i));
				imageMatrix[j][i] = rgb;
			}
		}

		int[] templates = { -1, -4, -7, -4, -1, -4, -16, -26, -16, -4, -7, -26, 505, -26, -7, -4, -16, -26, -16, -4, -1, -4, -7, -4, -1 };

		for (int y = 2; y < height - 2; y++)
		{
			for (int x = 2; x < width - 2; x++)
			{
				int sumR = 0;
				int sumG = 0;
				int sumB = 0;
				int index = 0;
				for (int m = x - 2; m < x + 3; m++)
				{
					for (int n = y - 2; n < y + 3; n++)
					{
						sumR += imageMatrix[m][n].r * templates[index];
						sumG += imageMatrix[m][n].g * templates[index];
						sumB += imageMatrix[m][n].b * templates[index++];
					}
				}
				sumR /= 273;
				sumG /= 273;
				sumB /= 273;

				sumR = ImageUtil.clampIn255(sumR);
				sumG = ImageUtil.clampIn255(sumG);
				sumB = ImageUtil.clampIn255(sumB);

				outputImage.setRGB(x, y, ImageUtil.getRGB(sumR, sumG, sumB));
			}
		}
	}
}
