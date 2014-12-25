package filter.frame;

import java.awt.image.BufferedImage;

import util.image.ImageUtil;

public class InstantFrameFilter extends FrameFilter
{

	@Override
	public BufferedImage getFrameImage()
	{
		// TODO Auto-generated method stub
		String fileName = "res/frame_instant.png";

		return ImageUtil.getImage(fileName);
	}

}
