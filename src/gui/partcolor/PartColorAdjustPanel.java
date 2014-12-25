package gui.partcolor;

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

public class PartColorAdjustPanel extends JPanel implements AdjustmentListener, ActionListener
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// ���ʴ�С������
	private JScrollBar			sizeScrollBar;

	// ���ʴ�С��ǩ
	private JLabel				sizeLabel;

	// ����
	private JButton				paintButton;

	// ����
	private JButton				eraseButton;

	// �����
	private PartColorFrame		parent;

	public PartColorAdjustPanel(PartColorFrame parent) throws HeadlessException
	{
		this.setLayout(null);

		this.setParent(parent);

		initButtons();

		initSizeBarAndLabel();

		setBounds(PartColorSetting.ADJUST_PANEL_RECTANGLE);
	}

	/**
	 * ��ʼ�����ʴ�С�������ͱ�ǩ
	 * */
	private void initSizeBarAndLabel()
	{
		sizeLabel = new JLabel("��С");
		sizeLabel.setBounds(PartColorSetting.SIZE_LABEL_RECTANGLE);

		int value = PartColorSetting.sizeValue;
		int extent = PartColorSetting.sizeExtent;
		int min = PartColorSetting.minSizeValue;
		int max = PartColorSetting.maxSizeValue;

		sizeScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, value, extent, min, max);
		sizeScrollBar.setBounds(PartColorSetting.SIZE_SCROLLBAR_RECTANGLE);
		sizeScrollBar.setUnitIncrement(extent);
		sizeScrollBar.setBlockIncrement(extent);
		sizeScrollBar.addAdjustmentListener(this);

		this.add(sizeLabel);
		this.add(sizeScrollBar);

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
			PartColorSetting.sizeValue = e.getValue();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == paintButton)
		{
			// sizeValue = e.getValue();
			PartColorSetting.type = Constants.TYPE_ERASE;
		}

		if (e.getSource() == eraseButton)
		{
			PartColorSetting.type = Constants.TYPE_GRAY;
		}
	}

	public PartColorFrame getParent()
	{
		return parent;
	}

	public void setParent(PartColorFrame parent)
	{
		this.parent = parent;
	}
}
