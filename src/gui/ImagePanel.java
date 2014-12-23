package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;

import algorithm.basic.Clone;
import algorithm.factory.ImageFactory;

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

	// 缩放比例
	protected float ratio;

	// 面板x坐标
	protected int x;

	// 面板y坐标
	protected int y;

	// 画布宽度
	protected int canvasWidth;

	// 画布高度
	protected int canvasHeight;

	public int getCanvasWidth()
	{
		return canvasWidth;
	}

	public void setCanvasWidth(int width)
	{
		this.canvasWidth = width;
	}

	public int getCanvasHeight()
	{
		return canvasHeight;
	}

	public void setCanvasHeight(int height)
	{
		this.canvasHeight = height;
	}

	public ImagePanel(BufferedImage image)
	{
		initDisplayImage(image);
		initSourceImage(image);

		calRatio(MAX_IMAGE_WIDTH, MAX_IMAGE_HEIGHT);
		calSizeAndPos(IMAGE_CENTER_X, IMAGE_CENTER_Y);

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

	public void clear()
	{
		// TODO Auto-generated method stub
		getGraphics().clearRect(0, 0, canvasWidth, canvasHeight);
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(displayImage, 0, 0, canvasWidth, canvasHeight, null);

	}

	/**
	 * 计算ratio
	 * */
	public void calRatio(int maxWidth, int maxHeight)
	{
		float ratioX = 1, ratioY = 1;

		if (displayImage.getWidth() > maxWidth)
		{
			ratioX = maxWidth * 1.0f / displayImage.getWidth();
		}

		if (displayImage.getHeight() > maxHeight)
		{
			ratioY = maxHeight * 1.0f / displayImage.getHeight();
		}

		ratio = ratioX < ratioY ? ratioX : ratioY;

	}

	/**
	 * 重新计算图片绘制的位置和大小
	 * */
	public void calSizeAndPos(int centerX, int centerY)
	{
		canvasWidth = (int) (displayImage.getWidth() * ratio);
		canvasHeight = (int) (displayImage.getHeight() * ratio);

		x = centerX - canvasWidth / 2;
		y = centerY - canvasHeight / 2;

		setBounds(x, y, canvasWidth, canvasHeight);
		repaint();
	}

}
