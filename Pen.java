import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;

public class Pen {

    public static final int MODE_NORMAL = 0, MODE_SWITCH = 1;
    public static final int ROTATION_RIGHT = -90, ROTATION_LEFT = 90, ROTATION_AROUND = 180;
    public static final int ARC_OPEN = Arc2D.OPEN, ARC_PIE = Arc2D.PIE, ARC_CHORD = Arc2D.CHORD;

    public final Screen screen;
    public int xPos;
    public int yPos;
    public boolean cDrawing;
    public int cAngle;
    public Graphics2D g2d;
    public int cPaintMode;
    public int cThickness;

    public Pen(Screen screen) {
        this.screen = screen;
        initial2dGraphics();
        this.resetToDefault();
    }

    public void drawTriangle(int length) {
        boolean temp = this.cDrawing;
        this.down();
        for (int i = 0; i < 3; i++) {
            this.moveBy(length);
            this.rotateBy(-120);
        }
        this.cDrawing = temp;
    }

    public void resetToDefault() {
        this.cPaintMode = 0;
        this.xPos = 0;
        this.yPos = 0;
        this.cDrawing = false;
        this.cAngle = 0;
        this.cThickness = 1;
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        g2d.draw(new Line2D.Double(x1, y1, x2, y2));
    }

    public void initial2dGraphics() {
        Graphics2D graphics2D = (Graphics2D) screen.getGraphicsFromPanel();
        graphics2D.setStroke(new BasicStroke(1.0F, 0, 0));
        graphics2D.setPaint(Color.BLACK);
        g2d = graphics2D;
    }

    public Color getColor() {
        return g2d.getColor();
    }

    public void setColor(Color color) {
        g2d.setColor(color);
    }

    public void rotateBy(int angle) {
        this.setAngle(this.cAngle + angle);
    }

    public void rotate() {
        this.rotateBy(ROTATION_LEFT);
    }

    public Font getFont() {
        return this.g2d.getFont();
    }

    public void setFont(Font font) {
        this.g2d.setFont(font);
    }

    public void write(String text) {
        g2d.drawString(text, this.xPos, this.yPos);
    }

    public void moveTo(int x, int y) {
        if (this.cDrawing) {
            drawLine(xPos, yPos, x, y);
        }
        this.xPos = x;
        this.yPos = y;
    }

    public void down() {
        this.cDrawing = true;
    }

    public void up() {
        this.cDrawing = false;
    }

    public int getThickness() {
        return cThickness;
    }

    public void setThickness(int thickness) {
        g2d.setStroke(new BasicStroke((float) thickness, 0, 0));
        this.cThickness = thickness;
    }

    public void moveBy(int distance) {
        double a = this.cAngle * Math.PI / 180.0;
        double x = this.xPos + distance * Math.cos(a);
        double y = this.yPos - distance * Math.sin(a);
        this.moveTo((int) x, (int) y);
    }

    public void drawCircle(int radius) {
        g2d.draw(new Ellipse2D.Double(this.xPos - radius, this.yPos - radius, 2.0 * radius, 2.0 * radius));
    }

    public void drawArc(int width, int height, int startAngle, int endAngle, int mode) {
        g2d.draw(new Arc2D.Double(this.xPos, this.yPos, width, height, startAngle, endAngle, mode));
    }

    public void drawRectangle(int width, int height, int arch) {
        g2d.draw(new RoundRectangle2D.Double(this.xPos, this.yPos, width, height, arch, arch));
    }

    public void drawRectangle(int width, int height) {
        this.drawRectangle(width, height, 0);
    }

    public void moveToMousePos() {
        this.moveTo(screen.cMouseXPos, screen.cMouseYPos);
    }

    public void setModeNormal() {
        this.cPaintMode = MODE_NORMAL;
        g2d.setPaintMode();
    }

    public void setModeSwitch() {
        this.cPaintMode = MODE_SWITCH;
        g2d.setXORMode(screen.getBackgroundColor());
    }

    public void setColorBackground() {
        this.setColor(screen.getBackgroundColor());
    }

    public int getAngle() {
        return cAngle;
    }

    public void setAngle(int cAngle) {
        this.cAngle = cAngle % 360;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public int getPaintMode() {
        return cPaintMode;
    }


}
