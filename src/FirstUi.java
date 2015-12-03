import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FirstUi extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = -6986710655595734041L;
	private static final String imagesPath = "resource/image/";
	private String names[] = { "Leila" , "Maryam" , "Sharareh" , "Ziba" };
	private String lastNames[]={ "Hoseini", "Yousefi", "Bay" , "Abdolahi" };
	private int current = -1; // this will force the fireCurrentChanged get
							 // Fired in prepareForm

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		if (current >= 0 && this.current != current) {
			int last = this.current;
			this.current = current;
			fireCurrentChanged(current, last);
		}
	}

	private void fireCurrentChanged(int current, int last) {
		if (cmbNames.getSelectedIndex() != current) {
			cmbNames.setSelectedIndex(current);
		}
		if (lstNames.getSelectedIndex() != current) {
			lstNames.setSelectedIndex(current);
		}
		txtCode.setText(String.valueOf(current));
		txtName.setText(names[current]);
		txtLastName.setText(lastNames[current]);
		
	}

	/*
	 * The following are needed to keep track of the form.
	 */
	private JTextField txtCode;
	private JTextField txtName;
	private JTextField txtLastName;
	private JComboBox<String> cmbNames;
	private JList<String> lstNames;
	private JButton btnNext;
	private JButton btnPrev;
	private JScrollPane scpane;

	/**
	 * prepares the form!
	 */
	private void prepareForm() {
		txtCode.setEditable(false);
		txtCode.setEnabled(false);
		for (int x = 0; x < names.length; x++) {
			cmbNames.addItem(names[x]);
		}
		cmbNames.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setCurrent(cmbNames.getSelectedIndex());
			}

		});
		lstNames.addListSelectionListener(new ListSelectionListener() {
		       public void valueChanged(ListSelectionEvent e) {
		    	       setCurrent(lstNames.getSelectedIndex());
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

	public FirstUi() {
		JPanel cPanel = new JPanel(new FlowLayout());
		JPanel wPanel = new JPanel(new FlowLayout());
		// GridBagLayout layout = new GridBagLayout();

		cPanel.setLayout(null);

		Image img = new ImageIcon(imagesPath + "icon.jpg").getImage();
		txtCode = new JTextField("-1", 20);
		txtName = new JTextField("Nothing", 20);
		txtLastName = new JTextField("Nothing", 20);

		btnNext = new JButton(null, new ImageIcon(imagesPath + "nxtrec.jpg"));
		btnPrev = new JButton(null, new ImageIcon(imagesPath + "prvrec.jpg"));
		btnNext.setToolTipText("Next");
		btnPrev.setToolTipText("Previous");
		JLabel lblCode = new JLabel("Code: ");
		JLabel lblName = new JLabel("First Name: ");
		JLabel lblLastName = new JLabel("Last Name: ");

		cmbNames = new JComboBox<String>();
		lstNames = new JList<String>(lastNames);
		lstNames.setVisibleRowCount(3);
		lstNames.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                scpane=new JScrollPane(lstNames);

		JToolBar toolbar = new JToolBar();
		toolbar.add(btnNext);
		toolbar.addSeparator();
		toolbar.add(btnPrev);

		this.setTitle("FirstForm");
		this.setIconImage(img);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cPanel.add(txtCode);
		cPanel.add(txtName);
		cPanel.add(txtLastName);
		cPanel.add(lblCode);
		cPanel.add(lblName);
		cPanel.add(lblLastName);
		wPanel.add(cmbNames);
		wPanel.add(scpane);

		this.add(cPanel, BorderLayout.CENTER);
		this.add(wPanel, BorderLayout.WEST);
		this.add(toolbar, BorderLayout.NORTH);

		txtCode.setBounds(200, 10, 100, 20);
		txtName.setBounds(200, 30, 100, 20);
		txtLastName.setBounds(200, 50, 100, 20);
		lblCode.setBounds(100, 10, 80, 20);
		lblName.setBounds(100, 30, 80, 20);
		lblLastName.setBounds(100, 50, 80, 20);
		prepareForm();
	}
	public static void main(String[] args) {
		FirstUi firstUI = new FirstUi();
		firstUI.pack();

		firstUI.setVisible(true);
		//firstUI.setCurrent(2);
	}
}
