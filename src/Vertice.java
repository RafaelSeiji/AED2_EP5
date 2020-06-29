

import java.util.LinkedList;

public class Vertice {

    protected int V;
    protected boolean color;
    protected LinkedList<Integer> adj;

    protected Vertice(int newV){

        this.V = newV;
        this.color = false;
        this.adj = new LinkedList<>();
    }
    protected void add(Integer i){
        this.adj.add(i);
    }
}