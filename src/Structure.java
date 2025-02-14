
import java.io.*;
import java.util.*;



public class Structure {

    protected int V;
    protected LinkedList<Vertice> lista;
    public int ini;

    protected Structure(String caminho){
        try {
            File arquivo = new File(caminho);
            Scanner sc = new Scanner(arquivo);
            V = sc.nextInt();
            System.out.println(V);
            sc.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        this.lista = new LinkedList();
        for (int i = 0; i < V+1; i++){
            this.lista.add(new Vertice(i,0));
        }
    }

    protected void addAresta(String arquivo_txt_arestas ,Structure grafo, int r){
        try{
            File arquivo = new File(arquivo_txt_arestas);
            Scanner sc = new Scanner(arquivo);
            sc.nextLine();
            sc.nextLine();

            while (sc.hasNext()) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                Vertice n1 = new Vertice(v1,0);
                Vertice n2 = new Vertice(v2,0);
                grafo.lista.get(v1).add(n2.V);
                grafo.lista.get(v2).add(n1.V);
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