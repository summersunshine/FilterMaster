package filter.Blur;

public class HorizontalBlurFilter extends InteractiveBlurFilter
{

	@Override
	public void processor()
	{
		// TODO Auto-generated method stub
		for (int y = HALF_MAX_MASK_SIZE; y < height - HALF_MAX_MASK_SIZE; y++)
		{
			int distance = Math.abs(y - centerY);

			for (int x = HALF_MAX_MASK_SIZE; x < width - HALF_MAX_MASK_SIZE; x++)
			{
				outputImage.setRGB(x, y, getRGBValue(x, y, distance));

			}
		}
	}

}
