
import java.awt.Color;
import java.util.Date;

public class Evento {
    
    private Date fecha_inicio;
    private Date fecha_fin;
    private int hora_inicio;
    private int min_inicio;
    private String ampm_inicio;
    private int hora_fin;
    private int min_fin;
    private String ampm_fin;
    private String titulo;
    private String descripcion;
    private Color color;
    private String ocurrencia;
    private String notificaciones;
    
    
    public Evento(){
        this.fecha_inicio = null;
        this.fecha_fin = null;
        this.hora_inicio = 0;
        this.min_inicio = 0;
        this.ampm_inicio = null;
        this.hora_fin = 0;
        this.min_fin = 0;
        this.ampm_fin = null;
        this.titulo = null;
        this.descripcion = null;
        this.color = null;
        this.ocurrencia = null;
        this.notificaciones = null;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(int hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public int getMin_inicio() {
        return min_inicio;
    }

    public void setMin_inicio(int min_inicio) {
        this.min_inicio = min_inicio;
    }

    public String getAmpm_inicio() {
        return ampm_inicio;
    }

    public void setAmpm_inicio(String ampm_inicio) {
        this.ampm_inicio = ampm_inicio;
    }

    public int getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(int hora_fin) {
        this.hora_fin = hora_fin;
    }

    public int getMin_fin() {
        return min_fin;
    }

    public void setMin_fin(int min_fin) {
        this.min_fin = min_fin;
    }

    public String getAmpm_fin() {
        return ampm_fin;
    }

    public void setAmpm_fin(String ampm_fin) {
        this.ampm_fin = ampm_fin;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getOcurrencia() {
        return ocurrencia;
    }

    public void setOcurrencia(String ocurrencia) {
        this.ocurrencia = ocurrencia;
    }
    
    public String getNotificaciones(){
        return notificaciones;
    }
    
    public void setNotificaciones(String notificaciones){
        this.notificaciones = notificaciones;
    }

}
