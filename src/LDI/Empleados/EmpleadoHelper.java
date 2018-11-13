package LDI.Empleados;


/**
* Empleados/EmpleadoHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Empleados.idl
* lunes 12 de noviembre de 2018 17H14' COT
*/

abstract public class EmpleadoHelper
{
  private static String  _id = "IDL:Empleados/Empleado:1.0";

  public static void insert (org.omg.CORBA.Any a, LDI.Empleados.Empleado that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static LDI.Empleados.Empleado extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (LDI.Empleados.EmpleadoHelper.id (), "Empleado");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static LDI.Empleados.Empleado read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_EmpleadoStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, LDI.Empleados.Empleado value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static LDI.Empleados.Empleado narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof LDI.Empleados.Empleado)
      return (LDI.Empleados.Empleado)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      LDI.Empleados._EmpleadoStub stub = new LDI.Empleados._EmpleadoStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static LDI.Empleados.Empleado unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof LDI.Empleados.Empleado)
      return (LDI.Empleados.Empleado)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      LDI.Empleados._EmpleadoStub stub = new LDI.Empleados._EmpleadoStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}