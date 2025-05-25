package br.com.fiap.capitalquest.model;

public class TipoSaida {

    // Atributos correspondentes às colunas do banco
    private int codigo;      // CD_TIPO_SAIDA
    private String nome;     // NM_TIPO_SAIDA

    // Construtor padrão
    public TipoSaida() {}

    // Construtor completo
    public TipoSaida(int codigo, String nome) {
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
