A painting app programmed in Java using the Swing library and the Eclipse IDE
# Java Paint
![GUI Screenshot](https://github.com/m-zurkiyeh/JavaPaint/blob/main/misc_imgs/Screenshot%202023-11-03%20120635.png)


### Installation
Use any IDE or text editor that use java compilers and run it (Preferably Eclipse)

### Important Code
```
private ArrayList<Point> points = new ArrayList<>();
private ArrayList<Color> colors = new ArrayList<>();
private ArrayList<Integer> drawSizes = new ArrayList<>();
private ArrayList<Line> lines =  new ArrayList<>();
```
These arraylists are necessary to store the mouse inputs for drawing since Java swing does not retain the trails themselves


## Task List
- [ ] Fix line color change bug
- [ ] Add drag and draw shapes (start with just square and circle shapes)
- [ ] Add image import functionality
  - [ ] Add drag and drop functionality
- [ ] Add save and load file feature
