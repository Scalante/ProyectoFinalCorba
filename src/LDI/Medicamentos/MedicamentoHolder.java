package LDI.Medicamentos;

/**
* Medicamentos/MedicamentoHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Medicamentos.idl
* mi�rcoles 7 de noviembre de 2018 23H15' COT
*/

public final class MedicamentoHolder implements org.omg.CORBA.portable.Streamable
{
  public LDI.Medicamentos.Medicamento value = null;

  public MedicamentoHolder ()
  {
  }

  public MedicamentoHolder (LDI.Medicamentos.Medicamento initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = LDI.Medicamentos.MedicamentoHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    LDI.Medicamentos.MedicamentoHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return LDI.Medicamentos.MedicamentoHelper.type ();
  }

}
