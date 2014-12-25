package gui.base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 调节面板的基类
 * */
public class BaseAdjustPanel extends JPanel implements ActionListener
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	private JButton				saveButton;

	private JButton				cancelButton;

	public BaseAdjustPanel()
	{
		initButtons();
	}

	private void initButtons()
	{
		// TODO Auto-generated method stub
		saveButton = new JButton("保存");
		saveButton.setBounds(0, 0, 100, 40);
		saveButton.addActionListener(this);

		cancelButton = new JButton("取消");
		cancelButton.setBounds(100, 0, 100, 40);
		cancelButton.addActionListener(this);

		this.setLayout(null);
		this.add(saveButton);
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

	private void saveOperation()
	{
		// TODO Auto-generated method stub

	}

	private void cancelOperation()
	{
		// TODO Auto-generated method stub

	}

}
