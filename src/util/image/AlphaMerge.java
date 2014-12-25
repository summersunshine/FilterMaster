package util.image;

import java.awt.image.BufferedImage;

/**
 * Alpha融合
 * */
public class AlphaMerge
{

	// 无方向
	public static final int DIR_NO = 0;

	// 从左到右
	public static final int DIR_LEFT_2_RIGHT = 1;

	// 从右到左
	public static final int DIR_RIGHT_2_LEFT = 2;

	// 从上到下
	public static final int DIR_UP_2_DOWN = 3;

	// 从下到上
	public static final int DIR_DOWN_2_UP = 4;

	// 以最小的长宽进行融合
	public static int MERGE_TYPE_MIN = 1;

	// 以最小的长宽进行融合并拉伸
	public static int MERGE_TYPE_MIN_SCALE = 2;

	// 以最大的长宽进行融合
	public static int MERGE_TYPE_MAX = 3;

	// 以最大的长宽进行融合并拉伸
	public static int MERGE_TYPE_MAX_SCALE = 4;

	// 以第一张图片的长宽进行融合
	public static int MERGE_TYPE_IMAGE_1 = 5;

	// 以第二张图片的长宽进行融合
	public static int MERGE_TYPE_IMAGE_2 = 6;

	public static int targetWidth;
	public static int targetHeight;

	public static float ratioX1;
	public static float ratioY1;

	public static float ratioX2;
	public static float ratioY2;

	public static BufferedImage getImage(BufferedImage image1, BufferedImage image2)
	{
		setSizeAndRatio(image1, image2, MERGE_TYPE_MIN_SCALE);
		return scanForNoDir(image1, image2, 0.5f);
	}

	/**
	 * @param image1
	 *            需要融合的图像1
	 * @param image2
	 *            需要融合的图像2
	 * @param alpha
	 *            扫描的方向
	 * @param type
	 *            拼合的方式
	 * */
	public static BufferedImage getImage(BufferedImage image1, BufferedImage image2, float alpha)
	{
		setSizeAndRatio(image1, image2, MERGE_TYPE_MIN_SCALE);
		return scanForNoDir(image1, image2, alpha);
	}

	/**
	 * @param image1
	 *            需要融合的图像1
	 * @param image2
	 *            需要融合的图像2
	 * @param dir
	 *            扫描的方向
	 * @param type
	 *            拼合的方式
	 * */
	public static BufferedImage getImage(BufferedImage image1, BufferedImage image2, int type)
	{
		setSizeAndRatio(image1, image2, type);
		return scanForNoDir(image1, image2, 0.5f);
	}

	/**
	 * @param image1
	 *            需要融合的图像1
	 * @param image2
	 *            需要融合的图像2
	 * @param dir
	 *            扫描的方向
	 * @param type
	 *            拼合的方式
	 * */
	public static BufferedImage getImage(BufferedImage image1, BufferedImage image2, int type, int dir)
	{
		setSizeAndRatio(image1, image2, type);

		if (dir == DIR_LEFT_2_RIGHT)
		{
			return scanFromLeftToRight(image1, image2);
		}
		else if (dir == DIR_RIGHT_2_LEFT)
		{
			return scanFromRightToLeft(image1, image2);
		}
		else if (dir == DIR_UP_2_DOWN)
		{
			return scanFromUpToDown(image1, image2);
		}
		else if (dir == DIR_DOWN_2_UP)
		{
			return scanFromDownToUp(image1, image2);
		}
		else
		{
			return scanForNoDir(image1, image2, 0.5f);
		}
	}

	/**
	 * 依据type设置新图像的大小以及源图像的缩放比例
	 * 
	 * @param image1
	 * @param image2
	 * @param type
	 * */
	public static void setSizeAndRatio(BufferedImage image1, BufferedImage image2, int type)
	{
		if (type == MERGE_TYPE_MIN)
		{
			setSizeForMin(image1, image2);
			setRatioForNoScale();
		}
		else if (type == MERGE_TYPE_MIN_SCALE)
		{
			setSizeForMin(image1, image2);
			setRatioForScale(image1, image2);
		}
		else if (type == MERGE_TYPE_MAX)
		{
			setSizeForMax(image1, image2);
			setRatioForNoScale();
		}
		else if (type == MERGE_TYPE_MAX_SCALE)
		{
			setSizeForMax(image1, image2);
			setRatioForScale(image1, image2);
		}
		else if (type == MERGE_TYPE_IMAGE_1)
		{
			targetWidth = image1.getWidth();
			targetHeight = image1.getHeight();
			setRatioForScale(image1, image2);
		}
		else
		{
			targetWidth = image2.getWidth();
			targetHeight = image2.getHeight();
			setRatioForScale(image1, image2);
		}

		printInfo(type);
	}

	/**
	 * 选取两个图像最小的长宽作为目标图像的长宽
	 * 
	 * @param image1
	 * @param image2
	 * */
	public static void setSizeForMin(BufferedImage image1, BufferedImage image2)
	{
		targetWidth = image1.getWidth() < image2.getWidth() ? image1.getWidth() : image2.getWidth();
		targetHeight = image1.getHeight() < image2.getHeight() ? image1.getHeight() : image2.getHeight();
	}

	/**
	 * 选取两个图像最大的长宽作为目标图像的长宽
	 * 
	 * @param image1
	 * @param image2
	 * */
	public static void setSizeForMax(BufferedImage image1, BufferedImage image2)
	{
		targetWidth = image1.getWidth() > image2.getWidth() ? image1.getWidth() : image2.getWidth();
		targetHeight = image1.getHeight() > image2.getHeight() ? image1.getHeight() : image2.getHeight();
	}

	/**
	 * 当没有缩放的时候，缩放比例均为1
	 * */
	public static void setRatioForNoScale()
	{
		ratioX1 = ratioX2 = ratioY1 = ratioY2 = 1;
	}

	/**
	 * 有缩放的时候计算缩放比例
	 * 
	 * @param image1
	 * @param image2
	 * */
	public static void setRatioForScale(BufferedImage image1, BufferedImage image2)
	{
		// 如果宽度取自image1
		if (targetWidth == image1.getWidth())
		{
			ratioX1 = 1;
			ratioX2 = image2.getWidth() * 1.0f / targetWidth;
		}
		// 如果宽度取自image2
		else
		{
			ratioX1 = image1.getWidth() * 1.0f / targetWidth;
			ratioX2 = 1;
		}

		// 如果高度取自image1
		if (targetHeight == image1.getHeight())
		{
			ratioY1 = 1;
			ratioY2 = image2.getHeight() * 1.0f / targetHeight;
		}
		// 如果高度取自image2
		else
		{
			ratioY1 = image1.getHeight() * 1.0f / targetHeight;
			ratioY2 = 1;
		}
	}

	public static void printInfo(int type)
	{
//		System.out.println("ratioX1 " + ratioX1);
//		System.out.println("ratioY1 " + ratioY1);
//		System.out.println("ratioX2 " + ratioX2);
//		System.out.println("ratioY2 " + ratioY2);
//		System.out.println("width " + targetWidth);
//		System.out.println("height " + targetHeight);
//		System.out.println("TYPE " + type);

	}

	/**
	 * 整张图都使用进行融合 image1使用alpha image2使用1-alpha
	 * 
	 * @param image1
	 * @param image2
	 * @param alpha
	 * 
	 * */
	public static BufferedImage scanForNoDir(BufferedImage image1, BufferedImage image2, float alpha)
	{
		BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);

		// float alpha = 0.5f;
		for (int y = 0; y < targetHeight; y++)
		{
			for (int x = 0; x < targetWidth; x++)
			{
				int[] rgb1 = ImageUtil.getSplitRGB(image1.getRGB((int) (x * ratioX1), (int) (y * ratioY1)));
				int[] rgb2 = ImageUtil.getSplitRGB(image2.getRGB((int) (x * ratioX2), (int) (y * ratioY2)));
				outputImage.setRGB(x, y, getMergeRGB(rgb1, rgb2, alpha));
			}
		}

		return outputImage;
	}

	/**
	 * @param image1
	 *            需要融合的图像1
	 * @param image2
	 *            需要融合的图像2
	 * @param width
	 *            输出图像的宽
	 * @param height
	 *            输出图像的长 从上往下扫描
	 * */
	public static BufferedImage scanFromUpToDown(BufferedImage image1, BufferedImage image2)
	{
		BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);

		float alpha = 1;

		for (int y = 0; y < targetHeight; y++)
		{
			alpha = (targetHeight - y) * 1.0f / targetHeight;
			for (int x = 0; x < targetWidth; x++)
			{
				int[] rgb1 = ImageUtil.getSplitRGB(image1.getRGB((int) (x * ratioX1), (int) (y * ratioY1)));
				int[] rgb2 = ImageUtil.getSplitRGB(image2.getRGB((int) (x * ratioX2), (int) (y * ratioY2)));
				outputImage.setRGB(x, y, getMergeRGB(rgb1, rgb2, alpha));
			}
		}

		return outputImage;
	}

	/**
	 * 从下往上扫描
	 * 
	 * @param image1
	 *            需要融合的图像1
	 * @param image2
	 *            需要融合的图像2
	 * @param width
	 *            输出图像的宽
	 * @param height
	 *            输出图像的长
	 * */
	public static BufferedImage scanFromDownToUp(BufferedImage image1, BufferedImage image2)
	{
		BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);

		float alpha = 0;
		for (int y = 0; y < targetHeight; y++)
		{

			alpha = y * 1.0f / targetHeight;
			for (int x = 0; x < targetWidth; x++)
			{
				int[] rgb1 = ImageUtil.getSplitRGB(image1.getRGB((int) (x * ratioX1), (int) (y * ratioY1)));
				int[] rgb2 = ImageUtil.getSplitRGB(image2.getRGB((int) (x * ratioX2), (int) (y * ratioY2)));
				outputImage.setRGB(x, y, getMergeRGB(rgb1, rgb2, alpha));
			}
		}

		return outputImage;
	}

	/**
	 * 从左往右扫描
	 * 
	 * @param image1
	 *            需要融合的图像1
	 * @param image2
	 *            需要融合的图像2
	 * @param width
	 *            输出图像的宽
	 * @param height
	 *            输出图像的长
	 * */
	public static BufferedImage scanFromLeftToRight(BufferedImage image1, BufferedImage image2)
	{
		BufferedImage outputImage = new BufferedImage(targetHeight, targetHeight, BufferedImage.TYPE_INT_RGB);

		float alpha = 1;
		for (int x = 0; x < targetWidth; x++)
		{
			alpha = (targetHeight - x) * 1.0f / targetHeight;
			for (int y = 0; y < targetHeight; y++)
			{
				int[] rgb1 = ImageUtil.getSplitRGB(image1.getRGB((int) (x * ratioX1), (int) (y * ratioY1)));
				int[] rgb2 = ImageUtil.getSplitRGB(image2.getRGB((int) (x * ratioX2), (int) (y * ratioY2)));
				outputImage.setRGB(x, y, getMergeRGB(rgb1, rgb2, alpha));
			}
		}
		return outputImage;
	}

	/**
	 * 从右往左扫描
	 * 
	 * @param image1
	 *            需要融合的图像1
	 * @param image2
	 *            需要融合的图像2
	 * @param width
	 *            输出图像的宽
	 * @param height
	 *            输出图像的长
	 * */
	public static BufferedImage scanFromRightToLeft(BufferedImage image1, BufferedImage image2)
	{
		BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);

		float alpha = 0;
		for (int x = 0; x < targetWidth; x++)
		{
			alpha = x * 1.0f / targetHeight;
			for (int y = 0; y < targetHeight; y++)
			{
				int[] rgb1 = ImageUtil.getSplitRGB(image1.getRGB((int) (x * ratioX1), (int) (y * ratioY1)));
				int[] rgb2 = ImageUtil.getSplitRGB(image2.getRGB((int) (x * ratioX2), (int) (y * ratioY2)));
				outputImage.setRGB(x, y, getMergeRGB(rgb1, rgb2, alpha));
			}
		}

		return outputImage;
	}

	/**
	 * 获取融合的rgb值 rgb1使用alpha rgb2使用1-alpha
	 * 
	 * @param rgb1
	 * @param rgb2
	 * @param alpha
	 * 
	 * */
	public static int getMergeRGB(int[] rgb1, int[] rgb2, float alpha)
	{

		int r = (int) (rgb1[0] * alpha + rgb2[0] * (1 - alpha));
		int g = (int) (rgb1[1] * alpha + rgb2[1] * (1 - alpha));
		int b = (int) (rgb1[2] * alpha + rgb2[2] * (1 - alpha));
		r = ImageUtil.clampIn255(r);
		g = ImageUtil.clampIn255(g);
		b = ImageUtil.clampIn255(b);
		return ImageUtil.getRGB(r, g, b);
	}
}
