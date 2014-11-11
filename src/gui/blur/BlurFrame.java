package gui.blur;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class BlurFrame extends JFrame
{
	// ���ʵĴ�С
	public static int sizeValue = 40;

	// ģ��������
	public static int levelValue = 40;

	// ԭʼͼ��
	public BufferedImage sourceImage;

	// ģ��ͼ�����
	public BlurImagePanel imagePanel;

	// �����������
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
	 * ��ʼ���������
	 * */
	private void initAdjustPanel()
	{
		adjustPanel = new BlurAdjustPanel();

		getContentPane().add(adjustPanel);

	}

	/**
	 * ��ʼ��ͼ�����
	 * */
	private void initImagePanel()
	{
		imagePanel = new BlurImagePanel(sourceImage);

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
