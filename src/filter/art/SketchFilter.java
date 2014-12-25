package filter.art;

import java.awt.image.BufferedImage;

import util.image.ImageUtil;
import filter.Filter;
import filter.Blur.GuassBlurFilter;
import filter.basic.GrayFilter;
import filter.basic.InverseFilter;

public class SketchFilter extends Filter
{

	@Override
	public void processor()
	{
		// TODO Auto-generated method stub
		// 转换成灰度图
		GrayFilter grayFilter = new GrayFilter();
		BufferedImage grayImage = grayFilter.getImage(image);

		// 反向
		InverseFilter inverseFilter = new InverseFilter();
		BufferedImage reverseImage = inverseFilter.getImage(grayImage);

		// 高斯模糊滤波器
		GuassBlurFilter guassBlurFilter = new GuassBlurFilter();
		BufferedImage guassBlurImage = guassBlurFilter.getImage(reverseImage);

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				int b = ImageUtil.getSplitRGB(guassBlurImage.getRGB(x, y))[0];
				int a = ImageUtil.getSplitRGB(grayImage.getRGB(x, y))[0];

				int temp = (int) (a + a * b / (256 - b) / 1.5);
				a = Math.min(temp, 255);

				outputImage.setRGB(x, y, ImageUtil.getRGB(a, a, a));

			}
		}
	}

}
