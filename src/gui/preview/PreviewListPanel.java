package gui.preview;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import app.Constants;

public class PreviewListPanel extends JScrollPane
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// �����б�
	private int[]				typeList;

	// �����б�
	private String[]			describeList;

	// ��ʵ���ݵĸ߶�
	private int					contentHeight;

	private JLabel[]			labelList;

	private PreviewPanel[]		previewPanelList;

	// Ԥ��ͼ
	private BufferedImage		previewImage;

	public PreviewListPanel(BufferedImage previewImage, int type)
	{
		this.previewImage = previewImage;
		initTypeList(type);
		initDescribeList(type);
		initPanel();
	}

	/**
	 * ����type��ʼ��typelist
	 * 
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
		case Constants.TYPE_FASHION:
			typeList = Constants.TYPE_FASHION_LIST;
			break;
		case Constants.TYPE_FRAME:
			typeList = Constants.TYPE_FRAME_LIST;
			break;
		default:
			typeList = null;
			break;
		}
	}

	/**
	 * ����type��ʼ��desribe list
	 * 
	 * @param type
	 * */
	private void initDescribeList(int type)
	{
		switch (type)
		{
		case Constants.TYPE_ART:
			describeList = Constants.DESCRIBE_ART_LIST;
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
		case Constants.TYPE_FASHION:
			describeList = Constants.DESCRIBE_FASHION_LIST;
			break;
		case Constants.TYPE_FRAME:
			describeList = Constants.DESCRIBE_FRAME_LIST;
			break;
		default:
			typeList = null;
			break;
		}
	}

	/**
	 * ����ԴԤ��ͼ������������Ч��Ԥ��ͼ
	 * 
	 * @param previewImage
	 * */
	public void initPanel()
	{
		this.setLayout(null);
		this.contentHeight = 0;

		for (int i = 0; i < typeList.length; i++)
		{
			addLabel(i);
			addPreviewPanel(i);
			contentHeight += 150;
		}

		this.setPreferredSize(new Dimension(240, contentHeight + 50));

		this.setVisible(true);
	}

	/**
	 * ��ӱ�ǩ
	 * 
	 * @param index
	 * */
	private void addLabel(int index)
	{
		JLabel label = new JLabel(describeList[index]);
		label.setBounds(20, index * 150, 200, 50);
		add(label);

	}

	/**
	 * ���Ԥ�����
	 * 
	 * @param index
	 * */
	private void addPreviewPanel(int index)
	{
		PreviewPanel previewPanel = new PreviewPanel(typeList[index], previewImage);
		previewPanel.setBounds(20, index * 150 + 50, 200, 100);
		add(previewPanel);

	}

	/**
	 * ��ȡ���ݵĸ߶�
	 * */
	public int getContentHeight()
	{
		return contentHeight;
	}

}
