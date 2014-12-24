package gui.magicmirror;

import java.awt.Rectangle;

import app.Constants;

public class MagicMirrorSetting
{
	
	//���ð뾶
	public static int radiusValue = 100;
	
	//�˾�����
	public static int type = Constants.TYPE_CONCAVE_MIRROIR;
	


	// ģ��������Сֵ
	public static final int minRadiusValue = 10;

	// ģ���������ֵ
	public static final int maxRadiusValue = 1000;

	// ģ�����ȵ��ڵļ��
	public static final int radiusExtent = 10;
	
	
	// adjustpanel��bounds
	public static final Rectangle ADJUST_PANEL_RECTANGLE = new Rectangle(0, 200, 200, 300);
	
	// size label��bounds
	public static final Rectangle RADIUS_LABEL_RECTANGLE = new Rectangle(100, 70, 30, 40);

	// size scrollbar��bounds
	public static final Rectangle RADIUS_SCROLLBAR_RECTANGLE = new Rectangle(20, 100, 160, 20);

	// paint button��bounds
	public static final Rectangle CONVEX_BUTTON_RECTANGLE = new Rectangle(0, 0, 100, 40);

	// erase button��bounds
	public static final Rectangle CONCAVE_BUTTON_RECTANGLE = new Rectangle(100, 0, 100, 40);
}
