package algorithm;

import java.awt.image.BufferedImage;

import util.RGB;

public class Inverse
{
	public static BufferedImage getImage(BufferedImage image)
	{
		int height = image.getHeight();
		int width  = image.getWidth();
		
		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
	     for(int i=0;i<height;i++)  
	     {
	        for(int j=0;j<width;j++)  
	        {     
	              RGB rgb = new RGB(image.getRGB(j, i));
	              RGB reverseRgb = new RGB(255-rgb.r,255-rgb.g,255-rgb.b);
	              outputImage.setRGB(j, i, reverseRgb.getRGB());
	        }  
	     }
	     return outputImage;
	     
	}
}
