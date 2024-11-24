package gm.empleados.controllers;

import gm.empleados.model.Empleado;
import gm.empleados.services.EmpleadoServicio;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    EmpleadoServicio empleadoServicio;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String inciar(ModelMap modelo){
        List<Empleado> empleados = empleadoServicio.getEmpleados();
        empleados.forEach(empleado -> {
            logger.info(empleado.toString());
        });
        //Compartimos el modelo con la vista
        modelo.put("empleados",empleados);
        return "index";
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.GET)
    public String mostrarAgregar(){
        return "agregar"; // agregar.jsp
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public String agregarEmpleado(@ModelAttribute("empleadoForma") Empleado empleado){
        logger.info("Empleado a agregar: " + empleado.toString());
        empleadoServicio.saveEmpleado(empleado);
        return "redirect:/"; // Redigire al path /
    }

    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String mostrarEditarEmpleado(@RequestParam int idEmpleado, ModelMap modelo){
        logger.info("idEmpleado a editar: " + idEmpleado);
        Empleado empleado = empleadoServicio.getEmpleadoById(idEmpleado);
        modelo.put("empleado",empleado);
        return "editar";
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editarEmpleado(@ModelAttribute("empleadoForma") Empleado empleado){
        logger.info("Empleado a editar: " + empleado.toString());
        empleadoServicio.saveEmpleado(empleado);
        return "redirect:/";
    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.GET)
    public String eliminarEmpleado(@RequestParam int idEmpleado){
        logger.info("idEmpleado a eliminar: " + idEmpleado);
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(idEmpleado);
        empleadoServicio.deleteEmpleado(empleado);
        return "redirect:/";
    }

}
