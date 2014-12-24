package filter.lomo;

import util.Geometry;
import util.ImgUtil;
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
					outputImage.setRGB(x, y, ImgUtil.getRGB(0, 0, 0));
				}
				else
				{
					int[] rgb = ImgUtil.getSplitRGB(image.getRGB(x, y));
					float ratio = (float) (1 - distance * 1.0 / radius);
					int r = (int) (rgb[0] * ratio);
					int g = (int) (rgb[1] * ratio);
					int b = (int) (rgb[2] * ratio);
					outputImage.setRGB(x, y, ImgUtil.getRGB(r, g, b));
				}
			}
		}

	}

}
