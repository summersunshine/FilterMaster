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

	// Դͼ��
	public BufferedImage		sourceImage;

	// ��С��Ԥ��ͼ
	public BufferedImage		previewImage;

	// Ԥ�����
	PreviewTabbedPanel			previewTabbedPanel;

	// ��ͼ����ʾ���
	public ImagePanel			imagePanel;

	// �����������
	public BasicAdjustPanel		adjustPanel;

	// ��ť���
	public MainButtonPanel		mainButtonPanel;

	// Դͼ��·��
	public String				sourceImagePath;

	// �����黯����
	public BlurFrame			blurFrame;

	// ƴͼ����
	public JigsawFrame			jigsawFrame;

	// ħ������
	public MagicMirrorFrame		magicMirrorFrame;

	// �ֲ���ɫ����
	public PartColorFrame		partColorFrame;

	// �ֲ������˽���
	public PartMosaicFrame		partMosaicFrame;

	// �򿪰�ť
	private JButton				openButton;

	// ���水ť
	private JButton				saveButton;

	// ȡ����ť
	private JButton				cancelButton;

	// �ԱȰ�ť
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
	 * ��ʼ����ť���
	 * */
	private void initButtonPanel()
	{
		mainButtonPanel = new MainButtonPanel();
		getContentPane().add(mainButtonPanel);
	}

	/**
	 * ��ʼ�������������
	 * */
	private void initBasicAdjustPanel()
	{
		adjustPanel = new BasicAdjustPanel();
		getContentPane().add(adjustPanel);

	}

	/**
	 * ��ʼ���Ա����
	 * */
	private void initCompareFrame()
	{
		new CompareFrame(sourceImage, imagePanel.getDisplayImage());
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
	 * ��ʼ�����水ť
	 * */
	private void initSaveButton()
	{
		// TODO Auto-generated method stub
		saveButton = new JButton("����");
		saveButton.setBounds(410, 600, 100, 40);
		saveButton.addActionListener(this);

		this.add(saveButton);
	}

	/**
	 * ��ʼ��ȡ����ť
	 * */
	private void initCancelButton()
	{
		// TODO Auto-generated method stub
		cancelButton = new JButton("ȡ��");
		cancelButton.setBounds(750, 600, 100, 40);
		cancelButton.addActionListener(this);

		this.add(cancelButton);
	}

	/**
	 * ��ʼ���ԱȰ�ť
	 * */
	private void initCompareButton()
	{
		compareButton = new JButton();
		compareButton.setBounds(850, 600, 100, 40);
		compareButton.setText("�Ա�");
		compareButton.addActionListener(this);
		getContentPane().add(compareButton);
	}

	/**
	 * ��ʼ���ļ�ѡ����
	 * */
	private void initOpenFileChooser()
	{
		File desktop = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "����");
		JFileChooser fileChooser = new JFileChooser(desktop);
		fileChooser.setFileFilter(new FileNameExtensionFilter("ͼ��", "jpg", "png", "jpeg", "bmp"));

		int option = fileChooser.showOpenDialog(null);
		if (JFileChooser.APPROVE_OPTION == option)
		{
			loadImage(fileChooser.getSelectedFile());
		}

	}

	/**
	 * ����ͼ��
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
	 * ��ʼ��������ļ�ѡ����
	 * */
	private void initSaveFileChooser()
	{
		File desktop = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "����");
		JFileChooser fileChooser = new JFileChooser(desktop);
		fileChooser.setFileFilter(new FileNameExtensionFilter("ͼ��", "jpg", "png"));

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
	 * ����ͼ��
	 * 
	 * @param image
	 * @param currFile
	 * @throws IOException
	 * */
	private void saveImage(File file) throws IOException
	{
		file = getLegalFile(file);

		// ���������
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
	 * ��ȡ�Ϸ���·��
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
	 * ������ʾ��ͼ��
	 * 
	 * @param displayImage
	 * */
	public void setDisplayImage(BufferedImage displayImage)
	{
		imagePanel.updateImage(displayImage);

	}

	/**
	 * ��ȡ��ʾ��ͼ��
	 * */
	public BufferedImage getDisplayImage()
	{
		return imagePanel.getDisplayImage();
	}

	/**
	 * ��ȡͼ�����
	 * */
	public ImagePanel getImagePanel()
	{
		return imagePanel;
	}

	/**
	 * ������ͼ�����
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
	 * ����סͼ�����
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
	 * ����Ԥ�����
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
