package util;

/**
 * RGB颜色空间
 * */
public class RGB
{
	public static final int	GRAY	= 0;
	public static final int	R		= 1;
	public static final int	G		= 2;
	public static final int	B		= 3;

	public int				r;
	public int				g;
	public int				b;

	/**
	 * 构造函数
	 *
	 * @param r
	 * @param g
	 * @param b
	 * */
	public RGB(int r, int g, int b)
	{
		this.r = r;
		this.g = g;
		this.b = b;

		clamp();
	}

	/**
	 * 构造函数
	 * 
	 * @param r
	 * @param g
	 * @param b
	 * */
	public RGB(float r, float g, float b)
	{
		this.r = (int) r;
		this.g = (int) g;
		this.b = (int) b;

		clamp();
	}

	/**
	 * 构造函数
	 * 
	 * @param rgb
	 *            [] 以数组的方式分别保存三个通道
	 * */
	public RGB(int[] rgb)
	{
		this.r = rgb[0];
		this.g = rgb[1];
		this.b = rgb[2];

		clamp();
	}

	/**
	 * 构造函数
	 * 
	 * @param rgb
	 *            24位整数
	 * */
	public RGB(int rgb)
	{
		this.r = (rgb & 0xff0000) >> 16;
		this.g = (rgb & 0xff00) >> 8;
		this.b = (rgb & 0xff);

		clamp();
	}

	/**
	 * 是否是纯白色
	 * */
	public boolean isPureWhite()
	{
		return this.r == 255 && this.g == 255 && this.b == 255;
	}

	/**
	 * 是否是纯黑色
	 * */
	public boolean isPureBlack()
	{
		return this.r == 0 && this.g == 0 && this.b == 255;
	}

	public int[] getSplitRGB()
	{
		int[] rgbs = new int[3];
		rgbs[0] = r;
		rgbs[1] = g;
		rgbs[2] = b;
		return rgbs;
	}

	public int getRGB()
	{
		int rr = r << 16;
		int gg = g << 8;
		int bb = b;
		return (rr | gg | bb);
	}

	public void clamp()
	{
		r = ImgUtil.clampIn255(r);
		g = ImgUtil.clampIn255(g);
		b = ImgUtil.clampIn255(b);
	}
}
