package filter.art;

import util.image.ImageUtil;
import filter.Filter;

public class SculptureFilter extends Filter
{

	public void preProcessor()
	{
		super.preProcessor();
		// rgb为输入图像的3个通道，output r g b为输出图像的通道
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				outputImage.setRGB(x, y, ImageUtil.getRGB(128, 128, 128));
			}
		}
	}

	@Override
	public void processor()
	{

		for (int y = 1; y < height - 1; y++)
		{
			for (int x = 1; x < width - 1; x++)
			{
				int[] rgbColor1 = ImageUtil.getSplitRGB(image.getRGB(x - 1, y - 1));
				int[] rgbColor2 = ImageUtil.getSplitRGB(image.getRGB(x + 1, y + 1));
				int r = rgbColor1[0] - rgbColor2[0] + 128;
				int g = rgbColor1[1] - rgbColor2[1] + 128;
				int b = rgbColor1[2] - rgbColor2[2] + 128;
				r = ImageUtil.clampIn255(r);
				g = ImageUtil.clampIn255(g);
				b = ImageUtil.clampIn255(b);

				outputImage.setRGB(x, y, ImageUtil.getRGB(r, g, b));
			}
		}
	}

}
