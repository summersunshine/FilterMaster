package gui.compare;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class CompareImagePanel extends JPanel
{
	// 源图像
	private BufferedImage sourceImage;

	// 显示图像，美化之后的图像
	private BufferedImage displayImage;

	// 图像宽度
	private int imageWidth;

	// 图像高度
	private int imageHeight;

	// x坐标
	private int x;

	// y坐标
	private int y;

	// x轴方向的比率
	private float ratioX;

	// y轴方向的比率
	private float ratioY;

	// 总的比率
	private float ratio;

	public CompareImagePanel(BufferedImage sourceImage, BufferedImage displayImage)
	{
		this.sourceImage = sourceImage;
		this.displayImage = displayImage;

		this.calRatio();
		this.calSizeAndPos();

		this.setVisible(true);
	}

	/**
	 * 更新图像面板 通常在之前会更新一次布局
	 * */
	public void updateImagePanel()
	{
		this.calRatio();
		this.calSizeAndPos();
		this.repaint();
	}

	@Override
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		try
		{
			clear(g2);
			if (CompareSetting.isVertical())
			{
				paintInVertical(g2);
			}
			else
			{
				paintInHorizontal(g2);
			}

		}
		finally
		{
			g2.dispose();
		}
	}

	/**
	 * 清除整个面板上的缓存
	 * 
	 * @param g2
	 * */
	public void clear(Graphics2D graphics2d)
	{
		graphics2d.clearRect(0, 0, CompareSetting.MAX_IMAGE_WDITH, CompareSetting.MAX_IMAGE_HEIGHT);
	}

	/**
	 * 竖直情况下绘制图像
	 * 
	 * @param graphics2d
	 * */
	private void paintInVertical(Graphics2D graphics2d)
	{
		int x = (CompareSetting.IMAGE_PANEL_WIDTH - imageWidth) / 2;
		graphics2d.drawImage(sourceImage, x, 0, imageWidth, imageHeight, null);
		graphics2d.drawImage(displayImage, x, imageHeight, imageWidth, imageHeight, null);
	}

	/**
	 * 水平情况下绘制图像
	 *
	 * @param graphics2d
	 * */
	private void paintInHorizontal(Graphics2D graphics2d)
	{
		int y = (CompareSetting.IMAGE_PANEL_WIDTH - imageHeight) / 2;
		graphics2d.drawImage(sourceImage, 0, y, imageWidth, imageHeight, null);
		graphics2d.drawImage(displayImage, imageWidth, y, imageWidth, imageHeight, null);
	}

	/**
	 * 计算两种情况下的ratio 竖直 水平
	 * */
	private void calRatio()
	{
		ratioX = ratioY = 1;

		if (CompareSetting.isVertical())
		{
			calRatioInVertical();
		}
		else
		{
			calRatioInHorizontal();
		}

		ratio = ratioX < ratioY ? ratioX : ratioY;
		
		System.out.println("ratio" + ratio);
	}

	/**
	 * 计算竖直放置时的ratio
	 * */
	private void calRatioInVertical()
	{

		if (sourceImage.getWidth() > CompareSetting.MAX_IMAGE_WDITH)
		{
			ratioX = CompareSetting.MAX_IMAGE_WDITH * 1.0f / sourceImage.getWidth();
		}

		if (sourceImage.getHeight() > CompareSetting.MAX_IMAGE_HEIGHT / 2)
		{
			ratioY = CompareSetting.MAX_IMAGE_HEIGHT * .5f / sourceImage.getHeight();
		}

	}

	/**
	 * 计算水平放置时的ratio
	 * */
	private void calRatioInHorizontal()
	{
		if (sourceImage.getWidth() > CompareSetting.MAX_IMAGE_WDITH/2)
		{
			ratioX = CompareSetting.MAX_IMAGE_WDITH * 0.5f / sourceImage.getWidth();
		}

		if (sourceImage.getHeight() > CompareSetting.MAX_IMAGE_HEIGHT)
		{
			ratioY = CompareSetting.MAX_IMAGE_HEIGHT * 1.0f / sourceImage.getHeight();
		}

	}

	/**
	 * 重新计算图片绘制的位置和大小
	 * */
	public void calSizeAndPos()
	{
		int centerX = CompareSetting.FRAME_WIDTH / 2;
		int centerY = CompareSetting.FRAME_HEIGHT / 2;

		this.imageWidth = (int) (sourceImage.getWidth() * ratio);
		this.imageHeight = (int) (sourceImage.getHeight() * ratio);

		x = centerX - CompareSetting.IMAGE_PANEL_WIDTH / 2;
		y = centerY - CompareSetting.IMAGE_PANEL_HEIGHT / 2;

		setBounds(x, y, CompareSetting.IMAGE_PANEL_WIDTH, CompareSetting.IMAGE_PANEL_HEIGHT);

	}

}
