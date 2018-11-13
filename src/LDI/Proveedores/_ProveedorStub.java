package LDI.Proveedores;


/**
* Proveedores/_ProveedorStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Proveedores.idl
* domingo 11 de noviembre de 2018 20H15' COT
*/

public class _ProveedorStub extends org.omg.CORBA.portable.ObjectImpl implements LDI.Proveedores.Proveedor
{

  public boolean insertarProveedor (int rues, String nombre, int idDepartamento, int idCiudad, String direccion, String telefono)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("insertarProveedor", true);
                $out.write_long (rues);
                $out.write_wstring (nombre);
                $out.write_long (idDepartamento);
                $out.write_long (idCiudad);
                $out.write_wstring (direccion);
                $out.write_wstring (telefono);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return insertarProveedor (rues, nombre, idDepartamento, idCiudad, direccion, telefono        );
            } finally {
                _releaseReply ($in);
            }
  } // insertarProveedor

  public boolean actualizarProveedor (int rues, String nombre, int idDepartamento, int idCiudad, String direccion, String telefono)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("actualizarProveedor", true);
                $out.write_long (rues);
                $out.write_wstring (nombre);
                $out.write_long (idDepartamento);
                $out.write_long (idCiudad);
                $out.write_wstring (direccion);
                $out.write_wstring (telefono);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return actualizarProveedor (rues, nombre, idDepartamento, idCiudad, direccion, telefono        );
            } finally {
                _releaseReply ($in);
            }
  } // actualizarProveedor

  public boolean eliminarProveedor (int rues)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("eliminarProveedor", true);
                $out.write_long (rues);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return eliminarProveedor (rues        );
            } finally {
                _releaseReply ($in);
            }
  } // eliminarProveedor

  public String consultarProveedor (int rues)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("consultarProveedor", true);
                $out.write_long (rues);
                $in = _invoke ($out);
                String $result = $in.read_wstring ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return consultarProveedor (rues        );
            } finally {
                _releaseReply ($in);
            }
  } // consultarProveedor

  public void shutdown ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("shutdown", false);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                shutdown (        );
            } finally {
                _releaseReply ($in);
            }
  } // shutdown

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Proveedores/Proveedor:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _ProveedorStub
