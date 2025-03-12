package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

// Classe que representa um livro
class Livro {
    private String titulo;
    private String autor;
    private String ISBN;

    public Livro(String titulo, String autor, String ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getISBN() { return ISBN; }

    @Override
    public String toString() {
        return "Livro: " + titulo + ", Autor: " + autor + ", ISBN: " + ISBN;
    }
}

// Classe que representa um membro da biblioteca
class Membro {
    private String nome;
    private int id;
    private String email;

    public Membro(String nome, int id, String email) {
        this.nome = nome;
        this.id = id;
        this.email = email;
    }

    public String getNome() { return nome; }
    public int getId() { return id; }
    public String getEmail() { return email; }
}

// Classe que representa um empréstimo de livro
class Emprestimo {
    private Livro livro;
    private Membro membro;
    private Date dataEmprestimo;

    public Emprestimo(Livro livro, Membro membro) {
        this.livro = livro;
        this.membro = membro;
        this.dataEmprestimo = new Date();
    }

    public Livro getLivro() { return livro; }
    public Membro getMembro() { return membro; }
    public Date getDataEmprestimo() { return dataEmprestimo; }

    @Override
    public String toString() {
        return "Empréstimo - Livro: " + livro.getTitulo() + " | Membro: " + membro.getNome() + " | Data: " + dataEmprestimo;
    }
}

// Classe que gerencia a biblioteca
class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Membro> membros = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado: " + livro);
    }

    public void removerLivro(String ISBN) {
        livros.removeIf(livro -> livro.getISBN().equals(ISBN));
        System.out.println("Livro removido: ISBN " + ISBN);
    }

    public void registrarMembro(Membro membro) {
        membros.add(membro);
        System.out.println("Novo membro registrado: " + membro.getNome());
    }

    public void registrarEmprestimo(Livro livro, Membro membro) {
        Optional<Emprestimo> emprestimoExistente = emprestimos.stream()
                .filter(e -> e.getLivro().equals(livro))
                .findFirst();

        if (emprestimoExistente.isEmpty()) {
            Emprestimo emprestimo = new Emprestimo(livro, membro);
            emprestimos.add(emprestimo);
            System.out.println("Novo empréstimo registrado: " + emprestimo);
        } else {
            System.out.println("O livro já está emprestado.");
        }
    }

    public void devolverLivro(Livro livro) {
        emprestimos.removeIf(e -> e.getLivro().equals(livro));
        System.out.println("Livro devolvido: " + livro.getTitulo());
    }

    public void visualizarBiblioteca() {
        System.out.println("\n=== Biblioteca ===");

        System.out.println("Livros disponíveis:");
        livros.stream()
                .filter(livro -> emprestimos.stream().noneMatch(e -> e.getLivro().equals(livro)))
                .forEach(System.out::println);

        System.out.println("\nMembros cadastrados:");
        membros.forEach(membro -> System.out.println(membro.getNome() + " (ID: " + membro.getId() + ")"));

        System.out.println("\nEmpréstimos ativos:");
        emprestimos.forEach(System.out::println);
    }
}

// Classe que representa um prato do cardápio
class Prato {
    private String nome;
    private double preco;
    private String descricao;

    public Prato(String nome, double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public String getDescricao() { return descricao; }
}

// Classe que representa um pedido
class Pedido {
    private int numeroPedido;
    private String cliente;
    private List<Prato> listaDePratos = new ArrayList<>();

    public Pedido(int numeroPedido, String cliente) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
    }

    public void adicionarPrato(Prato prato) {
        listaDePratos.add(prato);
    }

    public void removerPrato(Prato prato) {
        listaDePratos.remove(prato);
    }

    public double calcularTotal() {
        return listaDePratos.stream().mapToDouble(Prato::getPreco).sum();
    }

    public void visualizarPedido() {
        System.out.println("\n=== Pedido ===");
        System.out.println("Pedido Nº: " + numeroPedido + " | Cliente: " + cliente);
        listaDePratos.forEach(prato -> System.out.println("- " + prato.getNome() + " (R$ " + prato.getPreco() + ")"));
        System.out.println("Total: R$ " + calcularTotal());
    }
}
