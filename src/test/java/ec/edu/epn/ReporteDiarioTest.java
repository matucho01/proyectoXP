package ec.edu.epn;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReporteDiarioTest {
    @Test
    public void given_when_then_ok(){
        ReporteDiario reporteDiario = new ReporteDiario();
        boolean expected = true;
        assertEquals(expected, reporteDiario.generarArchivoReporteDiario("22-09-22", "Reporte"));
    }
}