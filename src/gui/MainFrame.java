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

	// 显示的图像
	public BufferedImage displayImage;

	// 源图像
	public BufferedImage sourceImage;

	// 缩小的预览图
	public BufferedImage previewImage;

	// 主界面
	// public static JFrame mainFrame;

	// 主图像显示面板
	public ImagePanel imagePanel;

	// 源图像路径
	public String sourceImagePath;

	// 背景虚化界面
	public BlurFrame blurFrame;

	// 拼图界面
	public JigsawFrame jigsawFrame;

	// 魔镜界面
	public MagicMirrorFrame magicMirrorFrame;

	// 局部彩色界面
	public PartColorFrame partColorFrame;

	// 局部马赛克界面
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
	 * 初始化基础调整面板
	 * */
	private void initBasicAdjustPanel()
	{
		getContentPane().add(BasicAdjustPanel.getInstance());

	}

	/**
	 * 初始化打开按钮
	 * */
	private void initOpenButton()
	{
		JButton openButton = new JButton();
		openButton.setSize(100, 30);
		openButton.setText("打开");
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
	 * 初始化背景虚幻按钮
	 * */
	private void initBackgroundBlurButton()
	{
		JButton backgroundButton = new JButton();
		backgroundButton.setSize(100, 30);
		backgroundButton.setLocation(150, 0);
		backgroundButton.setText("背景虚化");
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
	 * 初始化拼图按钮
	 * */
	private void initJigasawButton()
	{
		JButton jigasawButton = new JButton();
		jigasawButton.setSize(100, 30);
		jigasawButton.setLocation(300, 0);
		jigasawButton.setText("背景拼图");
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
	 * 初始化魔镜按钮
	 * */
	private void initMagicMirrorButton()
	{
		JButton magicMirrorButton = new JButton();
		magicMirrorButton.setSize(100, 30);
		magicMirrorButton.setLocation(450, 0);
		magicMirrorButton.setText("魔镜");
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
	 * 初始化文件选择器
	 * */
	private void initFileChooser()
	{
		File desktop = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "桌面");
		JFileChooser fileChooser = new JFileChooser(desktop);
		fileChooser.setFileFilter(new FileNameExtensionFilter("图像", "jpg", "png"));

		int option = fileChooser.showOpenDialog(null);
		if (JFileChooser.APPROVE_OPTION == option)
		{
			loadImage(fileChooser.getSelectedFile());
		}

	}

	/**
	 * 载入图像
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
	 * 设置主图像面板
	 * 
	 * @param type
	 * @param parameter
	 * */
	public void setMainImagePanel(int type, Object... parameter)
	{
		imagePanel.updateImage(type, parameter);
	}

	/**
	 * 设置住图像面板
	 * */
	private void setMainImagePanel()
	{

		imagePanel = new ImagePanel(sourceImage);
		getContentPane().add(imagePanel);
		imagePanel.repaint();
	}

	/**
	 * 设置预览面板
	 * */
	public void setPreviewImages()
	{

		PreviewTabbedPanel previewTabbedPanel = new PreviewTabbedPanel(previewImage);
		getContentPane().add(previewTabbedPanel);
		setVisible(true);

	}

}
