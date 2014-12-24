package filter.frame;

import java.awt.image.BufferedImage;

import util.ImgUtil;

public class InstantFrameFilter extends FrameFilter
{

	@Override
	public BufferedImage getFrameImage()
	{
		// TODO Auto-generated method stub
		String fileName = "res/frame_instant.png";

		return ImgUtil.getImg(fileName);
	}

}
