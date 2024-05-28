package br.com.fiap.tech_challenge.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_aparelho")
public class Aparelho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean estaReservado;
    private String nomeAparelho;
    private String modelo;
    private String observacao;
    private String timeResponsavel;
    private String quemReservou;

    public Aparelho() {}

    public Aparelho(Long id, boolean estaReservado, String nomeAparelho, String modelo, String observacao,
                    String timeResponsavel, String quemReservou) {
        this.id = id;
        this.estaReservado = estaReservado;
        this.nomeAparelho = nomeAparelho;
        this.modelo = modelo;
        this.observacao = observacao;
        this.timeResponsavel = timeResponsavel;
        this.quemReservou = quemReservou;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEstaReservado() {
        return estaReservado;
    }

    public void setEstaReservado(boolean estaReservado) {
        this.estaReservado = estaReservado;
    }

    public String getNomeAparelho() {
        return nomeAparelho;
    }

    public void setNomeAparelho(String nomeAparelho) {
        this.nomeAparelho = nomeAparelho;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getTimeResponsavel() {
        return timeResponsavel;
    }

    public void setTimeResponsavel(String timeResponsavel) {
        this.timeResponsavel = timeResponsavel;
    }

    public String getQuemReservou() {
        return quemReservou;
    }

    public void setQuemReservou(String quemReservou) {
        this.quemReservou = quemReservou;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aparelho aparelho = (Aparelho) o;
        return Objects.equals(id, aparelho.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Aparelho{" +
                "id=" + id +
                ", estaReservado=" + estaReservado +
                ", nomeAparelho='" + nomeAparelho + '\'' +
                ", modelo='" + modelo + '\'' +
                ", observacao='" + observacao + '\'' +
                ", timeResponsavel='" + timeResponsavel + '\'' +
                ", quemReservou='" + quemReservou + '\'' +
                '}';
    }
}
