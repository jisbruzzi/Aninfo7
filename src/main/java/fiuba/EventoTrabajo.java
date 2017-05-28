package fiuba;

public class EventoTrabajo {
	private Empleado empleado;
	private float horas;

	EventoTrabajo(Empleado e, float hs) {
		this.empleado=e;
		this.horas=hs;
	}

	public float obtenerHoras() {
		return this.horas;
	}

}
