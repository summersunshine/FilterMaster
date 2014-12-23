package algorithm.factory;

import java.awt.image.BufferedImage;

import algorithm.fun.AlphaMerge;
import algorithm.fun.MagicMirror;
import algorithm.fun.Mosaic;
import app.Constants;

public class FunImageFactory
{

	/**
	 * 依据类型，图像，参数获取新的趣味图像
	 * 
	 * @param type
	 *            类型
	 * @param image
	 *            图像
	 * @param paramter
	 *            不定参数
	 * */
	public static BufferedImage getImage(int type, BufferedImage image, Object... parameter)
	{
		switch (type)
		{

		case (Constants.TYPE_ALPHA_MERGE):
			return AlphaMerge.getImage(image, (BufferedImage) (parameter[0]));
		case (Constants.TYPE_ALPHA_MERGE_1):
			return AlphaMerge.getImage(image, (BufferedImage) (parameter[0]), AlphaMerge.DIR_LEFT_2_RIGHT);
		case (Constants.TYPE_ALPHA_MERGE_2):
			return AlphaMerge.getImage(image, (BufferedImage) (parameter[0]), AlphaMerge.DIR_RIGHT_2_LEFT);
		case (Constants.TYPE_ALPHA_MERGE_3):
			return AlphaMerge.getImage(image, (BufferedImage) (parameter[0]), AlphaMerge.DIR_UP_2_DOWN);
		case (Constants.TYPE_ALPHA_MERGE_4):
			return AlphaMerge.getImage(image, (BufferedImage) (parameter[0]), AlphaMerge.DIR_DOWN_2_UP);
		case (Constants.TYPE_MAGIC_MIRROIR_1):
			return MagicMirror.getImage(image, MagicMirror.TYPE_CONCAVE, (float) (parameter[0]));
		case (Constants.TYPE_MAGIC_MIRROIR_2):
			return MagicMirror.getImage(image, MagicMirror.TYPE_CONVEX, (float) (parameter[0]));
		case (Constants.TYPE_MOSIC):
			return Mosaic.getImage(image);
		default:
			return null;
		}

	}
}
