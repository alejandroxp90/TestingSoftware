package org.scripts.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CheckLinks {

    //Esta es la primera clase para el PAGE OBJECT MODEL POM
    //Checar todos los links de una pagina web

    private WebDriver driver;

    public CheckLinks(WebDriver driver) {
        this.driver = driver;
    }

    // se crea el metodo que checara en la pagina los links

    public boolean checkingPageLinks(){

        List<WebElement> links = driver.findElements(By.tagName("a"));
        String url = "";
        List<String> brokenLinks = new ArrayList<String>();
        List<String> okLinks = new ArrayList<String>();
        //Permite crear una conexion http el error se resuelve importando
        //la libreria import java.net.*;
        HttpURLConnection httpConection = null;
        //En la variable responseCode se guardara el codigo de estado de la conexion.
        int responseCode = 200;
        //crear un iterador para iterar en la lista de links
        Iterator<WebElement> it = links.iterator();

        while (it.hasNext()){
            //Devolvera el elemento url con el atributo href
            //De esta forma estamos guardando en la variable url la url del link que viene en el atributo
            url = it.next().getAttribute("href");
            //Si hay una etiqueta a y no tiene href
            if (url==null || url.isEmpty()){
                System.out.println(url + " La url is not configured or it is empty");
                continue;
            }
            try {
                //Se establecera la conexion HTTP con un casteo para convertir httpURLConnection
                //Se hace un casteo para convertir lo que nos devuelve a httpurlconnection
                httpConection = (HttpURLConnection)(new URL(url).openConnection());
                httpConection.setRequestMethod("HEAD");
                // con el metodo HEAD solicita el encabezado de la pagina en vez de GET solicita el header
                httpConection.connect();
                responseCode = httpConection.getResponseCode();

                //Verificamos el codigo de respuesta para analizar el error.

                if (responseCode > 400){
                    System.out.println("**** ERROR BROKEN LINK: -- " + url);
                    brokenLinks.add(url);
                }else {
                    System.out.println("***** VALID LINK: -- " + url);
                    okLinks.add(url);
                }
            }catch (Exception e){

                e.printStackTrace();

            }

        }

        System.out.println("Valid links " + okLinks.size());
        System.out.println("Invalid links " + brokenLinks.size());

        // vamos a iterar sobre la lista de links rotos para imprimir todos los links que tienen problemas.

        if(brokenLinks.size()>0){
            System.out.println("****** ERROR -------------------------- Broken Links");

            for (int i = 0; i < brokenLinks.size(); i++){
                System.out.println(brokenLinks.get(i));
            }

            return false;

        }else {

            return true;

        }
        // FIN DE LA CLASE PAGE
    }

}