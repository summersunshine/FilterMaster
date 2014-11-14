package algorithm.lomo;

import java.awt.image.BufferedImage;

import algorithm.style.YouthStyle;

public class MemoryLomo
{
	public static BufferedImage getImage(BufferedImage image)
	{
		return ClassicalLomo.getImage(YouthStyle.getImage(image));
	}
}
