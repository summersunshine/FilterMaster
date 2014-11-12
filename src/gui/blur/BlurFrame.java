package gui.blur;

import gui.BaseFrame;
import gui.MainFrame;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import algorithm.Constants;

public class BlurFrame extends BaseFrame
{
	// 原始图像
	public BufferedImage sourceImage;

	// 模糊图像面板
	public BlurImagePanel imagePanel;

	// 调节数据面板
	public BlurAdjustPanel adjustPanel;

	public BlurFrame(BufferedImage image)
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
		adjustPanel = new BlurAdjustPanel(this);

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
	 * 更新图像面板
	 */
	public void setImagePanel()
	{
		System.out.println("update image" + BlurSetting.levelValue);
		imagePanel.updateImage(BlurSetting.levelValue);
	}
	

}
