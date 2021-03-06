/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupoAD.appconcurso;

import grupoAD.appconcurso.modelos.Pregunta;
import grupoAD.appconcurso.modelos.Respuesta;
import grupoAD.appconcurso.modelos.Usuario;
import grupoAD.appconcurso.utils.GestorMariadb;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.JDialog;
import javax.swing.JRadioButton;

/**
 *
 * @author usuario
 */
public class FrmPrincipal
        extends javax.swing.JFrame
{

  /**
   * Creates new form FrmPrincipal
   */
  public FrmPrincipal()
  {
    initComponents();
    gestorBD = new GestorMariadb();
    jPanel1.setVisible(false);
    JDialog logIn = new LogIn(this, true);
    logIn.setVisible(true);
    if (user == null)
      System.exit(0);

    this.lblUsuario.setText("Bienvenido " + user.getUsuario());
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    btngrpRespuestas = new javax.swing.ButtonGroup();
    jPanel2 = new javax.swing.JPanel();
    btnJugar = new javax.swing.JButton();
    lblUsuario = new javax.swing.JLabel();
    jPanel1 = new javax.swing.JPanel();
    panelJugar = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    txtPregunta = new javax.swing.JTextArea();
    rdoRespuesta1 = new javax.swing.JRadioButton();
    rdoRespuesta2 = new javax.swing.JRadioButton();
    rdoRespuesta3 = new javax.swing.JRadioButton();
    rdoRespuesta4 = new javax.swing.JRadioButton();
    btnSiguiente = new javax.swing.JButton();
    btnAnterior = new javax.swing.JButton();
    lblRestantes = new javax.swing.JLabel();
    panelResultado = new javax.swing.JPanel();
    lblAciertos = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setMinimumSize(new java.awt.Dimension(600, 300));

    btnJugar.setText("Jugar");
    btnJugar.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        btnJugarActionPerformed(evt);
      }
    });

    lblUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblUsuario.setText("lblUsuario");
    lblUsuario.setToolTipText("");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(btnJugar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
      .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(btnJugar)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel1.setLayout(new java.awt.CardLayout());

    panelJugar.setMaximumSize(null);

    jScrollPane1.setBackground(new java.awt.Color(60, 63, 65));
    jScrollPane1.setBorder(null);

    txtPregunta.setColumns(20);
    txtPregunta.setLineWrap(true);
    txtPregunta.setRows(1);
    txtPregunta.setBorder(null);
    txtPregunta.setFocusable(false);
    jScrollPane1.setViewportView(txtPregunta);

    btngrpRespuestas.add(rdoRespuesta1);
    rdoRespuesta1.setText("respuesta");

    btngrpRespuestas.add(rdoRespuesta2);
    rdoRespuesta2.setText("respuesta");
    rdoRespuesta2.setToolTipText("");

    btngrpRespuestas.add(rdoRespuesta3);
    rdoRespuesta3.setText("respuesta");
    rdoRespuesta3.setToolTipText("");

    btngrpRespuestas.add(rdoRespuesta4);
    rdoRespuesta4.setText("respuesta");

    btnSiguiente.setText("Siguente ???");
    btnSiguiente.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        btnSiguienteActionPerformed(evt);
      }
    });

    btnAnterior.setText("??? Anterior");
    btnAnterior.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        btnAnteriorActionPerformed(evt);
      }
    });

    lblRestantes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lblRestantes.setText("lblRestantes");

    javax.swing.GroupLayout panelJugarLayout = new javax.swing.GroupLayout(panelJugar);
    panelJugar.setLayout(panelJugarLayout);
    panelJugarLayout.setHorizontalGroup(
      panelJugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(rdoRespuesta3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(rdoRespuesta2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(rdoRespuesta4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJugarLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addComponent(rdoRespuesta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(panelJugarLayout.createSequentialGroup()
        .addGap(10, 10, 10)
        .addGroup(panelJugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lblRestantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(panelJugarLayout.createSequentialGroup()
            .addComponent(jScrollPane1)
            .addGap(10, 10, 10))))
    );
    panelJugarLayout.setVerticalGroup(
      panelJugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelJugarLayout.createSequentialGroup()
        .addComponent(lblRestantes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(rdoRespuesta1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(rdoRespuesta3, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(rdoRespuesta2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(rdoRespuesta4, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        .addGap(18, 18, 18)
        .addGroup(panelJugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnSiguiente)
          .addComponent(btnAnterior))
        .addContainerGap(14, Short.MAX_VALUE))
    );

    jPanel1.add(panelJugar, "card2");

    panelResultado.setMaximumSize(null);
    panelResultado.setMinimumSize(new java.awt.Dimension(0, 0));

    lblAciertos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblAciertos.setText("jLabel1");

    javax.swing.GroupLayout panelResultadoLayout = new javax.swing.GroupLayout(panelResultado);
    panelResultado.setLayout(panelResultadoLayout);
    panelResultadoLayout.setHorizontalGroup(
      panelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelResultadoLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(lblAciertos, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        .addContainerGap())
    );
    panelResultadoLayout.setVerticalGroup(
      panelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelResultadoLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(lblAciertos, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
        .addContainerGap())
    );

    jPanel1.add(panelResultado, "card3");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGap(0, 0, 0))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAnteriorActionPerformed
    {//GEN-HEADEREND:event_btnAnteriorActionPerformed
      if (preguntaActual - 1 < 0)
        return;

      --preguntaActual;
      rellenarPregunta();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSiguienteActionPerformed
    {//GEN-HEADEREND:event_btnSiguienteActionPerformed
      if (preguntaActual + 1 >= listPreguntas.size())
      {
        panelJugar.setVisible(false);
        panelResultado.setVisible(true);
        lblAciertos.setText("Has acertado " + resultado + " pregunta");
        return;
      }
      comprobarPregunta();
      ++preguntaActual;
      rellenarPregunta();
    }//GEN-LAST:event_btnSiguienteActionPerformed

  private void btnJugarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnJugarActionPerformed
  {//GEN-HEADEREND:event_btnJugarActionPerformed
    listPreguntas = gestorBD.obtenerPreguntas(4);
    preguntaActual = 0;
    rellenarPregunta();
    jPanel1.setVisible(true);
    panelJugar.setVisible(true);
    panelResultado.setVisible(false);
  }//GEN-LAST:event_btnJugarActionPerformed

  private void comprobarPregunta()
  {
    List<Respuesta> listRespuestas = listPreguntas.get(preguntaActual).getRespuestas();
    for (Respuesta respuesta : listRespuestas)
    {
      if (!respuesta.isCorrecta())
        continue;

      Enumeration<AbstractButton> allRadioButton = btngrpRespuestas.getElements();
      int auxContador = 0;
      while (allRadioButton.hasMoreElements())
      {
        JRadioButton rdo = (JRadioButton) allRadioButton.nextElement();
        if (rdo.isSelected() && rdo.getText().equals(respuesta.getTexto()))
        {
          resultado++;
          return;
        }
        auxContador++;
      }
    }
  }

  private void rellenarPregunta()
  {
    Pregunta pregunta = listPreguntas.get(preguntaActual);
    txtPregunta.setText(pregunta.getEnunciado());
    rdoRespuesta1.setText(pregunta.getRespuestas().get(0).getTexto());
    rdoRespuesta2.setText(pregunta.getRespuestas().get(1).getTexto());
    rdoRespuesta3.setText(pregunta.getRespuestas().get(2).getTexto());
    rdoRespuesta4.setText(pregunta.getRespuestas().get(3).getTexto());
    this.lblRestantes.setText(preguntaActual + 1 + "/" + listPreguntas.size());
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String args[])
  {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try
    {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
      {
        if ("Nimbus".equals(info.getName()))
        {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex)
    {
      java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(
              java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex)
    {
      java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(
              java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex)
    {
      java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(
              java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex)
    {
      java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(
              java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new FrmPrincipal().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnAnterior;
  private javax.swing.JButton btnJugar;
  private javax.swing.JButton btnSiguiente;
  private javax.swing.ButtonGroup btngrpRespuestas;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel lblAciertos;
  private javax.swing.JLabel lblRestantes;
  private javax.swing.JLabel lblUsuario;
  private javax.swing.JPanel panelJugar;
  private javax.swing.JPanel panelResultado;
  private javax.swing.JRadioButton rdoRespuesta1;
  private javax.swing.JRadioButton rdoRespuesta2;
  private javax.swing.JRadioButton rdoRespuesta3;
  private javax.swing.JRadioButton rdoRespuesta4;
  private javax.swing.JTextArea txtPregunta;
  // End of variables declaration//GEN-END:variables

// Mis variables
  private final GestorMariadb gestorBD;
  private List<Pregunta> listPreguntas;
  private int resultado = 0;
  private int preguntaActual;
  public Usuario user;
}
