package LDI.Medicamentos;


abstract public class MedicamentoHelper
{
  private static String  _id = "IDL:Medicamentos/Medicamento:1.0";

  public static void insert (org.omg.CORBA.Any a, LDI.Medicamentos.Medicamento that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static LDI.Medicamentos.Medicamento extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (LDI.Medicamentos.MedicamentoHelper.id (), "Medicamento");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static LDI.Medicamentos.Medicamento read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_MedicamentoStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, LDI.Medicamentos.Medicamento value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static LDI.Medicamentos.Medicamento narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof LDI.Medicamentos.Medicamento)
      return (LDI.Medicamentos.Medicamento)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      LDI.Medicamentos._MedicamentoStub stub = new LDI.Medicamentos._MedicamentoStub ();
      stub._set_delegate(delegate);
      return (Medicamento) stub;
    }
  }

  public static LDI.Medicamentos.Medicamento unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof LDI.Medicamentos.Medicamento)
      return (LDI.Medicamentos.Medicamento)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      LDI.Medicamentos._MedicamentoStub stub = new LDI.Medicamentos._MedicamentoStub ();
      stub._set_delegate(delegate);
      return (Medicamento) stub;
    }
  }

}
