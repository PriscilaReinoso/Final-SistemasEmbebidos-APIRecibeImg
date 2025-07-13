# Final-SistemasEmbebidos-APIRecibeImg
Desarrollo del codigo para el examen final de la materia "Sistemas Embebidos" de la UNLa. Se expone un servicio que recibe imagenes.
Metodo brindado por IA "ChatGPT"

- Metodo: POST - endpoint:  /image/upload - body: form-data key=image (tipo File) value=imagen a pasar
- con el comando docker compose up -d se levanta la API
- Las imagenes se guardan en la carpeta uploads a la altura de la carpeta api