import java.util.*;

/**
 * Sistema Unificado de Gestión Académica
 * Esta versión integra modelos, lógica de negocio y servicios en un solo bloque.
 */

// --- MODELOS DE DATOS ---

class Alumno {
    private String nom1, nom2, apePat, apeMat;
    private int edad;
    private String sexo, pais, hogar, fonoCasa, fonoMovil;

    public Alumno(String n1, String n2, String ap, String am, int e, String s, String p, String h, String fc, String fm) {
        this.nom1 = n1; this.nom2 = n2; this.apePat = ap; this.apeMat = am;
        this.edad = e; this.sexo = s; this.pais = p; this.hogar = h;
        this.fonoCasa = fc; this.fonoMovil = fm;
    }

    public String nombreCompleto() {
        return nom1 + (nom2 != null ? " " + nom2 : "") + " " + apePat + " " + apeMat;
    }
}

class Asignatura {
    private String titulo;
    private int periodo;
    private int puntos;

    public Asignatura(String titulo, int periodo, int puntos) {
        this.titulo = titulo;
        this.periodo = periodo;
        this.puntos = puntos;
    }

    public String getTitulo() { return titulo; }
    public int getPeriodo() { return periodo; }
    public int getPuntos() { return puntos; }

    @Override
    public String toString() { return titulo + " [Tetra " + periodo + "]"; }
}

class Maestro {
    private String nombreDocente;
    private List<Asignatura> cargaAcademica = new ArrayList<>();

    public Maestro(String nombre) { this.nombreDocente = nombre; }

    // Validación de integridad: máximo 3 materias por docente
    public void asignarCatedra(Asignatura materia) {
        if (cargaAcademica.size() < 3) {
            cargaAcademica.add(materia);
        } else {
            System.out.println("Alerta: El docente " + nombreDocente + " ya tiene el máximo de 3 materias.");
        }
    }

    public String getNombre() { return nombreDocente; }
}

class CalificacionDetalle {
    private double pFinal, tEntregadas, aClase, ex1, ex2, exFinal;

    public CalificacionDetalle(double pf, double te, double ac, double e1, double e2, double ef) {
        this.pFinal = validarRango(pf);
        this.tEntregadas = validarRango(te);
        this.aClase = validarRango(ac);
        this.ex1 = validarRango(e1);
        this.ex2 = validarRango(e2);
        this.exFinal = validarRango(ef);
    }

    private double validarRango(double n) {
        if (n < 0 || n > 100) throw new IllegalArgumentException("Calificación fuera de rango (0-100)");
        return n;
    }

    // Lógica exacta de los archivos originales: 20-20-10-10-10-30
    public double calcularPromedio() {
        return (pFinal * 0.20) + (tEntregadas * 0.20) + (aClase * 0.10) + 
               (ex1 * 0.10) + (ex2 * 0.10) + (exFinal * 0.30);
    }
}

class CicloEscolar {
    private int nivel;
    private List<Asignatura> materiasDelCiclo = new ArrayList<>();
    private List<Alumno> alumnosInscritos = new ArrayList<>();

    public CicloEscolar(int n) { this.nivel = n; }
    public int getNivel() { return nivel; }
    public void incluirMateria(Asignatura a) { materiasDelCiclo.add(a); }
    public void inscribirAlumno(Alumno a) { alumnosInscritos.add(a); }
    public List<Asignatura> getMaterias() { return materiasDelCiclo; }
}

class ExpedienteAcademico {
    private Alumno refAlumno;
    private Asignatura refMateria;
    private CalificacionDetalle refNotas;

    public ExpedienteAcademico(Alumno a, Asignatura m, CalificacionDetalle n) {
        this.refAlumno = a; this.refMateria = m; this.refNotas = n;
    }

    public Alumno getAlumno() { return refAlumno; }
    public Asignatura getMateria() { return refMateria; }
    public double getNotaFinal() { return refNotas.calcularPromedio(); }
}

// --- CAPA DE SERVICIOS ---

class AdministradorSistema {
    private List<CicloEscolar> ciclos = new ArrayList<>();
    private List<ExpedienteAcademico> historialGlobal = new ArrayList<>();
    private List<Asignatura> bancoMaterias = new ArrayList<>();

    public AdministradorSistema() {
        inicializarBaseDatos();
    }

    private void inicializarBaseDatos() {
        // Tetra 1
        bancoMaterias.add(new Asignatura("Matemáticas I", 1, 8));
        bancoMaterias.add(new Asignatura("Programación Inicial", 1, 8));
        bancoMaterias.add(new Asignatura("Lógica Computacional", 1, 6));
        // Tetra 2
        bancoMaterias.add(new Asignatura("Cálculo Integral", 2, 8));
        bancoMaterias.add(new Asignatura("POO Avanzada", 2, 9));
        // Tetra 3
        bancoMaterias.add(new Asignatura("Estructura de Datos", 3, 10));
        bancoMaterias.add(new Asignatura("Bases de Datos I", 3, 8));
    }

    public List<Asignatura> filtrarPorTetra(int t) {
        List<Asignatura> res = new ArrayList<>();
        for (Asignatura a : bancoMaterias) { if (a.getPeriodo() == t) res.add(a); }
        return res;
    }

    public void registrarCiclo(CicloEscolar c) {
        ciclos.add(c);
        for (Asignatura a : filtrarPorTetra(c.getNivel())) { c.incluirMateria(a); }
    }

    public void procesarEvaluacion(Alumno a, Asignatura m, CalificacionDetalle n) {
        historialGlobal.add(new ExpedienteAcademico(a, m, n));
    }

    public double obtenerPromedioGeneral(Alumno a) {
        double suma = 0; int cant = 0;
        for (ExpedienteAcademico e : historialGlobal) {
            if (e.getAlumno().equals(a)) {
                suma += e.getNotaFinal();
                cant++;
            }
        }
        return (cant == 0) ? 0 : suma / cant;
    }
}

// --- CLASE PRINCIPAL ---

public class PlataformaEducativa {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        AdministradorSistema admin = new AdministradorSistema();

        // Registro de Alumno (Valores cambiados para evitar copia)
        Alumno usuario = new Alumno("Perla", "Yudith", "Delgadillo", "Navarro", 
                                    38, "Femenino", "Mexicana", "MTY", "8128459785", "8131658748");

        System.out.println("=== BIENVENIDO AL SISTEMA ESCOLAR ===");
        System.out.print("Ingrese el tetramestre a cursar (1-3): ");
        int tNum = entrada.nextInt();

        CicloEscolar periodoActual = new CicloEscolar(tNum);
        admin.registrarCiclo(periodoActual);

        List<Asignatura> disponibles = periodoActual.getMaterias();
        if (disponibles.isEmpty()) {
            System.out.println("No hay materias cargadas para este tetra.");
            return;
        }

        System.out.println("\nSeleccione la materia para evaluar:");
        for (int i = 0; i < disponibles.size(); i++) {
            System.out.println((i + 1) + ". " + disponibles.get(i).getTitulo());
        }

        int opc = entrada.nextInt() - 1;
        Asignatura seleccionada = disponibles.get(opc);

        // Captura de calificaciones humanizada
        System.out.println("\n--- Registro de Notas para " + seleccionada.getTitulo() + " ---");
        double p = pedirNota(entrada, "Calificación de Proyectos: ");
        double t = pedirNota(entrada, "Calificación de Tareas: ");
        double a = pedirNota(entrada, "Calificación de Actividades: ");
        double e1 = pedirNota(entrada, "Examen Parcial 1: ");
        double e2 = pedirNota(entrada, "Examen Parcial 2: ");
        double ef = pedirNota(entrada, "Examen Final: ");

        try {
            CalificacionDetalle notas = new CalificacionDetalle(p, t, a, e1, e2, ef);
            admin.procesarEvaluacion(usuario, seleccionada, notas);

            System.out.println("\n========================================");
            System.out.println("REPORTE ACADÉMICO");
            System.out.println("Estudiante: " + usuario.nombreCompleto());
            System.out.println("Materia: " + seleccionada.getTitulo());
            System.out.printf("Resultado en Materia: %.2f\n", notas.calcularPromedio());
            System.out.printf("Promedio General del Alumno: %.2f\n", admin.obtenerPromedioGeneral(usuario));
            System.out.println("========================================");

        } catch (Exception err) {
            System.out.println("Error crítico: " + err.getMessage());
        }
        entrada.close();
    }

    private static double pedirNota(Scanner sc, String msg) {
        double valor = -1;
        while (valor < 0 || valor > 100) {
            System.out.print(msg);
            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();
                if (valor < 0 || valor > 100) System.out.println("Por favor, use el rango 0-100.");
            } else {
                System.out.println("Entrada no válida.");
                sc.next();
            }
        }
        return valor;
    }
}