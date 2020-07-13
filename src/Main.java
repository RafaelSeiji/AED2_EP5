import org.jfree.ui.RefineryUtilities;

import java.math.BigDecimal;
import java.util.*;


public class Main {
    protected ArrayList<Node> LLdataset;
    public static void main(String[] args){
        float tempo = java.lang.System.currentTimeMillis();
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        String caminho_txt = "C:\\Users\\rtoma\\Desktop\\Faculdade\\2020\\AED2\\EP4\\traducao2.txt";
        Structure grafo = new Structure(caminho_txt);
        int x = random.nextInt(grafo.getV()+1);
        grafo.addAresta(caminho_txt,grafo, x);
        System.out.println(x);
        int sucetiveis = grafo.getV();
        int infectados = 0;
        int recuperados = 0;
        int[] vetor = new int[3];
        vetor[0] = sucetiveis;
        vetor[1] = infectados;
        vetor[2] = recuperados;
        int v = 3640;
        ArrayList<Node> LLdataset = new ArrayList<>();
        contagio(grafo,v,10,100,vetor,LLdataset);
        System.out.println("Total: "+grafo.getV());
        System.out.println("Sucetiveis: "+vetor[0]);
        System.out.println("Infectados: "+vetor[1]);
        System.out.println("Recuperados: "+vetor[2]);


        final StackedBarChart stacked = new StackedBarChart("Stacked Bar Chart", vetor);
        stacked.pack();
        RefineryUtilities.centerFrameOnScreen(stacked);
        stacked.setVisible(true);

        LinearChart chart = new LinearChart(LLdataset);
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
        float tempoFim = System.currentTimeMillis();
        System.out.println("Tempo total: "+(tempoFim-tempo)/60000);

    }

    public static void contagio(Structure grafo, int v, int r, int c, int[] vetor, ArrayList<Node> LLdataset) {
        int cont = 0;
        System.out.println("Contagio");
        System.out.println("v: "+v);
        LinkedList<Vertice> queue = new LinkedList<Vertice>();
        vetor[0]--;//suc
        vetor[1]++;//rec
        grafo.lista.get(v).setState(1);//visitado
        queue.add(grafo.lista.get(v));//add na fila
        Random random = new Random();
        while(queue.size()!=0) {
            int y = random.nextInt(101);//dado contagio
            Vertice vv = queue.poll();
            System.out.println(vv.V);
            Iterator<Integer> i = vv.adj.listIterator();
            while (i.hasNext() && y <= c) {
                int n = i.next();
                if (grafo.lista.get(n).getState() == 0) {
                    vetor[0]--;
                    int x = random.nextInt(101);
                    if(x>=r) {//Não se recuperou
                        grafo.lista.get(n).setState(1);
                        vetor[1]++;
                        queue.add(grafo.lista.get(n));
                    }else{//Se recuperou
                        grafo.lista.get(n).setState(2);
                        vetor[2]++;//rec
                    }
                }
                /*
                String s = Integer.toString(cont);
                Node no = new Node(s,vetor[0],vetor[1],vetor[2]);
                cont++;
                LLdataset.add(no);
                   */
            }
            String s = Integer.toString(cont);
            Node no = new Node(s,vetor[0],vetor[1],vetor[2]);
            cont++;
            LLdataset.add(no);


        }
        System.out.println("cont: "+cont);

    }
}