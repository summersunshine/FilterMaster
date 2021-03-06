package gui.magicmirror;

import gui.base.BaseFrame;
import gui.main.MainFrame;

import java.awt.image.BufferedImage;

public class MagicMirrorFrame extends BaseFrame
{

	/**
	 * 
	 */
	private static final long		serialVersionUID	= 1L;

	// Դͼ��
	private BufferedImage			sourceImage;

	// ħ���������
	private MagicMirrorAdjustPanel	adjustPanel;

	// ħ��ͼ�����
	private MagicMirrorImagePanel	imagePanel;

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
	 * ��ʼ���������
	 * */
	private void initAdjustPanel()
	{
		adjustPanel = new MagicMirrorAdjustPanel(this);

		getContentPane().add(adjustPanel);

		adjustPanel.repaint();
	}

	/**
	 * ��ʼ��ͼ�����
	 * */
	private void initImagePanel()
	{
		imagePanel = new MagicMirrorImagePanel(sourceImage);

		getContentPane().add(imagePanel);

		imagePanel.repaint();
	}

	/**
	 * ����ͼ�����
	 * */
	public void setImagePanel()
	{
		// TODO Auto-generated method stub
		imagePanel.updateImage(MagicMirrorSetting.type, MagicMirrorSetting.radiusValue);
	}
}
