/*-------------------------- Algoritmo SRT ------------------------*/
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

public class TestSRT {

	public static void main(String[] args) {

		admProcesamiento admP1 = new admProcesamiento(20, 48);


		admP1.agregarProceso("P1", 1, 4, 3, 3, Prioridad.Alta);
		admP1.agregarProceso("P2", 1, 2, 4, 4, Prioridad.Baja);
		admP1.agregarProceso("P3", 3, 2, 5, 1, Prioridad.Media);
		admP1.agregarProceso("P4", 3, 1, 4, 5, Prioridad.Media);
		admP1.agregarProceso("P5", 5, 3, 2, 3, Prioridad.Alta);

		System.out.println("----------- Planificador SRT -----------");
		System.out.println(admP1.mostrarPlanificador(admP1.planificarSRT()));
		System.out.println(admP1.mostrarProcesos() + "\n-> hay 1 procesador" + "\n-> E/S Se realiza en paralelo\n");
		
		System.out.println("----------- Resultados SRT -----------");
		admTablaProcesos admTP1 = new admTablaProcesos(admP1);
		System.out.println(admTP1.mostrarResultados(admP1.planificarSRT()));

	}

}
