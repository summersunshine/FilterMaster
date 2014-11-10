package gui.backgroundblur;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import algorithm.blur.DoubleGuassBlur;

public class BackgroundBlurFrame extends JFrame
{
	// ���ʵĴ�С
	public static int sizeValue = 40;

	// ģ��������
	public static int levelValue = 40;

	// ԭʼͼ��
	public BufferedImage sourceImage;

	// ģ��ͼ�����
	public BackgroundBlurImagePanel imagePanel;

	// �����������
	public BackgroundAdjustPanel adjustPanel;

	public BackgroundBlurFrame(BufferedImage image)
	{
		this.setSize(1280, 720);
		this.setLayout(null);

		sourceImage = image;

		initAdjustPanel();

		initImagePanel();

		this.setVisible(true);

	}

	/**
	 * ��ʼ���������
	 * */
	private void initAdjustPanel()
	{
		adjustPanel = new BackgroundAdjustPanel();

		getContentPane().add(adjustPanel);

	}

	/**
	 * ��ʼ��ͼ�����
	 * */
	private void initImagePanel()
	{
		imagePanel = new BackgroundBlurImagePanel(sourceImage);

		getContentPane().add(imagePanel);
	}

	/**
	 * ����Բ�εĹ��
	 * */
	public void setCircleCursor()
	{
		imagePanel.setCircleCursor();
	}

}
