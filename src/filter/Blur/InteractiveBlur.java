package filter.Blur;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class InteractiveBlur
{

	// 掩码最小值
	public static final int MIN_MASK_SIZE = 3;

	// 掩码最大值
	public static final int MAX_MASK_SIZE = 15;
	
	//掩码最大值的一半
	public static final int HALF_MAX_MASK_SIZE = 7;

	// 最小值与最大值的差
	public static final int DIFF_MASK_SIZE = MAX_MASK_SIZE - MIN_MASK_SIZE;

	// 点在模糊区域中
	public static final int AREA_BLUR = 1;

	// 点在清晰区域中
	public static final int AREA_CLEAR = 2;

	// 点在过渡区域中
	public static final int AREA_TRAN = 3;

	// 圆形的清晰区域
	public static final int TYPE_CIRCLE = 1;

	// 垂直的清晰区域
	public static final int TYPE_VERTCIAL = 2;

	// 水平的清晰区域
	public static final int TYPE_HORIZONTAL = 3;

	//外部区域以外的都是模糊的
	private static int outSize;
	
	//内部区域以内的都是清晰的
	private static int innerSize;

	//区域
	private static int area;

	
	private static Color[][] colorMatrix;


	/**
	 * 获取图像
	 * 
	 * @param image
	 *            源图像
	 * @param x
	 *            x坐标
	 * @param y
	 *            y坐标
	 * @param size
	 *            作用范围
	 * @param type
	 *            类型
	 * */
	public static BufferedImage getImage(BufferedImage image,int type)
	{
		int x = image.getWidth()/2;
		int y = image.getHeight()/2;
		int size = (int) (Math.sqrt(x*x+y*y)/6);
		
		InteractiveBlur.innerSize = size;
		InteractiveBlur.outSize = (int) (size * 1.5);
		// 获取rgb矩阵
		colorMatrix = getColorMatrix(image);
		


		switch (type)
		{
		case TYPE_VERTCIAL:
			return getVecticalImage(image, x, size);
		case TYPE_HORIZONTAL:
			return getHozizontalImage(image, y, size);
		default:
			return getCircleImage(image, x, y, size);
		}
	}
	


	/**
	 * 获取图像
	 * 
	 * @param image
	 *            源图像
	 * @param x
	 *            x坐标
	 * @param y
	 *            y坐标
	 * @param size
	 *            作用范围
	 * @param type
	 *            类型
	 * */
	public static BufferedImage getImage(BufferedImage image, int x, int y, int size, int type)
	{
		InteractiveBlur.innerSize = size;
		InteractiveBlur.outSize = (int) (size * 1.5);
		// 获取rgb矩阵
		colorMatrix = getColorMatrix(image);

		switch (type)
		{
		case TYPE_VERTCIAL:
			return getVecticalImage(image, x, size);
		case TYPE_HORIZONTAL:
			return getHozizontalImage(image, y, size);
		default:
			return getCircleImage(image, x, y, size);
		}
	}

	/**
	 * 获取圆形的清晰区域
	 * 
	 * @param image
	 *            源图像
	 * @param x
	 *            x坐标
	 * @param y
	 *            y坐标
	 * @param size
	 *            作用范围
	 * */
	private static BufferedImage getCircleImage(BufferedImage image, int centerX, int centerY, int size)
	{
		int width = image.getWidth();
		int height = image.getHeight();

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int y = HALF_MAX_MASK_SIZE; y < height - HALF_MAX_MASK_SIZE; y++)
		{
			for (int x = HALF_MAX_MASK_SIZE; x < width - HALF_MAX_MASK_SIZE; x++)
			{
				int distance = getDistance(x, y, centerX, centerY);
				area = getArea(distance);
				outputImage.setRGB(x, y, getRGBValue(image, x, y,distance));
			}
		}
		return outputImage;
	}

	/**
	 * 获取纵向的背景虚化图像
	 * 
	 * @param image
	 *            源图像
	 * @param x
	 *            x坐标
	 * @param y
	 *            y坐标
	 * @param size
	 *            作用范围
	 * */
	public static BufferedImage getVecticalImage(BufferedImage image, int centerX, int size)
	{
		int width = image.getWidth();
		int height = image.getHeight();

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int x = HALF_MAX_MASK_SIZE; x < width - HALF_MAX_MASK_SIZE; x++)
		{
			int distance  = Math.abs(x - centerX);
			area = getArea(Math.abs(x - centerX));

			for (int y = HALF_MAX_MASK_SIZE; y < height - HALF_MAX_MASK_SIZE; y++)
			{
				outputImage.setRGB(x, y, getRGBValue(image, x, y,distance));

			}
		}
		return outputImage;
	}

	/**
	 * 获取水平的背景虚化图像
	 * 
	 * @param image
	 *            源图像
	 * @param x
	 *            x坐标
	 * @param y
	 *            y坐标
	 * @param size
	 *            作用范围
	 * */
	public static BufferedImage getHozizontalImage(BufferedImage image, int centerY, int size)
	{
		int width = image.getWidth();
		int height = image.getHeight();
		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int y = HALF_MAX_MASK_SIZE; y < height - HALF_MAX_MASK_SIZE; y++)
		{
			int distance = Math.abs(y - centerY);
			area = getArea(distance);
			
			for (int x = HALF_MAX_MASK_SIZE; x < width - HALF_MAX_MASK_SIZE; x++)
			{
				outputImage.setRGB(x, y, getRGBValue(image, x, y,distance));

			}
		}
		return outputImage;
	}

	
	private static int getRGBValue(BufferedImage image, int x, int y,int distance)
	{
		if (area == AREA_BLUR)
		{
			return getBlurRGBValue(x, y, MAX_MASK_SIZE);
		}
		else if (area == AREA_TRAN)
		{
			// 过渡区间
			int maskSize = MIN_MASK_SIZE + DIFF_MASK_SIZE * (distance - innerSize) / (outSize - innerSize);
			// 将masksize变为奇数
			maskSize = (maskSize / 2) * 2 + 1;

			return getBlurRGBValue(x, y, maskSize);
		}
		else
		{
			return image.getRGB(x, y);
		}
	}

	/**
	 * 获取模糊后的图像的rgb值
	 * 
	 * @param colorMatrix
	 * @param x
	 * @param y
	 * @param maskSize
	 * */
	private static int getBlurRGBValue(int x, int y, int maskSize)
	{
		int sum = maskSize * maskSize;
		int halfMaskSize = maskSize / 2;

		int sumR = 0, sumG = 0, sumB = 0;
		for (int i = -halfMaskSize; i <= halfMaskSize; i++)
		{
			for (int j = -halfMaskSize; j <= halfMaskSize; j++)
			{
				sumR += colorMatrix[x + i][y + j].getRed();
				sumG += colorMatrix[x + i][y + j].getGreen();
				sumB += colorMatrix[x + i][y + j].getBlue();
			}
		}
		sumR /= sum;
		sumG /= sum;
		sumB /= sum;

		sumR = sumR << 16;
		sumG = sumG << 8;

		return sumR|sumG|sumB;
	}

	// 判断点在那个区域
	private static int getArea(int distance)
	{
		int area;
		if (distance > outSize)
		{
			area = AREA_BLUR;
		}
		else if (distance < innerSize)
		{
			area = AREA_CLEAR;
		}
		else
		{
			area = AREA_TRAN;
		}
		return area;
	}

	/**
	 * 获取两点之间的距离
	 * 
	 * @param x1
	 *            第一个点的X坐标
	 * @param y1
	 *            第一个点的y坐标
	 * @param x2
	 *            第二个点的X坐标
	 * @param y2
	 *            第二个点的y坐标
	 * */
	private static int getDistance(int x1, int y1, int x2, int y2)
	{
		int x = x1 - x2;
		int y = y1 - y2;
		return (int) Math.sqrt(x * x + y * y);
	}
	
	
	/**
	 * 获取图像的color矩阵
	 * 
	 * @param image
	 * */
	private static Color[][] getColorMatrix(BufferedImage image)
	{
		int width = image.getWidth();
		int height = image.getHeight();
		Color[][] matrix = new Color[width][height];
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				matrix[x][y]  = new Color(image.getRGB(x, y));
			}
		}
		return matrix;
	}
}
