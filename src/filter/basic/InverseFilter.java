package filter.basic;

import util.color.RGB;
import filter.Filter;

public class InverseFilter extends Filter
{

	@Override
	public void processor()
	{
		// TODO Auto-generated method stub
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				RGB rgb = new RGB(image.getRGB(x, y));
				RGB reverseRgb = new RGB(255 - rgb.r, 255 - rgb.g, 255 - rgb.b);
				outputImage.setRGB(x, y, reverseRgb.getRGB());
			}
		}
	}

}
