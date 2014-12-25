package algorithm.art;

import java.awt.image.BufferedImage;

import algorithm.basic.Gray;
import algorithm.basic.Inverse;
import algorithm.blur.GuassBlur;
import util.ImageUtil;

/**
 * ����
 * */
public class Sketch
{

	/**
	 * �����˾�
	 * 
	 * @param image
	 * */
	public static BufferedImage getImage(BufferedImage image)
	{
		int height = image.getHeight();
		int width = image.getWidth();

		// ת���ɻҶ�ͼ
		BufferedImage grayImage = Gray.getImage(image);

		// ����
		BufferedImage reverseImage = Inverse.getImage(grayImage);

		// ��˹ģ��
		BufferedImage guassBlurImage = GuassBlur.getImage(reverseImage);

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				int b = ImageUtil.getSplitRGB(guassBlurImage.getRGB(x, y))[0];
				int a = ImageUtil.getSplitRGB(grayImage.getRGB(x, y))[0];

				int temp = (int) (a + a * b / (256 - b) / 1.5);
				a = Math.min(temp, 255);

				reverseImage.setRGB(x, y, ImageUtil.getRGB(a, a, a));

			}
		}
		return reverseImage;
	}
}
