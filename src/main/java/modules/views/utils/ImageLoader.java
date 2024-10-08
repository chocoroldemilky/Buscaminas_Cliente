package modules.views.utils;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;

import javax.swing.ImageIcon;

public class ImageLoader {
    private static ImageLoader instance;
    private Map<String, Icon> mapIcons;
    
    private ImageLoader(int width, int height) {
        mapIcons = new HashMap<>();
        
        String paths[] = {
            "/resources/celda_close.png",
            "/resources/abierta.png",
            "/resources/1.png",
            "/resources/2.png",
            "/resources/3.png",
            "/resources/4.png",
            "/resources/5.png",
            "/resources/bomba.png"
        };
        
        for (String path : paths) {
            ImageIcon imageIcon = new ImageIcon(ImageLoader.class.getResource(path));
            Image image = imageIcon.getImage();
            
            if (image == null) 
                System.out.println("No se pudo cargar la imagen " + path);
            else
                mapIcons.put(path, new ImageIcon(image.getScaledInstance(width - 20, height - 20, Image.SCALE_SMOOTH)));
        } 
    }
    
    public static ImageLoader getIntanceImageLoader (int width, int height) {
        if (instance == null) {
            instance = new ImageLoader(width, height);
        }
        return instance;
    }
    
    public static Icon setImageLabel(String root, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(ImageLoader.class.getResource(root));
        Image image = imageIcon.getImage();
        
        if (image == null) {
            System.out.println("No se pudo cargar la imagen correctamente");
        }
        return new ImageIcon(image.getScaledInstance(width - 20, height - 20, Image.SCALE_SMOOTH));
    }
    
    public Icon getImageClosedCell () {
        return mapIcons.get("/resources/celda_close.png");
    }
    
    public Icon getImageMine () {
        return mapIcons.get("/resources/bomba.png");
    }
    
    public Icon getImageZero () {
        return mapIcons.get("/resources/abierta.png");
    }
    
    public Icon getImageOne () {
        return mapIcons.get("/resources/1.png");
    }
    
    public Icon getImageTwo () {
        return mapIcons.get("/resources/2.png");
    }
    
    public Icon getImageThree () {
        return mapIcons.get("/resources/3.png");
    }
    
    public Icon getImageFour () {
        return mapIcons.get("/resources/4.png");
    }
    
    public Icon getImageFive () {
        return mapIcons.get("/resources/5.png");
    }
    
    public Icon getImage(String path) {
        return mapIcons.get(path);
    }
}
