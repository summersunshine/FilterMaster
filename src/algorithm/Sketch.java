package algorithm;

import java.awt.image.BufferedImage;

import util.ImgUtil;

public class Sketch
{

	public static BufferedImage getImage(BufferedImage image)
	{
		int height = image.getHeight();
		int width = image.getWidth();
		
        
	    //转换成灰度图
	    BufferedImage grayImage = Gray.getImage(image);
	    
	    
	    //反响
	    BufferedImage reverseImage = Inverse.getImage(grayImage);
	    
	    //高斯模糊
	    BufferedImage guassBlurImage = GuassBlur.getImage(reverseImage);
	        
      
	    
        for(int i=0;i<height;i++)  
        {
	        for(int j=0;j<width;j++)  
	        {  
	           int b = ImgUtil.getSplitRGB(guassBlurImage.getRGB(j, i))[0] ;
	           int a = ImgUtil.getSplitRGB(grayImage.getRGB(j, i))[0] ;
	           
	           int temp=a+a*b/(256-b);    
	           a= Math.min(temp,255);  
	
	           reverseImage.setRGB(j, i, ImgUtil.getRGB(a, a, a));
	        
	        }
		}
       return reverseImage;
	}
}
