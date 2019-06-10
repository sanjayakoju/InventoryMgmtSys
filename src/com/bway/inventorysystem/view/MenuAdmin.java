package com.bway.inventorysystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;

public class MenuAdmin extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnQuickBill;
	private JButton btnCashier;
	private JButton btnTransaction;
	private JButton btnStock;
	private JButton btnSales;
	private JButton btnExit;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdmin frame = new MenuAdmin();
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
	public MenuAdmin() {
		setTitle("Admin Menu");
		setMinimumSize(new Dimension(1366, 721));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 719);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getDesktopPane());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(255, 215, 0));
			panel.setBounds(0, 0, 1360, 60);
			panel.setLayout(null);
			panel.add(getBtnQuickBill());
			panel.add(getBtnCashier());
			panel.add(getBtnTransaction());
			panel.add(getBtnStock());
			panel.add(getBtnSales());
			panel.add(getBtnExit());
		}
		return panel;
	}
	private JButton getBtnQuickBill() {
		if (btnQuickBill == null) {
			btnQuickBill = new JButton("Quick Bill");
			btnQuickBill.setBorder(null);
			btnQuickBill.setBackground(new Color(255, 215, 0));
			btnQuickBill.setBounds(10, 11, 89, 43);
		}
		return btnQuickBill;
	}
	private JButton getBtnCashier() {
		if (btnCashier == null) {
			btnCashier = new JButton("Cashier");
			btnCashier.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					AddCashier ob=new AddCashier();
					ob.setVisible(true);
					
				}
			});
			btnCashier.setBorder(null);
			btnCashier.setBackground(new Color(255, 215, 0));
			btnCashier.setBounds(170, 21, 89, 23);
		}
		return btnCashier;
	}
	private JButton getBtnTransaction() {
		if (btnTransaction == null) {
			btnTransaction = new JButton("Transaction");
			btnTransaction.setBorder(null);
			btnTransaction.setBackground(new Color(255, 215, 0));
			btnTransaction.setBounds(296, 21, 152, 23);
		}
		return btnTransaction;
	}
	private JButton getBtnStock() {
		if (btnStock == null) {
			btnStock = new JButton("Stock");
			btnStock.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					UpdateStock us=new UpdateStock();
					us.setVisible(true);
				}
			});
			btnStock.setBorder(null);
			btnStock.setBackground(new Color(255, 215, 0));
			btnStock.setBounds(495, 21, 89, 23);
		}
		return btnStock;
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
			btnSales.setBounds(651, 21, 89, 23);
		}
		return btnSales;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					QuickBillForm qb=new QuickBillForm();
					qb.setVisible(true);
					dispose();
				}
			});
			btnExit.setBorder(null);
			btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnExit.setIcon(new ImageIcon("D:\\Icons\\if_button_cancel_18572.png"));
			btnExit.setBackground(new Color(255, 215, 0));
			btnExit.setBounds(1187, 9, 115, 43);
		}
		return btnExit;
	}
	private JDesktopPane getDesktopPane() {
		if (desktopPane == null) {
			desktopPane = new JDesktopPane();
			desktopPane.setBackground(new Color(255, 0, 255));
			desktopPane.setBounds(0, 729, 1360, 669);
		}
		return desktopPane;
	}
}
