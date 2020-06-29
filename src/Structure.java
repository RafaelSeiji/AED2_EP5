
import java.io.*;
import java.util.*;



public class Structure {

    protected int V;
    protected LinkedList<LinkedList<Node>> lista;
    public int ini;

    protected Structure(String caminho){
        try {
            File arquivo = new File(caminho);
            Scanner sc = new Scanner(arquivo);
            V = sc.nextInt();
            sc.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        this.lista = new LinkedList();
        for (int i = 0; i < V+1; i++){
            this.lista.add(new LinkedList<Node>());
        }
    }

    protected void addAresta(String arquivo_txt_arestas ,Structure grafo, int r){
        try{
            File arquivo = new File(arquivo_txt_arestas);
            Scanner sc = new Scanner(arquivo);
            sc.nextLine();
            sc.nextLine();

            while (sc.hasNext()) {
                Node n = new Node();
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                if(v1==r) {
                    n.state = 1;
                    ini = v1;
                }
                n.v=v1;
                grafo.lista.get(v1).add(n);
                n.v=v2;
                grafo.lista.get(v2).add(n);
                System.out.print(v1+" "+v2);
                System.out.println();
            }
            sc.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    protected int getV(){
        return this.V;
    }
}