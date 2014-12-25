package util.image;

import java.awt.image.BufferedImage;

/**
 * Alpha�ں�
 * */
public class AlphaMerge
{

	// �޷���
	public static final int DIR_NO = 0;

	// ������
	public static final int DIR_LEFT_2_RIGHT = 1;

	// ���ҵ���
	public static final int DIR_RIGHT_2_LEFT = 2;

	// ���ϵ���
	public static final int DIR_UP_2_DOWN = 3;

	// ���µ���
	public static final int DIR_DOWN_2_UP = 4;

	// ����С�ĳ�������ں�
	public static int MERGE_TYPE_MIN = 1;

	// ����С�ĳ�������ںϲ�����
	public static int MERGE_TYPE_MIN_SCALE = 2;

	// �����ĳ�������ں�
	public static int MERGE_TYPE_MAX = 3;

	// �����ĳ�������ںϲ�����
	public static int MERGE_TYPE_MAX_SCALE = 4;

	// �Ե�һ��ͼƬ�ĳ�������ں�
	public static int MERGE_TYPE_IMAGE_1 = 5;

	// �Եڶ���ͼƬ�ĳ�������ں�
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
	 *            ��Ҫ�ںϵ�ͼ��1
	 * @param image2
	 *            ��Ҫ�ںϵ�ͼ��2
	 * @param alpha
	 *            ɨ��ķ���
	 * @param type
	 *            ƴ�ϵķ�ʽ
	 * */
	public static BufferedImage getImage(BufferedImage image1, BufferedImage image2, float alpha)
	{
		setSizeAndRatio(image1, image2, MERGE_TYPE_MIN_SCALE);
		return scanForNoDir(image1, image2, alpha);
	}

	/**
	 * @param image1
	 *            ��Ҫ�ںϵ�ͼ��1
	 * @param image2
	 *            ��Ҫ�ںϵ�ͼ��2
	 * @param dir
	 *            ɨ��ķ���
	 * @param type
	 *            ƴ�ϵķ�ʽ
	 * */
	public static BufferedImage getImage(BufferedImage image1, BufferedImage image2, int type)
	{
		setSizeAndRatio(image1, image2, type);
		return scanForNoDir(image1, image2, 0.5f);
	}

	/**
	 * @param image1
	 *            ��Ҫ�ںϵ�ͼ��1
	 * @param image2
	 *            ��Ҫ�ںϵ�ͼ��2
	 * @param dir
	 *            ɨ��ķ���
	 * @param type
	 *            ƴ�ϵķ�ʽ
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
	 * ����type������ͼ��Ĵ�С�Լ�Դͼ������ű���
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
	 * ѡȡ����ͼ����С�ĳ�����ΪĿ��ͼ��ĳ���
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
	 * ѡȡ����ͼ�����ĳ�����ΪĿ��ͼ��ĳ���
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
	 * ��û�����ŵ�ʱ�����ű�����Ϊ1
	 * */
	public static void setRatioForNoScale()
	{
		ratioX1 = ratioX2 = ratioY1 = ratioY2 = 1;
	}

	/**
	 * �����ŵ�ʱ��������ű���
	 * 
	 * @param image1
	 * @param image2
	 * */
	public static void setRatioForScale(BufferedImage image1, BufferedImage image2)
	{
		// ������ȡ��image1
		if (targetWidth == image1.getWidth())
		{
			ratioX1 = 1;
			ratioX2 = image2.getWidth() * 1.0f / targetWidth;
		}
		// ������ȡ��image2
		else
		{
			ratioX1 = image1.getWidth() * 1.0f / targetWidth;
			ratioX2 = 1;
		}

		// ����߶�ȡ��image1
		if (targetHeight == image1.getHeight())
		{
			ratioY1 = 1;
			ratioY2 = image2.getHeight() * 1.0f / targetHeight;
		}
		// ����߶�ȡ��image2
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
	 * ����ͼ��ʹ�ý����ں� image1ʹ��alpha image2ʹ��1-alpha
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
	 *            ��Ҫ�ںϵ�ͼ��1
	 * @param image2
	 *            ��Ҫ�ںϵ�ͼ��2
	 * @param width
	 *            ���ͼ��Ŀ�
	 * @param height
	 *            ���ͼ��ĳ� ��������ɨ��
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
	 * ��������ɨ��
	 * 
	 * @param image1
	 *            ��Ҫ�ںϵ�ͼ��1
	 * @param image2
	 *            ��Ҫ�ںϵ�ͼ��2
	 * @param width
	 *            ���ͼ��Ŀ�
	 * @param height
	 *            ���ͼ��ĳ�
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
	 * ��������ɨ��
	 * 
	 * @param image1
	 *            ��Ҫ�ںϵ�ͼ��1
	 * @param image2
	 *            ��Ҫ�ںϵ�ͼ��2
	 * @param width
	 *            ���ͼ��Ŀ�
	 * @param height
	 *            ���ͼ��ĳ�
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
	 * ��������ɨ��
	 * 
	 * @param image1
	 *            ��Ҫ�ںϵ�ͼ��1
	 * @param image2
	 *            ��Ҫ�ںϵ�ͼ��2
	 * @param width
	 *            ���ͼ��Ŀ�
	 * @param height
	 *            ���ͼ��ĳ�
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
	 * ��ȡ�ںϵ�rgbֵ rgb1ʹ��alpha rgb2ʹ��1-alpha
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
