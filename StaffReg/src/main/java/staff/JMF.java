package staff;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.media.Buffer;
import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;
import javax.media.Manager;
import javax.media.Player;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;

public class JMF {
    
    public static void main(String[] args) throws Exception 
    {
        CaptureDeviceInfo deviceInfo = CaptureDeviceManager.getDevice("vfw:Microsoft WDM Image Capture (Win32):0");
         
        Player player = null; 
        player = Manager.createRealizedPlayer(deviceInfo.getLocator());
        player.start();
        Thread.sleep(2500);
        FrameGrabbingControl frameGrabber = (FrameGrabbingControl)player.getControl("javax.media.control.FrameGrabbingControl");
        Buffer buf = frameGrabber.grabFrame();
 
        Image img = (new BufferToImage((VideoFormat)buf.getFormat()).createImage(buf));
        BufferedImage buffImg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImg.createGraphics();
        g.drawImage(img, null, null);
 
        g.setColor(Color.RED);
        //g.setFont(new Font("Verdana", Font.BOLD, 16));
        g.drawString((new Date()).toString(), 10, 25);
 
        ImageIO.write(buffImg, "png", new File("c:\\webcam.png"));
 
        player.close();
        player.deallocate();
        System.exit(0);
    }
}