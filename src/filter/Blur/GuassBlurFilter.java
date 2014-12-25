package filter.Blur;

import java.awt.Color;

import util.ImageUtil;
import util.color.ColorUtil;
import filter.Filter;

public class GuassBlurFilter extends Filter
{

	public static int	MASKSIZE	= 5;

	/**
	 * 对mask的size做预处理
	 * 
	 * @param masksize
	 * @return new mask size
	 * */
	public void preProcessor()
	{
		super.preProcessor();
		MASKSIZE = (MASKSIZE / 2) * 2 + 1;

	}

	@Override
	public void processor()
	{
		// TODO Auto-generated method stub

		int halfMaskSize = MASKSIZE / 2;

		Color[][] imageMatrix = ColorUtil.getColorMatrix(image);

		double sum = MASKSIZE * MASKSIZE;

		for (int y = halfMaskSize; y < height - halfMaskSize; y++)
		{
			for (int x = halfMaskSize; x < width - halfMaskSize; x++)
			{
				float sumR = 0, sumG = 0, sumB = 0;
				for (int i = -halfMaskSize; i <= halfMaskSize; i++)
				{
					for (int j = -halfMaskSize; j <= halfMaskSize; j++)
					{
						sumR += imageMatrix[x + i][y + j].getRed();
						sumG += imageMatrix[x + i][y + j].getGreen();
						sumB += imageMatrix[x + i][y + j].getBlue();
					}
				}
				sumR /= sum;
				sumR = ImageUtil.clamp(sumR);
				sumG /= sum;
				sumG = ImageUtil.clamp(sumG);
				sumB /= sum;
				sumB = ImageUtil.clamp(sumB);

				outputImage.setRGB(x, y, ImageUtil.getRGB((int) sumR, (int) sumG, (int) sumB));

			}
		}
	}
}
