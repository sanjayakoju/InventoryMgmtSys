package com.bway.inventorysystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuickBillForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblWelcomeToThe;
	private JButton btnAdminLogin;
	private JButton btnCashierLogin;
	private JLabel lblQuickBill;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuickBillForm frame = new QuickBillForm();
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
	public QuickBillForm() {
		setTitle("Quickbill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 441);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(106, 90, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblWelcomeToThe());
		contentPane.add(getBtnAdminLogin());
		contentPane.add(getBtnCashierLogin());
		contentPane.add(getLblQuickBill());
	}
	private JLabel getLblWelcomeToThe() {
		if (lblWelcomeToThe == null) {
			lblWelcomeToThe = new JLabel("Welcome To Super Market Billing Sysytem");
			lblWelcomeToThe.setForeground(Color.BLUE);
			lblWelcomeToThe.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblWelcomeToThe.setBounds(54, 23, 448, 79);
		}
		return lblWelcomeToThe;
	}
	private JButton getBtnAdminLogin() {
		if (btnAdminLogin == null) {
			btnAdminLogin = new JButton("Admin Login");
			btnAdminLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					LoginForm login=new LoginForm();
					login.setVisible(true);
					dispose();
				}
			});
			btnAdminLogin.setForeground(Color.BLUE);
			btnAdminLogin.setBounds(350, 156, 126, 28);
		}
		return btnAdminLogin;
	}
	private JButton getBtnCashierLogin() {
		if (btnCashierLogin == null) {
			btnCashierLogin = new JButton("Cashier Login");
			btnCashierLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					CashierLogin login=new CashierLogin();
					login.setVisible(true);
					dispose();
				}
			});
			btnCashierLogin.setForeground(Color.BLUE);
			btnCashierLogin.setBounds(350, 219, 126, 28);
		}
		return btnCashierLogin;
	}
	private JLabel getLblQuickBill() {
		if (lblQuickBill == null) {
			lblQuickBill = new JLabel("Quick Bill");
			lblQuickBill.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblQuickBill.setForeground(Color.BLUE);
			lblQuickBill.setBounds(120, 263, 95, 28);
		}
		return lblQuickBill;
	}
}
