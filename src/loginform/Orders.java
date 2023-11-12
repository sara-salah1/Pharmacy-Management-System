package loginform;

import Control.Orders_Operations;
import Modeling.Customers_Model;
import Modeling.Orders_Model;
import Modeling.Pharmacist_Model;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Seifeldin Ahmed
 */
public class Orders extends javax.swing.JFrame {
   private static  int row_number=0;
   public  Orders_Operations All_data = new Orders_Operations();


    public static int getRow_number() {
        return row_number;
    }


    public Orders() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        search1 = new javax.swing.JTextField();
        SearchButton = new button.mybutton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableDark2 = new tabledark.TableDark();
        OrderInfo = new button.mybutton();
        MakeOrder = new button.mybutton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pharmacy (15).png"))); // NOI18N
        jLabel4.setRequestFocusEnabled(false);
        jLabel4.setVerifyInputWhenFocusTarget(false);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back-button.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/product.png"))); // NOI18N
        jLabel6.setInheritsPopupMenu(false);
        jLabel6.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel6.setRequestFocusEnabled(false);

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(6, 107, 138));
        jTextField2.setText("Order List");
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        search1.setText("Enter Order Number");
        search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search1ActionPerformed(evt);
            }
        });

        SearchButton.setBackground(new java.awt.Color(6, 107, 138));
        SearchButton.setForeground(new java.awt.Color(255, 255, 255));
        SearchButton.setText("Search");
        SearchButton.setBorderColor(new java.awt.Color(255, 255, 255));
        SearchButton.setBorderPainted(false);
        SearchButton.setColorClick(new java.awt.Color(0, 153, 153));
        SearchButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SearchButton.setRadius(10);
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        TableDark2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Order Number", "Price", "Customer ID", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableDark2.setGridColor(new java.awt.Color(0, 102, 102));
        TableDark2.getTableHeader().setReorderingAllowed(false);
        TableDark2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDark2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableDark2);

        OrderInfo.setBackground(new java.awt.Color(6, 107, 138));
        OrderInfo.setForeground(new java.awt.Color(255, 255, 255));
        OrderInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/box.png"))); // NOI18N
        OrderInfo.setText("Order Info");
        OrderInfo.setBorderColor(new java.awt.Color(255, 255, 255));
        OrderInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        OrderInfo.setRadius(10);
        OrderInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderInfoMouseClicked(evt);
            }
        });
        OrderInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderInfoActionPerformed(evt);
            }
        });

        MakeOrder.setBackground(new java.awt.Color(6, 107, 138));
        MakeOrder.setForeground(new java.awt.Color(255, 255, 255));
        MakeOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add-product.png"))); // NOI18N
        MakeOrder.setText("Make Order");
        MakeOrder.setBorderColor(new java.awt.Color(255, 255, 255));
        MakeOrder.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MakeOrder.setRadius(10);
        MakeOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MakeOrderMouseClicked(evt);
            }
        });
        MakeOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MakeOrderActionPerformed(evt);
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
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(search1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 64, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(OrderInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178)
                        .addComponent(MakeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(68, 68, 68))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(search1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 93, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(OrderInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MakeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
     public void show_table() {
        DefaultTableModel mm = (DefaultTableModel) TableDark2.getModel();
        All_data.get_OrderData();
        Object[] row = new Object[4];
         for (int i = 0; i < All_data.order_arr.size(); i++) {
            row[0] = All_data.order_arr.get(i).getOrder_number(); 
            row[1] = All_data.order_arr.get(i).getPrice();
            row[2] = All_data.Customers_arr.get(i).getFirstname() +" " + All_data.Customers_arr.get(i).getLastname();
            row[3] = All_data.order_arr.get(i).getDate();
            mm.insertRow(i, row);         
        }
    
        // Mouse Event
        TableDark2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                row_number = TableDark2.getSelectedRow();
            }
         }
         );
                }
     
     private void show_order( ArrayList<Object> arr) 
    {
        DefaultTableModel pr = (DefaultTableModel) TableDark2.getModel();
        Object[] row = new Object[4];
        row[0] = ((Orders_Model)arr.get(3)).getOrder_number();
        row[1] = ((Orders_Model)arr.get(3)).getPrice();
        row[2] = ((Customers_Model)arr.get(1)).getFirstname() + " " + ((Customers_Model)arr.get(1)).getLastname(); 
        row[3] = ((Orders_Model)arr.get(3)).getDate();
        pr.insertRow(0, row);
        
        TableDark2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                row_number = TableDark2.getSelectedRow();
            }
        }
        );
    }
    
    
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
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
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search1ActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        if (search1.getText().isEmpty()) {
        } else {
            ArrayList<Object> obj = Orders_Operations.Search_Order(Integer.parseInt(search1.getText()));
            if (obj != null) {
                this.dispose();
                Orders pr = new Orders();
                pr.show_order(obj);
                pr.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "This Order does not exist", "Message", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void TableDark2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDark2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TableDark2MouseClicked

    private void OrderInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderInfoMouseClicked
        OrderInfo obj=new OrderInfo();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_OrderInfoMouseClicked

    private void OrderInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderInfoActionPerformed

    }//GEN-LAST:event_OrderInfoActionPerformed

    private void MakeOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MakeOrderMouseClicked
     MakeOrder obj = new MakeOrder();
     obj.setVisible(true);
     this.dispose();
    }//GEN-LAST:event_MakeOrderMouseClicked

    private void MakeOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MakeOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MakeOrderActionPerformed

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
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Orders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.mybutton MakeOrder;
    private button.mybutton OrderInfo;
    private button.mybutton SearchButton;
    private tabledark.TableDark TableDark2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField search1;
    // End of variables declaration//GEN-END:variables
}
