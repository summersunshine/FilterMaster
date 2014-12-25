package util.color;

import util.image.ImageUtil;

/**
 * HSLÑÕÉ«¿Õ¼ä
 * H 0~360
 * S 0~100
 * L 0~100
 * */
public class HSL
{
	public static final int H = 1;
	public static final int S = 2;
	public static final int L = 3;

	public int h;
	public int s;
	public int l;

	public HSL(int h, int s, int l)
	{
		this.h = h;
		this.s = s;
		this.l = l;
		clamp();
	}

	public HSL(int[] value)
	{
		this.h = value[0];
		this.s = value[1];
		this.l = value[2];
		clamp();
	}

	public HSL(int value)
	{
		this.h = (value & 0xff0000) >> 16;
		this.s = (value & 0xff00) >> 8;
		this.l = (value & 0xff);
		clamp();
	}

	public int[] getSplitHSL()
	{
		int[] value = new int[3];
		value[0] = h;
		value[1] = s;
		value[2] = l;
		return value;
	}

	public int getHSL()
	{
		int hh = h << 16;
		int ss = s << 8;
		int ll = l;
		return (hh | ss | ll);
	}
	
	public void clamp()
	{
		h = ImageUtil.clamp(h,360);
		s = ImageUtil.clamp(s,100);
		l = ImageUtil.clamp(l,100);
	}
}
