# Proyecto Librería 📖

El objetivo de este proyecto es desarrollar un sistema de gestión de una tienda de libros en Java que incluya funcionalidades de manejo de inventario, gestión de clientes, ventas, interfaz gráfica de usuario (GUI) y persistencia de datos en archivos.

## Estructura del proyecto ⚙️
> [!NOTE]
> Esta estructura está sujeta a cambios.
```
Da un ejemplo
```

## Ejecutando las pruebas 🧪

> [!CAUTION]
> No todas las pruebas realizadas han sido comprobadas.


_Explica que verifican estas pruebas y por qué_

```
Da un ejemplo
```
## Despliegue 📦

_Agrega notas adicionales sobre como hacer deploy_

## Complicaciones 🐛
```

```
## Objetivos 🎯

Integrar los diferentes módulos desarrollados por los otros equipos en una aplicación funcional y completa.

*	Crear la clase Ensamblador con métodos para integrar los diferentes elementos del sistema, como clientes, libros, archivos, etc.
*	Definir subclases específicas para manejar ventas, archivos y reportes, e implementa los métodos necesarios para cada una.

•	Atributos:
- [ ] clientes: Una lista de objetos Cliente.
- [ ]  libros: Una lista de objetos Libro.
- [ ]  archivos: Una lista de objetos Archivo.
*	Métodos:
- [ ]  agregarCliente(Cliente cliente): Agrega un cliente a la lista de clientes.
- [ ] eliminarCliente(Cliente cliente): Elimina un cliente de la lista.
- [ ] 	agregarLibro(Libro libro): Agrega un libro a la lista de libros.
- [ ] 	eliminarLibro(Libro libro): Elimina un libro de la lista.
- [ ] 	agregarArchivo(Archivo archivo): Agrega un archivo a la lista de archivos.
- [ ] 	eliminarArchivo(Archivo archivo): Elimina un archivo de la lista.
- [ ] buscarClientePorNombre(String nombre): Busca un cliente por su nombre y devuelve el objeto Cliente correspondiente.
- [ ] 	buscarLibroPorTitulo(String titulo): Busca un libro por su título y devuelve el objeto Libro correspondiente.
- [ ] 	guardarDatosEnArchivo(Archivo archivo): Guarda los datos de la tienda de libros en un archivo especificado.
- [ ] 	cargarDatosDesdeArchivo(Archivo archivo): Carga los datos de la tienda de libros desde un archivo especificado.
- [ ] 	generarInforme(): Genera un informe con estadísticas sobre la tienda de libros, como el número de clientes, libros disponibles, etc.
-------------------------------------------------------------------
* Subclase EnsambladorVentas:
Esta subclase de Ensamblador se especializa en el ensamblaje de las ventas de libros.
	Atributos adicionales:
- [ ] 	ventas: Una lista de objetos Venta.
	Métodos adicionales:
- [ ] 	agregarVenta(Venta venta): Agrega una venta a la lista de ventas.
- [ ] 	eliminarVenta(Venta venta): Elimina una venta de la lista.
- [ ] 	buscarVentaPorCliente(Cliente cliente): Busca todas las ventas asociadas a un cliente específico.
- [ ]	buscarVentaPorLibro(Libro libro): Busca todas las ventas asociadas a un libro específico.
- [ ]	calcularTotalVentas(): Calcula el total de ventas realizadas.
----------------------------------------------------------------------------------------------
* Subclase EnsambladorArchivos:
Esta subclase de Ensamblador se encarga de manejar los archivos en la tienda de libros.
•	Métodos adicionales:
- [ ]	guardarDatosEnArchivos(): Guarda todos los datos de la tienda de libros en archivos específicos.
- [ ] cargarDatosDesdeArchivos(): Carga todos los datos de la tienda de libros desde archivos específicos.
----------------------------------------------------------------------------------------------------------------------------------------------
* Subclase EnsambladorReportes:
Esta subclase de Ensamblador se dedica a generar reportes y estadísticas sobre la tienda de libros.
-	Métodos adicionales:
- [ ]	generarReporteClientes(): Genera un reporte con información detallada sobre los clientes.
- [ ]	generarReporteLibros(): Genera un reporte con información detallada sobre los libros disponibles.
- [ ] generarReporteVentas(): Genera un reporte con información detallada sobre las ventas realizadas.

## Construido con 🛠️

 <img alt="imagen-java" height="60" src="./java-original.svg"> Java

## Autores ✒️

* **Guillermo Castro Abarca**
* **Geovana Da Silva Oliveira**
* **Luigi Alfonso Pineda**
* **Gianfranco**

 :+1: This PR looks great - it's ready to merge! :shipit:
