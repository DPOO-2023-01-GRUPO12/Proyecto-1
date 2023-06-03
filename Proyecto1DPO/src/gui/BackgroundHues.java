package gui;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

class BackgroundHues extends JComponent {

    private ImageIcon myPicture;
    private Icon img;
    private BufferedImage bufferedImage;
    
    public BackgroundHues(FrameHuesLogin frameHues) {

        // Imagen de fondo
	setPreferredSize(new Dimension(frameHues.getWidth(), frameHues.getHeight()));

        String[] pathNames = {".","Icons", "backHues.png" };
        String pathUsers = String.join(File.separator, pathNames);
        
        img = new ImageIcon(pathUsers);
        //myPicture = new ImageIcon(pathUsers);
        //add(new JLabel(myPicture));
        setVisible(true);
    }
    

    private void createImage() {
	if(img!=null) {
	    int width = getWidth();
	    int height = getHeight();
	    if(width>0&&height>0) {
		bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = bufferedImage.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		Rectangle rec = getAutoSize(img);
		g2d.drawImage(((ImageIcon)img).getImage(),rec.x,rec.y,rec.width,rec.height,null);
		g2d.dispose();
		//createBlurImage(bufferedImage,rec);
	    
	    }
	}
    }
    
    private void createBlurImage(BufferedImage bufferedImage2, Rectangle rec) {
	int x = 20;
	int y = 20;
	int width = 250;
	int height = 250;
	if(width>0&&height>0) {
	    //BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    int shadow = 8;
	    int kernelSize = 10;
	    float[] kernelData = new float[kernelSize * kernelSize];
	    Arrays.fill(kernelData, 1.0f / (kernelSize * kernelSize));
	    Kernel kernel = new Kernel(kernelSize, kernelSize, kernelData);
	        
	    ConvolveOp op = new ConvolveOp(kernel);
	    bufferedImage = op.filter(bufferedImage2, null);
	    Graphics2D g2d = bufferedImage.createGraphics();
	    
	    g2d.dispose();
	    g2d.drawImage(bufferedImage, rec.x, rec.y,rec.width,rec.height,null);
	}
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
	g.drawImage(bufferedImage, 0, 0, null);
        super.paintComponent(g);
    }
    
    @Override
    public void setBounds(int x, int y, int width, int height)
    {
        // TODO Auto-generated method stub
        super.setBounds(x, y, width, height);
        createImage();
    }
    
    private Rectangle getAutoSize(Icon image) {
	int w = getWidth();
	int h = getHeight();
	int iw = image.getIconWidth();
	int ih = image.getIconHeight();
	double xScale = (double) w/iw;
	double yScale = (double) h/ih;
	double scale = Math.max(xScale, yScale);
	int width = (int) (scale*iw);
	int height = (int) (scale*ih);
	if(width<1) {
	    width = 1;
	}
	if(height<1) {
	    height=1;
	}

	int x = (w - width)/2;
	int y = (h-height)/2;
	return new Rectangle(new Point(x,y),new Dimension(width,height));
    }

}