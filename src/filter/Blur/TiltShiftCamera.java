package filter.Blur;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * �������
 * 
 * ����������Խ��㷨�ֽ�Ϊ�������� 1.����ͼ��ı��Ͷ� 2.��ͼ����ȡһ�κ��������ģ��������������Ĳ���
 * */
public class TiltShiftCamera
{
	public static BufferedImage getImage(BufferedImage image, float saturability)
	{
		BufferedImage outputImage = updateImageSaturability(image, saturability);
		return InteractiveBlur.getImage(outputImage, InteractiveBlur.TYPE_HORIZONTAL);

	}

	public static BufferedImage getImage(BufferedImage image, int y, int size, float saturability)
	{
		BufferedImage outputImage = updateImageSaturability(image, saturability);

		InteractiveBlur.centerY = y;
		return InteractiveBlur.getImage(outputImage, size, InteractiveBlur.TYPE_HORIZONTAL);

	}

	/**
	 * ����ͼ���ɫ��ͱ��Ͷ�
	 * 
	 * @param image
	 * @param saturability
	 * */
	public static BufferedImage updateImageSaturability(BufferedImage image, float saturability)
	{

		int width = image.getWidth();
		int height = image.getHeight();

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				Color color = new Color(image.getRGB(x, y));
				float[] hsbValue = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
				hsbValue[1] = hsbValue[1] + saturability > 1f ? 1f : hsbValue[1] + saturability;
				outputImage.setRGB(x, y, Color.HSBtoRGB(hsbValue[0], hsbValue[1], hsbValue[2]));

			}
		}

		return outputImage;
	}
}
