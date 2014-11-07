package gui.preview;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.text.BreakIterator;

import javax.swing.JLabel;
import javax.swing.JPanel;

import algorithm.Constants;

public class PreviewListPanel extends JPanel
{
	//类型列表
	private int[] typeList;
	private String[] describeList;
	
	public PreviewListPanel(BufferedImage previewImage, int type)
	{

		initTypeList(type);
		initDescribeList(type);
		initPanel(previewImage);

	}

	
	/**
	 * 依据type初始化typelist
	 * @param type
	 * */
	private void initTypeList(int type)
	{
		switch (type)
		{
		case Constants.TYPE_ART:
			typeList = Constants.TYPE_ALPA_LIST;
			break;
		case Constants.TYPE_BAISC:
			typeList = Constants.TYPE_BASIC_LIST;
			break;
		case Constants.TYPE_BLUR:
			typeList = Constants.TYPE_BLUR_LIST;
			break;
		case Constants.TYPE_LOMO:
			typeList = Constants.TYPE_LOMO_LIST;
			break;
		case Constants.TYPE_STYLE:
			typeList = Constants.TYPE_STYLE_LIST;
			break;

		default:
			typeList = null;
			break;
		}
	}
	
	/**
	 * 依据type初始化desribe list
	 * @param type
	 * */
	private void initDescribeList(int type)
	{
		switch (type)
		{
		case Constants.TYPE_ART:
			describeList = Constants.DESCRIBE_ALPA_LIST;
			break;
		case Constants.TYPE_BAISC:
			describeList = Constants.DESCRIBE_BASIC_LIST;
			break;
		case Constants.TYPE_BLUR:
			describeList = Constants.DESCRIBE_BLUR_LIST;
			break;
		case Constants.TYPE_LOMO:
			describeList = Constants.DESCRIBE_LOMO_LIST;
			break;
		case Constants.TYPE_STYLE:
			describeList = Constants.DESCRIBE_STYLE_LIST;
			break;

		default:
			typeList = null;
			break;
		}
	}
	
	
	/**
	 * 依据源预览图像生产其他的效果预览图
	 * @param previewImage
	 * */
	private void initPanel(BufferedImage previewImage)
	{
		this.setLayout(new GridLayout(10,2));
		for (int i = 0; i < typeList.length; i++)
		{
			PreviewPanel previewPanel = new PreviewPanel(typeList[i], previewImage);
			JLabel label = new JLabel(describeList[i]);
			
			add(label);
			add(previewPanel);
			
			previewPanel.repaint();
		}
		
		this.setSize(200,720);
	}
}
