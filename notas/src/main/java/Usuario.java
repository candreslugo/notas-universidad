import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

    private int id;
    private String primerNombre;
    private String segunNombre;
    private String apellidos;
    Carrera carrera;
    ArrayList<Materia> materia;

    Scanner entrada = new Scanner(System.in);

    public Usuario(int id, String primerNombre, String segunNombre, String apellidos, Carrera carrera, ArrayList<Materia> materia) {
        this.id = id;
        this.primerNombre = primerNombre;
        this.segunNombre = segunNombre;
        this.apellidos = apellidos;
        this.carrera = carrera;
        this.materia = materia;

    }

    public Usuario() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegunNombre() {
        return segunNombre;
    }

    public void setSegunNombre(String segunNombre) {
        this.segunNombre = segunNombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public ArrayList<Materia> getMateria() {
        return materia;
    }

    public void setMateria(ArrayList<Materia> materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", primerNombre='" + primerNombre + '\'' +
                ", segunNombre='" + segunNombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", carrera=" + carrera +
                ", materia=" + materia +
                '}';
    }


    public ArrayList agregarUsuario(ArrayList<Usuario> usuariosList, ArrayList<Carrera> carrerasList, ArrayList<Materia> materiasCreadas, ArrayList<Materia> materias) {
        int idCarrera, cantMaterias = 0, idMateria;
        ArrayList<Materia> materiasList = new ArrayList<>();
        Usuario usuario = new Usuario();
        Carrera carrera = new Carrera();
        Materia materia = new Materia();
        System.out.print("Ingrese el id del usuario : ");

        usuario.setId(entrada.nextInt());
        System.out.print("Ingrese el primer nombre del usuario : ");

        usuario.setPrimerNombre(entrada.next());
        System.out.print("Ingrese el segundo nombre del usuario : ");

        usuario.setSegunNombre(entrada.next());
        System.out.print("Ingrese el apellido del usuario : ");

        usuario.setApellidos(entrada.next());
        System.out.println("");
        System.out.println("Seleccione el id de la carrera aestudiar : ");
        System.out.println("-------------------------------------------");

        carrera = carrera.buscarCarrera(carrerasList);
        usuario.setCarrera(carrera);

        //

       /* ArrayList<Notas> notas = new ArrayList<>();
        int i = 0;
        boolean validar = false;
        System.out.println("");
        System.out.println("\n -------------------------------------------------\n" + "*** Agregue las Matarias a cursar en el semestre ***" +
                "\n id-(1)=> Java" +
                "\n id-(2) Javas-Script" +
                "\n id-(3) C++" +
                "\n id-(4) PHP" +
                "\n id-(5) phyton" +
                "\n id-(6) C#" +
                "\n id-(8) Salir\n");


        do {
            System.out.print("Ingrese un id ( ) válido para la Materia: ");
            idMateria = entrada.nextInt();
            for (int j = 0; j < materias.size(); j++) {
                if (idMateria == materias.get(j).getId()) {
                    i = 0;
                    break;
                } else {
                    i = 1;
                    materia.setId(idMateria);
                }
            }
        } while (i != 1);
        materia.setId(idMateria);
        System.out.print("Ingrese el nombre de la materia: ");
        materia.setNombre(entrada.next());
        System.out.println("Ingrese los créditos de la materia de 1 a 10");
        materia.setCreditos(entrada.nextInt());
        materias.add(materia);
        System.out.println("_____________________________________");
        System.out.println("***** Materia creada correctamente *****");
        System.out.println("---------------------------------------\n");
*/
//


        do {
            System.out.println("Cuales materias desea matricular ?");

            System.out.println("Sólo hay " + materiasCreadas.size() + " materias disponibles: ");
            System.out.println("-------------------------------------");
            for (Materia materia3 : materiasList) {
                System.out.println(getMateria());


            }

            System.out.print("numero de materias seleccionar: ");
            cantMaterias = entrada.nextInt();

            System.out.println("");


        } while (cantMaterias > materiasCreadas.size());
        materiasList = materia.agregarMateria(cantMaterias, materiasCreadas, carrera.getCreditosTot());
        if (materiasList.size() == cantMaterias) {
            usuario.setMateria(materiasList);
            usuariosList.add(usuario);
            System.out.println("-------------------------------------------");
            System.out.println("****** el Usuario fue creado correctamente *******");
            System.out.println("------------------------------------------------------      -");
            for (int l = 0; l < usuariosList.size(); l++) {
                System.out.println(usuariosList.get(l).getId() + "-" + usuariosList.get(l).getPrimerNombre());
            }
            System.out.println("");
            System.out.println("");
            System.out.println("");

        } else {
            System.out.println("Error al crear el usuario:");
            System.out.println("La cantidad de creditos de las materias superan el permitido por la Carrera " + carrera.getCreditosTot());
        }

        return usuariosList;
    }

    public Usuario buscarUsuario(ArrayList<Usuario> usuariosList) {

        Usuario usuario = new Usuario();
        int idusuario;
        String nombre = "";
        ArrayList<Notas> notasArrayList;

        System.out.println("Listado de usuarios:");
        System.out.println("---------------------- ");

        for (int i = 0; i < usuariosList.size(); i++) {
            System.out.println("id: " + usuariosList.get(i).getId() + "  -   " + "nombre: " + usuariosList.get(i).getPrimerNombre());
            System.out.println("");
        }
        System.out.print("Seleccione el id del usuario: ");


        idusuario = entrada.nextInt();
        for (int j = 0; j < usuariosList.size(); j++) {
            if (idusuario == usuariosList.get(j).getId()) {
                usuario = usuariosList.get(j);
                System.out.println(usuario.getPrimerNombre() + usuario.getCarrera() + usuario.getMateria());
                break;
            } else {
                usuario = null;
            }
        }

        return usuario;
    }


    public void modificarUsuario(ArrayList<Usuario> usuariosList, ArrayList<Materia> materiasCreadas) {
        Usuario usuario = new Usuario();
        Carrera carrera = new Carrera();
        Materia materia = new Materia();
        ArrayList<Carrera> carrerasList = new ArrayList<>();
        ArrayList<Materia> materiasList = new ArrayList<>();
        carrerasList = carrera.creacionCarreras();
        int opcion, opcion2;

        usuario = usuario.buscarUsuario(usuariosList);
        do {


            System.out.println("Cuál dato desea modificar del usuario :" + usuario.getPrimerNombre() + " \n" +
                    "\n 1) Primer nombre" +
                    "\n 2) Segundo nombre" +
                    "\n 3) Apellido" +
                    "\n 4) Carrera" +
                    "\n 5) Materias" +
                    "\n 6) Volver al menu principal");

            System.out.println("ingrese el numero de la opcion (): ");
            opcion = entrada.nextInt();


            switch (opcion) {

                case 1:
                    System.out.print("Ingrese el NUEVO Primer Nombre del usuario: " + usuario.getPrimerNombre());
                    usuario.setPrimerNombre(entrada.next());
                    break;
                case 2:
                    System.out.println("Ingrese el NUEVO Segundo Nombre del usuario: " + usuario.getPrimerNombre());
                    usuario.setSegunNombre(entrada.next());
                    break;
                case 3:
                    System.out.println("Ingrese el NUEVO Apellido del usuario: " + usuario.getPrimerNombre());
                    usuario.setApellidos(entrada.next());
                    break;
                case 4:
                    System.out.println("Seleccione la nueva carrera del usuario: " + usuario.getPrimerNombre());
                    carrera = carrera.buscarCarrera(carrerasList);
                    usuario.setCarrera(carrera);
                    break;
                case 5:
                    do {
                        System.out.println("1. Agregar materia \n" +
                                "2. Eliminar materia \n" +
                                "3. Salir");
                        opcion2 = entrada.nextInt();
                        switch (opcion2) {
                            case 1:
                                materiasList = usuario.getMateria();
                                materia = materia.buscarMateria(materiasCreadas, usuario);

                                if (materia != null || materia.getId() != 0) {
                                    materiasList.add(materia);
                                    usuario.setMateria(materiasList);
                                } else {
                                    System.out.println("No se pudo encontrar la materia seleccionada");
                                    materiasList.remove(materia);
                                }
                                break;
                            case 2:
                                materia = materia.eliminarMatArray(usuario.getMateria());
                                usuario.getMateria().remove(materia);
                                break;
                        }
                    } while (opcion2 != 3);

                    break;
            }

        } while (opcion != 6);

    }

    public void eliminarUsuario(ArrayList<Usuario> eliminarUsuario) {
        Usuario usuario1 = new Usuario();

        for (int i = 0; i < eliminarUsuario.size(); i++) {
            System.out.println(eliminarUsuario.get(i));
        }
        String eliminar;
        int indice = 0;
        System.out.print("digite el primer nombre del usuario que desea eliminar: ");
        eliminar = entrada.next();
        for (Usuario usuario : eliminarUsuario) {
            if (eliminar.equals(usuario.getPrimerNombre())) {
                indice = 1;
                usuario1 = usuario;
            }
        }
        if (indice == 1) {
            eliminarUsuario.remove(usuario1);
            System.out.println("---------------------------");
            System.out.println("***** usuario eliminado *****");
            System.out.println("---------------------------");
        } else {
            System.out.println("el usuario no se encuentra");
        }

        for (Usuario eliminarU : eliminarUsuario) {
            System.out.println(eliminarU);


        }
    }


    public void resultados(ArrayList<Usuario> usuarios) {
        Usuario usuario = new Usuario();
        Notas nota = new Notas();
        double notaDef;
        String definitiva = "";

        usuario = usuario.buscarUsuario(usuarios);

        System.out.println("Alumno: \n" + usuario.getPrimerNombre());
        System.out.println("Carrera asignada: \n" + usuario.getCarrera().getNombre());
        System.out.println("Materias matriculadas: \n");
        for (Materia materias : usuario.getMateria()) {
            if (materias.getNotas().size() > 0) {
                notaDef = nota.calcularNotaDefinitiva(materias.getNotas());
                if (notaDef >= 3) {
                    definitiva = "Aprobó";
                } else {
                    definitiva = "Desaprobó";
                }
                System.out.println("Materia: " + materias.getNombre() + " Nota definitiva: " + notaDef + " : " + definitiva + "\n");
            } else {
                System.out.println("La materia " + materias.getNombre() + " no tiene notas asignadas" + "\n");
            }
        }

    }

    public double validarNotas2(ArrayList<Notas> notas) {
        boolean validar = false;
        double sumaPorcentaje = 0, promedio = 0;
        double resultado = 0;

        for (int i = 0; i < notas.size(); i++) {
            sumaPorcentaje += notas.get(i).getPorcentaje();
            promedio += notas.get(i).getValor();
            promedio = promedio / notas.size();
            if (sumaPorcentaje <= 100 && sumaPorcentaje > 0 && promedio <= 5) {
                resultado = sumaPorcentaje;
            }
        }

        return resultado;
    }


}
