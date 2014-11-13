package gui;

import gui.blur.BlurFrame;
import gui.compare.CompareFrame;
import gui.jigsaw.JigsawFrame;
import gui.magicmirror.MagicMirrorFrame;
import gui.partcolor.PartColorFrame;
import gui.partmosaic.PartMosaicFrame;
import gui.preview.PreviewTabbedPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import util.ImgUtil;
import algorithm.basic.SaturationAndHue;
import algorithm.basic.Scale;
import algorithm.basic.Clone;

public class MainFrame extends JFrame implements ActionListener
{

	// 显示的图像
	public BufferedImage displayImage;

	// 源图像
	public BufferedImage sourceImage;

	// 缩小的预览图
	public BufferedImage previewImage;

	//预览面板
	PreviewTabbedPanel previewTabbedPanel;
	
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

	// 打开按钮
	private JButton openButton;

	// 保存按钮
	private JButton saveButton;

	// 取消按钮
	private JButton cancelButton;

	//对比按钮
	private JButton compareButton;
	
	// 背景模糊按钮
	private JButton blurButton;

	// 拼图按钮
	private JButton jigsawButton;

	// 魔镜按钮
	private JButton magicMirrorButton;

	// 局部彩色按钮
	private JButton partColorButton;

	// 马赛克按钮
	private JButton partMosaicButton;

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
		initBlurButton();
		initJigsawButton();
		initMagicMirrorButton();
		initPartColorButton();
		initPartMosaicButton();
		initSaveButton();
		initCancelButton();
		initCompareButton();
		
		
		initBasicAdjustPanel();

		File file = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\sand.jpg");
		loadImage(file);

		// partMosaicFrame = new PartMosaicFrame(sourceImage);
		// partColorFrame = new PartColorFrame(sourceImage);
		// magicMirrorFrame = new MagicMirrorFrame(sourceImage);
		// jigsawFrame = new JigsawFrame(sourceImage);
		// blurFrame = new BlurFrame(sourceImage);
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
		openButton = new JButton();
		openButton.setSize(100, 30);
		openButton.setText("打开");
		openButton.addActionListener(this);
		getContentPane().add(openButton);
	}




	
	/**
	 * 初始化背景虚幻按钮
	 * */
	private void initBlurButton()
	{
		blurButton = new JButton();
		blurButton.setSize(100, 30);
		blurButton.setLocation(150, 0);
		blurButton.setText("背景虚化");
		blurButton.addActionListener(this);
		getContentPane().add(blurButton);
	}

	/**
	 * 初始化拼图按钮
	 * */
	private void initJigsawButton()
	{
		jigsawButton = new JButton();
		jigsawButton.setSize(100, 30);
		jigsawButton.setLocation(300, 0);
		jigsawButton.setText("背景拼图");
		jigsawButton.addActionListener(this);
		getContentPane().add(jigsawButton);
	}

	/**
	 * 初始化魔镜按钮
	 * */
	private void initMagicMirrorButton()
	{
		magicMirrorButton = new JButton();
		magicMirrorButton.setSize(100, 30);
		magicMirrorButton.setLocation(450, 0);
		magicMirrorButton.setText("魔镜");
		magicMirrorButton.addActionListener(this);
		getContentPane().add(magicMirrorButton);
	}

	/**
	 * 初始化局部彩色按钮
	 * */
	private void initPartColorButton()
	{
		partColorButton = new JButton();
		partColorButton.setSize(100, 30);
		partColorButton.setLocation(600, 0);
		partColorButton.setText("局部彩色");
		partColorButton.addActionListener(this);
		getContentPane().add(partColorButton);
	}

	/**
	 * 初始化局部马赛克按钮
	 * */
	private void initPartMosaicButton()
	{
		partMosaicButton = new JButton();
		partMosaicButton.setSize(100, 30);
		partMosaicButton.setLocation(750, 0);
		partMosaicButton.setText("局部马赛克");
		partMosaicButton.addActionListener(this);
		getContentPane().add(partMosaicButton);
	}

	/**
	 * 初始化保存按钮
	 * */
	private void initSaveButton()
	{
		// TODO Auto-generated method stub
		saveButton = new JButton("保存");
		saveButton.setBounds(410, 600, 100, 40);
		saveButton.addActionListener(this);

		this.add(saveButton);
	}

	/**
	 * 初始化取消按钮
	 * */
	private void initCancelButton()
	{
		// TODO Auto-generated method stub
		cancelButton = new JButton("取消");
		cancelButton.setBounds(750, 600, 100, 40);
		cancelButton.addActionListener(this);

		this.add(cancelButton);
	}

	/**
	 * 初始化对比按钮
	 * */
	private void initCompareButton()
	{
		compareButton = new JButton();
		compareButton.setBounds(850, 600, 100, 40);
		compareButton.setText("对比");
		compareButton.addActionListener(this);
		getContentPane().add(compareButton);
	}
	
	/**
	 * 初始化文件选择器
	 * */
	private void initOpenFileChooser()
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
	 * @param file
	 * */
	private void loadImage(File file)
	{
		sourceImagePath = file.getAbsolutePath();
		sourceImage = ImgUtil.getImg(sourceImagePath);

		if (sourceImage != null)
		{

			SaturationAndHue.getImage(sourceImage, 0, 0);
			displayImage = Clone.getImage(sourceImage);
			previewImage = Scale.getImage(sourceImage, 140, 96);

			setPreviewImages();
			setImagePanel();

		}
	}

	/**
	 * 初始化保存的文件选择器
	 * */
	private void initSaveFileChooser()
	{
		File desktop = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "桌面");
		JFileChooser fileChooser = new JFileChooser(desktop);
		fileChooser.setFileFilter(new FileNameExtensionFilter("图像", "jpg", "png"));

		int option = fileChooser.showSaveDialog(null);
		if (JFileChooser.APPROVE_OPTION == option)
		{
			try
			{
				saveImage(fileChooser.getSelectedFile());
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 保存图像
	 * 
	 * @param image
	 * @param currFile
	 * @throws IOException
	 * */
	private void saveImage(File file) throws IOException
	{
		file = getLegalFile(file);

		// 创建输出流
		try
		{
			if (!file.exists())
			{
				file.createNewFile();
			}
			sourceImage = Clone.getImage(displayImage);
			ImageIO.write(displayImage, "JPG", file);
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 获取合法的路径
	 * */
	private File getLegalFile(File file)
	{
		String name = file.getName().toLowerCase();
		
		if (!name.endsWith("jpg") || !name.endsWith("png") || !name.endsWith("bmp"))
		{
			String path = file.getAbsolutePath();
			file = new File(path + ".jpg");
			
			for (int i = 0; file.exists(); i++)
			{
				file = new File(path + "(" + i + ").jpg");
			}
		}
		
		return file;
	}

	/**
	 * 设置主图像面板
	 * 
	 * @param type
	 * @param parameter
	 * */
	public void setImagePanel(int type, Object... parameter)
	{
		imagePanel.updateImage(type, parameter);
	}

	
	/***/
	public void setImagePanel(BufferedImage image)
	{
		imagePanel.updateImage(image);
	}
	
	/**
	 * 设置住图像面板
	 * */
	private void setImagePanel()
	{
		if (imagePanel!=null)
		{
			imagePanel.clear();
			getContentPane().remove(imagePanel);
		}
		
		imagePanel = new ImagePanel(sourceImage);
		getContentPane().add(imagePanel);
		imagePanel.repaint();

	}

	/**
	 * 设置预览面板
	 * */
	public void setPreviewImages()
	{

		if (previewTabbedPanel!=null)
		{
			getContentPane().remove(previewTabbedPanel);
		}
		previewTabbedPanel = new PreviewTabbedPanel(previewImage);
		getContentPane().add(previewTabbedPanel);
		previewTabbedPanel.repaint();
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == openButton)
		{
			initOpenFileChooser();
		}
		else if (e.getSource() == blurButton)
		{
			blurFrame = new BlurFrame(sourceImage);
		}
		else if (e.getSource() == jigsawButton)
		{
			jigsawFrame = new JigsawFrame(sourceImage);
		}
		else if (e.getSource() == magicMirrorButton)
		{
			magicMirrorFrame = new MagicMirrorFrame(sourceImage);
		}
		else if (e.getSource() == partColorButton)
		{
			partColorFrame = new PartColorFrame(sourceImage);
		}
		else if (e.getSource() == partMosaicButton)
		{
			partMosaicFrame = new PartMosaicFrame(sourceImage);
		}
		else if (e.getSource() == saveButton)
		{
			initSaveFileChooser();
		}
		else if (e.getSource() == compareButton)
		{
			CompareFrame compareFrame = new CompareFrame(sourceImage, imagePanel.getDisplayImage());
		}
		else
		{

		}
	}

}
