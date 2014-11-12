package gui.magicmirror;

import gui.blur.BlurSetting;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

import algorithm.Constants;

public class MagicMirrorAdjustPanel extends JPanel implements AdjustmentListener, ActionListener, MouseListener
{


	// 凸的
	private JButton convexButton;

	// 凹的
	private JButton concaveButton;

	// 嘻哈程度滚动条
	private JScrollBar radiusScrollBar;

	// 嘻哈标签
	private JLabel radiusLabel;

	// 主界面
	MagicMirrorFrame parent;

	public MagicMirrorAdjustPanel(MagicMirrorFrame parent) throws HeadlessException
	{
		this.setLayout(null);

		this.parent = parent;

		initRadiusBarAndLabel();

		initButtons();

		this.addMouseListener(this);

		setBounds(MagicMirrorSetting.ADJUST_PANEL_RECTANGLE);
	}

	/**
	 * 初始化半径滚动条和标签
	 * */
	private void initRadiusBarAndLabel()
	{
		radiusLabel = new JLabel("范围");
		radiusLabel.setBounds(MagicMirrorSetting.RADIUS_LABEL_RECTANGLE);

		int extent = MagicMirrorSetting.radiusExtent;
		int min = MagicMirrorSetting.minRadiusValue;
		int max = MagicMirrorSetting.maxRadiusValue;
		
		radiusScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, min,extent,min,max);
		radiusScrollBar.setBounds(MagicMirrorSetting.RADIUS_SCROLLBAR_RECTANGLE);
		radiusScrollBar.setUnitIncrement(extent);
		radiusScrollBar.setBlockIncrement(extent);
		radiusScrollBar.addAdjustmentListener(this);

		this.add(radiusLabel);
		this.add(radiusScrollBar);

	}

	/**
	 * 初始化按钮们
	 * */
	private void initButtons()
	{
		// TODO Auto-generated method stub
		convexButton = new JButton("凸透镜");
		convexButton.setBounds(MagicMirrorSetting.CONVEX_BUTTON_RECTANGLE);
		convexButton.addActionListener(this);

		concaveButton = new JButton("凹透镜");
		concaveButton.setBounds(MagicMirrorSetting.CONCAVE_BUTTON_RECTANGLE);
		concaveButton.addActionListener(this);
		convexButton.setSelected(false);

		this.add(convexButton);
		this.add(concaveButton);

	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == radiusScrollBar)
		{
			MagicMirrorSetting.radiusValue = e.getValue();
			parent.setImagePanel();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == concaveButton)
		{
			switchToConcave();
		}

		if (e.getSource() == convexButton)
		{
			switchToConvex();
		}

	}
	
	/**
	 * 将滤镜切换到凹透镜
	 * */
	private void switchToConcave()
	{
		// TODO Auto-generated method stub
		concaveButton.setSelected(false);
		convexButton.setSelected(true);
		MagicMirrorSetting.type = Constants.TYPE_MAGIC_MIRROIR_1;

		parent.setImagePanel();
	}
	
	/**
	 * 将滤镜切换到凸透镜
	 * */
	private void switchToConvex()
	{
		// TODO Auto-generated method stub
		convexButton.setSelected(false);
		concaveButton.setSelected(true);
		MagicMirrorSetting.type = Constants.TYPE_MAGIC_MIRROIR_2;

		parent.setImagePanel();
	}
	

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		System.out.println("click");
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		parent.setImagePanel();
	}
}
