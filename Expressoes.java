//FILEWRITER, IOEXCEPTION E PRINTWRITER PARA SALVAR O ARQUIVO -----------------
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Expressoes{

    private String frase;

    Expressoes() {
        

    }

    public void begin() throws IOException{

        System.out.print("\nDigite a Palavra: ");
        Scanner input = new Scanner(System.in);
        this.frase = input.nextLine();
        input.close();

        salvaTxt();
        leTxt();

    }
    
    //MÉTODO PARA SALVAR U-M-A LINHA NO .TXT ------------------------
    private void salvaTxt() throws IOException {

        final FileWriter arq = new FileWriter("linguagem.txt");
        final PrintWriter gravarArq = new PrintWriter(arq);
        gravarArq.printf(frase);
        arq.close();
        System.out.println("Arquivo Criado Com Sucesso!");

    }

    //MÉTODO QUE LÊ U-M-A LINHA SEM ESPAÇO --------------------------------------
    private void leTxt(){
      
       System.out.printf("\nConteúdo do arquivo texto:\t");

       try {

            FileReader arq = new FileReader("linguagem.txt");
            BufferedReader lerArq = new BufferedReader(arq); 

            String linha = lerArq.readLine(); 
            System.out.printf("%s\n\n", linha);

            arq.close();
        }

        catch (IOException e) {

            System.err.printf("Erro na abertura do arquivo: %s.\n",
            e.getMessage());
            
        }

    }


    public String getFrase(){

        return this.frase;

    }      


  /*public void setFrase(String frase){

        this.frase = frase;

    }*/ 
       
}