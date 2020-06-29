import java.util.LinkedList;

public class Node {
    protected int v;
    protected int state = 0;

    protected Node(int v, int state) {
        this.v = v;
        this.state = state;
    }
    protected Node(){

    }
    protected int getState(){
        return this.state;
    }
    protected void setState(int state){
        this.state = state;
    }
    protected int getV(){
        return this.v;
    }
}

