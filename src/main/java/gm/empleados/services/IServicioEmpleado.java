package gm.empleados.services;

import gm.empleados.model.Empleado;

import java.util.List;

public interface IServicioEmpleado {
    public List<Empleado> getEmpleados();
    public Empleado getEmpleadoById(Integer id);
    public void saveEmpleado(Empleado empleado);
    public void deleteEmpleado(Empleado empleado);
}
