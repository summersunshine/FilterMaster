package gui.partmosaic;

import java.awt.Rectangle;

import app.Constants;

public class PartMosaicSetting
{
	// ����
	public static int				type						= Constants.TYPE_MOSIC;

	// ���ʵĴ�С
	public static int				sizeValue					= 40;

	// ģ��������
	public static int				patchValue					= 8;

	// ���ʴ�С����Сֵ
	public static final int			minSizeValue				= 20;

	// ���ʴ�С�����ֵ
	public static final int			maxSizeValue				= 100;

	// ���ʵ��ڵļ��
	public static final int			sizeExtent					= 5;

	// ģ��������Сֵ
	public static final int			minPatchValue				= 8;

	// ģ���������ֵ
	public static final int			maxPatchValue				= 36;

	// ģ�����ȵ��ڵļ��
	public static final int			patchExtent					= 4;

	// adjustpanel��bounds
	public static final Rectangle	ADJUST_PANEL_RECTANGLE		= new Rectangle(0, 200, 200, 300);

	// size label��bounds
	public static final Rectangle	SIZE_LABEL_RECTANGLE		= new Rectangle(50, 70, 100, 40);

	// size scrollbar��bounds
	public static final Rectangle	SIZE_SCROLLBAR_RECTANGLE	= new Rectangle(20, 100, 160, 20);

	// level label��bounds
	public static final Rectangle	PATCH_LABEL_RECTANGLE		= new Rectangle(50, 170, 100, 40);

	// level scrollbar��bounds
	public static final Rectangle	PATCH_SCROLLBAR_RECTANGLE	= new Rectangle(20, 200, 160, 20);

	// paint button��bounds
	public static final Rectangle	PAINT_BUTTON_RECTANGLE		= new Rectangle(0, 0, 100, 40);

	// erase button��bounds
	public static final Rectangle	ERASE_BUTTON_RECTANGLE		= new Rectangle(100, 0, 100, 40);
}
