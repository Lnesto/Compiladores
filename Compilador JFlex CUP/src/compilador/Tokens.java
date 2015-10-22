/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilador;

/**
 * Enumeracion de los tokens utilizados en el lenguaje.
 * 
 * @author Juan Camilo González Idárraga.
 * @author Luis Ernesto García Riojas.
 * @author Luis Emilio González Zapata.
 * @author Ingeniería de Sistemas y Computación - Semestre VI.
 * @author Universidad del Quindío.
 * @version 1.0
 * @since 2015-09-12
 */
public enum Tokens {
    Suma,Multiplicacion,Division,Resta,Modulo,SumaIgual,RestaIgual,MultiplicacionIgual,DivisionIgual,ModuloIgual,
    Comparacion,Incremento,Decremento,Mayor,Menor,MayorIgual,MenorIgual,NotIgual,Asignacion,Not,Or,And,
    AperturaParentesis,CerraduraParentesis,AperturaLlave,CerraduraLlave,AperturaCorchete,CerraduraCorchete,Identificador,ValorEntero,ValorReal,
   PuntoComa,DosPuntos,Coma,Cadena,ERROR
}
