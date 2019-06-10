package com.bway.inventorysystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.bway.inventorysystem.dao.SaleDao;
import com.bway.inventorysystem.dao.SaleDaoImpl;
import com.bway.inventorysystem.model.Sale;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class SearchBill extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblBillNo;
	private JTextField billNotxt;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBill frame = new SearchBill();
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
	public SearchBill() {
		setTitle("Search Bill");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 684, 561);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(75, 0, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblBillNo());
		contentPane.add(getBillNotxt());
		contentPane.add(getBtnSearch());
		contentPane.add(getScrollPane());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Search Bill");
			lblNewLabel.setForeground(new Color(250, 235, 215));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel.setBounds(286, 47, 277, 45);
		}
		return lblNewLabel;
	}
	private JLabel getLblBillNo() {
		if (lblBillNo == null) {
			lblBillNo = new JLabel("Bill No");
			lblBillNo.setForeground(new Color(250, 235, 215));
			lblBillNo.setBounds(158, 119, 46, 14);
		}
		return lblBillNo;
	}
	private JTextField getBillNotxt() {
		if (billNotxt == null) {
			billNotxt = new JTextField();
			billNotxt.setBounds(246, 116, 124, 20);
			billNotxt.setColumns(10);
		}
		return billNotxt;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Sale ob=new Sale();
					ob.setSaleId(Integer.parseInt(billNotxt.getText()));
					SaleDao sdao=new SaleDaoImpl();
					List<Sale> slist=sdao.fetchData(ob);
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					model.setRowCount(0);
					for(int i=0;i<slist.size();i++)
			        {
						
			            model.addRow(new Object[]
			            {
			            slist.get(i).getSaleId(),
			            slist.get(i).getCustomerName(),
			            slist.get(i).getProductName(),
			            slist.get(i).getTotal(),
			            slist.get(i).getDate()});
			        }
				}
			});
			btnSearch.setForeground(new Color(0, 0, 0));
			btnSearch.setBounds(432, 115, 89, 23);
		}
		return btnSearch;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(83, 163, 499, 321);
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
					"Bill No", "Customer Name", "Product Name","Amount", "Date"
				}
			));
		}
		return table;
	}
}
