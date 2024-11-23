/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author guilherme
 */
@Entity
@Table(name = "revisao")
public class Revisao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private Date data;
    private double km;
    private String servicosrealizados;
    @JoinColumn(name = "ïdautomovel")
    @ManyToOne
    private Automovel idautomovel;

    public Revisao() {
    }

    public Revisao(Date data, double km, String servicosrealizados, Automovel idautomovel) {
        this.data = data;
        this.km = km;
        this.servicosrealizados = servicosrealizados;
        this.idautomovel = idautomovel;
    }

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public double getKm() {
        return km;
    }

    public String getServicosrealizados() {
        return servicosrealizados;
    }

    public Automovel getIdautomovel() {
        return idautomovel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public void setServicosrealizados(String servicosrealizados) {
        this.servicosrealizados = servicosrealizados;
    }

    public void setIdautomovel(Automovel idautomovel) {
        this.idautomovel = idautomovel;
    }

    @Override
    public String toString() {
        return "revisao{" + "id=" + id + ", data=" + data + ", km=" + km + ", servicosrealizados=" + servicosrealizados + ", idautomovel=" + idautomovel + '}';
    }

}
