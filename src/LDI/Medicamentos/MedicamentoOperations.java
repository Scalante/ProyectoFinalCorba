package LDI.Medicamentos;


public interface MedicamentoOperations 
{
  boolean insertarMedicamento (int codigo, String nombre, int idCondicion, int idPresentacion, int ruesLab, int precioVenta, int cantidad, String fechaCaducidad, String ubicacion);
  boolean actualizarMedicamento (int codigo, String nombre, int idCondicion, int idPresentacion, int ruesLab, int precioVenta, int cantidad, String fechaCaducidad, String ubicacion);
  boolean eliminarMedicamento (int codigo, int idCondicion, int idPresentacion, int ruesLab);
  String consultarMedicamento (int codigo);
  void shutdown ();
} // interface MedicamentoOperations
