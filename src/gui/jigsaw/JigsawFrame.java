package gui.jigsaw;

import gui.BaseFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class JigsawFrame extends BaseFrame implements ActionListener
{

	// 第一张图片
	private BufferedImage firstSourceImage;

	// 显示图片面板
	private JigsawImagePanel imagePanel;

	// 按钮组
	private JigsawButtonGroup buttonGroup;

	public JigsawFrame(BufferedImage image)
	{
		super();

		firstSourceImage = image;

	}

	private void initImagePanel()
	{
		// TODO Auto-generated method stub
		imagePanel = new JigsawImagePanel(firstSourceImage, sourceImage);

		getContentPane().add(imagePanel);

		imagePanel.repaint();

	}

	private void initButtonGroup()
	{
		buttonGroup = new JigsawButtonGroup(this);

		getContentPane().add(buttonGroup);

		buttonGroup.repaint();
	}

	@Override
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
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub

	}

}
