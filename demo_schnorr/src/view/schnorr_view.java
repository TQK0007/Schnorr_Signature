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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

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
import javax.swing.JRadioButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.*;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;


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
	private JTextField txtCKSan;
	
	
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
		setForeground(Color.BLACK);
		setFont(new Font("Times New Roman", Font.PLAIN, 15));
		setTitle("Chữ ký Schnorr");
		
		
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
		panel.setBounds(10, 10, 362, 531);
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
		lblSNguynT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSNguynT.setBackground(Color.WHITE);
		lblSNguynT.setBounds(10, 68, 109, 48);
		panel.add(lblSNguynT);
		
		JLabel lblSNguynT_2 = new JLabel("Số nguyên tố q\r\n");
		lblSNguynT_2.setForeground(Color.BLACK);
		lblSNguynT_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSNguynT_2.setBackground(Color.WHITE);
		lblSNguynT_2.setBounds(10, 126, 109, 48);
		panel.add(lblSNguynT_2);
		
		txtP = new JTextField();
		txtP.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		txtP.setColumns(10);
		txtP.setBounds(192, 84, 160, 32);
		panel.add(txtP);
		
		txtQ = new JTextField();
		txtQ.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		txtQ.setColumns(10);
		txtQ.setBounds(192, 136, 160, 32);
		panel.add(txtQ);
		
		JLabel lblSNguynT_2_1 = new JLabel("Số nguyên  d\r\n\r\n");
		lblSNguynT_2_1.setForeground(Color.BLACK);
		lblSNguynT_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSNguynT_2_1.setBackground(Color.WHITE);
		lblSNguynT_2_1.setBounds(10, 184, 109, 48);
		panel.add(lblSNguynT_2_1);
		
		txtD = new JTextField();
		txtD.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		txtD.setColumns(10);
		txtD.setBounds(192, 194, 160, 32);
		panel.add(txtD);
		
		JLabel lblSNguynT_2_1_1 = new JLabel("e1: e1^p = 1 mod p");
		lblSNguynT_2_1_1.setForeground(Color.BLACK);
		lblSNguynT_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSNguynT_2_1_1.setBackground(Color.WHITE);
		lblSNguynT_2_1_1.setBounds(10, 242, 127, 48);
		panel.add(lblSNguynT_2_1_1);
		
		txtE1 = new JTextField();
		txtE1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		txtE1.setEditable(false);
		txtE1.setColumns(10);
		txtE1.setBounds(192, 252, 160, 32);
		panel.add(txtE1);
		
		JLabel lblSNguynT_2_1_1_1 = new JLabel("e2 = e1^d mod p\r\n");
		lblSNguynT_2_1_1_1.setForeground(Color.BLACK);
		lblSNguynT_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSNguynT_2_1_1_1.setBackground(Color.WHITE);
		lblSNguynT_2_1_1_1.setBounds(10, 300, 109, 48);
		panel.add(lblSNguynT_2_1_1_1);
		
		txtE2 = new JTextField();
		txtE2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		txtE2.setEditable(false);
		txtE2.setColumns(10);
		txtE2.setBounds(192, 310, 160, 32);
		panel.add(txtE2);
		
		JLabel lblPublicKey = new JLabel("Khóa công khai ( e1,e2,p,q )");
		lblPublicKey.setForeground(Color.BLACK);
		lblPublicKey.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPublicKey.setBackground(Color.WHITE);
		lblPublicKey.setBounds(10, 358, 178, 41);
		panel.add(lblPublicKey);
		
		JLabel lblPrivateKey = new JLabel("Khóa bí mật ( d )");
		lblPrivateKey.setForeground(Color.BLACK);
		lblPrivateKey.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPrivateKey.setBackground(Color.WHITE);
		lblPrivateKey.setBounds(10, 409, 127, 41);
		panel.add(lblPrivateKey);
		
		JRadioButton radioButtonTC = new JRadioButton("Tạo thủ công");
		radioButtonTC.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radioButtonTC.setBounds(10, 456, 127, 21);
		panel.add(radioButtonTC);
		
		JRadioButton radioButtonTD = new JRadioButton("Tạo tự động");
		radioButtonTD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radioButtonTD.setBounds(139, 456, 103, 21);
		panel.add(radioButtonTD);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radioButtonTC);
		group.add(radioButtonTD);
		
		txtP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(!radioButtonTC.isSelected())
				{
					JOptionPane.showMessageDialog(null,"Chọn tạo thủ công trước");
					txtP.setEditable(false);
				}
				else
				{
					txtP.setEditable(true);
				}
			}
		});
		
		txtQ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(!radioButtonTC.isSelected())
				{
					JOptionPane.showMessageDialog(null,"Chọn tạo thủ công trước");
					txtQ.setEditable(false);
				}
				else
				{
					txtQ.setEditable(true);
				}
			}
		});
		
		txtD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(!radioButtonTC.isSelected())
				{
					JOptionPane.showMessageDialog(null,"Chọn tạo thủ công trước");
					txtD.setEditable(false);
				}
				else
				{
					txtD.setEditable(true);
				}
			}
		});
		
		txtP.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if(!txtP.getText().isEmpty())
				{
					try
					{
						Long p = Long.parseLong(txtP.getText());
						if(!taoKhoa.soNguyenTo(p))
						{
							JOptionPane.showMessageDialog(null, "P không phải số nguyên tố");
							txtP.setText("");
						}
					}
					catch(NumberFormatException E)
					{
						E.printStackTrace();
					}
				}
				
			}
		});
		
		txtQ.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if(!txtQ.getText().isEmpty())
				{
					try
					{
						Long q = Long.parseLong(txtQ.getText());
						if(!taoKhoa.soNguyenTo(q))
						{
							JOptionPane.showMessageDialog(null, "Q không phải số nguyên tố");
							txtQ.setText("");
						}
					}
					catch(NumberFormatException E)
					{
						E.printStackTrace();
					}
				}
				
			}
		});
		
		
		JButton btnTaoKhoa = new JButton("Tạo khóa ");
		btnTaoKhoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(radioButtonTD.isSelected() && !radioButtonTC.isSelected())
				{
//					group.clearSelection();
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
					JOptionPane.showMessageDialog(null, "Tạo khóa thành công");
				}
				else if(!radioButtonTD.isSelected() && radioButtonTC.isSelected())
				{
					if(txtP.getText().equals("") || txtQ.getText().equals("") || txtD.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Tạo khóa lỗi, nhập hết các trường");
					}
					else
					{
						long e1,e2;
						
						taoKhoa.setP(Long.parseLong(txtP.getText()));
						taoKhoa.setQ(Long.parseLong(txtQ.getText()));
						taoKhoa.setD(Long.parseLong(txtD.getText()));
						e1 = taoKhoa.randomE1();
						e2 = taoKhoa.E2();
						
						txtE1.setText(String.valueOf(e1));
						txtE2.setText(String.valueOf(e2));
						
						JOptionPane.showMessageDialog(null, "Tạo khóa thành công");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Chọn 1 chế độ");
				}
			}
		});
		btnTaoKhoa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnTaoKhoa.setBounds(107, 492, 178, 32);
		panel.add(btnTaoKhoa);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.ORANGE, 2));
		panel_1.setBounds(399, 10, 571, 531);
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
		lblThngipM.setFont(new Font("Times New Roman", Font.PLAIN, 15));
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
				
//				chỉ mở được file txt
				
//				txtAreaM.setText("");
//				
//				JFileChooser fileChooser = new JFileChooser();
//
//				fileChooser.setAcceptAllFileFilterUsed(true);
//				int result = fileChooser.showOpenDialog(null);
//				if(result == JFileChooser.APPROVE_OPTION)
//				{
//					File selectedFile = fileChooser.getSelectedFile();
//					try
//					{
//						BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
//						String line = null;
//						while((line = reader.readLine()) != null)
//						{
//							txtAreaM.append(line+"\n");
//						}
//						reader.close();
//					}
//					catch(IOException E)
//					{
//						E.printStackTrace();
//					}
//				}
				
				txtAreaM.setText("");				
				JFileChooser fileChooser = new JFileChooser();

				fileChooser.setAcceptAllFileFilterUsed(true);
				int result = fileChooser.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION)
				{
					File selectedFile = fileChooser.getSelectedFile();
					if(selectedFile.getName().endsWith(".txt"))
					{
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
					
					else if(selectedFile.getName().endsWith(".docx"))
					{
						try
						{
							FileInputStream fis = new FileInputStream(selectedFile.getAbsolutePath());
						    XWPFDocument document = new XWPFDocument(fis);
						    XWPFWordExtractor extractor = new XWPFWordExtractor(document);
						    txtAreaM.setText(extractor.getText());
						    extractor.close();
						    fis.close();
						}
						catch(IOException E)
						{
							E.printStackTrace();
						}
					}
					
					else if(selectedFile.getName().endsWith(".xlsx"))
					{
						try
						{
							FileInputStream fis = new FileInputStream(selectedFile.getAbsolutePath());
							XSSFWorkbook wb = new XSSFWorkbook(fis);
							XSSFSheet sh = wb.getSheet("Sheet1");
							txtAreaM.setText(sh.getRow(0).getCell(0).toString());
							wb.close();
						}
						catch(IOException E)
						{
							E.printStackTrace();
						}
					}
					
					else
					{
						try
						{
							FileInputStream fis = new FileInputStream(selectedFile.getAbsolutePath());
							PDDocument document = PDDocument.load(fis);
							PDFTextStripper pdfText = new PDFTextStripper();
							
							txtAreaM.setText(pdfText.getText(document));
						}
						catch(IOException E)
						{
							E.printStackTrace();
						}
					}
					
				}
				
			}
		});
		btnChonFIle.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnChonFIle.setBounds(142, 193, 122, 33);
		panel_1.add(btnChonFIle);
		
		JLabel lblSNguynT_2_1_2 = new JLabel("Số nguyên  r\r\n\r\n");
		lblSNguynT_2_1_2.setForeground(Color.BLACK);
		lblSNguynT_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSNguynT_2_1_2.setBackground(Color.WHITE);
		lblSNguynT_2_1_2.setBounds(10, 227, 122, 48);
		panel_1.add(lblSNguynT_2_1_2);
		
		txtR = new JTextField();
		txtR.setColumns(10);
		txtR.setBounds(142, 236, 329, 33);
		panel_1.add(txtR);
		
		JLabel lblSNguynT_2_1_2_1 = new JLabel("Chữ ký s1");
		lblSNguynT_2_1_2_1.setForeground(Color.BLACK);
		lblSNguynT_2_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSNguynT_2_1_2_1.setBackground(Color.WHITE);
		lblSNguynT_2_1_2_1.setBounds(10, 317, 101, 48);
		panel_1.add(lblSNguynT_2_1_2_1);
		
		txtS1 = new JTextField();
		txtS1.setEditable(false);
		txtS1.setColumns(10);
		txtS1.setBounds(142, 326, 329, 33);
		panel_1.add(txtS1);
		
		JLabel lblSNguynT_2_1_2_1_1 = new JLabel("Chữ ký s2");
		lblSNguynT_2_1_2_1_1.setForeground(Color.BLACK);
		lblSNguynT_2_1_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSNguynT_2_1_2_1_1.setBackground(Color.WHITE);
		lblSNguynT_2_1_2_1_1.setBounds(10, 375, 101, 48);
		panel_1.add(lblSNguynT_2_1_2_1_1);
		
		txtS2 = new JTextField();
		txtS2.setEditable(false);
		txtS2.setColumns(10);
		txtS2.setBounds(142, 384, 329, 33);
		panel_1.add(txtS2);
		
		JLabel lblCpChK = new JLabel("Cặp chữ ký ( s1,s2 )");
		lblCpChK.setForeground(Color.BLACK);
		lblCpChK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCpChK.setBackground(Color.WHITE);
		lblCpChK.setBounds(10, 433, 138, 48);
		panel_1.add(lblCpChK);
		
		JRadioButton radioButtonTCR = new JRadioButton("Tạo thủ công");
		radioButtonTCR.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radioButtonTCR.setBounds(142, 283, 127, 21);
		panel_1.add(radioButtonTCR);
		
		JRadioButton radioButtonTDR = new JRadioButton("Tạo tự động");
		radioButtonTDR.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radioButtonTDR.setBounds(271, 284, 103, 21);
		panel_1.add(radioButtonTDR);
		
		ButtonGroup group2 = new ButtonGroup();
		group2.add(radioButtonTDR);
		group2.add(radioButtonTCR);
		
		txtR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(!radioButtonTCR.isSelected())
				{
					JOptionPane.showMessageDialog(null,"Chọn tạo thủ công trước");
					txtR.setEditable(false);
				}
				else
				{
					txtR.setEditable(true);
				}
			}
		});
		
		
		
		JButton btnTSNR = new JButton("Tạo số nguyên r");
		btnTSNR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(radioButtonTDR.isSelected() && !radioButtonTCR.isSelected())
				{
					long r = taoChuKy.randomR();
					txtR.setText(String.valueOf(r));
					JOptionPane.showMessageDialog(null, "Tạo thành công r");
				}
				else if(!radioButtonTDR.isSelected() && radioButtonTCR.isSelected())
				{
					if(txtR.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Vui lòng nhập r");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Tạo thành công r");
					}	
				}
				else
				{
					JOptionPane.showMessageDialog(null, "chọn 1 chế độ");
				}
			}
		});
		
		btnTSNR.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnTSNR.setBounds(85, 482, 180, 41);
		panel_1.add(btnTSNR);
	
			
		JButton btnTaoCK = new JButton("Tạo Chữ Ký");
		btnTaoCK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(radioButtonTDR.isSelected() && !radioButtonTCR.isSelected())
				{
					if(txtR.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Tạo r trước khi tạo chữ ký");
					}
					else
					{
						String m = txtAreaM.getText();
						taoChuKy.setM(m);
						long p,q,d,e1,r;
						p = Long.parseLong(txtP.getText());
						q = Long.parseLong(txtQ.getText());
						d = Long.parseLong(txtD.getText());
						e1 = Long.parseLong(txtE1.getText());
						r = Long.parseLong(txtR.getText());
						taoChuKy.setR(r);
						BigInteger s1, s2;
						
						s1 = taoChuKy.S1(e1, p);
						s2 = taoChuKy.S2(d, q, s1);
						txtS1.setText(s1.toString());
						txtS2.setText(s2.toString());
					}
				}
				else if(!radioButtonTDR.isSelected() && radioButtonTCR.isSelected())
				{
					if(txtR.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Tạo r trước khi tạo chữ ký");
					}
					else
					{
						String m = txtAreaM.getText();
						taoChuKy.setM(m);
						long p,q,d,e1,r;
						p = Long.parseLong(txtP.getText());
						q = Long.parseLong(txtQ.getText());
						d = Long.parseLong(txtD.getText());
						e1 = Long.parseLong(txtE1.getText());
						r = Long.parseLong(txtR.getText());
						taoChuKy.setR(r);
						BigInteger s1, s2;
						
						s1 = taoChuKy.S1(e1, p);
						s2 = taoChuKy.S2(d, q, s1);
						txtS1.setText(s1.toString());
						txtS2.setText(s2.toString());
					}
				}
				
			}
		});
		btnTaoCK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnTaoCK.setBounds(296, 482, 158, 41);
		panel_1.add(btnTaoCK);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 200, 0), 2));
		panel_2.setBounds(10, 551, 960, 224);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblXcMinhCh = new JLabel("Xác Minh Chữ Ký");
		lblXcMinhCh.setBounds(10, 3, 185, 30);
		lblXcMinhCh.setForeground(Color.RED);
		lblXcMinhCh.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblXcMinhCh.setBackground(Color.WHITE);
		panel_2.add(lblXcMinhCh);
		
		JLabel lblSNguynT_2_1_2_1_2 = new JLabel("Chữ Ký Xác Thực V");
		lblSNguynT_2_1_2_1_2.setBounds(10, 43, 138, 39);
		lblSNguynT_2_1_2_1_2.setForeground(Color.BLACK);
		lblSNguynT_2_1_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSNguynT_2_1_2_1_2.setBackground(Color.WHITE);
		panel_2.add(lblSNguynT_2_1_2_1_2);
		
		txtV = new JTextField();
		txtV.setEditable(false);
		txtV.setColumns(10);
		txtV.setBounds(187, 43, 406, 39);
		panel_2.add(txtV);
		
		txtCKSan = new JTextField();
		txtCKSan.setEditable(false);
		txtCKSan.setColumns(10);
		txtCKSan.setBounds(187, 92, 406, 39);
		panel_2.add(txtCKSan);
		
		
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
						txtCKSan.setText(sp.toString());
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
		
		btnChonCK.setBounds(616, 92, 167, 39);
		btnChonCK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
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
		
		btnTaoCKV.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnTaoCKV.setBounds(616, 43, 167, 39);
		panel_2.add(btnTaoCKV);
		
		
		JButton btnXMCK = new JButton("Xác Minh Chữ Ký\r\n\r\n");
		btnXMCK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			

				if(txtV.getText().equals("") && txtCKSan.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Chưa có chữ ký xác minh");
				}
				else
				{
					if(txtV.getText().equals(""))
					{
						if(txtS1.getText().equals(txtCKSan.getText()))
						{
							JOptionPane.showMessageDialog(null,"Chữ ký hợp lệ ");
						}
						
						else
						{
							JOptionPane.showMessageDialog(null, "chữ ký không hợp lệ bản rõ đã bị chỉnh sửa!");
						}
					}
					else
					{
						if(txtS1.getText().equals(txtV.getText()))
						{
							JOptionPane.showMessageDialog(null,"Chữ ký hợp lệ ");
						}
						
						else
						{
							JOptionPane.showMessageDialog(null, "chữ ký không hợp lệ bản rõ đã bị chỉnh sửa!");
						}
					}
				}
			
			}
		});
		
		btnXMCK.setBounds(187, 153, 200, 48);
		btnXMCK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_2.add(btnXMCK);
		
		JLabel lblSNguynT_2_1_2_1_2_1 = new JLabel("Chữ Ký Tạo Sẵn");
		lblSNguynT_2_1_2_1_2_1.setForeground(Color.BLACK);
		lblSNguynT_2_1_2_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSNguynT_2_1_2_1_2_1.setBackground(Color.WHITE);
		lblSNguynT_2_1_2_1_2_1.setBounds(10, 92, 138, 39);
		panel_2.add(lblSNguynT_2_1_2_1_2_1);
		
		
		
		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txtP.setText("");
				txtQ.setText("");
				txtD.setText("");
				txtE1.setText("");
				txtE2.setText("");
				txtR.setText("");
				txtAreaM.setText("");
				txtS1.setText("");
				txtS2.setText("");
				txtV.setText("");
				txtCKSan.setText("");
				group.clearSelection();
				group2.clearSelection();
			}
		});
		btnLamMoi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnLamMoi.setBounds(393, 153, 200, 48);
		panel_2.add(btnLamMoi);
		
	}
}
