import javax.swing.*;
import java.awt.*;

public class UI extends Box {

    private TextField tfCurrent;

    public UI() {
        super(1);
        setSize(new Dimension(500, 300));
        init();
    }

    private void init(){
        tfCurrent = new TextField();
        tfCurrent.setSize(new Dimension(100, 25));
        add(tfCurrent);
    }
}
