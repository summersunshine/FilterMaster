package gui.scrawl;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

import app.Constants;

public class ScrawlAdjustPanel extends JPanel implements ActionListener, AdjustmentListener
{
	// ���ʴ�С������
	private JScrollBar sizeScrollBar;

	// ���ʴ�С��ǩ
	private JLabel sizeLabel;
	
	//Ϳѻ����͸���ȹ�����
	private JScrollBar alphaScrollBar;
	
	//Ϳѻ����͸���ȱ�ǩ
	private JLabel alphaLabel;

	// ����
	private JButton paintButton;

	// ����
	private JButton eraseButton;

	// �����
	private ScrawlFrame parent;

	public ScrawlAdjustPanel(ScrawlFrame parent) throws HeadlessException
	{
		this.parent = parent;
		this.setBounds(ScrawlSetting.ADJUST_PANEL_RECTANGLE);
		this.setLayout(null);

		

		initSizeBarAndLabel();
		//initAlphaBarAndLabel();
		
		initButtons();
		
		setVisible(true);
	}

	/**
	 * ��ʼ�����ʴ�С�������ͱ�ǩ
	 * */
	private void initSizeBarAndLabel()
	{
		sizeLabel = new JLabel("��С");
		sizeLabel.setBounds(ScrawlSetting.SIZE_LABEL_RECTANGLE);

		int extent = ScrawlSetting.sizeExtent;
		int min = ScrawlSetting.minSizeValue;
		int max = ScrawlSetting.maxSizeValue;

		sizeScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, min, extent, min, max);
		sizeScrollBar.setBounds(ScrawlSetting.SIZE_SCROLLBAR_RECTANGLE);
		sizeScrollBar.setUnitIncrement(extent);
		sizeScrollBar.setBlockIncrement(extent);
		sizeScrollBar.addAdjustmentListener(this);

		this.add(sizeLabel);
		this.add(sizeScrollBar);

	}
	
	/**
	 * ��ʼ��Ϳѻ����͸���ȹ������ͱ�ǩ
	 * */
	private void initAlphaBarAndLabel()
	{
		alphaLabel = new JLabel("Ϳѻ͸��");
		alphaLabel.setBounds(ScrawlSetting.ALPHA_LABEL_RECTANGLE);

		int extent = ScrawlSetting.alphaExtent;
		int min = ScrawlSetting.minAlphaValue;
		int max = ScrawlSetting.maxAlphaValue;

		alphaScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, min, extent, min, max);
		alphaScrollBar.setBounds(ScrawlSetting.ALPHA_SCROLLBAR_RECTANGLE);
		alphaScrollBar.setUnitIncrement(extent);
		alphaScrollBar.setBlockIncrement(extent);
		alphaScrollBar.addAdjustmentListener(this);

		this.add(alphaLabel);
		this.add(alphaScrollBar);
	}

	/**
	 * ��ʼ����ť��
	 * */
	private void initButtons()
	{
		// TODO Auto-generated method stub
		paintButton = new JButton("����");
		paintButton.setBounds(0, 0, 100, 40);
		paintButton.addActionListener(this);

		eraseButton = new JButton("��Ƥ��");
		eraseButton.setBounds(100, 0, 100, 40);
		eraseButton.addActionListener(this);
		paintButton.setSelected(true);

		this.add(paintButton);
		this.add(eraseButton);

		

	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == sizeScrollBar)
		{
			// sizeValue = e.getValue();
			ScrawlSetting.sizeValue = e.getValue();
		}
		
		if (e.getSource() == alphaScrollBar)
		{
			ScrawlSetting.alphaValue = e.getValue();
			
			parent.updateDrawingALpha();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == paintButton)
		{
			// sizeValue = e.getValue();
			ScrawlSetting.type = Constants.TYPE_BAISC;
		}

		if (e.getSource() == eraseButton)
		{
			ScrawlSetting.type = Constants.TYPE_ERASE;
		}
	}
}
