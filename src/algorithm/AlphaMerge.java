package algorithm;

import java.awt.image.BufferedImage;

import util.ImgUtil;

/**
 * Alpha�ں�
 * */
public class AlphaMerge
{

	public static int TYPE_LEFT_2_RIGHT = 1;
	public static int TYPE_RIGHT_2_LEFT = 2;
	public static int TYPE_UP_2_DOWN = 3;
	public static int TYPE_DOWN_2_UP = 4;

	public static BufferedImage getImage(BufferedImage image1, BufferedImage image2)
	{
		return getImage(image1, image2, 0.5f);
	}

	/**
	 * @param image1
	 *            ��Ҫ�ںϵ�ͼ��1
	 * @param image2
	 *            ��Ҫ�ںϵ�ͼ��2
	 * @param type
	 *            ɨ�������
	 * */
	public static BufferedImage getImage(BufferedImage image1, BufferedImage image2, int type)
	{
		int width = image1.getWidth() < image2.getWidth() ? image1.getWidth() : image2.getWidth();
		int height = image1.getHeight() < image2.getHeight() ? image1.getHeight() : image2.getHeight();

		if (type == TYPE_LEFT_2_RIGHT)
		{
			return scanFromLeftToRight(image1, image2, width, height);
		} else if (type == TYPE_RIGHT_2_LEFT)
		{
			return scanFromRightToLeft(image1, image2, width, height);
		} else if (type == TYPE_UP_2_DOWN)
		{
			return scanFromUpToDown(image1, image2, width, height);
		} else
		{
			return scanFromDownToUp(image1, image2, width, height);
		}
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
	public static BufferedImage scanFromUpToDown(BufferedImage image1, BufferedImage image2, int width, int height)
	{
		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		float alpha = 1;
		for (int y = 0; y < height; y++)
		{

			alpha = (height - y) * 1.0f / height;
			for (int x = 0; x < width; x++)
			{
				int[] rgb1 = ImgUtil.getSplitRGB(image1.getRGB(x, y));
				int[] rgb2 = ImgUtil.getSplitRGB(image2.getRGB(x, y));
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
	public static BufferedImage scanFromDownToUp(BufferedImage image1, BufferedImage image2, int width, int height)
	{
		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		float alpha = 0;
		for (int y = 0; y < height; y++)
		{

			alpha = y * 1.0f / height;
			for (int x = 0; x < width; x++)
			{
				int[] rgb1 = ImgUtil.getSplitRGB(image1.getRGB(x, y));
				int[] rgb2 = ImgUtil.getSplitRGB(image2.getRGB(x, y));
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
	public static BufferedImage scanFromLeftToRight(BufferedImage image1, BufferedImage image2, int width, int height)
	{
		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		float alpha = 1;
		for (int x = 0; x < width; x++)
		{
			alpha = (height - x) * 1.0f / height;
			for (int y = 0; y < height; y++)
			{
				int[] rgb1 = ImgUtil.getSplitRGB(image1.getRGB(x, y));
				int[] rgb2 = ImgUtil.getSplitRGB(image2.getRGB(x, y));
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
	public static BufferedImage scanFromRightToLeft(BufferedImage image1, BufferedImage image2, int width, int height)
	{
		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		float alpha = 0;
		for (int x = 0; x < width; x++)
		{
			alpha = x * 1.0f / height;
			for (int y = 0; y < height; y++)
			{
				int[] rgb1 = ImgUtil.getSplitRGB(image1.getRGB(x, y));
				int[] rgb2 = ImgUtil.getSplitRGB(image2.getRGB(x, y));
				outputImage.setRGB(x, y, getMergeRGB(rgb1, rgb2, alpha));
			}
		}
		return outputImage;
	}

	/**
	 * @param image1
	 * @param image2
	 * @param alpha
	 *            ����ͼ��ʹ�ý����ں� image1ʹ��alpha image2ʹ��1-alpha
	 * */
	public static BufferedImage getImage(BufferedImage image1, BufferedImage image2, float alpha)
	{
		int width = image1.getWidth() < image2.getWidth() ? image1.getWidth() : image2.getWidth();
		int height = image1.getHeight() < image2.getHeight() ? image1.getHeight() : image2.getHeight();

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				int[] rgb1 = ImgUtil.getSplitRGB(image1.getRGB(x, y));
				int[] rgb2 = ImgUtil.getSplitRGB(image2.getRGB(x, y));
				outputImage.setRGB(x, y, getMergeRGB(rgb1, rgb2, alpha));
			}
		}

		return outputImage;
	}

	/**
	 * ��ȡ�ںϵ�rgbֵ
	 * 
	 * @param rgb1
	 * @param rgb2
	 * @param alpha
	 *            rgb1ʹ��alpha rgb2ʹ��1-alpha
	 * */
	public static int getMergeRGB(int[] rgb1, int[] rgb2, float alpha)
	{

		int r = (int) (rgb1[0] * alpha + rgb2[0] * (1 - alpha));
		int g = (int) (rgb1[1] * alpha + rgb2[1] * (1 - alpha));
		int b = (int) (rgb1[2] * alpha + rgb2[2] * (1 - alpha));
		r = ImgUtil.clamp(r);
		g = ImgUtil.clamp(g);
		b = ImgUtil.clamp(b);
		return ImgUtil.getRGB(r, g, b);
	}
}
