package br.com.fiap.capitalquest.model;

public class TipoEntrada {

    // Atributos correspondentes às colunas do banco
    private int codigo;      // CD_TIPO_ENTRADA
    private String nome;     // NM_TIPO_ENTRADA

    // Construtor padrão
    public TipoEntrada() {}

    // Construtor completo
    public TipoEntrada(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

