package algorithm.blur;

import java.awt.image.BufferedImage;

import util.ImgUtil;
import util.RGB;

/**
 * �ӱ���˹ģ��
 * */
public class DoubleGuassBlur
{

	public static BufferedImage getImage(BufferedImage image, int x, int y, int radius)
	{
		return GuassBlur.getImage(GuassBlur.getImage(image, x, y, radius), x, y, radius);
	}

	/**
	 * ��ȡ��˹ģ��ͼ��
	 * @param image
	 * */
	public static BufferedImage getImage(BufferedImage image)
	{
		return getImage(image,7);
	}
	
	
	/**
	 * ��ȡ��˹ģ��ͼ��
	 * @param image
	 * @param maskSzie ��Ĥ�Ĵ�С��ֻ��Ϊ����
	 * */
	public static BufferedImage getImage(BufferedImage image,int maskSize)
	{
		maskSize = pretreatmentForMaskSize(maskSize);
		
		int halfMaskSize = maskSize/2;
		int width = image.getWidth();
		int height = image.getHeight();
		
		
		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);


		RGB[][] imageMatrix = new RGB[width][height];
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				imageMatrix[x][y]  = new RGB(image.getRGB(x, y));
			}
		}
		
		double sum = maskSize*maskSize;
		
		
		for (int y = halfMaskSize; y < height - halfMaskSize; y++)
		{
			for (int x = halfMaskSize; x < width - halfMaskSize; x++)
			{
				float sumR = 0,sumG = 0,sumB = 0;
				for (int i = -halfMaskSize; i <= halfMaskSize; i++)
				{
					for (int j = -halfMaskSize; j <= halfMaskSize; j++)
					{
						sumR += imageMatrix[x + i][y + j].r;
						sumG += imageMatrix[x + i][y + j].g;
						sumB += imageMatrix[x + i][y + j].b;
					}
				}
				sumR /=sum; 
				sumR = ImgUtil.clamp(sumR);
				sumG /=sum; 
				sumG = ImgUtil.clamp(sumG);
				sumB /=sum; 
				sumB = ImgUtil.clamp(sumB);
				
				outputImage.setRGB(x, y, ImgUtil.getRGB((int)sumR, (int)sumG, (int)sumB));

			}
		}

		return outputImage;

	}

	/**
	 * ��ȡ���ؾ���
	 * @param image
	 * @param width
	 * @param height
	 * @return imageMatrix
	 * */
	public static RGB[][] getImageMatrix(BufferedImage image,int width,int height)
	{
		RGB[][] imageMatrix = new RGB[width][height];
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				imageMatrix[x][y]  = new RGB(image.getRGB(x, y));
			}
		}
		return imageMatrix;
	}
	
	
	/**
	 * ��mask��size��Ԥ����
	 * @param masksize
	 * @return new mask size
	 * */
	public static int pretreatmentForMaskSize(int maskSize)
	{
		return (maskSize/2)*2 +1;
	}
	
	
	

}
