package Contest;

import javax.swing.*;
import java.awt.*;

public class Table extends JFrame {

    public Table(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setVisible(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        int x = (int)(toolkit.getScreenSize().getWidth()-this.getWidth())/2;

        int y = (int)(toolkit.getScreenSize().getHeight()-this.getHeight())/2;

        this.setLocation(x, y);
    }

    public static void main(String[] args) {
        new Table();
    }

}
