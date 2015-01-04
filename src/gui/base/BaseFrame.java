package gui.base;

import gui.main.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BaseFrame extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// ���水ť
	private JButton				saveButton;

	// ȡ����ť
	private JButton				cancelButton;

	public BaseFrame()
	{
		this.initBounds();
		// this.setSize(1280, 720);
		this.setLayout(null);
		initSaveButton();
		initCancelButton();
	}

	private void initBounds()
	{
		this.setBounds(MainFrame.getInstance().getBounds());
	}

	/**
	 * ��ʼ�����水ť
	 * */
	private void initSaveButton()
	{
		// TODO Auto-generated method stub
		saveButton = new JButton("����");
		saveButton.setBounds(410, 600, 100, 40);
		saveButton.addActionListener(this);

		this.add(saveButton);
	}

	/**
	 * ��ʼ��ȡ����ť
	 * */
	private void initCancelButton()
	{
		// TODO Auto-generated method stub
		cancelButton = new JButton("ȡ��");
		cancelButton.setBounds(750, 600, 100, 40);
		cancelButton.addActionListener(this);

		this.add(cancelButton);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub

		if (e.getSource() == saveButton)
		{
			saveOperation();
		}

		if (e.getSource() == cancelButton)
		{
			cancelOperation();
		}

	}

	protected void saveOperation()
	{
		// TODO Auto-generated method stub
		this.dispose();
	}

	protected void cancelOperation()
	{
		// TODO Auto-generated method stub
		this.dispose();
	}

}
