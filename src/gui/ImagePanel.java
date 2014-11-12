package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;

import algorithm.ImageFactory;
import algorithm.basic.Clone;

public class ImagePanel extends JPanel
{
	// 显示图像的最大宽度
	public static final int MAX_IMAGE_WIDTH = 800;

	// 显示图像的最大长度
	public static final int MAX_IMAGE_HEIGHT = 450;

	// 图像中心的X
	public static final int IMAGE_CENTER_X = 640;

	// 图像中心的Y
	public static final int IMAGE_CENTER_Y = 320;

	// 显示的图像
	protected BufferedImage displayImage;

	// 原始的图像
	protected BufferedImage sourceImage;
	


	//缩放比例
	protected float ratio;
	
	//面板x坐标
	protected int x;
	
	//面板y坐标
	protected int y;
	
	//画布宽度
	protected int width;
	
	//画布高度
	protected int height;

	public ImagePanel(BufferedImage image)
	{
		initDisplayImage(image);
		initSourceImage(image);
		
		calRatio();
		calSizeAndPos();
		
		setVisible(true);
	}


	
	/**
	 * 初始化显示图像 需要深度复制重新克隆出一个
	 * 
	 * @param image
	 * */
	protected void initDisplayImage(BufferedImage image)
	{
		displayImage = Clone.getImage(image);
	}
	
	/**
	 * 初始化源图像
	 * 
	 * @param image
	 * */
	protected void initSourceImage(BufferedImage image)
	{
		sourceImage = image;
	}
	

	/**
	 * 获取sourceImage
	 * */
	public BufferedImage getSourceImage()
	{
		return sourceImage;
	}
	
	/**
	 * 获取displayImage
	 * */
	public BufferedImage getDisplayImage()
	{
		return displayImage;
	}
	
	/**
	 * 直接更新图像并重画
	 * 
	 * @param image
	 * */
	public void updateImage(BufferedImage image)
	{
		// TODO Auto-generated method stub
		displayImage = image;

		repaint();
	}

	/**
	 * 使用类型和参数更新图像
	 * 
	 * @param type
	 * @param parameter
	 * */
	public void updateImage(int type, Object... parameter)
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

		}
		finally
		{
			g2.dispose();
		}
	}

	/**
	 * 计算ratio
	 * */
	private void calRatio()
	{
		float ratioX = 1, ratioY = 1;

		if (displayImage.getWidth() > MAX_IMAGE_WIDTH)
		{
			ratioX = MAX_IMAGE_WIDTH * 1.0f / displayImage.getWidth();
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

		setBounds(x, y, width, height);
	}



}
