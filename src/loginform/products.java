package loginform;

import Control.Products_Operations;
import Modeling.Products_Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LEGION
 */
public  class products extends javax.swing.JFrame {
    
    private ArrayList<Products_Model> arr;
    private int row_number=0;
    /**
     * Creates new form products
     */
    
    public products() {
        initComponents();
        TableDark1.fixTable(jScrollPane1);
        TableDark1.setColumnAlignment(0, JLabel.CENTER);
        TableDark1.setCellAlignment(0, JLabel.CENTER);
        TableDark1.setColumnAlignment(1, JLabel.CENTER);
        TableDark1.setCellAlignment(1, JLabel.CENTER);
    }

    
    public void show_table() {
        DefaultTableModel pr = (DefaultTableModel) TableDark1.getModel();
        arr = Products_Operations.get_ProductsData();
        Object[] row = new Object[6];
         for (int i = 0; i < arr.size(); i++) 
          {
             row[0] = arr.get(i).getMed_name(); 
             row[1] = arr.get(i).getPrice();
             row[2] = arr.get(i).getQuantity();
             row[3] = arr.get(i).getCategory();
             row[4] = arr.get(i).getExpired_date();
             row[5] = arr.get(i).getDescription();   
             pr.insertRow(i, row);
          }
       
    TableDark1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                row_number = TableDark1.getSelectedRow();
            }
        }
        );
    }
    
 private void show_Product(Products_Model obj) 
    {
        DefaultTableModel pr = (DefaultTableModel) TableDark1.getModel();
        Object[] row = new Object[6];
        row[0] = obj.getMed_name();
        row[1] = obj.getPrice();
        row[2] = obj.getQuantity();
        row[3] = obj.getCategory();
        row[4] = obj.getExpired_date();
        row[5] = obj.getDescription();
        pr.insertRow(0, row);
        
            arr = Products_Operations.get_ProductsData();
            TableDark1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                row_number = TableDark1.getSelectedRow();
            }
        }
        );
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        txtsearch = new javax.swing.JTextField();
        Search = new button.mybutton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableDark1 = new tabledark.TableDark();
        Stock = new button.mybutton();
        Delete = new button.mybutton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pharmacy (15).png"))); // NOI18N
        jLabel1.setRequestFocusEnabled(false);
        jLabel1.setVerifyInputWhenFocusTarget(false);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back-button.png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/product.png"))); // NOI18N
        jLabel3.setInheritsPopupMenu(false);
        jLabel3.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel3.setRequestFocusEnabled(false);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(6, 107, 138));
        jTextField1.setText("Products List");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        txtsearch.setText("Enter Name");

        Search.setBackground(new java.awt.Color(6, 107, 138));
        Search.setForeground(new java.awt.Color(255, 255, 255));
        Search.setText("Search");
        Search.setBorderColor(new java.awt.Color(255, 255, 255));
        Search.setBorderPainted(false);
        Search.setColorClick(new java.awt.Color(0, 153, 153));
        Search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Search.setRadius(10);
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        TableDark1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Price", "Quantity", "Category", "Expired_date", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableDark1.setGridColor(new java.awt.Color(0, 102, 102));
        TableDark1.getTableHeader().setReorderingAllowed(false);
        TableDark1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDark1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableDark1);

        Stock.setBackground(new java.awt.Color(6, 107, 138));
        Stock.setForeground(new java.awt.Color(255, 255, 255));
        Stock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/box.png"))); // NOI18N
        Stock.setText("Set Stock");
        Stock.setBorderColor(new java.awt.Color(255, 255, 255));
        Stock.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Stock.setRadius(10);
        Stock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StockMouseClicked(evt);
            }
        });
        Stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StockActionPerformed(evt);
            }
        });

        Delete.setBackground(new java.awt.Color(6, 107, 138));
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/x (2).png"))); // NOI18N
        Delete.setText("Delete");
        Delete.setBorderColor(new java.awt.Color(255, 255, 255));
        Delete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Delete.setMaximumSize(new java.awt.Dimension(121, 34));
        Delete.setMinimumSize(new java.awt.Dimension(121, 34));
        Delete.setPreferredSize(new java.awt.Dimension(121, 34));
        Delete.setRadius(10);
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(back))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 51, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(Stock, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158)
                .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Stock, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 36, Short.MAX_VALUE))
        );

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void StockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StockActionPerformed

    }//GEN-LAST:event_StockActionPerformed

    private void StockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StockMouseClicked
        setStock ob=new setStock();
        ob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_StockMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
    if(login.Manager)
     {
        rond obj = new rond();
        obj.setVisible(true);
        this.dispose();
     }
     else
     {
        phar_rond obj = new phar_rond();
        obj.setVisible(true);
        this.dispose();
     }

    }//GEN-LAST:event_backMouseClicked


    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        if (txtsearch.getText().isEmpty()) {
        } else {
            Products_Model obj = Products_Operations.Search_Product(txtsearch.getText());
            if (obj != null) {
                this.dispose();
                products pr = new products();
                pr.show_Product(obj);
                pr.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "This product does not exist", "Message", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_SearchActionPerformed

    private void TableDark1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDark1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TableDark1MouseClicked


    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
      String name = arr.get(row_number).getMed_name();
        Products_Operations.Delete_Product(name);
        this.dispose(); 
        products gg = new products();
        gg.show_table();
        gg.setVisible(true);
       // JOptionPane.showMessageDialog(null, "Product has been Deleted Successfully", "Message", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_DeleteActionPerformed

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              new products().setVisible(true);
            
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.mybutton Delete;
    private button.mybutton Search;
    private button.mybutton Stock;
    private tabledark.TableDark TableDark1;
    private javax.swing.JLabel back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables

  
}
