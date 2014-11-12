package gui.blur;

import gui.BaseFrame;
import gui.MainFrame;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import algorithm.Constants;

public class BlurFrame extends BaseFrame
{
	// ԭʼͼ��
	public BufferedImage sourceImage;

	// ģ��ͼ�����
	public BlurImagePanel imagePanel;

	// �����������
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
	 * ��ʼ���������
	 * */
	private void initAdjustPanel()
	{
		adjustPanel = new BlurAdjustPanel(this);

		getContentPane().add(adjustPanel);

	}

	/**
	 * ��ʼ��ͼ�����
	 * */
	private void initImagePanel()
	{
		imagePanel = new BlurImagePanel(sourceImage);

		getContentPane().add(imagePanel);
	}
	
	
	/**
	 * ����ͼ�����
	 */
	public void setImagePanel()
	{
		System.out.println("update image" + BlurSetting.levelValue);
		imagePanel.updateImage(BlurSetting.levelValue);
	}
	

}
