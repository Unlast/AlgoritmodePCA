/*-------------------------- Algoritmo SPN ------------------------*/
//  Planificador de corto alcance (PCA)
//
// Es el principal planificador del Sistema Operativo, está continuamente 
// funcionando, es quien decide que proceso pasa a ejecutado, usa distintas 
// políticas o algoritmos, brinda cierta equidad.
// v1.2
// Autor: José Victor Ibáñez
/*------------------------- ------------- -------------------------*/

package Test;

import Model.Prioridad;
import Model.admProcesamiento;
import Model.admTablaProcesos;

public class TestLPNRR {

	public static void main(String[] args) {

		admProcesamiento admP1 = new admProcesamiento(20, 84);


		admP1.agregarProceso("P1", 4, 3, 4, 3, Prioridad.Baja);
		admP1.agregarProceso("P2", 2, 8, 2, 8, Prioridad.Media);
		admP1.agregarProceso("P3", 6, 2, 6, 4, Prioridad.Alta);
		admP1.agregarProceso("P4", 2, 5, 2, 7, Prioridad.Media);
		admP1.agregarProceso("P5", 5, 3, 1, 2, Prioridad.Alta);
		admP1.agregarProceso("P6", 6, 6, 5, 9, Prioridad.Baja);
		admP1.agregarProceso("P7", 2, 7, 1, 1, Prioridad.Media);
		admP1.agregarProceso("P8", 4, 5, 1, 9, Prioridad.Alta);

		System.out.println("----------- Planificador LPNRR -----------");
		System.out.println(admP1.mostrarPlanificador(admP1.planificarLPNRR(3)));
		System.out.println(admP1.mostrarProcesos() + "\n-> hay 1 procesador" + "\n-> E/S Se realiza en paralelo\n");
		
		System.out.println("----------- Resultados LPNRR -----------");
		admTablaProcesos admTP1 = new admTablaProcesos(admP1);
		System.out.println(admTP1.mostrarResultados(admP1.planificarLPNRR(3)));

	}

}
