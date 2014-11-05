package algorithm;

import java.awt.image.BufferedImage;

import util.ImgUtil;

public class RetroStyle
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
	              int []rgb = ImgUtil.getSplitRGB(image.getRGB(j, i));
	              int r= (int) Math.max(0, Math.min(255, 0.393*rgb[0] + 0.769*rgb[1] + 0.189*rgb[2]));
	              int g= (int) Math.max(0, Math.min(255, 0.349*rgb[0] + 0.686*rgb[1] + 0.168*rgb[2]));
	              int b= (int) Math.max(0, Math.min(255, 0.272*rgb[0] + 0.534*rgb[1] + 0.131*rgb[2]));
	              
	              outputImage.setRGB(j, i, ImgUtil.getRGB(r, g, b));
	        }  
	     }
	     return outputImage;
	     
	}
}
