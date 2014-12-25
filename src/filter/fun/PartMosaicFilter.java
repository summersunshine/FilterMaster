package filter.fun;

import util.geometry.Geometry;
import util.image.ImageUtil;

public class PartMosaicFilter extends MosaicFilter
{

	public static int	centerX;
	public static int	centerY;
	public static int	radius;
	public static int	size;

	@Override
	public void processor()
	{
		// TODO Auto-generated method stub
		int startX = centerX - radius;
		int startY = centerY - radius;
		int endX = centerX + radius;
		int endY = centerY + radius;

		outputImage = image;
		for (int y = startY; y < endY; y++)
		{
			for (int x = startX; x < endX; x++)
			{

				if (Geometry.getDistance(x, y, centerX, centerY) < radius && ImageUtil.isInsideImage(image, x, y))
				{
					int targetX = (x / size) * size;
					int targetY = (y / size) * size;
					outputImage.setRGB(x, y, image.getRGB(targetX, targetY));
				}
			}
		}
	}

}
