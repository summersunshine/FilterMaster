package filter;

import java.awt.image.BufferedImage;

public abstract class Filter
{
	protected int			width;
	protected int			height;
	protected BufferedImage	image;
	protected BufferedImage	outputImage;

	public Filter()
	{

	}

	public BufferedImage getImage(BufferedImage image)
	{
		setImage(image);

		preProcessor();

		processor();

		// postProcessor();

		return outputImage;
	}

	abstract public void processor();

	// public void postProcessor();

	public void preProcessor()
	{
		outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

	}

	public void setImage(BufferedImage image)
	{
		this.image = image;
		this.setWidth(image.getWidth());
		this.setHeight(image.getHeight());
	}

	public BufferedImage getImage()
	{
		return image;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}
}
