package algorithm;

import java.awt.image.BufferedImage;

import algorithm.style.RetroStyle;

public class StyleImageFactory
{

	public static BufferedImage getImage(int type, BufferedImage image, Object... parameter)
	{
		switch (type)
		{
		case (Constants.TYPE_RETRO_STYLE):
			return RetroStyle.getImage(image);
		default:
			return null;
		}

	}
}
