package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import algorithm.Sculpture;

public class MainFrame extends JFrame
{

	JPanel paintPanel;
	Graphics graphics;

	// public static void main(String args[]) {
	// MainFrame mainFrame = new MainFrame();
	// mainFrame.setSize(1280, 800);
	// mainFrame.setVisible(true);
	//
	// }

	public MainFrame()
	{
		this.setLayout(null);
		initPanel();
		initImage();
		this.setBackground(Color.white);
	}

	private void initImage()
	{
		// TODO Auto-generated method stub
		File imageFile = new File("res/test.jpg");
		Image image = null;
		try
		{
			image = ImageIO.read(new FileInputStream(imageFile));

		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (image != null)
		{
			Sculpture.getImage((BufferedImage) image);

			graphics = paintPanel.getGraphics();
			graphics.drawImage(image, 0, 0, null);
		}

	}

	/**
	 * 初始化绘制面板*
	 */
	public void initPanel()
	{
		paintPanel = new JPanel();
		paintPanel.setBackground(Color.WHITE);
		paintPanel.setBounds(0, 50, 1280, 720);
		graphics = paintPanel.getGraphics();
		this.add(paintPanel);
	}

}
