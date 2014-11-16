package algorithm.basic;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import util.Geometry;

/**
 * ����Ч��
 * */
public class Erase
{

	/**
	 * ����Ӧ����ԴͼƬ�ϵ�Ч����Բ������
	 * 
	 * @param currImage
	 *            ��ǰͼƬ
	 * @param sourceImage
	 *            ԭͼƬ
	 * @param centerX
	 *            ���������ĵ�X����
	 * @param centerY
	 *            ���������ĵ�Y����
	 * @param radius
	 *            �����İ뾶
	 * */
	public static BufferedImage getImage(BufferedImage currImage, BufferedImage sourceImage, int centerX, int centerY, int radius)
	{
		int startX = centerX - radius;
		int startY = centerY - radius;
		int endX = centerX + radius;
		int endY = centerY + radius;

		startX = startX < 0 ? 0 : startX;
		startY = startY < 0 ? 0 : startY;
		endX = endX > currImage.getWidth() ? currImage.getWidth() : endX;
		endY = endY > currImage.getHeight() ? currImage.getHeight() : endY;

		for (int y = startY; y < endY; y++)
		{
			for (int x = startX; x < endX; x++)
			{
				if (Geometry.getDistance(x, y, centerX, centerY) < radius)
				{
					currImage.setRGB(x, y, sourceImage.getRGB(x, y));
				}
			}
		}
		return currImage;

	}
	
	
	/**
	 * ����Ӧ����ԴͼƬ�ϵ�Ч��������ԭͼƬ������£���������ΪԲ������
	 * 
	 * @param sourceImage
	 *            ԭͼƬ
	 * @param centerX
	 *            ���������ĵ�X����
	 * @param centerY
	 *            ���������ĵ�Y����
	 * @param radius
	 *            �����İ뾶
	 * */
	public static BufferedImage getImage(BufferedImage sourceImage, int centerX, int centerY, int radius)
	{
		int startX = centerX - radius;
		int startY = centerY - radius;
		int endX = centerX + radius;
		int endY = centerY + radius;

		startX = startX < 0 ? 0 : startX;
		startY = startY < 0 ? 0 : startY;
		endX = endX > sourceImage.getWidth() ? sourceImage.getWidth() : endX;
		endY = endY > sourceImage.getHeight() ? sourceImage.getHeight() : endY;

		for (int y = startY; y < endY; y++)
		{
			for (int x = startX; x < endX; x++)
			{
				if (Geometry.getDistance(x, y, centerX, centerY) < radius)
				{
					sourceImage.setRGB(x, y, 0x00ffffff);
				}
			}
		}
		return sourceImage;

	}
	

	/**
	 * ����Ӧ����ԴͼƬ�ϵ�Ч������������
	 * 
	 * @param currImage
	 *            ��ǰͼƬ
	 * @param sourceImage
	 *            ԭͼƬ
	 * @param startX
	 *            �����������ʼX����
	 * @param startY
	 *            �����������ʼY����
	 * @param width
	 *            ��������Ŀ��
	 * @param height
	 *            ��������ĸ߶�
	 * */
	public static BufferedImage getImage(BufferedImage currImage, BufferedImage sourceImage, int startX, int startY, int width, int height)
	{
		int endX = startX + width;
		int endY = startY + height;

		startX = startX < 0 ? 0 : startX;
		startY = startY < 0 ? 0 : startY;
		endX = endX > currImage.getWidth() ? currImage.getWidth() : endX;
		endY = endY > currImage.getHeight() ? currImage.getHeight() : endY;

		for (int y = startY; y < endY; y++)
		{
			for (int x = startX; x < endX; x++)
			{
				currImage.setRGB(x, y, sourceImage.getRGB(x, y));
			}
		}
		return currImage;

	}

	/**
	 * ����Ӧ����ԴͼƬ�ϵ�Ч������������
	 * 
	 * @param currImage
	 *            ��ǰͼƬ
	 * @param sourceImage
	 *            ԭͼƬ
	 * @param rectangle
	 *            �����������
	 * */
	public static BufferedImage getImage(BufferedImage currImage, BufferedImage sourceImage, Rectangle rectangle)
	{
		return getImage(currImage, sourceImage, rectangle.x, rectangle.y, rectangle.width, rectangle.height);

	}

}
