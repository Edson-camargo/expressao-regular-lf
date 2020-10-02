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
    private String a2;

    Expressoes() {
        
        a1 = new ArrayList<String>();
        //a2+="(";

    }

    public void begin() throws IOException{
        System.out.print("\nDigite a Palavra: ");
        Scanner input = new Scanner(System.in);
        this.frase = input.nextLine();
        input.close();
        salvaTxt(frase);
        theFirst();
        theSecond();
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
        for(i=0; i<suporte.length;i++){
            if(((suporte[i] == '0') || (suporte[i] == '1'))){
                if(suporte[i] == '0'){a1.add("L(0)");a2+="L(0)";}                              
                if(suporte[i] == '1'){a1.add("L(1)");a2+="L(1)";}
            }
            if((suporte[i] == '*') || suporte[i] == '|'){
                if(suporte[i] == '*'){a1.add("*");a2+="*";}
                if(suporte[i] == '|'){a1.add("|");a2+="U";}
            }
        }
        a2+=")";
        System.out.println(a2);
        for(i=0;i<a1.size();i++){System.out.println(a1.get(i));}
        final FileWriter arq = new FileWriter("linguagem.txt", true);
        final PrintWriter gravarArq = new PrintWriter(arq);
        gravarArq.printf("\n"+a2);
        arq.close();
    }

    private void theSecond(){
        
    }

    public String getFrase(){
        return this.frase;
    }      

  /*public void setFrase(String frase){
        this.frase = frase;
    }*/        
}