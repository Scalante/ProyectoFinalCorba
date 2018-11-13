package LDI.Proveedores;


public interface ProveedorOperations 
{
  boolean insertarProveedor (int rues, String nombre, int idDepartamento, int idCiudad, String direccion, String telefono);
  boolean actualizarProveedor (int rues, String nombre, int idDepartamento, int idCiudad, String direccion, String telefono);
  boolean eliminarProveedor (int rues);
  String consultarProveedor (int rues);
  void shutdown ();
} // interface ProveedorOperations
