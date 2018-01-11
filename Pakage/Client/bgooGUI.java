package Client;
//
//bgooGUI
//作者：陶冶
//功能：界面实现和invoke接口
//
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class bgooGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	static JFrame myframe = new JFrame("BGoo");// 主界面
	static JFrame frame1 = new JFrame("查询单词");// 查询单词界面
	static JFrame frame11 = new JFrame("英英词典");// 查询单词界面
	static JFrame frame12 = new JFrame("英汉词典");// 查询单词界面
	static JFrame frame2 = new JFrame("记忆单词");
	static JFrame frame3 = new JFrame("翻译文本");// 翻译文本界面
	static JFrame frame5 = new JFrame("美文共赏");
	static JFrame jiyif1 = new JFrame("记忆单词");
	static JFrame jiyif2 = new JFrame("记忆单词");
	static JFrame jiyif3 = new JFrame("记忆单词");
	static JFrame jiyif4 = new JFrame("记忆单词");
	static JFrame jiyif5= new JFrame("记忆单词");
	static JFrame frame4 = new JFrame("测试单词");
	static JFrame hyf = new JFrame("汉-英");
	static JFrame yhf = new JFrame("英-汉");
	static JFrame meiwenf1 = new JFrame("美文共赏");
	static JFrame meiwenf2 = new JFrame("美文共赏");
	static JFrame meiwenf3 = new JFrame("美文共赏");
	static JFrame meiwenf4 = new JFrame("美文共赏");
	static JFrame meiwenf5 = new JFrame("美文共赏");
	static JFrame meiwenf6 = new JFrame("美文共赏");
	static JFrame frame6 = new JFrame("听力训练");
	static JFrame listen = new JFrame("听力");

	static JTextArea ta1 = new JTextArea();
	static JLabel title = new JLabel();
	static String yuanwen1 = null;
	public static int k = 0;
	public static int formal = 0;
	final static bgooGUI myTest = new bgooGUI();

	// 服务器功能调用invoke
	public String invoke(String words, String type) {
		String result = "";
		String result1 = "";
		String result2 = "";
		XmlRpcClient client = new XmlRpcClient();
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		try {
			config.setServerURL(new URL("http://127.0.0.1:10080"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		client.setConfig(config);
		try {
			if (type.trim().equals("entozh")) {
				// 英转中的具体实现模块，其中包括对unicode字段的处理
				result = (String) client.execute("transHandler.trans",
						new Object[] { words, "en", "zh" });
				System.out.println(result);
				StringBuilder buf = new StringBuilder();
				String[] cc = result.split("\\\\u");
				for (String c : cc) {
					if (c.equals(""))
						continue;
					int cInt = Integer.parseInt(c, 16);
					char cChar = (char) cInt;
					buf.append(cChar);
				}
				result2 = buf.toString();
			}
			if (type.trim().equals("zhtoen")) {
				// 中转英，很简单
				result2 = (String) client.execute("transHandler.trans",
						new Object[] { words, "zh", "en" });
			}
			if (type.trim().equals("entoen")) {
				// 英转英，很简单
				result2 = (String) client.execute("HiWord.Geten",
						new Object[] { words });
			}
			if (type.trim().equals("getzh")) {
				// 英转英，很简单
				result2 = (String) client.execute("SQLHandler.Getzh",
						new Object[] { words });
			}
			if (type.trim().equals("getranden")) {
				// 英转英，很简单
				result2 = (String) client.execute("SQLHandler.Getranden",
						new Object[] {});
			}
			if (type.trim().equals("article1_en")) {
				// 显示美文原文1
				result2 = (String) client.execute("GetTextHandler.readFile",
						new Object[] { "Source/Art1en.txt" });
			}
			if (type.trim().equals("article1_zh")) {
				// 显示中文译文1
				result2 = (String) client.execute("GetTextHandler.readFile",
						new Object[] { "Source/Art1zh.txt" });
			}
			if (type.trim().equals("article2_en")) {
				// 显示美文原文2
				result2 = (String) client.execute("GetTextHandler.readFile",
						new Object[] { "Source/Art2en.txt" });
			}
			if (type.trim().equals("article2_zh")) {
				// 显示中文译文2
				result2 = (String) client.execute("GetTextHandler.readFile",
						new Object[] { "Source/Art2zh.txt" });
			}
			if (type.trim().equals("article3_en")) {
				// 显示美文原文3
				result2 = (String) client.execute("GetTextHandler.readFile",
						new Object[] { "Source/Art3en.txt" });
			}
			if (type.trim().equals("article3_zh")) {
				// 显示中文译文3
				result2 = (String) client.execute("GetTextHandler.readFile",
						new Object[] { "Source/Art3zh.txt" });
			}
			if (type.trim().equals("article4_en")) {
				// 显示美文原文4
				result2 = (String) client.execute("GetTextHandler.readFile",
						new Object[] { "Source/Art4en.txt" });
			}
			if (type.trim().equals("article4_zh")) {
				// 显示中文译文4
				result2 = (String) client.execute("GetTextHandler.readFile",
						new Object[] { "Source/Art4zh.txt" });
			}
			if (type.trim().equals("article5_en")) {
				// 显示美文原文5
				result2 = (String) client.execute("GetTextHandler.readFile",
						new Object[] { "Source/Art5en.txt" });
			}
			if (type.trim().equals("article5_zh")) {
				// 显示中文译文5
				result2 = (String) client.execute("GetTextHandler.readFile",
						new Object[] { "Source/Art5zh.txt" });
			}
			if (type.trim().equals("article6_en")) {
				// 显示美文原文6
				result2 = (String) client.execute("GetTextHandler.readFile",
						new Object[] { "Source/Art6en.txt" });
			}
			if (type.trim().equals("article6_zh")) {
				// 显示中文译文6
				result2 = (String) client.execute("GetTextHandler.readFile",
						new Object[] { "Source/Art6zh.txt" });
			}
			if (type.trim().equals("null")) {
				// 隐藏中文译文
				result2 = (String) client.execute("GetTextHandler.readFile",
						new Object[] { "Source//null.txt" });
			}

			if (type.trim().equals("getchi")) {
				// TODO 随机get一个中文2
				Random random2 = new Random();
				int i2 = random2.nextInt(1000);
				result2 = (String) client.execute("GetWordHandler.GetChi",
						new Object[] { "Source/四级单词.txt", i2 });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result1);
		return result2;
	}

	// 与随机数相关的invoke
	public String invoke1(String fr, String type, int m) {
		String result2 = null;
		XmlRpcClient client = new XmlRpcClient();
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		try {
			config.setServerURL(new URL("http://127.0.0.1:10080"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		client.setConfig(config);
		try {
			if (type.trim().equals("geteng")) {
				// TODO 随机get一个英文
				result2 = (String) client.execute("GetWordHandler.GetEng",
						new Object[] { "Source/四级单词.txt", m });
			}
			if (type.trim().equals("getchi1")) {
				// TODO 匹配该英文的中文含义

				result2 = (String) client.execute("GetWordHandler.GetChi1",
						new Object[] { "Source/四级单词.txt", m });
			}

			if (type.trim().equals("recite"))
				result2 = (String) client.execute("recitewordHandler.Recite",
						new Object[] { "Source/四级单词.txt", m });
			if (type.trim().equals("word"))
				result2 = (String) client.execute("meanHandler.Mean",
						new Object[] { "Source/四级单词.txt", m });

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result2;
	}

	// 与音频调度相关的invoke
	public String invoke2(String type, String fr) {
		// ArrayList result = new ArrayList();
		String result = null;
		XmlRpcClient client = new XmlRpcClient();// 创建客户端，标识服务器
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		try {
			config.setServerURL(new URL("http://127.0.0.1:10080"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		client.setConfig(config);
		try {

			if (type.trim().equals("ly"))

				result = (String) client.execute("SouContent.Lyrics",
						new Object[] { fr });

		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println("Server's Response: " + result);//输出结果
		return result;
	}

	// 与数据库有关的invoke
	public String invoke3(String type, int k) {

		String result = "";
		XmlRpcClient client = new XmlRpcClient();
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		try {
			config.setServerURL(new URL("http://127.0.0.1:10080"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		client.setConfig(config);
		try {

			if (type.trim().equals("getranden")) {
				// 英转英，很简单
				result = (String) client.execute("SQLHandler.Getranden",
						new Object[] { k });
			}
			if (type.trim().equals("getrandzh")) {
				// 英转英，很简单
				result = (String) client.execute("SQLHandler.Getrandzh",
						new Object[] { k });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 调度pisoff
	public String invoke4(String word) {

		String result = "";
		XmlRpcClient client = new XmlRpcClient();
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		try {
			config.setServerURL(new URL("http://127.0.0.1:10080"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		client.setConfig(config);
		try {
			result = (String) client.execute("SQLHandler.pisoff",
					new Object[] { word });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 调度getthemall
	public String invoke5() {

		String result = "";
		XmlRpcClient client = new XmlRpcClient();
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		try {
			config.setServerURL(new URL("http://127.0.0.1:10080"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		client.setConfig(config);
		try {
			result = (String) client.execute("SQLHandler.Getthemall",
					new Object[] {});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 与音频调度相关的invoke3
	public String invoke6(String type, int index) {
		String result = null;
		XmlRpcClient client = new XmlRpcClient();// 创建客户端，标识服务器
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		try {
			config.setServerURL(new URL("http://127.0.0.1:10080"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		client.setConfig(config);
		try {

			if (type.trim().equals("start"))
				result = (String) client
						.execute("Soun.start1", new Object[] {});
			else if (type.trim().equals("pause"))
				result = (String) client
						.execute("Soun.pause1", new Object[] {});
			else if (type.trim().equals("prev"))
				result = (String) client.execute("Soun.prev1", new Object[] {});
			else if (type.trim().equals("next"))
				result = (String) client.execute("Soun.next1", new Object[] {});
			else if (type.trim().equals("stop"))
				result = (String) client.execute("Soun.stop1", new Object[] {});
			else if (type.trim().equals("chushihua"))
				result = (String) client.execute("Soun.chushihua",
						new Object[] {});
			else if (type.trim().equals("xu"))
				result = (String) client.execute("Soun.choness1",
						new Object[] { index });
			else if (type.trim().equals("chu"))
				result = (String) client.execute("Soun.chushihua",
						new Object[] {});
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println("Server's Response: " + result);//输出结果
		return "Server's Response: " + result;
	}

	public static void main(String[] args) throws IOException {

		// 下面是背景板的调色
		myframe.getContentPane().setBackground(new Color(220, 232, 235));
		frame11.getContentPane().setBackground(new Color(220, 232, 235));
		frame12.getContentPane().setBackground(new Color(220, 232, 235));
		frame2.getContentPane().setBackground(new Color(220, 232, 235));
		frame3.getContentPane().setBackground(new Color(220, 232, 235));
		frame5.getContentPane().setBackground(new Color(220, 232, 235));
		jiyif1.getContentPane().setBackground(new Color(220, 232, 235));
		jiyif2.getContentPane().setBackground(new Color(220, 232, 235));
		jiyif3.getContentPane().setBackground(new Color(220, 232, 235));
		jiyif4.getContentPane().setBackground(new Color(220, 232, 235));
		jiyif5.getContentPane().setBackground(new Color(220, 232, 235));
		frame4.getContentPane().setBackground(new Color(220, 232, 235));
		hyf.getContentPane().setBackground(new Color(220, 232, 235));
		yhf.getContentPane().setBackground(new Color(220, 232, 235));
		meiwenf1.getContentPane().setBackground(new Color(220, 232, 235));
		meiwenf2.getContentPane().setBackground(new Color(220, 232, 235));
		meiwenf3.getContentPane().setBackground(new Color(220, 232, 235));
		meiwenf4.getContentPane().setBackground(new Color(220, 232, 235));
		meiwenf5.getContentPane().setBackground(new Color(220, 232, 235));
		meiwenf6.getContentPane().setBackground(new Color(220, 232, 235));
		frame6.getContentPane().setBackground(new Color(220, 232, 235));
		listen.getContentPane().setBackground(new Color(220, 232, 235));
		// 以下为界面风格选取
		try {
			// UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
			// 椭圆按钮+黄色按钮背景
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
			// 水滴状风格
			// UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
			// 木质感+xp风格
			// UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel ");
			// 椭圆按钮+翠绿色按钮背景+金属质感
			// UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");

		} catch (Exception e) {
		}

		GridLayout gl = new GridLayout(3, 2, 20, 40);

		JButton button1 = new JButton("查询单词");
		JButton button2 = new JButton("记忆单词");
		JButton button3 = new JButton("翻译文本");
		JButton button4 = new JButton("测试单词");
		JButton button5 = new JButton("美文共赏");
		JButton button6 = new JButton("听力训练");
		JPanel panel = new JPanel();
		Font f = new Font("宋体", Font.ROMAN_BASELINE, 15);// 根据指定字体名称、样式和磅值大小，创建一个新
		// Font。
		button1.setFont(f);
		button1.setForeground(Color.black);
		button2.setFont(f);
		button2.setForeground(Color.black);
		button3.setFont(f);
		button3.setForeground(Color.black);
		button4.setFont(f);
		button4.setForeground(Color.black);
		button5.setFont(f);
		button5.setForeground(Color.black);
		button6.setFont(f);
		button6.setForeground(Color.black);
		panel.setLayout(gl);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);

		// 单词查询按钮
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myframe.setVisible(false);
				JPanel panel1 = new JPanel();
				panel1.setLayout(null);

				JButton entoen = new JButton("英汉词典");
				JButton entozh = new JButton("英英词典");

				entoen.setBounds(40, 40, 200, 50);
				entozh.setBounds(40, 105, 200, 50);
				Font f = new Font("宋体", Font.ROMAN_BASELINE, 15);// 根据指定字体名称、样式和磅值大小，创建一个新
				// Font。

				entoen.setFont(f);
				entoen.setForeground(Color.black);
				entozh.setFont(f);
				entozh.setForeground(Color.black);

				panel1.add(entoen);
				panel1.add(entozh);
				frame1.add(panel1);
				frame1.setSize(300, 230);
				frame1.setLocationRelativeTo(null);
				frame11.getContentPane()
						.setBackground(new Color(197, 216, 222));
				frame1.setVisible(true);
				entozh.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame1.setVisible(false);
						JPanel panel1 = new JPanel();
						// BorderLayout l = new BorderLayout(10,10);
						panel1.setLayout(null);
						ImageIcon i1 = new ImageIcon("sousuo.jpg");
						JLabel label1 = new JLabel(i1);
						JButton search1 = new JButton("查询");
						JButton button = new JButton("返回主界面");
						final JTextArea result = new JTextArea(" ");
						final JTextField inputbox = new JTextField(20);
						label1.setBounds(20, 20, 20, 20);
						search1.setBounds(280, 20, 70, 20);
						JScrollPane sp1 = new JScrollPane(result);
						sp1.setBounds(20, 50, 480, 580);
						sp1.setBorder(BorderFactory
								.createLineBorder(new Color(220, 232, 235)));
						inputbox.setBorder(BorderFactory
								.createLineBorder(new Color(220, 232, 235)));
						button.setBounds(360, 20, 140, 20);
						inputbox.setBounds(20, 20, 250, 20);

						result.setLineWrap(true);
						Font f = new Font("微软雅黑", Font.ROMAN_BASELINE, 15);// 根据指定字体名称、样式和磅值大小，创建一个新
						// Font。
						search1.setFont(f);
						// search1.setForeground(new Color(2,176,229));
						button.setFont(f);
						button.setForeground(Color.black);
						inputbox.setBackground(Color.white);
						result.setBackground(Color.white);
						frame11.getContentPane().setBackground(
								new Color(220, 232, 235));
						panel1.add(inputbox);
						panel1.add(search1);
						panel1.add(sp1);
						panel1.add(button);
						panel1.add(label1);
						frame11.add(panel1);
						frame11.setSize(540, 680);
						frame11.setLocationRelativeTo(null);

						frame11.setVisible(true);
						// result.setLineWrap(true);
						// �� ��ѯ���õķ���������
						search1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String words = inputbox.getText();
								if (!words.equals("")) {
									String result1 = myTest.invoke(words,
											"entoen");
									result.setText(result1);
								}
							}
						});

						// �ڲ�ѯ���ʽ����ϰ������������桱��ť�����¼�
						button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								myframe.setVisible(true);
								frame11.dispose();

							}
						});
					}
				});
				entoen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame1.setVisible(false);
						JPanel panel1 = new JPanel();
						// BorderLayout l = new BorderLayout(10,10);
						panel1.setLayout(null);
						ImageIcon i1 = new ImageIcon("sousuo.jpg");
						JLabel label1 = new JLabel(i1);
						JButton search1 = new JButton("查询");
						JButton button = new JButton("返回主界面");
						final JTextArea result = new JTextArea(" ");
						final JTextField inputbox = new JTextField(20);
						label1.setBounds(20, 20, 20, 20);
						search1.setBounds(280, 20, 70, 20);
						JScrollPane sp1 = new JScrollPane(result);
						sp1.setBounds(20, 50, 480, 180);
						button.setBounds(360, 20, 140, 20);
						inputbox.setBounds(20, 20, 250, 20);
						Font f = new Font("宋体", Font.ROMAN_BASELINE, 15);// 根据指定字体名称、样式和磅值大小，创建一个新
						// Font。
						search1.setFont(f);
						search1.setForeground(Color.black);
						button.setFont(f);
						button.setForeground(Color.black);
						panel1.add(inputbox);
						panel1.add(search1);
						panel1.add(sp1);
						panel1.add(button);
						panel1.add(label1);
						frame12.add(panel1);
						frame12.setSize(560, 300);
						frame12.setLocationRelativeTo(null);
						frame12.getContentPane().setBackground(
								new Color(197, 216, 222));
						frame12.setVisible(true);
						result.setLineWrap(true);
						// �� ��ѯ���õķ���������
						search1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String words = inputbox.getText();
								if (!words.equals("")) {
									String result1 = myTest.invoke(words,
									"entozh");
							result.setText(result1);
								}
							}
						});

						// �ڲ�ѯ���ʽ����ϰ������������桱��ť�����¼�
						button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								myframe.setVisible(true);
								frame12.dispose();

							}
						});
					}
				});

			}
		});
		// 记忆单词按钮
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myframe.setVisible(false);
				JPanel panel1 = new JPanel();
				panel1.setLayout(null);
				JLabel choose = new JLabel("选择题库");
				JButton siji = new JButton("四级题库");
				JButton liuji = new JButton("六级题库");
				JButton toefl = new JButton("托福题库");
				JButton ielts = new JButton("雅思题库");
				JButton wordy = new JButton("已背题库");
				choose.setBounds(175, 10, 100, 20);
				siji.setBounds(100, 40, 200, 50);
				liuji.setBounds(100, 105, 200, 50);
				toefl.setBounds(100, 170, 200, 50);
				ielts.setBounds(100, 235, 200, 50);
				wordy.setBounds(100, 300, 200, 50);
				Font f = new Font("宋体", Font.ROMAN_BASELINE, 15);// 根据指定字体名称、样式和磅值大小，创建一个新
				// Font。
				choose.setFont(f);
				choose.setForeground(Color.black);
				siji.setFont(f);
				siji.setForeground(Color.black);
				liuji.setFont(f);
				liuji.setForeground(Color.black);
				toefl.setFont(f);
				toefl.setForeground(Color.black);
				ielts.setFont(f);
				ielts.setForeground(Color.black);
				wordy.setFont(f);
				wordy.setForeground(Color.black);
				panel1.add(choose);
				panel1.add(siji);
				panel1.add(liuji);
				panel1.add(toefl);
				panel1.add(ielts);
				panel1.add(wordy);
				frame2.add(panel1);
				frame2.setSize(400, 430);
				frame2.setLocationRelativeTo(null);
				frame2.setVisible(true);

				ielts.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame2.setVisible(false);
						JPanel pl = new JPanel();
						pl.setLayout(null);
						final JTextField word = new JTextField();
						final JTextArea mean = new JTextArea();
						JButton bt_yes = new JButton("下一个");
						JButton bt_return = new JButton("返回");
						JButton bt_no = new JButton("不会");
						JButton bt_ins = new JButton("记住了");
						word.setBounds(100, 20, 200, 30);
						mean.setBounds(100, 70, 200, 200);
						bt_yes.setBounds(20, 290, 100, 30);
						bt_return.setBounds(130, 290, 70, 30);
						bt_no.setBounds(210, 290, 70, 30);
						bt_ins.setBounds(290, 290, 100, 30);
						Font f = new Font("宋体", Font.ROMAN_BASELINE, 15);// 根据指定字体名称、样式和磅值大小，创建一个新
						// Font。
						bt_return.setFont(f);
						bt_return.setForeground(Color.black);
						bt_no.setFont(f);
						bt_no.setForeground(Color.black);
						bt_yes.setFont(f);
						bt_yes.setForeground(Color.black);
						bt_ins.setFont(f);
						bt_ins.setForeground(Color.black);
						pl.add(bt_return);
						pl.add(bt_no);
						pl.add(bt_yes);
						pl.add(bt_ins);
						word.setBorder(BorderFactory
								.createLineBorder(new Color(220, 232, 235)));
						mean.setBorder(BorderFactory
								.createLineBorder(new Color(220, 232, 235)));
						pl.add(word);
						pl.add(mean);
						jiyif1.setSize(412, 412);
						jiyif1.setLocationRelativeTo(null);
						jiyif1.add(pl);
						jiyif1.setVisible(true);
						Random random = new Random();
						int i = random.nextInt(2089);
						k = i;
						String result = myTest.invoke3("getrandzh", k);
						word.setText(result);
						bt_yes.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								Random random = new Random();
								int i = random.nextInt(2089);
								k = i;
								String result = myTest.invoke3("getrandzh", k);
								word.setText(result);
								mean.setText(" ");

							}

						});
						bt_return.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								myframe.setVisible(true);
								jiyif1.dispose();
							}
						});
						bt_no.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								String result = myTest.invoke3("getranden", k);
								mean.setText(result);
							}

						});
						bt_ins.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								String result = word.getText();
								myTest.invoke4(result);// 该怎么证明这个问题呢
								JOptionPane.showMessageDialog(null,
										"恭喜！该词不再出现！");
							}

						});
					}
				});

				siji.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame2.setVisible(false);
						JPanel pl = new JPanel();
						pl.setLayout(null);
						final JTextField word = new JTextField();
						final JTextArea mean = new JTextArea();
						JButton bt_yes = new JButton("下一个");
						JButton bt_return = new JButton("返回");
						JButton bt_no = new JButton("不会");
						JButton bt_ins = new JButton("记住了");
						word.setBounds(100, 20, 200, 30);
						mean.setBounds(100, 70, 200, 200);
						bt_yes.setBounds(20, 290, 100, 30);
						bt_return.setBounds(130, 290, 70, 30);
						bt_no.setBounds(210, 290, 70, 30);
						bt_ins.setBounds(290, 290, 100, 30);
						Font f = new Font("宋体", Font.ROMAN_BASELINE, 15);// 根据指定字体名称、样式和磅值大小，创建一个新
						// Font。
						bt_return.setFont(f);
						bt_return.setForeground(Color.black);
						bt_no.setFont(f);
						bt_no.setForeground(Color.black);
						bt_yes.setFont(f);
						bt_yes.setForeground(Color.black);
						bt_ins.setFont(f);
						bt_ins.setForeground(Color.black);
						pl.add(bt_return);
						pl.add(bt_no);
						pl.add(bt_yes);
						pl.add(bt_ins);
						word.setBorder(BorderFactory
								.createLineBorder(new Color(220, 232, 235)));
						mean.setBorder(BorderFactory
								.createLineBorder(new Color(220, 232, 235)));
						pl.add(word);
						pl.add(mean);
						jiyif2.setSize(412, 412);
						jiyif2.setLocationRelativeTo(null);
						jiyif2.add(pl);
						jiyif2.setVisible(true);
						Random random = new Random();
						int i = random.nextInt(2089);
						k = i;
						String result = myTest.invoke3("getrandzh", k);
						word.setText(result);
						bt_yes.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								Random random = new Random();
								int i = random.nextInt(2089);
								k = i;
								String result = myTest.invoke3("getrandzh", k);
								word.setText(result);
								mean.setText(" ");

							}

						});
						bt_return.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								myframe.setVisible(true);
								jiyif2.dispose();
							}
						});
						bt_no.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								String result = myTest.invoke3("getranden", k);
								mean.setText(result);
							}

						});
						bt_ins.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								String result = word.getText();
								myTest.invoke4(result);// 该怎么证明这个问题呢
								JOptionPane.showMessageDialog(null,
										"恭喜！该词不再出现！");
							}

						});
					}
				});

				liuji.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame2.setVisible(false);
						JPanel pl = new JPanel();
						pl.setLayout(null);
						final JTextField word = new JTextField();
						final JTextArea mean = new JTextArea();
						JButton bt_yes = new JButton("下一个");
						JButton bt_return = new JButton("返回");
						JButton bt_no = new JButton("不会");
						JButton bt_ins = new JButton("记住了");
						word.setBounds(100, 20, 200, 30);
						mean.setBounds(100, 70, 200, 200);
						bt_yes.setBounds(20, 290, 100, 30);
						bt_return.setBounds(130, 290, 70, 30);
						bt_no.setBounds(210, 290, 70, 30);
						bt_ins.setBounds(290, 290, 100, 30);
						Font f = new Font("宋体", Font.ROMAN_BASELINE, 15);// 根据指定字体名称、样式和磅值大小，创建一个新
						// Font。
						bt_return.setFont(f);
						bt_return.setForeground(Color.black);
						bt_no.setFont(f);
						bt_no.setForeground(Color.black);
						bt_yes.setFont(f);
						bt_yes.setForeground(Color.black);
						bt_ins.setFont(f);
						bt_ins.setForeground(Color.black);
						pl.add(bt_return);
						pl.add(bt_no);
						pl.add(bt_yes);
						pl.add(bt_ins);
						word.setBorder(BorderFactory
								.createLineBorder(new Color(220, 232, 235)));
						mean.setBorder(BorderFactory
								.createLineBorder(new Color(220, 232, 235)));
						pl.add(word);
						pl.add(mean);
						jiyif3.setSize(412, 412);
						jiyif3.setLocationRelativeTo(null);
						jiyif3.add(pl);
						jiyif3.setVisible(true);
						Random random = new Random();
						int i = random.nextInt(2089);
						k = i;
						String result = myTest.invoke3("getrandzh", k);
						word.setText(result);
						bt_yes.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								Random random = new Random();
								int i = random.nextInt(2089);
								k = i;
								String result = myTest.invoke3("getrandzh", k);
								word.setText(result);
								mean.setText(" ");

							}

						});
						bt_return.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								myframe.setVisible(true);
								jiyif3.dispose();
							}
						});
						bt_no.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								String result = myTest.invoke3("getranden", k);
								mean.setText(result);
							}

						});
						bt_ins.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								String result = word.getText();
								myTest.invoke4(result);// 该怎么证明这个问题呢
								JOptionPane.showMessageDialog(null,
										"恭喜！该词不再出现！");
							}

						});
					}
				});

				toefl.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame2.setVisible(false);
						JPanel pl = new JPanel();
						pl.setLayout(null);
						final JTextField word = new JTextField();
						final JTextArea mean = new JTextArea();
						JButton bt_yes = new JButton("下一个");
						JButton bt_return = new JButton("返回");
						JButton bt_no = new JButton("不会");
						JButton bt_ins = new JButton("记住了");
						word.setBounds(100, 20, 200, 30);
						mean.setBounds(100, 70, 200, 200);
						bt_yes.setBounds(20, 290, 100, 30);
						bt_return.setBounds(130, 290, 70, 30);
						bt_no.setBounds(210, 290, 70, 30);
						bt_ins.setBounds(290, 290, 100, 30);
						Font f = new Font("宋体", Font.ROMAN_BASELINE, 15);// 根据指定字体名称、样式和磅值大小，创建一个新
						// Font。
						bt_return.setFont(f);
						bt_return.setForeground(Color.black);
						bt_no.setFont(f);
						bt_no.setForeground(Color.black);
						bt_yes.setFont(f);
						bt_yes.setForeground(Color.black);
						bt_ins.setFont(f);
						bt_ins.setForeground(Color.black);
						pl.add(bt_return);
						pl.add(bt_no);
						pl.add(bt_yes);
						pl.add(bt_ins);
						word.setBorder(BorderFactory
								.createLineBorder(new Color(220, 232, 235)));
						mean.setBorder(BorderFactory
								.createLineBorder(new Color(220, 232, 235)));
						pl.add(word);
						pl.add(mean);
						jiyif4.setSize(412, 412);
						jiyif4.setLocationRelativeTo(null);
						jiyif4.add(pl);
						jiyif4.setVisible(true);
						Random random = new Random();
						int i = random.nextInt(2089);
						k = i;
						String result = myTest.invoke3("getrandzh", k);
						word.setText(result);
						bt_yes.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								Random random = new Random();
								int i = random.nextInt(2089);
								k = i;
								String result = myTest.invoke3("getrandzh", k);
								word.setText(result);
								mean.setText(" ");

							}

						});
						bt_return.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								myframe.setVisible(true);
								jiyif4.dispose();
							}
						});
						bt_no.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								String result = myTest.invoke3("getranden", k);
								mean.setText(result);
							}

						});
						bt_ins.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								String result = word.getText();
								myTest.invoke4(result);// 该怎么证明这个问题呢
								JOptionPane.showMessageDialog(null,
										"恭喜！该词不再出现！");
							}

						});
					}
				});

				wordy.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame2.setVisible(false);
						JPanel pl = new JPanel();
						pl.setLayout(null);
						final JTextArea mean = new JTextArea();
						JButton bt_return = new JButton("返回");
						JButton bt_set = new JButton("刷新");
						mean.setBounds(100, 70, 200, 200);
						bt_set.setBounds(70, 290, 100, 30);
						bt_return.setBounds(190, 290, 100, 30);
						Font f = new Font("宋体", Font.ROMAN_BASELINE, 15);// 根据指定字体名称、样式和磅值大小，创建一个新
						// //
						// Font。
						bt_return.setFont(f);
						bt_return.setForeground(Color.black);
						pl.add(bt_return);
						bt_set.setFont(f);
						bt_set.setForeground(Color.black);
						pl.add(bt_set);
						JScrollPane sp1 = new JScrollPane(mean);
						sp1.setBorder(BorderFactory.createLineBorder(new Color(
								220, 232, 235)));
						sp1.setBackground(Color.white);
						sp1.setBounds(20, 20, 380, 260);
						mean.setBorder(BorderFactory
								.createLineBorder(new Color(220, 232, 235)));
						pl.add(sp1);
						jiyif5.setSize(420, 412);
						jiyif5.setLocationRelativeTo(null);
						jiyif5.add(pl);
						jiyif5.setVisible(true);
						mean.setText(" ");
						bt_set.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String result1 = myTest.invoke5();
								String result = result1.substring(5, result1.length());
								mean.setText(result);
							}
						});
						bt_return.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								myframe.setVisible(true);
								jiyif5.dispose();
							}
						});
					}
				});
			}
		});
		// 翻译句子按钮
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myframe.setVisible(false);
				JPanel panel1 = new JPanel();
				panel1.setLayout(null);
				final JTextArea input = new JTextArea(" ");
				final JTextArea output = new JTextArea(" ");
				JButton button = new JButton("翻译");
				JButton button1 = new JButton("返回");
				input.setBounds(50, 10, 300, 100);
				output.setBounds(50, 150, 300, 100);
				button.setBounds(115, 120, 70, 20);
				button1.setBounds(215, 120, 70, 20);
				Font f = new Font("宋体", Font.ROMAN_BASELINE, 15);// 根据指定字体名称、样式和磅值大小，创建一个新
				// Font。
				button.setFont(f);
				button.setForeground(Color.black);
				button1.setFont(f);
				button1.setForeground(Color.black);
				panel1.add(button);
				panel1.add(button1);
				input.setBorder(BorderFactory.createLineBorder(new Color(220,
						232, 235)));
				output.setBorder(BorderFactory.createLineBorder(new Color(220,
						232, 235)));
				panel1.add(input);
				panel1.add(output);
				frame3.add(panel1);
				frame3.setSize(400, 320);
				frame3.setLocationRelativeTo(null);
				frame3.setVisible(true);
				// �� ���� ���õķ��������� ��褡�����
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String words = input.getText();
						if (!words.equals("")) {
							String result1 = myTest.invoke(words, "entozh");
							output.setText(result1);

						}
					}
				});

				button1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						myframe.setVisible(true);
						frame3.dispose();
					}
				});
			}
		});
		// 单词测试按钮
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myframe.setVisible(false);
				JPanel panel1 = new JPanel();
				panel1.setLayout(null);
				JButton hy = new JButton("汉译英");
				JButton yh = new JButton("英译汉");
				JButton button7 = new JButton("返回");
				hy.setBounds(20, 20, 150, 30);
				yh.setBounds(20, 60, 150, 30);
				button7.setBounds(20, 100, 150, 30);
				Font f = new Font("宋体", Font.ROMAN_BASELINE, 15);// 根据指定字体名称、样式和磅值大小，创建一个新
				// Font。
				hy.setFont(f);
				hy.setForeground(Color.black);
				yh.setFont(f);
				yh.setForeground(Color.black);
				panel1.add(hy);
				panel1.add(yh);
				panel1.add(button7);

				// 点击汉译英界面
				hy.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame4.setVisible(false);
						JPanel panel = new JPanel();
						panel.setLayout(null);
						JLabel hanyi = new JLabel("汉译:");
						JLabel yingwen = new JLabel("英文:");
						final JTextField tf1 = new JTextField();
						final JTextField tf2 = new JTextField();
						JButton queding = new JButton("确定");
						JButton tiaoguo = new JButton("跳过");
						JButton re = new JButton("返回主界面");
						hanyi.setBounds(60, 20, 50, 25);
						yingwen.setBounds(60, 55, 50, 25);
						tf1.setBounds(100, 20, 200, 25);
						tf2.setBounds(100, 55, 200, 25);
						queding.setBounds(50, 100, 70, 25);
						tiaoguo.setBounds(140, 100, 70, 25);
						re.setBounds(230, 100, 100, 25);
						Font f = new Font("宋体", Font.ROMAN_BASELINE, 15);// 根据指定字体名称、样式和磅值大小，创建一个新
						// Font。
						queding.setFont(f);
						queding.setForeground(Color.black);
						tiaoguo.setFont(f);
						tiaoguo.setForeground(Color.black);
						panel.add(hanyi);
						panel.add(yingwen);
						panel.add(queding);
						panel.add(tiaoguo);
						panel.add(re);
						tf1.setBorder(BorderFactory.createLineBorder(new Color(
								220, 232, 235)));
						tf2.setBorder(BorderFactory.createLineBorder(new Color(
								220, 232, 235)));
						panel.add(tf1);
						panel.add(tf2);
						hyf.add(panel);
						hyf.setSize(400, 200);
						hyf.setLocationRelativeTo(null);
						hyf.setVisible(true);
						// 在窗口加载时便进行一次随机get中文
						String fr = "Source/四级单词.txt";
						Random random = new Random();
						int i = random.nextInt(2089);
						k = i;
						String result = myTest.invoke1(fr, "word", k);
						tf1.setText(result);
						queding.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// 首先get对应的英文意思
								String fr = "Source/四级单词.txt";
								String result = myTest.invoke1(fr, "recite", k);
								// 然后获取字符的纯英文版本
								String result1 = ("A" + result).trim()
										.substring(1);
								// 然后获取输入
								String result2 = tf2.getText();

								// 然后进行匹配
								if (result1.equals(result2)) {
									JOptionPane.showMessageDialog(hyf, "正确！");
								} else {
									JOptionPane.showMessageDialog(hyf, "错误！");
									tf2.setText("正确答案：" + result1);
								}
							}
						});
						// 点击跳过后
						tiaoguo.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// 清空两框
								String result = myTest.invoke("  ", "null");
								tf1.setText(result);
								tf2.setText(result);
								// 随机get中文
								String fr = "Article/四级单词.txt";
								Random random = new Random();
								int i = random.nextInt(2089);
								k = i;
								String result2 = myTest.invoke1(fr, "word", k);
								tf1.setText(result2);
							}
						});
						// 点击返回主界面
						re.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								myframe.setVisible(true);
								hyf.dispose();

							}
						});
					}
				});
				yh.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame5.setVisible(false);
						JPanel panel = new JPanel();
						panel.setLayout(null);
						JLabel yingwen = new JLabel("英文:");
						final JTextField tf = new JTextField();
						JButton queding = new JButton("确定");
						JButton tiaoguo = new JButton("跳过");
						JButton re = new JButton("返回主界面");
						String n = "美丽的 可爱的 啦啦啦啦啦";
						String m = "善良的";
						String p = "帅气的";
						String q = "完美的";
						final JRadioButton jb1 = new JRadioButton(n);
						final JRadioButton jb2 = new JRadioButton(m);
						final JRadioButton jb3 = new JRadioButton(p);
						final JRadioButton jb4 = new JRadioButton(q);
						ButtonGroup bg = new ButtonGroup();
						yingwen.setBounds(40, 30, 70, 30);
						tf.setBounds(80, 30, 150, 30);
						tf.setBorder(BorderFactory.createLineBorder(new Color(
								220, 232, 235)));
						jb1.setBounds(50, 80, 180, 30);
						jb2.setBounds(50, 120, 180, 30);
						jb3.setBounds(50, 160, 180, 30);
						jb4.setBounds(50, 200, 180, 30);
						queding.setBounds(25, 250, 70, 20);
						tiaoguo.setBounds(105, 250, 70, 20);
						re.setBounds(185, 250, 100, 20);
						Font f = new Font("宋体", Font.ROMAN_BASELINE, 15);// 根据指定字体名称、样式和磅值大小，创建一个新
						// Font。
						queding.setFont(f);
						queding.setForeground(Color.black);
						tiaoguo.setFont(f);
						tiaoguo.setForeground(Color.black);
						bg.add(jb1);
						bg.add(jb2);
						bg.add(jb3);
						bg.add(jb4);
						panel.add(yingwen);
						panel.add(tf);
						panel.add(queding);
						panel.add(tiaoguo);
						panel.add(re);
						panel.add(jb1);
						panel.add(jb2);
						panel.add(jb3);
						panel.add(jb4);
						yhf.add(panel);
						yhf.setSize(320, 320);
						yhf.setLocationRelativeTo(null);
						yhf.setVisible(true);
						String fr = "Source/四级单词.txt";
						Random random = new Random();
						int i = random.nextInt(2089);
						k = i;
						String resulta = myTest.invoke1(fr, "recite", k);
						tf.setText(resulta);
						String result = myTest.invoke1(fr, "word", k);
						// get一个匹配的汉语意思
						// 随机get三个其他的汉语意思

						Random random2 = new Random();
						int i2 = random2.nextInt(2089);
						String result2 = myTest.invoke1(fr, "word", i2);

						Random random3 = new Random();
						int i3 = random3.nextInt(2089);
						String result3 = myTest.invoke1(fr, "word", i3);

						Random random4 = new Random();
						int i4 = random4.nextInt(2089);
						String result4 = myTest.invoke1(fr, "word", i4);
						jb1.setText(result);
						jb2.setText(result2);
						jb3.setText(result3);
						jb4.setText(result4);
						queding.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// 随机摆放四个汉语意思
								if (1 == formal) {

									if (jb1.isSelected()) {
										JOptionPane.showMessageDialog(hyf,
												"正确！");
									} else {
										JOptionPane.showMessageDialog(hyf,
												"错误！");
									}
								} else if (2 == formal) {

									if (jb3.isSelected()) {
										JOptionPane.showMessageDialog(hyf,
												"正确！");
									} else {
										JOptionPane.showMessageDialog(hyf,
												"错误！");
									}
								} else if (3 == formal) {

									if (jb3.isSelected()) {
										JOptionPane.showMessageDialog(hyf,
												"正确！");
									} else {
										JOptionPane.showMessageDialog(hyf,
												"错误！");
									}
								} else if (4 == formal) {

									if (jb1.isSelected()) {
										JOptionPane.showMessageDialog(hyf,
												"正确！");
									} else {
										JOptionPane.showMessageDialog(hyf,
												"错误！");
									}
								} else {

									if (jb2.isSelected()) {
										JOptionPane.showMessageDialog(hyf,
												"正确！");
									} else {
										JOptionPane.showMessageDialog(hyf,
												"错误！");
									}
								}
							}
						});
						tiaoguo.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// get对应的中文意思
								String fr = "Source/四级单词.txt";
								Random random = new Random();
								int i = random.nextInt(2089);
								k = i;
								String resulta = myTest
										.invoke1(fr, "recite", k);
								tf.setText(resulta);
								String result = myTest.invoke1(fr, "word", k);
								// get一个匹配的汉语意思
								// 随机get三个其他的汉语意思

								Random random2 = new Random();
								int i2 = random2.nextInt(2089);
								String result2 = myTest.invoke1(fr, "word", i2);

								Random random3 = new Random();
								int i3 = random3.nextInt(2089);
								String result3 = myTest.invoke1(fr, "word", i3);

								Random random4 = new Random();
								int i4 = random4.nextInt(2089);
								String result4 = myTest.invoke1(fr, "word", i4);
								// 随机摆放四个汉语意思
								if (1 == GetNumber(1)) {
									jb1.setText(result);
									jb2.setText(result2);
									jb3.setText(result3);
									jb4.setText(result4);
									formal = 1;
								} else if (2 == GetNumber(1)) {
									jb1.setText(result2);
									jb2.setText(result3);
									jb3.setText(result);
									jb4.setText(result4);
									formal = 2;
								} else if (3 == GetNumber(1)) {
									jb1.setText(result4);
									jb2.setText(result3);
									jb3.setText(result);
									jb4.setText(result2);
									formal = 3;
								} else if (4 == GetNumber(1)) {
									jb1.setText(result);
									jb2.setText(result4);
									jb3.setText(result3);
									jb4.setText(result2);
									formal = 4;
								} else {
									jb1.setText(result4);
									jb2.setText(result);
									jb3.setText(result3);
									jb4.setText(result2);
									formal = 5;
								}
							}
						});
						re.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								yhf.setVisible(false);
								myframe.setVisible(true);
								yhf.dispose();

							}
						});

					}
				});
				button7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						myframe.setVisible(true);
						frame4.dispose();

					}
				});
				frame4.add(panel1);
				frame4.setSize(230, 200);
				frame4.setLocationRelativeTo(null);
				frame4.setVisible(true);
			}
		});
		// 美文共赏按钮
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myframe.setVisible(false);
				JPanel panel1 = new JPanel();
				panel1.setLayout(null);
				JButton button1 = new JButton("文章一");
				JButton button2 = new JButton("文章二");
				JButton button3 = new JButton("文章三");
				JButton button4 = new JButton("文章四");
				JButton button5 = new JButton("文章五");
				JButton button6 = new JButton("文章六");
				JButton button7 = new JButton("返回");
				button1.setBounds(20, 20, 80, 30);
				button2.setBounds(100, 60, 80, 30);
				button3.setBounds(180, 100, 80, 30);
				button4.setBounds(260, 140, 80, 30);
				button5.setBounds(340, 180, 80, 30);
				button6.setBounds(420, 220, 80, 30);
				button7.setBounds(20, 220, 80, 30);
				Font f = new Font("宋体", Font.ROMAN_BASELINE, 15);// 根据指定字体名称、样式和磅值大小，创建一个新
				// Font。
				button1.setFont(f);
				button1.setForeground(Color.black);
				button2.setFont(f);
				button2.setForeground(Color.black);
				button3.setFont(f);
				button3.setForeground(Color.black);
				button4.setFont(f);
				button4.setForeground(Color.black);
				button5.setFont(f);
				button5.setForeground(Color.black);
				button6.setFont(f);
				button6.setForeground(Color.black);
				button7.setFont(f);
				button7.setForeground(Color.black);
				panel1.add(button1);
				panel1.add(button2);
				panel1.add(button3);
				panel1.add(button4);
				panel1.add(button5);
				panel1.add(button6);
				panel1.add(button7);
				button1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame5.setVisible(false);
						JPanel panel1 = new JPanel();
						panel1.setLayout(null);
						JTextArea textarea1 = new JTextArea();
						final JTextArea textarea2 = new JTextArea();
						JScrollPane sp1 = new JScrollPane(textarea1);
						JScrollPane sp2 = new JScrollPane(textarea2);
						sp1.setBorder(BorderFactory.createLineBorder(new Color(
								220, 232, 235)));
						sp1.setBorder(BorderFactory.createLineBorder(new Color(
								220, 232, 235)));
						sp1.setBounds(20, 20, 340, 180);
						sp2.setBounds(20, 210, 340, 150);
						String result = myTest.invoke("", "article1_en");
						textarea1.setText(result);
						JButton bt_trans = new JButton("翻译");
						JButton bt_return = new JButton("返回");
						JButton bt_hide = new JButton("隐藏翻译");
						textarea1.setBounds(20, 20, 340, 180);
						textarea2.setBounds(20, 210, 340, 150);
						bt_trans.setBounds(20, 370, 100, 20);
						bt_return.setBounds(140, 370, 100, 20);
						bt_hide.setBounds(250, 370, 100, 20);
						Font f = new Font("宋体", Font.ROMAN_BASELINE, 15);// 根据指定字体名称、样式和磅值大小，创建一个新
						// Font。
						bt_trans.setFont(f);
						bt_trans.setForeground(Color.black);
						bt_return.setFont(f);
						bt_return.setForeground(Color.black);
						bt_hide.setFont(f);
						bt_hide.setForeground(Color.black);
						panel1.add(sp1);
						panel1.add(sp2);
						panel1.add(bt_trans);
						panel1.add(bt_return);
						panel1.add(bt_hide);
						textarea1.setLineWrap(true);
						textarea2.setLineWrap(true);
						meiwenf1.add(panel1);
						meiwenf1.setSize(400, 450);
						meiwenf1.setVisible(true);
						meiwenf1.setLocationRelativeTo(null);
						bt_return.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								meiwenf1.setVisible(false);
								frame5.setVisible(true);

							}
						});
						bt_trans.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String result = myTest
										.invoke("", "article1_zh");
								textarea2.setText(result);

							}
						});
						bt_hide.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String result = myTest.invoke("", "null");
								textarea2.setText(result);

							}
						});

					}
				});
				button2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame5.setVisible(false);
						JPanel panel1 = new JPanel();
						panel1.setLayout(null);
						JTextArea textarea1 = new JTextArea();
						final JTextArea textarea2 = new JTextArea();

						String result = myTest.invoke("", "article2_en");
						textarea1.setText(result);
						JButton bt_trans = new JButton("翻译");
						JButton bt_return = new JButton("返回");
						JButton bt_hide = new JButton("隐藏翻译");
						textarea1.setBounds(20, 20, 340, 180);
						textarea2.setBounds(20, 210, 340, 150);
						bt_trans.setBounds(20, 370, 100, 20);
						bt_return.setBounds(140, 370, 100, 20);
						bt_hide.setBounds(250, 370, 100, 20);
						JScrollPane sp1 = new JScrollPane(textarea1);
						JScrollPane sp2 = new JScrollPane(textarea2);
						sp1.setBorder(BorderFactory.createLineBorder(new Color(
								220, 232, 235)));
						sp1.setBorder(BorderFactory.createLineBorder(new Color(
								220, 232, 235)));
						sp1.setBounds(20, 20, 340, 180);
						sp2.setBounds(20, 210, 340, 150);
						Font f = new Font("宋体", Font.ROMAN_BASELINE, 15);// 根据指定字体名称、样式和磅值大小，创建一个新
						// Font。
						bt_trans.setFont(f);
						bt_trans.setForeground(Color.black);
						bt_return.setFont(f);
						bt_return.setForeground(Color.black);
						bt_hide.setFont(f);
						bt_hide.setForeground(Color.black);
						panel1.add(sp1);
						panel1.add(sp2);
						panel1.add(bt_trans);
						panel1.add(bt_return);
						panel1.add(bt_hide);
						textarea1.setLineWrap(true);
						textarea2.setLineWrap(true);
						meiwenf2.add(panel1);
						meiwenf2.setSize(400, 450);
						meiwenf2.setVisible(true);
						meiwenf2.setLocationRelativeTo(null);
						bt_return.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								meiwenf1.setVisible(false);
								meiwenf2.setVisible(false);
								meiwenf3.setVisible(false);
								meiwenf4.setVisible(false);
								meiwenf5.setVisible(false);
								meiwenf6.setVisible(false);
								frame5.setVisible(true);

							}
						});
						bt_trans.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String result = myTest
										.invoke("", "article2_zh");
								textarea2.setText(result);

							}
						});
						bt_hide.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String result = myTest.invoke("", "null");
								textarea2.setText(result);

							}
						});

					}
				});
				button3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame5.setVisible(false);
						JPanel panel1 = new JPanel();
						panel1.setLayout(null);
						JTextArea textarea1 = new JTextArea();
						final JTextArea textarea2 = new JTextArea();
						String result = myTest.invoke("", "article3_en");
						textarea1.setText(result);
						JButton bt_trans = new JButton("翻译");
						JButton bt_return = new JButton("返回");
						JButton bt_hide = new JButton("隐藏翻译");
						textarea1.setBounds(20, 20, 340, 180);
						textarea2.setBounds(20, 210, 340, 150);
						bt_trans.setBounds(20, 370, 100, 20);
						bt_return.setBounds(140, 370, 100, 20);
						bt_hide.setBounds(250, 370, 100, 20);
						JScrollPane sp1 = new JScrollPane(textarea1);
						JScrollPane sp2 = new JScrollPane(textarea2);
						sp1.setBorder(BorderFactory.createLineBorder(new Color(
								220, 232, 235)));
						sp1.setBorder(BorderFactory.createLineBorder(new Color(
								220, 232, 235)));
						sp1.setBounds(20, 20, 340, 180);
						sp2.setBounds(20, 210, 340, 150);
						Font f = new Font("宋体", Font.ROMAN_BASELINE, 15);// 根据指定字体名称、样式和磅值大小，创建一个新
						// Font。
						bt_trans.setFont(f);
						bt_trans.setForeground(Color.black);
						bt_return.setFont(f);
						bt_return.setForeground(Color.black);
						bt_hide.setFont(f);
						bt_hide.setForeground(Color.black);
						panel1.add(sp1);
						panel1.add(sp2);

						panel1.add(bt_trans);
						panel1.add(bt_return);
						panel1.add(bt_hide);
						textarea1.setLineWrap(true);
						textarea2.setLineWrap(true);
						meiwenf3.add(panel1);
						meiwenf3.setSize(400, 450);
						meiwenf3.setVisible(true);
						meiwenf3.setLocationRelativeTo(null);
						bt_return.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								meiwenf1.setVisible(false);
								meiwenf2.setVisible(false);
								meiwenf3.setVisible(false);
								meiwenf4.setVisible(false);
								meiwenf5.setVisible(false);
								meiwenf6.setVisible(false);
								frame5.setVisible(true);

							}
						});
						bt_trans.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String result = myTest
										.invoke("", "article3_zh");
								textarea2.setText(result);

							}
						});
						bt_hide.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String result = myTest.invoke("", "null");
								textarea2.setText(result);

							}
						});

					}
				});
				button4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame5.setVisible(false);
						JPanel panel1 = new JPanel();
						panel1.setLayout(null);
						JTextArea textarea1 = new JTextArea();
						final JTextArea textarea2 = new JTextArea();
						String result = myTest.invoke("", "article4_en");
						textarea1.setText(result);
						JButton bt_trans = new JButton("翻译");
						JButton bt_return = new JButton("返回");
						JButton bt_hide = new JButton("隐藏翻译");
						textarea1.setBounds(20, 20, 340, 180);
						textarea2.setBounds(20, 210, 340, 150);
						bt_trans.setBounds(20, 370, 100, 20);
						bt_return.setBounds(140, 370, 100, 20);
						bt_hide.setBounds(250, 370, 100, 20);
						JScrollPane sp1 = new JScrollPane(textarea1);
						JScrollPane sp2 = new JScrollPane(textarea2);
						sp1.setBorder(BorderFactory.createLineBorder(new Color(
								220, 232, 235)));
						sp1.setBorder(BorderFactory.createLineBorder(new Color(
								220, 232, 235)));
						sp1.setBounds(20, 20, 340, 180);
						sp2.setBounds(20, 210, 340, 150);
						Font f = new Font("宋体", Font.ROMAN_BASELINE, 15);// 根据指定字体名称、样式和磅值大小，创建一个新
						// Font。
						bt_trans.setFont(f);
						bt_trans.setForeground(Color.black);
						bt_return.setFont(f);
						bt_return.setForeground(Color.black);
						bt_hide.setFont(f);
						bt_hide.setForeground(Color.black);
						panel1.add(sp1);
						panel1.add(sp2);
						panel1.add(bt_trans);
						panel1.add(bt_return);
						panel1.add(bt_hide);
						textarea1.setLineWrap(true);
						textarea2.setLineWrap(true);
						meiwenf4.add(panel1);
						meiwenf4.setSize(400, 450);
						meiwenf4.setVisible(true);
						meiwenf4.setLocationRelativeTo(null);
						bt_return.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								meiwenf4.setVisible(false);
								frame5.setVisible(true);

							}
						});
						bt_trans.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String result = myTest
										.invoke("", "article4_zh");
								textarea2.setText(result);

							}
						});
						bt_hide.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String result = myTest.invoke("", "null");
								textarea2.setText(result);

							}
						});

					}
				});
				button5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame5.setVisible(false);
						JPanel panel1 = new JPanel();
						panel1.setLayout(null);
						JTextArea textarea1 = new JTextArea();
						final JTextArea textarea2 = new JTextArea();
						String result = myTest.invoke("", "article5_en");
						textarea1.setText(result);
						JButton bt_trans = new JButton("翻译");
						JButton bt_return = new JButton("返回");
						JButton bt_hide = new JButton("隐藏翻译");
						textarea1.setBounds(20, 20, 340, 180);
						textarea2.setBounds(20, 210, 340, 150);
						bt_trans.setBounds(20, 370, 100, 20);
						bt_return.setBounds(140, 370, 100, 20);
						bt_hide.setBounds(250, 370, 100, 20);
						JScrollPane sp1 = new JScrollPane(textarea1);
						JScrollPane sp2 = new JScrollPane(textarea2);
						sp1.setBorder(BorderFactory.createLineBorder(new Color(
								220, 232, 235)));
						sp1.setBorder(BorderFactory.createLineBorder(new Color(
								220, 232, 235)));
						sp1.setBounds(20, 20, 340, 180);
						sp2.setBounds(20, 210, 340, 150);
						Font f = new Font("宋体", Font.ROMAN_BASELINE, 15);// 根据指定字体名称、样式和磅值大小，创建一个新
						// Font。
						bt_trans.setFont(f);
						bt_trans.setForeground(Color.black);
						bt_return.setFont(f);
						bt_return.setForeground(Color.black);
						bt_hide.setFont(f);
						bt_hide.setForeground(Color.black);
						panel1.add(sp1);
						panel1.add(sp2);
						panel1.add(bt_trans);
						panel1.add(bt_return);
						panel1.add(bt_hide);
						textarea1.setLineWrap(true);
						textarea2.setLineWrap(true);
						meiwenf5.add(panel1);
						meiwenf5.setSize(400, 450);
						meiwenf5.setVisible(true);
						meiwenf5.setLocationRelativeTo(null);
						bt_return.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								meiwenf1.setVisible(false);
								meiwenf2.setVisible(false);
								meiwenf3.setVisible(false);
								meiwenf4.setVisible(false);
								meiwenf5.setVisible(false);
								meiwenf6.setVisible(false);
								frame5.setVisible(true);

							}
						});
						bt_trans.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String result = myTest
										.invoke("", "article5_zh");
								textarea2.setText(result);

							}
						});
						bt_hide.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String result = myTest.invoke("", "null");
								textarea2.setText(result);

							}
						});

					}
				});
				button6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame5.setVisible(false);
						JPanel panel2 = new JPanel();
						panel2.setLayout(null);
						JTextArea textarea1 = new JTextArea();
						final JTextArea textarea2 = new JTextArea();
						String result6 = myTest.invoke("", "article6_en");
						textarea1.setText(result6);
						JButton bt_trans = new JButton("翻译");
						JButton bt_return = new JButton("返回");
						JButton bt_hide = new JButton("隐藏翻译");
						textarea1.setBounds(20, 20, 340, 180);
						textarea2.setBounds(20, 210, 340, 150);
						bt_trans.setBounds(20, 370, 100, 20);
						bt_return.setBounds(140, 370, 100, 20);
						bt_hide.setBounds(250, 370, 100, 20);
						JScrollPane sp1 = new JScrollPane(textarea1);
						JScrollPane sp2 = new JScrollPane(textarea2);
						sp1.setBorder(BorderFactory.createLineBorder(new Color(
								220, 232, 235)));
						sp1.setBorder(BorderFactory.createLineBorder(new Color(
								220, 232, 235)));
						sp1.setBounds(20, 20, 340, 180);
						sp2.setBounds(20, 210, 340, 150);
						Font f = new Font("宋体", Font.ROMAN_BASELINE, 15);// 根据指定字体名称、样式和磅值大小，创建一个新
						// Font。
						bt_trans.setFont(f);
						bt_trans.setForeground(Color.black);
						bt_return.setFont(f);
						bt_return.setForeground(Color.black);
						bt_hide.setFont(f);
						bt_hide.setForeground(Color.black);
						panel2.add(sp1);
						panel2.add(sp2);
						panel2.add(bt_trans);
						panel2.add(bt_return);
						panel2.add(bt_hide);
						textarea1.setLineWrap(true);
						textarea2.setLineWrap(true);
						meiwenf6.add(panel2);
						meiwenf6.setSize(400, 450);
						meiwenf6.setVisible(true);
						meiwenf6.setLocationRelativeTo(null);
						bt_return.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								meiwenf1.setVisible(false);
								meiwenf2.setVisible(false);
								meiwenf3.setVisible(false);
								meiwenf4.setVisible(false);
								meiwenf5.setVisible(false);
								meiwenf6.setVisible(false);
								frame5.setVisible(true);

							}
						});
						bt_trans.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String result = myTest
										.invoke("", "article6_zh");
								textarea2.setText(result);

							}
						});
						bt_hide.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String result = myTest.invoke("", "null");
								textarea2.setText(result);

							}
						});

					}
				});
				button7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame5.setVisible(false);
						myframe.setVisible(true);

					}
				});
				frame5.add(panel1);
				frame5.setSize(520, 320);
				frame5.setVisible(true);
				frame5.setLocationRelativeTo(null);
			}
		});
		// 听力练习按钮
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				myframe.setVisible(false);
				JPanel panel1 = new JPanel();
				panel1.setLayout(null);
				JButton button1 = new JButton("Adele-Set Fire to the Rain");
				JButton button2 = new JButton("Amy Diamond-Heartbeats");
				JButton button3 = new JButton("Beyoncé-If I Were A Boy");
				JButton button4 = new JButton(
						"Carly Rae Jepsen-I Really Like You");
				JButton button5 = new JButton("SovietMarch");
				JButton button6 = new JButton("心臓を捧げよ");
				button1.setBounds(100, 20, 180, 30);
				button2.setBounds(60, 60, 180, 30);
				button3.setBounds(120, 100, 180, 30);
				button4.setBounds(60, 140, 180, 30);
				button5.setBounds(120, 180, 180, 30);
				button6.setBounds(60, 220, 180, 30);
				Font f = new Font("宋体", Font.ROMAN_BASELINE, 15);// 根据指定字体名称、样式和磅值大小，创建一个新
				// Font。
				button1.setFont(f);
				button1.setForeground(Color.black);
				button2.setFont(f);
				button2.setForeground(Color.black);
				button3.setFont(f);
				button3.setForeground(Color.black);
				button4.setFont(f);
				button4.setForeground(Color.black);
				button5.setFont(f);
				button5.setForeground(Color.black);
				button6.setFont(f);
				button6.setForeground(Color.black);
				panel1.add(button1);
				panel1.add(button2);
				panel1.add(button3);
				panel1.add(button4);
				panel1.add(button5);
				panel1.add(button6);
				button1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String song1 = "Source/song1";

						yuanwen1 = myTest.invoke2("ly", song1);
						@SuppressWarnings("unused")
						String result = myTest.invoke6("chu", 1);
						myTest.invoke6("xu", 0);
						frame6.setVisible(false);
						JPanel panel = new JPanel();
						panel.setLayout(null);
						// JLabel title = new
						// JLabel("Adele-Set Fire to the Rain.wav");
						title.setText("Adele-Set Fire to the Rain.wav");
						JButton start = new JButton("播放");
						JButton pause = new JButton("暂停");
						JButton last = new JButton("上一曲");
						JButton next = new JButton("下一曲");
						JButton stop = new JButton("停止");
						JButton re = new JButton("返回主界面");
						JButton xianshi = new JButton("显示原文");

						ta1.setText("   ");
						JScrollPane sp = new JScrollPane(ta1);
						// title.setBounds(100,20,200,30);
						last.setBounds(20, 70, 80, 30);
						start.setBounds(120, 70, 70, 30);
						pause.setBounds(200, 70, 70, 30);
						next.setBounds(290, 70, 80, 30);
						stop.setBounds(390, 90, 80, 30);
						ta1.setBounds(30, 120, 320, 120);
						xianshi.setBounds(60, 260, 100, 30);
						re.setBounds(220, 260, 100, 30);
						sp.setBounds(30, 120, 320, 120);
						sp
								.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						sp
								.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
						panel.add(title);
						panel.add(start);
						panel.add(pause);
						panel.add(last);
						panel.add(next);
						panel.add(stop);
						panel.add(re);
						panel.add(sp);
						panel.add(xianshi);
						start.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("start", 1);
							}
						});
						pause.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("stop", 1);
							}
						});
						last.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("prev", 0);
							}
						});
						next.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("next", 1);
							}
						});
						stop.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("stop", 1);
							}
						});
						xianshi.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								/*
								 * int i=0; String m = null; String song1 =
								 * "data/song1"; ArrayList result = new
								 * ArrayList();
								 * 
								 * for(i=0;i<result.size();i++) { m=(String)
								 * result.get(i);
								 * 
								 * }
								 */
								ta1.setText(yuanwen1);
							}
						});
						re.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// myTest.invoke6("chushihu",1);
								listen.setVisible(false);
								myframe.setVisible(true);
								myTest.invoke6("stop", 1);
							}
						});
						ta1.setText("   ");
						listen.add(panel);
						listen.setSize(400, 350);
						listen.setLocationRelativeTo(null);
						listen.setVisible(true);

					}
				});
				button2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String song1 = "Source/song2";

						yuanwen1 = myTest.invoke2("ly", song1);
						myTest.invoke6("xu", 1);
						frame6.setVisible(false);
						JPanel panel = new JPanel();
						panel.setLayout(null);
						// JLabel title = new
						// JLabel("Amy Diamond-Heartbeats.wav");

						title.setText("Amy Diamond-Heartbeats.wav");
						JButton start = new JButton("播放");
						JButton pause = new JButton("暂停");
						JButton last = new JButton("上一曲");
						JButton next = new JButton("下一曲");
						JButton stop = new JButton("停止");
						JButton re = new JButton("返回主界面");
						JButton xianshi = new JButton("显示原文");
						// final JTextArea ta1 = new JTextArea();
						ta1.setText("   ");
						JScrollPane sp = new JScrollPane(ta1);
						title.setBounds(100, 20, 200, 30);
						last.setBounds(20, 70, 80, 30);
						start.setBounds(120, 70, 70, 30);
						pause.setBounds(200, 70, 70, 30);
						next.setBounds(290, 70, 80, 30);
						stop.setBounds(390, 90, 80, 30);
						ta1.setBounds(30, 120, 320, 120);
						xianshi.setBounds(60, 260, 100, 30);
						re.setBounds(220, 260, 100, 30);
						sp.setBounds(30, 120, 320, 120);
						sp
								.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						sp
								.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
						panel.add(title);
						panel.add(start);
						panel.add(pause);
						panel.add(last);
						panel.add(next);
						panel.add(stop);
						panel.add(re);
						panel.add(sp);
						panel.add(xianshi);
						start.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("start", 2);
							}
						});
						pause.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("stop", 2);
							}
						});
						last.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("prev", 1);
							}
						});
						next.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("next", 2);
							}
						});
						stop.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("stop", 2);
							}
						});
						xianshi.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								/*
								 * int i=0; String m = null; String song1 =
								 * "data/song1"; ArrayList result = new
								 * ArrayList();
								 * 
								 * for(i=0;i<result.size();i++) { m=(String)
								 * result.get(i);
								 * 
								 * }
								 */
								ta1.setText(yuanwen1);
							}
						});
						re.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// myTest.invoke6("chushihu",1);
								listen.setVisible(false);
								myframe.setVisible(true);
							}
						});
						ta1.setText("   ");
						listen.add(panel);
						listen.setSize(400, 350);
						listen.setLocationRelativeTo(null);
						listen.setVisible(true);

					}
				});
				button3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String song1 = "Source/song3";

						yuanwen1 = myTest.invoke2("ly", song1);
						myTest.invoke6("xu", 2);
						frame6.setVisible(false);
						JPanel panel = new JPanel();
						panel.setLayout(null);
						// JLabel title = new
						// JLabel("Beyoncé-If I Were A Boy.wav");
						title.setText("Beyoncé-If I Were A Boy.wav");
						JButton start = new JButton("播放");
						JButton pause = new JButton("暂停");
						JButton last = new JButton("上一曲");
						JButton next = new JButton("下一曲");
						JButton stop = new JButton("停止");
						JButton re = new JButton("返回主界面");
						JButton xianshi = new JButton("显示原文");
						// final JTextArea ta1 = new JTextArea();
						ta1.setText("   ");
						JScrollPane sp = new JScrollPane(ta1);
						title.setBounds(100, 20, 200, 30);
						last.setBounds(20, 70, 80, 30);
						start.setBounds(120, 70, 70, 30);
						pause.setBounds(200, 70, 70, 30);
						next.setBounds(290, 70, 80, 30);
						stop.setBounds(390, 90, 80, 30);
						ta1.setBounds(30, 120, 320, 120);
						xianshi.setBounds(60, 260, 100, 30);
						re.setBounds(220, 260, 100, 30);
						sp.setBounds(30, 120, 320, 120);
						sp
								.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						sp
								.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
						panel.add(title);
						panel.add(start);
						panel.add(pause);
						panel.add(last);
						panel.add(next);
						panel.add(stop);
						panel.add(re);
						panel.add(sp);
						panel.add(xianshi);
						start.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("start", 3);
							}
						});
						pause.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("stop", 3);
							}
						});
						last.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("prev", 2);
							}
						});
						next.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("next", 3);
							}
						});
						stop.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("stop", 3);
							}
						});
						xianshi.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								/*
								 * int i=0; String m = null; String song1 =
								 * "data/song1"; ArrayList result = new
								 * ArrayList();
								 * 
								 * for(i=0;i<result.size();i++) { m=(String)
								 * result.get(i);
								 * 
								 * }
								 */
								ta1.setText(yuanwen1);
							}
						});
						re.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// myTest.invoke6("chushihu",1);
								listen.setVisible(false);
								myframe.setVisible(true);
							}
						});
						ta1.setText("   ");
						listen.add(panel);
						listen.setSize(400, 350);
						listen.setLocationRelativeTo(null);
						listen.setVisible(true);

					}
				});
				button4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String song1 = "Source/song4";

						yuanwen1 = myTest.invoke2("ly", song1);
						myTest.invoke6("xu", 3);
						frame6.setVisible(false);
						JPanel panel = new JPanel();
						panel.setLayout(null);
						// JLabel title = new
						// JLabel("Carly Rae Jepsen-I Really Like You.wav");
						title.setText("Carly Rae Jepsen-I Really Like You.wav");
						JButton start = new JButton("播放");
						JButton pause = new JButton("暂停");
						JButton last = new JButton("上一曲");
						JButton next = new JButton("下一曲");
						JButton stop = new JButton("停止");
						JButton re = new JButton("返回主界面");
						JButton xianshi = new JButton("显示原文");
						// final JTextArea ta1 = new JTextArea();
						ta1.setText("   ");
						JScrollPane sp = new JScrollPane(ta1);
						title.setBounds(100, 20, 200, 30);
						last.setBounds(20, 70, 80, 30);
						start.setBounds(120, 70, 70, 30);
						pause.setBounds(200, 70, 70, 30);
						next.setBounds(290, 70, 80, 30);
						stop.setBounds(390, 90, 80, 30);
						ta1.setBounds(30, 120, 320, 120);
						xianshi.setBounds(60, 260, 100, 30);
						re.setBounds(220, 260, 100, 30);
						sp.setBounds(30, 120, 320, 120);
						sp
								.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						sp
								.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
						panel.add(title);
						panel.add(start);
						panel.add(pause);
						panel.add(last);
						panel.add(next);
						panel.add(stop);
						panel.add(re);
						panel.add(sp);
						panel.add(xianshi);
						start.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("start", 1);
							}
						});
						pause.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("stop", 1);
							}
						});
						last.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("prev", 0);
							}
						});
						next.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("next", 1);
							}
						});
						stop.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("stop", 1);
							}
						});
						xianshi.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								/*
								 * int i=0; String m = null; String song1 =
								 * "data/song1"; ArrayList result = new
								 * ArrayList();
								 * 
								 * for(i=0;i<result.size();i++) { m=(String)
								 * result.get(i);
								 * 
								 * }
								 */
								ta1.setText(yuanwen1);
							}
						});
						re.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// myTest.invoke6("chushihu",1);
								listen.setVisible(false);
								myframe.setVisible(true);
							}
						});
						ta1.setText("   ");
						listen.add(panel);
						listen.setSize(400, 350);
						listen.setLocationRelativeTo(null);
						listen.setVisible(true);

					}
				});
				button5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String song1 = "Source/song5";

						yuanwen1 = myTest.invoke2("ly", song1);
						myTest.invoke6("xu", 4);
						frame6.setVisible(false);
						JPanel panel = new JPanel();
						panel.setLayout(null);
						// JLabel title = new
						// JLabel("Donna Lewis-I Could Be the One.wav");
						title.setText("Donna Lewis-I Could Be the One.wav");
						JButton start = new JButton("播放");
						JButton pause = new JButton("暂停");
						JButton last = new JButton("上一曲");
						JButton next = new JButton("下一曲");
						JButton stop = new JButton("停止");
						JButton re = new JButton("返回主界面");
						JButton xianshi = new JButton("显示原文");
						// final JTextArea ta1 = new JTextArea();
						ta1.setText("   ");
						JScrollPane sp = new JScrollPane(ta1);
						title.setBounds(100, 20, 200, 30);
						last.setBounds(20, 70, 80, 30);
						start.setBounds(120, 70, 70, 30);
						pause.setBounds(200, 70, 70, 30);
						next.setBounds(290, 70, 80, 30);
						stop.setBounds(390, 90, 80, 30);
						ta1.setBounds(30, 120, 320, 120);
						xianshi.setBounds(60, 260, 100, 30);
						re.setBounds(220, 260, 100, 30);
						sp.setBounds(30, 120, 320, 120);
						sp
								.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						sp
								.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
						panel.add(title);
						panel.add(start);
						panel.add(pause);
						panel.add(last);
						panel.add(next);
						panel.add(stop);
						panel.add(re);
						panel.add(sp);
						panel.add(xianshi);
						start.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("start", 1);
							}
						});
						pause.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("stop", 1);
							}
						});
						last.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("prev", 0);
							}
						});
						next.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("next", 1);
							}
						});
						stop.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("stop", 1);
							}
						});
						xianshi.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								/*
								 * int i=0; String m = null; String song1 =
								 * "data/song1"; ArrayList result = new
								 * ArrayList();
								 * 
								 * for(i=0;i<result.size();i++) { m=(String)
								 * result.get(i);
								 * 
								 * }
								 */
								ta1.setText(yuanwen1);
							}
						});
						re.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// myTest.invoke6("chushihu",1);
								ta1.setText("   ");
								listen.setVisible(false);
								myframe.setVisible(true);
							}
						});
						listen.add(panel);
						listen.setSize(400, 350);
						listen.setLocationRelativeTo(null);
						listen.setVisible(true);

					}
				});
				button6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String song1 = "Source/song6";

						yuanwen1 = myTest.invoke2("ly", song1);
						myTest.invoke6("xu", 5);
						frame6.setVisible(false);
						JPanel panel = new JPanel();
						panel.setLayout(null);
						// JLabel title = new
						// JLabel("Eminem - Lose Yourself.wav");
						title.setText("Eminem - Lose Yourself.wav");
						JButton start = new JButton("播放");
						JButton pause = new JButton("暂停");
						JButton last = new JButton("上一曲");
						JButton next = new JButton("下一曲");
						JButton stop = new JButton("停止");
						JButton re = new JButton("返回主界面");
						JButton xianshi = new JButton("显示原文");
						// final JTextArea ta1 = new JTextArea();

						JScrollPane sp = new JScrollPane(ta1);
						title.setBounds(100, 20, 200, 30);
						last.setBounds(20, 70, 80, 30);
						start.setBounds(120, 70, 70, 30);
						pause.setBounds(200, 70, 70, 30);
						next.setBounds(290, 70, 80, 30);
						stop.setBounds(390, 90, 80, 30);
						ta1.setBounds(30, 120, 320, 120);
						xianshi.setBounds(60, 260, 100, 30);
						re.setBounds(220, 260, 100, 30);
						sp.setBounds(30, 120, 320, 120);
						sp
								.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						sp
								.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
						panel.add(title);
						panel.add(start);
						panel.add(pause);
						panel.add(last);
						panel.add(next);
						panel.add(stop);
						panel.add(re);
						panel.add(sp);
						panel.add(xianshi);
						start.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("start", 1);
							}
						});
						pause.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("stop", 1);
							}
						});
						last.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("prev", 0);
							}
						});
						next.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("next", 1);
							}
						});
						stop.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// String m = null;
								myTest.invoke6("stop", 1);
							}
						});
						xianshi.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								/*
								 * int i=0; String m = null; String song1 =
								 * "data/song1"; ArrayList result = new
								 * ArrayList();
								 * 
								 * for(i=0;i<result.size();i++) { m=(String)
								 * result.get(i);
								 * 
								 * }
								 */
								ta1.setText(yuanwen1);
							}
						});
						re.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// myTest.invoke6("chushihu",1);
								ta1.setText("   ");
								listen.setVisible(false);
								myframe.setVisible(true);
							}
						});
						listen.add(panel);
						listen.setSize(400, 350);
						listen.setLocationRelativeTo(null);
						listen.setVisible(true);

					}
				});

				frame6.add(panel1);
				frame6.setSize(370, 320);
				frame6.setLocationRelativeTo(null);
				frame6.setVisible(true);
			}
		});
		// 其他
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		myframe.getContentPane().setBackground(new Color(197, 216, 222));
		myframe.add(panel);
		myframe.setSize(400, 300);
		myframe.setLocationRelativeTo(null);
		myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myframe.setVisible(true);

	}

	public static int GetNumber(int i) {
		// 数组
		int[] ary = new int[10];
		// 集合 ,临时集合temp存放1~10个数字
		ArrayList<Integer> temp = new ArrayList<Integer>();
		// list集合存放需要的数字
		ArrayList<Integer> list = new ArrayList<Integer>();
		// 给集合添加1~10的数字
		for (int i1 = 1; i1 < 11; i1++) {
			temp.add(i1);
		}
		// while循环 随即抽取集合的数字给数组
		int index = 0;
		while (true) {
			if (list.size() == 10) {
				break;
			}
			int it = temp.get((int) (Math.random() * 10));
			// 如果list存在这个数组就继续循环
			if (list.contains(it)) {
				continue;
			} else {
				// 如果list不存在这个数字，那么就把这个数字给数组，并且在list中加入这个数字
				ary[index] = it;
				list.add(it);
				index++;
			}
		}
		// /输出数组的元素
		return ary[i];
	}
}
