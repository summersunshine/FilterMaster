package filter.fun;

import java.awt.image.BufferedImage;

import util.geometry.Geometry;
import util.image.ImageUtil;
import filter.Filter;

public class ConcaveMirrorFilter extends Filter
{
	public static float	radius	= 1000;
	public static float	change	= 1;

	@Override
	public void processor()
	{
		// TODO Auto-generated method stub
		int centerX = width / 2;
		int centerY = height / 2;

		float max = Geometry.getDistance(0, 0, centerX, centerY);
		radius = radius > max ? max : radius;

		outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{

				int distance = Geometry.getDistance(x, y, centerX, centerY);
				if (distance > radius)
				{
					outputImage.setRGB(x, y, image.getRGB(x, y));
				}
				else
				{

					float radio = distance / radius;
					radio = 1.5f / (0.5f + radio);
					float srcX = (float) ((x - centerX) / change);
					float srcY = (float) ((y - centerY) / change);
					srcX = (int) (srcX * radio);
					srcY = (int) (srcY * radio);
					srcX += centerX;
					srcY += centerY;

					// 判断，如果是画面上，就使用对应的颜色
					// 否则，使用黑色来进行填充
					if (ImageUtil.isInsideImage(image, (int) srcX, (int) srcY))
					{
						outputImage.setRGB(x, y, image.getRGB((int) srcX, (int) srcY));
					}
					else
					{
						outputImage.setRGB(x, y, ImageUtil.getRGB(0, 0, 0));
					}

				}
			}
		}
	}

}
