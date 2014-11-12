package gui.partmosaic;

import gui.ImagePanel;
import gui.blur.BlurSetting;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import util.ImgUtil;
import algorithm.Constants;
import algorithm.FunImageFactory;
import algorithm.basic.Clone;
import algorithm.basic.Erase;
import algorithm.fun.Mosaic;

public class PartMosaicImagePanel extends ImagePanel implements MouseListener, MouseMotionListener
{

	// 原始图像
	public BufferedImage sourceImage;

	// 鼠标是否进入
	public boolean isMouseEntered;

	// 显示的x坐标
	private int displayX;

	// 显示的y坐标
	private int displayY;

	public PartMosaicImagePanel(BufferedImage image)
	{

		super(image);

		sourceImage = image;
		isMouseEntered = false;

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		setCircleCursor();
	}

	/**
	 * 设置光标为圆形
	 * */
	public void setCircleCursor()
	{
		// TODO Auto-generated method stub
		System.out.println("change cursor");

		BufferedImage image = ImgUtil.getImg("res/circle.png");

		Toolkit tk = Toolkit.getDefaultToolkit();

		Cursor cursor = tk.createCustomCursor(image, new Point(16, 16), "blur");

		setCursor(cursor);
	}

	/**
	 * 根据涂抹的位置更新图像
	 * 
	 * @param x
	 * @param y
	 * */
	private void updateImage(int x, int y)
	{
		displayX = (int) (x / ratio);
		displayY = (int) (y / ratio);

		if(PartMosaicSetting.type == Constants.TYPE_ERASE)
		{
			updateImage(Erase.getImage(displayImage, sourceImage, displayX, displayY, PartMosaicSetting.sizeValue));
		}
		else
		{
			updateImage(Mosaic.getImage(displayImage,PartMosaicSetting.patchValue, displayX, displayY, PartMosaicSetting.sizeValue));
		}
	}

	/**
	 * 依据patchValue更新图像
	 * 
	 * @param patchValue
	 *            马赛克块的大小
	 * */
	public void updateImage(int patchValue)
	{
		displayImage = Mosaic.getImage(sourceImage, patchValue);

		repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e)
	{
		updateImage(e.getX(), e.getY());
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		updateImage(e.getX(), e.getY());
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		isMouseEntered = true;
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		isMouseEntered = false;
		// System.out.println("mouse exit");
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

}
