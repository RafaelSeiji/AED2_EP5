

import org.jfree.ui.RefineryUtilities;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Random random = new Random();
        String caminho_txt = "C:\\Users\\rtoma\\Desktop\\Faculdade\\2020\\AED2\\EP4\\traducao2.txt";
        //LinkedList<BigInteger> lista = Arquivo.extrairIDs(caminho_txt);
        //HashMap mapa = Arquivo.extrairRazao(caminho_txt);
        Structure grafo = new Structure(caminho_txt);
        int x = random.nextInt(grafo.getV()+1);
        System.out.println(x);
        grafo.addAresta(caminho_txt,grafo, x);
        Scanner sc = new Scanner(System.in);
        System.out.println("Chance de recuperação(0-100): ");
        int r = sc.nextInt();
        System.out.println("Chances de contagio(0-100): ");
        int c = sc.nextInt();
        contagio(grafo, grafo.ini, r, c);

        //System.out.println("passou addAresta");
       // Grafico grafico =  new Grafico("Sai corona","Grau de conexoes na quarentena",grafo);
       // grafico.pack();
       // RefineryUtilities.centerFrameOnScreen(grafico);
        //grafico.setVisible(true);
    }
    public static void contagio(Structure grafo, int v, int r, int c){
        Random random = new Random();
        int x = random.nextInt(101);
        int y;
        if(x>r) {//Não se recuperou
            for (Node no : grafo.lista.get(v)) {//Visitar vizinhos
                if(no.getState()==0){//Pessoas suscetiveis
                    y = random.nextInt(101);
                    if(y<=c){//Contagio com exito
                        no.setState(1);
                        contagio(grafo, no.getV(),c,r);//Chamada recursiva
                    }
                }
            }
        }else{//Pessoa se recuperou
            Node no = new Node(v,3);
            grafo.lista.get(v).set(v,no);
        }
    }
}