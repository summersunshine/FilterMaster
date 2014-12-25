package util.color;

import java.awt.Color;
import java.awt.image.BufferedImage;

import util.image.ImageUtil;

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
	 * 将rgb转换到hsl空间
	 * 
	 * */
	public static HSL getHSL(RGB value)
	{

		float r = value.r / 255f;
		float g = value.g / 255f;
		float b = value.b / 255f;

		// 获取r,g,b中的最大值
		float max = Math.max(Math.max(r, g), b);
		// 获取r,g,b中的最小值
		float min = Math.min(Math.min(r, g), b);

		float h, s, l;

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

		l = (max + min) / 2;

		if (l == 0 || min == max)
		{
			s = 0;
		}
		else if (0 < l && l <= 1 / 2f)
		{
			s = (max - min) / (2 * l);
		}
		else
		{
			s = (max - min) / (2 - 2 * l);
		}

		l *= 100;
		s *= 100;
		return new HSL((int) h, (int) s, (int) l);
	}

	/**
	 * 将hsl转换到rgb空间
	 * */
	public static RGB getRGB(HSL value)
	{
		float h = value.h / 360f;
		float s = value.s / 100f;
		float l = value.l / 100f;

		float q, p, tr, tg, tb;

		if (l < 1 / 2f)
		{
			q = l * (1 + s);
		}
		else
		{
			q = l + s - (l * s);
		}

		p = 2 * l - q;

		tr = h + 1 / 3f;
		tg = h;
		tb = h - 1 / 3f;

		tr = clampForHSL(tr);
		tg = clampForHSL(tg);
		tb = clampForHSL(tb);

		tr = transferForHSL(tr, p, q);
		tg = transferForHSL(tg, p, q);
		tb = transferForHSL(tb, p, q);

		return new RGB(tr * 255, tg * 255, tb * 255);
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
		float a = value.a - 128;
		float b = value.b - 128;
		double fx, fy, fz;
		double x, y, z;
		double dr, dg, db;

		fy = (1 + 16f) / 116f;
		fy = fy * fy * fy;

		if (fy > 0.008856)
		{
			y = fy;
		}
		else
		{
			fy = L / 903.3;
		}

		if (fy > 0.008856)
		{
			y = Math.pow(fy, 1.0 / 3.0);
		}
		else
		{
			y = 7.787 * fy + 16.0 / 116.0;
		}

		fx = a / 500.0 + fy;
		if (fx > 0.206893)
		{
			x = Math.pow(fx, 3.0);
		}
		else
		{
			x = (fx - 16.0 / 116.0) / 7.787;
		}

		fz = fy - b / 200.0;
		if (fz > 0.206893)
		{
			z = Math.pow(fz, 3);
		}
		else
		{
			z = (fz - 16.0 / 116.0) / 7.787;
		}

		x = x * 0.950456 * 255.0;
		y = y * 255.0;
		z = z * 1.088754 * 255.0;

		dr = 3.240479 * x - 1.537150 * y - 0.498535 * z;
		dg = -0.969256 * x + 1.875992 * y + 0.041556 * z;
		db = 0.055648 * x - 0.204043 * y + 1.057311 * z;

		dr = ImageUtil.clamp((float) dr);
		dg = ImageUtil.clamp((float) dg);
		db = ImageUtil.clamp((float) db);

		return new RGB((int) dr, (int) dg, (int) db);
	}

	/**
	 * 将值收到0-1区间内
	 * 
	 * @param value
	 * */
	public static float clampForHSL(float value)
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
	 * 将数值进行计算转换
	 * 
	 * @param value
	 * */
	public static float transferForHSL(float value, float p, float q)
	{
		if (value < 1 / 6f)
		{
			return p + (q - p) * 6 * value;
		}
		else if (1 / 6f <= value && value < 1 / 2f)
		{
			return q;
		}
		else if (1 / 2f <= value && value < 2 / 3f)
		{
			return p + (q - p) * 6 * (2 / 3f - value);
		}
		else
		{
			return p;
		}

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

	/**
	 * 获取RGB矩阵
	 * 
	 * @param image
	 * */
	public static RGB[][] getRGBMatrix(BufferedImage image)
	{
		int width = image.getWidth();
		int height = image.getHeight();
		RGB[][] matrix = new RGB[width][height];
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				matrix[x][y] = new RGB(image.getRGB(x, y));
			}
		}
		return matrix;

	}

	/**
	 * 获取Color矩阵
	 * 
	 * @param image
	 * */
	public static Color[][] getColorMatrix(BufferedImage image)
	{
		int width = image.getWidth();
		int height = image.getHeight();
		Color[][] matrix = new Color[width][height];
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				matrix[x][y] = new Color(image.getRGB(x, y));
			}
		}
		return matrix;

	}

}
