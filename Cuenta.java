public class Cuenta {
    private double saldo = 0;
    private double ingreso;
    private double retirada;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public Double ingresar(double ingreso) {
        if (ingreso < 0 || ingreso > 6000) {
            saldo = 0;
        } else {
            saldo += ingreso;
        }
        return saldo;
    }

    public double retirar(double retirada) {
        if (!(retirada > saldo || retirada > 6000.00 || retirada < 0)) {
            this.saldo -= retirada;
        }
        return saldo;
    }

    public void transferencia(Cuenta receptor, double cantidad) {
        if (!(cantidad < 0 || cantidad > 3000)) {
            saldo = saldo - cantidad;
            receptor.ingresar(cantidad);
        }
    }
}
