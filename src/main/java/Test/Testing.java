package Test;

import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import com.google.api.client.util.Base64;

public class Testing {
	
	
	
	   public static void main(String args[]) throws Exception{
	      BufferedImage bImage = ImageIO.read(new File("D:\\rose"));
	      ByteArrayOutputStream bos = new ByteArrayOutputStream();
	      ImageIO.write(bImage, "jpg", bos );
	      byte [] data = bos.toByteArray();
	      
	      byte[] base64 = Base64.encodeBase64(data);
	      System.out.println(base64);
	   }
	}
