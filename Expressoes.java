//FILEWRITER, IOEXCEPTION E PRINTWRITER PARA SALVAR O ARQUIVO -----------------
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Expressoes{

    private String frase;
    private Integer flag=0;
    private char [] suporte;
    private ArrayList <String> a1;
    private ArrayList <String> a3;
    private ArrayList <String> a4;
    private ArrayList <String> a5;

    Expressoes() {
        
        a1 = new ArrayList<String>();
        a3 = new ArrayList<String>();
        a4 = new ArrayList<String>();
        a5 = new ArrayList<String>();

    }

    public void begin() throws IOException{
        System.out.print("\nDigite a Palavra: ");
        Scanner input = new Scanner(System.in);
        this.frase = input.nextLine();
        input.close();
        salvaTxt(frase);
        theFirst();
        theSecond();
        //theThird();
        //leTxt(); 
    }    
    
    //MÉTODO PARA SALVAR U-M-A LINHA NO .TXT ------------------------
    private void salvaTxt(String frase) throws IOException {
        if(flag==0){
            final FileWriter arq = new FileWriter("linguagem.txt", true);
            final PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf(frase);          
            arq.close();          
            flag++;
        }
        else{
            final FileWriter arq = new FileWriter("linguagem.txt", true);
            final PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf("\n"+frase);
            arq.close();
        }
    }

    //MÉTODO QUE LÊ U-M-A LINHA SEM ESPAÇO --------------------------------------
    private void leTxt(){      
       System.out.printf("\nConteúdo do arquivo texto:\t");
       try {
            FileReader arq = new FileReader("linguagem.txt");
            BufferedReader lerArq = new BufferedReader(arq); 
            while(lerArq.ready()){
                String linha = lerArq.readLine();
                System.out.println(linha);
            }
            /*String linha = lerArq.readLine(); 
            System.out.printf("%s\n\n", linha);*/
            arq.close();
        }
        catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
            e.getMessage());            
        }
    }

    private void theFirst() throws IOException{
        suporte  = frase.toCharArray();
        Integer i;       
        String a2=""; a2+="("; 
        for(i=0; i<suporte.length;i++){
            if(((suporte[i] == '0') || (suporte[i] == '1'))){
                if(suporte[i] == '0'){a1.add("L(0)");a2+="L(0)";}                              
                if(suporte[i] == '1'){a1.add("L(1)");a2+="L(1)";}
            }
            if((suporte[i] == '*') || suporte[i] == '|'){
                if(suporte[i] == '*'){a1.add("*");a2+="*";}
                if(suporte[i] == '|'){a1.add("U");a2+="U";}
            }
        }
        a2+=")";
        System.out.println(a2);
        //for(i=0;i<a1.size();i++){System.out.printf(a1.get(i));}
        salvaTxt(a2);
    }

    private void theSecond() throws IOException{
        Integer i, j=0, flag1=0;
        String a2=""; a2+="";
        String aux4="", aux5="";
        for(i=0;i<a1.size();i++){
            if((a1.get(i) == "L(0)") || (a1.get(i) == "L(1)")){
                a3.add("{");
                a2+="{";
                if(a1.get(i) == "L(0)"){a3.add("0");a2+="0";}
                if(a1.get(i) == "L(1)"){a3.add("1");a2+="1";}
                a2+="}";
                a3.add("}");
            }
            if((a1.get(i) == "*") || (a1.get(i) == "|")){
                if(a1.get(i) == "*"){a3.add("*");a2+="*";}
                if(a1.get(i) == "U"){a3.add("U");a2+="U";}
            }
        }
        salvaTxt(a2);
        System.out.printf("\nA3: \n");
        for(i=0;i<a3.size();i++){System.out.printf(a3.get(i));}
        
        while(j<2){
            for(i=0;i<a3.size();i++){
                if((a3.get(i) == "{") || (a3.get(i) == "}")){
                    if(a3.get(i) == "{"){a3.remove("{");}
                    if(a3.get(i) == "}"){a3.remove("}");}
                }
            }
        j++;
        }

        System.out.printf("\nA3: \n");
        for(i=0;i<a3.size();i++){System.out.printf(a3.get(i));}

        for(i=0;i<=a3.size();i++){
            if(i==a3.size()){a4.add("}");break;}
            if(flag1==0){
                a4.add("{");flag1++;
                if((a3.get(i)=="0")||(a3.get(i)=="1")){
                    a4.add(a3.get(i));
                }   
            }
            else{
                if((a3.get(i)=="0")||(a3.get(i)=="1")){
                    a4.add(a3.get(i));
                }
                if((a3.get(i)=="*")||(a3.get(i)=="U")){
                    a4.add("}");
                    a4.add(a3.get(i));
                    a4.add("{");
                }
            }
        }

        frase = a4.toString();
        salvaTxt(frase);

        System.out.printf("\nA4: \n");
        for(i=0;i<a4.size();i++){System.out.printf(a4.get(i));}       
    }

    /*private void theThird() throws IOException{
        Integer i;
        String a2;
        for(i=0;i<a3.size();i++){
            if(((a3.get(i) == "{0}") && (a3.get(i+1) == "*")) || ((a3.get(i) == "{1}") && (a3.get(i+1) == "*"))){
                a3.add("{e,");
                for(i=0;i<10.i++){
                    a3.add(0);
                }
            }            
        }
    }*/

    public String getFrase(){
        return this.frase;
    }      

  /*public void setFrase(String frase){
        this.frase = frase;
    }*/        
}