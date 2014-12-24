package filter.art;

import util.ImgUtil;
import filter.Filter;

public class SculptureFilter extends Filter
{

	public void preProcessor()
	{
		super.preProcessor();
		// rgbΪ����ͼ���3��ͨ����output r g bΪ���ͼ���ͨ��
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				outputImage.setRGB(x, y, ImgUtil.getRGB(128, 128, 128));
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
				int[] rgbColor1 = ImgUtil.getSplitRGB(image.getRGB(x - 1, y - 1));
				int[] rgbColor2 = ImgUtil.getSplitRGB(image.getRGB(x + 1, y + 1));
				int r = rgbColor1[0] - rgbColor2[0] + 128;
				int g = rgbColor1[1] - rgbColor2[1] + 128;
				int b = rgbColor1[2] - rgbColor2[2] + 128;
				r = ImgUtil.clampIn255(r);
				g = ImgUtil.clampIn255(g);
				b = ImgUtil.clampIn255(b);

				outputImage.setRGB(x, y, ImgUtil.getRGB(r, g, b));
			}
		}
	}

}
