package org.example;
// Classe principal para testar os sistemas
public class Main {
    public static void main(String[] args) {
        // Teste do sistema da biblioteca
        Biblioteca biblioteca = new Biblioteca();
        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "12345");
        Livro livro2 = new Livro("Harry Potter", "Não sei", "32143");
        Membro membro1 = new Membro("João", 1, "joao@email.com");
        Membro membro2 = new Membro("Matheus", 2, "matheus@email.com");
        Membro membro3 = new Membro("Luan", 3, "luan@email.com");

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.registrarMembro(membro1);
        biblioteca.registrarMembro(membro2);
        biblioteca.registrarMembro(membro3);
        biblioteca.registrarEmprestimo(livro1, membro1);
        biblioteca.devolverLivro(livro1);
        biblioteca.registrarEmprestimo(livro2, membro2);
        biblioteca.registrarEmprestimo(livro1, membro3);
        biblioteca.visualizarBiblioteca();

        // Teste do sistema de pedidos do restaurante
        Pedido pedido1 = new Pedido(1, "Maria");
        Prato prato1 = new Prato("Pizza", 40.0, "Pizza de mussarela");
        Prato prato2 = new Prato("Hambúrguer", 25.0, "Hambúrguer artesanal");

        pedido1.adicionarPrato(prato1);
        pedido1.adicionarPrato(prato2);
        pedido1.visualizarPedido();
    }
}




