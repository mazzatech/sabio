package com.sabio.util;
import java.awt.Graphics2D;   
import java.awt.Image;   
import java.awt.RenderingHints;   
import java.awt.image.BufferedImage;   
import java.io.BufferedOutputStream;   
import java.io.FileNotFoundException;   
import java.io.FileOutputStream;   
import java.io.IOException;   
import com.sun.image.codec.jpeg.ImageFormatException;   
import com.sun.image.codec.jpeg.JPEGCodec;   
import com.sun.image.codec.jpeg.JPEGEncodeParam;   
import com.sun.image.codec.jpeg.JPEGImageEncoder; 

public class RedimensionarImagem {
	
	
	public RedimensionarImagem(){
		
	}
 
    // Método para redimensionar imagens (criar thubmnails)   
    public void redimensionar(Image image, int width, int height, int quality, String nomeImagem) {   

        // Calculos necessários para manter as propoçoes da imagem, conhecido   
        // como "aspect ratio"   
        double thumbRatio = (double) width / (double) height;   
        int imageWidth = image.getWidth(null);   
        int imageHeight = image.getHeight(null);   
  
        double imageRatio = (double) imageWidth / (double) imageHeight;   
  
        if (thumbRatio < imageRatio) {   
            height = (int) (width / imageRatio);   
        } else {   
            width = (int) (height * imageRatio);   
        }   
        // Fim do cálculo   
  
        BufferedImage thumbImage = new BufferedImage(width, height,   
                BufferedImage.TYPE_INT_RGB);   
  
        Graphics2D graphics2D = thumbImage.createGraphics();   
  
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,   
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);   
  
        graphics2D.drawImage(image, 0, 0, width, height, null);   
  
        BufferedOutputStream out;   
  
        try {   
  
            out = new BufferedOutputStream(new FileOutputStream(nomeImagem));   
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);   
            JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(thumbImage);   
            quality = Math.max(0, Math.min(quality, 100));   
            param.setQuality((float) quality / 100.0f, false);   
            encoder.setJPEGEncodeParam(param);   
            encoder.encode(thumbImage);   
            out.close();   
  
        } catch (FileNotFoundException e) {   
            System.out.println("FileNotFoundException " + e.getMessage());   
        } catch (ImageFormatException e) {   
            System.out.println("ImageFormatException " + e.getMessage());   
        } catch (IOException e) {   
            System.out.println("IOException " + e.getMessage());   
        }   
    }  
}
