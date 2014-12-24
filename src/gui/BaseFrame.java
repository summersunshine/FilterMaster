package gui;

import gui.main.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BaseFrame extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// 保存按钮
	private JButton				saveButton;

	// 取消按钮
	private JButton				cancelButton;

	public BaseFrame()
	{
		this.initBounds();
		// this.setSize(1280, 720);
		this.setLayout(null);
		initSaveButton();
		initCancelButton();
	}

	private void initBounds()
	{
		this.setBounds(MainFrame.getInstance().getBounds());
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

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub

		if (e.getSource() == saveButton)
		{
			saveOperation();
		}

		if (e.getSource() == cancelButton)
		{
			cancelOperation();
		}

	}

	protected void saveOperation()
	{
		// TODO Auto-generated method stub
		this.dispose();
	}

	protected void cancelOperation()
	{
		// TODO Auto-generated method stub
		this.dispose();
	}

	// // 源图像的路径
	// protected String sourceImagePath;
	// // 源图像
	// protected BufferedImage sourceImage;
	// // 现实图像
	// protected BufferedImage displayImage;
	//
	// public BaseFrame()
	// {
	// initOpenButton();
	//
	// this.setSize(Global.SCREEN_WDITH, Global.SCREEN_HEIGHT);
	// this.setLayout(null);
	// this.setVisible(true);
	//
	// }
	//
	// /**
	// * 初始化打开按钮
	// * */
	// private void initOpenButton()
	// {
	// JButton openButton = new JButton();
	// openButton.setSize(100, 30);
	// openButton.setText("打开");
	// openButton.addActionListener(new ActionListener()
	// {
	//
	// @Override
	// public void actionPerformed(ActionEvent e)
	// {
	// // TODO Auto-generated method stub
	// initFileChooser();
	// }
	// });
	// getContentPane().add(openButton);
	// }
	//
	// /**
	// * 初始化文件选择器
	// * */
	// private void initFileChooser()
	// {
	// File desktop = new File(System.getProperty("user.home") +
	// System.getProperty("file.separator") + "桌面");
	// JFileChooser fileChooser = new JFileChooser(desktop);
	// fileChooser.setFileFilter(new FileNameExtensionFilter("图像", "jpg",
	// "png"));
	//
	// int option = fileChooser.showOpenDialog(null);
	// if (JFileChooser.APPROVE_OPTION == option)
	// {
	// loadImage(fileChooser.getSelectedFile());
	// }
	//
	// }
	//
	// /**
	// * 载入图像
	// *
	// * @param currFile
	// * */
	// private void loadImage(File currFile)
	// {
	// sourceImagePath = currFile.getAbsolutePath();
	// sourceImage = ImgUtil.getImg(sourceImagePath);
	//
	// if (sourceImage != null)
	// {
	// afterLoadImage();
	// }
	// }
	//
	// /**
	// * 在载入图像之后要做的事情
	// * */
	// protected void afterLoadImage()
	// {
	//
	// }

}
