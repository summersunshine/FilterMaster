package util;

public class HSL
{
	public static final int H = 1;
	public static final int S = 2;
	public static final int L = 3;

	public int h;
	public int s;
	public int l;

	public HSL(int r, int g, int b)
	{
		this.h = r;
		this.s = g;
		this.l = b;
	}

	public HSL(int[] hsl)
	{
		this.h = hsl[0];
		this.s = hsl[1];
		this.l = hsl[2];
	}

	public HSL(int hsl)
	{
		this.h = (hsl & 0xff0000) >> 16;
		this.s = (hsl & 0xff00) >> 8;
		this.l = (hsl & 0xff);
	}

	public int[] getSplitRGB()
	{
		int[] hsls = new int[3];
		hsls[0] = h;
		hsls[1] = s;
		hsls[2] = l;
		return hsls;
	}

	public int getRGB()
	{
		int hh = h << 16;
		int ss = s << 8;
		int ll = l;
		return (hh | ss | ll);
	}
}
