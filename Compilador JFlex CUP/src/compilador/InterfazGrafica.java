/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compilador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java_cup.runtime.*;

/**
 * Clase que implementa la GUI del programa.
 * 
 * @author Juan Camilo González Idárraga.
 * @author Luis Ernesto García Riojas.
 * @author Luis Emilio González Zapata.
 * @author Ingeniería de Sistemas y Computación - Semestre VI.
 * @author Universidad del Quindío.
 * @version 1.0
 * @since 2015-09-12
 */
public class InterfazGrafica extends javax.swing.JFrame {
    
    private ArrayList<Token> lista_tokens;
    private ArrayList<Token> lista_errores;
    private ArrayList<String>lista_reservadas;
    private JFileChooser jfc;
    private File abierto_f;
    
    /**
     * Constructor que crea la interfaz gráfica
     */
    public InterfazGrafica() {
        setTitle("Compilador");
        initComponents();
        initVar();   
        //Inicializar selector de archivos y aplicarle filtro
        jfc=new JFileChooser();
        FileNameExtensionFilter filtro=new FileNameExtensionFilter("Archivo alpha","alpha");
        jfc.setFileFilter(filtro);
    }
    
    /**
     * Metodo para inicializar variables o estructuras de datos.
     */
    private void initVar(){
        lista_tokens = new ArrayList();
        lista_errores = new ArrayList();
        lista_reservadas=new ArrayList();
        fillReserved();
    }

    /**
     * Metodo para llenar la lista de palabras reservadas
     */
    private void fillReserved(){
        //Agregar palabras reservadas aqui
        lista_reservadas.add("str");    
        lista_reservadas.add("int");    
        lista_reservadas.add("flot");    
        lista_reservadas.add("doub");    
        lista_reservadas.add("bool");    
        lista_reservadas.add("char");    
        lista_reservadas.add("pub");    
        lista_reservadas.add("priv");    
        lista_reservadas.add("stat");    
        lista_reservadas.add("void");    
        lista_reservadas.add("finl");    
        lista_reservadas.add("true");    
        lista_reservadas.add("fals");    
        lista_reservadas.add("prot");    
        lista_reservadas.add("ret");    
        lista_reservadas.add("brk");    
        lista_reservadas.add("clas");    
        lista_reservadas.add("true");  
        lista_reservadas.add("itfz");  
        lista_reservadas.add("imps");  
        lista_reservadas.add("abs");  
        lista_reservadas.add("sout");  
        lista_reservadas.add("sin");  

        //Agregar estructuras de control aqui

        lista_reservadas.add("for");    
        lista_reservadas.add("if");    
        lista_reservadas.add("case");    
        lista_reservadas.add("do");    
        lista_reservadas.add("whil");    
        lista_reservadas.add("swth");
}

    /**
     * Metodo para agregar un token a la lista.
     * @param token Tipo de token
     * @param lexema Lexema del token
     * @param linea Linea en que se encontró
     * @param columna Columna en que se encontró
     * @param tamaño Tamaño del token
     */
    private void addToken(String token,String lexema,int linea,int columna,int tamaño){
        lista_tokens.add(new Token(token, lexema, linea, columna, tamaño));
    }
    
    /**
     * Agrega un token creado como clase a la lista.
     * @param token Token a agregar
     */
    private void addToken(Token token){
        lista_tokens.add(token);
    }
    
    /**
     * Metodo para agregar un simbolo no reconocido (error) a la lista.
     * @param token Tipo de token
     * @param lexema Lexema del token
     * @param linea Linea en que se encontró
     * @param columna Columna en que se encontró
     * @param tamaño Tamaño del token
     */
    private void addError(String token,String lexema,int linea,int columna,int tamaño){
        lista_errores.add(new Token(token, lexema, linea, columna, tamaño));
    }
    
    /**
     * Agrega un error a la lista.
     * @param token 
     */
    private void addError(Token token){
        lista_errores.add(token);
    }
   
    /**
     * Metodo para buscar un lexema en una lista
     * @param lista Lista de palabras
     * @param token Token a buscar
     * @return 
     */
    private boolean isKeyword(ArrayList<String> lista,Token token){
        if(!lista.isEmpty()){
            for(String tok:lista){
                if(tok.equals(token.lexema)){
                    token.setToken(tok);
                    addToken(token);
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * Metodo para agregar datos de la lista a la tabla
     * @param tabla Tabla en que se muestra el resultado
     * @param lista Lista de datos
     */
    private void fillTokenTable(JTable tabla,ArrayList<Token> lista){
        int i=0;
        DefaultTableModel modelo=new DefaultTableModel(new String []{"Token","Lexema","Linea"},lista.size());
        modelo.addRow(new Object[]{"","",""});
        for(Token tok: lista ){
            modelo.setValueAt(tok.token, i, 0);
            modelo.setValueAt(tok.lexema, i, 1);
            modelo.setValueAt(tok.linea, i, 2);
            i++;
        }
        tabla.setModel(modelo);
    }
    
    /**
     * Metodo que inicializa los componentes
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Código", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        jPanel3.setName("Código"); // NOI18N
        jPanel3.setOpaque(false);

        jButton1.setText("Analizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jButton1)
                .addContainerGap(106, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Resultado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Token", "Lexema", "Linea"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Token", "Lexema", "Linea"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable2);

        jLabel1.setText("Tabla de Tokens");

        jLabel2.setText("Tabla de errores");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Léxico", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jMenu1.setText("Archivo");

        jMenuItem4.setText("Abrir");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem3.setText("Guardar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem2.setText("Guardar como...");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("Salir");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edicion");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo que permite analizar in codigo insertado mediante un boton
     * @param evt Evento del boton
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        File fichero= new File("codigo.txt");
        BufferedWriter writer;
        try{
            writer = new BufferedWriter(new FileWriter(fichero));
            writer.write(jTextArea1.getText());
            writer.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "No se pudo guardar archivo de entrada debido a "+ ex.toString());
        }
        try{
            //probamos nuestra clase Lexer.java
            probarLexerFile();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
         fillTokenTable(jTable1,lista_tokens);
         fillTokenTable(jTable2,lista_errores);
         initVar();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Metodo de interaccion con el area de texto para ingresoo
     * @param evt Evento de un menu
     */
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        abierto_f=abrirArchivo(jfc,jTextArea1);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * Metodo de interaccion con el area de texto para ingreso
     * @param evt Evento de un menu
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        abierto_f=guardarArchivo(jfc,jTextArea1);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        abierto_f=guardarArchivo(abierto_f,jTextArea1);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * Metodo principal para inicial la interfaz
     * @param args Argumentos de ejecucion
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazGrafica().setVisible(true);
            }
        });
    }
    
    /**
     * Metodo para extraer los tokens de un archivo
     * @throws IOException Excepcion de entrada/salida
     */
    public void probarLexerFile() throws IOException{
        Reader reader = new BufferedReader(new FileReader("codigo.txt"));
        AnalizadorLexico lexer = new AnalizadorLexico (reader);
        String resultado="";
        while(true){
            //Tokens tokens = lexer.yylex();
            java_cup.runtime.Symbol tokens = lexer.next_token();
            
            if(tokens==null){
                resultado  = resultado+"EOF";
            //    jTextArea2.setText(resultado);
                return;
            }
            switch(tokens.sym){
                case ERROR: 
                    //addError(new Token(tokens.toString(),lexer.lexeme,lexer.line+1,lexer.column,lexer.yylength()));
                     break;
                    /*
                case IDENTIFICADOR: 
             Token tok=new Token(tokens.toString(),lexer.lexeme,lexer.line+1,lexer.column,lexer.yylength());
             if(isKeyword(lista_reservadas,tok)){}    
             else{addToken(tok);} 
             break;
                    */
                    /*
                case ValorEntero:
                addToken(new Token(tokens.toString(),lexer.lexeme,lexer.line+1,lexer.column,lexer.yylength()));    
                    break;
             */
                default:
                //addToken(new Token(tokens.toString(),lexer.yytext(),lexer.line+1,lexer.column,lexer.yylength()));                 
            }
           
        }
        
    }

    /**
     * Metodo que permite agregar una extension a un archivo
     * @param nombre Nombre del archivi
     * @param extension Extension del archivo
     * @return 
     */
    private String agregarExtencion (String nombre,String extension){
        String[] arreglo=nombre.split(".");
        if(arreglo.length<2){
            return "."+extension;
        }
        return nombre;
    }
    /**
     * Metodo que permite guardar un archivo de texto con un seleccionador
     * @param jfc Seleccionador de Java
     * @param AreaTexto Area de texto de donde proviene el texto
     * @return Archivo a guardar
     */
    private File guardarArchivo(JFileChooser jfc,JTextArea AreaTexto) {
        try {
            if(jfc.showSaveDialog(this)!=JFileChooser.CANCEL_OPTION){
                File guardar_f =jfc.getSelectedFile();
                if(guardar_f!=null){
                    /*guardamos el archivo y le damos el formato directamente,
                    * si queremos que se guarde en formato doc lo definimos como .doc*/   
                    FileWriter guardar_fw=new FileWriter(new File(guardar_f.getAbsolutePath()+agregarExtencion(guardar_f.getName(),"alpha")));
                    guardar_fw.write(AreaTexto.getText());
                    guardar_fw.close();
                    JOptionPane.showMessageDialog(null, "El archivo se a guardado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
                    return guardar_f;
                }
            }
        }

        catch(IOException ex){
            JOptionPane.showMessageDialog(null,"Su archivo no se ha guardado","Advertencia",JOptionPane.WARNING_MESSAGE);
            return null;
        }
        
        return null;
    
    }

    /**
     * Metodo que permite guardar un archivo directamente
     * @param guardar_f Archivo a guardar
     * @param AreaTexto Texto a guardar
     * @return 
     */
    private File guardarArchivo(File guardar_f,JTextArea AreaTexto) {
        try {
            if(guardar_f!=null){
                /*guardamos el archivo y le damos el formato directamente,
                 * si queremos que se guarde en formato doc lo definimos como .doc*/   
                FileWriter guardar_fw=new FileWriter(guardar_f);
                guardar_fw.write(AreaTexto.getText());
                guardar_fw.close();
                JOptionPane.showMessageDialog(null, "El archivo se a guardado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
                return guardar_f;
            }
        }

        catch(IOException ex) {
            JOptionPane.showMessageDialog(null,"Su archivo no se ha guardado","Advertencia",JOptionPane.WARNING_MESSAGE);
            return null;
        }
        
        return null;
        
     }

    /**
     * Metodo que permite abrir un archivo mediante un seleccionador
     * @param jfc Seleccionador de java
     * @param areatexto Area donde se pondra el texto
     * @return Archivo que se selecciono
     */
    private File abrirArchivo(JFileChooser jfc,JTextArea areatexto) {
        String aux="";   
        String text=areatexto.getText();   
        String texto="";
        File archivo=null;
        try {
            /**llamamos el metodo que permite cargar la ventana*/

            if(jfc.showOpenDialog(this)!=JFileChooser.CANCEL_OPTION){
                /**abrimos el archivo seleccionado*/
                archivo=jfc.getSelectedFile();

                /**recorremos el archivo, lo leemos para plasmarlo
                *en el area de texto*/
                if(archivo!=null) {     
                    FileReader archivos=new FileReader(archivo);
                    BufferedReader lee=new BufferedReader(archivos);
                    while((aux=lee.readLine())!=null)
                    {
                        texto+= aux+ "\n";
                    }
                    lee.close();
                }    
            } else{texto=text;}

        }
        catch(IOException ex) {
            JOptionPane.showMessageDialog(null,ex+"\nNo se ha encontrado el archivo","ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
        }
        
        areatexto.setText(texto);//El texto se almacena en el JTextArea
        return archivo;
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
