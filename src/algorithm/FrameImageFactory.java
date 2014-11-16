package algorithm;

import java.awt.image.BufferedImage;

import algorithm.art.OilPaint;
import algorithm.art.Pencil;
import algorithm.art.Sculpture;
import algorithm.art.Sketch;
import algorithm.art.StrokeArea;
import algorithm.frame.Frame;

public class FrameImageFactory
{

	/**
	 * �������ͣ�ͼ�񣬲�����ȡ�µ�������ͼ��
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
		case (Constants.TYPE_FRAME_WOOD):
			return Frame.getImage(image, 1);
		case (Constants.TYPE_FRAME_INSTANT):
			return Frame.getImage(image, 2);
		case (Constants.TYPE_FRAME_FILM):
			return Frame.getImage(image, 3);
		case (Constants.TYPE_FRAME_SIMPLE):
			return Frame.getImage(image, 4);
		default:
			return null;
		}

	}
}
