/*---------------- Algoritmo Prioridad Apropiativos ---------------*/
//  Planificador de corto alcance (PCA)
//
// Es el principal planificador del Sistema Operativo, está continuamente 
// funcionando, es quien decide que proceso pasa a ejecutado, usa distintas 
// políticas o algoritmos, brinda cierta equidad.
// v1.2
// Autor: José Victor Ibáñez
/*------------------------- ------------- -------------------------*/

package Test;

import Model.admProcesamiento;
import Model.admTablaProcesos;
import Model.Prioridad;

public class TestPrioridadesApropiativos {

	public static void main(String[] args) {

		admProcesamiento admP1 = new admProcesamiento(20, 48);

		admP1.agregarProceso("P3", 1, 3, 3, 3, Prioridad.Alta);
		admP1.agregarProceso("P2", 3, 8, 2, 6, Prioridad.Media);
		admP1.agregarProceso("P1", 3, 2, 5, 7, Prioridad.Baja);
		admP1.agregarProceso("P5", 4, 5, 1, 5, Prioridad.Alta);

		System.out.println("----------- Planificador Prioridad Apropiativos -----------");
		System.out.println(admP1.mostrarPlanificador(admP1.planificarPrioridadesApropiativos()));
		System.out.println(admP1.mostrarProcesos() + "\n-> hay 1 procesador" + "\n-> E/S Se realiza en paralelo\n");
		
		System.out.println("----------- Resultados Prioridad Apropiativos -----------");
		admTablaProcesos admTP1 = new admTablaProcesos(admP1);
		System.out.println(admTP1.mostrarResultados(admP1.planificarPrioridadesApropiativos()));

	}

}
