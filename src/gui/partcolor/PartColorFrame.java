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
	
	// 原始图像
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
	 * 初始化调整面板
	 * */
	private void initAdjustPanel()
	{
		partColorAdjustPanel = new PartColorAdjustPanel(this);
		
		getContentPane().add(partColorAdjustPanel);
		
		partColorAdjustPanel.repaint();
	}
	
	
	/**
	 * 初始化图像面板
	 * */
	private void initImagePanel()
	{
		partColorImagePanel = new PartColorImagePanel(sourceImage);
		
		getContentPane().add(partColorImagePanel);
		
		partColorImagePanel.repaint();
	}
	
	/**
	 * 设置图像面板
	 * */
	public void setImagePanel(float radius,int type)
	{
		// TODO Auto-generated method stub
		partColorImagePanel.updateImage(type,radius);
	}
}
