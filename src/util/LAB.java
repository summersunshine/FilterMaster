package util;


/**
 * LABÑÕÉ«¿Õ¼ä
 * */
public class LAB
{
	public static final int L = 1;
	public static final int A = 2;
	public static final int B = 3;

	public int l;
	public int a;
	public int b;

	public LAB(int l, int  a, int b)
	{
		this.l = l;
		this.a = a;
		this.b = b;
		
		clamp();
	}

	public LAB(float l, float a, float b)
	{
		this.l = (int) l;
		this.a = (int) a;
		this.b = (int) b;
		
		clamp();
	}

	public LAB(int[] lab)
	{
		this.l = lab[0];
		this.a = lab[1];
		this.b = lab[2];
		
		clamp();
	}

	public LAB(int rgb)
	{
		this.l = (rgb & 0xff0000) >> 16;
		this.a = (rgb & 0xff00) >> 8;
		this.b = (rgb & 0xff);
		
		clamp();
	}

	public int[] getSplitLAB()
	{
		int[] rgbs = new int[3];
		rgbs[0] = l;
		rgbs[1] = a;
		rgbs[2] = b;
		return rgbs;
	}

	public int getLAB()
	{
		int rr = l << 16;
		int gg = a << 8;
		int bb = b;
		return (rr | gg | bb);
	}
	
	
	public void clamp()
	{
		l = ImgUtil.clamp(l);
		a = ImgUtil.clamp(a);
		b = ImgUtil.clamp(b);
	}
}
