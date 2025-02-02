import java.util.UUID

class Tarea(val identificador: Int, val descripcion: String?) {
    companion object {
        fun generarIdentificador(): Int = UUID.randomUUID().toString().hashCode()
    }

    var estadoTarea: String = "Sin completar"

    override fun toString(): String = "Identificador: $identificador\nDescripcion: $descripcion\nEstado: $estadoTarea "
}