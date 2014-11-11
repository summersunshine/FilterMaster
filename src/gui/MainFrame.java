package gui;

import gui.blur.BlurFrame;
import gui.jigsaw.JigsawFrame;
import gui.magicmirror.MagicMirrorFrame;
import gui.partcolor.PartColorFrame;
import gui.partmosaic.PartMosaicFrame;
import gui.preview.PreviewTabbedPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import util.ImgUtil;
import algorithm.basic.Scale;

public class MainFrame extends JFrame
{

	// ��ʾ��ͼ��
	public BufferedImage displayImage;

	// Դͼ��
	public BufferedImage sourceImage;

	// ��С��Ԥ��ͼ
	public BufferedImage previewImage;

	// ������
	// public static JFrame mainFrame;

	// ��ͼ����ʾ���
	public ImagePanel imagePanel;

	// Դͼ��·��
	public String sourceImagePath;

	// �����黯����
	public BlurFrame blurFrame;

	// ƴͼ����
	public JigsawFrame jigsawFrame;

	// ħ������
	public MagicMirrorFrame magicMirrorFrame;

	// �ֲ���ɫ����
	public PartColorFrame partColorFrame;

	// �ֲ������˽���
	public PartMosaicFrame partMosaicFrame;

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
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initOpenButton();
		initBackgroundBlurButton();
		initJigasawButton();
		initMagicMirrorButton();

		initBasicAdjustPanel();

		File file = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\sand.jpg");
		loadImage(file);

		partMosaicFrame = new PartMosaicFrame(sourceImage);
		// partColorFrame = new PartColorFrame(sourceImage);
		// magicMirrorFrame = new MagicMirrorFrame(sourceImage);
		// jigsawFrame = new JigsawFrame(sourceImage);
		// backgroundBlurFrame = new BackgroundBlurFrame(sourceImage);
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
		backgroundButton.setText("�����黯");
		backgroundButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				blurFrame = new BlurFrame(sourceImage);
			}
		});
		getContentPane().add(backgroundButton);
	}

	/**
	 * ��ʼ��ƴͼ��ť
	 * */
	private void initJigasawButton()
	{
		JButton jigasawButton = new JButton();
		jigasawButton.setSize(100, 30);
		jigasawButton.setLocation(300, 0);
		jigasawButton.setText("����ƴͼ");
		jigasawButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				// backgroundBlurFrame = new BackgroundBlurFrame(sourceImage);
				jigsawFrame = new JigsawFrame(sourceImage);
			}
		});
		getContentPane().add(jigasawButton);
	}

	/**
	 * ��ʼ��ħ����ť
	 * */
	private void initMagicMirrorButton()
	{
		JButton magicMirrorButton = new JButton();
		magicMirrorButton.setSize(100, 30);
		magicMirrorButton.setLocation(450, 0);
		magicMirrorButton.setText("ħ��");
		magicMirrorButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				// backgroundBlurFrame = new BackgroundBlurFrame(sourceImage);
				magicMirrorFrame = new MagicMirrorFrame(sourceImage);
			}
		});
		getContentPane().add(magicMirrorButton);
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
	 * 
	 * @param currFile
	 * */
	private void loadImage(File currFile)
	{
		sourceImagePath = currFile.getAbsolutePath();
		sourceImage = ImgUtil.getImg(sourceImagePath);

		if (sourceImage != null)
		{

			displayImage = sourceImage;
			previewImage = Scale.getImage(sourceImage, 140, 96);

			setPreviewImages();
			setMainImagePanel();

		}
	}

	/**
	 * ������ͼ�����
	 * 
	 * @param type
	 * @param parameter
	 * */
	public void setMainImagePanel(int type, Object... parameter)
	{
		imagePanel.updateImage(type, parameter);
	}

	/**
	 * ����סͼ�����
	 * */
	private void setMainImagePanel()
	{

		imagePanel = new ImagePanel(sourceImage);
		getContentPane().add(imagePanel);
		imagePanel.repaint();
	}

	/**
	 * ����Ԥ�����
	 * */
	public void setPreviewImages()
	{

		PreviewTabbedPanel previewTabbedPanel = new PreviewTabbedPanel(previewImage);
		getContentPane().add(previewTabbedPanel);
		setVisible(true);

	}

}
