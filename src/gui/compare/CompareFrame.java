package gui.compare;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CompareFrame extends JFrame implements ActionListener
{
	//图像对比面板
	private CompareImagePanel compareImagePanel;

	//竖直按钮
	private JButton verticalButton;
	
	//水平按钮
	private JButton horizontalButton;

	//源图像
	private BufferedImage sourceImage;
	
	//显示图像
	private BufferedImage displayImage;

	public CompareFrame(BufferedImage sourceImage, BufferedImage displayImage)
	{

		this.setLayout(null);
		this.sourceImage = sourceImage;
		this.displayImage = displayImage;

		this.initLayoutType();
		this.initButtons();
		this.initCompareImagePanel();

		this.setSize(CompareSetting.FRAME_WIDTH, CompareSetting.FRAME_HEIGHT);
		this.setVisible(true);

	}

	/**
	 * 设置默认的布局类型
	 * */
	private void initLayoutType()
	{
		CompareSetting.setLayoutType(sourceImage.getWidth(), sourceImage.getHeight());
	}

	/**
	 * 初始化比较面板
	 * 
	 * @param sourceImage
	 * @param displayImage
	 * */
	private void initCompareImagePanel()
	{
		compareImagePanel = new CompareImagePanel(sourceImage, displayImage);
		getContentPane().add(compareImagePanel);
		compareImagePanel.repaint();
	}

	/**
	 * 初始化竖直和水平按钮
	 * */
	private void initButtons()
	{
		// TODO Auto-generated method stub
		verticalButton = new JButton("竖直");
		verticalButton.setBounds(CompareSetting.VERTICAL_BUTTON_TRCTANGLE);
		verticalButton.addActionListener(this);

		horizontalButton = new JButton("水平");
		horizontalButton.setBounds(CompareSetting.HOZRIONTAL_BUTTON_RECTANGLE);
		horizontalButton.addActionListener(this);

		getContentPane().add(verticalButton);
		getContentPane().add(horizontalButton);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == verticalButton)
		{
			switchToVertical();
		}
		else
		{
			switchToHorizontal();
		}

	}

	/**
	 * 切换到竖直
	 * */
	private void switchToVertical()
	{
		CompareSetting.layoutType = CompareSetting.TYPE_VETTICAL;
		compareImagePanel.updateImagePanel();
	}

	/**
	 * 切换到水平
	 * */
	private void switchToHorizontal()
	{
		CompareSetting.layoutType = CompareSetting.TYPE_HORIZONTAL;
		compareImagePanel.updateImagePanel();
	}

}
