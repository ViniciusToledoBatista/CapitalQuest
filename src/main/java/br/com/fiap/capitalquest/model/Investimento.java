package br.com.fiap.capitalquest.model;

import java.sql.Date;

public class Investimento {
    private int codigo;                  // CD_INVESTIMENTO
    private String descricao;            // DS_INVESTIMENTO
    private double valor;                // VL_INVESTIMENTO
    private Date data;                   // DT_INVESTIMENTO
    private int codigoTipoInvestimento;  // CD_TIPO_INVESTIMENTO
    private int codigoCadastro;          // CD_CADASTRO

    private TipoInvestimento tipoInvestimento;  // novo atributo para relacionamento

    // Getters e setters
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }

    public int getCodigoTipoInvestimento() {
        return codigoTipoInvestimento;
    }
    public void setCodigoTipoInvestimento(int codigoTipoInvestimento) {
        this.codigoTipoInvestimento = codigoTipoInvestimento;
    }

    public int getCodigoCadastro() {
        return codigoCadastro;
    }
    public void setCodigoCadastro(int codigoCadastro) {
        this.codigoCadastro = codigoCadastro;
    }

    public TipoInvestimento getTipoInvestimento() {
        return tipoInvestimento;
    }
    public void setTipoInvestimento(TipoInvestimento tipoInvestimento) {
        this.tipoInvestimento = tipoInvestimento;
    }
}
