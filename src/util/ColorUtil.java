package util;

import java.awt.Label;

public class ColorUtil
{

	/**
	 * 将RGB值转换为hsl空间
	 * 
	 * @param value
	 * */
	public static HSV getHSV(RGB value)
	{

		float r = value.r / 255f;
		float g = value.g / 255f;
		float b = value.b / 255f;

		// 获取r,g,b中的最大值
		float max = Math.max(Math.max(r, g), b);
		// 获取r,g,b中的最小值
		float min = Math.min(Math.min(r, g), b);

		float h, s, v;

		if (max == min)
		{
			h = 0;
		}
		else if (max == r)
		{
			if (g >= b)
			{
				h = 60 * (g - b) / (max - min);
			}
			else
			{
				h = 60 * (g - b) / (max - min) + 360;
			}
		}
		else if (max == g)
		{
			h = 60 * (b - r) / (max - min) + 120;
		}
		else
		{
			h = 60 * (r - g) / (max - min) + 240;
		}

		if (max == 0)
		{
			s = 0;
		}
		else
		{
			s = 1 - (min / max);
		}

		v = max;

		v *= 100;
		s *= 100;
		return new HSV((int) h, (int) s, (int) v);
	}
	
	/**
	 * 将hsl转换到rgb空间
	 * 
	 * @param value
	 * */
	public static RGB getRGB(HSV value)
	{
		// float r, g, b;
		float h = value.h;
		float s = value.s / 100f;
		float v = value.v / 100f;

		int hi = (int) (h / 60);
		float f = h / 60 - hi;

		float p = v * (1 - s);
		float q = v * (1 - f * s);
		float t = v * (1 - (1 - f) * s);

		if (hi == 0)
		{
			return new RGB(v * 255, t * 255, p * 255);
		}
		else if (hi == 1)
		{
			return new RGB(q * 255, v * 255, p * 255);
		}
		else if (hi == 2)
		{
			return new RGB(p * 255, v * 255, t * 255);
		}
		else if (hi == 3)
		{
			return new RGB(p * 255, q * 255, v * 255);
		}
		else if (hi == 4)
		{
			return new RGB(t * 255, p * 255, v * 255);
		}
		else
		{
			return new RGB(v * 255, p * 255, q * 255);
		}

	}
	
	
	
	

	/**
	 * 将RGB转换为lab空间
	 * */
	public static LAB getLAB(RGB value)
	{
		float R = value.r;
		float G = value.g;
		float B = value.b;

		float L = (float) (0.2126007 * R + 0.7151947 * G + 0.0722046 * B);
		float a = (float) (0.3258962 * R - 0.4992596 * G + 0.1733409 * B + 128);
		float b = (float) (0.1218128 * R + 0.3785610 * G - 0.5003738 * B + 128);

		return new LAB(L, a, b);
	}

	/**
	 * 将LAB转换为RGB空间
	 * */
	public static RGB getRGB(LAB value)
	{
		float L = value.l;
		float a = value.a;
		float b = value.b;

		float R = (float) (L + 0.0120308 * a + 0.0021207 * b);
		float G = (float) (L - 0.0035973 * a - 0.0001765 * b);
		float B = (float) (L + 0.0002074 * a - 0.0044965 * b);

		return new RGB(R, G, B);
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
