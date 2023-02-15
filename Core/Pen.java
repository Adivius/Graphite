import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;

public class Pen {

    public static final int MODE_NORMAL = 0, MODE_SWITCH = 1;
    public static final int ROTATION_RIGHT = -90, ROTATION_LEFT = 90, ROTATION_AROUND = 180;
    public static final int ARC_OPEN = Arc2D.OPEN, ARC_PIE = Arc2D.PIE, ARC_CHORD = Arc2D.CHORD;

    private final Screen screen;
    private float xPos;
    private float yPos;
    private boolean cDrawing;
    private float cAngle;
    private Graphics2D g2d;
    private int cPaintMode;
    private float cThickness;
    private boolean cFillMode;

    public Pen(Screen screen) {
        this.screen = screen;
        init2DGraphics();
        this.resetToDefault();
    }

    public void resetToDefault() {
        this.cPaintMode = 0;
        this.xPos = 0.0f;
        this.yPos = 0.0f;
        this.cDrawing = false;
        this.cFillMode = false;
        this.cAngle = 0.0f;
        this.cThickness = 1.0f;
    }

    public void init2DGraphics() {
        Graphics2D graphics2D = (Graphics2D) screen.getGraphicsFromPanel();
        graphics2D.setStroke(new BasicStroke(1.0F, 0, 0));
        graphics2D.setPaint(Color.BLACK);
        g2d = graphics2D;
    }

    public void drawLine(float x1, float y1, float x2, float y2) {
        this.draw(new Line2D.Double(x1, y1, x2, y2));
    }

    public void drawTriangle(float length) {
        boolean temp = this.cDrawing;
        this.down();
        for (int i = 0; i < 3; i++) {
            this.moveBy(length);
            this.rotateBy(-120);
        }
        this.cDrawing = temp;
    }

    public void drawCircle(float radius) {
        this.draw(new Ellipse2D.Double(this.xPos - radius, this.yPos - radius, 2.0 * radius, 2.0 * radius));
    }

    public void drawArc(float width, float height, float startAngle, float endAngle, int mode) {
        this.draw(new Arc2D.Double(this.xPos, this.yPos, width, height, startAngle, endAngle, mode));
    }

    public void drawRectangle(float width, float height, float arch) {
        this.draw(new RoundRectangle2D.Double(this.xPos, this.yPos, width, height, arch, arch));
    }

    public void drawRectangle(float width, float height) {
        this.drawRectangle(width, height, 0);
    }

    private void draw(Shape shape) {
        if (this.cFillMode) {
            g2d.fill(shape);
        } else {
            g2d.draw(shape);
        }
    }

    public void write(String text) {
        g2d.drawString(text, this.xPos, this.yPos);
    }

    public void rotateBy(float angle) {
        this.setAngle(this.cAngle + angle);
    }

    public void rotate() {
        this.rotateBy(ROTATION_LEFT);
    }

    public void moveToMousePos() {
        this.moveTo(screen.cMouseXPos, screen.cMouseYPos);
    }

    public void moveBy(float distance) {
        float a = this.cAngle * (float) Math.PI / 180.0f;
        float x = this.xPos + distance * (float) Math.cos(a);
        float y = this.yPos - distance * (float) Math.sin(a);
        this.moveTo(x, y);
    }

    public void moveTo(float x, float y) {
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

    public float getThickness() {
        return cThickness;
    }

    public void setThickness(int thickness) {
        g2d.setStroke(new BasicStroke((float) thickness, 0, 0));
        this.cThickness = thickness;
    }

    public Font getFont() {
        return this.g2d.getFont();
    }

    public void setFont(Font font) {
        this.g2d.setFont(font);
    }

    public Color getColor() {
        return g2d.getColor();
    }

    public void setColor(Color color) {
        g2d.setColor(color);
    }

    public void setModeNormal() {
        this.cPaintMode = MODE_NORMAL;
        g2d.setPaintMode();
    }

    public void setModeSwitch() {
        this.cPaintMode = MODE_SWITCH;
        g2d.setXORMode(screen.getBackgroundColor());
    }

    public int getPaintMode() {
        return cPaintMode;
    }

    public void setColorBackground() {
        this.setColor(screen.getBackgroundColor());
    }

    public float getAngle() {
        return cAngle;
    }

    public void setAngle(float cAngle) {
        this.cAngle = cAngle % 360;
    }

    public float getXPos() {
        return xPos;
    }

    public float getYPos() {
        return yPos;
    }

    public boolean getFillMode() {
        return this.cFillMode;
    }

    public void setFillMode(boolean fillMode) {
        this.cFillMode = fillMode;
    }

    public Screen getScreen() {
        return this.screen;
    }

}
