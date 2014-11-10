package gui.jigsaw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import gui.BaseFrame;
import gui.ImagePanel;
import gui.preview.PreviewListPanel;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import util.ImgUtil;
import algorithm.Constants;
import algorithm.FunImageFactory;
import algorithm.basic.Scale;
import algorithm.fun.AlphaMerge;

public class JigsawFrame extends BaseFrame implements ActionListener
{

	// µ⁄“ª’≈Õº∆¨
	private BufferedImage firstSourceImage;

	// ‘§¿¿Õº∆¨
	private BufferedImage previewImage;

	// œ‘ æÕº∆¨√Ê∞Â
	private JigsawImagePanel imagePanel;

	// ‘§¿¿√Ê∞Â
	private PreviewListPanel previewListPanel;

	// ∞¥≈•◊È
	private JigsawButtonGroup buttonGroup;

	public JigsawFrame(BufferedImage image)
	{
		super();

		firstSourceImage = image;

	}

	private void initImagePanel()
	{
		// TODO Auto-generated method stub
		// displayImage = AlphaMerge.getImage(firstSourceImage, sourceImage);

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
		imagePanel.setImage(type);
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub

	}

}
