import java.util.Scanner;

/**
 * Classe responsável pelo tratamento e leitura de valores inseridos pelo utilizador em terminal.
 *
 * @author IPOO
 * @version 2021/2022
 */
public class InputReader {

    private final Scanner reader;

    /**
     * Construtor da classe InputReader.
     */
    public InputReader() {
        reader = new Scanner(System.in);
    }

    /**
     * Formata a questão colocada ao utilizador.
     *
     * @param question
     */
    private void showFormattedQuestion(String question) {
        if (question == null) {
            question = "";
        }
        question += "> ";
        System.out.print(question);
    }

    /**
     * Permite obter um valor real de dupla precisão
     *
     * @param question
     * @return valor real (double) obtido
     */
    public double getRealNumber(String question) {
        showFormattedQuestion(question);

        while (!reader.hasNextDouble()) {
            reader.nextLine();
            showFormattedQuestion(question);
        }
        double number = reader.nextDouble();
        reader.nextLine();
        return number;
    }

    /**
     * Permite obter um valor inteiro
     *
     * @param question
     * @return valor inteiro introduzido
     */
    public int getIntegerNumber(String question) {
        showFormattedQuestion(question);

        while (!reader.hasNextInt()) {
            reader.nextLine();
            showFormattedQuestion(question);
        }
        int number = reader.nextInt();
        reader.nextLine();
        return number;
    }

    /**
     * Permite obter um valor textual.
     *
     * @param question
     * @return string com respetivo texto
     */
    public String getText(String question) {
        showFormattedQuestion(question);

        return reader.nextLine();
    }
}