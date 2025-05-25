package br.com.fiap.capitalquest.model;

import java.sql.Date;

public class Saida {
    private int codigo;
    private String descricao;
    private double valor;
    private int codigoTipoSaida;
    private int codigoCadastro;
    private Date data;

    // getters e setters
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    // outros getters e setters
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

    public int getCodigoTipoSaida() {
        return codigoTipoSaida;
    }

    public void setCodigoTipoSaida(int codigoTipoSaida) {
        this.codigoTipoSaida = codigoTipoSaida;
    }

    public int getCodigoCadastro() {
        return codigoCadastro;
    }

    public void setCodigoCadastro(int codigoCadastro) {
        this.codigoCadastro = codigoCadastro;
    }
}
