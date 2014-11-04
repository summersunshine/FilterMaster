package algorithm;

import java.awt.image.BufferedImage;

import util.ImgUtil;
import util.RGB;

public class GuassBlur
{
	public static BufferedImage getImage(BufferedImage image)
	{
		
		int height = image.getHeight();
		int width  = image.getWidth();
		
		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		RGB [][] imageMatrix = new RGB[width][height];
	     for(int i=0;i<height;i++)  
	     {
	        for(int j=0;j<width;j++)  
	        {     
	              RGB rgb = new RGB(image.getRGB(j, i));
	              imageMatrix[j][i] = rgb;
	        }  
	     }
	     
	     
	     for(int j=1;j<height-1;j++)  
	     {
	        for(int i=1;i<width-1;i++)  
	        {     
	              
	            int r=  imageMatrix[i-1][j-1].r+ 2*imageMatrix[i-1][j  ].r+  imageMatrix[i-1][j+1].r+  
	            		2*imageMatrix[i  ][j-1].r+4*imageMatrix[i  ][j  ].r+2*imageMatrix[i  ][j+1].r+  
	            		  imageMatrix[i+1][j-1].r+2*imageMatrix[i+1][j  ].r+  imageMatrix[i+1][j+1].r;  
	              
	            int g=  imageMatrix[i-1][j-1].g+ 2*imageMatrix[i-1][j  ].g+  imageMatrix[i-1][j+1].g+  
	            		2*imageMatrix[i  ][j-1].g+4*imageMatrix[i  ][j  ].g+2*imageMatrix[i  ][j+1].g+  
	            		  imageMatrix[i+1][j-1].g+2*imageMatrix[i+1][j  ].g+  imageMatrix[i+1][j+1].g; 
	            
	            int b=  imageMatrix[i-1][j-1].b+ 2*imageMatrix[i-1][j  ].b+  imageMatrix[i-1][j+1].b+  
	            		2*imageMatrix[i  ][j-1].b+4*imageMatrix[i  ][j  ].b+2*imageMatrix[i  ][j+1].b+  
	            		  imageMatrix[i+1][j-1].b+2*imageMatrix[i+1][j  ].b+  imageMatrix[i+1][j+1].b; 
	            

	            r = r/16; 
	            g = g/16;
	            b = b/16;
	              
	            outputImage.setRGB(i, j, ImgUtil.getRGB(r, g, b));
	  
	        }  
	     }
	     
	     return outputImage;
		
	}
}
