package gui.scrawl;

import gui.base.BaseFrame;
import gui.main.MainFrame;

import java.awt.image.BufferedImage;

import app.Global;

public class ScrawlFrame extends BaseFrame
{
	/**
	 * 
	 */
	private static final long		serialVersionUID	= 1L;

	// 原始图像
	public BufferedImage			sourceImage;

	// 调节面板
	private ScrawlAdjustPanel		adjustPanel;

	// 颜色选择面板
	private ScrawlColorSelectPanel	colorSelectPanel;

	// 图像显示面板
	private ScrawlImagePanel		imagePanel;

	public ScrawlFrame(BufferedImage image)
	{
		super();

		sourceImage = image;

		initColorSelectPanel();
		initAdjustPanel();
		initImagePanel();

		this.setSize(Global.SCREEN_WDITH, Global.SCREEN_HEIGHT);
		this.setVisible(true);

		// colorSelectPanel.paintComponent();
	}

	public void updateDrawingAlpha()
	{
		imagePanel.updateAlpha();

	}

	/**
	 * 初始化调节面板
	 * */
	private void initAdjustPanel()
	{
		// TODO Auto-generated method stub
		adjustPanel = new ScrawlAdjustPanel(this);

		getContentPane().add(adjustPanel);
	}

	/**
	 * 初始化图像面板
	 * */
	private void initImagePanel()
	{
		// TODO Auto-generated method stub
		imagePanel = new ScrawlImagePanel(sourceImage);

		getContentPane().add(imagePanel);
	}

	/**
	 * 初始化颜色选择面板
	 * */
	private void initColorSelectPanel()
	{
		// TODO Auto-generated method stub
		colorSelectPanel = new ScrawlColorSelectPanel(this);

		getContentPane().add(colorSelectPanel);

	}

	@Override
	protected void saveOperation()
	{
		// TODO Auto-generated method stub
		imagePanel.merge();

		MainFrame.getInstance().setImagePanel(imagePanel.getDisplayImage());

		super.saveOperation();
	}

	@Override
	protected void cancelOperation()
	{
		// TODO Auto-generated method stub
		super.cancelOperation();
	}

}
