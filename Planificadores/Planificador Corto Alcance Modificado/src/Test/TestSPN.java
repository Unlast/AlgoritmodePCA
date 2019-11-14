/*-------------------------- Algoritmo SPN ------------------------*/
//  Planificador de corto alcance (PCA)
//
// Es el principal planificador del Sistema Operativo, est� continuamente 
// funcionando, es quien decide que proceso pasa a ejecutado, usa distintas 
// pol�ticas o algoritmos, brinda cierta equidad.
// v1.2
// Autor: Jos� Victor Ib��ez
/*------------------------- ------------- -------------------------*/

package Test;

import Model.Prioridad;
import Model.admProcesamiento;
import Model.admTablaProcesos;

public class TestSPN {

	public static void main(String[] args) {

		admProcesamiento admP1 = new admProcesamiento(20, 48);

		admP1.agregarProceso("P1", 1, 3, 3, 3, Prioridad.Alta);
		admP1.agregarProceso("P2", 3, 8, 2, 6, Prioridad.Media);
		admP1.agregarProceso("P3", 3, 2, 5, 7, Prioridad.Baja);
		admP1.agregarProceso("P4", 4, 5, 1, 5, Prioridad.Alta);

		System.out.println("----------- Planificador SPN -----------");
		System.out.println(admP1.mostrarPlanificador(admP1.planificarSPN()));
		System.out.println(admP1.mostrarProcesos() + "\n-> hay 1 procesador" + "\n-> E/S Se realiza en paralelo\n");
		
		System.out.println("----------- Resultados SPN -----------");
		admTablaProcesos admTP1 = new admTablaProcesos(admP1);
		System.out.println(admTP1.mostrarResultados(admP1.planificarSPN()));

	}

}
