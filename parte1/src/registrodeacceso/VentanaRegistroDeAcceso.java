package registrodeacceso;
import hilos.hiloDeTransaccion;
import hilos.hiloDeValidacion;
import javax.swing.JOptionPane;
import Test.TesteoSistema;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import Reporte.generadorReporteSwing;

public class VentanaRegistroDeAcceso extends javax.swing.JFrame {

    private final String placeholderCodigo = "20232571A";
    private final String placeholderFecha = "yyyy/MM/dd";


    public VentanaRegistroDeAcceso() {
        FondoPanel fondo = new FondoPanel("/fondosAplication/fondo4difuminado.jpg"); // Cambia por tu imagen
        this.setContentPane(fondo);

        initComponents();
        tblRegistro.getTableHeader().setReorderingAllowed(false);
        new TesteoSistema().TestearTrabajadoresInternos();
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        formatFecha1.setText(LocalDate.now().format(formato));
        formatFecha2.setText(LocalDate.now().format(formato));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblCodigo1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtCodigo1 = new javax.swing.JTextField();
        spnHora1 = new javax.swing.JSpinner();
        spnMin1 = new javax.swing.JSpinner();
        lblHora1 = new javax.swing.JLabel();
        formatFecha1 = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        checkEditable1 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        lblCodigo2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtCodigo2 = new javax.swing.JTextField();
        spnHora2 = new javax.swing.JSpinner();
        spnMin2 = new javax.swing.JSpinner();
        lblHora2 = new javax.swing.JLabel();
        formatFecha2 = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        checkEditable2 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistro = new javax.swing.JTable();
        tbnReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(204, 204, 204));
        panelPrincipal.setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(226, 247, 253,160));

        lblCodigo1.setForeground(new java.awt.Color(116, 116, 75));
        lblCodigo1.setText("codigo");

        jButton1.setForeground(new java.awt.Color(116, 116, 75));
        jButton1.setText("Marcar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtCodigo1.setBackground(new java.awt.Color(255, 255, 255));
        txtCodigo1.setForeground(new java.awt.Color(153, 153, 153));
        txtCodigo1.setText("20232571A");
        txtCodigo1.setOpaque(true);
        txtCodigo1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodigo1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigo1FocusLost(evt);
            }
        });

        spnHora1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        spnHora1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        spnHora1.setEnabled(false);

        spnMin1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        spnMin1.setEnabled(false);

        lblHora1.setForeground(new java.awt.Color(116, 116, 75));
        lblHora1.setText("Hora");

        formatFecha1.setEditable(false);
        formatFecha1.setForeground(new java.awt.Color(153, 153, 153));
        formatFecha1.setText("yyyy/MM/dd");
        formatFecha1.setFocusable(false);
        formatFecha1.setOpaque(true);
        formatFecha1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formatFecha1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formatFecha1FocusLost(evt);
            }
        });

        jLabel3.setText(":");

        checkEditable1.setForeground(new java.awt.Color(153, 153, 153,160));
        checkEditable1.setText("Editable");
        checkEditable1.setOpaque(false);
        checkEditable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkEditable1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(checkEditable1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblHora1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCodigo1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(formatFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spnHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spnMin1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCodigo1))))
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo1)
                    .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(checkEditable1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnMin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnHora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHora1)
                    .addComponent(formatFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(16, 16, 16))
        );

        jPanel2.setBackground(new java.awt.Color(226, 247, 253,160));

        lblCodigo2.setForeground(new java.awt.Color(116, 116, 75));
        lblCodigo2.setText("codigo");

        jButton2.setForeground(new java.awt.Color(116, 116, 75));
        jButton2.setText("Marcar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtCodigo2.setForeground(new java.awt.Color(153, 153, 153));
        txtCodigo2.setText("20232571A");
        txtCodigo2.setOpaque(true);
        txtCodigo2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodigo2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigo2FocusLost(evt);
            }
        });

        spnHora2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        spnHora2.setEnabled(false);

        spnMin2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        spnMin2.setEnabled(false);

        lblHora2.setForeground(new java.awt.Color(116, 116, 75));
        lblHora2.setText("Hora");

        formatFecha2.setEditable(false);
        formatFecha2.setForeground(new java.awt.Color(153, 153, 153));
        formatFecha2.setText("yyyy/MM/dd");
        formatFecha2.setFocusable(false);
        formatFecha2.setOpaque(true);
        formatFecha2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formatFecha2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formatFecha2FocusLost(evt);
            }
        });

        jLabel6.setText(":");

        checkEditable2.setForeground(new java.awt.Color(153, 153, 153,160));
        checkEditable2.setText("Editable");
        checkEditable2.setOpaque(false);
        checkEditable2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkEditable2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblHora2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCodigo2, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(formatFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spnHora2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spnMin2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCodigo2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkEditable2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo2)
                    .addComponent(txtCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(checkEditable2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnMin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnHora2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHora2)
                    .addComponent(formatFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(16, 16, 16))
        );

        jLabel1.setBackground(new java.awt.Color(238, 238, 238));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MARCARCION TRABAJADOR");

        jPanel3.setBackground(new java.awt.Color(226, 247, 253,150));

        tblRegistro.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblRegistro.setForeground(new java.awt.Color(116, 116, 75));
        tblRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cod", "Fecha", "hMI", "hF", "Anto", "TF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRegistro.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tblRegistro);

        tbnReporte.setForeground(new java.awt.Color(116, 116, 75));
        tbnReporte.setText("Reporte");
        tbnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tbnReporte)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tbnReporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(193, 193, 193))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigo1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigo1FocusGained
        if (txtCodigo1.getText().equals(placeholderCodigo)) {
            txtCodigo1.setText("");//limia el campo si se encuentra con el placeholder
        }
    }//GEN-LAST:event_txtCodigo1FocusGained

    private void txtCodigo2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigo2FocusGained
        if (txtCodigo2.getText().equals(placeholderCodigo)) {
            txtCodigo2.setText("");//limpia el campo si se encuentra con el placeholder
        }
    }//GEN-LAST:event_txtCodigo2FocusGained

    private void formatFecha1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formatFecha1FocusGained
        if (formatFecha1.getText().equals(placeholderFecha)) {
            formatFecha1.setText("");
        }
    }//GEN-LAST:event_formatFecha1FocusGained

    private void formatFecha2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formatFecha2FocusGained
        if (formatFecha2.getText().equals(placeholderFecha)) {
            formatFecha2.setText("");
        }
    }//GEN-LAST:event_formatFecha2FocusGained

    private void txtCodigo1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigo1FocusLost
        if (txtCodigo1.getText().isEmpty()) {
                txtCodigo1.setText(placeholderCodigo);
            }
    }//GEN-LAST:event_txtCodigo1FocusLost

    private void txtCodigo2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigo2FocusLost
        if (txtCodigo2.getText().isEmpty()) {
            txtCodigo2.setText(placeholderCodigo);
        }
    }//GEN-LAST:event_txtCodigo2FocusLost

    private void formatFecha1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formatFecha1FocusLost
        if (formatFecha1.getText().isEmpty()) {
            formatFecha1.setText(placeholderFecha);
        }
    }//GEN-LAST:event_formatFecha1FocusLost

    private void formatFecha2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formatFecha2FocusLost
        if (formatFecha2.getText().isEmpty()) {
            formatFecha2.setText(placeholderFecha);
        }
    }//GEN-LAST:event_formatFecha2FocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        hiloDeValidacion validador = new hiloDeValidacion(txtCodigo1, checkEditable1, spnHora1, spnMin1);
        validador.start();
        
        try {
        // Esperamos que termine la validación antes de seguir
            validador.join();
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(null, "El hilo de validación fue interrumpido.");
            return;
        }
        
         // Si la validación fue exitosa
        if (validador.esValido()) {
            // Lanzar hilo de transacción
            new hiloDeTransaccion(validador.getCodigo(), validador.getHoraValidada(), tblRegistro).start();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        hiloDeValidacion validador = new hiloDeValidacion(txtCodigo2, checkEditable2, spnHora2, spnMin2);
        validador.start();
        
        try {
        // Esperamos que termine la validación antes de seguir
            validador.join();
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(null, "El hilo de validación fue interrumpido.");
            return;
        }
        
         // Si la validación fue exitosa
        if (validador.esValido()) {
            // Lanzar hilo de transacción
            new hiloDeTransaccion(validador.getCodigo(), validador.getHoraValidada(), tblRegistro).start();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void checkEditable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkEditable1ActionPerformed
        spnHora1.setEnabled(true);
        spnMin1.setEnabled(true);
    }//GEN-LAST:event_checkEditable1ActionPerformed

    private void checkEditable2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkEditable2ActionPerformed
        spnHora2.setEnabled(true);
        spnMin2.setEnabled(true);
    }//GEN-LAST:event_checkEditable2ActionPerformed

    private void tbnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnReporteActionPerformed
        generadorReporteSwing generador = new generadorReporteSwing(this);
        generador.generarReporte();
    }//GEN-LAST:event_tbnReporteActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaRegistroDeAcceso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkEditable1;
    private javax.swing.JCheckBox checkEditable2;
    private javax.swing.JFormattedTextField formatFecha1;
    private javax.swing.JFormattedTextField formatFecha2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JLabel lblCodigo2;
    private javax.swing.JLabel lblHora1;
    private javax.swing.JLabel lblHora2;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JSpinner spnHora1;
    private javax.swing.JSpinner spnHora2;
    private javax.swing.JSpinner spnMin1;
    private javax.swing.JSpinner spnMin2;
    private javax.swing.JTable tblRegistro;
    private javax.swing.JButton tbnReporte;
    private javax.swing.JTextField txtCodigo1;
    private javax.swing.JTextField txtCodigo2;
    // End of variables declaration//GEN-END:variables
}
