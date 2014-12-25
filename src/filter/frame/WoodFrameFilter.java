package filter.frame;

import java.awt.image.BufferedImage;

import util.ImageUtil;

public class WoodFrameFilter extends FrameFilter
{

	@Override
	public BufferedImage getFrameImage()
	{
		// TODO Auto-generated method stub
		String fileName = "res/frame_wood.png";

		return ImageUtil.getImage(fileName);
	}

}
