package ec.edu.epn;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReporteDiarioTest {
    @Test
    public void given_report_data_when_generating_document_then_ok(){
        ReporteDiario reporteDiario = new ReporteDiario();
        boolean expected = true;
        assertEquals(expected, reporteDiario.generarArchivoReporteDiario("22-09-22", "Reporte"));
    }

    @Test
    public void given_date_and_turn_reports_and_turns_when_square_turn_then_ok(){
        ReporteDiario reporteDiario = new ReporteDiario();
        //String actual = reporteDiario.cuadreTurnos("22-08-22", reporteTurno, turnos);
    }
}