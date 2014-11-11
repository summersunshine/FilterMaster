package gui.blur;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import algorithm.Constants;

public class BlurFrame extends JFrame
{
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
