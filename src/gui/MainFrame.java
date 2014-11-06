package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import algorithm.Sculpture;


public class MainFrame extends JFrame
{

	JPanel paintPanel;
	Graphics graphics;

	/*** 
     *  
     * @param filePath 
     *            : only regular file 
     */  
    public static void open_file(String filePath) {  
        File file = new File(filePath);  
        if (!file.exists()) {  
            return;  
        }  
        Runtime runtime = null;  
        try {  
            runtime = Runtime.getRuntime();  
//            if (!SystemUtil.isWindows) {  
//                // System.out.println("is linux");  
//                runtime.exec("nautilus " + filePath);  
//            } else {  
                runtime.exec("cmd /c start explorer /select,/e, " + filePath);  
//            }  
        } catch (IOException ex) {  
            ex.printStackTrace();  
        } finally {  
            if (null != runtime) {  
                runtime.runFinalization();  
            }  
        }  
    }
    
	public MainFrame()
	{
		Img img = new Img();
		img.imgPanel("res/test.png");
		JFrame frame = new JFrame("Image JFrame");
		frame.add(img.imgPanel("res/test.png"));
		frame.setSize(400,400);
		frame.setVisible(true);
//		try
//		{
//			java.awt.Desktop.getDesktop().
//		} catch (IOException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} \
		
		JFileChooser jFileChooser = new JFileChooser(new File("C:\\Users\\XY\\Documents\\Downloads"));
		
		jFileChooser.showOpenDialog(frame);
		//open_file("C:\\Users\\XY\\Documents\\Downloads");
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
	
	static public void main(String args[])
	{
		MainFrame mainFrame = new MainFrame();
		
	}
}
