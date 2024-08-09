# Androidnativeclientapp


## Versión Mínima de Android: Android 7.0 Nougat (API 24)

Razón: Android Nougat es lo suficientemente moderno como para incluir soporte robusto para Custom Tabs y es ampliamente utilizado en muchos dispositivos.
Compatibilidad: Asegura compatibilidad con una amplia base de usuarios sin comprometer muchas características modernas.

## Version minima de Chrome

Para utilizar Custom Tabs en un dispositivo Android que ejecuta API 24 (Nougat) o superior, necesitas que Chrome esté 
instalado y actualizado a una versión compatible con Custom Tabs. La compatibilidad con Custom Tabs comenzó con Chrome 45.0, 
que fue lanzado en septiembre de 2015. Así que cualquier versión de Chrome desde la 45.0 en adelante será compatible.

## Consideraciones acerca de CustomTabs

-- CustomTabs es una tecnologia que permite la interaccion entre una applicacion mobile y contenido web. Este contenido web es renderizado en una version light 
del navegador chrome directamente, por lo tanto se heredan todas las vertajas de usar un browser (a diferencia de webview). Se pueden configurar algunos
aspectos de la "pestaña personalizada", como agregar opciones de menu, setear varios colores, customizar el boton de atras o cerrar y demas. Es importante
mencionar que una vez que se abre el CustomTab este se visualiza como adentro de la app, pero ocupando el 100% de la pantalla. No esta disponible
-- No todos los dispositivos Android vienen con chrome instalado, en cuyo caso se debe proveer de un mecanismo (Fallback) para abrir 
la pagina en un webview o en otro navegador
-- Por otro lado CustomTabs es una tecnologia que se encuentra implementada no solamente en Chrome, por lo tanto se puede revisar que navegadores soportan CustomTabs y en caso
de que el dispositivo no tenga instalado Chrome buscar alternativas y evitar webView.
-- Cuando usamos CustomTabs el usuario cuenta con toda la configuracion y seteos de su browser (passwords, history, etc).
-- Se puede configurar un Receiber en la app para notificar a la app acerca de cambios especificos en la navegacion de la web por parte del usuario, como por ejemplo
si el usuario clickeo un boton o marco un checkbox o cualquier otro evento del lado del browser.
