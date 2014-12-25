package filter.lomo;

import util.ImageUtil;
import util.geometry.Geometry;
import filter.Filter;

public class ClassicalLomoFilter extends Filter
{

	@Override
	public void processor()
	{
		float radius = width < height ? height : width;

		// TODO Auto-generated method stub
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{

				int distance = Geometry.getDistance(y, x, height / 2, width / 2);
				if (distance > radius)
				{
					outputImage.setRGB(x, y, ImageUtil.getRGB(0, 0, 0));
				}
				else
				{
					int[] rgb = ImageUtil.getSplitRGB(image.getRGB(x, y));
					float ratio = (float) (1 - distance * 1.0 / radius);
					int r = (int) (rgb[0] * ratio);
					int g = (int) (rgb[1] * ratio);
					int b = (int) (rgb[2] * ratio);
					outputImage.setRGB(x, y, ImageUtil.getRGB(r, g, b));
				}
			}
		}

	}

}
