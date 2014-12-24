package filter.art;

import java.awt.image.BufferedImage;

import util.ImgUtil;
import algorithm.basic.Gray;
import algorithm.basic.Inverse;
import algorithm.blur.GuassBlur;
import filter.Filter;

public class SketchFilter extends Filter
{

	@Override
	public void processor()
	{
		// TODO Auto-generated method stub
		// 转换成灰度图
		BufferedImage grayImage = Gray.getImage(image);

		// 反向
		BufferedImage reverseImage = Inverse.getImage(grayImage);

		// 高斯模糊
		BufferedImage guassBlurImage = GuassBlur.getImage(reverseImage);

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				int b = ImgUtil.getSplitRGB(guassBlurImage.getRGB(x, y))[0];
				int a = ImgUtil.getSplitRGB(grayImage.getRGB(x, y))[0];

				int temp = (int) (a + a * b / (256 - b) / 1.5);
				a = Math.min(temp, 255);

				outputImage.setRGB(x, y, ImgUtil.getRGB(a, a, a));

			}
		}
	}

}
