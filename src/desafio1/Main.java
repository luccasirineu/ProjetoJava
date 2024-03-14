package desafio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import entities.Usuario;

public class Main {
	
	private static ArrayList<String> perguntas = new ArrayList<>();
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
             opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                	try {
                    cadastrarUsuario();
                	} catch (Exception e) {
                		System.out.println(e.getMessage());
                	}
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    cadastrarPergunta();
                    break;
                case 4:
                    listarPerguntas();
                    break;
                case 5:
                    pesquisarUsuario();
                    break;
                case 6:
                	deletarPergunta();
                	break;
                case 0:
                    System.out.println("Saindo do programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

   
	private static void exibirMenu() {
        System.out.println("Menu Principal:");
        System.out.println("1 - Cadastrar usuário");
        System.out.println("2 - Listar todos usuários cadastrados");
        System.out.println("3 - Cadastrar nova pergunta no formulário");
        System.out.println("4 - Listar perguntas");
        System.out.println("5 - Pesquisar usuário por nome ou idade ou email");
        System.out.println("6 - Deletar pergunta");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }
	
	

    private static void cadastrarUsuario() throws Exception {
        System.out.print("Digite o nome do usuário (min 10 caracteres): ");
        String nome = scanner.nextLine();
        if (nome.length() < 10) {
            throw new Exception("Nome deve ter no mínimo 10 caracteres.");
        }
        System.out.print("Digite a idade do usuário: ");
        int idade = scanner.nextInt();
        if (idade < 18) {
            throw new Exception("Usuário tem que ser maio de 18 anos.");
        }

        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Digite o email do usuário: ");
        String email = scanner.nextLine();
        if (!email.contains("@")) {
            throw new Exception("Email deve conter '@'.");
        }


        Usuario novoUsuario = new Usuario(nome, email, idade);
        usuarios.add(novoUsuario);

        System.out.println("Usuário cadastrado com sucesso!");
    }
    
    

    private static void listarUsuarios() {
        System.out.println("Lista de usuários cadastrados:");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println((i + 1) + " - " + usuarios.get(i).getNome());
        }
    }
    
    
    
    private static void pesquisarUsuario() {
        System.out.print("Digite o termo de busca (parte ou nome completo): ");
        String termoBusca = scanner.nextLine();

        ArrayList<Usuario> resultados = buscarUsuarios(termoBusca);

        if (resultados.isEmpty()) {
            System.out.println("Nenhum usuário encontrado para o termo de busca: " + termoBusca);
        } else {
            System.out.println("Resultados da busca:");
            for (Usuario usuario : resultados) {
                System.out.println(usuario);
            }
        }
    }
    
    

    private static ArrayList<Usuario> buscarUsuarios(String termo) {
        ArrayList<Usuario> resultados = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            if (usuario.getNome().toLowerCase().contains(termo.toLowerCase())) {
                resultados.add(usuario);
            }
        }

        // Ordenar os resultados por nome
        Collections.sort(resultados, (u1, u2) -> u1.getNome().compareToIgnoreCase(u2.getNome()));

        return resultados;
    }


    private static void cadastrarPergunta() {
		
    	System.out.println("Digite aqui sua pergunta: ");
    	String pergunta = scanner.nextLine();
    	perguntas.add(pergunta);
		
	}
    
    private static void listarPerguntas() {
    	for(int i = 0; i<perguntas.size(); i++) {
    		System.out.println(perguntas.get(i));
    	}
    }
    
    private static void deletarPergunta() {
        System.out.print("Digite o número da pergunta que deseja deletar: ");
        int numPergunta = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        if (numPergunta <= 4 || numPergunta > perguntas.size()) {
            System.out.println("Número de pergunta inválido.");
            return;
        }
        perguntas.remove(numPergunta - 1);
        
        System.out.println("Pergunta deletada com sucesso!");
    }
}



