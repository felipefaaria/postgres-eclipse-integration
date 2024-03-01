package app;

import java.util.List;
import java.util.Scanner;

import dao.DAO;
import dao.UsuarioDAO;
import model.Usuario;

public class Aplicacao {

    public static void main(String[] args) throws Exception {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Scanner scanner = new Scanner(System.in);

        int escolha;

        do {
            System.out.println("\n===== Menu =====");
            System.out.println("1) Listar");
            System.out.println("2) Inserir");
            System.out.println("3) Excluir");
            System.out.println("4) Atualizar");
            System.out.println("5) Sair");

            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    listarUsuarios(usuarioDAO);
                    break;
                case 2:
                    inserirUsuario(usuarioDAO);
                    break;
                case 3:
                    excluirUsuario(usuarioDAO);
                    break;
                case 4:
                    atualizarUsuario(usuarioDAO);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (escolha != 5);

        scanner.close();
    }

    private static void listarUsuarios(UsuarioDAO usuarioDAO) {
        System.out.println("\n==== Listar usuários === ");
        List<Usuario> usuarios = usuarioDAO.getSexoMasculino();
        for (Usuario u : usuarios) {
            System.out.println(u.toString());
        }
    }

    private static void inserirUsuario(UsuarioDAO usuarioDAO) throws Exception {
        System.out.println("\n==== Inserir usuário === ");
        Usuario usuario = new Usuario(11, "felipe", "silva", 'M');
        if (usuarioDAO.insert(usuario)) {
            System.out.println("Inserção com sucesso -> " + usuario.toString());
        }
    }

    private static void excluirUsuario(UsuarioDAO usuarioDAO) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n==== Excluir usuário ===\nDigite o código do usuário a ser excluído: ");
        int codigo = scanner.nextInt();
        usuarioDAO.delete(codigo);
        System.out.println("Usuário excluído com sucesso.");
    }

    private static void atualizarUsuario(UsuarioDAO usuarioDAO) throws Exception {
    	Usuario usuarioToUpdate = new Usuario(11, "felipe", "faria", 'M');
        if(usuarioDAO.update(usuarioToUpdate)) {
            System.out.println("Usuário atualizado com sucesso: " + usuarioToUpdate.toString());
        }
    }
}

