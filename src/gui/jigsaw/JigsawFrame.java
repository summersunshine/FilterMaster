package gui.jigsaw;

import gui.base.BaseFrame;
import gui.main.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import util.image.ImageUtil;

public class JigsawFrame extends BaseFrame
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// ��һ��ͼƬ
	private BufferedImage		firstSourceImage;

	// �ڶ���ͼƬ
	private BufferedImage		secondSourceImage;

	// ��ʾͼƬ���
	private JigsawImagePanel	imagePanel;

	// ��ť��
	private JigsawButtonGroup	buttonGroup;

	private JButton				openButton;

	public JigsawFrame(BufferedImage image)
	{
		super();

		firstSourceImage = image;
		// setSecondSourceImage(image);

		initButtonGroup();
		initOpenButton();
		// initImagePanel();

		this.setVisible(true);

	}

	@Override
	protected void saveOperation()
	{
		// TODO Auto-generated method stub
		MainFrame.getInstance().setImagePanel(imagePanel.getDisplayImage());
		super.saveOperation();
	}

	@Override
	protected void cancelOperation()
	{
		// TODO Auto-generated method stub
		super.cancelOperation();
	}

	private void initImagePanel()
	{
		// TODO Auto-generated method stub
		imagePanel = new JigsawImagePanel(firstSourceImage, getSecondSourceImage());

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
	 * ��ʼ���򿪰�ť
	 * */
	private void initOpenButton()
	{
		openButton = new JButton();
		openButton.setSize(100, 30);
		openButton.setText("��");
		openButton.addActionListener(this);
		getContentPane().add(openButton);
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
		setSecondSourceImage(ImageUtil.getImage(currFile.getAbsolutePath()));

		if (getSecondSourceImage() != null)
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
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == openButton)
		{
			initFileChooser();
		}
		else
		{
			super.actionPerformed(e);
		}

	}

	public BufferedImage getSecondSourceImage()
	{
		return secondSourceImage;
	}

	public void setSecondSourceImage(BufferedImage secondSourceImage)
	{
		this.secondSourceImage = secondSourceImage;
	}

}
