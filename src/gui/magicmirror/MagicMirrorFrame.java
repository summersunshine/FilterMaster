package gui.magicmirror;

import gui.BaseFrame;
import gui.MainFrame;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class MagicMirrorFrame extends BaseFrame
{

	// 源图像
	private BufferedImage sourceImage;

	// 魔镜调节面板
	private MagicMirrorAdjustPanel adjustPanel;

	// 魔镜图像面板
	private MagicMirrorImagePanel imagePanel;

	public MagicMirrorFrame(BufferedImage image)
	{	
		super();

		sourceImage = image;

		initAdjustPanel();
		initImagePanel();

		this.setVisible(true);
	}

	@Override
	protected void saveOperation()
	{
		// TODO Auto-generated method stub
		MainFrame.getInstance().setImagePanel(imagePanel.getDisplayImage());
		super.saveOperation();
	}

	@Override
	protected void cancelOperation()
	{
		// TODO Auto-generated method stub
		super.cancelOperation();
	}

	/**
	 * 初始化调整面板
	 * */
	private void initAdjustPanel()
	{
		adjustPanel = new MagicMirrorAdjustPanel(this);

		getContentPane().add(adjustPanel);

		adjustPanel.repaint();
	}

	/**
	 * 初始化图像面板
	 * */
	private void initImagePanel()
	{
		imagePanel = new MagicMirrorImagePanel(sourceImage);

		getContentPane().add(imagePanel);

		imagePanel.repaint();
	}

	/**
	 * 设置图像面板
	 * */
	public void setImagePanel()
	{
		// TODO Auto-generated method stub
		imagePanel.updateImage(MagicMirrorSetting.type, MagicMirrorSetting.radiusValue);
	}
}
