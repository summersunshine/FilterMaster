package algorithm;

import java.awt.image.BufferedImage;

public class ImageFactory
{
	/**
	 * 依据类型，图像，参数获取新的图像
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
		case (Constants.TYPE_FASHION):
			return FashionImageFactory.getImage(type, image, parameter);
		case (Constants.TYPE_FRAME):
			return FrameImageFactory.getImage(type, image, parameter);
		default:
			return null;
		}

	}
}
