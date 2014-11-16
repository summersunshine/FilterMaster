package gui.partmosaic;

import gui.BaseFrame;
import gui.magicmirror.MagicMirrorSetting;
import gui.main.MainFrame;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class PartMosaicFrame extends BaseFrame
{

	// ԭʼͼ��
	public BufferedImage sourceImage;

	// ģ��ͼ�����
	public PartMosaicImagePanel imagePanel;

	// �����������
	public PartMosaicAdjustPanel adjustPanel;

	public PartMosaicFrame(BufferedImage image)
	{
		super();

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
		adjustPanel = new PartMosaicAdjustPanel();

		getContentPane().add(adjustPanel);

	}

	/**
	 * ��ʼ��ͼ�����
	 * */
	private void initImagePanel()
	{
		imagePanel = new PartMosaicImagePanel(sourceImage);

		getContentPane().add(imagePanel);
	}

	/**
	 * ����ͼ�����
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
	 * ����Բ�εĹ��
	 * */
	public void setCircleCursor()
	{
		imagePanel.setCircleCursor();
	}

}
