package gui;

import gui.backgroundblur.BackgroundBlurFrame;
import gui.preview.PreviewListPanel;
import gui.preview.PreviewPanel;
import gui.preview.PreviewTabbedPanel;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

import util.ImgUtil;
import algorithm.Constants;
import algorithm.ImageFactory;
import algorithm.basic.Scale;
import algorithm.fun.MagicMirror;

public class MainFrame extends JFrame
{

	
	//��ʾ��ͼ��
	public  BufferedImage displayImage;
	
	//Դͼ��
	public  BufferedImage sourceImage;
	
	//��С��Ԥ��ͼ
	public  BufferedImage previewImage;
	
	//������
	//public static JFrame mainFrame;
	
	//��ͼ����ʾ���
	public MainImagePanel mainImagePanel;
	
	//Դͼ��·��
	public String sourceImagePath;
	
	//
	public BackgroundBlurFrame backgroundBlurFrame;
	
	
	private static MainFrame instance;
	
	public static MainFrame getInstance()
	{
		if (instance == null)
		{
			instance = new MainFrame();
		}
		return instance;
	}
	
	
	public static void main(String args[])
	{
		MainFrame.getInstance();
	}
	
	public MainFrame()
	{
		this.setSize(1280, 720);
		this.setVisible(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		initOpenButton();
		initBackgroundBlurButton();
		initBasicAdjustPanel();

	}
	


	/**
	 * ��ʼ�������������
	 * */
	private void initBasicAdjustPanel()
	{
		getContentPane().add(BasicAdjustPanel.getInstance());
		
	}

	
	/**
	 * ��ʼ���򿪰�ť
	 * */
	private void initOpenButton()
	{
		JButton openButton = new JButton();
		openButton.setSize(100, 30);
		openButton.setText("��");
		openButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				initFileChooser();
			}
		});
		getContentPane().add(openButton);
	}

	
	/**
	 * ��ʼ��������ð�ť
	 * */
	private void initBackgroundBlurButton()
	{
		JButton backgroundButton = new JButton();
		backgroundButton.setSize(100, 30);
		backgroundButton.setLocation(150, 0);
		backgroundButton.setText("�������");
		backgroundButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				backgroundBlurFrame = new BackgroundBlurFrame(sourceImage);
			}
		});
		getContentPane().add(backgroundButton);
	}
	
	
	/**
	 * ��ʼ���ļ�ѡ����
	 * */
	private void initFileChooser()
	{
		File desktop = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "����");
		JFileChooser fileChooser = new JFileChooser(desktop);
		fileChooser.setFileFilter(new FileNameExtensionFilter("ͼ��", "jpg", "png"));

		int option = fileChooser.showOpenDialog(null);
		if (JFileChooser.APPROVE_OPTION == option)
		{
			loadImage(fileChooser.getSelectedFile());
		}

	}
	
	
	/**
	 * ����ͼ��
	 * @param currFile
	 * */
	private void loadImage(File currFile)
	{
		sourceImagePath = currFile.getAbsolutePath();
		sourceImage = ImgUtil.getImg(sourceImagePath);
		
		if (sourceImage!=null)
		{

			displayImage = sourceImage;
			previewImage = Scale.getImage(sourceImage, 80, 100);
			
			setPreviewImages();
			setMainImagePanel();
			
		}
		
	}
	
	/**
	 * ������ͼ�����
	 * @param type
	 * @param parameter
	 * */
	public void setMainImagePanel(int type,Object... parameter)
	{

		BufferedImage image = ImageFactory.getImage(type, sourceImage,parameter);
		mainImagePanel.setImage(image);
		mainImagePanel.repaint();
		System.out.println("change to type" + type);
	}
	
	/**
	 * ����סͼ�����
	 * */
	private void setMainImagePanel()
	{
	
		mainImagePanel = new MainImagePanel(sourceImage);
		getContentPane().add(mainImagePanel);
		mainImagePanel.repaint();
	}
	
	/**
	 * ����Ԥ�����
	 * */
	public void setPreviewImages()
	{
		
//		for (int i = 0; i < Constants.TYPE_ALPA_LIST.length; i++)
//		{
//			PreviewPanel previewPanel = new PreviewPanel(Constants.TYPE_ALPA_LIST[i],previewImage);
//			previewPanel.setLocation(900 + (i%2)*100, (i/2)*100);
//			getContentPane().add(previewPanel);
//			previewPanel.repaint();
//		}
		
		//PreviewListPanel artPanel = new PreviewListPanel(previewImage, Constants.TYPE_ART);
		
		PreviewTabbedPanel previewTabbedPanel =  new PreviewTabbedPanel(previewImage);
		previewTabbedPanel.setLocation(1080,0);
		getContentPane().add(previewTabbedPanel);
		setVisible(true);
		//previewTabbedPanel.repaint();
		
	}
	
	
	


}
