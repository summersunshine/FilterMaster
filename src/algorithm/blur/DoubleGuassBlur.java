package algorithm.blur;

import java.awt.image.BufferedImage;

import util.ImgUtil;
import util.RGB;

/**
 * 加倍高斯模糊
 * */
public class DoubleGuassBlur
{

	 public static BufferedImage getImage(BufferedImage image)
	 {
		 return GuassBlur.getImage(GuassBlur.getImage(image));
	 }
	
	public static RGB[][] imageMatrix;

	public static BufferedImage getImage(BufferedImage image, int x, int y, int radius)
	{
		return GuassBlur.getImage(GuassBlur.getImage(image, x, y, radius), x, y, radius);
	}

//	public static BufferedImage getImage(BufferedImage image)
//	{
//
//		int height = image.getHeight();
//		int width = image.getWidth();
//
//		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//
//		imageMatrix = new RGB[width][height];
//		for (int y = 0; y < height; y++)
//		{
//			for (int x = 0; x < width; x++)
//			{
//				RGB rgb = new RGB(image.getRGB(x, y));
//				imageMatrix[x][y] = rgb;
//			}
//		}
//
//		for (int y = 1; y < height - 1; y++)
//		{
//			for (int x = 1; x < width - 1; x++)
//			{
//				outputImage.setRGB(x, y, getValue(x, y));
//
//			}
//		}
//
//		return outputImage;
//
//	}

	/**
	 * 获取值
	 * 
	 * @param imageMatrxi
	 * @param x
	 * @param y
	 * @param type
	 *            通过类型以及坐标来获取新的值
	 * */
	static int getValue(int x, int y)
	{
		System.out.println("" + x + " " + y);
		float sumR = 0,sumG = 0,sumB = 0;
		for (int i = -1; i <= 1; i++)
		{
			for (int j = -1; j <= 1; j++)
			{
				sumR += imageMatrix[x + i][y + i].r * GuassMask.MASK3[i + 1][j + 1];
				sumG += imageMatrix[x + i][y + i].g * GuassMask.MASK3[i + 1][j + 1];
				sumB += imageMatrix[x + i][y + i].b * GuassMask.MASK3[i + 1][j + 1];
			}
		}
		sumR /=10; sumR = ImgUtil.clamp(sumR);
		sumG /=10; sumG = ImgUtil.clamp(sumG);
		sumB /=10; sumB = ImgUtil.clamp(sumB);
		return ImgUtil.getRGB((int)sumR, (int)sumG, (int)sumB);
		//return (int) sum;
	}
}
