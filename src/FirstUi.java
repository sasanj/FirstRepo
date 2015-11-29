import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstUi extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = -6986710655595734041L;
	private static final String imagesPath = "resource/image/";
	private String names[] = { "Mrs Hoseini", "Ms Yousefi", "Mrs Bay" , "Mrs Abdolahi" };
	private int current = -1; // this will force the fireCurrentChanged get
							 // Fired in prepareForm

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		if (current >= 0 && current < names.length && this.current != current) {
			int last = this.current;
			this.current = current;
			fireCurrentChanged(current, last);
		}
	}

	private void fireCurrentChanged(int current, int last) {
		if (cmbNames.getSelectedIndex() != current) {
			cmbNames.setSelectedIndex(current);
		}
		txtCode.setText(String.valueOf(current));
		txtDesc.setText(names[current]);
	}

	/*
	 * The following are needed to keep track of the form.
	 */
	private JTextField txtCode;
	private JTextField txtDesc;
	private JComboBox<String> cmbNames;
	private JList<String> lstNames;
	private JButton btnNext;
	private JButton btnPrev;

	public static void main(String[] args) {
		FirstUi firstUI = new FirstUi();
		firstUI.pack();

		firstUI.setVisible(true);
		firstUI.setCurrent(2);
	}

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
		txtDesc = new JTextField("Nothing", 20);

		btnNext = new JButton(null, new ImageIcon(imagesPath + "nxtrec.jpg"));
		btnPrev = new JButton(null, new ImageIcon(imagesPath + "prvrec.jpg"));
		btnNext.setToolTipText("Next");
		btnPrev.setToolTipText("Previous");
		JLabel lblCode = new JLabel("Code: ");
		JLabel lblDesc = new JLabel("Description: ");

		cmbNames = new JComboBox<String>();
		lstNames = new JList<String>();

		JToolBar toolbar = new JToolBar();
		toolbar.add(btnNext);
		toolbar.addSeparator();
		toolbar.add(btnPrev);

		this.setTitle("FirstForm");
		this.setIconImage(img);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cPanel.add(txtCode);
		cPanel.add(txtDesc);
		cPanel.add(lblCode);
		cPanel.add(lblDesc);
		wPanel.add(cmbNames);
		wPanel.add(lstNames);

		this.add(cPanel, BorderLayout.CENTER);
		this.add(wPanel, BorderLayout.WEST);
		this.add(toolbar, BorderLayout.NORTH);

		txtCode.setBounds(200, 10, 100, 20);
		txtDesc.setBounds(200, 30, 100, 20);
		lblCode.setBounds(100, 10, 80, 20);
		lblDesc.setBounds(100, 30, 80, 20);
		prepareForm();
	}
}
