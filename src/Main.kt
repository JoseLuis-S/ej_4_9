fun main() {
    var salir = false
    val agenda = ListaTareas()
    do {
        mostrarMenu()
        val opcion = elegirOpcion()
        when (opcion) {
            1 -> {
                print("Introduzca una descripcion de la tarea a añadir: ")
                val descripcion = readLine()
                agenda.lista.add(Tarea(Tarea.generarIdentificador(), descripcion))
                presioneEnter()
            }
            2 -> {
                print("Introduzca el identificador de la tarea: ")
                val identificador = try {
                    readLine()!!.toInt()
                } catch (e: NumberFormatException) {
                    println("Identificador no valido")
                    null
                }
                if (identificador != null) agenda.eliminarTarea(identificador)
                presioneEnter()
            }
            3 -> {
                print("Introduzca el identificador de la tarea: ")
                val identificador = try {
                    readLine()!!.toInt()
                } catch (e: NumberFormatException) {
                    println("Identificador no valido")
                    null
                }
                if (identificador != null) agenda.cambiarEstadoTarea(identificador)
                presioneEnter()
            }
            4 -> {
                agenda.mostrarTareas()
                presioneEnter()
            }
            5 -> salir = preguntarSalir()
        }

    } while (!salir)

    println("Hasta nunca!!")
}

fun mostrarMenu() {
    println("1.- Agregar tarea.\n" +
            "2.- Eliminar tarea.\n" +
            "3.- Cambiar estado tarea.\n" +
            "4.- Mostrar tareas.\n" +
            "5.- Salir.\n")
}

fun elegirOpcion(): Int {
    var opcion: Int
    do {
        print("Elija una opcion (1-5): ")
        val temp = readLine()

        opcion = try {
            temp!!.toInt()
        } catch (e: NumberFormatException) {
            0
        }

    } while (opcion !in 1..5)

    return opcion
}

fun preguntarSalir(): Boolean {
    var opcion: String?
    do {
        print("¿Seguro desea salir? (s/n): ")
        opcion = readLine()

    } while (opcion != "s" && opcion != "n")

    return opcion == "s"
}

fun presioneEnter() {
    print("\nPresione enter para continuar...\n")
    readLine()
}