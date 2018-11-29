import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		//List<Integer> lista = preencheListaAleatorio(21);

		List<Integer> lista = preechePosicaoConhecida(19, 1);

		System.out.println(lista.toString());

		System.out.println("\n\n" + procuraUmVetor(lista));

	}

	public static List<Integer> preencheListaAleatorio(int tam) {

		List<Integer> lista = new ArrayList<>();

		Random rnd = new Random();
		int posicaoRandom = rnd.nextInt(tam);
		System.out.println("\n\n" + posicaoRandom);

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

	/*
	 * private static int procuraTrue(List<Integer> lista, int controleEsquerda, int
	 * controleDireita) {
	 * 
	 * int posição = 0;
	 * 
	 * 
	 * 
	 * 
	 * return posição; }
	 */

	public static int procuraUmVetor(List<Integer> lista) {

		int posicaoInicial;
		
		if (lista.size() % 2 == 0) {
			posicaoInicial = (lista.size() / 2) - 1;
		}else
			posicaoInicial = lista.size() / 2;
		
		System.out.println(posicaoInicial);

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

			qtPasso = qtPasso * 2;
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

			qtPasso = qtPasso * 2;
			j++;
			i = j;

		} while (i <= posFinal || i >= 0);

		return -1;
	}

}
