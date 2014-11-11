package gui.partmosaic;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class PartMosaicFrame extends JFrame
{
	// ���ʵĴ�С
	public static int sizeValue = 40;

	// ģ��������
	public static int levelValue = 40;

	// ԭʼͼ��
	public BufferedImage sourceImage;

	// ģ��ͼ�����
	public PartMosaicImagePanel imagePanel;

	// �����������
	public PartMosaicAdjustPanel adjustPanel;

	public PartMosaicFrame(BufferedImage image)
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
		adjustPanel = new PartMosaicAdjustPanel();

		getContentPane().add(adjustPanel);

	}

	/**
	 * ��ʼ��ͼ�����
	 * */
	private void initImagePanel()
	{
		imagePanel = new PartMosaicImagePanel(sourceImage);

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
