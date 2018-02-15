package com.company;

import java.util.Scanner;

public class Main {


    public static int[][] computeTF(int mat[][], String p, String alf){
        int m=p.length();
        int al=alf.length();
        String pq="";
        String pk="";
        int k;
        for(int q=0;q<=m;q++){
            for(int a=0;a<al;a++){
                k=Math.min(m+1, q+2);
                if(q==0){
                    pq="" + alf.charAt(a);
                }
                else{
                    pq=p.substring(0, q) + alf.charAt(a);
                }
                //System.out.println(q + " - " + pq);
                if(q<p.length()){      //m
                    pk=p.substring(0, q+1);
                }else{
                    pk=p;
                }
                k--;
                while(k>m){ //quitar
                    k--;
                }
                while(!(pq.endsWith(pk))){
                    k--;
                    pk=pk.substring(0, pk.length()-1);
                }
                mat[q][a] = k;
            }
        }
        return mat;
    }

    public static void matcher(String t, String alf, int m, int [][] mat){
        int n=t.length();
        int q=0;
        int cont=0;
        for(int i=0;i<n;i++){
            q= mat[q][alf.indexOf(t.charAt(i))];
            if(q==m){
                cont++;
            }
        }
        System.out.println(cont);
    }



    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String alf = stdin.next();
        String p = stdin.next();
        String t = stdin.next();
        int[][] vacio= new int[(p.length()+1)][alf.length()];
        int[][] mat= computeTF(vacio,p,alf);
        int m=p.length();
        matcher(t,alf,m,mat);

    }
}
