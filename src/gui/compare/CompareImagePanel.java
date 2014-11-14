package gui.compare;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class CompareImagePanel extends JPanel
{
	// Դͼ��
	private BufferedImage sourceImage;

	// ��ʾͼ������֮���ͼ��
	private BufferedImage displayImage;

	// ͼ����
	private int imageWidth;

	// ͼ��߶�
	private int imageHeight;

	// x����
	private int x;

	// y����
	private int y;

	// x�᷽��ı���
	private float ratioX;

	// y�᷽��ı���
	private float ratioY;

	// �ܵı���
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
	 * ����ͼ����� ͨ����֮ǰ�����һ�β���
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
	 * �����������ϵĻ���
	 * 
	 * @param g2
	 * */
	public void clear(Graphics2D graphics2d)
	{
		graphics2d.clearRect(0, 0, CompareSetting.MAX_IMAGE_WDITH, CompareSetting.MAX_IMAGE_HEIGHT);
	}

	/**
	 * ��ֱ����»���ͼ��
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
	 * ˮƽ����»���ͼ��
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
	 * ������������µ�ratio ��ֱ ˮƽ
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
	 * ������ֱ����ʱ��ratio
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
	 * ����ˮƽ����ʱ��ratio
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
	 * ���¼���ͼƬ���Ƶ�λ�úʹ�С
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
