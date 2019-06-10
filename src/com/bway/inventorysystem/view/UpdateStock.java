package com.bway.inventorysystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateStock extends JFrame {

	private JPanel contentPane;
	private JLabel lblUpdateStock;
	private JLabel lblProductId;
	private JLabel lblProductName;
	private JLabel lblQuantityAvailable;
	private JLabel lblQuantityAdded;
	private JLabel lblMrp;
	private JTextField productIdTxt;
	private JTextField productNameTxt;
	private JTextField quantityAvailableTxt;
	private JTextField quantityAddedTxt;
	private JTextField mrpTxt;
	private JButton btnNew;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStock frame = new UpdateStock();
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
	public UpdateStock() {
		setTitle("Update Stock");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 90, 1114, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblUpdateStock());
		contentPane.add(getLblProductId());
		contentPane.add(getLblProductName());
		contentPane.add(getLblQuantityAvailable());
		contentPane.add(getLblQuantityAdded());
		contentPane.add(getLblMrp());
		contentPane.add(getProductIdTxt());
		contentPane.add(getProductNameTxt());
		contentPane.add(getQuantityAvailableTxt());
		contentPane.add(getQuantityAddedTxt());
		contentPane.add(getMrpTxt());
		contentPane.add(getBtnNew());
		contentPane.add(getBtnNewButton());
		contentPane.add(getScrollPane());
		displayStock();
	}

	private JLabel getLblUpdateStock() {
		if (lblUpdateStock == null) {
			lblUpdateStock = new JLabel("Update Stock");
			lblUpdateStock.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblUpdateStock.setBounds(120, 53, 241, 42);
		}
		return lblUpdateStock;
	}
	private JLabel getLblProductId() {
		if (lblProductId == null) {
			lblProductId = new JLabel("Product Id");
			lblProductId.setBounds(70, 127, 92, 14);
		}
		return lblProductId;
	}
	private JLabel getLblProductName() {
		if (lblProductName == null) {
			lblProductName = new JLabel("Product Name");
			lblProductName.setBounds(70, 167, 116, 14);
		}
		return lblProductName;
	}
	private JLabel getLblQuantityAvailable() {
		if (lblQuantityAvailable == null) {
			lblQuantityAvailable = new JLabel("Quantity Available");
			lblQuantityAvailable.setBounds(68, 207, 118, 14);
		}
		return lblQuantityAvailable;
	}
	private JLabel getLblQuantityAdded() {
		if (lblQuantityAdded == null) {
			lblQuantityAdded = new JLabel("Quantity Added");
			lblQuantityAdded.setBounds(70, 250, 116, 14);
		}
		return lblQuantityAdded;
	}
	private JLabel getLblMrp() {
		if (lblMrp == null) {
			lblMrp = new JLabel("Mrp");
			lblMrp.setBounds(70, 296, 92, 14);
		}
		return lblMrp;
	}
	private JTextField getProductIdTxt() {
		if (productIdTxt == null) {
			productIdTxt = new JTextField();
			productIdTxt.setEditable(false);
			productIdTxt.setBounds(237, 124, 182, 20);
			productIdTxt.setColumns(10);
		}
		return productIdTxt;
	}
	private JTextField getProductNameTxt() {
		if (productNameTxt == null) {
			productNameTxt = new JTextField();
			productNameTxt.setBounds(237, 164, 182, 20);
			productNameTxt.setColumns(10);
		}
		return productNameTxt;
	}
	private JTextField getQuantityAvailableTxt() {
		if (quantityAvailableTxt == null) {
			quantityAvailableTxt = new JTextField();
			quantityAvailableTxt.setEditable(false);
			quantityAvailableTxt.setBounds(237, 204, 182, 20);
			quantityAvailableTxt.setColumns(10);
		}
		return quantityAvailableTxt;
	}
	private JTextField getQuantityAddedTxt() {
		if (quantityAddedTxt == null) {
			quantityAddedTxt = new JTextField();
			quantityAddedTxt.setBounds(237, 247, 182, 20);
			quantityAddedTxt.setColumns(10);
		}
		return quantityAddedTxt;
	}
	private JTextField getMrpTxt() {
		if (mrpTxt == null) {
			mrpTxt = new JTextField();
			mrpTxt.setBounds(237, 293, 182, 20);
			mrpTxt.setColumns(10);
		}
		return mrpTxt;
	}
	private JButton getBtnNew() {
		if (btnNew == null) {
			btnNew = new JButton("New");
			btnNew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Stock s=new Stock();
					s.setProductName(productNameTxt.getText());
					s.setQuantityAdded(Integer.parseInt(quantityAddedTxt.getText().toString()));
					//s.setQuantityAvailable(Integer.parseInt(quantityAvailableTxt.getText().toString()));
					s.setMrp(Integer.parseInt(mrpTxt.getText().toString()));
					StockDao sdao=new StockDaoImpl();
					if(sdao.addStock(s))
					{
						JOptionPane.showMessageDialog(null,"Product added successfull.");
						displayStock();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Stock add fail!!");
					}
				}
			});
			btnNew.setBounds(132, 391, 89, 23);
		}
		return btnNew;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Update");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(table.getSelectedRow()<0)
					{
						JOptionPane.showMessageDialog(null, "Please select any row from table");
						return;
					}
					Stock s=new Stock();
					s.setStockId(Integer.parseInt(productIdTxt.getText()));
					s.setProductName(productNameTxt.getText());
					s.setQuantityAvailable(Integer.parseInt(quantityAvailableTxt.getText()));
					s.setQuantityAdded(Integer.parseInt(quantityAddedTxt.getText()));
					s.setMrp(Integer.parseInt(mrpTxt.getText()));
					
					StockDaoImpl sdao=new StockDaoImpl();
					if(sdao.updateStock(s))
					{
						JOptionPane.showMessageDialog(null,"Stock Update");
						displayStock();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Stock Update fail!!");
					}
					
				}
			});
			btnNewButton.setBounds(298, 391, 89, 23);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(481, 71, 586, 412);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					int row=table.getSelectedRow();
					productIdTxt.setText(table.getValueAt(row, 0).toString());
					productNameTxt.setText(table.getValueAt(row, 1).toString());
					quantityAvailableTxt.setText(table.getValueAt(row,2).toString());
					mrpTxt.setText(table.getValueAt(row,3).toString());
				}
			});
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
	
	public void displayStock()
	{
		StockDao sdao=new StockDaoImpl();
		List<Stock> slist=sdao.getAllStock();
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for(Stock s:slist)
		{
			int stock=s.getQuantityAvailable()+s.getQuantityAdded();
			model.addRow(new Object[] {
					s.getStockId(),s.getProductName(),stock ,s.getMrp()
			});
		}
	}
}
