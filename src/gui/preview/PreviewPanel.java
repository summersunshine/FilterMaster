package gui.preview;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;

import filter.Filter;
import filter.factory.FilterFactory;
import gui.main.MainFrame;

public class PreviewPanel extends JPanel implements MouseListener
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// 描述预览界面
	public JLabel				discribelLabel;

	// 显示的图像
	public BufferedImage		displayImage;

	// 滤镜类型
	public int					type;

	// 参数
	public Object[]				parameter;

	/**
	 * 构造函数
	 * 
	 * @param type
	 * @param sourceImage
	 * @param parameter
	 * */
	public PreviewPanel(int type, BufferedImage sourceImage, Object... parameter)
	{

		this.type = type;

		this.parameter = new Object[parameter.length];
		for (int i = 0; i < parameter.length; i++)
		{
			this.parameter[i] = parameter[i];
		}

		initDisplayImage(sourceImage);
		initDescribeLabel();

		this.addMouseListener(this);
		// this.setSize(80, 100);
		this.setVisible(true);

	}

	@Override
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		try
		{
			g2.drawImage(displayImage, 0, 0, displayImage.getWidth(), displayImage.getHeight(), null);
		}
		finally
		{
			g2.dispose();
		}
	}

	/**
	 * 初始化描述label
	 * */
	private void initDescribeLabel()
	{
		// TODO Auto-generated method stub
		discribelLabel = new JLabel();
		discribelLabel.setText("" + type);
	}

	/**
	 * 初始化显示的图像
	 * */
	private void initDisplayImage(BufferedImage sourceImage)
	{
		// TODO Auto-generated method stub
		// displayImage = ImageFactory.getImage(type, sourceImage, parameter);
		Filter filter = FilterFactory.getFilter(type);
		displayImage = filter.getImage(sourceImage);

	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		MainFrame.getInstance().setImagePanel(type);
	}

}
