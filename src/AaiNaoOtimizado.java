import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AaiNaoOtimizado {

	public static void main(String[] args) {

		List<Integer> lista = preencheListaAleatorio(1000);// Vetor com zeros e um elemento 1
															// do tamanho passado no parametro

		// List<Integer> lista = preechePosicaoConhecida(19, 1);

		System.out.println(lista.toString());// Imprime o vetor que será varrido na busca.

		System.out.println("\nPosição resultante do elemento 1 na busca: " + procuraUmVetor(lista)
				+ "\n\nCaso o resultado seja -1, não existe o elemento no vetor.");

	}

	public static List<Integer> preencheListaAleatorio(int tam) {

		List<Integer> lista = new ArrayList<>();

		Random rnd = new Random();
		int posicaoRandom = rnd.nextInt(tam);
		System.out.println("Posição de prova em que o 1 está posicionado: " + posicaoRandom + "\n");

		for (int i = 0; i < tam; i++) {

			if (i == posicaoRandom)
				lista.add(1);
			else
				lista.add(0);

		}

		return lista;
	}

	private static List<Integer> preechePosicaoConhecida(int tamanho, int posicao) {

		List<Integer> lista = new ArrayList<>();

		for (int i = 0; i < tamanho; i++) {

			if (i == posicao)
				lista.add(1);
			else
				lista.add(0);
		}
		return lista;
	}

	public static int procuraUmVetor(List<Integer> lista) {

		int posicaoInicial;

		if (lista.size() % 2 == 0) {
			posicaoInicial = (lista.size() / 2) - 1;
		} else
			posicaoInicial = lista.size() / 2;

		System.out.println("\nPosição em que a busca começa: " + posicaoInicial);

		int qtPasso = 1;
		int posFinal = lista.size() - 1;
		int j = posicaoInicial;
		int i = j;

		do {

			int limiteI = i + qtPasso;

			for (i = j; i <= limiteI; i++) {

				if (i <= posFinal) {

					if (Integer.valueOf(1).equals(lista.get(i)))
						return i;
				} else
					break;

			}

			qtPasso++;
			i--;
			j = i;
			int limiteJ = j - qtPasso;

			for (j = i; j >= limiteJ; j--) {

				if (j >= 0) {
					if (Integer.valueOf(1).equals(lista.get(j)))
						return j;
				} else
					break;
			}

			qtPasso++;
			j++;
			i = j;

		} while (i <= posFinal || i >= 0);

		return -1;
	}

}
