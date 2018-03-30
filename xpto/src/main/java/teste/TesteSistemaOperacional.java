package teste;

import br.com.xpto.util.SistemaOperacional;

public class TesteSistemaOperacional {

	public static void main(String[] args) {

		// SO info:
		SistemaOperacional so = new SistemaOperacional();
		System.out.println("Descrição SO:" + so.obterDescricao());
		System.out.println("Usuário logado:" + so.obterNomeDeUsuarioLogado());
		System.out.println("Arquitetura SO:" + so.obterArquitetura());
	}
}
