package gui.partmosaic;

import gui.BaseFrame;
import gui.main.MainFrame;

import java.awt.image.BufferedImage;

public class PartMosaicFrame extends BaseFrame
{

	/**
	 * 
	 */
	private static final long		serialVersionUID	= 1L;

	// 原始图像
	public BufferedImage			sourceImage;

	// 模糊图像面板
	public PartMosaicImagePanel		imagePanel;

	// 调节数据面板
	public PartMosaicAdjustPanel	adjustPanel;

	public PartMosaicFrame(BufferedImage image)
	{
		super();

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
		adjustPanel = new PartMosaicAdjustPanel();

		getContentPane().add(adjustPanel);

	}

	/**
	 * 初始化图像面板
	 * */
	private void initImagePanel()
	{
		imagePanel = new PartMosaicImagePanel(sourceImage);

		getContentPane().add(imagePanel);
	}

	/**
	 * 设置图像面板
	 * */
	public void setImagePanel()
	{
		// TODO Auto-generated method stub
		imagePanel.updateImage(PartMosaicSetting.patchValue);
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
	 * 设置圆形的光标
	 * */
	public void setCircleCursor()
	{
		imagePanel.setCircleCursor();
	}

}
