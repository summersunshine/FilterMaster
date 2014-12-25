package gui.scrawl;

import gui.base.ImagePanelWithCursor;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import util.image.Erase;
import util.image.ImageUtil;
import util.image.Merge;
import app.Constants;

public class ScrawlImagePanel extends ImagePanelWithCursor
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// 涂鸦层图像
	private BufferedImage		drawingImage;

	// 上一次显示的x坐标
	private int					lastDisplayX;

	// 上一次显示的y坐标
	private int					lastDisplayY;

	public ScrawlImagePanel(BufferedImage image)
	{
		super(image);
		// TODO Auto-generated constructor stub

		initDrawingImage();

	}

	/**
	 * 初始化一个具有alpha通道的涂鸦曾图像
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
		cursorImage = ImageUtil.getImage("res/circle.png");
	}

	@Override
	public void setCursorRadius()
	{
		radius = ScrawlSetting.sizeValue;
	}

	/**
	 * 在鼠标按下时记录下坐标
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
	 * 先绘制一层原始图像 再绘制一层涂鸦层图像
	 * 
	 * @param g2
	 * */
	protected void paintImage(Graphics2D g2)
	{
		g2.drawImage(displayImage, 0, 0, canvasWidth, canvasHeight, null);
		g2.drawImage(drawingImage, 0, 0, canvasWidth, canvasHeight, null);
	}

	/**
	 * 更新图像 涂鸦或者擦除
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
	 * 绘制涂鸦
	 * */
	public void paint()
	{
		Graphics2D g2d = drawingImage.createGraphics();
		g2d.setPaint(ScrawlSetting.brushColor);
		g2d.setStroke(getBasicStroke());
		g2d.drawLine(displayX, displayY, lastDisplayX, lastDisplayY);
	}

	/**
	 * 获取笔触
	 * */
	private BasicStroke getBasicStroke()
	{
		float width = ScrawlSetting.sizeValue / ratio;
		int cap = BasicStroke.CAP_ROUND;
		int join = BasicStroke.JOIN_BEVEL;
		return new BasicStroke(width, cap, join);
	}

	/**
	 * 以鼠标点为圆心擦除涂鸦
	 * */
	public void erase()
	{
		drawingImage = Erase.getImage(drawingImage, displayX, displayY, ScrawlSetting.sizeValue);

	}

	/**
	 * 更新图像的alpha值
	 * */
	public void updateAlpha()
	{

		drawingImage = ImageUtil.setImageAlpha(drawingImage, ScrawlSetting.alphaValue);

		repaint();
	}

	public void merge()
	{

		displayImage = Merge.getImage(displayImage, drawingImage);
	}

}
