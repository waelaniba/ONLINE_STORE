package edu.esprit.onlinestore.client.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import edu.esprit.onlinestore.domain.Product;
import edu.esprit.onlinestore.services.CartServiceRemote;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField txtDesignation;
	private JTextField txtPrice;
	private CartServiceRemote cartServiceRemote;
	private JTextField txtCurrency;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		
		try {
			
			Context ctx = new InitialContext();
			cartServiceRemote = (CartServiceRemote) ctx.
					lookup("/OnlineStore/CartService!edu.esprit.onlinestore.services.CartServiceRemote");
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDesignation = new JLabel("DESIGNATION");
		lblDesignation.setBounds(37, 38, 78, 14);
		contentPane.add(lblDesignation);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setBounds(69, 61, 46, 14);
		contentPane.add(lblPrice);
		
		txtDesignation = new JTextField();
		txtDesignation.setBounds(139, 35, 150, 20);
		contentPane.add(txtDesignation);
		txtDesignation.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(139, 58, 150, 20);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		JButton btnAddToCart = new JButton("ADD TO CART");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Product p = new Product(txtDesignation.getText(), Float.parseFloat(txtPrice.getText()));
				cartServiceRemote.addToCart(p);
				txtDesignation.setText(new String());
				txtPrice.setText(new String());
			}
		});
		btnAddToCart.setBounds(139, 89, 150, 23);
		contentPane.add(btnAddToCart);
		
		JButton btnClear = new JButton("CLEAR CART");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cartServiceRemote.cleanCart();
				txtDesignation.setText(new String());
				txtPrice.setText(new String());
			}
		});
		btnClear.setBounds(139, 121, 150, 23);
		contentPane.add(btnClear);
		
		JButton btnValidate = new JButton("VALIDATE CART");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cartServiceRemote.validateCartWithForeignCurrency(txtCurrency.getText());
				txtDesignation.setText(new String());
				txtPrice.setText(new String());
			}
		});
		btnValidate.setBounds(139, 155, 104, 28);
		contentPane.add(btnValidate);
		
		txtCurrency = new JTextField();
		txtCurrency.setText("TND");
		txtCurrency.setBounds(249, 155, 40, 28);
		contentPane.add(txtCurrency);
		txtCurrency.setColumns(10);
	}
}
