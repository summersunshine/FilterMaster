package filter.frame;

import java.awt.image.BufferedImage;

import util.ImgUtil;

public class FilmFrameFilter extends FrameFilter
{

	@Override
	public BufferedImage getFrameImage()
	{
		// TODO Auto-generated method stub
		String fileName = "res/frame_simple.png";

		return ImgUtil.getImg(fileName);
	}

}
