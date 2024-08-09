package dao.impl;

import dao.BD;
import dao.IDAO;
import modelo.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDAO<Odontologo> {
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;

        try {
            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Odontologo (" +
                            "MATRICULA, NOMBRE, APELLIDO)",Statement.RETURN_GENERATED_KEYS
            );

            preparedStatement.setInt(1, odontologo.getMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellid());
           
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            while (rs.next()) {
                paciente.setId(rs.getString(2));
                System.out.println("El odontologo guardado es " +
                                   odontologo.getNombre());
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        Connection connection = null;

        List<Odontologo> odontologoList = new ArrayList<>();
        Odontologo odontologo = null;

        try {
            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM ODONTOLOGO"
            );

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                odontologo = new Odontologo(rs.getInt(1), rs.getString(2),
                        rs.getString(3).toLocalDate());

                odontologoList.add(Odontologo);

                System.out.println(Odontologo.toString());
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return odontologoList;
    }

    @Override
    public Odontologo consultarPorId(Integer id) {
        Connection connection = null;

        try {
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void eliminarPorId(Integer id) {
        Connection connection = null;

        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        Connection connection = null;

        try {
            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE PACIENTES SET NOMBRE=?, APELLIDO=?, DOMICILIO=?"
            );

            preparedStatement.setString(1,paciente.getMatricula());
            preparedStatement.setString(2,paciente.getNombre());
            preparedStatement.setString(3, paciente.getApellido());
            
            preparedStatement.execute();

            System.out.println("Este es el nuevo nombre del paciente" + paciente.getNombre());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return odontologo;
    }
}
