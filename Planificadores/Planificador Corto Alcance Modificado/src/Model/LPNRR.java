public Tabla[][] planificarLPNRR(int quantum) {
		// Preparo Datos
		List<Proceso> procesos = clone(getLstProcesos());
		Tabla[][] auxTabla = newTable();
		// Preparo el hilo 
		getHilo().setEjecutando(false);
		// Contadores
		int cont = procesos.size();
		int timeOut = quantum;

		// Si existen Procesos cargado entonces resuelvo algoritmo 
		if (!procesos.isEmpty()) {
			// Por toda la tabla agrego los estados 
			for (int columna = 0; columna < getCantidaColumnas(); columna++) {
				// Se Realiza Turnos Rotativos: No
				
				// Se pasa proceso a: Listo
				if (cont >= 0) {
					if (listarProcesoEntrada(procesos,columna)) {
						cont--;
						// Se promueve Proceso: No
						
					}
				}
				// Se pasa proceso Bloqueado a: Listo
				listarProcesoBloqueado();
				// Se Ordena: Si
				getListo().ordenarTiempoTotal(); /***Ordeno por Tiempo Total***/
				// Se saca un proceso de Listo a: Ejecutando
				prosesarProceso();
				// Se Revisa CPU y Ejecuto Proceso
				if (activador(auxTabla,columna)) {
					prosesarProceso(); // Caso de que se bloquea o termina Proceso anterior. Se saca un proceso de Listo a: Ejecutando
					activador(auxTabla,columna);
					// Se reinicia quantum: SI
					timeOut=quantum;

				}
				// Se resta Quantum: SI
				timeOut--;
				
				// Se realiza E/S: Paralelo
				ejecutarEyS(auxTabla,columna);
			}// Fin del tiempo de la tabla 
		}
		return auxTabla;
	}