package gui.partcolor;

import gui.magicmirror.MagicMirrorAdjustPanel;
import gui.magicmirror.MagicMirrorImagePanel;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import algorithm.Constants;

public class PartColorFrame extends JFrame
{
	public static int type = Constants.TYPE_ERASE;
	
	public static int sizeValue = 40;
	
	// ԭʼͼ��
	public BufferedImage sourceImage;
	
	private PartColorAdjustPanel partColorAdjustPanel;
	
	private PartColorImagePanel partColorImagePanel;
	
	public PartColorFrame(BufferedImage image)
	{
		this.setSize(1280, 720);
		this.setLayout(null);
		
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
		partColorAdjustPanel = new PartColorAdjustPanel(this);
		
		getContentPane().add(partColorAdjustPanel);
		
		partColorAdjustPanel.repaint();
	}
	
	
	/**
	 * ��ʼ��ͼ�����
	 * */
	private void initImagePanel()
	{
		partColorImagePanel = new PartColorImagePanel(sourceImage);
		
		getContentPane().add(partColorImagePanel);
		
		partColorImagePanel.repaint();
	}
	
	/**
	 * ����ͼ�����
	 * */
	public void setImagePanel(float radius,int type)
	{
		// TODO Auto-generated method stub
		partColorImagePanel.updateImage(type,radius);
	}
}
