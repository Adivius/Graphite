import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Screen extends JFrame {

    public JPanel panel;
    public Image image;

    public int cKeyId;
    public boolean cKeyboardPressed;
    public boolean cMousePressed;
    public int cMouseXPos;
    public int cMouseYPos;

    ListenerKeyboard listenerKeyboard;
    ListenerMouse listenerMouse;

    public Screen(int width, int height, String title) {
        super(title);
        this.panel = (JPanel) this.getContentPane();
        this.panel.setLayout(null);
        this.panel.setOpaque(true);
        initListeners();

        this.setResizable(false);
        this.setFocusable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(width, height));
        this.pack();

        this.image = this.createImage(width, height);

        this.setVisible(true);
        this.init2DGraphics();
        this.setBackgroundColor(Color.WHITE);
        this.setLocationRelativeTo(null);
        this.panel.requestFocus();
    }

    public Screen(String title) {
        this(1, 1, title);
        Dimension dimension = this.getToolkit().getScreenSize();
        this.changeSize(dimension.width - 20, dimension.height - 60);
    }

    public void initListeners() {
        this.listenerKeyboard = new ListenerKeyboard();
        this.listenerMouse = new ListenerMouse();
        this.panel.addKeyListener(this.listenerKeyboard);
        this.panel.addMouseListener(this.listenerMouse);
        this.panel.addMouseMotionListener(this.listenerMouse);
    }

    public void init2DGraphics() {
        Graphics2D g2d = (Graphics2D) this.getGraphicsFromPanel();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setComposite(AlphaComposite.Clear);
    }

    public Graphics getGraphicsFromPanel() {
        return this.image.getGraphics();
    }

    public Color getBackgroundColor() {
        return this.panel.getBackground();
    }

    public void setBackgroundColor(Color color) {
        this.getGraphics2D().setBackground(color);
        this.getGraphics2D().clearRect(0, 0, this.getWidth(), this.getHeight());
        this.panel.validate();
    }

    public void changeSize(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        this.pack();
    }

    public void clear() {
        this.repaint();
    }

    public void exitProgram() {
        this.dispose();
        System.exit(0);
    }

    public void release() {
        this.setTitle("The program has ended!");
        this.sleep(10);
        while (!this.cKeyboardPressed) {
            this.sleep(10);
        }
        this.exitProgram();
    }

    public void redraw() {
        this.panel.getGraphics().drawImage(this.image, this.panel.getX(), this.panel.getY(), this.panel);
    }

    public void paint(Graphics g) {
        if (this.image != null) {
            g.drawImage(this.image, this.panel.getX(), this.panel.getY(), this.panel);
        } else {
            super.paint(g);
        }
    }

    public int getKeyId() {
        return cKeyId;
    }


    public boolean isKeyboardPressed() {
        return cKeyboardPressed;
    }

    public boolean isMousePressed() {
        return cMousePressed;
    }

    public int getMouseXPos() {
        return cMouseXPos;
    }

    public int getMouseYPos() {
        return cMouseYPos;
    }

    public void sleep(int milliSeconds) {
        this.sleep(milliSeconds, 0);
    }

    public void sleep(int milliSeconds, int nanoSeconds) {
        try {
            Thread.sleep(milliSeconds, nanoSeconds);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public Graphics2D getGraphics2D() {
        return (Graphics2D) getGraphicsFromPanel();
    }

    public class ListenerKeyboard extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            Screen.this.cKeyboardPressed = true;
            Screen.this.cKeyId = e.getExtendedKeyCode();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
            Screen.this.cKeyboardPressed = false;
            Screen.this.cKeyId = -1;
        }
    }

    public class ListenerMouse extends MouseAdapter {
        @Override
        public void mouseMoved(MouseEvent e) {
            super.mouseMoved(e);
            Screen.this.cMouseXPos = e.getX();
            Screen.this.cMouseYPos = e.getY();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            Screen.this.cMouseXPos = e.getX();
            Screen.this.cMouseYPos = e.getY();
            Screen.this.cMousePressed = true;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mousePressed(e);
            Screen.this.cMouseXPos = e.getX();
            Screen.this.cMouseYPos = e.getY();
            Screen.this.cMousePressed = false;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            Screen.this.cMouseXPos = e.getX();
            Screen.this.cMouseYPos = e.getY();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            Screen.this.cMouseXPos = e.getX();
            Screen.this.cMouseYPos = e.getY();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
            Screen.this.cMouseXPos = e.getX();
            Screen.this.cMouseYPos = e.getY();
        }
    }

}
