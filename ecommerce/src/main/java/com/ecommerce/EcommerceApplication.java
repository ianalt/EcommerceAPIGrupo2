package com.ecommerce;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ecommerce.controllers.CategoriaController;
import com.ecommerce.entities.Categoria;
import com.ecommerce.repositories.CategoriaRepository;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int opcaoMenu;

		SpringApplication.run(EcommerceApplication.class, args);

		// menu principal
		do {

			limpaTela();

			System.out.println("########################");
			System.out.println("E-commerce Sem Limites!");
			System.out.println("########################");

			System.out.println("\nDigite o valor da operação desejada:");
			System.out.println("\n\n");
			System.out.println("\t[0]\tSair");
			System.out.println("\t[1]\tOperações");
			System.out.println("\t[2]\tLogin");
			System.out.println("\t[3]\tCadastrar conta");

			System.out.println("Dígito: ");
			opcaoMenu = sc.nextInt();

			switch (opcaoMenu) {
			case 0:

				break;

			// menu de operações sem login
			case 1:

				int opcaoOperacoesNaoLogado;
				do {

					pulaLinha();

					System.out.println("\nDigite o valor da operação desejada:");
					System.out.println("\n\n");
					System.out.println("\t[0]\tVoltar");
					System.out.println("\t[1]\tVisualizar todas as categorias ");
					System.out.println("\t[2]\tVisualizar categoria especifica pelo nome");
					System.out.println("\t[3]\tCriar uma nova categoria");
					System.out.println("\t[4]\tEditar uma categoria");
					System.out.println("\t[5]\tDeletar uma categoria");
					System.out.println("\t[6]\tVisualizar todas os produtos ");
					System.out.println("\t[7]\tVisualizar produto especifico pelo nome");
					System.out.println("\t[8]\tCriar um novo produto (Com imagem)");
					System.out.println("\t[9]\tEditar um produto");
					System.out.println("\t[10]\tDeletar um produto");
					System.out.println("\t[11]\tVisualizar todos os pedidos");
					System.out.println("\t[12]\tExcluir algum pedido");

					System.out.println("Dígito: ");
					opcaoOperacoesNaoLogado = sc.nextInt();

					CategoriaController categoriaController = new CategoriaController();

					switch (opcaoOperacoesNaoLogado) {
					case 0:
						break;

					case 1:

//						for (Categoria categoria : listCategoria) {
//							System.out.println("Nome: " + categoria.getNome());
//							System.out.println("Descrição: " + categoria.getDescricao());
//						}

						break;
					case 2:

						System.out.println("Até aqui tudo bem =)");
						

						Categoria categoria = categoriaController.findByNome("Jogos").getBody();

						System.out.println("Até aqui tudo bem 2, a vingança =)");
						
						System.out.println("Nome: " + categoria.getNome());
						System.out.println("Descrição: " + categoria.getDescricao());

						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;
					case 6:
						break;
					case 7:
						break;
					case 8:
						break;
					case 9:
						break;
					case 10:
						break;
					case 11:
						break;
					case 12:
						break;
					}
				} while (opcaoOperacoesNaoLogado != 0);

				break;
			case 2:

				break;
			case 3:

				break;

			}
		} while (opcaoMenu != 0);

	}

	public static void pulaLinha() {
		System.out.println("\n\n\n");
	}

	public static void limpaTela() {
		for (int i = 1; i <= 25; ++i) {
			System.out.println("\n");
		}
	}

}
