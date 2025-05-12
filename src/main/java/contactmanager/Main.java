package contactmanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactManager cm = new ContactManager();
        try (Scanner sc = new Scanner(System.in)) {
            int option;

            do {
                System.out.println("\n=== AGENDA DE CONTATOS ===");
                System.out.println("1. Listar contatos");
                System.out.println("2. Adicionar contato");
                System.out.println("3. Editar contato");
                System.out.println("4. Remover contato");
                System.out.println("0. Sair");
                System.out.print("Escolha: ");
                option = sc.nextInt();
                sc.nextLine(); // limpar buffer

                switch (option) {
                    case 1:
                        cm.listContacts();
                        break;
                    case 2:
                        System.out.print("Nome: ");
                        String name = sc.nextLine();
                        System.out.print("Telefone: ");
                        String phone = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        cm.addContact(new Contact(name, phone, email));
                        break;
                    case 3:
                        cm.listContacts();
                        System.out.print("Número do contato para editar: ");
                        int idx = sc.nextInt() - 1;
                        sc.nextLine();
                        System.out.print("Novo nome: ");
                        name = sc.nextLine();
                        System.out.print("Novo telefone: ");
                        phone = sc.nextLine();
                        System.out.print("Novo email: ");
                        email = sc.nextLine();
                        cm.editContact(idx, new Contact(name, phone, email));
                        break;
                    case 4:
                        cm.listContacts();
                        System.out.print("Número do contato para remover: ");
                        idx = sc.nextInt() - 1;
                        cm.deleteContact(idx);
                        break;
                    case 0:
                        System.out.println("Encerrando...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } while (option != 0);
        }
    }
}
