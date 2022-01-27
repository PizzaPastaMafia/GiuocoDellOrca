import java.util.Random;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class Domandiere
{

    public static void InserisciValori(Domanda D, Player G1) throws IOException{
       
       String s;
       Random generator = new Random();
       
       int a = 1 + generator.nextInt(4); 
       int f = 1 + generator.nextInt(10);
       int cont = 0;
       if(a == 1){
               cont = 0;
           }else if(a == 2){
               cont = 10;    
           }else if(a == 3){
               cont = 20;
           }else if(a == 4){ 
               cont = 30;
           }
       
       while(G1.getSicurezza(cont+f-1) == true){
       
           a = 1 + generator.nextInt(4); 
           f = 1 + generator.nextInt(10);
           
           if(a == 1){
               cont = 0;
           }else if(a == 2){
               cont = 10;    
           }else if(a == 3){
               cont = 20;
           }else if(a == 4){ 
               cont = 30;
           }    
       
       }
       System.out.print("\n");
       FileReader e;
       BufferedReader b;
       e=new FileReader("A.txt");
       b=new BufferedReader(e);
       
       if(a == 1){
               
           e=new FileReader("A.txt");
           b=new BufferedReader(e);
           
       }else if(a == 2){
           
           e=new FileReader("B.txt");
           b=new BufferedReader(e);
           
       }else if(a == 3){
           
           e=new FileReader("C.txt");
           b=new BufferedReader(e);
           
       }else if(a == 4){
           
           e=new FileReader("D.txt");
           b=new BufferedReader(e); 
           
       }    
       
       for(int i = 1; i < f; i++){
           
           s=b.readLine();
           s=b.readLine();
           s=b.readLine();
           s=b.readLine();
           s=b.readLine();
           s=b.readLine();
           s=b.readLine();
           s=b.readLine();
           
       }
       
       s=b.readLine();
       D.setnumeroDomanda(s);
       s=b.readLine();
       D.setTitolo(s);
       s=b.readLine();
       D.setRisposte(1, s);
       s=b.readLine();
       D.setRisposte(2, s);
       s=b.readLine();
       D.setRisposte(3, s);
       s=b.readLine();
       D.setRisposte(4, s);
       s=b.readLine();
       D.setNumRisposta(Integer.parseInt(s));
       s=b.readLine();
       D.setPunti(Integer.parseInt(s));
       
       G1.setSicurezza(cont+f-1);
       
    }
}
