package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import util.ImgUtil;
import app.Global;

public class BaseFrame extends JFrame
{

	// 源图像的路径
	protected String sourceImagePath;
	// 源图像
	protected BufferedImage sourceImage;
	// 现实图像
	protected BufferedImage displayImage;

	public BaseFrame()
	{
		initOpenButton();

		this.setSize(Global.SCREEN_WDITH, Global.SCREEN_HEIGHT);
		this.setLayout(null);
		this.setVisible(true);

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
			afterLoadImage();
		}
	}

	/**
	 * 在载入图像之后要做的事情
	 * */
	protected void afterLoadImage()
	{

	}

}
