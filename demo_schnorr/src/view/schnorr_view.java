package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

import model.ktChuKy;
import model.taoChuKy;
import model.taoKhoa;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class schnorr_view extends JFrame {

	private JPanel contentPane;
	private JTextField txtQ;
	private JTextField txtD;
	private JTextField txtE1;
	private JTextField txtE2;
	private JTextField txtP;
	private JTextField txtR;
	private JTextField txtS1;
	private JTextField txtS2;
	private JTextField txtV;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					schnorr_view frame = new schnorr_view();
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
	public schnorr_view() {
		
		
		taoKhoa taoKhoa = new taoKhoa();
		taoChuKy taoChuKy = new taoChuKy();
		ktChuKy kt = new ktChuKy();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 994, 812);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.ORANGE, 2));
		panel.setBounds(10, 10, 362, 604);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tạo Khóa\r\n");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(10, 10, 109, 64);
		panel.add(lblNewLabel);
		
		JLabel lblSNguynT = new JLabel("Số nguyên tố p");
		lblSNguynT.setForeground(Color.BLACK);
		lblSNguynT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSNguynT.setBackground(Color.WHITE);
		lblSNguynT.setBounds(10, 84, 127, 48);
		panel.add(lblSNguynT);
		
		JLabel lblSNguynT_2 = new JLabel("Số nguyên tố q\r\n");
		lblSNguynT_2.setForeground(Color.BLACK);
		lblSNguynT_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSNguynT_2.setBackground(Color.WHITE);
		lblSNguynT_2.setBounds(10, 156, 127, 48);
		panel.add(lblSNguynT_2);
		
		txtQ = new JTextField();
		txtQ.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				long q = Long.parseLong(txtQ.getText());
				if(!taoKhoa.soNguyenTo(q))
				{
					JOptionPane.showMessageDialog(null, "Q không phải số nguyên tố");
				}
				
			}
		});
		txtQ.setColumns(10);
		txtQ.setBounds(192, 159, 160, 48);
		panel.add(txtQ);
		
		JLabel lblSNguynT_2_1 = new JLabel("Số nguyên  d\r\n\r\n");
		lblSNguynT_2_1.setForeground(Color.BLACK);
		lblSNguynT_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSNguynT_2_1.setBackground(Color.WHITE);
		lblSNguynT_2_1.setBounds(10, 228, 127, 48);
		panel.add(lblSNguynT_2_1);
		
		txtD = new JTextField();
		txtD.setColumns(10);
		txtD.setBounds(192, 231, 160, 48);
		panel.add(txtD);
		
		JLabel lblSNguynT_2_1_1 = new JLabel("e1: e1^p = 1 mod p");
		lblSNguynT_2_1_1.setForeground(Color.BLACK);
		lblSNguynT_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSNguynT_2_1_1.setBackground(Color.WHITE);
		lblSNguynT_2_1_1.setBounds(10, 300, 160, 48);
		panel.add(lblSNguynT_2_1_1);
		
		txtE1 = new JTextField();
		txtE1.setColumns(10);
		txtE1.setBounds(192, 303, 160, 48);
		panel.add(txtE1);
		
		JLabel lblSNguynT_2_1_1_1 = new JLabel("e2 = e1^d mod p\r\n");
		lblSNguynT_2_1_1_1.setForeground(Color.BLACK);
		lblSNguynT_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSNguynT_2_1_1_1.setBackground(Color.WHITE);
		lblSNguynT_2_1_1_1.setBounds(10, 386, 148, 48);
		panel.add(lblSNguynT_2_1_1_1);
		
		txtE2 = new JTextField();
		txtE2.setColumns(10);
		txtE2.setBounds(192, 386, 160, 48);
		panel.add(txtE2);
		
		JLabel lblPublicKey = new JLabel("Khóa công khai ( e1,e2,p,q )");
		lblPublicKey.setForeground(Color.BLACK);
		lblPublicKey.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPublicKey.setBackground(Color.WHITE);
		lblPublicKey.setBounds(10, 447, 239, 41);
		panel.add(lblPublicKey);
		
		JLabel lblPrivateKey = new JLabel("Khóa bí mật ( d )");
		lblPrivateKey.setForeground(Color.BLACK);
		lblPrivateKey.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPrivateKey.setBackground(Color.WHITE);
		lblPrivateKey.setBounds(10, 498, 160, 41);
		panel.add(lblPrivateKey);
		
		JButton btnTaoKhoa = new JButton("Tạo khóa tự động");
		btnTaoKhoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				long p,q,d,e1,e2;
				p = taoKhoa.randomP();
				q = taoKhoa.randomQ();
				d = taoKhoa.randomD();
				e1 = taoKhoa.randomE1();
				e2 = taoKhoa.E2();
				
				txtP.setText(String.valueOf(p));
				txtQ.setText(String.valueOf(q));
				txtD.setText(String.valueOf(d));
				txtE1.setText(String.valueOf(e1));
				txtE2.setText(String.valueOf(e2));
				
			}
		});
		btnTaoKhoa.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnTaoKhoa.setBounds(77, 549, 209, 48);
		panel.add(btnTaoKhoa);
		
		txtP = new JTextField();
		txtP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				long p = Long.parseLong(txtP.getText());
				if(!taoKhoa.soNguyenTo(p))
				{
					JOptionPane.showMessageDialog(null, "P không phải số nguyên tố");
				}
			
			}
		});
		txtP.setColumns(10);
		txtP.setBounds(192, 84, 160, 48);
		panel.add(txtP);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.ORANGE, 2));
		panel_1.setBounds(399, 10, 571, 604);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel lblToChK = new JLabel("Tạo Chữ Ký");
		lblToChK.setForeground(Color.RED);
		lblToChK.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblToChK.setBackground(Color.WHITE);
		lblToChK.setBounds(10, 10, 158, 64);
		panel_1.add(lblToChK);
		
		JLabel lblThngipM = new JLabel("Thông điệp m");
		lblThngipM.setForeground(Color.BLACK);
		lblThngipM.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblThngipM.setBackground(Color.WHITE);
		lblThngipM.setBounds(10, 84, 122, 48);
		panel_1.add(lblThngipM);
		
		JTextArea txtAreaM = new JTextArea();
		txtAreaM.setBounds(142, 98, 329, 85);
		panel_1.add(txtAreaM);
		
		JScrollPane scrollPane = new JScrollPane(txtAreaM);
		scrollPane.setBounds(142, 98, 329, 85);
		panel_1.add(scrollPane);
		 
		
		
		JButton btnChonFIle = new JButton("Chọn File\r\n");
		btnChonFIle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION)
				{
					File selectedFile = fileChooser.getSelectedFile();
					try
					{
						BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
						String line = null;
						while((line = reader.readLine()) != null)
						{
							txtAreaM.append(line+"\n");
						}
						reader.close();
					}
					catch(IOException E)
					{
						E.printStackTrace();
					}
				}
				
			}
		});
		btnChonFIle.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnChonFIle.setBounds(142, 193, 122, 33);
		panel_1.add(btnChonFIle);
		
		JLabel lblSNguynT_2_1_2 = new JLabel("Số nguyên  r\r\n\r\n");
		lblSNguynT_2_1_2.setForeground(Color.BLACK);
		lblSNguynT_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSNguynT_2_1_2.setBackground(Color.WHITE);
		lblSNguynT_2_1_2.setBounds(10, 250, 122, 48);
		panel_1.add(lblSNguynT_2_1_2);
		
		txtR = new JTextField();
		txtR.setColumns(10);
		txtR.setBounds(142, 253, 329, 48);
		panel_1.add(txtR);
		
		JLabel lblSNguynT_2_1_2_1 = new JLabel("Chữ ký s1");
		lblSNguynT_2_1_2_1.setForeground(Color.BLACK);
		lblSNguynT_2_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSNguynT_2_1_2_1.setBackground(Color.WHITE);
		lblSNguynT_2_1_2_1.setBounds(10, 330, 101, 48);
		panel_1.add(lblSNguynT_2_1_2_1);
		
		txtS1 = new JTextField();
		txtS1.setColumns(10);
		txtS1.setBounds(142, 330, 329, 48);
		panel_1.add(txtS1);
		
		JLabel lblSNguynT_2_1_2_1_1 = new JLabel("Chữ ký s2");
		lblSNguynT_2_1_2_1_1.setForeground(Color.BLACK);
		lblSNguynT_2_1_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSNguynT_2_1_2_1_1.setBackground(Color.WHITE);
		lblSNguynT_2_1_2_1_1.setBounds(10, 406, 101, 48);
		panel_1.add(lblSNguynT_2_1_2_1_1);
		
		txtS2 = new JTextField();
		txtS2.setColumns(10);
		txtS2.setBounds(142, 406, 329, 48);
		panel_1.add(txtS2);
		
		JLabel lblCpChK = new JLabel("Cặp chữ ký ( s1,s2 )");
		lblCpChK.setForeground(Color.BLACK);
		lblCpChK.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCpChK.setBackground(Color.WHITE);
		lblCpChK.setBounds(10, 464, 202, 48);
		panel_1.add(lblCpChK);
	
			
		JButton btnTaoCK = new JButton("Tạo Chữ Ký");
		btnTaoCK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String m = txtAreaM.getText();
				taoChuKy.setM(m);
				
				long p,q,d,e1,r;
				p = Long.parseLong(txtP.getText());
				q = Long.parseLong(txtQ.getText());
				d = Long.parseLong(txtD.getText());
				e1 = Long.parseLong(txtE1.getText());
				r = taoChuKy.randomR();
				BigInteger s1, s2;
				
				s1 = taoChuKy.S1(e1, p);
				s2 = taoChuKy.S2(d, q, s1);
				
				txtR.setText(String.valueOf(r));
				txtS1.setText(s1.toString());
				txtS2.setText(s2.toString());
				
			}
		});
		btnTaoCK.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnTaoCK.setBounds(189, 522, 199, 41);
		panel_1.add(btnTaoCK);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.ORANGE, 2));
		panel_2.setBounds(10, 624, 960, 174);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblXcMinhCh = new JLabel("Xác Minh Chữ Ký");
		lblXcMinhCh.setBounds(10, 3, 185, 30);
		lblXcMinhCh.setForeground(Color.RED);
		lblXcMinhCh.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblXcMinhCh.setBackground(Color.WHITE);
		panel_2.add(lblXcMinhCh);
		
		JLabel lblSNguynT_2_1_2_1_2 = new JLabel("Chữ Ký Xác Thực V");
		lblSNguynT_2_1_2_1_2.setBounds(10, 43, 167, 24);
		lblSNguynT_2_1_2_1_2.setForeground(Color.BLACK);
		lblSNguynT_2_1_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSNguynT_2_1_2_1_2.setBackground(Color.WHITE);
		panel_2.add(lblSNguynT_2_1_2_1_2);
		
		txtV = new JTextField();
		txtV.setColumns(10);
		txtV.setBounds(187, 43, 406, 48);
		panel_2.add(txtV);
		
		
		JButton btnChonCK = new JButton("Chọn Chữ Ký\r\n\r\n");
		btnChonCK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION)
				{
					File selectedFile = fileChooser.getSelectedFile();
					StringBuilder sp = new StringBuilder();
					try
					{
						BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
						String line = null;
						while((line = reader.readLine()) != null)
						{
							sp.append(line);
						}
						txtV.setText(sp.toString());
						reader.close();
					}
					catch(IOException E)
					{
						E.printStackTrace();
						JOptionPane.showMessageDialog(null, "Lấy chữ ký không thành công");
					}
				}
				
			}
		});
		
		btnChonCK.setBounds(416, 101, 167, 33);
		btnChonCK.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_2.add(btnChonCK);
		

		JButton btnTaoCKV = new JButton("Tao Chữ Ký V");
		btnTaoCKV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String m = txtAreaM.getText();
				taoChuKy.setM(m);
				
				long p,q,d,e1,e2,r;
				p = Long.parseLong(txtP.getText());
				q = Long.parseLong(txtQ.getText());
				d = Long.parseLong(txtD.getText());
				e1 = Long.parseLong(txtE1.getText());
				e2 = Long.parseLong(txtE2.getText());
				r = taoChuKy.randomR();
				BigInteger s1, s2, v;
				
				s1 = taoChuKy.S1(e1, p);
				s2 = taoChuKy.S2(d, q, s1);
				
				v = kt.V(m, e1, e2, s1, s2, p);
				txtV.setText(v.toString());
				
				
			}
		});
		
		btnTaoCKV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnTaoCKV.setBounds(187, 98, 167, 33);
		panel_2.add(btnTaoCKV);
		
		
		JButton btnXMCK = new JButton("Xác Minh Chữ Ký\r\n\r\n");
		btnXMCK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				if(txtS1.getText().equals(txtV.getText()))
				{
					JOptionPane.showMessageDialog(txtV,"Chữ ký hợp lệ ");
				}
				
				else
				{
					JOptionPane.showMessageDialog(txtV, "chữ ký không hợp lệ bản rõ đã bị chỉnh sửa!");
				}
			}
		});
		
		btnXMCK.setBounds(635, 40, 200, 48);
		btnXMCK.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_2.add(btnXMCK);
		
		
		
		
	}
}
