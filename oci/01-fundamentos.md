# 1. Introducción y Conceptos Básicos OCI

## 1.1 Fundamentos OCI

Oracle Cloud Infrastructure (OCI) esta formado por un conjunto de servicios en
la nube que permiten la construcción y ejecución de aplicaciones y servicios
en ambientes que permiten implementar diversos requerimientos no funcionales como
alta disponibilidad, etc.

OCI ofrece la administración de recursos de formas diversas:

* **Oracle Cloud Console** Formada por una interfaz gráfica que permite la
  administración de instancias, redes cloud, almacenamiento, , usuarios, permisos.
* **APIs** Formadas por un conjunto de APIs tipo REST  que hacen uso de peticiones
  HTTPS.
* **SDKs**  Software Development Kits (SDKs) facilitan el uso de las APIs OCI
  empleando diversos lenguajes de programación: Java, Ruby, Python.
* **Command line interface** (CLI) permite el uso de algunos servicios. Ofrece
  la misma funcionalidad de la consola mas algunos comandos adicionales, por
  ejemplo, ejecutar scripts. etc.
* **Cloud Shell** Es una interface a línea de comandos pero embebida en una
   página web que puede ser accedida desde la consola gráfica. Representa una
   alternativa para ejecutar comandos de forma rápida.
* **Terraform** Representa una solución _Infrastructure as code_ (IaC), es decir,
  software  que permite definir recursos de infraestructura en archivos  que
  pueden ser almacenados y compartidos.
* **Ansible** Herramienta empleada para automatizar la configuración y aprovisionamiento
  de infraestructura en la nube, deployment, actualización de software, orquestación
  de procesos complejos.
* **Resource manager** Es un servicio OCI que permite automatizar el proceso de
 aprovisionamiento de recursos en la nube (OCI resources). El uso de Terraform en
 conjunto con un Resource manager permite instalar, configurar, y adminsitrar
 recursos Siguiendo un modelo **Iac** (Infrastructure as code)

## 1.2 Conceptos OCI - Arquitectura física

### 1.2.1 Regiones

La infraestructura OCI esta soportada por un conjunto de regiones y _availability domains_
Una región es un área geográfica. Un availability domain  esta formado por un conjunto
de **data centers** localizados en una región. En una región pueden existir varios
_availability domains_.

Algunos recursos son particulares a una región, por ejemplo, una _virtual cloud network_,
etc. Availability domains son totalmente independientes entre sí con la finalidad
de implementar alta disponibilidad.

Availability domains están interconectados por una red de una muy baja latencia y un
ancho de banda grande. Entre otros beneficios, estas características permiten
configurar sistemas replicados de alta disponibilidad.

Cada región cuenta con un _availability domain_.  Cuando una región requiere crecer
o aumentar sus capacidades se pueden realizar las siguientes acciones:

* Agregar capacidad  a los availability domains
* Agregar más availability domains a una región
* Construir una nueva región

Regiones son independientes entre si, una aplicación puede ser instalada en la
región más cercada a sus clientes que la usan con mayor frecuencia, o en varias
regiones.

Regiones son agrupadas en **Realms**. Tenancies existen en un solo realm,
y puede acceder a todas las regiones que pertenecen al realm. OCI  define
algunos realms:

* Commercial
* Government
* Dedicated

### 1.2.2 x
