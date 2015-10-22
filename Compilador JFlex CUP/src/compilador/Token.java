/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilador;

/**
 * Clase que implementa la estructura de un token.
 * 
 * @author Juan Camilo González Idárraga.
 * @author Luis Ernesto García Riojas.
 * @author Luis Emilio González Zapata.
 * @author Ingeniería de Sistemas y Computación - Semestre VI.
 * @author Universidad del Quindío.
 * @version 1.0
 * @since 2015-09-12
 */
public class Token {

    String token;
    String lexema;
    int linea;
    int columna;        
    int tamaño;
    int columnaf;

    /**
    * Constructor por defecto de la clase token
    */
    public Token() {
    }

    /**
     * Constructor que inicializa los valores del token
     * @param token Tipo de token
     * @param lexema Lexema del token
     * @param linea Linea donde se encuentra
     * @param columna Columna donde se encuentra
     * @param tamaño Tamaño del token
     */
    public Token(String token, String lexema, int linea, int columna, int tamaño) {
        this.token = token;
        this.lexema = lexema;
        this.linea = linea;
        this.columna = columna;
        this.tamaño = tamaño;
    }

    /**
    * Permite obtener la linea dentro del texto en la que esta el token
    * @return Linea del token
    */
    public int getLinea() {
        return linea;
    }

    /**
     * Permite establecer la linea del token
     * @param linea Linea del token
     */
    public void setLinea(int linea) {
        this.linea = linea;
    }

    /**
     * Permite obtener el lexema que compone el token
     * @return Lexema del token
     */
    public String getLexema() {
        return lexema;
    }

    /**
     * Permite establecer el lexema de un token
     * @param lexema Lexema del token
     */
    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    /**
     * Permite obtener la categoria o tipo de token
     * @return Tipo de token
     */
    public String getToken() {
        return token;
    }

    /**
     * Permite establecer la categoria o tipo de token
     * @param token Tipo de token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Permite obtener la columa dentro del texto en donde se encuentra el token
     * @return Columna del token
     */
    public int getColumna() {
        return columna;
    }

    /**
     * Permite establecer la columna dentro del texto en donde se encuentra el token
     * @param columna Columna del token
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * Permite obtener la columnaf del token
     * @return Columnaf del token
     */
    public int getColumnaf() {
        return columnaf;
    }

    /**
     * Permite establecer la columnaf del token
     * @param columnaf Columnaf del token
     */
    public void setColumnaf(int columnaf) {
        this.columnaf = columnaf;
    }

    /**
     * Permite obtener el tamaño que ocupa el token
     * @return Tamaño del token
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * Permite establecer el tamaño que ocupa el token
     * @param tamaño Tamaño del token
     */
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

}
