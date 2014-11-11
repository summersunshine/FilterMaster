package gui.magicmirror;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class MagicMirrorFrame extends JFrame
{

	// Դͼ��
	private BufferedImage sourceImage;

	// ħ���������
	private MagicMirrorAdjustPanel magicMirrorAdjustPanel;

	// ħ��ͼ�����
	private MagicMirrorImagePanel magicMirrorImagePanel;

	public MagicMirrorFrame(BufferedImage image)
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
		magicMirrorAdjustPanel = new MagicMirrorAdjustPanel(this);

		getContentPane().add(magicMirrorAdjustPanel);

		magicMirrorAdjustPanel.repaint();
	}

	/**
	 * ��ʼ��ͼ�����
	 * */
	private void initImagePanel()
	{
		magicMirrorImagePanel = new MagicMirrorImagePanel(sourceImage);

		getContentPane().add(magicMirrorImagePanel);

		magicMirrorImagePanel.repaint();
	}

	/**
	 * ����ͼ�����
	 * */
	public void setImagePanel(float radius, int type)
	{
		// TODO Auto-generated method stub
		magicMirrorImagePanel.updateImage(type, radius);
	}
}
