package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;

import algorithm.basic.Clone;
import algorithm.factory.ImageFactory;

public class ImagePanel extends JPanel
{
	// ��ʾͼ��������
	public static final int MAX_IMAGE_WIDTH = 800;

	// ��ʾͼ�����󳤶�
	public static final int MAX_IMAGE_HEIGHT = 450;

	// ͼ�����ĵ�X
	public static final int IMAGE_CENTER_X = 640;

	// ͼ�����ĵ�Y
	public static final int IMAGE_CENTER_Y = 320;

	// ��ʾ��ͼ��
	protected BufferedImage displayImage;

	// ԭʼ��ͼ��
	protected BufferedImage sourceImage;

	// ���ű���
	protected float ratio;

	// ���x����
	protected int x;

	// ���y����
	protected int y;

	// �������
	protected int canvasWidth;

	// �����߶�
	protected int canvasHeight;

	public int getCanvasWidth()
	{
		return canvasWidth;
	}

	public void setCanvasWidth(int width)
	{
		this.canvasWidth = width;
	}

	public int getCanvasHeight()
	{
		return canvasHeight;
	}

	public void setCanvasHeight(int height)
	{
		this.canvasHeight = height;
	}

	public ImagePanel(BufferedImage image)
	{
		initDisplayImage(image);
		initSourceImage(image);

		calRatio(MAX_IMAGE_WIDTH, MAX_IMAGE_HEIGHT);
		calSizeAndPos(IMAGE_CENTER_X, IMAGE_CENTER_Y);

	}

	/**
	 * ��ʼ����ʾͼ�� ��Ҫ��ȸ������¿�¡��һ��
	 * 
	 * @param image
	 * */
	protected void initDisplayImage(BufferedImage image)
	{
		displayImage = Clone.getImage(image);
	}

	/**
	 * ��ʼ��Դͼ��
	 * 
	 * @param image
	 * */
	protected void initSourceImage(BufferedImage image)
	{
		sourceImage = image;
	}

	/**
	 * ��ȡsourceImage
	 * */
	public BufferedImage getSourceImage()
	{
		return sourceImage;
	}

	/**
	 * ��ȡdisplayImage
	 * */
	public BufferedImage getDisplayImage()
	{
		return displayImage;
	}

	/**
	 * ֱ�Ӹ���ͼ���ػ�
	 * 
	 * @param image
	 * */
	public void updateImage(BufferedImage image)
	{
		// TODO Auto-generated method stub
		displayImage = image;

		repaint();
	}

	/**
	 * ʹ�����ͺͲ�������ͼ��
	 * 
	 * @param type
	 * @param parameter
	 * */
	public void updateImage(int type, Object... parameter)
	{
		// TODO Auto-generated method stub
		displayImage = ImageFactory.getImage(type, sourceImage, parameter);

		repaint();
	}

	public void clear()
	{
		// TODO Auto-generated method stub
		getGraphics().clearRect(0, 0, canvasWidth, canvasHeight);
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(displayImage, 0, 0, canvasWidth, canvasHeight, null);

	}

	/**
	 * ����ratio
	 * */
	public void calRatio(int maxWidth, int maxHeight)
	{
		float ratioX = 1, ratioY = 1;

		if (displayImage.getWidth() > maxWidth)
		{
			ratioX = maxWidth * 1.0f / displayImage.getWidth();
		}

		if (displayImage.getHeight() > maxHeight)
		{
			ratioY = maxHeight * 1.0f / displayImage.getHeight();
		}

		ratio = ratioX < ratioY ? ratioX : ratioY;

	}

	/**
	 * ���¼���ͼƬ���Ƶ�λ�úʹ�С
	 * */
	public void calSizeAndPos(int centerX, int centerY)
	{
		canvasWidth = (int) (displayImage.getWidth() * ratio);
		canvasHeight = (int) (displayImage.getHeight() * ratio);

		x = centerX - canvasWidth / 2;
		y = centerY - canvasHeight / 2;

		setBounds(x, y, canvasWidth, canvasHeight);
		repaint();
	}

}
