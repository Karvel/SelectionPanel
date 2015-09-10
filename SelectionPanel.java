/*
 Elanna Grossman
 Creates a GUI with event handling to select items from list
 */ 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.List;

public class SelectionPanel extends JFrame
{
   private JPanel jpSelectType  = new JPanel(new FlowLayout());
   private JScrollPane jScrollPane1 = new JScrollPane();
   private JList<String> jList1 = new JList<String>();
   
   private JComboBox<String> jcboSelectType = new JComboBox<String>();
   private JLabel jlblSelectionPrint = new JLabel();
   
   private JLabel jLabel1 = new JLabel();
   
   private String[] countriesNames = {"United States", "United Kingdom", "China", "Germany", "France"};
   
   public SelectionPanel()
   {
      this.setSize(new Dimension(350, 350));
      
      
      //listen for combo box
      jcboSelectType.addActionListener(new java.awt.event.ActionListener()
                                          {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            boxAction(e);
         }//end actionPerformed
      });
      
      
      //listen for list
      jList1.setListData(countriesNames);
      jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener()
                                         {
         public void valueChanged(ListSelectionEvent e)
         {
            listAction(e);
         }//end valueChanged
      });
      
      jLabel1.setText("Choose Selection Mode");
      add(jScrollPane1, BorderLayout.CENTER);
      jScrollPane1.getViewport().add(jList1, null);
      add(jpSelectType, BorderLayout.NORTH);
      jpSelectType.add(jLabel1, BorderLayout.WEST);
      jpSelectType.add(jcboSelectType, BorderLayout.CENTER);
      add(jlblSelectionPrint, BorderLayout.SOUTH);
      
      jcboSelectType.addItem("SINGLE_SELECTION");
      jcboSelectType.addItem("SINGLE-INTERVAL_SELECTION");
      jcboSelectType.addItem("MULTIPLE-INTERVAL_SELECTION");
   }//end SelectionPanel
   
   //event handler for combo box
   void boxAction(ActionEvent e)
   {
      String selectedMode = (String)jcboSelectType.getSelectedItem();
      
      if (selectedMode.equals("SINGLE_SELECTION"))
      {
         jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      }//end if
      else if (selectedMode.equals("SINGLE-INTERVAL_SELECTION"))
      {
         jList1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      }//end else if
      if (selectedMode.equals("MULTIPLE-INTERVAL_SELECTION"))
      {
         jList1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      }//end if
   }//end boxAction
   
   //event handler for list
   void listAction(ListSelectionEvent e)
   {
      int[] idx = jList1.getSelectedIndices();
      List listSelect = jList1.getSelectedValuesList();
      String printList = "";
      
      for (int i = 0; i < idx.length; i++)
      {
         printList += listSelect.get(i) + " ";
      }//end for
      
      jlblSelectionPrint.setText(printList);
   }//end listAction
   
   //Main method
   public static void main(String[] args)
   {
      SelectionTest frame = new SelectionTest();
      frame.setTitle("SelectionTest");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }//end main
}//end SelectionTest