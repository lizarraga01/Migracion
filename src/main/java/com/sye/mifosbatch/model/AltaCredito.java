package com.sye.mifosbatch.model;

import com.google.gson.annotations.Expose;
import com.sye.mifosbatch.entity.Loan;

import lombok.Data;

@Data
public class AltaCredito {
    
    public AltaCredito(Loan loan){
        this.setCapitalInicial(loan.getCapitalinicial());
        this.setCodigoPostalVivienda(loan.getCodigopostalvivienda());
        this.setColoniaVivienda(loan.getColoniavivienda());
        this.setConvenio(loan.getConvenio());
        this.setDateFormat("dd/MM/yyyy");
        this.setDesmarcarCredito(loan.isDesmarcarcredito());
        this.setDireccionVivenda(loan.getDireccionvivenda());
        this.setEsMancomunado(loan.isEsmancomunado());
        this.setEsTitular(loan.isEstitular());
        this.setFechaDesembolso(loan.getFechadesembolso());
        this.setFechaFirma(loan.getFechafirma());
        this.setIdCliente(loan.getIdcliente());
        this.setIdConyugue(loan.getIdconyugue());
        this.setIdProducto(loan.getIdproducto());
        this.setIdSolicitud(loan.getIdsolicitud());
        this.setIdTipoAdjudicacion(loan.getIdtipoadjudicacion());
        this.setIdTipoCredito(loan.getIdtipocredito());
        this.setLocale("es_MX");
        this.setMarcarCredito(loan.isMarcarcredito());
        this.setNoCreditoAnterior(loan.getIdcreditosibadac().toString());
        this.setPlazo(loan.getPlazo());
        this.setPorcentajeDescuento(loan.getPorcentajedescuento());
        this.setPorcentajeDescuentoSAR(loan.getPorcentajedescuentoSAR());
        this.setStatusSHF(loan.getStatusshf());
        this.setSueldoBaseMensual(loan.getSueldobasemensual());
        this.setTasa(loan.getTasa());
    }

    @Expose
    private String noCreditoAnterior;
    @Expose
    private double capitalInicial;
    @Expose
    private double tasa;
    @Expose
    private int idCliente;
    @Expose
    private boolean esMancomunado;
    @Expose
    private boolean esTitular;
    @Expose
    private Long idConyugue;
    @Expose
    private String idSolicitud;
    @Expose
    private int plazo;
    @Expose
    private int idProducto;
    @Expose
    private int idTipoCredito;
    @Expose
    private String fechaDesembolso;
    @Expose
    private String fechaFirma;
    @Expose
    private int statusSHF;
    @Expose
    private int idTipoAdjudicacion;
    @Expose
    private int convenio;
    @Expose
    private String codigoPostalVivienda;
    @Expose
    private String direccionVivenda;
    @Expose
    private String coloniaVivienda;
    @Expose
    private int porcentajeDescuento;
    @Expose
    private int porcentajeDescuentoSAR;
    @Expose
    private double sueldoBaseMensual;
    @Expose
    private boolean desmarcarCredito;
    @Expose
    private boolean marcarCredito;
    @Expose
    private String locale;
    @Expose
    private String dateFormat;

    private Long idCredito;
    private String mensaje;

    public String getNoCreditoAnterior() {
        return noCreditoAnterior;
    }

    public void setNoCreditoAnterior(String noCreditoAnterior) {
        this.noCreditoAnterior = noCreditoAnterior;
    }

    public double getCapitalInicial() {
        return capitalInicial;
    }

    public void setCapitalInicial(double capitalInicial) {
        this.capitalInicial = capitalInicial;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public boolean isEsMancomunado() {
        return esMancomunado;
    }

    public void setEsMancomunado(boolean esMancomunado) {
        this.esMancomunado = esMancomunado;
    }

    public boolean isEsTitular() {
        return esTitular;
    }

    public void setEsTitular(boolean esTitular) {
        this.esTitular = esTitular;
    }

    public Long getIdConyugue() {
        return idConyugue;
    }

    public void setIdConyugue(Long idConyugue) {
        this.idConyugue = idConyugue;
    }

    public String getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(String idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdTipoCredito() {
        return idTipoCredito;
    }

    public void setIdTipoCredito(int idTipoCredito) {
        this.idTipoCredito = idTipoCredito;
    }

    public String getFechaDesembolso() {
        return fechaDesembolso;
    }

    public void setFechaDesembolso(String fechaDesembolso) {
        this.fechaDesembolso = fechaDesembolso;
    }

    public String getFechaFirma() {
        return fechaFirma;
    }

    public void setFechaFirma(String fechaFirma) {
        this.fechaFirma = fechaFirma;
    }

    public int getStatusSHF() {
        return statusSHF;
    }

    public void setStatusSHF(int statusSHF) {
        this.statusSHF = statusSHF;
    }

    public int getIdTipoAdjudicacion() {
        return idTipoAdjudicacion;
    }

    public void setIdTipoAdjudicacion(int idTipoAdjudicacion) {
        this.idTipoAdjudicacion = idTipoAdjudicacion;
    }

    public int getConvenio() {
        return convenio;
    }

    public void setConvenio(int convenio) {
        this.convenio = convenio;
    }

    public String getCodigoPostalVivienda() {
        return codigoPostalVivienda;
    }

    public void setCodigoPostalVivienda(String codigoPostalVivienda) {
        this.codigoPostalVivienda = codigoPostalVivienda;
    }

    public String getDireccionVivenda() {
        return direccionVivenda;
    }

    public void setDireccionVivenda(String direccionVivenda) {
        this.direccionVivenda = direccionVivenda;
    }

    public String getColoniaVivienda() {
        return coloniaVivienda;
    }

    public void setColoniaVivienda(String coloniaVivienda) {
        this.coloniaVivienda = coloniaVivienda;
    }

    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(int porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public int getPorcentajeDescuentoSAR() {
        return porcentajeDescuentoSAR;
    }

    public void setPorcentajeDescuentoSAR(int porcentajeDescuentoSAR) {
        this.porcentajeDescuentoSAR = porcentajeDescuentoSAR;
    }

    public double getSueldoBaseMensual() {
        return sueldoBaseMensual;
    }

    public void setSueldoBaseMensual(double sueldoBaseMensual) {
        this.sueldoBaseMensual = sueldoBaseMensual;
    }

    public boolean isDesmarcarCredito() {
        return desmarcarCredito;
    }

    public void setDesmarcarCredito(boolean desmarcarCredito) {
        this.desmarcarCredito = desmarcarCredito;
    }

    public boolean isMarcarCredito() {
        return marcarCredito;
    }

    public void setMarcarCredito(boolean marcarCredito) {
        this.marcarCredito = marcarCredito;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public Long getIdCredito() {
        return idCredito;
    }

    public void setIdCredito(Long idCredito) {
        this.idCredito = idCredito;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
