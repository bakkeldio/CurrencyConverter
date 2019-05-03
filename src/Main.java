import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame root = new JFrame();
        root.setSize(500, 300);
        root.setVisible(true);
        UI myUI = new UI();
        myUI.setVisible(true);
        root.add(myUI);
    }
}
