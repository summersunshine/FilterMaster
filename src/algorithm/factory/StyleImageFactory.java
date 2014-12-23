package algorithm.factory;

import java.awt.image.BufferedImage;

import algorithm.style.RetroStyle;
import algorithm.style.DuskStyle;
import algorithm.style.YouthStyle;
import app.Constants;

public class StyleImageFactory
{

	/**
	 * �������ͣ�ͼ�񣬲�����ȡ�µķ��ͼ��
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
		case (Constants.TYPE_RETRO_STYLE):
			return RetroStyle.getImage(image);
		case(Constants.TYPE_DUSK_STYLE):
			return DuskStyle.getImage(image);
		case(Constants.TYPE_YOUTH_STYLE):
			return YouthStyle.getImage(image);
		default:
			return null;
		}

	}
}
