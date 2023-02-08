import java.awt.*;

public class BufferedScreen extends EventScreen {

    public BufferedScreen(int width, int height, String title) {
        super(width, height, title);
    }

    public Graphics getGraphicsFromPanel() {
        return this.image.getGraphics();
    }

    public void setBackgroundColor(Color color) {
        this.getGraphics2D().setBackground(color);
        this.getGraphics2D().clearRect(0, 0, this.cWidth, this.cHeight);
        this.panel.validate();
    }

    public void paint(Graphics g) {
        if (this.image != null) {
            g.drawImage(this.image, this.getContentPane().getX(), this.getContentPane().getY(), this.getContentPane());
        } else {
            super.paint(g);
        }

    }

    public void redraw() {
        this.getContentPane().getGraphics().drawImage(this.image, this.getContentPane().getX(), this.getContentPane().getY(), this.getContentPane());
    }

}

