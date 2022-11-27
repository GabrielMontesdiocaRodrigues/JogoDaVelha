package JogoDaVelha.src;

import java.util.Scanner;

public class jogoDaVelha {

    static Integer posições[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };

    public static void main(String[] args) {
        boolean ficar = true;
        final Integer reset[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };

        while (ficar) {

            System.out.println("Vamos jogar o o jogo da velha?");
            System.out.println("");
            desenhaTabuleiro(posições);
            jogo();
            posições = reset.clone();
            System.out.println("Pra jogar de novo digita 1");
            System.out.println("pra sair digita 2:");
            Scanner sair = new Scanner(System.in);
            int escolha = sair.nextInt();

            if (escolha == 2)
                ficar = false;

        }
    }

    public static void desenhaTabuleiro(Integer[] posições2) {

        System.out.println("");

        Integer posiçãoInicial[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };

        for (int i = 0; i < 9; i++) {

            if (posições2[i] == -1) {

                if (i == 2 || i == 5 || i == 8)
                    System.out.print("   X   ");
                else
                    System.out.print("   X   |");

            }
            if (posições2[i] == -2) {

                if (i == 2 || i == 5 || i == 8)
                    System.out.print("   O   ");
                else
                    System.out.print("   O   |");

            }

            if (posições2[i] == posiçãoInicial[i]) {

                if (i == 2 || i == 5 || i == 8)
                    System.out.print("   " + i + "   ");
                else
                    System.out.print("   " + i + "   |");

            }

            if (i == 2 || i == 5) {

                System.out.println("");
                System.out.println("______________________");
            }

        }

        System.out.println("");
        System.out.println("");

    }

    public static void jogo() {

        boolean z = true;

        while (z) {

            System.out.println("");
            System.out.println("Você é o X, pode escolher uma posição pra jogar");
            escolhePosiçao(1);
            z = resultadoEscrita(resultado(posições));
            if (z != true)
                break;
            System.out.println("Você é o O, pode escolher uma posição pra jogar");
            escolhePosiçao(2);
            z = resultadoEscrita(resultado(posições));

        }
    }

    public static void escolhePosiçao(Integer I) {

        boolean z = true;

        Scanner input = new Scanner(System.in);

        while (z) {
            int escolha = input.nextInt();

            for (int i = 0; i < 9; i++) {
                if (escolha == posições[i]) {
                    if (I == 1) {
                        posições[i] = -1;
                    } else
                        posições[i] = -2;
                    z = false;
                }
            }
            if (z != false) {
                System.out.println("Não é uma posição do tabuleiro, tente de novo");
                escolha = 0;
            }

        }
        desenhaTabuleiro(posições);

    }

    /**
     * @param posições2
     * @return
     */
    public static int[] resultado(Integer[] posições2) {

        int resultado = 0;
        int winner = 0;

        for (int i = 0; i < 7;) {

            if ((posições2[i] == posições2[i + 1]) && posições2[i] == posições2[i + 2]) {

                if (posições2[i] == -1)
                    winner = 1;
                else
                    winner = 2;
                resultado = 1;
                break;
            }
            i += 3;
        }

        for (int i = 0; i < 3;) {
            if (posições2[i] == posições2[i + 3] && posições2[i] == posições2[i + 6]) {

                if (posições2[i] == -1)
                    winner = 1;
                else
                    winner = 2;
                resultado = 1;
                break;
            }
            i++;
        }

        if (posições2[0] == posições2[4] && posições2[0] == posições2[8]) {
            if (posições2[0] == -1)
                winner = 1;
            else
                winner = 2;
            resultado = 1;
        }

        if (posições2[2] == posições2[4] && posições2[2] == posições2[6]) {
            if (posições2[2] == -1)
                winner = 1;
            else
                winner = 2;
            resultado = 1;
        }
        int z = 0;
        for (int i = 0; i < 9; i++) {
            if (posições2[i] == -1 || posições2[i] == -2) {
                z++;
                if (z == 9) {
                    winner = 0;
                    resultado = 3;
                }
            }
        }

        int retorno[] = { resultado, winner };
        return retorno;
    }

    public static boolean resultadoEscrita(int[] result) {

        boolean z = true;

        if (result[0] == 1) {
            if (result[1] == 1)
                System.out.println("Parabens, o X ganhou");
            else
                System.out.println("Parabens, o O ganhou");
            z = false;
        }
        if (result[0] == 3) {
            System.out.println("Visshh, deu velha");
            z = false;
        }
        return z;
    }

}
