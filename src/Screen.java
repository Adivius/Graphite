import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Screen extends JFrame {


    public final JPanel panel;
    public int cKeyId;
    public boolean cKeyboardPressed;
    public boolean cMousePressed;
    public int cMouseXPos;
    public int cMouseYPos;
    public int cHeight;
    public int cWidth;

    public Screen(int width, int height, String title) {
        super(title);
        this.cHeight = 0;
        this.cWidth = 0;
        this.panel = (JPanel) this.getContentPane();
        this.panel.setLayout(null);
        this.panel.addKeyListener(new ListenerKeyboard());
        this.panel.addMouseListener(new ListenerMouse());
        this.panel.addMouseMotionListener(new ListenerMouse());
        this.panel.setOpaque(true);


        if (width == -1) {
            Dimension dimension = this.getToolkit().getScreenSize();
            width = dimension.width - 20;
            height = dimension.height - 60;
        }

        this.setBounds(0, 0, width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setFocusable(true);
        this.changeWindowSize();
        this.setSize(this.getWidth() - this.cWidth + width, this.getHeight() - this.cHeight + height);

        this.init2DGraphics();
        this.setBackgroundColor(Color.WHITE);
        this.sleep(500);
        this.setLocationRelativeTo(null);
        this.panel.requestFocus();
    }

    public void init2DGraphics() {
        Graphics2D g2d = (Graphics2D) this.getGraphicsFromPanel();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
    }

    public Graphics getGraphicsFromPanel() {
        return this.panel.getGraphics();
    }

    public Color getBackgroundColor() {
        return this.panel.getBackground();
    }

    public void setBackgroundColor(Color color) {
        this.panel.setBackground(color);
        this.panel.getGraphics().clearRect(0, 0, this.cWidth, this.cHeight);
        this.panel.paintImmediately(this.panel.getBounds());
        this.panel.validate();
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

    public void changeWindowSize() {
        this.changeSize(this.panel.getVisibleRect().width, this.panel.getVisibleRect().height);

    }

    public void changeSize(int x, int y) {
        this.cWidth = x;
        this.cHeight = y;
    }

    public void paint(Graphics g) {
        super.paint(g);
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public boolean isKeyboardPressed() {
        this.sleep(10);
        return cKeyboardPressed;
    }

    public boolean isMousePressed() {
        this.sleep(10);
        return cMousePressed;
    }

    public int getMouseXPos() {
        this.sleep(10);
        return cMouseXPos;
    }

    public int getMouseYPos() {
        this.sleep(10);
        return cMouseYPos;
    }

    public void sleep(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

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
