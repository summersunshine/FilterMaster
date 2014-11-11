package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;

import algorithm.ImageFactory;

public class ImagePanel extends JPanel
{
	// 显示图像的最大宽度
	public static final int MAX_IMAGE_WIDTH = 450;

	// 显示图像的最大长度
	public static final int MAX_IMAGE_HEIGHT = 800;

	// 图像中心的X
	public static final int IMAGE_CENTER_X = 640;

	// 图像中心的Y
	public static final int IMAGE_CENTER_Y = 360;

	// 显示的图像
	protected BufferedImage displayImage;

	// 原始的图像
	protected BufferedImage sourceImage;
	
	protected float ratioX;
	protected float ratioY;
	protected float ratio;
	protected int x;
	protected int y;
	protected int width;
	protected int height;

	public ImagePanel(BufferedImage image)
	{

		initImage(image);
		calRatio();
		calSizeAndPos();
		setVisible(true);
	}

	public void updateImage(BufferedImage image)
	{
		// TODO Auto-generated method stub
		displayImage = image;
		
		repaint();
	}
	
	public void updateImage(int type,Object... parameter)
	{
		// TODO Auto-generated method stub
		displayImage = ImageFactory.getImage(type, sourceImage, parameter);

		repaint();
	}

	@Override
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		try
		{

			g2.drawImage(displayImage, 0, 0, width, height, null);

		} finally
		{
			g2.dispose();
		}
	}

	
	private void initImage(BufferedImage image)
	{
		sourceImage = image;
		displayImage = image;
	}
	
	/**
	 * 计算ratio
	 * */
	private void calRatio()
	{
		ratioX = ratioY = 1;

		if (displayImage.getWidth() > MAX_IMAGE_WIDTH)
		{
			ratioX = MAX_IMAGE_HEIGHT * 1.0f / displayImage.getWidth();
		}

		if (displayImage.getHeight() > MAX_IMAGE_HEIGHT)
		{
			ratioY = MAX_IMAGE_HEIGHT * 1.0f / displayImage.getHeight();
		}

		ratio = ratioX < ratioY ? ratioX : ratioY;

	}

	/**
	 * 重新计算图片绘制的位置和大小
	 * */
	protected void calSizeAndPos()
	{
		width = (int) (displayImage.getWidth() * ratio);
		height = (int) (displayImage.getHeight() * ratio);
		x = IMAGE_CENTER_X - width / 2;
		y = IMAGE_CENTER_Y - height / 2;

		setLocation(x, y);

		setSize(width, height);
	}

}
