package gui.main;

import gui.blur.BlurFrame;
import gui.compare.CompareFrame;
import gui.jigsaw.JigsawFrame;
import gui.magicmirror.MagicMirrorFrame;
import gui.partcolor.PartColorFrame;
import gui.partmosaic.PartMosaicFrame;
import gui.scrawl.ScrawlFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainButtonPanel extends JPanel implements ActionListener
{
	// 背景模糊按钮
	private JButton blurButton;

	// 拼图按钮
	private JButton jigsawButton;

	// 魔镜按钮
	private JButton magicMirrorButton;

	// 局部彩色按钮
	private JButton partColorButton;

	// 马赛克按钮
	private JButton partMosaicButton;

	// 涂鸦按钮
	private JButton scrawlButton;

	public MainButtonPanel()
	{
		this.setLayout(new GridLayout(3, 2));

		initBlurButton();
		initJigsawButton();
		initMagicMirrorButton();
		initPartColorButton();
		initPartMosaicButton();
		initScrawlButton();
		this.setBounds(0, 360, 200, 300);
	}

	/**
	 * 初始化背景虚幻按钮
	 * */
	private void initBlurButton()
	{
		blurButton = new JButton();
		blurButton.setSize(100, 30);
		blurButton.setLocation(150, 0);
		blurButton.setText("背景虚化");
		blurButton.addActionListener(this);
		this.add(blurButton);
	}

	/**
	 * 初始化拼图按钮
	 * */
	private void initJigsawButton()
	{
		jigsawButton = new JButton();
		jigsawButton.setSize(100, 30);
		jigsawButton.setLocation(300, 0);
		jigsawButton.setText("背景拼图");
		jigsawButton.addActionListener(this);
		this.add(jigsawButton);
	}

	/**
	 * 初始化魔镜按钮
	 * */
	private void initMagicMirrorButton()
	{
		magicMirrorButton = new JButton();
		magicMirrorButton.setSize(100, 30);
		magicMirrorButton.setLocation(450, 0);
		magicMirrorButton.setText("魔镜");
		magicMirrorButton.addActionListener(this);
		this.add(magicMirrorButton);
	}

	/**
	 * 初始化局部彩色按钮
	 * */
	private void initPartColorButton()
	{
		partColorButton = new JButton();
		partColorButton.setSize(100, 30);
		partColorButton.setLocation(600, 0);
		partColorButton.setText("局部彩色");
		partColorButton.addActionListener(this);
		this.add(partColorButton);
	}

	/**
	 * 初始化局部马赛克按钮
	 * */
	private void initPartMosaicButton()
	{
		partMosaicButton = new JButton();
		partMosaicButton.setSize(100, 30);
		partMosaicButton.setLocation(750, 0);
		partMosaicButton.setText("局部马赛克");
		partMosaicButton.addActionListener(this);
		this.add(partMosaicButton);
	}

	/**
	 * 初始化涂鸦按钮
	 * */
	private void initScrawlButton()
	{
		scrawlButton = new JButton();
		scrawlButton.setSize(100, 30);
		scrawlButton.setLocation(750, 0);
		scrawlButton.setText("涂鸦");
		scrawlButton.addActionListener(this);
		this.add(scrawlButton);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		BufferedImage image = MainFrame.getInstance().getDisplayImage();

		// TODO Auto-generated method stub
		if (e.getSource() == blurButton)
		{
			BlurFrame blurFrame = new BlurFrame(image);
		}
		else if (e.getSource() == jigsawButton)
		{
			JigsawFrame jigsawFrame = new JigsawFrame(image);
		}
		else if (e.getSource() == magicMirrorButton)
		{
			MagicMirrorFrame magicMirrorFrame = new MagicMirrorFrame(image);
		}
		else if (e.getSource() == partColorButton)
		{
			PartColorFrame partColorFrame = new PartColorFrame(image);
		}
		else if (e.getSource() == partMosaicButton)
		{
			PartMosaicFrame partMosaicFrame = new PartMosaicFrame(image);
		}
		else if (e.getSource() == scrawlButton)
		{
			ScrawlFrame scrawlFrame = new ScrawlFrame(image);
		}
	}

}
