package gui.compare;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CompareFrame extends JFrame implements ActionListener
{
	//ͼ��Ա����
	private CompareImagePanel compareImagePanel;

	//��ֱ��ť
	private JButton verticalButton;
	
	//ˮƽ��ť
	private JButton horizontalButton;

	//Դͼ��
	private BufferedImage sourceImage;
	
	//��ʾͼ��
	private BufferedImage displayImage;

	public CompareFrame(BufferedImage sourceImage, BufferedImage displayImage)
	{

		this.setLayout(null);
		this.sourceImage = sourceImage;
		this.displayImage = displayImage;

		this.initLayoutType();
		this.initButtons();
		this.initCompareImagePanel();

		this.setSize(CompareSetting.FRAME_WIDTH, CompareSetting.FRAME_HEIGHT);
		this.setVisible(true);

	}

	/**
	 * ����Ĭ�ϵĲ�������
	 * */
	private void initLayoutType()
	{
		CompareSetting.setLayoutType(sourceImage.getWidth(), sourceImage.getHeight());
	}

	/**
	 * ��ʼ���Ƚ����
	 * 
	 * @param sourceImage
	 * @param displayImage
	 * */
	private void initCompareImagePanel()
	{
		compareImagePanel = new CompareImagePanel(sourceImage, displayImage);
		getContentPane().add(compareImagePanel);
		compareImagePanel.repaint();
	}

	/**
	 * ��ʼ����ֱ��ˮƽ��ť
	 * */
	private void initButtons()
	{
		// TODO Auto-generated method stub
		verticalButton = new JButton("��ֱ");
		verticalButton.setBounds(CompareSetting.VERTICAL_BUTTON_TRCTANGLE);
		verticalButton.addActionListener(this);

		horizontalButton = new JButton("ˮƽ");
		horizontalButton.setBounds(CompareSetting.HOZRIONTAL_BUTTON_RECTANGLE);
		horizontalButton.addActionListener(this);

		getContentPane().add(verticalButton);
		getContentPane().add(horizontalButton);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == verticalButton)
		{
			switchToVertical();
		}
		else
		{
			switchToHorizontal();
		}

	}

	/**
	 * �л�����ֱ
	 * */
	private void switchToVertical()
	{
		CompareSetting.layoutType = CompareSetting.TYPE_VETTICAL;
		compareImagePanel.updateImagePanel();
	}

	/**
	 * �л���ˮƽ
	 * */
	private void switchToHorizontal()
	{
		CompareSetting.layoutType = CompareSetting.TYPE_HORIZONTAL;
		compareImagePanel.updateImagePanel();
	}

}
