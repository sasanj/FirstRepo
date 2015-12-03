import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SimpleListWithModel extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = -6986710655595734041L;
	private static final String imagesPath = "resource/image/";
	private int current = -1; // this will force the fireCurrentChanged get
							 // Fired in prepareForm

	public int getCurrent() {
		return listNames.getSelectedIndex();
	}

	public void setCurrent(int current) {
		if (current >= 0 && this.current != current) {
			this.current = current;
			fireCurrentChanged(current);
		}
	}

	private void fireCurrentChanged(int current) {

		if (listNames.getSelectedIndex() != current) {
			listNames.setSelectedIndex(current);
		}
		txtCode.setText(String.valueOf(current));
		txtLastName.setText(listNames.getSelectedValue());
		
	}

	/*
	 * The following are needed to keep track of the form.
	 */
	private JTextField txtCode;
	private JTextField txtLastName;
	private JList<String> listNames;
	private JButton btnNext;
	private JButton btnPrev;
	private JScrollPane scpane;
	private DefaultListModel<String> model;

	/**
	 * prepares the form!
	 */
	private void prepareForm() {
		txtCode.setEditable(false);
		txtCode.setEnabled(false);
		
		model.addElement("Amiri");
		model.addElement("Shahani");
		
		listNames.addListSelectionListener(new ListSelectionListener() {
		       public void valueChanged(ListSelectionEvent e) {
		    	           setCurrent(getCurrent());
		    }
				
		});
		
		txtLastName.addActionListener(new ActionListener(){	
			   public void actionPerformed(ActionEvent e)  {
			    	   model.addElement(txtLastName.getText());
			    	   setCurrent(listNames.getMaxSelectionIndex()+1);
			    	   }
			   
		});
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setCurrent(getCurrent() + 1);
			}

		});
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setCurrent(getCurrent() - 1);
			}

		});
		setCurrent(0);
	}

	public SimpleListWithModel() {
		JPanel cPanel = new JPanel(new FlowLayout());
		JPanel wPanel = new JPanel(new FlowLayout());

		cPanel.setLayout(null);

		Image img = new ImageIcon(imagesPath + "icon.jpg").getImage();
		txtCode = new JTextField("-1", 20);
		txtLastName = new JTextField("Nothing", 20);

		btnNext = new JButton(null, new ImageIcon(imagesPath + "nxtrec.jpg"));
		btnPrev = new JButton(null, new ImageIcon(imagesPath + "prvrec.jpg"));
		btnNext.setToolTipText("Next");
		btnPrev.setToolTipText("Previous");
		JLabel lblCode = new JLabel("Code: ");
		JLabel lblLastName = new JLabel("Last Name: ");

		model=new DefaultListModel<String>();
		listNames = new JList<String>(model);
		listNames.setFixedCellWidth(150);
		listNames.setVisibleRowCount(4);
		listNames.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scpane=new JScrollPane(listNames);       

		JToolBar toolbar = new JToolBar();
		toolbar.add(btnNext);
		toolbar.addSeparator();
		toolbar.add(btnPrev);

		this.setTitle("FirstForm");
		this.setIconImage(img);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cPanel.add(txtCode);
		cPanel.add(txtLastName);
		cPanel.add(lblCode);
		cPanel.add(lblLastName);
		wPanel.add(scpane);

		this.add(cPanel, BorderLayout.CENTER);
		this.add(wPanel, BorderLayout.WEST);
		this.add(toolbar, BorderLayout.NORTH);

		txtCode.setBounds(200, 10, 100, 20);
		txtLastName.setBounds(200, 30, 100, 20);
		lblCode.setBounds(100, 10, 80, 20);
		lblLastName.setBounds(100, 30, 80, 20);
		prepareForm();
	}
	public static void main(String[] args) {
		SimpleListWithModel sampleObj = new SimpleListWithModel();
		sampleObj.pack();
		sampleObj.setVisible(true);
	}
}

/*class ListNamesModel extends AbstractListModel<String>
{
		
		 public ListNamesModel(int n)
		 { length = n; }
		 
	
		 public int getSize()
		 { return (); }
		 
	
		 public String getElementAt(int n)
		 {	 }
}*/
