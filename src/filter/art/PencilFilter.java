package filter.art;

import util.ImageUtil;
import filter.Filter;

public class PencilFilter extends Filter
{

	private static int	sensitivity	= 30;

	@Override
	public void processor()
	{
		// TODO Auto-generated method stub
		int m, n;
		for (int y = 0; y < height - 1; y++)
		{
			n = y + 1;
			for (int x = 0; x < width - 1; x++)
			{
				m = x + 1;
				// 当前灰度
				int color = getColor(image.getRGB(x, y));

				// 下一个点的灰度
				int nextColor = getColor(image.getRGB(m, n));

				if (color - nextColor > sensitivity)
				{
					outputImage.setRGB(x, y, ImageUtil.getRGB(0, 0, 0));
				}
				else
				{
					outputImage.setRGB(x, y, ImageUtil.getRGB(255, 255, 255));
				}
			}
		}

	}

	/**
	 * 颜色换算
	 * 
	 * @param rgb
	 * */
	private int getColor(int rgb)
	{
		int[] rgbColor = ImageUtil.getSplitRGB(rgb);
		int color = (int) ((rgbColor[0] * 3 + rgbColor[1] * 6 + rgbColor[2]) / 10.0);
		return color;
	}

}
