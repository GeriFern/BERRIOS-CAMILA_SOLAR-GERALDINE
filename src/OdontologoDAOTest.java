import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class OdontologoDAOTest {
    private OdontologoDAO dao;

    @Before
    public void setUp() throws Exception {
        dao = new OdontologoDAOArrayListImpl(); 
    }

    @Test
    public void testGuardarYListarOdontologos() {
        Odontologo odontologo1 = new Odontologo(123, "Juan", "Pérez");
        Odontologo odontologo2 = new Odontologo(456, "Ana", "Gómez");

        dao.guardarOdontologo(odontologo1);
        dao.guardarOdontologo(odontologo2);

        List<Odontologo> odontologos = dao.listarTodosOdontologos();

        assertEquals(2, odontologos.size());
        assertEquals("Juan", odontologos.get(0).getNombre());
        assertEquals("Ana", odontologos.get(1).getNombre());
    }
}