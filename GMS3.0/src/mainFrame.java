import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * 
 * 作者：戴睿轩,GMS2.0
 * date 2012/12/29
 * 项目：运动会成绩查询系统
 * 实现：	1.查询功能
 * 		2.修改功能
 *      3.添加元祖
 *      4.增添功能优化
 *      5.对相关界面进行修改
 */
public class mainFrame 
{
	static Mframe GMS;
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			
			@Override
			public void run() 
			{
				// TODO Auto-generated method stub
				GMS=new Mframe();
				//qq.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//qq.setUndecorated(true);						// 去掉窗口的装饰 
				
				GMS.setVisible(true);
				
			}
		});
				
	}
}

class Mframe extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH=460;
	public static final int DEFAUL_HEIGHT=500;
	
	
	
	public tmenu Mmenu = new tmenu();
	public inpanel Minpanel = new inpanel();
	public outscroller Mtable = new outscroller();
	
	public int loginstate = 0;
	
	
	public Mframe()
	{
		setTitle("GMS v3.0");								//设置窗口名称
		setSize(DEFAULT_WIDTH,DEFAUL_HEIGHT);			//设置窗口大小
		setLocationByPlatform(true);					//由系统控制窗口位置
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit kit = Toolkit.getDefaultToolkit();
		//Dimension screensize =kit.getScreenSize();
		Image ime = kit.getImage("QQ.png");				//设置窗口图标
		setIconImage(ime);
		
		setLayout(null);
		setResizable(false);			//窗口大小不可改变
		
		
		
		setJMenuBar(Mmenu);
		add(Minpanel);		
		add(Mtable);
		
		
		
	}
	
	class tmenu extends JMenuBar implements ActionListener
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private JMenu menu1 = new JMenu("功能");
		private JMenu menu2 = new JMenu("关于");
		
		private JMenuItem i11 = new JMenuItem("登陆");
		private JMenuItem i12 = new JMenuItem("添加");
		private JMenuItem i13 = new JMenuItem("保存");
		private JMenuItem i14 = new JMenuItem("查询");
		
		private JMenu tables = new JMenu("数据表");
		
		private JMenuItem i21 = new JMenuItem("运动员");
		private JMenuItem i22 = new JMenuItem("比赛项目");
		private JMenuItem i23 = new JMenuItem("成绩");
		
		private JMenuItem i221 = new JMenuItem("帮助");
		private JMenuItem i222 = new JMenuItem("关于");
		
		public int tableselect = 1;
		
		public tmenu()
		{
			menu1.add(i11);
			menu1.add(i12);
			menu1.add(i13);
			menu1.add(i14);
			
			menu2.add(i221);
			menu2.add(i222);
			
			tables.add(i21);
			tables.add(i22);
			tables.add(i23);
			
			i11.addActionListener(this);
			i12.addActionListener(this);
			i14.addActionListener(this);
			i21.addActionListener(this);
			i22.addActionListener(this);
			i23.addActionListener(this);
			i221.addActionListener(this);
			i222.addActionListener(this);
			
			menu1.add(tables);
			
			
			
			add(menu1);
			add(menu2);
			
			
		}
		
		public void login()
		{
			
			new lgwindow();
			
		}
		
		class lgwindow extends JFrame
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			//private JPanel user,password;
			public static final int DEFAULT_WIDTH=340;
			public static final int DEFAUL_HEIGHT=180;
			
			
			private JLabel u = new JLabel("用户名:");
			private JLabel p = new JLabel("密    码:");
			
			private JButton ok = new JButton("登录");
			private JButton cancel = new JButton("取消");
			
			JTextField user = new JTextField(10);
			JPasswordField password = new JPasswordField(10);
			
			public lgwindow()
			{
				System.out.println("denglu");
				setTitle("用户登录");								//设置窗口名称
				setSize(DEFAULT_WIDTH,DEFAUL_HEIGHT);			//设置窗口大小
				Toolkit kit = Toolkit.getDefaultToolkit();
				Dimension screenSize = kit.getScreenSize();
				int w = screenSize.width;
				int h = screenSize.height;
				int x = (w - WIDTH) / 2-300;
				int y = (h - HEIGHT) / 2-100;
				setLocation(x, y); // 设置界面位置，此处设置为屏幕中央						//由系统控制窗口位置
				
				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				setLayout(new GridLayout(3, 1));
				setResizable(false);			//窗口大小不可改变
				
				
				
				JPanel up = new JPanel();
				up.add(u);
				up.add(user);
				JPanel m = new JPanel();
				m.add(p);
				m.add(password);
				JPanel d = new JPanel();
				d.add(ok);
				d.add(cancel);
				add(up);
				add(m);
				add(d);
				
				
				ok.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						if(user.getText().equals("dairuixuan")&&
								password.getText().equals("5253419"))
						{
							JOptionPane.showMessageDialog(null, 
									"登录成功！");
							lgwindow.this.dispose();
							Mframe.this.setTitle("GMS V3.0  已登录 ");
							Mframe.this.loginstate=1;
							
						}
						else
						{
							JOptionPane.showMessageDialog(null, 
									"用户名或密码错误");
							Mframe.this.loginstate=0;
						}
							
						
					}
				});
				
				cancel.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JOptionPane.showMessageDialog(null, 
								"登录取消");
						lgwindow.this.dispose();
						Mframe.this.loginstate=0;
					}
				});
				
				setVisible(true);
				
			}
						
		}
		
		class info extends JFrame
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			public static final int DEFAULT_WIDTH=340;
			public static final int DEFAUL_HEIGHT=200;
			
			private JLabel j1 = new JLabel("运动会成绩管理");
			private JLabel j2 = new JLabel("作者：戴睿轩");
			private JLabel j3 = new JLabel("Copyright 2012-2014");
			public info()
			{
				setTitle("关于");								//设置窗口名称
				setSize(DEFAULT_WIDTH,DEFAUL_HEIGHT);			//设置窗口大小
				Toolkit kit = Toolkit.getDefaultToolkit();
				Dimension screenSize = kit.getScreenSize();
				int w = screenSize.width;
				int h = screenSize.height;
				int x = (w - WIDTH) / 2-300;
				int y = (h - HEIGHT) / 2-100;
				setLocation(x, y); // 设置界面位置，此处设置为屏幕中央				//由系统控制窗口位置
				
				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				setLayout(new GridLayout(5, 1));
				setResizable(false);
				
				
				ImageIcon icon = new 
						//ImageIcon("G:\\project\\java\\GMS\\GMS3.0\\src\\pic\\1.jpg");
						ImageIcon(this.getClass().getResource("pic/2.jpg"));
				JLabel la = new JLabel(icon);
				la.setIcon(icon);
				add(la); 
				
				ImageIcon icon2 = new 
						//ImageIcon("G:\\project\\java\\GMS\\GMS3.0\\src\\pic\\1.jpg");
						ImageIcon(this.getClass().getResource("pic/3.jpg"));
				JLabel la2 = new JLabel(icon2);
				la2.setIcon(icon2);
				add(la2); 
				
				JPanel t1 = new JPanel();
				t1.add(j1);
				JPanel t2 = new JPanel();
				t2.add(j2);
				JPanel t3 = new JPanel();
				t3.add(j3);

				add(t1);
				add(t2);
				add(t3);
				setVisible(true);
				
			}
		}
	
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
				if (e.getSource() == i222) {
					new info();
					System.out.println("关于");
					
				}
				if (e.getSource() == i11) {
				
					System.out.println("i11");
					if(loginstate==0)
					login();
					else
						JOptionPane.showMessageDialog(null, 
								"你已登录");
				}
				if (e.getSource() == i12) {
					System.out.println("添加数据");
					if(loginstate==1)
					{
						if(Mtable.addst==0)
						{
							Mtable.adddata();
							Mtable.addst = 1;
						}
						else
						{
							JOptionPane.showMessageDialog(null,
								"请完成当前创建！");
						}
					}
					else
					JOptionPane.showMessageDialog(null,
							"对不起，你未登录，无法创建！");
				}
				if(e.getSource()== i21){
					
					if(Mtable.addst==0)
					{
					System.out.println("b1");
					Minpanel.updateIn(1);
					Mtable.updatetable(1);
					tableselect = 1;
					}
					else
					{
						JOptionPane.showMessageDialog(null, 
								"请完成当前添加的数据");
					}
					
				}
				if(e.getSource()== i22){
					if(Mtable.addst==0)
					{
					System.out.println("b2");
					Minpanel.updateIn(2);
					Mtable.updatetable(2);
					tableselect = 2;
					}
					else
					{
						JOptionPane.showMessageDialog(null, 
							"请完成当前添加的数据");
					}
				}
				if(e.getSource()== i23){
					if(Mtable.addst==0)
					{
					System.out.println("b3");
					Minpanel.updateIn(3);
					Mtable.updatetable(3);
					tableselect = 3;
					}
					else
					{
					JOptionPane.showMessageDialog(null, 
							"请完成当前添加的数据");
					}
				}
				if(e.getSource()== i14)
				{
					String temp = Minpanel.t1.getText();
					//System.out.println(temp);
					Mtable.searchtable(temp);
				}
			
			
		}
		
	}




	class inpanel extends JPanel implements ActionListener
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public static final int PANEL_WIDTH = 460;
		public static final int PANEL_HEIGHT = 150;
		public static final int PANEL_X = 0;
		public static final int PANEL_Y = 0;
		
		public String[] table1 = {"号码","姓名","年龄","身高",
		"体重"};
		public String[] table2 = {"项目编号","名称","时间","地点"};
		public String[] table3 = {"项目编号","项目名称","运动员号码","排名"};
		
		private JLabel l1 = new JLabel("查询");
		private JTextField t1 = new JTextField(10);
		private JButton j1 = new JButton("查询");
		//private JButton b2 = new JButton("添加数据");
		
		
		
		public JComboBox<?> jcombo;
		public int  sindex = 0;
		
		private String  srchitem = null;
		
		
		
		public inpanel()
		{
			setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
			setBackground(Color.GRAY);
			setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
			

			jcombo = new JComboBox<Object>(table1);
			jcombo.addActionListener(new iselect(jcombo));
			j1.addActionListener(this);
		//	b2.addActionListener(this);
			add(jcombo);
			add(l1);
			add(t1);
			add(j1);
			//add(b2);
			ImageIcon icon = new 
					//ImageIcon("G:\\project\\java\\GMS\\GMS3.0\\src\\pic\\1.jpg");
					ImageIcon(this.getClass().getResource("pic/1.jpg"));		
			JLabel la = new JLabel(icon);
			la.setIcon(icon);
			add(la); 
			
		}
		
		public void updateIn(int i)
		{
			removeAll();
			switch(i)
			{
			case 1:jcombo = new JComboBox<Object>(table1);break;
			case 2:jcombo = new JComboBox<Object>(table2);break;
			case 3:jcombo = new JComboBox<Object>(table3);break;
			
			}
			sindex=0;
			jcombo.addActionListener(new iselect(jcombo));
			add(jcombo);
			add(l1);
			add(t1);
			add(j1);
			//add(b2);
			ImageIcon icon = new 
				ImageIcon(this.getClass().getResource("pic/1.jpg"));		
			JLabel la = new JLabel(icon);
			la.setIcon(icon);
			add(la); 
			this.repaint();
			this.doLayout();

		}
		
		
		
		class iselect  implements ActionListener
		{
			private JComboBox<?> temp = null;		
			public iselect(JComboBox<?> j)
			{
				temp = j;
			}
			public void actionPerformed(ActionEvent e) 
			{
				srchitem = temp.getSelectedItem().toString();
				sindex = temp.getSelectedIndex();
				System.out.println(srchitem);	
			}
		}



		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			if (e.getSource() == j1) 
			{			
				String temp = t1.getText();
				System.out.println(t1.getText());
				Mtable.searchtable(temp);
				
			}
			/*if (e.getSource() == b2) 
			{	
				if(loginstate==1)
				{
					if(Mtable.addst==0)
					{
						Mtable.adddata();
						Mtable.addst = 1;
					}
					else
					{
						JOptionPane.showMessageDialog(null,
							"请完成当前创建！");
					}
				}
				else
				JOptionPane.showMessageDialog(null,
						"对不起，你未登录，无法创建！");	
			}*/
			
			
			
		}
	}
	
	class outscroller extends JPanel 
	{
		/**
		 * 2012/12/31 15:36
		 * 
		 * 1.数据更新，监听器
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public static final int PANEL_WIDTH = 455;
		public static final int PANEL_HEIGHT = 300;
		public static final int PANEL_X = 0;
		public static final int PANEL_Y = 152;
		
		private String [][] sqltable ={
				{"Ano","Aname","Aage","Aheight","Aweight"},
				{"Gno","Gname","Gtime","Gplace"},
				{"Gno","Gname","Ano","RANKS"}
				};
		private String [][] newrow ={
				{"请输入数据","请输入数据","请输入数据","请输入数据","请输入数据"},
				{"请输入数据","请输入数据","请输入数据","请输入数据"},
				{"请输入数据","请输入数据","请输入数据","请输入数据"}
				};
		private int [] okrow ={10,6,6};
		private String[] temp = null;
		private int[] drow;
		private int rows = 0;
		
		
		private String[] colum = Minpanel.table1;
		Object[][] data = null;
		Object[] cdata = null;
		int ccount = 0;
		
		int addst = 0;
		
		public JTable table = null;
		public DefaultTableModel model = null;
		
		
		public outscroller()
		{
			setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
			//js = new javaToSql();
			//setBackground(Color.magenta);
			
			
			cdata = new String[5];
			model = new DefaultTableModel(colum, 0);
			javaToSql.sqltable(model,1, cdata);
			model.addTableModelListener(new dtable());
			table = new JTable();
			table.setModel(model);
			table.setFillsViewportHeight(true);
			add(new JScrollPane(table));
		
			
		}
		
		public void adddata() 
		{
			// TODO Auto-generated method stub
			drow = new int[newrow[Mmenu.tableselect-1].length];
			temp = newrow[Mmenu.tableselect-1];
			model.addRow(temp);
			table = new JTable();
			table.setModel(model);
			table.setFillsViewportHeight(true);
			add(new JScrollPane(table));
			
			//cdata = new String[ccount];
			
			this.repaint();
			this.doLayout();
			
			
		}

		public void updatetable(int i)
		{
			removeAll();

			switch(i)
			{
			case 1: colum = Minpanel.table1;
				ccount = Minpanel.table1.length;break;
			case 2: colum = Minpanel.table2;
				ccount = Minpanel.table2.length;break;
			case 3: colum = Minpanel.table3;
				ccount = Minpanel.table3.length;break;
			default: colum = Minpanel.table1;
				ccount = Minpanel.table1.length;break;
			}
			model = new DefaultTableModel(colum, 0);
			cdata = new String[ccount];
			javaToSql.sqltable(model,i, cdata);
			table = new JTable();
			model.addTableModelListener(new dtable());
			table.setModel(model);
			table.setFillsViewportHeight(true);
			add(new JScrollPane(table));
			
			//cdata = new String[ccount];
			
			this.repaint();
			this.doLayout();
			
		}
		public void searchtable(String srcstr)
		{
			removeAll();
			//js = new javaToSql();
			switch(Mmenu.tableselect)
			{
			case 1: colum = Minpanel.table1;
				ccount = Minpanel.table1.length;break;
			case 2: colum = Minpanel.table2;
				ccount = Minpanel.table2.length;break;
			case 3: colum = Minpanel.table3;
				ccount = Minpanel.table3.length;break;
			default: colum = Minpanel.table1;
				ccount = Minpanel.table1.length;break;
			}
			model = new DefaultTableModel(colum, 0);
			cdata = new String[ccount];			
			javaToSql.srctable(Mmenu.tableselect,srcstr,
					sqltable[Mmenu.tableselect-1][Minpanel.sindex],
					model,cdata);
			model.addTableModelListener(new dtable());
			table = new JTable();
			table.setModel(model);
			table.setFillsViewportHeight(true);
			add(new JScrollPane(table));
						
			this.repaint();
			this.doLayout();
		}
		
		public void updatedata(String c1,String c2,
				String data,String colname)
		{
			if(loginstate==1)
				javaToSql.update(c1,c2,data,colname,Mmenu.tableselect);
			else
				JOptionPane.showMessageDialog(null,
						"对不起你未登录，无法更新数据！");
			
		}
		
		
		
		
		
		
		
		class dtable implements TableModelListener
		{
			/**
			 * 
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			@Override
			public void tableChanged(TableModelEvent e)
			{
				// TODO Auto-generated method stub
				int row = e.getFirstRow();  
			    int column = e.getColumn();
				
			    
			    if(column!=-1)
			    {
			    	if((addst == 0 || row!=(model.getRowCount()-1)))
					{ 
					    TableModel model = (TableModel)e.getSource();
					    String columnName = javaToSql.
					    		 sqltables[Mmenu.tableselect-1][column];
					    Object data = model.getValueAt(row, column);
					     
					    String c1 = (String) model.getValueAt(row, 0);
					    String c2 = (String) model.getValueAt(row, 1);
					     
					     
					    Mtable.updatedata(c1, c2, (String) data, columnName);
					}
					else
					{
						//rows += column;
						System.out.print(column+"\t");
						drow[column] = 1;
						boolean flag = true;
						
						for(int j = 0;j<newrow[Mmenu.tableselect-1].length;j++)
						{
							if(drow[j]!=1) flag = false;
						}
						
						
						if(flag)
						//if(rows == okrow[Mmenu.tableselect-1])
						{
							if(Mmenu.tableselect==1)
							{
								javaToSql.adddata(model.getValueAt(row, 0),
									model.getValueAt(row, 1),
									model.getValueAt(row, 2),
									model.getValueAt(row, 3),
									model.getValueAt(row, 4),
									Mmenu.tableselect);
								Mtable.updatetable(Mmenu.tableselect);
							}
							else
							{
								javaToSql.adddata(model.getValueAt(row, 0),
										model.getValueAt(row, 1),
										model.getValueAt(row, 2),
										model.getValueAt(row, 3),
										Mmenu.tableselect);
								Mtable.updatetable(Mmenu.tableselect);
							}
							addst = 0;
							rows = 0;
						}
						
					}
			    	
			    }
			     
			     
				
			}
		}

	}
	
	

		

}




