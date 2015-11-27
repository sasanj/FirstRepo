import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.*;
import java.awt.*;
import java.awt.event.*;


public class FirstUi2 {

	 //Ui Components are Here
	 JFrame frmMain=new JFrame();
	 JPanel panCentral=new JPanel(new FlowLayout());
	 JPanel panWest=new JPanel(new FlowLayout());
	 
	 JTextField txtCod ;
	 JTextField txtDesc ;
		
	 JButton butNext;
	 JButton butBack;
	 JButton butInsert;
	 
	 JLabel lblCod ;
	 JLabel lblDesc;
	 
	 JToolBar toolbar = new JToolBar();
	 
	 ArrayList<String> codeList;	
	 ArrayList<String> descList;
		
	 DefaultListModel<String> listModel ;
	 JList<String> lstDesc=new JList<String>();

	 
     //SimpleUi Method For Create Ui
	 public void SimpleUi() {
		
		txtCod =new JTextField("'txtCode here'", 20);
		txtDesc =new JTextField("'txtDesc here'", 20);
			
		butNext=new JButton(null, new ImageIcon("resource/nxtrec.jpg"));
		butBack=new JButton(null, new ImageIcon("resource/prvrec.jpg"));
		butInsert=new JButton("Insert Into List");
		 
		butNext.setToolTipText("Next");
		butBack.setToolTipText("Previous");
		lblCod = new JLabel("txtCode: ");
		lblDesc = new JLabel("txtDescription: ");
		
		toolbar.add(butNext);
		toolbar.addSeparator();
		toolbar.add(butBack);
		
		frmMain.setBounds(30, 30, 600, 500);
		frmMain.setTitle("FirstForm");
		frmMain.setIconImage(new ImageIcon("resource/icon.jpg").getImage());
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		
		
		frmMain.add(panCentral, BorderLayout.CENTER);
		frmMain.add(panWest, BorderLayout.WEST);
		frmMain.add(toolbar, BorderLayout.NORTH);
		
		panCentral.setLayout(null);
		panCentral.add(txtCod );
		panCentral.add(txtDesc);
		panCentral.add(lblCod);
		panCentral.add(lblDesc);
		panCentral.add(butInsert);
		
		txtCod.setBounds(200, 10, 100, 20);
		txtDesc.setBounds(200, 30, 100, 20);
		lblCod.setBounds(100, 10, 80, 20);
		lblDesc.setBounds(100, 30, 80, 20);
		butInsert.setBounds(200, 50, 150, 20);
		
		codeList= new ArrayList<>(10);	
		descList= new ArrayList<>(10);
		
		
		// Save TextItems Values In Lists and Show on the Form
		 butInsert.addActionListener(new ActionListener()
		 {
		 public void actionPerformed(ActionEvent e)
		   { 
			
			 if (txtCod.getText() != null){
			      codeList.add(txtCod.getText());
			 }
			 
			if (txtDesc.getText() != null){
			      descList.add(txtDesc.getText());
			 }
			
			
			 listModel=new DefaultListModel<String>();
			 
			for (String dscInst : descList){
				listModel.addElement(dscInst.toString());
			}
			
			lstDesc.setModel(listModel);
			lstDesc.setLayoutOrientation(JList.VERTICAL);
			lstDesc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			//JScrollPane listScrollPane = new JScrollPane(lstDesc);  My JScrollPane Didn't work ????
			//panWest.add(listScrollPane, BorderLayout.WEST);
		    panWest.add( lstDesc , BorderLayout.WEST);
		   }
		 });
		 
	
         //Fill txtDesc when selecting a List item
		 lstDesc.addListSelectionListener(new ListSelectionListener()
		 {
			 public void valueChanged(ListSelectionEvent e)
			 {
				// txtCod.setText();  i have to use two dimensional array list and JList ?????
				 txtDesc.setText(lstDesc.getSelectedValue());
			 }
		  });
		  
	     frmMain.setVisible(true);	 
	 }
	
	 
	//main Method is here
	public static void main(String[] args)
	{
		FirstUi2 uiObj=new FirstUi2();
		uiObj.SimpleUi();
	}

}
		 


