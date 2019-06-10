package com.bway.inventorysystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import com.bway.inventorysystem.dao.SaleDaoImpl;
import com.bway.inventorysystem.dao.StockDao;
import com.bway.inventorysystem.dao.StockDaoImpl;
import com.bway.inventorysystem.model.Sale;
import com.bway.inventorysystem.model.Stock;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class NewBillForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblCustomerName;
	private JLabel lblNewLabel;
	private JLabel lblMrp;
	private JLabel lblQuantity;
	private JTextField customerNameTxt;
	private JTextField quantityTxt;
	private JComboBox comboBox;
	private JButton btnAdd;
	private JButton btnRemove;
	private JScrollPane scrollPane;
	private JDateChooser dateChooser;
	private JLabel lblTotal;
	private JTextField totalTxt;
	private JButton btnPrint;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBillForm frame = new NewBillForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewBillForm() {
		setTitle("New Bill");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1011, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblCustomerName());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblMrp());
		contentPane.add(getLblQuantity());
		contentPane.add(getCustomerNameTxt());
		contentPane.add(getQuantityTxt());
		contentPane.add(getComboBox());
		contentPane.add(getBtnAdd());
		contentPane.add(getBtnRemove());
		contentPane.add(getScrollPane());
		contentPane.add(getDateChooser());
		contentPane.add(getLblTotal());
		contentPane.add(getTotalTxt());
		contentPane.add(getBtnPrint());
	}
	private JLabel getLblCustomerName() {
		if (lblCustomerName == null) {
			lblCustomerName = new JLabel("Customer Name");
			lblCustomerName.setBounds(70, 111, 130, 14);
		}
		return lblCustomerName;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Product Name");
			lblNewLabel.setBounds(70, 149, 115, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblMrp() {
		if (lblMrp == null) {
			lblMrp = new JLabel("Date");
			lblMrp.setBounds(70, 202, 115, 14);
		}
		return lblMrp;
	}
	private JLabel getLblQuantity() {
		if (lblQuantity == null) {
			lblQuantity = new JLabel("Quantity");
			lblQuantity.setBounds(70, 248, 115, 14);
		}
		return lblQuantity;
	}
	private JTextField getCustomerNameTxt() {
		if (customerNameTxt == null) {
			customerNameTxt = new JTextField();
			customerNameTxt.setBounds(235, 103, 143, 20);
			customerNameTxt.setColumns(10);
		}
		return customerNameTxt;
	}
	private JTextField getQuantityTxt() {
		if (quantityTxt == null) {
			quantityTxt = new JTextField();
			quantityTxt.setBounds(235, 245, 143, 20);
			quantityTxt.setColumns(10);
		}
		return quantityTxt;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addMouseListener(new MouseAdapter() {
				
			});
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
			StockDao sdao=new StockDaoImpl();
			List<Stock> slist=sdao.getAllStock();
			for(Stock s:slist)
			{
				
				comboBox.addItem(s.getProductName());
				
			}
			//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				
				}
			});
			comboBox.setBounds(235, 146, 143, 20);
		}
		return comboBox;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Stock ob=new Stock();
					String cname=customerNameTxt.getText();
					
					String pname=comboBox.getSelectedItem().toString();
					//ob.setProductName(pname);
					int qty=Integer.parseInt((quantityTxt.getText()));
					
					Date date=new Date(dateChooser.getDate().getTime());
					int total;
					if(!pname.equals(""))
					{
						StockDao s=new StockDaoImpl();
						Stock ob1= s.fetchDatas(pname);
						total=(int) (qty*ob1.getMrp());
						DefaultTableModel model=(DefaultTableModel) table.getModel();
						model.addRow(new Object[]{cname,ob1.getStockId(),ob1.getProductName(),date,qty,ob1.getMrp(),total});
						grandTotal();
					}
					
				}
			});
			btnAdd.setBounds(96, 339, 89, 23);
		}
		return btnAdd;
	}
	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("Remove");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					customerNameTxt.setText("");
					quantityTxt.setText("");
					
//					int count = table.getRowCount();
//					
//			        for(int i=0;i<count;i++)
//			        {
//			           table.removeRow(0);
//			        }
				}
			});
			btnRemove.setBounds(273, 339, 89, 23);
		}
		return btnRemove;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(434, 100, 526, 294);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setBounds(235, 196, 143, 20);
		}
		return dateChooser;
	}
	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("Total");
			lblTotal.setBounds(525, 420, 74, 14);
		}
		return lblTotal;
	}
	private JTextField getTotalTxt() {
		if (totalTxt == null) {
			totalTxt = new JTextField();
			totalTxt.setEditable(false);
			totalTxt.setBounds(609, 417, 130, 20);
			totalTxt.setColumns(10);
		}
		return totalTxt;
	}
	private JButton getBtnPrint() {
		if (btnPrint == null) {
			btnPrint = new JButton("Save and Print");
			btnPrint.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					List<Sale> slist=new ArrayList<>();
					int c=table.getRowCount();
					for(int i=0;i<c;i++)
					{
						Sale ob=new Sale();
						ob.setCustomerName(table.getValueAt(i, 0).toString());
						ob.setStockId(Integer.parseInt(table.getValueAt(i, 1).toString()));
						ob.setProductName(table.getValueAt(i, 2).toString());
						ob.setDate(table.getValueAt(i, 3).toString());
						ob.setQuantity(Integer.parseInt(table.getValueAt(i, 4).toString()));
						ob.setMrp(Integer.parseInt(table.getValueAt(i, 5).toString()));
						ob.setTotal(Double.parseDouble(table.getValueAt(i, 6).toString()));
						slist.add(ob);
					}
					SaleDaoImpl sadao=new SaleDaoImpl();
					sadao.addSale(slist);
					printBill();
				}
			});
			btnPrint.setBounds(525, 466, 143, 23);
		}
		return btnPrint;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"CustomerName","Product Id","Product Name","Date","Quantity","Mrp", "Total"
				}
			));
		}
		return table;
	}
	
	 private void grandTotal()
	    {
	        int count = table.getRowCount();
	            double total=0;
	            for(int i=0;i<count;i++)
	            {
	                total+=Double.parseDouble(table.getValueAt(i,6).toString());     
	            }
	            totalTxt.setText(total+"");
	    }
	 
	     void printBill()
	    {
	        int count=table.getRowCount();
	        String str="Quick sale, Kathmandu\n";
	        for(int i=0;i<count;i++)
	        {
	        	str+="Customer Name : ";
	            str+=table.getValueAt(i,0).toString()+" "+"\n";
	            str+="Product Name : ";
	            str+=table.getValueAt(i,2).toString()+" "+"\n";
	            str+="Date : ";
	            str+=table.getValueAt(i,3).toString()+" "+"\n";
	            str+="Quantity : ";
	            str+=table.getValueAt(i,4).toString()+" "+"\n";
	            str+="Mrp : ";
	            str+=table.getValueAt(i,5).toString()+" "+"\n";
	            
	            
	            
	        }
	        str+="Grand Total:"+totalTxt.getText();
	        str+="\nThank You For Visiting!!!";
	        
	        BillPrint ob=new BillPrint();
	        ob.billPrint.setLineWrap(true);
	        ob.billPrint.setText(str);
	        try
	        {
	            ob.billPrint.print();
	        }
	        catch(Exception ex)
	        {
	            System.out.println(ex);
	        }
	    }
}
