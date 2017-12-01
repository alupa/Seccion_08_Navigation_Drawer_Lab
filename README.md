# Seccion_08_Navigation_Drawer_Lab
Laboratorio 8 Android - Menufy App.

Objetivo
--------
Crear una app que llamaremos Menufy, y en la cual vamos a hacer uso de Navigation Drawer, como hemos aprendido en los vídeos anteriores.

Tendremos 3 Fragments, Email, Alerts e Information. Tendremos una cabecera en el navigation drawer y un título con nuestro nombre. Hasta aquí,
bastante parecido a lo visto anteriormente.

Después de esas 3 opciones en nuestro navigation drawer, tendremos una opción más en otro grupo, llamada “Option” que representará un Switch.
Cómo personalizarlo de forma que se vea sin icono, alineado a la izquierda y no siendo seleccionable, sólo el Switch, no el texto. Controlar desde
nuestro MainActivity que cuando cambiemos el estado del Switch, mostremos un Toast diciendo si está en ON/OFF dependiendo del estado del
mismo.

Nuestros 3 fragments, deberán tener un FAB con diferentes iconos. Cada uno mostrará un diálogo diferente. cuando el FAB sea pulsado.
Tendremos que investigar como mostrar cuadros de diálogos en Android. Si necesitas una pista, abre el siguiente link: https://
developer.android.com/guide/topics/ui/dialogs.html?hl=es

Email: Mostraremos por defecto un textView centrado en el layout (“YOUR EMAIL”). El diálogo a mostrar debería ofrecernos la posibilidad de
insertar un email en un editText. Si pulsamos Aceptar, remplazaremos el TextView por defecto por el email, si cancelamos, no lo cambiaremos. No te
preocupes si cambiando entre fragments pierdes la info, puesto que no eso sería persistencia y no es el objetivo del ejercicio (aunque puedes
implementarlo si quieres con SharedPreferences o Realm).

Alerts: No mostramos ningún texto por defecto en el layout de Alerts, pero cuando abramos el diálogo, tendremos un Switch que si habilitamos y
aceptamos, Mostraremos en el layout de Alerts, “Alerts Enabled”, si lo deshabilitamos con el Switch y aceptamos, mostraremos “Alerts Disabled”.

Information: Texto por defecto en el layout “See More Info”. Cuando pulsemos en el FAB, ésta vez el Dialogo a mostrar es solo informativo, con un
botón neutral que no desencadena ninguna acción extra (Empieza por éste si es la primera vez que vas a crear un Cuadro de Diálogo de Android para ir
de mas sencillo a más complicado).

Intenta implementar todos los eventos clicks necesarios implementando la interfaz en el fragment/activity indicado, y sobre escribe el método
como es normal, de esta forma, en vez de implementarlo en línea con el típico fab.setOnClickListener( new OnClickListener….)
