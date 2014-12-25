package filter.fun;

import java.awt.image.BufferedImage;

import util.ImageUtil;
import util.geometry.Geometry;
import filter.Filter;

public class ConvexMirrorFilter extends Filter
{
	public static float	radius	= 1000;
	public static float	change	= 1;

	@Override
	public void processor()
	{
		// TODO Auto-generated method stub
		int width = image.getWidth();
		int height = image.getHeight();
		int centerX = width / 2;
		int centerY = height / 2;
		float max = width > height ? width / 2 : height / 2;
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

					float srcX = (float) ((x - centerX) / change);
					float srcY = (float) ((y - centerY) / change);
					srcX = (int) (srcX * distance / radius);
					srcY = (int) (srcY * distance / radius);
					srcX += centerX;
					srcY += centerY;

					// �жϣ�����ǻ����ϣ���ʹ�ö�Ӧ����ɫ
					// ����ʹ�ú�ɫ���������
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
