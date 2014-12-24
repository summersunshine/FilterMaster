package gui.scrawl;

import gui.ImagePanelWithCursor;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import util.ImgUtil;
import algorithm.basic.Alpha;
import algorithm.basic.Erase;
import algorithm.basic.Merge;
import app.Constants;

public class ScrawlImagePanel extends ImagePanelWithCursor
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// Ϳѻ��ͼ��
	private BufferedImage		drawingImage;

	// ��һ����ʾ��x����
	private int					lastDisplayX;

	// ��һ����ʾ��y����
	private int					lastDisplayY;

	public ScrawlImagePanel(BufferedImage image)
	{
		super(image);
		// TODO Auto-generated constructor stub

		initDrawingImage();

	}

	/**
	 * ��ʼ��һ������alphaͨ����Ϳѻ��ͼ��
	 * */
	private void initDrawingImage()
	{
		int width = displayImage.getWidth();
		int height = displayImage.getHeight();
		drawingImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}

	@Override
	public void setCursorImage()
	{
		// TODO Auto-generated method stub
		cursorImage = ImgUtil.getImg("res/circle.png");
	}

	@Override
	public void setCursorRadius()
	{
		radius = ScrawlSetting.sizeValue;
	}

	/**
	 * ����갴��ʱ��¼������
	 * 
	 * @param e
	 * */
	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		super.mousePressed(e);
		lastDisplayX = (int) (e.getX() / ratio);
		lastDisplayY = (int) (e.getY() / ratio);
	}

	/**
	 * �Ȼ���һ��ԭʼͼ�� �ٻ���һ��Ϳѻ��ͼ��
	 * 
	 * @param g2
	 * */
	protected void paintImage(Graphics2D g2)
	{
		g2.drawImage(displayImage, 0, 0, canvasWidth, canvasHeight, null);
		g2.drawImage(drawingImage, 0, 0, canvasWidth, canvasHeight, null);
	}

	/**
	 * ����ͼ�� Ϳѻ���߲���
	 *
	 * @param x
	 * @param y
	 * */
	@Override
	public void updateImage(int x, int y)
	{
		// TODO Auto-generated method stub
		System.out.println("update image");
		super.updateImage(x, y);

		if (ScrawlSetting.type == Constants.TYPE_ERASE)
		{
			erase();
		}
		else
		{
			paint();
		}

		lastDisplayX = displayX;
		lastDisplayY = displayY;
	}

	/**
	 * ����Ϳѻ
	 * */
	public void paint()
	{
		Graphics2D g2d = drawingImage.createGraphics();
		g2d.setPaint(ScrawlSetting.brushColor);

		g2d.setStroke(new BasicStroke(ScrawlSetting.sizeValue / ratio, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
		g2d.drawLine(displayX, displayY, lastDisplayX, lastDisplayY);
	}

	/**
	 * ������ΪԲ�Ĳ���Ϳѻ
	 * */
	public void erase()
	{
		drawingImage = Erase.getImage(drawingImage, displayX, displayY, ScrawlSetting.sizeValue);

	}

	/**
	 * ����ͼ���alphaֵ
	 * */
	public void updateAlpha()
	{

		drawingImage = Alpha.getImage(drawingImage, ScrawlSetting.alphaValue);

		repaint();
	}

	public void merge()
	{

		displayImage = Merge.getImage(displayImage, drawingImage);
		// try
		// {
		// ImageIO.write(drawingImage, "JPEG", new File("res/s.jpg"));
		// }
		// catch (IOException e)
		// {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

}
