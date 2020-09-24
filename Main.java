import java.util.Scanner;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{

        Scanner input = new Scanner(System.in);

        //SALVA PALAVRA -------------------------
        System.out.println("\nDigite a Palavra: "); String palavra = input.next();

        //CONSTRUTOR EXPRESSOES PARA CHAMAR A CLASSE ------------
        Expressoes vai = new Expressoes(palavra);  
        vai.salvaTxt();       //SALVA TXT ------------
        vai.leTxt();          //LÊ TXT ------------

    }

}