package algorithm.frame;

import java.awt.Image;
import java.awt.image.BufferedImage;

import util.ImgUtil;
import util.RGB;
import algorithm.fun.AlphaMerge;

/**
 * 相册
 * */
public class Frame
{
	
	//加相框的时候
	//源图像是否伸缩
	public static boolean isScale = false;
	
	
	/**
	 * 获取带相册的新图片
	 * 
	 * @param image
	 * @param index
	 * */
	public static BufferedImage getImage(BufferedImage image,int index)
	{
		String fileName = "res/frame" + index + ".png";
		BufferedImage frameImage = ImgUtil.getImg(fileName);
		return getImage(image, frameImage);
	}
	
	
	/**
	 * 将源图像和相框叠加起来
	 * 
	 * @param image
	 * @param frameImage
	 * */
	public static BufferedImage  getImage(BufferedImage image,BufferedImage frameImage)
	{
		int width = image.getWidth();
		int height = image.getHeight();

		float ratioX = frameImage.getWidth()*1f/width;
		float ratioY = frameImage.getHeight()*1f/height;
		float frameX,frameY;
		int frameRgb;
		
		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				frameX = x*ratioX;
				frameY = y*ratioY;
				
				frameRgb = frameImage.getRGB((int)frameX, (int)frameY);
				RGB value = new RGB(frameRgb);
				
				if (value.isPureWhite())
				{
					outputImage.setRGB(x, y, image.getRGB(x, y));
				}
				else
				{
					outputImage.setRGB(x, y, frameRgb);
				}
			}
		}

		return outputImage;
		
	}
}
