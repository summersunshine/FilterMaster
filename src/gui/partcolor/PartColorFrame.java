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

	// ԭʼͼ��
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
	 * ��ʼ���������
	 * */
	private void initAdjustPanel()
	{
		adjustPanel = new PartColorAdjustPanel(this);

		getContentPane().add(adjustPanel);

		adjustPanel.repaint();
	}

	/**
	 * ��ʼ��ͼ�����
	 * */
	private void initImagePanel()
	{
		imagePanel = new PartColorImagePanel(sourceImage);

		getContentPane().add(imagePanel);

		imagePanel.repaint();
	}

	/**
	 * ����ͼ�����
	 * */
	public void setImagePanel(float radius, int type)
	{
		// TODO Auto-generated method stub
		imagePanel.updateImage(type, radius);
	}
}
