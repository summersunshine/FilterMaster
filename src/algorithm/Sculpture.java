package algorithm;

import java.awt.Image;
import java.awt.image.*;

import org.w3c.dom.css.RGBColor;

import util.ImgUtil;

public class Sculpture
{

	public static BufferedImage getImage(BufferedImage image)
	{
		int width = image.getWidth();
		int height = image.getHeight();

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		int i, j;
		// rgb为输入图像的3个通道，output r g b为输出图像的通道
		for (i = 0; i < height; i++)
		{
			for (j = 0; j < width; j++)
			{
				outputImage.setRGB(j, i, ImgUtil.getRGB(128, 128, 128));
			}
		}

		for (i = 1; i < height - 1; i++)
		{
			for (j = 1; j < width - 1; j++)
			{
				int[] rgbColor1 = ImgUtil.getSplitRGB(image.getRGB(j - 1, i - 1));
				int[] rgbColor2 = ImgUtil.getSplitRGB(image.getRGB(j + 1, i + 1));
				int r = rgbColor1[0] - rgbColor2[0] + 128;
				int g = rgbColor1[1] - rgbColor2[1] + 128;
				int b = rgbColor1[2] - rgbColor2[2] + 128;
				int rgb = ImgUtil.getRGB(r, g, b);
				outputImage.setRGB(j, i, rgb);
			}
		}

		return outputImage;
	}


}
