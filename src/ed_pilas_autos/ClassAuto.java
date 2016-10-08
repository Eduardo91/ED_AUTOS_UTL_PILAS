package ed_pilas_autos;
/**
 *
 * @author Eduardo
 */
public class ClassAuto {
private int placa;
private String marca;
private String modelo;
private int horaEntrada;
private double costoPorHora;

    public ClassAuto() {
    }

    public ClassAuto(int placa, String marca, String modelo, int horaEntrada, double costoPorHora) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.horaEntrada = horaEntrada;
        this.costoPorHora = costoPorHora;
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public double getCostoPorHora() {
        return costoPorHora;
    }

    public void setCostoPorHora(double costoPorHora) {
        this.costoPorHora = costoPorHora;
    }
    
    
    
}
