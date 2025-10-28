package view;

import controllers.UsuarioController;

public class UsuarioView {

    public static void main(String[] args) {
        UsuarioController usuarioController = new UsuarioController();

        // Crear usuarios
        String resultadoCrear = usuarioController.createUsuario("Paola", "Fernandez", "Culiacan");
        System.out.println(resultadoCrear);
        
        String resultadoCrear2 = usuarioController.createUsuario("Manuel", "Fernandez", "Culiacan");
        System.out.println(resultadoCrear2);
        
        String resultadoCrear3 = usuarioController.createUsuario("Juana", "Fernandez", "Culiacan");
        System.out.println(resultadoCrear3);

        // Actualizar usuario
        String resultadoActualizar = usuarioController.updateUsuario(3, "Armando");
        System.out.println(resultadoActualizar);

        // Obtener usuario
        String resultadoObtener = usuarioController.getUsuario(3);
        System.out.println(resultadoObtener);

        // Eliminar usuarios
        String resultadoEliminar = usuarioController.deleteUsuario(1);
        System.out.println(resultadoEliminar);
        
        String resultadoEliminar2 = usuarioController.deleteUsuario(2);
        System.out.println(resultadoEliminar2);
    }
} 