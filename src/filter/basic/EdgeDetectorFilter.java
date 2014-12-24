package filter.basic;

import util.ColorUtil;
import util.ImgUtil;
import util.RGB;
import algorithm.basic.Gray;
import app.Constants;
import filter.Filter;

public class EdgeDetectorFilter extends Filter
{
	public static int[][]	SOBEL_MASK_X	= { { -1, 0, 1 }, { -2, 0, 2 }, { -1, 0, 1 } };
	public static int[][]	SOBEL_MASK_Y	= { { -1, -2, -1 }, { 0, 0, 0 }, { 1, 2, 1 } };
	public static int[][]	LAPLACE_MASK	= { { 0, -1, 0 }, { -1, 4, -1 }, { 0, -1, 0 } };

	public static int		type;

	@Override
	public void processor()
	{
		// TODO Auto-generated method stub
		int maskSize = 3;
		int halfMaskSize = maskSize / 2;

		RGB[][] imageMatrix = ColorUtil.getRGBMatrix(Gray.getImage(image));

		int[][] mask = getMask(type);

		for (int y = halfMaskSize; y < height - halfMaskSize; y++)
		{
			for (int x = halfMaskSize; x < width - halfMaskSize; x++)
			{
				int gray = getValue(imageMatrix, x, y, mask);

				outputImage.setRGB(x, y, ImgUtil.getRGB(gray, gray, gray));

			}
		}
	}

	private int[][] getMask(int type)
	{
		if (type == Constants.TYPE_EDGE_LAPLACE)
		{
			System.out.println("TYPE_EDGE_LAPLACE");
			return LAPLACE_MASK;
		}
		else if (type == Constants.TYPE_EDGE_SOBEL_X)
		{
			System.out.println("TYPE_EDGE_SOBEL_X");
			return SOBEL_MASK_X;
		}
		else
		{
			System.out.println("TYPE_EDGE_SOBEL_Y");
			return SOBEL_MASK_Y;
		}
	}

	private int getValue(RGB[][] imageMatrix, int x, int y, int[][] Mask)
	{
		int sum = 0;
		for (int i = -1; i <= 1; i++)
		{
			for (int j = -1; j <= 1; j++)
			{
				sum += imageMatrix[x + i][y + j].r * Mask[i + 1][j + 1];
			}
		}
		sum = ImgUtil.clampIn255(sum);

		return sum;
	}
}
