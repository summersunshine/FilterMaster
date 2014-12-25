package filter.Blur;

import java.awt.Color;

import util.color.ColorUtil;
import filter.Filter;

public abstract class InteractiveBlurFilter extends Filter
{
	// ������Сֵ
	public static final int	MIN_MASK_SIZE		= 3;

	// �������ֵ
	public static final int	MAX_MASK_SIZE		= 15;

	// �������ֵ��һ��
	public static final int	HALF_MAX_MASK_SIZE	= 7;

	// ��Сֵ�����ֵ�Ĳ�
	public static final int	DIFF_MASK_SIZE		= MAX_MASK_SIZE - MIN_MASK_SIZE;

	// ����ģ��������
	public static final int	AREA_BLUR			= 1;

	// ��������������
	public static final int	AREA_CLEAR			= 2;

	// ���ڹ���������
	public static final int	AREA_TRAN			= 3;

	// Բ�ε���������
	public static final int	TYPE_CIRCLE			= 1;

	// ��ֱ����������
	public static final int	TYPE_VERTCIAL		= 2;

	// ˮƽ����������
	public static final int	TYPE_HORIZONTAL		= 3;

	public static int		centerX;

	public static int		centerY;

	public static int		size;

	private int				innerSize;

	private int				outSize;

	private Color[][]		colorMatrix;

	public void preProcessor()
	{
		// ��ȡrgb����
		colorMatrix = ColorUtil.getColorMatrix(image);

		innerSize = size;

		outSize = (int) (size * 1.5);

		super.preProcessor();
	}

	protected int getRGBValue(int x, int y, int distance)
	{
		if (distance > outSize)
		{
			return getBlurRGBValue(x, y, MAX_MASK_SIZE);
		}
		else if (distance < innerSize)
		{
			return image.getRGB(x, y);

		}
		else
		{
			// ��������
			int maskSize = MIN_MASK_SIZE + DIFF_MASK_SIZE * (distance - innerSize) / (outSize - innerSize);
			// ��masksize��Ϊ����
			maskSize = (maskSize / 2) * 2 + 1;

			return getBlurRGBValue(x, y, maskSize);
		}
	}

	/**
	 * ��ȡģ�����ͼ���rgbֵ
	 * 
	 * @param colorMatrix
	 * @param x
	 * @param y
	 * @param maskSize
	 * */
	protected int getBlurRGBValue(int x, int y, int maskSize)
	{
		int sum = maskSize * maskSize;
		int halfMaskSize = maskSize / 2;

		int sumR = 0, sumG = 0, sumB = 0;
		for (int i = -halfMaskSize; i <= halfMaskSize; i++)
		{
			for (int j = -halfMaskSize; j <= halfMaskSize; j++)
			{
				sumR += colorMatrix[x + i][y + j].getRed();
				sumG += colorMatrix[x + i][y + j].getGreen();
				sumB += colorMatrix[x + i][y + j].getBlue();
			}
		}
		sumR /= sum;
		sumG /= sum;
		sumB /= sum;

		sumR = sumR << 16;
		sumG = sumG << 8;

		return sumR | sumG | sumB;
	}

	/**
	 * ��ȡ����֮��ľ���
	 * 
	 * @param x1
	 *            ��һ�����X����
	 * @param y1
	 *            ��һ�����y����
	 * @param x2
	 *            �ڶ������X����
	 * @param y2
	 *            �ڶ������y����
	 * */
	protected int getDistance(int x1, int y1, int x2, int y2)
	{
		int x = x1 - x2;
		int y = y1 - y2;
		return (int) Math.sqrt(x * x + y * y);
	}

}
