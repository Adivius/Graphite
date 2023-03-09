# Graphite  

Graphite is a simple library to draw 2d graphics on your screen in Java.
It uses a JFrame (JPanel) and its graphics to draw shapes and texts to 
create simple graphics. <br>
(Inspired by the [__SuM__](https://www.mg-werl.de/sum/) library.)

## Usage

```java
//Create a Screen:
Screen screen = new Screen(int width, int height, String title);

//Create a Pen and link it to the screen:
Pen pen = new Pen(Screen screen);

//Move the pen:
pen.moveBy(float distance);
pen.moveTo(float x, float y);
pen.moveToMousePos();

float pen.getXPos();
float pen.getYPos();

//Rotate the pen:
pen.rotateToMousePos();
pen.rotateBy(float rotation);
pen.rotateTo(float x, float y);
pen.rotate();
pen.setRotation(float cRotation);

float pen.getRotation();

//Put the pen to draw
pen.up();
pen.down();

boolean pen.isDrawing();

//Change the color of the pen:
pen.setColor(Color color);
pen.setColorToBackground();

Color pen.getColor();

//Draw a shape:
pen.drawLine(float x1, float y1, float x2, float y2);
pen.drawTriangle(float length);
pen.drawCircle(float radius);
pen.drawArc(float width, float height, float startRotation, float endRotation, int mode);
(arc_modes: ARC_OPEN / ARC_PIE / ARC_CHORD)
pen.drawRectangle(float width, float height, float arch);
pen.drawRectangle(float width, float height);

//Fill the shapes:
pen.setFillMode(boolean fillMode);

pen.boolean getFillMode();

//Switch drawing modes:
pen.setModeNormal();
pen.setModeSwitch();

int pen.getPaintMode();

//Write text:
pen.write(String text);
pen.setFont(Font font);

Font pen.getFont();

// !! UPDATE THE SCREEN AFTER DRAWING: !!
screen.redraw();

//Clear screen:
screen.clear();

//Change background:
screen.setBackgroundColor(Color color);

Color screen.getBackgroundColor();

//Make delay:
screen.sleep(int milliSeconds);
screen.sleep(int milliSeconds, int nanoSeconds);

//Change screen size:
screen.changeSize(int width, int height);

//End the program:
screen.release();

//Stop the program:
screen.exitProgram();


//Create an inheritance of EventScreen to edit the listeners for mouse and keyboard events
```

## TODO
    - Better write function
    - More tools
    - A way to edit font & font styles
    - Image loader

## Screenshots
![Screenshot.png](https://github.com/Adivius/Graphite/blob/main/Screenshot.png)

## License
[MIT](https://choosealicense.com/licenses/mit/)
