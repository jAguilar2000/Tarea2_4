package Configuracion;

public class Transacciones {
    public static final String DBName = "TAREA2_4";
    public static final String TableSignatures = "signatures";
    public static final String id = "id";
    public static final String firmaDigital = "firmaDigital";
    public static final String descripcion = "descripcion";

    public static final String CreateTableSigantures = "Create table " + TableSignatures + " (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, firmaDigital TEXT, descripcion TEXT )";

    public static final String DropTableSignaturess = "DROP TABLE IF EXISTS "+ TableSignatures;

    public static final String SelectAllSignaturess = "SELECT * FROM " + TableSignatures;
}
