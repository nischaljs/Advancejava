import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

class MyComponent extends JComponent {
    @override
    protected void paintComponents(Craphics g) {
        Graphics2D g2d = (Graphics2D);
        g2d.setColor(Color.RED);
        g2d.fillOval(10, 10, 100, 100);

    }

}

public class MyPaint extends JFrame {
    public MyPaint
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyComponent mComponent = new MyComponent();
        add(mComponent);
        pack();
        setVisible(true);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            new MyPaint();
        });
    }
}

classroom code:6
nbshrv
