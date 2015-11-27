	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class FirstUi {
		public static void main(String[] args)
		{
			FirstUi smplObject=new FirstUi();
			smplObject.SimpleUi();
		}

		public void SimpleUi() {
			JFrame frame=new JFrame();
			JPanel cPanel=new JPanel(new FlowLayout());
			JPanel wPanel=new JPanel(new FlowLayout());
			
			//GridBagLayout layout = new GridBagLayout();
			
			cPanel.setLayout(null);
			
			Image img = new ImageIcon("icon.jpg").getImage();
			JTextField cod =new JTextField("'Code here'", 20);
			JTextField desc =new JTextField("'Desc here'", 20);
			
			JButton nextbutton=new JButton(null, new ImageIcon("nxtrec.jpg"));
			JButton backbutton=new JButton(null, new ImageIcon("prvrec.jpg"));
			nextbutton.setToolTipText("Next");
			backbutton.setToolTipText("Previous");
			JLabel codelabel = new JLabel("Code: ");
			JLabel desclabel = new JLabel("Description: ");
			
			
			JComboBox<String> dataList=new JComboBox<>();
			dataList.addItem("Mrs Hoseini");
			dataList.addItem("Ms Yousefi");
			dataList.addItem("Mrs Bay");
		
			
			JToolBar toolbar = new JToolBar();
			toolbar.add(nextbutton);
			toolbar.addSeparator();
			toolbar.add(backbutton);
				
				
			frame.setBounds(30, 30, 600, 500);
			frame.setTitle("FirstForm");
			frame.setIconImage(img);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
			
			
			frame.add(cPanel, BorderLayout.CENTER);
			frame.add(wPanel, BorderLayout.WEST);
			frame.add(toolbar, BorderLayout.NORTH);
			

			cPanel.add(cod );
			cPanel.add(desc);
			cPanel.add(codelabel);
			cPanel.add(desclabel);
			wPanel.add(dataList);
			
			cod.setBounds(200, 10, 100, 20);
			desc.setBounds(200, 30, 100, 20);
			codelabel.setBounds(100, 10, 80, 20);
			desclabel.setBounds(100, 30, 80, 20);

			
			 dataList.addActionListener(new ActionListener()
					 {
					 public void actionPerformed(ActionEvent e)
					   {
			
						 if (dataList.getSelectedItem() == "Mrs Hoseini") 
						 {
							 cod.setText("1");
							 desc.setText("Mrs Hoseini");
							 }
							 
						 else if (dataList.getSelectedItem() == "Ms Yousefi")
						 {
							 cod.setText("2");
							 desc.setText("Ms Yousefi");
						 }
							 
						 else if (dataList.getSelectedItem() == "Mrs Bay")
						 {
							 cod.setText("3");
							 desc.setText("Mrs Bay"); 
						 }	 
					   }
					 });
			 
			 
			 
			 nextbutton.addActionListener(new ActionListener()
			 {
			 public void actionPerformed(ActionEvent e)
			   {

				 if (dataList.getSelectedItem() == "Mrs Hoseini") 
				 {   
					 dataList.setSelectedItem("Ms Yousefi");
					 cod.setText("2");
					 desc.setText("Ms Yousefi");
					 }
					 
				 else if (dataList.getSelectedItem() == "Ms Yousefi")
				 {
					 dataList.setSelectedItem("Mrs Bay");
					 cod.setText("3");
					 desc.setText("Mrs Bay");
				 }
					 
				 else if (dataList.getSelectedItem() == "Mrs Bay")
				 {
					 dataList.setSelectedItem("Mrs Hoseini");
					 cod.setText("1");
					 desc.setText("Mrs Hoseini"); 
				 }	 
			   }
			 }); 
			
			 
			 backbutton.addActionListener(new ActionListener()
			 {
			 public void actionPerformed(ActionEvent e)
			   {

				 if (dataList.getSelectedItem() == "Mrs Hoseini") 
				 {   
					 dataList.setSelectedItem("Mrs Bay");
					 cod.setText("3");
					 desc.setText("Mrs Bay");
					 }
					 
				 else if (dataList.getSelectedItem() == "Ms Yousefi")
				 {
					 dataList.setSelectedItem("Mrs Hoseini");
					 cod.setText("1");
					 desc.setText("Mrs Hoseini");
				 }
					 
				 else if (dataList.getSelectedItem() == "Mrs Bay")
				 {
					 dataList.setSelectedItem("Ms Yousefi");
					 cod.setText("2");
					 desc.setText("Mrs Yousefi"); 
				 }	 
			   }
			 });
			 
		frame.setVisible(true);	 
		}
	
	}


