package lothel.soft.rrhh.model;

public class Cuenta {
    
    private int idCuenta;
    private String idUsuario;
    private String contrasnha;
    private TipoCuenta tipocuenta;

    public Cuenta(String idUsuario, String contrasnha, TipoCuenta tipocuenta) {
        this.idUsuario = idUsuario;
        this.contrasnha = contrasnha;
        this.tipocuenta = tipocuenta;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContrasnha() {
        return contrasnha;
    }

    public void setContrasnha(String contrasnha) {
        this.contrasnha = contrasnha;
    }

    public TipoCuenta getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(TipoCuenta tipocuenta) {
        this.tipocuenta = tipocuenta;
    }
    
    
    
}
