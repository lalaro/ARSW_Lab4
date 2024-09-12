## Escuela Colombiana de Ingeniería

## Arquitecturas de Software

# Componentes y conectores - Parte I.

El ejercicio se debe traer terminado para el siguiente laboratorio (Parte II).

#### Middleware- gestión de planos.


## Antes de hacer este ejercicio, realice [el ejercicio introductorio al manejo de Spring y la configuración basada en anotaciones](https://github.com/ARSW-ECI/Spring_LightweightCont_Annotation-DI_Example).

En este ejercicio se va a construír un modelo de clases para la capa lógica de una aplicación que permita gestionar planos arquitectónicos de una prestigiosa compañia de diseño. 

![](img/ClassDiagram1.png)

1. Configure la aplicación para que funcione bajo un esquema de inyección de dependencias, tal como se muestra en el diagrama anterior.


	Lo anterior requiere:

	* Agregar las dependencias de Spring.
	* Agregar la configuración de Spring.
	* Configurar la aplicación -mediante anotaciones- para que el esquema de persistencia sea inyectado al momento de ser creado el bean 'BlueprintServices'.
Debemos revisar dependecias:

![](./img/media/Image1.jpeg)

![](./img/media/Image2.jpeg)

Agregamos el @Service a la clase BlueprintsPersistence
![](./img/media/Image3.jpeg)

Creamos el archivo xml applicationContext.xml
![](./img/media/Image5.jpeg)

Añadimos la clase Main y lo conectamos con el archivo 'new ClassPathXmlApplicationContext("applicationContext.xml");'
![](./img/media/Image4.jpeg)

2. Complete los operaciones getBluePrint() y getBlueprintsByAuthor(). Implemente todo lo requerido de las capas inferiores (por ahora, el esquema de persistencia disponible 'InMemoryBlueprintPersistence') agregando las pruebas correspondientes en 'InMemoryPersistenceTest'.

El método getBluePrint() será @Override y actualizado con las condiciones necesarias
![](./img/media/Image6.jpeg)

El método addNewBlueprint(Blueprint bp), traera el dato dpp.saveBlueprint(bp);

![](./img/media/Image7.jpeg)

LLamaremos al método anterior desde la clase de BlueprintsPersistence
![](./img/media/Image8.jpeg)

Pruebas correspondientes a lo implementado anteriormente:
![](./img/media/Image9.jpeg)
![](./img/media/Image10.jpeg)

3. Haga un programa en el que cree (mediante Spring) una instancia de BlueprintServices, y rectifique la funcionalidad del mismo: registrar planos, consultar planos, registrar planos específicos, etc.

Se deben realizar los siguientes cambios para las clases correspondientes para crear la instancia de BlueprintServices:
a.
![](./img/media/Image11.jpeg)
b.
![](./img/media/Image12.jpeg)
c.
![](./img/media/Image13.jpeg)
d.
![](./img/media/Image14.jpeg)

4. Se quiere que las operaciones de consulta de planos realicen un proceso de filtrado, antes de retornar los planos consultados. Dichos filtros lo que buscan es reducir el tamaño de los planos, removiendo datos redundantes o simplemente submuestrando, antes de retornarlos. Ajuste la aplicación (agregando las abstracciones e implementaciones que considere) para que a la clase BlueprintServices se le inyecte uno de dos posibles 'filtros' (o eventuales futuros filtros). No se contempla el uso de más de uno a la vez:
	* (A) Filtrado de redundancias: suprime del plano los puntos consecutivos que sean repetidos.
	* (B) Filtrado de submuestreo: suprime 1 de cada 2 puntos del plano, de manera intercalada.

Se creara una carpeta de filters, con tres clases como se muestra a continuación:
![](./img/media/Image15.jpeg)

Clase BlueprintsFilter:
![](./img/media/Image19.jpeg)

Clase SubsamplingFilter:
![](./img/media/Image16.jpeg)

Clase RedundancyFilter:
![](./img/media/Image17.jpeg)

Y se realiza la inserción de dependencias por:
![](./img/media/Image18.jpeg)

5. Agrege las pruebas correspondientes a cada uno de estos filtros, y pruebe su funcionamiento en el programa de prueba, comprobando que sólo cambiando la posición de las anotaciones -sin cambiar nada más-, el programa retorne los planos filtrados de la manera (A) o de la manera (B). 
![](./img/media/Image19.jpeg)
