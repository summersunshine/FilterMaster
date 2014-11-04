package util;

import java.awt.Color;

public class RGB
{
	public int r;
	public int g;
	public int b;
	
	public RGB(int r,int g,int b)
	{
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public RGB(int []rgb)
	{
		this.r = rgb[0];
		this.g = rgb[1];
		this.b = rgb[2];
	}
	
	public RGB(int rgb)
	{
		this.r 	= (rgb & 0xff0000) >> 16;
		this.g	= (rgb & 0xff00) >> 8;
		this.b  = (rgb & 0xff);
	}
	
	
	public  int[] getSplitRGB()
	{
		int[] rgbs = new int[3];
		rgbs[0] = r;
		rgbs[1] = g;
		rgbs[2] = b;
		return rgbs;
	}

	public  int getRGB()
	{
		int rr = r << 16;
		int gg = g << 8;
		int bb = b;
		return (rr | gg | bb);
	}
	
}
