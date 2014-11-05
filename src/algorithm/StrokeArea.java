package algorithm;

import java.awt.image.BufferedImage;

import util.ImgUtil;

public class StrokeArea
{
	public static BufferedImage getImage(BufferedImage image, int size)
	{
		int width = image.getWidth();
		int height = image.getHeight();

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		int[] inPixels = new int[width * height];
		int[] outPixels = new int[width * height];
		ImgUtil.getRGB(image, inPixels, 0, 0, width, height);
		int index = 0, index2 = 0;
		int semiRow = (int) (size / 2);
		int semiCol = (int) (size / 2);
		int newX, newY;

		// initialize the color RGB array with zero...
		int[] rgb = new int[3];
		int[] rgb2 = new int[3];
		for (int i = 0; i < rgb.length; i++)
		{
			rgb[i] = rgb2[i] = 0;
		}

		// start the algorithm process here!!
		for (int row = 0; row < height; row++)
		{
			int ta = 0;
			for (int col = 0; col < width; col++)
			{
				index = row * width + col;
				ta = (inPixels[index] >> 24) & 0xff;
				rgb[0] = (inPixels[index] >> 16) & 0xff;
				rgb[1] = (inPixels[index] >> 8) & 0xff;
				rgb[2] = inPixels[index] & 0xff;

				/* adjust region to fit in source image */
				// color difference and moment Image
				double moment = 0.0d;
				for (int subRow = -semiRow; subRow <= semiRow; subRow++)
				{
					for (int subCol = -semiCol; subCol <= semiCol; subCol++)
					{
						newY = row + subRow;
						newX = col + subCol;
						if (newY < 0)
						{
							newY = 0;
						}
						if (newX < 0)
						{
							newX = 0;
						}
						if (newY >= height)
						{
							newY = height - 1;
						}
						if (newX >= width)
						{
							newX = width - 1;
						}
						index2 = newY * width + newX;
						rgb2[0] = (inPixels[index2] >> 16) & 0xff; // red
						rgb2[1] = (inPixels[index2] >> 8) & 0xff; // green
						rgb2[2] = inPixels[index2] & 0xff; // blue
						moment += ImgUtil.getColorDiff(rgb, rgb2);
					}
				}
				// calculate the output pixel value.
				int outPixelValue = ImgUtil.clamp((int) (255.0d * moment / (size * size)));
				outPixels[index] = (ta << 24) | (outPixelValue << 16) | (outPixelValue << 8) | outPixelValue;
			}
		}

		ImgUtil.setRGB(outputImage, outPixels);
		return outputImage;
	}
}
