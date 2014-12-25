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

	// ԭʼͼ��
	public BufferedImage			sourceImage;

	// �������
	private ScrawlAdjustPanel		adjustPanel;

	// ��ɫѡ�����
	private ScrawlColorSelectPanel	colorSelectPanel;

	// ͼ����ʾ���
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
	 * ��ʼ���������
	 * */
	private void initAdjustPanel()
	{
		// TODO Auto-generated method stub
		adjustPanel = new ScrawlAdjustPanel(this);

		getContentPane().add(adjustPanel);
	}

	/**
	 * ��ʼ��ͼ�����
	 * */
	private void initImagePanel()
	{
		// TODO Auto-generated method stub
		imagePanel = new ScrawlImagePanel(sourceImage);

		getContentPane().add(imagePanel);
	}

	/**
	 * ��ʼ����ɫѡ�����
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
