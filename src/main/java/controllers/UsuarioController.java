package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import models.Usuario;

public class UsuarioController {


    private SessionFactory getSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Usuario.class)
                .buildSessionFactory();
    }

    // Crear usuario
    public String createUsuario(String nombre, String apellido, String direccion) {
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Usuario usuario = new Usuario(nombre, apellido, direccion);
            Transaction tx = session.beginTransaction();
            session.persist(usuario); // reemplaza save()
            tx.commit();
            return "Usuario Creado";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al registrar usuario";
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    // Actualizar nombre de un usuario
    public String updateUsuario(int id, String nuevoNombre) {
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Transaction tx = session.beginTransaction();
            Usuario usuario = session.get(Usuario.class, id);
            if (usuario != null) {
                usuario.setNombre(nuevoNombre);
                session.merge(usuario); // reemplaza update()
                tx.commit();
                return "Usuario actualizado";
            } else {
                return "Usuario no encontrado";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al actualizar usuario";
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    // Obtener usuario por id
    public String getUsuario(int id) {
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Usuario usuario = session.get(Usuario.class, id);
            if (usuario != null) {
                return "Usuario: " + usuario.getNombre() + " " + usuario.getApellido() + ", " + usuario.getDireccion();
            } else {
                return "Usuario no encontrado";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al obtener usuario";
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    // Eliminar usuario por id
    public String deleteUsuario(int id) {
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Transaction tx = session.beginTransaction();
            Usuario usuario = session.get(Usuario.class, id);
            if (usuario != null) {
                session.remove(usuario); // reemplaza delete()
                tx.commit();
                return "Usuario eliminado";
            } else {
                return "Usuario no encontrado";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al eliminar usuario";
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
