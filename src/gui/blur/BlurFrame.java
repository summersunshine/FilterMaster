package gui.blur;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class BlurFrame extends JFrame
{
	// 画笔的大小
	public static int sizeValue = 40;

	// 模糊的力度
	public static int levelValue = 40;

	// 原始图像
	public BufferedImage sourceImage;

	// 模糊图像面板
	public BlurImagePanel imagePanel;

	// 调节数据面板
	public BlurAdjustPanel adjustPanel;

	public BlurFrame(BufferedImage image)
	{
		this.setSize(1280, 720);
		this.setLayout(null);

		sourceImage = image;

		initAdjustPanel();

		initImagePanel();

		this.setVisible(true);

	}

	/**
	 * 初始化调整面板
	 * */
	private void initAdjustPanel()
	{
		adjustPanel = new BlurAdjustPanel();

		getContentPane().add(adjustPanel);

	}

	/**
	 * 初始化图像面板
	 * */
	private void initImagePanel()
	{
		imagePanel = new BlurImagePanel(sourceImage);

		getContentPane().add(imagePanel);
	}

	/**
	 * 设置圆形的光标
	 * */
	public void setCircleCursor()
	{
		imagePanel.setCircleCursor();
	}

}
