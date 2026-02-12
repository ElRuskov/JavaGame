package board;
public class Pawn {
    private Color color;
    private int pos = 0;

    public Pawn(Color color) {
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getPos() {
        return pos;
    }

    public void forward(int rollvalue) {
        pos=rollvalue;
    }
    public void backward(int rollvalue) {
        pos=rollvalue;
    }
}
