public class Command {
    private int x;
    private int y;

    public Command(){
        x=y=0;
    }
    public Command(int aX, int aY){
        setX(aX);
        setY(aY);
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int aX){
        if(aX<0)
            x=0;
        else
            x = aX;
    }
    public void setY(int aY){
        if(aY<0)
            y=0;
        else
            y=aY;
    }
    public String toString(){
        return getX()+", "+getY();
    }
}
