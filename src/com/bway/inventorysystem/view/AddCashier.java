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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.bway.inventorysystem.dao.CashierDao;
import com.bway.inventorysystem.dao.CashierDaoImpl;
import com.bway.inventorysystem.model.Cashier;


import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddCashier extends JFrame {

	private JPanel contentPane;
	private JLabel lblAddCashierDetail;
	private JLabel lblCashierId;
	private JLabel lblCashierName;
	private JLabel lblMobileNumber;
	private JLabel lblAddress;
	private JLabel lblEmailId;
	private JLabel lblPassword;
	private JTextField cashierIdTxt;
	private JTextField cashierNameTxt;
	private JTextField mobileNoTxt;
	private JTextField addressTxt;
	private JTextField emailIdTxt;
	private JPasswordField passwordTxt;
	private JButton btnAddNew;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCashier frame = new AddCashier();
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
	public AddCashier() {
		setResizable(false);
		setTitle("Add Cashier");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 90, 1114, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblAddCashierDetail());
		contentPane.add(getLblCashierId());
		contentPane.add(getLblCashierName());
		contentPane.add(getLblMobileNumber());
		contentPane.add(getLblAddress());
		contentPane.add(getLblEmailId());
		contentPane.add(getLblPassword());
		contentPane.add(getCashierIdTxt());
		contentPane.add(getCashierNameTxt());
		contentPane.add(getMobileNoTxt());
		contentPane.add(getAddressTxt());
		contentPane.add(getEmailIdTxt());
		contentPane.add(getPasswordTxt());
		contentPane.add(getBtnAddNew());
		contentPane.add(getBtnNewButton());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnDelete());
		displayCashier();
	}

	private JLabel getLblAddCashierDetail() {
		if (lblAddCashierDetail == null) {
			lblAddCashierDetail = new JLabel("Add Cashier Details");
			lblAddCashierDetail.setFont(new Font("Dialog", Font.BOLD, 24));
			lblAddCashierDetail.setBounds(62, 37, 402, 38);
		}
		return lblAddCashierDetail;
	}
	private JLabel getLblCashierId() {
		if (lblCashierId == null) {
			lblCashierId = new JLabel("Cashier Id");
			lblCashierId.setBounds(62, 106, 95, 14);
		}
		return lblCashierId;
	}
	private JLabel getLblCashierName() {
		if (lblCashierName == null) {
			lblCashierName = new JLabel("Cashier Name");
			lblCashierName.setBounds(62, 143, 143, 14);
		}
		return lblCashierName;
	}
	private JLabel getLblMobileNumber() {
		if (lblMobileNumber == null) {
			lblMobileNumber = new JLabel("Mobile Number");
			lblMobileNumber.setBounds(60, 178, 145, 14);
		}
		return lblMobileNumber;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setBounds(62, 217, 136, 14);
		}
		return lblAddress;
	}
	private JLabel getLblEmailId() {
		if (lblEmailId == null) {
			lblEmailId = new JLabel("Email Id");
			lblEmailId.setBounds(62, 253, 117, 14);
		}
		return lblEmailId;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setBounds(62, 296, 95, 14);
		}
		return lblPassword;
	}
	private JTextField getCashierIdTxt() {
		if (cashierIdTxt == null) {
			cashierIdTxt = new JTextField();
			cashierIdTxt.setEnabled(false);
			cashierIdTxt.setEditable(false);
			cashierIdTxt.setBounds(275, 103, 189, 20);
			cashierIdTxt.setColumns(10);
		}
		return cashierIdTxt;
	}
	private JTextField getCashierNameTxt() {
		if (cashierNameTxt == null) {
			cashierNameTxt = new JTextField();
			cashierNameTxt.setBounds(275, 140, 189, 20);
			cashierNameTxt.setColumns(10);
		}
		return cashierNameTxt;
	}
	private JTextField getMobileNoTxt() {
		if (mobileNoTxt == null) {
			mobileNoTxt = new JTextField();
			mobileNoTxt.setBounds(275, 175, 189, 20);
			mobileNoTxt.setColumns(10);
		}
		return mobileNoTxt;
	}
	private JTextField getAddressTxt() {
		if (addressTxt == null) {
			addressTxt = new JTextField();
			addressTxt.setBounds(275, 214, 189, 20);
			addressTxt.setColumns(10);
		}
		return addressTxt;
	}
	private JTextField getEmailIdTxt() {
		if (emailIdTxt == null) {
			emailIdTxt = new JTextField();
			emailIdTxt.setBounds(275, 250, 189, 20);
			emailIdTxt.setColumns(10);
		}
		return emailIdTxt;
	}
	private JPasswordField getPasswordTxt() {
		if (passwordTxt == null) {
			passwordTxt = new JPasswordField();
			passwordTxt.setBounds(275, 293, 189, 20);
		}
		return passwordTxt;
	}
	private JButton getBtnAddNew() {
		if (btnAddNew == null) {
			btnAddNew = new JButton("Add New");
			btnAddNew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Cashier c=new Cashier();
					c.setCashierName(cashierNameTxt.getText());
					c.setAddress(addressTxt.getText());
					c.setEmail(emailIdTxt.getText());
					c.setMobileNumber(mobileNoTxt.getText());
					c.setPassword(passwordTxt.getText());
					
					CashierDao cdao=new CashierDaoImpl();
					if(cdao.addCashier(c))
					{
						JOptionPane.showMessageDialog(null,"Cashier added successfully.");
						displayCashier();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Cashier add fail!!");
					}
					
				}
			});
			btnAddNew.setIcon(new ImageIcon("D:\\Icons\\if_login_54330.png"));
			btnAddNew.setBounds(33, 415, 117, 55);
		}
		return btnAddNew;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Update");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if(table.getSelectedRow()<0)
					{
						JOptionPane.showMessageDialog(null, "Please select any row from table");
						return;
					}
					Cashier c=new Cashier();
					c.setCashierId(Integer.parseInt(cashierIdTxt.getText()));
					c.setCashierName(cashierNameTxt.getText());
					c.setAddress(addressTxt.getText());
					c.setEmail(emailIdTxt.getText());
					c.setMobileNumber(mobileNoTxt.getText());
					c.setPassword(passwordTxt.getText());
					
					CashierDao cdao=new CashierDaoImpl();
					if(cdao.updateCashier(c))
					{
						JOptionPane.showMessageDialog(null,"Cashier update successfully.");
						displayCashier();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Cashier update fail!!");
					}
					
					
				}
			});
			btnNewButton.setIcon(new ImageIcon("D:\\Icons\\if_button-synchronize_blue_68694.png"));
			btnNewButton.setBounds(198, 413, 155, 59);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setEnabled(false);
			scrollPane.setBounds(555, 56, 516, 414);
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
					 cashierIdTxt.setText(table.getValueAt(row, 0).toString());
					 cashierNameTxt.setText(table.getValueAt(row,1).toString());
					 addressTxt.setText(table.getValueAt(row, 3).toString());
					 mobileNoTxt.setText(table.getValueAt(row,2).toString());
					 emailIdTxt.setText(table.getValueAt(row, 4).toString());
					 passwordTxt.setText(table.getValueAt(row,5).toString());
					 
				}
			});
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Name", "Mb No", "Address", "Email","Password"
				}
			));
		}
		return table;
	}
	
	public void displayCashier()
	{
		CashierDao cdao=new CashierDaoImpl();
		List<Cashier> clist=cdao.getAllCashier();
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for(Cashier c:clist)
		{
			model.addRow(new Object[] {c.getCashierId(),c.getCashierName(),c.getMobileNumber(),c.getAddress(),c.getEmail(),c.getPassword()});;
		}
		
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if(table.getSelectedRow()<0)
					{
						JOptionPane.showMessageDialog(null, "Please select any row from table");
						return;
					}
					
					int row=table.getSelectedRow();
					int id=(int) table.getModel().getValueAt(row, 0);
					
					CashierDao edao=new CashierDaoImpl();
					if(edao.deleteCashier(id))
					{
						JOptionPane.showMessageDialog(null, "Delete success");
						displayCashier();
					}
				}
			});
			btnDelete.setBounds(406, 431, 89, 23);
		}
		return btnDelete;
	}
}
