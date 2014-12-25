package gui.partmosaic;

import java.awt.Rectangle;

import app.Constants;

public class PartMosaicSetting
{
	// 类型
	public static int				type						= Constants.TYPE_MOSIC;

	// 画笔的大小
	public static int				sizeValue					= 40;

	// 模糊的力度
	public static int				patchValue					= 8;

	// 画笔大小的最小值
	public static final int			minSizeValue				= 20;

	// 画笔大小的最大值
	public static final int			maxSizeValue				= 100;

	// 画笔调节的间隔
	public static final int			sizeExtent					= 5;

	// 模糊力度最小值
	public static final int			minPatchValue				= 8;

	// 模糊力度最大值
	public static final int			maxPatchValue				= 36;

	// 模糊力度调节的间隔
	public static final int			patchExtent					= 4;

	// adjustpanel的bounds
	public static final Rectangle	ADJUST_PANEL_RECTANGLE		= new Rectangle(0, 200, 200, 300);

	// size label的bounds
	public static final Rectangle	SIZE_LABEL_RECTANGLE		= new Rectangle(50, 70, 100, 40);

	// size scrollbar的bounds
	public static final Rectangle	SIZE_SCROLLBAR_RECTANGLE	= new Rectangle(20, 100, 160, 20);

	// level label的bounds
	public static final Rectangle	PATCH_LABEL_RECTANGLE		= new Rectangle(50, 170, 100, 40);

	// level scrollbar的bounds
	public static final Rectangle	PATCH_SCROLLBAR_RECTANGLE	= new Rectangle(20, 200, 160, 20);

	// paint button的bounds
	public static final Rectangle	PAINT_BUTTON_RECTANGLE		= new Rectangle(0, 0, 100, 40);

	// erase button的bounds
	public static final Rectangle	ERASE_BUTTON_RECTANGLE		= new Rectangle(100, 0, 100, 40);
}
