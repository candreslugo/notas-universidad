import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main (String [] args) {

        Scanner entrada = new Scanner(System.in);
        double  promedio=0, sumaPorcentaje=0;
        int opcion;
        Notas nota = new Notas();
        Usuario usuario = new Usuario();
        ArrayList<Carrera> arrayCarreras = new ArrayList<Carrera>();
        ArrayList<Notas> arrayNotas = new ArrayList<Notas>();
        ArrayList<Materia> arrayMaterias = new ArrayList<Materia>();
        ArrayList<Usuario> arrayUsuarios = new ArrayList<Usuario>();
        ArrayList<Usuario> arrayUsuariosCreados = new ArrayList<>();
        ArrayList<Materia> materiasUsuario = new ArrayList<>();

        Carrera carr = new Carrera();
        Materia materia = new Materia();
        arrayCarreras = carr.creacionCarreras();

        Materia materia1 = new Materia(50, "Matematicas", 6, arrayNotas);
        Materia materia2 = new Materia(40, "Algebra", 5, arrayNotas);
        Materia materia3 = new Materia(30, "Calculo", 5, arrayNotas);
        Materia materia4 = new Materia(20, "Fisica", 8, arrayNotas);

        arrayMaterias.add(materia1);
        arrayMaterias.add(materia2);
        arrayMaterias.add(materia3);
        arrayMaterias.add(materia4);

        materiasUsuario = arrayMaterias;


        boolean verificador=true;

        //do {
            System.out.printf("");
            System.out.println("\n ---------------------------------\n"+"************ MENU ****************" +
                    "\n ----------------------------------\n" +
                    "\n Administracion de usuarios:" +
                    "\n ---------------------------" +
                    "\n 1) Crear usuario" +
                    "\n 2) Modificar usuario" +
                    "\n 3) Eliminar usuario" +
                    "\n 4) Ver usuarios creados\n" +
                    "\n Administracion de materias:" +
                    "\n ---------------------------" +
                    "\n 5) Crear materia" +
                    "\n 6) Modificar materia" +
                    "\n 7) Eliminar materia\n" +
                    "\n Administracion de notas:" +
                    "\n ------------------------" +
                    "\n 8) Agregar notas" +
                    "\n 9) Modificar notas" +
                    "\n 10) Eliminar notas\n" +
                    "\n 11) Resultados" +
                    "\n ---------------\n" +
                    "\n 12) Salir\n");
            System.out.print("digita tu opcion: ");
            System.out.println("");

           // opcion = entrada.nextInt();
        opcion = 1;

            switch (opcion){

            case 1:
                arrayUsuarios = usuario.agregarUsuario(arrayUsuarios, arrayCarreras,arrayMaterias,arrayMaterias);
                  opcion=0;
            break;
            case 2:
                usuario.modificarUsuario(arrayUsuarios, materiasUsuario);
                opcion=0;
                break;
            case 3:usuario.eliminarUsuario(arrayUsuarios);
                opcion=0;
                break;
            case 4:
                usuario.buscarUsuario(arrayUsuarios);
                opcion=0;
                break;
            case 5:
                arrayMaterias = materia.crearMateria(arrayMaterias);
                opcion=0;
                break;
            case 6:
                materia.modificarMateria(arrayMaterias);
                opcion=0;
                break;
            case 7:
                arrayMaterias = materia.eliminarMateria(arrayMaterias);
                opcion=0;
                break;
            case 8:
                nota.agregarNota(arrayUsuarios);
                opcion=0;
                break;
            case 9:
                nota.modificarNota(arrayUsuarios);
                opcion=0;
                break;

            case 10:
                nota.eliminarNota(arrayUsuarios);
                opcion=0;
                break;

            case 11:
                usuario.resultados(arrayUsuarios);
                opcion=0;
                break;
        }

       // }while (verificador=true);



    }

}
