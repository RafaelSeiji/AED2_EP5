

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Arquivo {

    protected static HashMap<BigInteger,Integer> extrairRazao(String caminho){
        File arquivo = new File(caminho);
        HashMap mapa = new HashMap();
        try{
            Scanner sc = new Scanner(arquivo);
            sc.nextInt();
            sc.nextInt();
            while (sc.hasNext()){
                int id = sc.nextInt();
                int pos = sc.nextInt();
                BigInteger aux = new BigInteger(String.valueOf(id));
                mapa.put(aux, Integer.parseInt(String.valueOf(pos)));
            }
            sc.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return mapa;
    }

    protected static LinkedList<BigInteger> extrairIDs(String caminho){
        File arquivo = new File(caminho);
        LinkedList lista = new LinkedList();
        lista.add(0);
        try{
            Scanner sc = new Scanner(arquivo);
            sc.nextInt();
            sc.nextInt();
            while (sc.hasNext()){
                BigInteger aux = new BigInteger(String.valueOf(sc.nextInt()));
                lista.add(aux);
                sc.nextInt();
            }
            sc.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return lista;
    }
}