
/* --------------------------Codigo de Usuario----------------------- */

package ejemplocup;

import java_cup.runtime.*;
import java.io.Reader;

import static compilador.Tokens.*;
      
%% //inicio de opciones
   
/* ------ Seccion de opciones y declaraciones de JFlex -------------- */  
   
/* Cambiamos el nombre de la clase del analizador a Lexer */

%class AnalizadorLexico

/*
    Activar el contador de lineas, variable yyline
    Activar el contador de columna, variable yycolumn
*/

/* %type Tokens */

%line
%column
    
/* 
   Activamos la compatibilidad con Java CUP para analizadores
   sintacticos(parser)
*/

%cup
   
/*
    Declaraciones

    El codigo entre %{  y %} sera copiado integramente en el 
    analizador generado.
*/

%{

    public String lexeme;
    public int line;
    public int column;

    /*  Generamos un java_cup.Symbol para guardar el tipo de token encontrado */

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    /* Generamos un Symbol para el tipo de token encontrado junto con su valor */

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}
   
/*
    Macro declaraciones
  
    Declaramos expresiones regulares que despues usaremos en las
    reglas lexicas.
*/
   
/*  Un salto de linea es un \n, \r o \r\n dependiendo del SO   */
Salto = \r|\n|\r\n
   
/* Espacio es un espacio en blanco, tabulador \t, salto de linea o avance de pagina \f, normalmente son ignorados */
Espacio     = {Salto} | [ \t\f]
   
/* Una literal entera es un numero 0 oSystem.out.println("\n*** Generado " + archNombre + "***\n"); un digito del 1 al 9 seguido de 0 o mas digitos del 0 al 9 */
Entero = 0 | [1-9][0-9]*

L = [a-zA-ZñÑ]
S = [_]
D = [0-9]
Simbolos=[\|\(\)\{\}\[\]\<\>\\\.\*\+\?\^\$\/\.\~\!@]
Space=[ \t]
V=[ÁáÉéíÍÓóÚúü]


%% //fin de opciones
/* -------------------- Seccion de reglas lexicas ------------------ */
   
/*
   Esta seccion contiene expresiones regulares y acciones. 
   Las acciones son código en Java que se ejecutara cuando se
   encuentre una entrada valida para la expresion regular correspondiente */
   
   /* YYINITIAL es el estado inicial del analizador lexico al escanear.
      Las expresiones regulares solo serán comparadas si se encuentra
      en ese estado inicial. Es decir, cada vez que se encuentra una 
      coincidencia el scanner vuelve al estado inicial. Por lo cual se ignoran
      estados intermedios.*/
   
<YYINITIAL> {
   
    /* No hace nada si encuentra el espacio en blanco */
    {Espacio}       { /* ignora el espacio */ } 

    "//".* {/*Ignore*/}
    
    /* Regresa que el token SEMI declarado en la clase sym fue encontrado. */
    ";" { return symbol(sym.SEMI); }

    /* Regresa que el token OP_SUMA declarado en la clase sym fue encontrado. */
    "+" {  System.out.print(" + "); return symbol(sym.OP_SUMA); }

    /* Regresa que el token OP_SUMA declarado en la clase sym fue encontrado. */
    "-" {  System.out.print(" - "); return symbol(sym.OP_RESTA); }

    /* Regresa que el token OP_SUMA declarado en la clase sym fue encontrado. */
    "*" {  System.out.print(" * "); return symbol(sym.OP_MULT); }

    /* Regresa que el token PARENIZQ declarado en la clase sym fue encontrado. */
    "(" {  System.out.print(" ( "); return symbol(sym.PARENIZQ); }

    /* Regresa que el token PARENIZQ declarado en la clase sym fue encontrado. */
    ")" {  System.out.print(" ) "); return symbol(sym.PARENDER); }

    "." {  System.out.print(" / "); line=yyline; column=yycolumn; return symbol(sym.POINT); }
    "/" {  System.out.print(" / "); line=yyline; column=yycolumn; return symbol(sym.OP_DIV); }
    "=" {  System.out.print(" = "); line=yyline; column=yycolumn; return symbol(sym.ASIG); }
    "==" {  System.out.print(" == "); line=yyline; column=yycolumn; return symbol(sym.COMP); }
    "%" {  System.out.print(" % "); line=yyline; column=yycolumn; return symbol(sym.MOD); }
    "+=" {  System.out.print(" += "); line=yyline; column=yycolumn; return symbol(sym.SUMEQ); }
    "-=" {  System.out.print(" -= "); line=yyline; column=yycolumn; return symbol(sym.RESTEQ); }
    "*=" {  System.out.print(" *= "); line=yyline; column=yycolumn; return symbol(sym.MULTEQ); }
    "/=" {  System.out.print(" /= "); line=yyline; column=yycolumn; return symbol(sym.DIVEQ); }
    "%=" {  System.out.print(" %= "); line=yyline; column=yycolumn; return symbol(sym.MODEQ); }
    "!" {  System.out.print(" ! "); line=yyline; column=yycolumn; return symbol(sym.NOT); }
    "!=" {  System.out.print(" != "); line=yyline; column=yycolumn; return symbol(sym.NOTEQ); }
    "&&" {  System.out.print(" && "); line=yyline; column=yycolumn; return symbol(sym.AND); }
    "||" {  System.out.print(" || "); line=yyline; column=yycolumn; return symbol(sym.OR); }
    "{" {  System.out.print(" { "); line=yyline; column=yycolumn; return symbol(sym.KEYIZQ); }
    "}" {  System.out.print(" } "); line=yyline; column=yycolumn; return symbol(sym.KEYDER); }
    "[" {  System.out.print(" [ "); line=yyline; column=yycolumn; return symbol(sym.CORIZQ); }
    "]" {  System.out.print(" ] "); line=yyline; column=yycolumn; return symbol(sym.CORDER); }
    ">" {  System.out.print(" < "); line=yyline; column=yycolumn; return symbol(sym.MAYOR); }
    ">=" {  System.out.print(" >= "); line=yyline; column=yycolumn; return symbol(sym.MAYOREQ); }
    "<" {  System.out.print(" > "); line=yyline; column=yycolumn; return symbol(sym.MENOR); }
    "<=" {  System.out.print(" <= "); line=yyline; column=yycolumn; return symbol(sym.MENOREQ); }
    ":" {  System.out.print(" : "); line=yyline; column=yycolumn; return symbol(sym.POINTS); }
    "++" {  System.out.print(" ++ "); line=yyline; column=yycolumn; return symbol(sym.INC); }
    "--" {  System.out.print(" -- "); line=yyline; column=yycolumn; return symbol(sym.DEC); }
    "," {  System.out.print(" , "); line=yyline; column=yycolumn; return symbol(sym.COMA); }
    "?" {  System.out.print(" ? "); line=yyline; column=yycolumn; return symbol(sym.INTROG); }
    "clas" {  System.out.print(" clas "); line=yyline; column=yycolumn; return symbol(sym.CLASS); }
"clas" {  System.out.print(" clas "); line=yyline; column=yycolumn; return symbol(sym.CLASS); }
    "true" {  System.out.print(" true "); line=yyline; column=yycolumn; return symbol(sym.TRUE); }
    "fals" {  System.out.print(" fals "); line=yyline; column=yycolumn; return symbol(sym.FALSE); }
    "ret" {  System.out.print(" ret "); line=yyline; column=yycolumn; return symbol(sym.RET); }
    "if" {  System.out.print(" if "); line=yyline; column=yycolumn; return symbol(sym.IF); }
    "else" {  System.out.print(" else "); line=yyline; column=yycolumn; return symbol(sym.ELSE); }
    "null" {  System.out.print(" null "); line=yyline; column=yycolumn; return symbol(sym.NULL); }
    "sup" {  System.out.print(" sup "); line=yyline; column=yycolumn; return symbol(sym.SUP); }
    "this" {  System.out.print(" this "); line=yyline; column=yycolumn; return symbol(sym.THIS); }
    "bool" {  System.out.print(" bool "); line=yyline; column=yycolumn; return symbol(sym.BOOL); }
    "chr" {  System.out.print(" chr "); line=yyline; column=yycolumn; return symbol(sym.CHR); }
    "int" {  System.out.print(" int "); line=yyline; column=yycolumn; return symbol(sym.INT); }
    "flot" {  System.out.print(" flot "); line=yyline; column=yycolumn; return symbol(sym.FLOT); }
    "lon" {  System.out.print(" lon "); line=yyline; column=yycolumn; return symbol(sym.LON); }
    "doub" {  System.out.print(" doub "); line=yyline; column=yycolumn; return symbol(sym.DOUB); }
    "pub" {  System.out.print(" pub "); line=yyline; column=yycolumn; return symbol(sym.PUB); }
    "priv" {  System.out.print(" priv "); line=yyline; column=yycolumn; return symbol(sym.PRIV); }
    "prot" {  System.out.print(" prot "); line=yyline; column=yycolumn; return symbol(sym.PROT); }
    "stat" {  System.out.print(" stat "); line=yyline; column=yycolumn; return symbol(sym.STAT); }
    "finl" {  System.out.print(" finl "); line=yyline; column=yycolumn; return symbol(sym.FINL); }
    "nat" {  System.out.print(" nat "); line=yyline; column=yycolumn; return symbol(sym.NAT); }
    "syn" {  System.out.print(" syn "); line=yyline; column=yycolumn; return symbol(sym.SYN); }
    "abst" {  System.out.print(" abst "); line=yyline; column=yycolumn; return symbol(sym.ABST); }
    "thr" {  System.out.print(" thr "); line=yyline; column=yycolumn; return symbol(sym.THR); }
    "trns" {  System.out.print(" trns "); line=yyline; column=yycolumn; return symbol(sym.TRNS); }

    
    "\""[^"\""]*"\"" { System.out.print(yytext()); line=yyline; column=yycolumn; return symbol(sym.STR, new String(yytext())); }

    "'"[^"'"]*"'" { System.out.print(yytext()); line=yyline; column=yycolumn; return symbol(sym.CHAR, new Char(yytext())); }
   
    /* Si se encuentra un entero, se imprime, se regresa un token numero
        que representa un entero y el valor que se obtuvo de la cadena yytext
        al convertirla a entero. yytext es el token encontrado. */
    {Entero} { System.out.print(yytext()); line=yyline; column=yycolumn; lexeme=yytext(); return symbol(sym.ENTERO, new Integer(yytext())); }
    
    {Entero}*"."{D}+ { System.out.print(yytext()); line=yyline; column=yycolumn; lexeme=yytext(); return symbol(sym.REAL, new Double(yytext())); }
    
    {L}( {L} | {Entero} | "_" )* { System.out.print(yytext()); line=yyline; column=yycolumn; lexeme=yytext(); return symbol(sym.ID, new String(yytext())); }

    . {line=yyline;column=yycolumn; lexeme=yytext return symbol(sym.ERROR);}
    
}


/* Si el token contenido en la entrada no coincide con ninguna regla entonces se marca un token ilegal */
[^] { System.out.print("Caracter ilegal <"+yytext()+">"); return symbol(sym.ERROR); }

