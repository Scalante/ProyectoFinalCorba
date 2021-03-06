package LDI.Empleados;


/**
* Empleados/EmpleadoOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Empleados.idl
* lunes 12 de noviembre de 2018 17H14' COT
*/

public interface EmpleadoOperations 
{
  boolean insertarEmpleado (int identificacion, String nombre, int idDepartamento, int idCiudad, String direcion, String correo, String telefono, char estado, String urlImagen, byte imagen);
  boolean actualizarEmpleado (int identificacion, String nombre, int idDepartamento, int idCiudad, String direcion, String correo, String telefono, char estado, String urlImagen, byte imagen);
  boolean eliminarEmpleado (int identificacion);
  String consultarEmpleado (int identificacion);
  void shutdown ();
} // interface EmpleadoOperations
