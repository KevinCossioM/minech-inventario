
package Vistas;

import DAO.ProductoDAO;
import Modelo.Producto;
import Servicio.AlertaServicio;
import controlador.Ctrl_Alerta;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Alertas extends javax.swing.JInternalFrame {
public void mostrarProductosStockBajo(int limite) {
    String[] columnas = {"Nombre"," Categoria", "Código", "Proveedor", "Stock"};
    DefaultTableModel modelo = new DefaultTableModel(null, columnas){
        @Override
        public boolean isCellEditable(int row, int column) {
        return false; // hace que todas las celdas no se puedan editar
    }

    };

    // Inicializa los componentes del servicio y controlador
    ProductoDAO productoDAO = new ProductoDAO();
    AlertaServicio alertaServicio = new AlertaServicio(productoDAO);
    Ctrl_Alerta ctrl = new Ctrl_Alerta(alertaServicio);

    List<Producto> productos = ctrl.obtenerProductosConStockBajo(limite);

    for (Producto p : productos) {
        Object[] fila = {
            p.getNombre(),
            p.getCategoria(),
            p.getCodigo(),
            p.getProveedor(),

            p.getStock()
        };
        modelo.addRow(fila);
    }

    jTable_productos.setModel(modelo);
}

    
    public Alertas() {
        initComponents();
         mostrarProductosStockBajo(100);
            JOptionPane.showMessageDialog(
        this,
        "<html><b><font color='red'>¡Alerta!</font></b><br>El stock de algunos productos está muy bajo.<br>Revisa la lista para tomar acción inmediata.</html>",
        "⚠ Stock Bajo Detectado",
        JOptionPane.WARNING_MESSAGE
    );
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        Logo1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 204));

        Logo1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Logo1.setForeground(new java.awt.Color(0, 0, 0));
        Logo1.setText("Alertas de Stock Bajo ");

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

        jDesktopPane1.setLayer(Logo1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Logo1)
                .addGap(238, 238, 238))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logo1)
                .addGap(78, 78, 78)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo1;
    private javax.swing.JDesktopPane jDesktopPane1;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    // End of variables declaration//GEN-END:variables
}
