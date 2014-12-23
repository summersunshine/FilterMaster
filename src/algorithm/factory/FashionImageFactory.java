package algorithm.factory;

import java.awt.image.BufferedImage;

import algorithm.fashion.Flare;
import algorithm.fashion.Parchment;
import algorithm.fashion.Photon;
import algorithm.fashion.Rainbow;
import app.Constants;

public class FashionImageFactory
{
	/**
	 * �������ͣ�ͼ�񣬲�����ȡ�µ�lomoͼ��
	 * 
	 * @param type
	 *            ����
	 * @param image
	 *            ͼ��
	 * @param paramter
	 *            ��������
	 * */
	public static BufferedImage getImage(int type, BufferedImage image, Object... parameter)
	{
		switch (type)
		{
		case (Constants.TYPE_RAINBOW):
			return Rainbow.getImage(image);
		case (Constants.TYPE_PHOTON):
			return Photon.getImage(image);
		case (Constants.TYPE_PARCHMENT):
			return Parchment.getImage(image);
		case (Constants.TYPE_FLARE):
			return Flare.getImage(image);
		default:
			return null;
		}
	}
}
