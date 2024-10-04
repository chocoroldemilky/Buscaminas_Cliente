package modules.views.components;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import modules.views.utils.ImageLoader;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import modules.views.utils.Colors;

public class CustomButton extends JButton {
    private Icon icon;
    private boolean pressed;
    private ImageLoader loader; // Instancia del cargador de imágenes
    private boolean flag;
    public CustomButton (int width, int height) {
        this.flag = false;
        this.setPreferredSize(new Dimension(width, height));
        this.loader = ImageLoader.getIntanceImageLoader(width, height);
        this.icon = this.loader.getImageClosedCell();
        
        setIcon(this.icon);
        setContentAreaFilled(false);
        setBorderPainted(false);
        
        addMouseListener(new MouseAdapter() {
           
           @Override
           public void mouseEntered(MouseEvent e) {
               setBorder(BorderFactory.createLineBorder(Colors.PURPLE));
           }
           
           @Override
           public void mouseExited(MouseEvent e) {
               setBorder(null);
           }
           
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger() || e.getButton() == MouseEvent.BUTTON3) {
                    toogleFlag();
                }
            }
        });
    }  
    
    public void updateCellMine () {
        this.icon = this.loader.getImageMine();
        setIcon(this.icon);
    }
    
    public void updateCellZero () {
        this.icon = this.loader.getImageZero();
        setIcon(this.icon);
    }
    
    public void updateCellOne () {
        this.icon = this.loader.getImageOne();
        setIcon(this.icon);
    }
    
    public void updateCellTwo () {
        this.icon = this.loader.getImageTwo();
        setIcon(this.icon);
    }
    
    public void updateCellThree () {
        this.icon = this.loader.getImageThree();
        setIcon(this.icon);
    }
    
    public void updateCellFour () {
        this.icon = this.loader.getImageFour();
        setIcon(this.icon);
    }
    
    public void updateCellFive () {
        this.icon = this.loader.getImageFive();
        setIcon(this.icon);
    }
    
    private void toogleFlag () {
        if (this.flag) {
            this.icon = this.loader.getImageClosedCell();
            this.flag = false;
        }
        
        else {
            this.icon = this.loader.getImageFlag();
            this.flag = true;
        }
        
        setIcon(this.icon);
    }
}
