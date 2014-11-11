package gui.magicmirror;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class MagicMirrorFrame extends JFrame
{

	// 源图像
	private BufferedImage sourceImage;

	// 魔镜调节面板
	private MagicMirrorAdjustPanel magicMirrorAdjustPanel;

	// 魔镜图像面板
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
	 * 初始化调整面板
	 * */
	private void initAdjustPanel()
	{
		magicMirrorAdjustPanel = new MagicMirrorAdjustPanel(this);

		getContentPane().add(magicMirrorAdjustPanel);

		magicMirrorAdjustPanel.repaint();
	}

	/**
	 * 初始化图像面板
	 * */
	private void initImagePanel()
	{
		magicMirrorImagePanel = new MagicMirrorImagePanel(sourceImage);

		getContentPane().add(magicMirrorImagePanel);

		magicMirrorImagePanel.repaint();
	}

	/**
	 * 设置图像面板
	 * */
	public void setImagePanel(float radius, int type)
	{
		// TODO Auto-generated method stub
		magicMirrorImagePanel.updateImage(type, radius);
	}
}
