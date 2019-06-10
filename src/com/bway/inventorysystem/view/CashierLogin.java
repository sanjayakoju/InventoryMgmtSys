package com.bway.inventorysystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bway.inventorysystem.dao.CashierDao;
import com.bway.inventorysystem.dao.CashierDaoImpl;
import com.bway.inventorysystem.dao.UserController;
import com.bway.inventorysystem.model.Cashier;
import com.bway.inventorysystem.model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierLogin extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField cashierIdTxt;
	private JPasswordField passwordTxt;
	private JButton btnLogin;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierLogin frame = new CashierLogin();
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
	public CashierLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 391);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(75, 0, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getLblUsername());
		contentPane.add(getLblPassword());
		contentPane.add(getCashierIdTxt());
		contentPane.add(getPasswordTxt());
		contentPane.add(getBtnLogin());
		contentPane.add(getBtnCancel());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(255, 69, 0));
			panel.setBounds(0, 0, 525, 43);
			panel.setLayout(null);
			panel.add(getLblNewLabel());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Cashier Login");
			lblNewLabel.setForeground(new Color(250, 235, 215));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(25, 11, 128, 21);
		}
		return lblNewLabel;
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Email Id");
			lblUsername.setForeground(new Color(250, 235, 215));
			lblUsername.setBounds(83, 108, 82, 26);
		}
		return lblUsername;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setForeground(new Color(250, 235, 215));
			lblPassword.setBounds(83, 145, 70, 26);
		}
		return lblPassword;
	}
	private JTextField getCashierIdTxt() {
		if (cashierIdTxt == null) {
			cashierIdTxt = new JTextField();
			cashierIdTxt.setBounds(175, 111, 157, 20);
			cashierIdTxt.setColumns(10);
		}
		return cashierIdTxt;
	}
	private JPasswordField getPasswordTxt() {
		if (passwordTxt == null) {
			passwordTxt = new JPasswordField();
			passwordTxt.setBounds(175, 148, 157, 20);
		}
		return passwordTxt;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Cashier ob=new Cashier();
					ob.setEmail(cashierIdTxt.getText());
					ob.setPassword(passwordTxt.getText());
					CashierDao uc=new CashierDaoImpl();
					if(uc.cashierLogin(ob))
					{
						JOptionPane.showMessageDialog(null,"Logged as as Cashier" );
						CashierMenu m=new CashierMenu();
						m.setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid email Id and password");
					}
					
				}
			
				
			});
			btnLogin.setBackground(new Color(65, 105, 225));
			btnLogin.setForeground(new Color(250, 235, 215));
			btnLogin.setBounds(243, 212, 89, 23);
		}

		return btnLogin;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					QuickBillForm qb=new QuickBillForm();
					qb.setVisible(true);
					dispose();
				}
			});
			btnCancel.setBackground(new Color(255, 0, 0));
			btnCancel.setForeground(new Color(250, 235, 215));
			btnCancel.setBounds(142, 212, 89, 23);
		}
		return btnCancel;
	}
}
