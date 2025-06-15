package com.example.cifradecesar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CifraDeCesar {

    public static String cifraDeCesar(String mensagem, int deslocamento){
        if (mensagem.isEmpty()){ //verifica se a mensagem passada esta vazia
            return "Mensagem vazia!";
        }

         deslocamento = ((deslocamento % 26) + 26) % 26; // Normaliza o deslocamento

        StringBuilder resultado = new StringBuilder(); //String para colocar a mensagem cifrada
        
        for(int i=0; i<mensagem.length(); i++){ //percorre a mensagem recebida
            char c = mensagem.charAt(i);

            if(Character.isLetter(c)){ //verifica se o char na posição i é uma letra
                int inicio = Character.isLowerCase(c) ? 'a' : 'A'; //conversão para ASCII
                char cifrado = (char) ((c - inicio + deslocamento) % 26 + inicio); // calcula o deslocamento e já dá o char cifrado
                resultado.append(cifrado);
            } else {// se for um espaço ou símbolo apenas o coloca no resultado sem alterar
                resultado.append(c); 
            }           
        }

        return resultado.toString();
    }

    public static List<Map.Entry<Character, Integer>> contaFrequencia(String mensagem){

        Map<Character, Integer> frequencia = new HashMap<>();

        for (char c : mensagem.toUpperCase().toCharArray()) {//conta as ocorrencias de cada char
            if (Character.isLetter(c)) {
                frequencia.put(c, frequencia.getOrDefault(c, 0) + 1);
            }
        }

        List<Map.Entry<Character, Integer>> listaFrequencia = new ArrayList<>(frequencia.entrySet());

        listaFrequencia.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));//ordena a lista pelo numero de ocorrencias

        return listaFrequencia;
    }

    public static int deslocamentoEstimado(List<Map.Entry<Character, Integer>> listaFrequencia){
        //compara com a letra mais frequente da lingua portuguesa para estimar o deslocamento
        char letraMaisFrequente = listaFrequencia.get(0).getKey();
        int deslocamentoEstimado = (letraMaisFrequente - 'A') % 26;

        return deslocamentoEstimado;
    }

    public static int forcaBruta(String mensagemCifrada,String mensagem){
        //testa todas as chaves
        for (int i = 1; i <= 26; i++) {
        String tentativa = cifraDeCesar(mensagemCifrada, -i);
        if (tentativa.equalsIgnoreCase(mensagem)) {
            return i;
        }
    }
    return -1;
    }

    public static void cifraTeste(String mensagem, int deslocamento){
        String mensagemCifrada = cifraDeCesar(mensagem, deslocamento);

        System.out.println("mensagem Cifrada: "+mensagemCifrada);

        List<Map.Entry<Character, Integer>> listaFrequencia = contaFrequencia(mensagemCifrada);
        
        for (Map.Entry<Character, Integer> entrada : listaFrequencia) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }  
        
        int deslocamentoEstimado = deslocamentoEstimado(listaFrequencia);

        System.out.println("Deslocamento Estimado: " + deslocamentoEstimado);

        String mensagemDecriptada = cifraDeCesar(mensagemCifrada, -deslocamentoEstimado);

        System.out.println("Mensagem decriptada com deslocamento estimado: " + mensagemDecriptada);

        int deslocamentoFB = forcaBruta(mensagemCifrada, mensagem);
        System.out.println("Deslocamento encontrado por força bruta: " + deslocamentoFB);

        System.out.println("Mensagem decriptada com deslocamento força bruta: " + cifraDeCesar(mensagemCifrada, -deslocamentoFB));
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a mensagem original: ");
        String mensagem = scanner.nextLine();
        
        System.out.print("Digite o deslocamento (chave): ");
        int deslocamento = scanner.nextInt();

        cifraTeste(mensagem, deslocamento);
        
    }
}