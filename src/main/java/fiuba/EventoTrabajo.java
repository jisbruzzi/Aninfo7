package fiuba;

public class EventoTrabajo {
	private Empleado empleado;
	private float horas;

	public EventoTrabajo(Empleado e, float hs) {
		this.empleado=e;
		this.horas=hs;
	}

	public float obtenerHoras() {
		return this.horas;
	}

}
