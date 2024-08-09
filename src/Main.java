import dao.BD;
import modelo.Odontologo;
import servicio.OdontologoServicio;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BD.createTable();

            Odontologo odontologo = new Odontologo("2024",
                "Enrique",
                "Norero");

            OdontologoServicio servicio = new OdontologoServicio();

        servicio.guardar(odontologo);

        System.out.println("ondotologo guardado");
        System.out.println(odontologo.toString());

            Odontologo Odontologo2 = new Odontologo("2025",
                "Andres",
                "SAnchez");

        servicio.guardar(paciente2);
       
        servicio.listarTodos();

    }
}
