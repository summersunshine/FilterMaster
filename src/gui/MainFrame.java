package gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import util.ImgUtil;
import algorithm.fun.MagicMirror;

public class MainFrame extends Frame
{
	public static final int MAX_IMAGE_WIDTH = 450;
	public static final int MAX_IMAGE_HEIGHT = 800;

	public static final int IMAGE_CENTER_X = 640;
	public static final int IMAGE_CENTER_Y = 360;
	
	
	public static BufferedImage displayImage;
	public static BufferedImage sourceImage;
	public static JFrame mainFrame;
	
	public String sourceImagePath;
	
	public static void main(String args[])
	{
		MainFrame mainFrame = new MainFrame();

	}
	
	public MainFrame()
	{
		super();
		mainFrame = new JFrame("Image JFrame");

		mainFrame.setSize(1280, 720);
		mainFrame.setVisible(true);
		mainFrame.setLayout(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initOpenButton();

		mainFrame.add(BasicAdjustPanel.getInstance());

	}
	




	private void initOpenButton()
	{
		JButton openButton = new JButton();
		openButton.setSize(100, 30);
		openButton.setText("´ò¿ª");
		openButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				initFileChooser();
			}
		});
		mainFrame.add(openButton);
	}

	private void initFileChooser()
	{
		File desktop = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "×ÀÃæ");
		JFileChooser fileChooser = new JFileChooser(desktop);
		fileChooser.setFileFilter(new FileNameExtensionFilter("Í¼Ïñ", "jpg", "png"));

		int option = fileChooser.showOpenDialog(null);
		if (JFileChooser.APPROVE_OPTION == option)
		{
			File currFile = fileChooser.getSelectedFile();
			sourceImagePath = currFile.getAbsolutePath();
			sourceImage = ImgUtil.getImg(sourceImagePath);
			
			if (sourceImage!=null)
			{
				displayImage = MagicMirror.getImage(sourceImage, MagicMirror.TYPE_CONVEX);
				paintImage();
				
			}
		}

	}
	
	public static void paintImage()
	{
		float ratioX=1,ratioY=1,ratio;
		if (displayImage.getWidth()>MAX_IMAGE_WIDTH)
		{
			ratioX = MAX_IMAGE_HEIGHT*1.0f/displayImage.getWidth();
		}
		
		if (displayImage.getHeight()>MAX_IMAGE_HEIGHT)
		{
			ratioY = MAX_IMAGE_HEIGHT*1.0f/displayImage.getHeight();
		}
		
		ratio = ratioX < ratioY?ratioX:ratioY;
		
		int width = (int) (displayImage.getWidth()*ratio);
		int height = (int) (displayImage.getHeight()*ratio);
		int x = IMAGE_CENTER_X - width/2;
		int y = IMAGE_CENTER_Y - height/2;
		
		mainFrame.getGraphics().drawImage((Image)displayImage,x,y,width,height,null);
	}
	

}
