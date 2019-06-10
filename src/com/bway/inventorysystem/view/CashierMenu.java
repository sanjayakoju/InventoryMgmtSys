package com.bway.inventorysystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierMenu extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnQuickBill;
	private JButton btnNewBill;
	private JButton btnSearchBill;
	private JButton btnProductInformation;
	private JButton btnSales;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierMenu frame = new CashierMenu();
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
	public CashierMenu() {
		setTitle("Cashier Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(255, 215, 0));
			panel.setBounds(0, 0, 1350, 73);
			panel.setLayout(null);
			panel.add(getBtnQuickBill());
			panel.add(getBtnNewBill());
			panel.add(getBtnSearchBill());
			panel.add(getBtnProductInformation());
			panel.add(getBtnSales());
			panel.add(getBtnExit());
		}
		return panel;
	}
	private JButton getBtnQuickBill() {
		if (btnQuickBill == null) {
			btnQuickBill = new JButton("Quick Bill");
			btnQuickBill.setBackground(new Color(255, 0, 0));
			btnQuickBill.setBounds(10, 11, 89, 55);
		}
		return btnQuickBill;
	}
	private JButton getBtnNewBill() {
		if (btnNewBill == null) {
			btnNewBill = new JButton("New Bill");
			btnNewBill.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					NewBillForm bill=new NewBillForm();
					bill.setVisible(true);
					
				}
			});
			btnNewBill.setBorder(null);
			btnNewBill.setBackground(new Color(255, 215, 0));
			btnNewBill.setBounds(190, 27, 89, 23);
		}
		return btnNewBill;
	}
	private JButton getBtnSearchBill() {
		if (btnSearchBill == null) {
			btnSearchBill = new JButton("Search Bill");
			btnSearchBill.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					SearchBill s=new SearchBill();
					s.setVisible(true);
				}
			});
			btnSearchBill.setBorder(null);
			btnSearchBill.setBackground(new Color(255, 215, 0));
			btnSearchBill.setBounds(296, 27, 89, 23);
		}
		return btnSearchBill;
	}
	private JButton getBtnProductInformation() {
		if (btnProductInformation == null) {
			btnProductInformation = new JButton("Product Information");
			btnProductInformation.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ProductInformation pi=new ProductInformation();
					pi.setVisible(true);
				}
			});
			btnProductInformation.setBorder(null);
			btnProductInformation.setBackground(new Color(255, 215, 0));
			btnProductInformation.setBounds(416, 27, 169, 23);
		}
		return btnProductInformation;
	}
	private JButton getBtnSales() {
		if (btnSales == null) {
			btnSales = new JButton("Sales");
			btnSales.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SaleInfo sf=new SaleInfo();
					sf.setVisible(true);
				}
			});
			btnSales.setBorder(null);
			btnSales.setBackground(new Color(255, 215, 0));
			btnSales.setBounds(617, 27, 89, 23);
		}
		return btnSales;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					CashierLogin ob=new CashierLogin();
					ob.setVisible(true);
					dispose();
				}
			});
			btnExit.setIcon(new ImageIcon("D:\\Icons\\if_button_fewer_7697.png"));
			btnExit.setBackground(new Color(255, 215, 0));
			btnExit.setBorder(null);
			btnExit.setBounds(1229, 17, 89, 43);
		}
		return btnExit;
	}
}
