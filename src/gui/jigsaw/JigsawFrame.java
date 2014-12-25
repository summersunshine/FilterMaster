package gui.jigsaw;

import gui.BaseFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import util.ImageUtil;

public class JigsawFrame extends BaseFrame implements ActionListener
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// 第一张图片
	private BufferedImage		firstSourceImage;

	// 第二张图片
	private BufferedImage		secondSourceImage;

	// 显示图片面板
	private JigsawImagePanel	imagePanel;

	// 按钮组
	private JigsawButtonGroup	buttonGroup;

	private JButton				openButton;

	public JigsawFrame(BufferedImage image)
	{
		super();

		firstSourceImage = image;
		secondSourceImage = image;

		initButtonGroup();
		initOpenButton();
		// initImagePanel();

		this.setVisible(true);

	}

	private void initImagePanel()
	{
		// TODO Auto-generated method stub
		imagePanel = new JigsawImagePanel(firstSourceImage, secondSourceImage);

		getContentPane().add(imagePanel);

		imagePanel.repaint();

	}

	private void initButtonGroup()
	{
		buttonGroup = new JigsawButtonGroup(this);

		getContentPane().add(buttonGroup);

		buttonGroup.repaint();
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
		secondSourceImage = ImageUtil.getImage(currFile.getAbsolutePath());

		if (secondSourceImage != null)
		{
			afterLoadImage();
		}
	}

	protected void afterLoadImage()
	{
		initImagePanel();

		initButtonGroup();

		this.setVisible(true);

		System.out.println("show image panel");
	}

	public void setImagePanel(int type)
	{
		// TODO Auto-generated method stub
		imagePanel.updateImage(type);
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub
		initFileChooser();
	}

}
