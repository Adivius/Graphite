import java.awt.event.*;

public class EventScreen extends Screen {

    ListenerKeyboardEdit listenerKeyboardEdit;
    ListenerMouseEdit listenerMouseEdit;

    public EventScreen(int width, int height, String title) {
        super(width, height, title);
    }

    public EventScreen(String title) {
        super(title);
    }

    @Override
    public void initListeners() {
        this.listenerKeyboardEdit = new ListenerKeyboardEdit();
        this.listenerMouseEdit = new ListenerMouseEdit();
        this.panel.addKeyListener(this.listenerKeyboardEdit);
        this.panel.addMouseListener(this.listenerMouseEdit);
        this.panel.addMouseMotionListener(this.listenerMouseEdit);
        this.panel.addMouseWheelListener(this.listenerMouseEdit);
    }

    public void editKeyPressed(KeyEvent e) {

    }

    public void editKeyReleased(KeyEvent e) {

    }

    public void editKeyTyped(KeyEvent e) {

    }

    public void editMouseMoved(MouseEvent e) {

    }

    public void editMousePressed(MouseEvent e) {

    }

    public void editMouseClicked(MouseEvent e) {

    }

    public void editMouseReleased(MouseEvent e) {

    }

    public void editMouseEntered(MouseEvent e) {

    }

    public void editMouseExited(MouseEvent e) {

    }

    public void editMouseDragged(MouseEvent e) {

    }

    public void editMouseWheelMoved(MouseWheelEvent e) {

    }

    public class ListenerKeyboardEdit extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            EventScreen.this.editKeyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
            EventScreen.this.editKeyReleased(e);
        }

        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
            EventScreen.this.editKeyTyped(e);
        }
    }

    public class ListenerMouseEdit extends MouseAdapter {
        @Override
        public void mouseMoved(MouseEvent e) {
            super.mouseMoved(e);
            EventScreen.this.editMouseMoved(e);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            EventScreen.this.editMousePressed(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mousePressed(e);
            EventScreen.this.editMouseReleased(e);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            EventScreen.this.editMouseEntered(e);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            EventScreen.this.editMouseExited(e);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
            EventScreen.this.editMouseDragged(e);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            EventScreen.this.editMouseClicked(e);
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            super.mouseWheelMoved(e);
            EventScreen.this.editMouseWheelMoved(e);
        }
    }

}
