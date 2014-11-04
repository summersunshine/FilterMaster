package algorithm;

import java.awt.Image;
import java.awt.image.*;

import org.w3c.dom.css.RGBColor;

public class Sculpture {

	public static BufferedImage emboss(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();

		BufferedImage outputImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		int i, j;
		// rgb为输入图像的3个通道，output r g b为输出图像的通道
		for (i = 0; i < height; i++) {
			for (j = 0; j < width; j++) {
				outputImage.setRGB(j, i, getRGB(128, 128, 128));
			}
		}

		for (i = 1; i < height - 1; i++) {
			for (j = 1; j < width - 1; j++) {
				int[] rgbColor1 = getSplitRGB(image.getRGB(j - 1, i - 1));
				int[] rgbColor2 = getSplitRGB(image.getRGB(j + 1, i + 1));
				int r = rgbColor1[0] - rgbColor2[0] + 128;
				int g = rgbColor1[1] - rgbColor2[1] + 128;
				int b = rgbColor1[2] - rgbColor2[2] + 128;
				int rgb = getRGB(r, g, b);
				outputImage.setRGB(j, i, rgb);
			}
		}

		return outputImage;
	}

	public static int[] getSplitRGB(int pixel) {
		int[] rgbs = new int[3];
		rgbs[0] = (pixel & 0xff0000) >> 16;
		rgbs[1] = (pixel & 0xff00) >> 8;
		rgbs[2] = (pixel & 0xff);
		return rgbs;
	}

	public static int getRGB(int r, int g, int b) {
		r = r << 16;
		g = g << 8;

		return (r | g | b);
	}
}
