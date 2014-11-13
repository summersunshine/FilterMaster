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

	// ��ʾ��ͼ��
	public BufferedImage displayImage;

	// Դͼ��
	public BufferedImage sourceImage;

	// ��С��Ԥ��ͼ
	public BufferedImage previewImage;

	//Ԥ�����
	PreviewTabbedPanel previewTabbedPanel;
	
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

	// �򿪰�ť
	private JButton openButton;

	// ���水ť
	private JButton saveButton;

	// ȡ����ť
	private JButton cancelButton;

	//�ԱȰ�ť
	private JButton compareButton;
	
	// ����ģ����ť
	private JButton blurButton;

	// ƴͼ��ť
	private JButton jigsawButton;

	// ħ����ť
	private JButton magicMirrorButton;

	// �ֲ���ɫ��ť
	private JButton partColorButton;

	// �����˰�ť
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
		openButton = new JButton();
		openButton.setSize(100, 30);
		openButton.setText("��");
		openButton.addActionListener(this);
		getContentPane().add(openButton);
	}




	
	/**
	 * ��ʼ��������ð�ť
	 * */
	private void initBlurButton()
	{
		blurButton = new JButton();
		blurButton.setSize(100, 30);
		blurButton.setLocation(150, 0);
		blurButton.setText("�����黯");
		blurButton.addActionListener(this);
		getContentPane().add(blurButton);
	}

	/**
	 * ��ʼ��ƴͼ��ť
	 * */
	private void initJigsawButton()
	{
		jigsawButton = new JButton();
		jigsawButton.setSize(100, 30);
		jigsawButton.setLocation(300, 0);
		jigsawButton.setText("����ƴͼ");
		jigsawButton.addActionListener(this);
		getContentPane().add(jigsawButton);
	}

	/**
	 * ��ʼ��ħ����ť
	 * */
	private void initMagicMirrorButton()
	{
		magicMirrorButton = new JButton();
		magicMirrorButton.setSize(100, 30);
		magicMirrorButton.setLocation(450, 0);
		magicMirrorButton.setText("ħ��");
		magicMirrorButton.addActionListener(this);
		getContentPane().add(magicMirrorButton);
	}

	/**
	 * ��ʼ���ֲ���ɫ��ť
	 * */
	private void initPartColorButton()
	{
		partColorButton = new JButton();
		partColorButton.setSize(100, 30);
		partColorButton.setLocation(600, 0);
		partColorButton.setText("�ֲ���ɫ");
		partColorButton.addActionListener(this);
		getContentPane().add(partColorButton);
	}

	/**
	 * ��ʼ���ֲ������˰�ť
	 * */
	private void initPartMosaicButton()
	{
		partMosaicButton = new JButton();
		partMosaicButton.setSize(100, 30);
		partMosaicButton.setLocation(750, 0);
		partMosaicButton.setText("�ֲ�������");
		partMosaicButton.addActionListener(this);
		getContentPane().add(partMosaicButton);
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
	 * ����Ԥ�����
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
