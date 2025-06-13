package Vistas;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brian Rivera
 */
public class IventarioProducto extends javax.swing.JInternalFrame {

    public IventarioProducto() {
        initComponents();
        listarProductos();

        jTable_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = jTable_productos.getSelectedRow();
                if (fila >= 0) {
                    txt_nombre.setText(jTable_productos.getValueAt(fila, 1).toString());
                    txt_precio.setText(jTable_productos.getValueAt(fila, 2).toString());
                    txt_cantidad.setText(jTable_productos.getValueAt(fila, 3).toString());
                    txt_descripcion.setText(jTable_productos.getValueAt(fila, 4).toString());
                    jComboBox_categoria.setSelectedItem(jTable_productos.getValueAt(fila, 5).toString());
                }
            }
        });
    }

    public void listarProductos() {
        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Categoría");

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM productos");
            ResultSet rs = ps.executeQuery();

            boolean hayDatos = false;
            while (rs.next()) {
                hayDatos = true;
                Object[] fila = {
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getDouble("precio_unitario"),
                    rs.getInt("stock"),
                    rs.getString("proveedor"),
                    rs.getString("categoria")
                };
                modelo.addRow(fila);
            }

            if (!hayDatos) {
                JOptionPane.showMessageDialog(null, "No hay productos registrados.");
            }

            jTable_productos.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar productos: " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelIventario = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        Logo1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox_categoria = new javax.swing.JComboBox<>();
        Actualizar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        txt_cantidad = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        PanelIventario.setBackground(new java.awt.Color(204, 204, 204));

        jTable_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_productos);

        Logo1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Logo1.setForeground(new java.awt.Color(0, 0, 0));
        Logo1.setText("IVENTARIO MINECH");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Cantidad:");

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Precio:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Descripcion:");

        txt_descripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txt_precio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Categoria:");

        jComboBox_categoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione categoria:", "Bebidas", "Galletas", "Caramelos" }));

        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        txt_cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        PanelIventario.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PanelIventario.setLayer(Logo1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PanelIventario.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PanelIventario.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PanelIventario.setLayer(txt_nombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PanelIventario.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PanelIventario.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PanelIventario.setLayer(txt_descripcion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PanelIventario.setLayer(txt_precio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PanelIventario.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PanelIventario.setLayer(jComboBox_categoria, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PanelIventario.setLayer(Actualizar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PanelIventario.setLayer(Eliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PanelIventario.setLayer(txt_cantidad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PanelIventario.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout PanelIventarioLayout = new javax.swing.GroupLayout(PanelIventario);
        PanelIventario.setLayout(PanelIventarioLayout);
        PanelIventarioLayout.setHorizontalGroup(
            PanelIventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIventarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Logo1)
                .addGap(331, 331, 331))
            .addGroup(PanelIventarioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(PanelIventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelIventarioLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIventarioLayout.createSequentialGroup()
                        .addGroup(PanelIventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelIventarioLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 25, Short.MAX_VALUE))
                            .addGroup(PanelIventarioLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PanelIventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(25, 25, 25))))
        );
        PanelIventarioLayout.setVerticalGroup(
            PanelIventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIventarioLayout.createSequentialGroup()
                .addComponent(Logo1)
                .addGroup(PanelIventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelIventarioLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(Actualizar)
                        .addGap(32, 32, 32)
                        .addComponent(Eliminar)
                        .addGap(28, 28, 28)
                        .addComponent(jButton1))
                    .addGroup(PanelIventarioLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(PanelIventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelIventarioLayout.createSequentialGroup()
                        .addGroup(PanelIventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(PanelIventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(PanelIventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(PanelIventarioLayout.createSequentialGroup()
                        .addComponent(jComboBox_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelIventario)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelIventario)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        int fila = jTable_productos.getSelectedRow();
        if (fila >= 0) {
            try {
                int id = Integer.parseInt(jTable_productos.getValueAt(fila, 0).toString());
                String nombre = txt_nombre.getText();
                double precio = Double.parseDouble(txt_precio.getText());
                int cantidad = Integer.parseInt(txt_cantidad.getText());
                String proveedor = txt_descripcion.getText(); // asumiendo que aquí va el proveedor
                String categoria = jComboBox_categoria.getSelectedItem().toString();

                Connection cn = Conexion.conectar();
                PreparedStatement ps = cn.prepareStatement("UPDATE productos SET nombre=?, precio_unitario=?, stock=?, proveedor=?, categoria=? WHERE id=?");
                ps.setString(1, nombre);
                ps.setDouble(2, precio);
                ps.setInt(3, cantidad);
                ps.setString(4, proveedor);
                ps.setString(5, categoria);
                ps.setInt(6, id);

                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Producto actualizado correctamente.");
                listarProductos();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar producto: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila para actualizar.");
        }


    }//GEN-LAST:event_ActualizarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int fila = jTable_productos.getSelectedRow();
        if (fila >= 0) {
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este producto?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                try {
                    int id = Integer.parseInt(jTable_productos.getValueAt(fila, 0).toString());
                    Connection cn = Conexion.conectar();
                    PreparedStatement ps = cn.prepareStatement("DELETE FROM productos WHERE id=?");
                    ps.setInt(1, id);
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.");
                    listarProductos();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar producto: " + e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila para eliminar.");
    }    }//GEN-LAST:event_EliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txt_nombre.setText("");
        txt_precio.setText("");
        txt_cantidad.setText("");
        txt_descripcion.setText("");
        jComboBox_categoria.setSelectedIndex(0); // Asume que el primer ítem es el predeterminado
        jTable_productos.clearSelection(); // Quita la selección en la tabla
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JLabel Logo1;
    private javax.swing.JDesktopPane PanelIventario;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox_categoria;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
