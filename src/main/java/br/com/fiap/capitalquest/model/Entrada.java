package br.com.fiap.capitalquest.model;

import java.sql.Date;

public class Entrada {
    private int codigo;
    private String descricao;
    private double valor;
    private int codigoTipoEntrada;
    private int codigoCadastro;
    private Date data; // Aqui, data é java.sql.Date

    // getters e setters
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    // outros getters e setters...
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
    public int getCodigoTipoEntrada() {
        return codigoTipoEntrada;
    }
    public void setCodigoTipoEntrada(int codigoTipoEntrada) {
        this.codigoTipoEntrada = codigoTipoEntrada;
    }
    public int getCodigoCadastro() {
        return codigoCadastro;
    }
    public void setCodigoCadastro(int codigoCadastro) {
        this.codigoCadastro = codigoCadastro;
    }
}
