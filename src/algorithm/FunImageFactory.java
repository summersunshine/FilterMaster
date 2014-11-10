package algorithm;

import java.awt.image.BufferedImage;

import algorithm.fun.AlphaMerge;
import algorithm.fun.MagicMirror;
import algorithm.fun.Mosaic;

public class FunImageFactory
{

	public static BufferedImage getImage(int type, BufferedImage image, Object... parameter)
	{
		switch (type)
		{

		case (Constants.TYPE_ALPHA_MERGE):
			return AlphaMerge.getImage(image, (BufferedImage) (parameter[0]));
		case (Constants.TYPE_ALPHA_MERGE_1):
			return AlphaMerge.getImage(image, (BufferedImage) (parameter[0]), AlphaMerge.TYPE_LEFT_2_RIGHT);
		case (Constants.TYPE_ALPHA_MERGE_2):
			return AlphaMerge.getImage(image, (BufferedImage) (parameter[0]), AlphaMerge.TYPE_RIGHT_2_LEFT);
		case (Constants.TYPE_ALPHA_MERGE_3):
			return AlphaMerge.getImage(image, (BufferedImage) (parameter[0]), AlphaMerge.TYPE_UP_2_DOWN);
		case (Constants.TYPE_ALPHA_MERGE_4):
			return AlphaMerge.getImage(image, (BufferedImage) (parameter[0]), AlphaMerge.TYPE_DOWN_2_UP);
		case (Constants.TYPE_MAGIC_MIRROIR_1):
			return MagicMirror.getImage(image, MagicMirror.TYPE_CONCAVE);
		case (Constants.TYPE_MAGIC_MIRROIR_2):
			return MagicMirror.getImage(image, MagicMirror.TYPE_CONVEX);
		case (Constants.TYPE_MOSIC):
			return Mosaic.getImage(image, (int) (parameter[0]));
		default:
			return null;
		}

	}
}
