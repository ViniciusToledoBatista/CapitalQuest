package br.com.fiap.capitalquest.model;

public class TipoInvestimento {

    // Atributos correspondentes às colunas do banco
    private int codigo;      // CD_TIPO_INVESTIMENTO
    private String nome;     // NM_TIPO_INVESTIMENTO

    // Construtor padrão
    public TipoInvestimento() {}

    // Construtor completo
    public TipoInvestimento(int codigo, String nome) {
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
