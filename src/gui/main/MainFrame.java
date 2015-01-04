package gui.main;

import gui.base.BaseImagePanel;
import gui.compare.CompareFrame;
import gui.preview.PreviewTabbedPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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

import util.image.Clone;
import util.image.ImageUtil;
import util.image.SaturationAndHue;
import util.image.Scale;

public class MainFrame extends JFrame implements ActionListener, WindowListener
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// Դͼ��
	private BufferedImage		sourceImage;

	// ��С��Ԥ��ͼ
	private BufferedImage		previewImage;

	// Ԥ�����
	private PreviewTabbedPanel	previewTabbedPanel;

	// ��ͼ����ʾ���
	private BaseImagePanel		imagePanel;

	// �����������
	private BasicAdjustPanel	adjustPanel;

	// ��ť���
	private MainButtonPanel		mainButtonPanel;

	// Դͼ��·��
	private String				sourceImagePath;

	// �򿪰�ť
	private JButton				openButton;

	// ���水ť
	private JButton				saveButton;

	// ȡ����ť
	private JButton				cancelButton;

	// �ԱȰ�ť
	private JButton				compareButton;

	// ʵ��
	private static MainFrame	instance;

	// ��ʵ��
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
		this.addWindowListener(this);

		initOpenButton();

		// File file = new
		// File("C:\\Users\\Public\\Pictures\\Sample Pictures\\sand.jpg");
		// loadImage(file);

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
		openButton.setSize(150, 30);
		openButton.setText("��ͼƬ");
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
		sourceImage = ImageUtil.getImage(sourceImagePath);

		if (sourceImage != null)
		{

			SaturationAndHue.getImage(sourceImage, 0, 0);
			previewImage = Scale.getImage(sourceImage, 100, 100);

			initButtonPanel();
			initBasicAdjustPanel();
			initSaveButton();
			initCancelButton();
			initCompareButton();

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
	 * ��ȡԴͼ��
	 * */
	public BufferedImage getSourceImage()
	{
		return imagePanel.getSourceImage();
	}

	/**
	 * ��ȡͼ�����
	 * */
	public BaseImagePanel getImagePanel()
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

	/**
	 * ������ͼ�����
	 * 
	 * @param image
	 * */
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

		imagePanel = new BaseImagePanel(sourceImage);
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
			imagePanel.updateImage(sourceImage);
		}
	}

	@Override
	public void windowOpened(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

}
