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

import com.bway.inventorysystem.dao.StockDao;
import com.bway.inventorysystem.dao.StockDaoImpl;
import com.bway.inventorysystem.model.Stock;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ProductInformation extends JFrame {

	private JPanel contentPane;
	private JLabel lblProductInformation;
	private JLabel lblProductName;
	private JTextField productNameTxt;
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
					ProductInformation frame = new ProductInformation();
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
	public ProductInformation() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 688, 556);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(75, 0, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblProductInformation());
		contentPane.add(getLblProductName());
		contentPane.add(getProductNameTxt());
		contentPane.add(getBtnSearch());
		contentPane.add(getScrollPane());
	}

	private JLabel getLblProductInformation() {
		if (lblProductInformation == null) {
			lblProductInformation = new JLabel("Product Information");
			lblProductInformation.setForeground(new Color(250, 235, 215));
			lblProductInformation.setFont(new Font("Dialog", Font.PLAIN, 24));
			lblProductInformation.setBounds(218, 40, 259, 48);
		}
		return lblProductInformation;
	}
	private JLabel getLblProductName() {
		if (lblProductName == null) {
			lblProductName = new JLabel("Product Name");
			lblProductName.setForeground(new Color(250, 235, 215));
			lblProductName.setBounds(96, 120, 143, 14);
		}
		return lblProductName;
	}
	private JTextField getProductNameTxt() {
		if (productNameTxt == null) {
			productNameTxt = new JTextField();
			productNameTxt.setBounds(229, 117, 167, 20);
			productNameTxt.setColumns(10);
		}
		return productNameTxt;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					Stock ob=new Stock();
					ob.setProductName(productNameTxt.getText());
					StockDao sdao=new StockDaoImpl();
					List<Stock> list=sdao.fetchData(ob);
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					model.setRowCount(0);
					for(int i=0;i<list.size();i++)
			        {
						int st=list.get(i).getQuantityAvailable()+list.get(i).getQuantityAdded();
			            model.addRow(new Object[]
			            {
			            list.get(i).getStockId(),
			            list.get(i).getProductName(),
			            st,
			            list.get(i).getMrp()});
			        }
			        
				
				
				}
			});
			btnSearch.setBounds(418, 116, 89, 23);
		}
		return btnSearch;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBackground(new Color(75, 0, 130));
			scrollPane.setBounds(83, 186, 524, 275);
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
					"Product Id", "Product Name", "Available", "Mrp"
				}
			));
		}
		return table;
	}
	
	
}
