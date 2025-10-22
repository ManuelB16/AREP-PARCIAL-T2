# Parcial Segundo Tercio Arep Lucas

La aplicacion consiste en un servicio proxy y dos backends, los cuales se rotan entre uno activo y el otro pasivo, el proxy recibe las request y este las dirige a los backends, y da el resultado esperado.

# Secuencia de Lucas

Esta secuencia se hace con  
L(0)=2
L(1)=1
L(n)=L(n−1)+L(n−2), para un n≥2.

# La request

Este debe usar el nombre de la funcion especificado y el parametro se le pasa en una variable de query con el nombre "value"

<img width="217" height="33" alt="image" src="https://github.com/user-attachments/assets/3858e03a-e1eb-481d-aec1-fdf974a49aa0" />

# Creacion de instancias para el proxy y backends

<img width="1607" height="97" alt="image" src="https://github.com/user-attachments/assets/2b96969d-d850-437d-b36c-1890657ccded" />

Cada instancia tiene un servicio corriendo respectivamente

Proxy
<img width="1110" height="683" alt="image" src="https://github.com/user-attachments/assets/aef2cc2f-0ac9-4e79-8ee9-645bc6ff5443" />

Back 1
<img width="1108" height="627" alt="image" src="https://github.com/user-attachments/assets/585215f5-e444-4484-938c-ec77572a5a29" />

Back 2
<img width="1111" height="624" alt="image" src="https://github.com/user-attachments/assets/034b50cc-1f85-46ff-8b84-aeb903c4dbde" />

# No se consigue hacer que el servicio funcione correctamente en las instancias pero se hace la prueba localmente

https://github.com/user-attachments/assets/526f6bee-6ed6-4678-965d-7621a2b37052

https://github.com/user-attachments/assets/3ce589d3-067b-432e-83bd-de26b5088de5



