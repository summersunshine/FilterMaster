package app;

public class Constants
{
	public static final int	TYPE_ERASE				= 0;
	public static final int	TYPE_ART				= 1;
	public static final int	TYPE_BAISC				= 2;
	public static final int	TYPE_BLUR				= 3;
	public static final int	TYPE_FUN				= 4;
	public static final int	TYPE_LOMO				= 5;
	public static final int	TYPE_STYLE				= 6;
	public static final int	TYPE_FASHION			= 7;
	public static final int	TYPE_FRAME				= 8;

	// art
	public static final int	TYPE_OIL_PAINT			= 101;
	public static final int	TYPE_PENCIL				= 102;
	public static final int	TYPE_SCULPTUE			= 103;
	public static final int	TYPE_SKETCH				= 104;
	public static final int	TYPE_STOKEAREA			= 105;

	// basic
	public static final int	TYPE_GRAY				= 201;
	public static final int	TYPE_INTENSITY_CONTRAST	= 202;
	public static final int	TYPE_SATURATION_HUE		= 203;
	public static final int	TYPE_INVERSE			= 204;
	public static final int	TYPE_SCALE				= 205;
	public static final int	TYPE_SHARPEN			= 206;
	public static final int	TYPE_EDGE_SOBEL_X		= 207;
	public static final int	TYPE_EDGE_SOBEL_Y		= 208;
	public static final int	TYPE_EDGE_LAPLACE		= 209;

	// blur
	// public static final int TYPE_DOUBLE_GUASS_BLUR = 300;
	public static final int	TYPE_GUASS_BLUR			= 301;
	public static final int	TYPE_LASER				= 302;
	public static final int	TYPE_MOTION_BLUR		= 303;

	// fun
	public static final int	TYPE_ALPHA_MERGE		= 400;
	public static final int	TYPE_ALPHA_MERGE_1		= 401;
	public static final int	TYPE_ALPHA_MERGE_2		= 402;
	public static final int	TYPE_ALPHA_MERGE_3		= 403;
	public static final int	TYPE_ALPHA_MERGE_4		= 404;
	public static final int	TYPE_CONCAVE_MIRROIR	= 405;
	public static final int	TYPE_CONVEX_MIRROIR		= 406;
	public static final int	TYPE_MOSIC				= 407;
	public static final int	TYPE_PART_MOSIC			= 408;
	// lomo
	public static final int	TYPE_LOMO_CLASSIC		= 501;
	public static final int	TYPE_LOMO_MEMORY		= 502;

	// style
	public static final int	TYPE_RETRO_STYLE		= 601;
	public static final int	TYPE_DUSK_STYLE			= 602;
	public static final int	TYPE_YOUTH_STYLE		= 603;

	// fashion
	public static final int	TYPE_RAINBOW			= 701;
	public static final int	TYPE_PHOTON				= 702;
	public static final int	TYPE_PARCHMENT			= 703;
	public static final int	TYPE_FLARE				= 704;

	// frame
	public static final int	TYPE_FRAME_WOOD			= 801;
	public static final int	TYPE_FRAME_INSTANT		= 802;
	public static final int	TYPE_FRAME_FILM			= 803;
	public static final int	TYPE_FRAME_SIMPLE		= 804;

	public static int[]		TYPE_ALPA_LIST			= { TYPE_OIL_PAINT, TYPE_PENCIL, TYPE_SCULPTUE, TYPE_SKETCH, TYPE_STOKEAREA };

	public static int[]		TYPE_BASIC_LIST			= { TYPE_GRAY, TYPE_INVERSE, TYPE_SHARPEN, TYPE_EDGE_SOBEL_X, TYPE_EDGE_SOBEL_Y, TYPE_EDGE_LAPLACE };

	public static int[]		TYPE_BLUR_LIST			= { TYPE_GUASS_BLUR, TYPE_LASER, TYPE_MOTION_BLUR };

	public static int[]		TYPE_FUN_LIST			= { TYPE_ALPHA_MERGE, TYPE_ALPHA_MERGE_1, TYPE_ALPHA_MERGE_2, TYPE_ALPHA_MERGE_3, TYPE_ALPHA_MERGE_4,
			TYPE_CONCAVE_MIRROIR, TYPE_CONVEX_MIRROIR, TYPE_MOSIC };

	public static int[]		TYPE_LOMO_LIST			= { TYPE_LOMO_CLASSIC, TYPE_LOMO_MEMORY };

	public static int[]		TYPE_STYLE_LIST			= { TYPE_RETRO_STYLE, TYPE_DUSK_STYLE, TYPE_YOUTH_STYLE };

	public static int[]		TYPE_FASHION_LIST		= { TYPE_RAINBOW, TYPE_PHOTON, TYPE_PARCHMENT, TYPE_FLARE };

	public static int[]		TYPE_FRAME_LIST			= { TYPE_FRAME_WOOD, TYPE_FRAME_INSTANT, TYPE_FRAME_FILM, TYPE_FRAME_SIMPLE };

	public static String[]	DESCRIBE_ART_LIST		= { "ÓÍ»­", "Ç¦±Ê", "¸¡µñ", "ËØÃè", "±Ê´¥ÇøÓò" };

	public static String[]	DESCRIBE_BASIC_LIST		= { "»Ò¶ÈÍ¼", "¸ºÆ¬", "Èñ»¯", "SLOBEL±ßÔµ¼ì²â1", "SLOBEL±ßÔµ¼ì²â2", "À­ÆÕÀ­Ë¹±ßÔµ¼ì²â" };

	public static String[]	DESCRIBE_BLUR_LIST		= { "¸ßË¹Ä£ºý", "¹âÏßÄ£ºý", "¶¯Ì¬Ä£ºý" };

	public static String[]	DESCRIBE_LOMO_LIST		= { "¾­µä", "»ØÒä" };

	public static String[]	DESCRIBE_STYLE_LIST		= { "¸´¹Å", "»Æ»è", "Çà´º" };

	public static String[]	DESCRIBE_FASHION_LIST	= { "²Êºç", "¼«¹â", "ÑòÆ¤Ö½", "¹âÔÎ" };

	public static String[]	DESCRIBE_FRAME_LIST		= { "Ä¾ÖÆ", "ÅÄÁ¢µÃ", "½ºÆ¬", "¼òµ¥" };

}
