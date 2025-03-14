import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        int[] parametros;
        boolean inputInvalido = true;

        System.out.println("O modulo contador mostra a iteração do intervalo de dois numeros.");
        do {
            try{
                parametros = inputDados();
                contar(parametros[0],parametros[1]);

                inputInvalido = !inputInvalido;
            }
            catch(IOException|InputMismatchException e){
                System.out.println("Por favor, insira apenas valores numericos.\nTente novamente!");
            }
            catch (ParametrosInvalidosException e){
                System.out.println("O primeiro valor precisa ser menor que o segundo valor!\nTente novamente!");
            }
        }while(inputInvalido);
    }

    public static int[] inputDados() throws IOException, InputMismatchException {
        Scanner terminal = new Scanner(System.in);
        int[] entradaParametros = new int[2];
        System.out.println("Digite o primeiro parâmetro");
        entradaParametros[0] = terminal.nextInt();
        System.out.println("Digite o segundo parâmetro");
        entradaParametros[1] = terminal.nextInt();
        return entradaParametros;
    }

    public static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException{
        if( parametroUm > parametroDois ){
            throw new ParametrosInvalidosException();
        }else if(parametroUm==parametroDois){
            System.out.println("Parametros iguais, não há intervalo para iterações do contador.");
        }
        else{
            int contagem = parametroDois - parametroUm;
            System.out.println("Iniciando contagem de incremento do intervalo: "+parametroUm+"~"+parametroDois+"...");
            for (int i = 1; i<=contagem; i++){
                System.out.println("\niteração #"+i);
                System.out.println(parametroUm+" + "+(i)+" = "+(parametroUm+i));
            }
            System.out.println("Total de iterações: "+contagem);
        }
    }
}