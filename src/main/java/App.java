import java.util.Scanner;

import static java.lang.String.format;
import static java.lang.System.out;

public class App {
    public static void main(String[] args) {
        // Lê os dados de entrada

        Scanner in = new Scanner(System.in);

        out.println("Digite a sequência de DNA:");
        String dnaSequence = in.nextLine();

        out.println("Digite o grupo a ser procurado:");
        String groupToFind = in.nextLine();

        // Grupo dos nucleotídeos valídos, usados nas validações abaixo

        String nucleotides = "CAGT";

        // Válida se os dados de entrada respeitam os nucleotídeos

        // Entrada da sequência
        for (int i = 0; i < dnaSequence.length(); i++) {
            if (nucleotides.indexOf(dnaSequence.charAt(i)) == -1) {
                out.println("Dados de entrada inválidos.");
                return;
            }
        }

        // O grupo para procurar tem que ter 3 caracteres
        if (groupToFind.length() != 3) {
            out.println("Dados de entrada inválidos.");
            return;
        }

        // O grupo também tem que respeitar os nucleotídeos
        for (int i = 0; i < groupToFind.length(); i++) {
            if (nucleotides.indexOf(dnaSequence.charAt(i)) == -1) {
                out.println("Dados de entrada inválidos.");
                return;
            }
        }

        // Procura o grupo dentro da sequência fornecida, pulando em 3 em 3, pois são grupos de 3
        for (int i = 0; i < dnaSequence.length() - 2; i += 3) {

            // Temos certeza que o grupo terá 3 caracteres, então podemos ir pegando
            // em 3 em 3, não precisamos de outro loop :)

            char firstNucleotide = dnaSequence.charAt(i);
            char secondNucleotide = dnaSequence.charAt(i + 1);
            char thirdNucleotide = dnaSequence.charAt(i + 2);

            // Testamos se os 3 caracteres acima estão na entrada do usuário, independente da ordem
            if (groupToFind.indexOf(firstNucleotide) > -1 &&
                    groupToFind.indexOf(secondNucleotide) > -1 &&
                    groupToFind.indexOf(thirdNucleotide) > -1) {

                // Achamos, o slot é a posição atual dividido por 3 (cada grupo tem 3)
                int slot = (i / 3) + 1;
                out.println(format("O grupo %s foi encontrado no slot %s", groupToFind, slot));

                // Podemos retornar, pois é apenas para retornar a primeira ocorrência
                return;
            }
        }

        // Se chegamos até aqui, é pq não encontramos
        out.println(format("O grupo %s não existe na sequência de DNA fornecida", groupToFind));
    }
}
