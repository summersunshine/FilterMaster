package gui.preview;

import gui.MainFrame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;

import algorithm.ImageFactory;

public class PreviewPanel extends JPanel implements MouseListener
{
	// ����Ԥ������
	public JLabel discribelLabel;

	// ��ʾ��ͼ��
	public BufferedImage displayImage;

	// �˾�����
	public int type;

	// ����
	public Object[] parameter;

	/**
	 * ���캯��
	 * 
	 * @param type
	 * @param sourceImage
	 * @param parameter
	 * */
	public PreviewPanel(int type, BufferedImage sourceImage, Object... parameter)
	{

		this.type = type;

		this.parameter = new Object[parameter.length];
		for (int i = 0; i < parameter.length; i++)
		{
			this.parameter[i] = parameter[i];
		}

		initDisplayImage(sourceImage);
		initDescribeLabel();

		this.addMouseListener(this);
		// this.setSize(80, 100);
		this.setVisible(true);

	}

	@Override
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		try
		{
			g2.drawImage(displayImage, 0, 0, displayImage.getWidth(), displayImage.getHeight(), null);
		} finally
		{
			g2.dispose();
		}
	}

	/**
	 * ��ʼ������label
	 * */
	private void initDescribeLabel()
	{
		// TODO Auto-generated method stub
		discribelLabel = new JLabel();
		discribelLabel.setText("" + type);
	}

	/**
	 * ��ʼ����ʾ��ͼ��
	 * */
	private void initDisplayImage(BufferedImage sourceImage)
	{
		// TODO Auto-generated method stub
		displayImage = ImageFactory.getImage(type, sourceImage, parameter);
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		MainFrame.getInstance().setMainImagePanel(type);
	}

}
