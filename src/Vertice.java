

import java.util.LinkedList;

public class Vertice {

    protected int V;
    protected int state;
    protected LinkedList<Integer> adj;

    protected Vertice(int newV, int state){

        this.V = newV;
        this.state = state;
        this.adj = new LinkedList<>();
    }
    protected void add(Integer i){
        this.adj.add(i);
    }
    protected void setState(int state){
        this.state=state;
    }
    protected int getState(){
        return this.state;
    }
}
