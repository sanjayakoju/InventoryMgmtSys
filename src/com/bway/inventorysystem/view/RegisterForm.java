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
import javax.swing.JPasswordField;
import com.bway.inventorysystem.dao.UserController;
import com.bway.inventorysystem.model.User;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class RegisterForm extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblRetypePass;
	private JLabel lblBirthdate;
	private JLabel lblAddress;
	private JTextField firstNameTxt;
	private JTextField lastNameTxt;
	private JTextField usernameTxt;
	private JPasswordField passwordTxt;
	private JPasswordField retypePassTxt;
	private JTextField addressTxt;
	private JDateChooser dateChooser;
	private JButton btnCancel;
	private JButton btnRegister;
	private JButton btnClickHereTo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForm frame = new RegisterForm();
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
	public RegisterForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 584);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(75, 0, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getLblFirstName());
		contentPane.add(getLblLastName());
		contentPane.add(getLblUsername());
		contentPane.add(getLblPassword());
		contentPane.add(getLblRetypePass());
		contentPane.add(getLblBirthdate());
		contentPane.add(getLblAddress());
		contentPane.add(getFirstNameTxt());
		contentPane.add(getLastNameTxt());
		contentPane.add(getUsernameTxt());
		contentPane.add(getPasswordTxt());
		contentPane.add(getRetypePassTxt());
		contentPane.add(getAddressTxt());
		contentPane.add(getDateChooser());
		contentPane.add(getBtnCancel());
		contentPane.add(getBtnRegister());
		contentPane.add(getBtnClickHereTo());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(255, 69, 0));
			panel.setBounds(0, 0, 559, 57);
			panel.setLayout(null);
			panel.add(getLblNewLabel());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Register");
			lblNewLabel.setForeground(new Color(230, 230, 250));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
			lblNewLabel.setBounds(44, 0, 153, 52);
		}
		return lblNewLabel;
	}
	private JLabel getLblFirstName() {
		if (lblFirstName == null) {
			lblFirstName = new JLabel("First Name:");
			lblFirstName.setForeground(new Color(230, 230, 250));
			lblFirstName.setBounds(38, 101, 83, 25);
		}
		return lblFirstName;
	}
	private JLabel getLblLastName() {
		if (lblLastName == null) {
			lblLastName = new JLabel("Last Name:");
			lblLastName.setForeground(new Color(250, 235, 215));
			lblLastName.setBounds(38, 137, 83, 25);
		}
		return lblLastName;
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username:");
			lblUsername.setForeground(new Color(250, 235, 215));
			lblUsername.setBounds(38, 173, 83, 25);
		}
		return lblUsername;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setForeground(new Color(250, 235, 215));
			lblPassword.setBounds(38, 208, 69, 25);
		}
		return lblPassword;
	}
	private JLabel getLblRetypePass() {
		if (lblRetypePass == null) {
			lblRetypePass = new JLabel("Retype pass:");
			lblRetypePass.setForeground(new Color(250, 235, 215));
			lblRetypePass.setBounds(38, 244, 83, 25);
		}
		return lblRetypePass;
	}
	private JLabel getLblBirthdate() {
		if (lblBirthdate == null) {
			lblBirthdate = new JLabel("BirthDate:");
			lblBirthdate.setForeground(new Color(250, 235, 215));
			lblBirthdate.setBounds(38, 286, 83, 25);
		}
		return lblBirthdate;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address:");
			lblAddress.setForeground(new Color(250, 235, 215));
			lblAddress.setBounds(38, 325, 69, 25);
		}
		return lblAddress;
	}
	private JTextField getFirstNameTxt() {
		if (firstNameTxt == null) {
			firstNameTxt = new JTextField();
			firstNameTxt.setBounds(133, 103, 188, 25);
			firstNameTxt.setColumns(10);
		}
		return firstNameTxt;
	}
	private JTextField getLastNameTxt() {
		if (lastNameTxt == null) {
			lastNameTxt = new JTextField();
			lastNameTxt.setBounds(131, 139, 190, 25);
			lastNameTxt.setColumns(10);
		}
		return lastNameTxt;
	}
	private JTextField getUsernameTxt() {
		if (usernameTxt == null) {
			usernameTxt = new JTextField();
			usernameTxt.setBounds(131, 173, 190, 25);
			usernameTxt.setColumns(10);
		}
		return usernameTxt;
	}
	private JPasswordField getPasswordTxt() {
		if (passwordTxt == null) {
			passwordTxt = new JPasswordField();
			passwordTxt.setBounds(133, 210, 188, 23);
		}
		return passwordTxt;
	}
	private JPasswordField getRetypePassTxt() {
		if (retypePassTxt == null) {
			retypePassTxt = new JPasswordField();
			retypePassTxt.setBounds(131, 246, 190, 25);
		}
		return retypePassTxt;
	}
	private JTextField getAddressTxt() {
		if (addressTxt == null) {
			addressTxt = new JTextField();
			addressTxt.setBounds(133, 325, 270, 84);
			addressTxt.setColumns(10);
		}
		return addressTxt;
	}
	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setBounds(131, 286, 190, 25);
		}
		return dateChooser;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					LoginForm ob=new LoginForm();
					ob.setVisible(true);
					dispose();
				}
			});
			btnCancel.setBackground(new Color(255, 0, 0));
			btnCancel.setForeground(new Color(250, 235, 215));
			btnCancel.setBounds(95, 439, 89, 25);
		}
		return btnCancel;
	}
	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("Register");
			btnRegister.setBackground(new Color(65, 105, 225));
			btnRegister.setForeground(new Color(250, 235, 215));
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					User u=new User();
					u.setFirstName(firstNameTxt.getText());
					u.setLastName(lastNameTxt.getText());
					u.setUsername(usernameTxt.getText());
					u.setPassword(passwordTxt.getText());
					u.setRetypePass(retypePassTxt.getText());
					u.setBirthDate(new Date(dateChooser.getDate().getTime()));
					u.setAddress(addressTxt.getText());
					
					UserController uc=new UserController(); 
					uc.registerUser(u);
					
					
				}
			});
			btnRegister.setBounds(217, 439, 104, 25);
		}
		return btnRegister;
	}
	private JButton getBtnClickHereTo() {
		if (btnClickHereTo == null) {
			btnClickHereTo = new JButton("Click here to login");
			btnClickHereTo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					LoginForm login=new LoginForm();
					login.setVisible(true);
					dispose();
				}
			});
			btnClickHereTo.setBorder(null);
			btnClickHereTo.setBackground(new Color(75, 0, 130));
			btnClickHereTo.setForeground(new Color(250, 235, 215));
			btnClickHereTo.setBounds(133, 485, 188, 23);
		}
		return btnClickHereTo;
	}
}
