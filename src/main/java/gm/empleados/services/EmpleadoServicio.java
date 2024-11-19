package gm.empleados.services;

import gm.empleados.model.Empleado;
import gm.empleados.repository.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicio implements IServicioEmpleado{

    @Autowired
    EmpleadoRepositorio empleadoRepositorio;

    @Override
    public List<Empleado> getEmpleados() {
        return empleadoRepositorio.findAll();
    }

    @Override
    public Empleado getEmpleadoById(Integer id) {
        return empleadoRepositorio.findById(id).orElse(null);
    }

    @Override
    public void saveEmpleado(Empleado empleado) {
        empleadoRepositorio.save(empleado);
    }

    @Override
    public void deleteEmpleado(Empleado empleado) {
        empleadoRepositorio.delete(empleado);
    }
}
