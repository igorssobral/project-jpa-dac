package br.edu.ifpb.dac.igorsobral.projetojpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifpb.dac.igorsobral.projetojpa.control.CursoController;
import br.edu.ifpb.dac.igorsobral.projetojpa.control.InstituicaoController;
import br.edu.ifpb.dac.igorsobral.projetojpa.entity.Curso;
import br.edu.ifpb.dac.igorsobral.projetojpa.entity.Instituicao;
import br.edu.ifpb.dac.igorsobral.projetojpa.read.Read;

@SpringBootApplication
public class ProjetoSpringDataJpaApplication implements CommandLineRunner {

	@Autowired
	private InstituicaoController instituicaoController;
	@Autowired
	private CursoController cursoController;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Read input = new Read();
		boolean loop = false;

		while (!loop) {
			System.out.println("1- Adicionar Instituição.\n" + "2- Listar todas.\n" + "3- Update.\n" + "4- Delete.\n"
					+ "5- Sair.");

			int opcao = Integer.parseInt(input.read());

			switch (opcao) {
			case 1: {

				System.out.print("nome da Instituição: ");
				String name = input.read();

				System.out.print("Telefone: ");
				String telefone = input.read();
				
				System.out.print("Email: ");
				String email = input.read();
				
				System.out.println("------Curso-----");
				System.out.print("Nome do Curso: ");
				String nome = input.read();

				System.out.println("Quantidade de Periodos: ");
				int periodos = Integer.parseInt(input.read());

				System.out.print("Carga Horaria: ");
				int cargaHoraria = Integer.parseInt(input.read());

				System.out.print("Mensalidade: ");
				double mensalidade = Double.parseDouble(input.read());

				

				Curso curso = cursoController.create(nome, periodos, cargaHoraria, mensalidade);

				instituicaoController.create(name, telefone, email, curso);
				break;

			}
			case 2: {
				List<Instituicao> lista = instituicaoController.read();
				for (Instituicao string : lista) {
					System.out.println(string.toString());
				}
				break;
			}
			case 3: {
				System.out.println("1- Atualizar Instituição.\n" + "2- Atualizar Curso");

				int op = Integer.parseInt(input.read());

				if (op == 1) {

					System.out.println("ÏD: ");

					int id = Integer.parseInt(input.read());
					System.out.print("nome da Instituição: ");
					String name = input.read();

					System.out.print("Telefone: ");
					String telefone = input.read();

					System.out.print("Email: ");
					String email = input.read();

					instituicaoController.update(name, telefone, email, id);
				} else if (op == 2) {

					System.out.println("ÏD: ");

					int id = Integer.parseInt(input.read());

					System.out.println("------Curso-----");
					System.out.print("Nome do Curso: ");
					String nome = input.read();

					System.out.println("Quantidade de Periodos: ");
					int periodos = Integer.parseInt(input.read());

					System.out.println("Carga Horaria: ");
					int cargaHoraria = Integer.parseInt(input.read());

					System.out.println("Mensalidade: ");
					double mensalidade = Double.parseDouble(input.read());

					cursoController.update(nome, cargaHoraria, periodos, mensalidade, id);
				} else {
					System.out.println("Opção Invalida");
				}

				break;
			}
			case 4: {
				System.out.println("Digite o ID do que você deseja excluir.");
				int opDell = Integer.parseInt(input.read());
				instituicaoController.delete(opDell);
			}
			case 5: {
				loop = true;
			}
			}
		}
	}

}
