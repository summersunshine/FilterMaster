package gui.partcolor;

import gui.BaseFrame;
import gui.main.MainFrame;

import java.awt.image.BufferedImage;

public class PartColorFrame extends BaseFrame
{

	/**
	 * 
	 */
	private static final long		serialVersionUID	= 1L;

	// 原始图像
	public BufferedImage			sourceImage;

	private PartColorAdjustPanel	adjustPanel;

	private PartColorImagePanel		imagePanel;

	public PartColorFrame(BufferedImage image)
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
		adjustPanel = new PartColorAdjustPanel(this);

		getContentPane().add(adjustPanel);

		adjustPanel.repaint();
	}

	/**
	 * 初始化图像面板
	 * */
	private void initImagePanel()
	{
		imagePanel = new PartColorImagePanel(sourceImage);

		getContentPane().add(imagePanel);

		imagePanel.repaint();
	}

	/**
	 * 设置图像面板
	 * */
	public void setImagePanel(float radius, int type)
	{
		// TODO Auto-generated method stub
		imagePanel.updateImage(type, radius);
	}
}
