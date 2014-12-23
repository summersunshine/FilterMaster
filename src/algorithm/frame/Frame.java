package algorithm.frame;

import java.awt.Color;
import java.awt.image.BufferedImage;

import util.ImgUtil;

/**
 * ���
 * */
public class Frame
{

	// ������ʱ��
	// Դͼ���Ƿ�����
	public static boolean	isScale	= false;

	/**
	 * ��ȡ��������ͼƬ
	 * 
	 * @param image
	 * @param index
	 * */
	public static BufferedImage getImage(BufferedImage image, int index)
	{
		String fileName = "res/frame" + index + ".png";
		BufferedImage frameImage = ImgUtil.getImg(fileName);
		return getImage(image, frameImage);
	}

	/**
	 * ��Դͼ�������������
	 * 
	 * @param image
	 * @param frameImage
	 * */
	public static BufferedImage getImage(BufferedImage image, BufferedImage frameImage)
	{
		int width = image.getWidth();
		int height = image.getHeight();

		float ratioX = frameImage.getWidth() * 1f / width;
		float ratioY = frameImage.getHeight() * 1f / height;
		float frameX, frameY;
		int frameRgb, sourceRgb;
		Color frameColor, sourceColor;

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				frameX = x * ratioX;
				frameY = y * ratioY;

				frameRgb = frameImage.getRGB((int) frameX, (int) frameY);
				frameColor = new Color(frameRgb, true);

				sourceRgb = image.getRGB(x, y);
				sourceColor = new Color(sourceRgb, true);

				float alpha = frameColor.getAlpha() / 255f;

				int r = (int) (frameColor.getRed() * alpha + sourceColor.getRed() * (1 - alpha));
				int g = (int) (frameColor.getGreen() * alpha + sourceColor.getGreen() * (1 - alpha));
				int b = (int) (frameColor.getBlue() * alpha + sourceColor.getBlue() * (1 - alpha));

				outputImage.setRGB(x, y, ImgUtil.getRGB(r, g, b));

			}
		}

		return outputImage;

	}
}
