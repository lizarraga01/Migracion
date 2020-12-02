package com.sye.mifosbatch.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="creditos")
public class Loan implements Serializable{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long idcreditosibadac;
    private double capitalinicial;
    private double tasa;
    private int idcliente;
    private boolean esmancomunado;
    private boolean estitular;
    private Long idconyugue;
    private String idsolicitud;
    private int plazo;
    private int idproducto;
    private int idtipocredito;
    private String fechadesembolso;
    private String fechafirma;
    private int statusshf;
    private int idtipoadjudicacion;
    private int convenio;
    private String codigopostalvivienda;
    private String direccionvivenda;
    private String coloniavivienda;
    private int porcentajedescuento;
    private int porcentajedescuentoSAR;
    private double sueldobasemensual;
    private boolean desmarcarcredito;
    private boolean marcarcredito;   
    @Id
    private Long id;
    private int idmifos;
    private String migrationdesc;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getIdcreditosibadac() {
        return idcreditosibadac;
    }

    public void setIdcreditosibadac(Long idcreditosibadac) {
        this.idcreditosibadac = idcreditosibadac;
    }

    public double getCapitalinicial() {
        return capitalinicial;
    }

    public void setCapitalinicial(double capitalinicial) {
        this.capitalinicial = capitalinicial;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public boolean isEsmancomunado() {
        return esmancomunado;
    }

    public void setEsmancomunado(boolean esmancomunado) {
        this.esmancomunado = esmancomunado;
    }

    public boolean isEstitular() {
        return estitular;
    }

    public void setEstitular(boolean estitular) {
        this.estitular = estitular;
    }

    public Long getIdconyugue() {
        return idconyugue;
    }

    public void setIdconyugue(Long idconyugue) {
        this.idconyugue = idconyugue;
    }

    public String getIdsolicitud() {
        return idsolicitud;
    }

    public void setIdsolicitud(String idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getIdtipocredito() {
        return idtipocredito;
    }

    public void setIdtipocredito(int idtipocredito) {
        this.idtipocredito = idtipocredito;
    }

    public String getFechadesembolso() {
        return fechadesembolso;
    }

    public void setFechadesembolso(String fechadesembolso) {
        this.fechadesembolso = fechadesembolso;
    }

    public String getFechafirma() {
        return fechafirma;
    }

    public void setFechafirma(String fechafirma) {
        this.fechafirma = fechafirma;
    }

    public int getStatusshf() {
        return statusshf;
    }

    public void setStatusshf(int statusshf) {
        this.statusshf = statusshf;
    }

    public int getIdtipoadjudicacion() {
        return idtipoadjudicacion;
    }

    public void setIdtipoadjudicacion(int idtipoadjudicacion) {
        this.idtipoadjudicacion = idtipoadjudicacion;
    }

    public int getConvenio() {
        return convenio;
    }

    public void setConvenio(int convenio) {
        this.convenio = convenio;
    }

    public String getCodigopostalvivienda() {
        return codigopostalvivienda;
    }

    public void setCodigopostalvivienda(String codigopostalvivienda) {
        this.codigopostalvivienda = codigopostalvivienda;
    }

    public String getDireccionvivenda() {
        return direccionvivenda;
    }

    public void setDireccionvivenda(String direccionvivenda) {
        this.direccionvivenda = direccionvivenda;
    }

    public String getColoniavivienda() {
        return coloniavivienda;
    }

    public void setColoniavivienda(String coloniavivienda) {
        this.coloniavivienda = coloniavivienda;
    }

    public int getPorcentajedescuento() {
        return porcentajedescuento;
    }

    public void setPorcentajedescuento(int porcentajedescuento) {
        this.porcentajedescuento = porcentajedescuento;
    }

    public int getPorcentajedescuentoSAR() {
        return porcentajedescuentoSAR;
    }

    public void setPorcentajedescuentoSAR(int porcentajedescuentoSAR) {
        this.porcentajedescuentoSAR = porcentajedescuentoSAR;
    }

    public double getSueldobasemensual() {
        return sueldobasemensual;
    }

    public void setSueldobasemensual(double sueldobasemensual) {
        this.sueldobasemensual = sueldobasemensual;
    }

    public boolean isDesmarcarcredito() {
        return desmarcarcredito;
    }

    public void setDesmarcarcredito(boolean desmarcarcredito) {
        this.desmarcarcredito = desmarcarcredito;
    }

    public boolean isMarcarcredito() {
        return marcarcredito;
    }

    public void setMarcarcredito(boolean marcarcredito) {
        this.marcarcredito = marcarcredito;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdmifos() {
        return idmifos;
    }

    public void setIdmifos(int idmifos) {
        this.idmifos = idmifos;
    }

    public String getMigrationdesc() {
        return migrationdesc;
    }

    public void setMigrationdesc(String migrationdesc) {
        this.migrationdesc = migrationdesc;
    }
}
