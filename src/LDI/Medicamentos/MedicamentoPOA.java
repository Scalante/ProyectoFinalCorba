package LDI.Medicamentos;


public abstract class MedicamentoPOA extends org.omg.PortableServer.Servant
 implements LDI.Medicamentos.MedicamentoOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("insertarMedicamento", new java.lang.Integer (0));
    _methods.put ("actualizarMedicamento", new java.lang.Integer (1));
    _methods.put ("eliminarMedicamento", new java.lang.Integer (2));
    _methods.put ("consultarMedicamento", new java.lang.Integer (3));
    _methods.put ("shutdown", new java.lang.Integer (4));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // Medicamentos/Medicamento/insertarMedicamento
       {
         int codigo = in.read_long ();
         String nombre = in.read_wstring ();
         int idCondicion = in.read_long ();
         int idPresentacion = in.read_long ();
         int ruesLab = in.read_long ();
         int precioVenta = in.read_long ();
         int cantidad = in.read_long ();
         String fechaCaducidad = in.read_wstring ();
         String ubicacion = in.read_wstring ();
         boolean $result = false;
         $result = this.insertarMedicamento (codigo, nombre, idCondicion, idPresentacion, ruesLab, precioVenta, cantidad, fechaCaducidad, ubicacion);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // Medicamentos/Medicamento/actualizarMedicamento
       {
         int codigo = in.read_long ();
         String nombre = in.read_wstring ();
         int idCondicion = in.read_long ();
         int idPresentacion = in.read_long ();
         int ruesLab = in.read_long ();
         int precioVenta = in.read_long ();
         int cantidad = in.read_long ();
         String fechaCaducidad = in.read_wstring ();
         String ubicacion = in.read_wstring ();
         boolean $result = false;
         $result = this.actualizarMedicamento (codigo, nombre, idCondicion, idPresentacion, ruesLab, precioVenta, cantidad, fechaCaducidad, ubicacion);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // Medicamentos/Medicamento/eliminarMedicamento
       {
         int codigo = in.read_long ();
         int idCondicion = in.read_long ();
         int idPresentacion = in.read_long ();
         int ruesLab = in.read_long ();
         boolean $result = false;
         $result = this.eliminarMedicamento (codigo, idCondicion, idPresentacion, ruesLab);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // Medicamentos/Medicamento/consultarMedicamento
       {
         int codigo = in.read_long ();
         String $result = null;
         $result = this.consultarMedicamento (codigo);
         out = $rh.createReply();
         out.write_wstring ($result);
         break;
       }

       case 4:  // Medicamentos/Medicamento/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Medicamentos/Medicamento:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Medicamento _this() 
  {
    return MedicamentoHelper.narrow(
    super._this_object());
  }

  public Medicamento _this(org.omg.CORBA.ORB orb) 
  {
    return MedicamentoHelper.narrow(
    super._this_object(orb));
  }


} // class MedicamentoPOA
