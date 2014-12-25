package filter.Blur;

public class VerticalBlurFilter extends InteractiveBlurFilter
{

	@Override
	public void processor()
	{
		// TODO Auto-generated method stub
		for (int x = HALF_MAX_MASK_SIZE; x < width - HALF_MAX_MASK_SIZE; x++)
		{
			int distance = Math.abs(x - centerX);
			for (int y = HALF_MAX_MASK_SIZE; y < height - HALF_MAX_MASK_SIZE; y++)
			{
				outputImage.setRGB(x, y, getRGBValue(x, y, distance));

			}
		}
	}

}
