package com.bway.inventorysystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bway.inventorysystem.dao.UserController;
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

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblLoginForm;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField usernameTxt;
	private JPasswordField passwordTxt;
	private JButton btnCancel;
	private JButton btnLogin;
	private JButton btnClickHereTo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(75, 0, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getLblUsername());
		contentPane.add(getLblPassword());
		contentPane.add(getUsernameTxt());
		contentPane.add(getPasswordTxt());
		contentPane.add(getBtnCancel());
		contentPane.add(getBtnLogin());
		contentPane.add(getBtnClickHereTo());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(255, 69, 0));
			panel.setBounds(0, 0, 561, 56);
			panel.setLayout(null);
			panel.add(getLblLoginForm());
		}
		return panel;
	}
	private JLabel getLblLoginForm() {
		if (lblLoginForm == null) {
			lblLoginForm = new JLabel("Login Form");
			lblLoginForm.setBounds(208, 11, 119, 34);
			lblLoginForm.setForeground(new Color(230, 230, 250));
			lblLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 19));
		}
		return lblLoginForm;
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username");
			lblUsername.setForeground(new Color(230, 230, 250));
			lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblUsername.setBounds(81, 155, 104, 24);
		}
		return lblUsername;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setForeground(new Color(250, 235, 215));
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPassword.setBounds(81, 208, 90, 29);
		}
		return lblPassword;
	}
	private JTextField getUsernameTxt() {
		if (usernameTxt == null) {
			usernameTxt = new JTextField();
			usernameTxt.setBounds(214, 159, 176, 29);
			usernameTxt.setColumns(10);
		}
		return usernameTxt;
	}
	private JPasswordField getPasswordTxt() {
		if (passwordTxt == null) {
			passwordTxt = new JPasswordField();
			passwordTxt.setBounds(214, 208, 176, 29);
		}
		return passwordTxt;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					QuickBillForm quick=new QuickBillForm();
					quick.setVisible(true);
					dispose();
				}
			});
			btnCancel.setBackground(new Color(255, 0, 0));
			btnCancel.setForeground(new Color(230, 230, 250));
			btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnCancel.setBounds(195, 292, 89, 36);
		}
		return btnCancel;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					User ob=new User();
					ob.setUsername(usernameTxt.getText());
					ob.setPassword(passwordTxt.getText());
					UserController uc=new UserController();
					int status=uc.userLogin(ob);
					if(status==-1)
					{
						JOptionPane.showMessageDialog(null,"Invalid user");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Logged as as Admin" );
						MenuAdmin m=new MenuAdmin();
						m.setVisible(true);
						dispose();
					}
					
				}
			});
			btnLogin.setForeground(new Color(230, 230, 250));
			btnLogin.setBackground(new Color(65, 105, 225));
			btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnLogin.setBounds(309, 292, 89, 36);
		}
		return btnLogin;
	}
	private JButton getBtnClickHereTo() {
		if (btnClickHereTo == null) {
			btnClickHereTo = new JButton("Click here to create a new account");
			btnClickHereTo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					RegisterForm register=new RegisterForm();
					register.setVisible(true);
					dispose();
				}
			});
			btnClickHereTo.setBorder(null);
			btnClickHereTo.setBackground(new Color(75, 0, 130));
			btnClickHereTo.setForeground(new Color(230, 230, 250));
			btnClickHereTo.setBounds(162, 364, 270, 23);
		}
		return btnClickHereTo;
	}
}
