package algorithm;

import java.awt.image.BufferedImage;

import algorithm.style.RetroStyle;

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
		default:
			return null;
		}

	}
}
