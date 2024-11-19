package gm.empleados.repository;

import gm.empleados.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepositorio extends JpaRepository<Empleado,Integer> {
}
