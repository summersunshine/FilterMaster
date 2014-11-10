package algorithm;

import java.awt.image.BufferedImage;

import algorithm.style.RetroStyle;

public class ImageFactory
{
	public static BufferedImage getImage(int type, BufferedImage image, Object... parameter)
	{
		int classify = type / 100;

		switch (classify)
		{
		case (Constants.TYPE_ART):
			return ArtImageFactory.getImage(type, image, parameter);
		case (Constants.TYPE_BAISC):
			return BasicImageFactory.getImage(type, image, parameter);
		case (Constants.TYPE_BLUR):
			return BlurImageFactory.getImage(type, image, parameter);
		case (Constants.TYPE_FUN):
			return FunImageFactory.getImage(type, image, parameter);
		case (Constants.TYPE_LOMO):
			return LomoImageFactory.getImage(type, image, parameter);
		case (Constants.TYPE_STYLE):
			return StyleImageFactory.getImage(type, image, parameter);
		default:
			return null;
		}

	}
}
