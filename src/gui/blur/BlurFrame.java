package gui.blur;

import gui.base.BaseFrame;
import gui.main.MainFrame;

import java.awt.image.BufferedImage;

public class BlurFrame extends BaseFrame
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// ԭʼͼ��
	private BufferedImage		sourceImage;

	// ģ��ͼ�����
	private BlurImagePanel		imagePanel;

	// �л����
	private BlurTabbedPanel		tabbedPanel;

	public BlurFrame(BufferedImage image)
	{
		super();

		sourceImage = image;

		// initAdjustPanel();

		initTabbedPanel();

		initImagePanel();

		this.setVisible(true);
	}

	@Override
	protected void saveOperation()
	{
		// TODO Auto-generated method stub
		MainFrame.getInstance().setImagePanel(getImagePanel().getDisplayImage());
		super.saveOperation();
	}

	@Override
	protected void cancelOperation()
	{
		// TODO Auto-generated method stub
		super.cancelOperation();
	}

	// /**
	// * ��ʼ���������
	// * */
	// private void initAdjustPanel()
	// {
	// adjustPanel = new BlurAdjustPanel(this);
	//
	// getContentPane().add(adjustPanel);
	//
	// }

	/**
	 * ��ʼ���������
	 * */
	private void initTabbedPanel()
	{
		tabbedPanel = new BlurTabbedPanel(this);

		getContentPane().add(tabbedPanel);

	}

	/**
	 * ��ʼ��ͼ�����
	 * */
	private void initImagePanel()
	{
		setImagePanel(new BlurImagePanel(sourceImage));

		getContentPane().add(getImagePanel());
	}

	/**
	 * ����ͼ�����
	 */
	public void setImagePanel()
	{
		System.out.println("update image" + BlurSetting.levelValue);
		imagePanel.updateBlurLevel(BlurSetting.levelValue);
	}

	public BlurImagePanel getImagePanel()
	{
		return imagePanel;
	}

	public void setImagePanel(BlurImagePanel imagePanel)
	{
		this.imagePanel = imagePanel;
	}

}
