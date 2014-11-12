package util;

public class HSV
{
	public static final int H = 1;
	public static final int S = 2;
	public static final int V = 3;

	public int h;
	public int s;
	public int v;

	public HSV(int h, int s, int v)
	{
		this.h = h;
		this.s = s;
		this.v = v;
		clamp();
	}

	public HSV(int[] hsv)
	{
		this.h = hsv[0];
		this.s = hsv[1];
		this.v = hsv[2];
		clamp();
	}

	public HSV(int hsv)
	{
		this.h = (hsv & 0xff0000) >> 16;
		this.s = (hsv & 0xff00) >> 8;
		this.v = (hsv & 0xff);
		clamp();
	}

	public int[] getSplitHSB()
	{
		int[] hsvs = new int[3];
		hsvs[0] = h;
		hsvs[1] = s;
		hsvs[2] = v;
		return hsvs;
	}

	public int getHSB()
	{
		int hh = h << 16;
		int ss = s << 8;
		int vv = v;
		return (hh | ss | vv);
	}
	
	public void clamp()
	{
		h = ImgUtil.clamp(h,360);
		s = ImgUtil.clamp(s,100);
		v = ImgUtil.clamp(v,100);
	}
}
