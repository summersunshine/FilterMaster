package algorithm.fun;

import java.awt.image.BufferedImage;

import util.Geometry;
import util.ImgUtil;

public class MagicMirror
{

	// 凸透镜
	public static final int TYPE_CONVEX = 1;
	// 凹透镜
	public static final int TYPE_CONCAVE = 2;

	public static float change = 1;

	
	public static BufferedImage getImage(BufferedImage image, int type,float radius)
	{
		if (type == TYPE_CONVEX)
		{
			return getConvexImage(image,radius);
		} else
		{
			return getConcaveImage(image,radius);
		}
	}
	

	public static BufferedImage getImage(BufferedImage image, int type)
	{
		if (type == TYPE_CONVEX)
		{
			return getConvexImage(image);
		} else
		{
			return getConcaveImage(image);
		}
	}
	
	

	private static BufferedImage getConcaveImage(BufferedImage image)
	{
		// TODO Auto-generated method stub
		return getConcaveImage(image,100000);
	}

	private static BufferedImage getConvexImage(BufferedImage image)
	{
		// TODO Auto-generated method stub
		return getConvexImage(image,100000);
	}
	


	// 凸透镜
	public static BufferedImage getConvexImage(BufferedImage image,float radius)
	{
		int width = image.getWidth();
		int height = image.getHeight();
		int centerX = width / 2;
		int centerY = height / 2;
		float max = width > height ? width / 2 : height / 2;
		radius = radius>max?max:radius;

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{

				int distance = Geometry.getDistance(x, y, centerX, centerY);
				if (distance > radius)
				{
					outputImage.setRGB(x, y, image.getRGB(x, y));
				} else
				{

					float srcX = (float) ((x - centerX) / change);
					float srcY = (float) ((y - centerY) / change);
					srcX = (int) (srcX * distance / radius);
					srcY = (int) (srcY * distance / radius);
					srcX += centerX;
					srcY += centerY;

					// 判断，如果是画面上，就使用对应的颜色
					// 否则，使用黑色来进行填充
					if (ImgUtil.isInsideImage(image, (int) srcX, (int) srcY))
					{
						outputImage.setRGB(x, y, image.getRGB((int) srcX, (int) srcY));
					} else
					{
						outputImage.setRGB(x, y, ImgUtil.getRGB(0, 0, 0));
					}

				}
			}
		}

		return outputImage;
	}

	// 凹透镜
	public static BufferedImage getConcaveImage(BufferedImage image,float radius)
	{
		int width = image.getWidth();
		int height = image.getHeight();
		int centerX = width / 2;
		int centerY = height / 2;

		float max = Geometry.getDistance(0, 0, centerX, centerY);
		radius = radius>max?max:radius;

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{

				int distance = Geometry.getDistance(x, y, centerX, centerY);
				if (distance > radius)
				{
					outputImage.setRGB(x, y, image.getRGB(x, y));
				} else
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
					if (ImgUtil.isInsideImage(image, (int) srcX, (int) srcY))
					{
						outputImage.setRGB(x, y, image.getRGB((int) srcX, (int) srcY));
					} else
					{
						outputImage.setRGB(x, y, ImgUtil.getRGB(0, 0, 0));
					}

				}
			}
		}

		return outputImage;
	}
}
