package LDI.Proveedores;

/**
* Proveedores/ProveedorHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Proveedores.idl
* domingo 11 de noviembre de 2018 20H15' COT
*/

public final class ProveedorHolder implements org.omg.CORBA.portable.Streamable
{
  public LDI.Proveedores.Proveedor value = null;

  public ProveedorHolder ()
  {
  }

  public ProveedorHolder (LDI.Proveedores.Proveedor initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = LDI.Proveedores.ProveedorHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    LDI.Proveedores.ProveedorHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return LDI.Proveedores.ProveedorHelper.type ();
  }

}
