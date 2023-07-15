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

### 1.2.1 Regions, Availability domains

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

Availability domains están aislados unos de otros, tolerante a fallas.
Al configurar servicios de Cloud se deben emplear múltiples availability
domains para asegurar disponibilidad.

### 1.2.2 2 Fault domains

* Conjunto de recursos de hardware e infraestructura dentro de un mismo
  availability domain
* Cada availability domain contiene 3 fault domains.
* Fault domains permiten distribuir las instancias del cliente de tal forma
  que no compartan hardware dentro del mismo availability domain.
* La ocurrencia de una falla afectará a un solo fault domain, pero no a los
  demás.  

## 1.3 Cuentas y accesos

### 1.3.1 Tenancy

* Al momento de crear una suscripción a Oracle OCI se crea un tenancy.
* Tenancy puede ser visto como una cuenta de usuario.
* Representa una especie de partición segura y aislada en la cual se pueden
  administrar recursos OCI.
* Cuando se crea un tenancy, por default se asigna a la región seleccionada por
  el cliente. Posteriormente, el tenancy puede suscribirse a otras regiones
  (multiple tenancies).

### 1.3.2 Compartment

* Un compartment permite administrar el control de acceso a cloud resources.
  puede ser visto como un contenedor lógico de recursos.
* Cada compartment esta formado por un conjunto de estos recursos (instancias,
  virtual cloud networks, block volumes) que serán accedidos únicamente por
  ciertos grupos con permisos específicos.
* Al crear un tenancy, se le asocia un **root compartment** el cual asocia
  a todos los recursos del tenancy.
* Cuando se crea un recurso se debe especificar el compartment al que pertenece.

### 1.3.3 Identity domains, policies

* Representa un contenedor empleado para administrar usuarios y roles.
* Un policy representa un documento que especifica quién puede acceder a
  ciertos recursos y de qué forma. Un usuario puede escribir sus propias policies
* Policies pueden ser aplicadas a un compartment en específico  o inclusive
  pueden ser aplicadas al root compartment (tenancy). Al otorgar un permiso
  a nivel tenancy, dicho permiso será aplicado a todos los compartments definidos
  dentro del tenancy

## 1.4 Introducción a IAM

* IAM (Identity and Access Management) define una serie de funcionalidades como
  son:
  * Autenticación
  * Single sign on (SSO)
  * Identity lifecycle management
* Estas funcionalidades permiten administrar el control de acceso a aplicaciones
  en cualquier momento, desde cualquier lugar, y desde cualquier dispositivo de
  forma segura.
* IAM puede integrarse con fuentes de identidad existente (Identity stores),
  con proveedores externos, y aplicaciones tanto en la nube como con aplicaciones
  on-premises.
* IAM ofrece la plataforma de seguridad para OCI.

### 1.4.1  Escenario de ejemplo

* Una empresa cuenta con 2 equipos que harán uso de 2 proyectos en OCI: proyectos
  A y B.
* La compañía hará uso de una VCN (Virtual Cloud Network), se requiere de un
  usuario administrador para esta red.

  https://confluence.oci.oraclecorp.com/spaces/viewspace.action?key=DEVCENTRAL
  
  https://confluence.oci.oraclecorp.com/display/DEVCENTRAL/Training+on+Fundamentals%2C+Networking%2C+Core+Services%2C+and+OCI+Platform

  https://docs.oracle.com/en-us/iaas/Content/General/Concepts/regions.htm#About

  https://mylearn.oracle.com/ou/component/-/108432/165494