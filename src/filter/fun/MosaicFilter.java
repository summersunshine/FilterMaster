package filter.fun;

import filter.Filter;

public class MosaicFilter extends Filter
{

	public static int	size	= 12;

	@Override
	public void processor()
	{
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{

				int targetX = (x / size) * size;
				int targetY = (y / size) * size;
				outputImage.setRGB(x, y, image.getRGB(targetX, targetY));

			}
		}

	}

}
