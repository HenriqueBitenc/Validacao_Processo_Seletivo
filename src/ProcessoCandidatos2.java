import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Random;

public class ProcessoCandidatos2 {
    
    
    public static void main(String[] args) throws Exception {
        
        System.out.println("Processo Seletivo");
        selecaoCandidatos();

    }

    static void selecaoCandidatos(){

        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};
        int indiceCandidatoArray = 0;
        int candidatoSelecionado = 0;
        double salarioBase = 2000.0;
        ArrayList<String> candidatosAprovados = new ArrayList<>();
        
        while (candidatoSelecionado < 5 && indiceCandidatoArray < candidatos.length) {

                String candidato = candidatos[indiceCandidatoArray];
                double salarioPretendido = valorPretendido();
                System.out.println("Este candidato " + candidato + " Solicitou este valor de salário " + salarioPretendido);

                        if (salarioBase >= salarioPretendido) {
                            System.out.println("O candidato " + candidato + " foi selecionado para a vaga!");
                            candidatosAprovados.add(candidatos[indiceCandidatoArray]);
                            candidatoSelecionado++;  
                        }    

                indiceCandidatoArray++; 

        }

    imprimirSelecionados(candidatosAprovados);

    for (String candidato:candidatosAprovados){

        entrandoEmContato(candidato);
    }

    }

    static void entrandoEmContato(String candidato){

        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            }else{
                System.out.println("Contato realizado com sucesso!");
            }

        }while(continuarTentando && tentativasRealizadas<=3);

        if (atendeu) {
            System.out.println("Conseguimos contato com o candidato " + candidato + " na " + tentativasRealizadas + "ª tentativa.");
        }else{
            System.out.println("Não conseguimos contato com o candidato " + candidato);
        }

    }


    static double valorPretendido(){

        return ThreadLocalRandom.current().nextDouble(1800,2200);

    }

    static void imprimirSelecionados(ArrayList<String> candidatosAprovados){

        
        for( String candidato:candidatosAprovados){

            System.out.println("O candidato " + candidato + " foi aprovado!");
        }

    }

    static boolean atender(){

       return new Random().nextInt(3)==1;
        
    }
}