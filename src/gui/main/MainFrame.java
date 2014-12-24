package gui.main;

import gui.ImagePanel;
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
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import util.ImgUtil;
import algorithm.basic.Clone;
import algorithm.basic.SaturationAndHue;
import algorithm.basic.Scale;

public class MainFrame extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// 源图像
	public BufferedImage		sourceImage;

	// 缩小的预览图
	public BufferedImage		previewImage;

	// 预览面板
	PreviewTabbedPanel			previewTabbedPanel;

	// 主图像显示面板
	public ImagePanel			imagePanel;

	// 基础调节面板
	public BasicAdjustPanel		adjustPanel;

	// 按钮面板
	public MainButtonPanel		mainButtonPanel;

	// 源图像路径
	public String				sourceImagePath;

	// 背景虚化界面
	public BlurFrame			blurFrame;

	// 拼图界面
	public JigsawFrame			jigsawFrame;

	// 魔镜界面
	public MagicMirrorFrame		magicMirrorFrame;

	// 局部彩色界面
	public PartColorFrame		partColorFrame;

	// 局部马赛克界面
	public PartMosaicFrame		partMosaicFrame;

	// 打开按钮
	private JButton				openButton;

	// 保存按钮
	private JButton				saveButton;

	// 取消按钮
	private JButton				cancelButton;

	// 对比按钮
	private JButton				compareButton;

	private static MainFrame	instance;

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
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e)
		{
		}

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
		initButtonPanel();
		initBasicAdjustPanel();
		initSaveButton();
		initCancelButton();
		initCompareButton();

		File file = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\sand.jpg");
		loadImage(file);

		// partMosaicFrame = new PartMosaicFrame(sourceImage);
		// partColorFrame = new PartColorFrame(sourceImage);
		// magicMirrorFrame = new MagicMirrorFrame(sourceImage);
		// jigsawFrame = new JigsawFrame(sourceImage);
		// blurFrame = new BlurFrame(sourceImage);
	}

	/**
	 * 初始化按钮面板
	 * */
	private void initButtonPanel()
	{
		mainButtonPanel = new MainButtonPanel();
		getContentPane().add(mainButtonPanel);
	}

	/**
	 * 初始化基础调整面板
	 * */
	private void initBasicAdjustPanel()
	{
		adjustPanel = new BasicAdjustPanel();
		getContentPane().add(adjustPanel);

	}

	/**
	 * 初始化对比面板
	 * */
	private void initCompareFrame()
	{
		new CompareFrame(sourceImage, imagePanel.getDisplayImage());
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
		fileChooser.setFileFilter(new FileNameExtensionFilter("图像", "jpg", "png", "jpeg", "bmp"));

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
			previewImage = Scale.getImage(sourceImage, 100, 100);

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
			sourceImage = Clone.getImage(imagePanel.getDisplayImage());
			ImageIO.write(sourceImage, "JPG", file);
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
	 * 设置显示的图像
	 * 
	 * @param displayImage
	 * */
	public void setDisplayImage(BufferedImage displayImage)
	{
		imagePanel.updateImage(displayImage);

	}

	/**
	 * 获取显示的图像
	 * */
	public BufferedImage getDisplayImage()
	{
		return imagePanel.getDisplayImage();
	}

	/**
	 * 获取图像面板
	 * */
	public ImagePanel getImagePanel()
	{
		return imagePanel;
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
		if (imagePanel != null)
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

		if (previewTabbedPanel != null)
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
		else if (e.getSource() == saveButton)
		{
			initSaveFileChooser();
		}
		else if (e.getSource() == compareButton)
		{
			initCompareFrame();
		}
		else
		{

		}
	}

}
