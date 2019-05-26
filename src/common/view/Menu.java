package common.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import common.model.Score;
import tictactoe.controller.TicTacToeController;
import tictactoe.model.TicTacToe;
import tictactoe.view.TicTacToeView;

public class Menu extends JFrame implements ActionListener, MouseListener {
	private static final long serialVersionUID = 7569627007177996281L;

	private JButton StartButton;
	private JButton eraseButton;

	private JPanel contentPane;
	private JPanel gamesPane;
	
	private JPanel scorePane;
	private JLabel scorePlayer1;
	private JLabel scorePlayer2;

	public Menu() {

		loadPanel();
		
		setBounds(0, 0, 400, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("TIC-TAC-TOE");
		setName("By Urmat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(this);
		setVisible(true);
	}
	
	public void loadPanel() {

		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		gamesPane = new JPanel();
		gamesPane.setBounds(50, 50, 300, 200);
		gamesPane.setLayout(null);
		contentPane.add(gamesPane);



		StartButton = new JButton("Start Game");
		StartButton.addActionListener(this);
		StartButton.addMouseListener(this);
		StartButton.setBounds(50, 50, 200, 40);
		gamesPane.add(StartButton);
		

		
		scorePane = new JPanel();
		scorePane.setBounds(50, 300, 300, 50);
		scorePane.setLayout(new GridLayout(1,1));
		contentPane.add(scorePane);
		
		scorePlayer1 = new JLabel();
		scorePlayer1.setForeground(Color.red);
		scorePane.add(scorePlayer1);
		
		eraseButton = new JButton("Zero");
		eraseButton.addActionListener(this);
		eraseButton.addMouseListener(this);
		scorePane.add(eraseButton);
		
		scorePlayer2 = new JLabel();
		scorePlayer2.setForeground(Color.blue);
		scorePlayer2.setHorizontalAlignment(JLabel.RIGHT);
		scorePane.add(scorePlayer2);
		
		updateScore();
	}
	
	private void updateScore() {
		Score score = Score.deserializeScore();
		scorePlayer1.setText("Player 1 : "+score.getScorePlayer1());
		scorePlayer2.setText("Player 2 : "+score.getScorePlayer2());
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.StartButton)
		{
			TicTacToe modele = new TicTacToe(3, 3);
			TicTacToeView vue = new TicTacToeView(modele);
			new TicTacToeController(modele, vue);
		}

		else if(e.getSource() == this.eraseButton)
		{
			Score.eraseScore();
			updateScore();
		}
	}
	
	
	public void mouseReleased(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {
		if(e.getSource() instanceof JButton)
			((JButton)e.getSource()).setFont(new Font("Lucida",Font.PLAIN,13));
	}
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == this)
			updateScore();
		if(e.getSource() instanceof JButton)
			((JButton)e.getSource()).setFont(new Font("Lucida",Font.BOLD,18));
		}
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()== this)
		updateScore();
	}
}