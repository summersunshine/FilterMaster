package algorithm.blur;

import java.awt.image.BufferedImage;

import util.Geometry;
import util.ImgUtil;
import util.RGB;

/**
 * ��˹ģ��
 * */
public class GuassBlur
{

	public static final int[][] MASK =
	{
	{ 1, 2, 1 },
	{ 2, 4, 2 },
	{ 1, 2, 1 } };
	
	public static final int MASK_SIZE = 3;

	public static BufferedImage getImage(BufferedImage image)
	{

		int height = image.getHeight();
		int width = image.getWidth();

		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		RGB[][] imageMatrix = new RGB[width][height];
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				RGB rgb = new RGB(image.getRGB(x, y));
				imageMatrix[x][y] = rgb;
			}
		}

		for (int y = 1; y < height - 1; y++)
		{
			for (int x = 1; x < width - 1; x++)
			{

				int r = imageMatrix[x - 1][y - 1].r + 2 * imageMatrix[x - 1][y].r + imageMatrix[x - 1][y + 1].r + 2 * imageMatrix[x][y - 1].r + 4
						* imageMatrix[x][y].r + 2 * imageMatrix[x][y + 1].r + imageMatrix[x + 1][y - 1].r + 2 * imageMatrix[x + 1][y].r
						+ imageMatrix[x + 1][y + 1].r;

				int g = imageMatrix[x - 1][y - 1].g + 2 * imageMatrix[x - 1][y].g + imageMatrix[x - 1][y + 1].g + 2 * imageMatrix[x][y - 1].g + 4
						* imageMatrix[x][y].g + 2 * imageMatrix[x][y + 1].g + imageMatrix[x + 1][y - 1].g + 2 * imageMatrix[x + 1][y].g
						+ imageMatrix[x + 1][y + 1].g;

				int b = imageMatrix[x - 1][y - 1].b + 2 * imageMatrix[x - 1][y].b + imageMatrix[x - 1][y + 1].b + 2 * imageMatrix[x][y - 1].b + 4
						* imageMatrix[x][y].b + 2 * imageMatrix[x][y + 1].b + imageMatrix[x + 1][y - 1].b + 2 * imageMatrix[x + 1][y].b
						+ imageMatrix[x + 1][y + 1].b;

				r = r / 16;
				g = g / 16;
				b = b / 16;

				r = ImgUtil.clamp(r);
				g = ImgUtil.clamp(g);
				b = ImgUtil.clamp(b);

				outputImage.setRGB(x, y, ImgUtil.getRGB(r, g, b));

			}
		}

		return outputImage;

	}

	public static BufferedImage getImage(BufferedImage image, int centerX, int centerY, int radius)
	{
		int startX = centerX - radius;
		int startY = centerY - radius;
		int endX = centerX + radius;
		int endY = centerY + radius;

		RGB[][] imageMatrix = new RGB[2 * radius+2][2 * radius+2];
		for (int y = startY; y < endY; y++)
		{
			for (int x = startX; x < endX; x++)
			{
				RGB rgb = new RGB(image.getRGB(x, y));
				imageMatrix[x-startX][y-startY] = rgb;
			}
		}

		// ֻ�ڿ��ܵķ�Χ�ڽ���ɨ��
		// ��С������
		for (int y = startY+1; y < endY-1; y++)
		{
			for (int x = startX+1; x < endX-1; x++)
			{
				// �������Բ�ھͽ���ģ�������򲻴���
				if (Geometry.getDistance(x, y, centerX, centerY) < radius)
				{
					int r = getValue(imageMatrix, x-startX, y-startY, RGB.R);
					int g = getValue(imageMatrix, x-startX, y-startY, RGB.G);
					int b = getValue(imageMatrix, x-startX, y-startY, RGB.B);

					image.setRGB(x, y, ImgUtil.getRGB(r, g, b));
				}
			}
		}

		return image;

	}

	/**
	 * ��ȡֵ
	 * 
	 * @param imageMatrxi
	 * @param x
	 * @param y
	 * @param type
	 *            ͨ�������Լ���������ȡ�µ�ֵ
	 * */
	static int getValue(RGB[][] imageMatrix, int x, int y, int type)
	{
		System.out.println("" + x + " " + y);
		int sum = 0;
		for (int i = -1; i <= 1; i++)
		{
			for (int j = -1; j <= 1; j++)
			{
				if (type == RGB.R)
				{
					sum += imageMatrix[x + i][y + i].r*MASK[i+1][j+1];
				} else if (type == RGB.G)
				{
					sum += imageMatrix[x + i][y + i].g*MASK[i+1][j+1];
				} else
				{
					sum += imageMatrix[x + i][y + i].b*MASK[i+1][j+1];
				}

			}
		}
		sum /= 16;

		sum = ImgUtil.clamp(sum);

		return sum;
	}
}
