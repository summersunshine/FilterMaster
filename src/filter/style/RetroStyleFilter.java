package filter.style;

import util.ImageUtil;
import filter.Filter;

public class RetroStyleFilter extends Filter
{

	@Override
	public void processor()
	{
		// TODO Auto-generated method stub
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				int[] rgb = ImageUtil.getSplitRGB(image.getRGB(x, y));
				int r = (int) Math.max(0, Math.min(255, 0.393 * rgb[0] + 0.769 * rgb[1] + 0.189 * rgb[2]));
				int g = (int) Math.max(0, Math.min(255, 0.349 * rgb[0] + 0.686 * rgb[1] + 0.168 * rgb[2]));
				int b = (int) Math.max(0, Math.min(255, 0.272 * rgb[0] + 0.534 * rgb[1] + 0.131 * rgb[2]));

				outputImage.setRGB(x, y, ImageUtil.getRGB(r, g, b));
			}
		}
	}

}
