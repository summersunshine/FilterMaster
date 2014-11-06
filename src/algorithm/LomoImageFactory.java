package algorithm;

import java.awt.image.BufferedImage;

import algorithm.lomo.Lomo;

public class LomoImageFactory
{



	public static BufferedImage getImage(int type, BufferedImage image, Object... parameter)
	{
		switch (type)
		{
		case (Constants.TYPE_LOMO_CLASSIC):
			return Lomo.getImage(image, (int) parameter[0]);
		default:
			return null;
		}
	}
}
