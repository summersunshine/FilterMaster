package gui.blur;

import gui.ImagePanelWithCursor;
import gui.main.MainFrame;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import util.ImgUtil;
import algorithm.Constants;
import algorithm.basic.Clone;
import algorithm.basic.Erase;
import algorithm.blur.DoubleGuassBlur;

public class BlurImagePanel extends ImagePanelWithCursor
{
	
	// 高斯模糊图像
	public BufferedImage guassBlurImage;
	

	public BlurImagePanel(BufferedImage image)
	{

		super(image);
		
		initGuassBlurImage(image);
	}

	@Override
	protected void initDisplayImage(BufferedImage image)
	{
		// TODO Auto-generated method stub
		displayImage = DoubleGuassBlur.getImage(image,BlurSetting.levelValue);
		
		//MainFrame.getInstance().setDisplayImage(Clone.getImage(displayImage));
	}

	@Override
	protected void initSourceImage(BufferedImage image)
	{
		// TODO Auto-generated method stub
		sourceImage = Clone.getImage(image);
	}

	protected void initGuassBlurImage(BufferedImage image)
	{
		// TODO Auto-generated method stub
		guassBlurImage = Clone.getImage(displayImage);
	}
	


	
	/**
	 * 更新模糊程度
	 * @param level
	 * */
	public void updateImage(int level)
	{
		guassBlurImage = DoubleGuassBlur.getImage(sourceImage,level);
		
		displayImage = Clone.getImage(guassBlurImage);
		
		repaint();
	}
	
	
	/**
	 * 根据涂抹的位置更新图像
	 * 
	 * @param x
	 * @param y
	 * */
	public void updateImage(int x, int y)
	{
		super.updateImage(x, y);
		
		System.out.println("update image");
		if(BlurSetting.type == Constants.TYPE_ERASE)
		{
			updateImage(Erase.getImage(displayImage, sourceImage, displayX, displayY, BlurSetting.sizeValue));
		}
		else
		{
			updateImage(Erase.getImage(displayImage,guassBlurImage, displayX, displayY, BlurSetting.sizeValue));
		}
		

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
	
	@Override
	public void setCursorImage()
	{
		// TODO Auto-generated method stub
		cursorImage = ImgUtil.getImg("res/circle.png");
	}

	@Override
	public void setCursorRadius()
	{
		radius = BlurSetting.sizeValue;
	}

}
