package algorithm;

import java.awt.image.*;

import util.ImgUtil;

/**
 * ����
 * */
public class Sculpture
{

	public static BufferedImage getImage(BufferedImage image)
	{
		int width = image.getWidth();
		int height = image.getHeight();

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		int y, x;
		// rgbΪ����ͼ���3��ͨ����output r g bΪ���ͼ���ͨ��
		for (y = 0; y < height; y++)
		{
			for (x = 0; x < width; x++)
			{
				outputImage.setRGB(x, y, ImgUtil.getRGB(128, 128, 128));
			}
		}

		for (y = 1; y < height - 1; y++)
		{
			for (x = 1; x < width - 1; x++)
			{
				int[] rgbColor1 = ImgUtil.getSplitRGB(image.getRGB(x - 1, y - 1));
				int[] rgbColor2 = ImgUtil.getSplitRGB(image.getRGB(x + 1, y + 1));
				int r = rgbColor1[0] - rgbColor2[0] + 128;
				int g = rgbColor1[1] - rgbColor2[1] + 128;
				int b = rgbColor1[2] - rgbColor2[2] + 128;
				r = ImgUtil.clamp(r);
				g = ImgUtil.clamp(g);
				b = ImgUtil.clamp(b);

				outputImage.setRGB(x, y, ImgUtil.getRGB(r, g, b));
			}
		}

		return outputImage;
	}

}
