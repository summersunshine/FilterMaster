package util;

public class ColorUtil
{

	/**
	 * 将RGB值转换为hsl空间
	 * 
	 * @param value
	 * */
	public static HSV getHSV(RGB value)
	{
		
		float r = value.r/255f;
		float g = value.g/255f;
		float b = value.b/255f;
		
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


		if(max == 0)
		{
			s = 0;
		}
		else
		{
			s = 1 - (min/max);
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
		//float r, g, b;
		float h = value.h;
		float s = value.s / 100f;
		float v = value.v / 100f;
		
		
		int hi = (int) (h/60);
		float f = h/60 - hi;
		
		float p = v*(1-s);
		float q = v*(1-f*s);
		float t = v*(1-(1-f)*s);
		
		if (hi==0)
		{
			return new RGB(v*255, t*255, p*255); 
		}
		else if (hi==1)
		{
			return new RGB(q*255, v*255, p*255); 
		}
		else if (hi==2)
		{
			return new RGB(p*255, v*255, t*255); 
		}
		else if (hi==3)
		{
			return new RGB(p*255, q*255, v*255); 
		}
		else if (hi==4)
		{
			return new RGB(t*255, p*255, v*255); 
		}
		else
		{
			return new RGB(v*255, p*255, q*255); 
		}
		
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
