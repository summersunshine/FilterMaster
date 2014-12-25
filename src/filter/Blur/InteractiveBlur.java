package filter.Blur;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class InteractiveBlur
{

	// ������Сֵ
	public static final int MIN_MASK_SIZE = 3;

	// �������ֵ
	public static final int MAX_MASK_SIZE = 15;
	
	//�������ֵ��һ��
	public static final int HALF_MAX_MASK_SIZE = 7;

	// ��Сֵ�����ֵ�Ĳ�
	public static final int DIFF_MASK_SIZE = MAX_MASK_SIZE - MIN_MASK_SIZE;

	// ����ģ��������
	public static final int AREA_BLUR = 1;

	// ��������������
	public static final int AREA_CLEAR = 2;

	// ���ڹ���������
	public static final int AREA_TRAN = 3;

	// Բ�ε���������
	public static final int TYPE_CIRCLE = 1;

	// ��ֱ����������
	public static final int TYPE_VERTCIAL = 2;

	// ˮƽ����������
	public static final int TYPE_HORIZONTAL = 3;

	//�ⲿ��������Ķ���ģ����
	private static int outSize;
	
	//�ڲ��������ڵĶ���������
	private static int innerSize;

	//����
	private static int area;

	
	private static Color[][] colorMatrix;


	/**
	 * ��ȡͼ��
	 * 
	 * @param image
	 *            Դͼ��
	 * @param x
	 *            x����
	 * @param y
	 *            y����
	 * @param size
	 *            ���÷�Χ
	 * @param type
	 *            ����
	 * */
	public static BufferedImage getImage(BufferedImage image,int type)
	{
		int x = image.getWidth()/2;
		int y = image.getHeight()/2;
		int size = (int) (Math.sqrt(x*x+y*y)/6);
		
		InteractiveBlur.innerSize = size;
		InteractiveBlur.outSize = (int) (size * 1.5);
		// ��ȡrgb����
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
	 * ��ȡͼ��
	 * 
	 * @param image
	 *            Դͼ��
	 * @param x
	 *            x����
	 * @param y
	 *            y����
	 * @param size
	 *            ���÷�Χ
	 * @param type
	 *            ����
	 * */
	public static BufferedImage getImage(BufferedImage image, int x, int y, int size, int type)
	{
		InteractiveBlur.innerSize = size;
		InteractiveBlur.outSize = (int) (size * 1.5);
		// ��ȡrgb����
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
	 * ��ȡԲ�ε���������
	 * 
	 * @param image
	 *            Դͼ��
	 * @param x
	 *            x����
	 * @param y
	 *            y����
	 * @param size
	 *            ���÷�Χ
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
	 * ��ȡ����ı����黯ͼ��
	 * 
	 * @param image
	 *            Դͼ��
	 * @param x
	 *            x����
	 * @param y
	 *            y����
	 * @param size
	 *            ���÷�Χ
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
	 * ��ȡˮƽ�ı����黯ͼ��
	 * 
	 * @param image
	 *            Դͼ��
	 * @param x
	 *            x����
	 * @param y
	 *            y����
	 * @param size
	 *            ���÷�Χ
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
			// ��������
			int maskSize = MIN_MASK_SIZE + DIFF_MASK_SIZE * (distance - innerSize) / (outSize - innerSize);
			// ��masksize��Ϊ����
			maskSize = (maskSize / 2) * 2 + 1;

			return getBlurRGBValue(x, y, maskSize);
		}
		else
		{
			return image.getRGB(x, y);
		}
	}

	/**
	 * ��ȡģ�����ͼ���rgbֵ
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

	// �жϵ����Ǹ�����
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
	 * ��ȡ����֮��ľ���
	 * 
	 * @param x1
	 *            ��һ�����X����
	 * @param y1
	 *            ��һ�����y����
	 * @param x2
	 *            �ڶ������X����
	 * @param y2
	 *            �ڶ������y����
	 * */
	private static int getDistance(int x1, int y1, int x2, int y2)
	{
		int x = x1 - x2;
		int y = y1 - y2;
		return (int) Math.sqrt(x * x + y * y);
	}
	
	
	/**
	 * ��ȡͼ���color����
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
