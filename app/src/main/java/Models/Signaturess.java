package Models;

public class Signaturess {
    private int id;
    private String descripcion;
    private String firma;

    public Signaturess(int id, String descripcion, String firma) {
        this.id = id;
        this.descripcion = descripcion;
        this.firma = firma;
    }

    public Signaturess(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }
}
