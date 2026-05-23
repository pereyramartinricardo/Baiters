public class BateriaInsuficiente extends RuntimeException {
    public BateriaInsuficiente(String patente) {
        super("Batería insuficiente");
    }

}
