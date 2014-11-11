package util;

public class ColorUtil
{

	/**
	 * 将RGB值转换为hsl空间
	 * 
	 * @param value
	 * */
	public static HSL getHsl(RGB value)
	{
		// 获取r,g,b中的最大值
		int max = Math.max(Math.max(value.r, value.g), value.b);
		// 获取r,g,b中的最小值
		int min = Math.min(Math.min(value.r, value.g), value.b);

		float h, s, l;

		if (max == min)
		{
			h = 0;
		}
		else if (max == value.r)
		{
			if (value.g >= value.b)
			{
				h = 60 * (value.g - value.b) / (max - min);
			}
			else
			{
				h = 60 * (value.g - value.b) / (max - min) + 360;
			}
		}
		else if (max == value.g)
		{
			h = 60 * (value.b - value.r) / (max - min) + 120;
		}
		else
		{
			h = 60 * (value.r - value.g) / (max - min) + 240;
		}

		l = (max + min) / 2 / 255;

		if (l == 0 || max == min)
		{
			s = 0;
		}
		else if (0 < l && l <= 127)
		{
			s = (max - min) / (2 * l);
		}
		else
		{
			s = (max - min) / (2 - 2 * l);
		}

		h = h * 255 / 360f;
		l *= 255;
		s *= 255;
		return new HSL((int) h, (int) s, (int) l);
	}

	/**
	 * 将hsl转换到rgb空间
	 * 
	 * @param value
	 * */
	public static RGB getRGB(HSL value)
	{
		float r, g, b;
		float h = value.h * 360 / 255f;
		float l = value.l / 255f;
		float s = value.s / 255f;
		if (value.s == 0)
		{
			r = g = b = value.l;
			return new RGB(r, g, b);
		}

		float p, q;
		if (l < 0.5)
		{
			q = l * (1 + s);
		}
		else
		{
			q = l + s - (l * s);
		}
		p = 2 * l - q;

		r = h + 1 / 3f;
		g = h;
		b = h - 1 / 3f;

		r = getValue(clamp(r), p, q) * 255;
		g = getValue(clamp(g), p, q) * 255;
		b = getValue(clamp(b), p, q) * 255;

		return new RGB(r, g, b);
	}

	/**
	 * 将值收到0-1区间内
	 * 
	 * @param value
	 * */
	public static float clamp(float value)
	{
		if (value < 0)
		{
			return value + 1;
		}

		if (value > 1)
		{
			return value - 1;
		}

		return value;
	}

	/**
	 * 计算值
	 * 
	 * @param value
	 * @param p
	 * @param q
	 * */
	public static float getValue(float value, float p, float q)
	{
		if (value < 1 / 6f)
		{
			value = p + ((q - p) * 6 * value);
		}
		else if (1 / 6f <= value && value < 1 / 2f)
		{
			value = q;
		}
		else if (1 / 2f <= value && value < 2 / 3f)
		{
			value = p + ((q - p) * 6 * (2 / 3f - value));
		}
		else
		{
			value = p;
		}

		return value;

	}
}
