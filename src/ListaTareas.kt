import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ListaTareas() {
    companion object {
        fun generarFechaTareas(): String {
            val fechaHoraActual: LocalDateTime = LocalDateTime.now()
            val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
            return fechaHoraActual.format(formatter)
        }
    }
    val lista: MutableList<Tarea> = ArrayList()

    fun agregarTarea(tarea: Tarea) {
        lista.add(tarea)
        println("Tarea agregada: ${tarea.identificador}")
    }
    fun eliminarTarea(identificador: Int) {
        for (i in lista) {
            if (identificador == i.identificador) {
                lista.remove(i)
                println("Tarea eliminada: ${i.identificador}")
            }
        }
        println("Identificador erroneo: $identificador")
    }
    fun cambiarEstadoTarea(identificador: Int) {
        for (i in lista) {
            if (i.identificador == identificador ) {
                if (i.estadoTarea == "Completada") println("La tarea ya fue completada.") else i.estadoTarea = "Completada | Fecha: ${generarFechaTareas()}"
                println("Estado actual: ${i.estadoTarea}")
                return
            }
        }
        println("Error, no se ha podido cambiar el estado")
    }
    fun mostrarTareas() {
        var contador = 1
        for (i in lista) {
            println("Tarea $contador")
            println(i)
            println()
            contador++
        }
    }
}