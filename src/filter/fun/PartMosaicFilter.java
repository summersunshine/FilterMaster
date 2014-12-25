package filter.fun;

import util.ImageUtil;
import util.geometry.Geometry;

public class PartMosaicFilter extends MosaicFilter
{

	public static int	centerX;
	public static int	centerY;
	public static int	radius;

	@Override
	public void processor()
	{
		// TODO Auto-generated method stub
		int startX = centerX - radius;
		int startY = centerY - radius;
		int endX = centerX + radius;
		int endY = centerY + radius;

		for (int y = startY; y < endY; y++)
		{
			for (int x = startX; x < endX; x++)
			{

				if (Geometry.getDistance(x, y, centerX, centerY) < radius && ImageUtil.isInsideImage(image, x, y))
				{
					int targetX = (x / size) * size;
					int targetY = (y / size) * size;
					image.setRGB(x, y, image.getRGB(targetX, targetY));
				}
			}
		}
	}

}
