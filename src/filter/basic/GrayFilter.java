package filter.basic;

import util.ImgUtil;
import filter.Filter;

public class GrayFilter extends Filter
{

	@Override
	public void processor()
	{
		// TODO Auto-generated method stub

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				int[] rgb = ImgUtil.getSplitRGB(image.getRGB(x, y));
				int averageRgb = (rgb[0] + rgb[1] + rgb[2]) / 3;

				outputImage.setRGB(x, y, ImgUtil.getRGB(averageRgb, averageRgb, averageRgb));
			}
		}

	}

}
