package com.bway.inventorysystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.bway.inventorysystem.dao.SaleDao;
import com.bway.inventorysystem.dao.SaleDaoImpl;
import com.bway.inventorysystem.dao.StockDao;
import com.bway.inventorysystem.dao.StockDaoImpl;
import com.bway.inventorysystem.model.Sale;
import com.bway.inventorysystem.model.Stock;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class SaleInfo extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnNewButton;
	private JLabel lblSaleBillDeatail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleInfo frame = new SaleInfo();
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
	public SaleInfo() {
		setTitle("Sale Info");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 903, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(34, 139, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getBtnNewButton());
		contentPane.add(getLblSaleBillDeatail());
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(47, 104, 786, 322);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Customer name", "Product Name", "Date", "Quantity", "Mrp" , "Total"
				}
			));
		}
		return table;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Load sale");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					displaySale();
				}
			});
			btnNewButton.setBounds(386, 461, 156, 23);
		}
		return btnNewButton;
	}
	public void displaySale()
	{
		SaleDao sdao=new SaleDaoImpl();
		List<Sale> slist=sdao.getAllSale();
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for(Sale s:slist)
		{
			
			model.addRow(new Object[] {
					s.getCustomerName(),s.getProductName(),s.getDate() ,s.getQuantity(),s.getMrp(),s.getTotal()
			});
		}
	}
	private JLabel getLblSaleBillDeatail() {
		if (lblSaleBillDeatail == null) {
			lblSaleBillDeatail = new JLabel("Sales Bill Detail");
			lblSaleBillDeatail.setForeground(new Color(240, 248, 255));
			lblSaleBillDeatail.setBackground(new Color(0, 0, 139));
			lblSaleBillDeatail.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblSaleBillDeatail.setBounds(63, 47, 237, 34);
		}
		return lblSaleBillDeatail;
	}
}
