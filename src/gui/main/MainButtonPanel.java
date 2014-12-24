package gui.main;

import gui.blur.BlurFrame;
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
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// ����ģ����ť
	private JButton				blurButton;

	// ƴͼ��ť
	private JButton				jigsawButton;

	// ħ����ť
	private JButton				magicMirrorButton;

	// �ֲ���ɫ��ť
	private JButton				partColorButton;

	// �����˰�ť
	private JButton				partMosaicButton;

	// Ϳѻ��ť
	private JButton				scrawlButton;

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
	 * ��ʼ��������ð�ť
	 * */
	private void initBlurButton()
	{
		blurButton = new JButton();
		blurButton.setSize(100, 30);
		blurButton.setLocation(150, 0);
		blurButton.setText("�����黯");
		blurButton.addActionListener(this);
		this.add(blurButton);
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
		this.add(jigsawButton);
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
		this.add(magicMirrorButton);
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
		this.add(partColorButton);
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
		this.add(partMosaicButton);
	}

	/**
	 * ��ʼ��Ϳѻ��ť
	 * */
	private void initScrawlButton()
	{
		scrawlButton = new JButton();
		scrawlButton.setSize(100, 30);
		scrawlButton.setLocation(750, 0);
		scrawlButton.setText("Ϳѻ");
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
			new BlurFrame(image);
		}
		else if (e.getSource() == jigsawButton)
		{
			new JigsawFrame(image);
		}
		else if (e.getSource() == magicMirrorButton)
		{
			new MagicMirrorFrame(image);
		}
		else if (e.getSource() == partColorButton)
		{
			new PartColorFrame(image);
		}
		else if (e.getSource() == partMosaicButton)
		{
			new PartMosaicFrame(image);
		}
		else if (e.getSource() == scrawlButton)
		{
			new ScrawlFrame(image);
		}
	}

}
