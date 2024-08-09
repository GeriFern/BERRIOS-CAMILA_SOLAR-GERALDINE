package servicio;

import dao.IDAO;
import dao.impl.ImplementacionDaoH2;
import modelo.Odontologo;

import java.util.List;

public class OdontologoServicio {
    private IDAO<Odontologo> iOdontologoDAO;

    public OdontologoServicio() {
        this.iOdontologoDAO = new OdontologoDaoH2();
    }

    public Odontologo guardar(Odontologo odontologo) {
        return iOdontologoDAO.guardar(odontologo);
    }

   public List<Odontologo> listarTodos() {
        return iOdontologoDAO.listarTodos();
    }

}