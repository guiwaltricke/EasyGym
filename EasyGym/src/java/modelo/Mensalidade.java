package modelo;

import java.util.Date;

public class Mensalidade {
    private Integer codigo;
    private Cliente cliente;
    private String descricao;
    private Date dataRef;
    private Date datapagto;
    private double valorpago;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDatapagto() {
        return datapagto;
    }

    public void setDatapagto(Date datapagto) {
        this.datapagto = datapagto;
    }

    public double getValorpago() {
        return valorpago;
    }

    public void setValorpago(double valorpago) {
        this.valorpago = valorpago;
    }
    
    public Date getDataRef() {
        return dataRef;
    }

    public void setDataRef(Date dataRef) {
        this.dataRef = dataRef;
    }    
}
