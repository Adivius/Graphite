import java.awt.*;

public class BufferedScreen extends EventScreen {

    public BufferedScreen(int width, int height, String title) {
        super(width, height, title);
    }

    public BufferedScreen(String title){
        super(title);
    }

    public Graphics getGraphicsFromPanel() {
        return this.image.getGraphics();
    }

    public void setBackgroundColor(Color color) {
        this.getGraphics2D().setBackground(color);
        this.getGraphics2D().clearRect(0, 0, this.getWidth(), this.getHeight());
        this.panel.validate();
    }

    public void paint(Graphics g) {
        if (this.image != null) {
            g.drawImage(this.image, this.panel.getX(), this.panel.getY(), this.panel);
        } else {
            super.paint(g);
        }

    }

    public void redraw() {
        this.panel.getGraphics().drawImage(this.image, this.panel.getX(), this.panel.getY(), this.panel);
    }

    @Override
    public void changeSize(int width, int height){
        super.changeSize(width, height);
        this.redraw();
    }

}

