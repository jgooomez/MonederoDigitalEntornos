import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class testCuentaTest {
    Cuenta c1 = new Cuenta();
    Cuenta c2 = new Cuenta();

    @Test
    void testCreaCuenta() {
        double esperado = 0;
        assertEquals(esperado,c1.getSaldo());
    }

    @Test
    void testIngresa100() {
        c1.ingresar(100);
        double esperado = 100;
        assertEquals(esperado,c1.getSaldo());
    }

    @Test
    void testIngresa300() {
        c1.ingresar(3000);
        double esperado = 3000;
        assertEquals(esperado,c1.getSaldo());
    }

    @Test
    void testIngresa3000() {
        c1.ingresar(100);
        c1.ingresar(3000);
        double esperado = 3100;
        assertEquals(esperado,c1.getSaldo());
    }

    @Test
    void testIngresaNegativo() {
        c1.ingresar(-100);
        double esperado = 0;
        assertEquals(esperado,c1.getSaldo());
    }

    @Test
    void testIngresaDecimales() {
        c1.ingresar(100.45);
        double esperado = 100.45;
        assertEquals(esperado,c1.getSaldo());
    }

    @Test
    void testIngresa6000() {
        c1.ingresar(6000);
        double esperado = 6000;
        assertEquals(esperado,c1.getSaldo());
    }

    @Test
    void testIngresa6001Error() {
        c1.ingresar(6001);
        double esperado = 0;
        assertEquals(esperado,c1.getSaldo());
    }

    @Test
    void testRetira100() {
        c1.ingresar(500);
        c1.retirar(100);
        double esperado = 400;
        assertEquals(esperado, c1.getSaldo());
    }

    @Test
    void testRetira500() {
        c1.ingresar(200);
        c1.retirar(500);
        double esperado = 200;
        assertEquals(esperado, c1.getSaldo());
    }

    @Test
    void testRetiraNegativo() {
        c1.ingresar(500);
        c1.retirar(-100);
        double esperado = 500;
        assertEquals(esperado, c1.getSaldo());
    }

    @Test
    void testRetiraDecimales() {
        c1.ingresar(500);
        c1.retirar(100.45);
        double esperado = 399.55;
        assertEquals(esperado, c1.getSaldo());
    }

    @Test
    void testRetira6000() {
        c1.ingresar(6000);
        c1.ingresar(1000);
        c1.retirar(6000);
        double esperado = 1000;
        assertEquals(esperado, c1.getSaldo());
    }

    @Test
    void testRetira60001Error() {
        c1.ingresar(6000);
        c1.ingresar(1000);
        c1.retirar(6000.01);
        double esperado = 7000;
        assertEquals(esperado, c1.getSaldo());
    }

    @Test
    void testTransferencia() {
        c1.ingresar(500);
        c2.ingresar(50);
        double esperado1 = 400;
        double esperado2 = 150;
        c1.transferencia(c2, 100);
        assertEquals(esperado1, c1.getSaldo());
        assertEquals(esperado2, c2.getSaldo());
    }

    @Test
    void testTransferenciaNegativo() {
        c1.ingresar(500);
        c2.ingresar(50);
        double esperado1 = 500;
        double esperado2 = 50;
        c1.transferencia(c2, -100);
        assertEquals(esperado1, c1.getSaldo());
        assertEquals(esperado2, c2.getSaldo());
    }

    @Test
    void testTransferencia3000() {
        c1.ingresar(3500);
        c2.ingresar(50);
        double esperado1 = 500;
        double esperado2 = 3050;
        c1.transferencia(c2, 3000);
        assertEquals(esperado1, c1.getSaldo());
        assertEquals(esperado2, c2.getSaldo());
    }

    @Test
    void testTransferencia3000Error() {
        c1.ingresar(3500);
        c2.ingresar(50);
        double esperado1 = 3500;
        double esperado2 = 50;
        c1.transferencia(c2, 3000.01);
        assertEquals(esperado1, c1.getSaldo());
        assertEquals(esperado2, c2.getSaldo());
    }


}