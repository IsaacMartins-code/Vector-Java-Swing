package vetoreswing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultListModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class VetoresSwing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VetoresSwing frame = new VetoresSwing();
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
	public VetoresSwing() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner.setBounds(10, 11, 59, 34);
		contentPane.add(spinner);
		
		JLabel jlabel = new JLabel("");
		jlabel.setBounds(246, 31, 105, 14);
		contentPane.add(jlabel);

		JList<Integer> list = new JList<Integer>();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				String text =  Integer.toString(list.getSelectedIndex());
				jlabel.setText("Vetor["+ text + "]");
				
			}
		});
		list.setBounds(246, 60, 105, 183);
		contentPane.add(list);
		
		int vet[] = new int[10];
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				DefaultListModel lista = new DefaultListModel();

				for(int c = 0; c<vet.length; c++) {

					String v = ( "vet[" + c + "] ->" + vet[c]);

					lista.addElement(v);
				}
				
				list.setModel(lista);
			}
		});
		
		JButton btnAdd = new JButton("Adicionar");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int spin =  (int) spinner.getValue();
				int selec = list.getSelectedIndex();
				vet[selec] = spin;
				
				DefaultListModel lista = new DefaultListModel();
				
				for(int c = 0; c<vet.length; c++) {
					
					String v = ("vet[" + c + "] ->" + vet[c]);
					lista.addElement(v);
				
				}
				
				list.setModel(lista);
				
				String text = Integer.toString(selec);
				jlabel.setText("Vetor["+ text + "]");
			}
		});
		btnAdd.setBounds(106, 14, 97, 29);
		contentPane.add(btnAdd);
		
		JButton btnRemov = new JButton("Remover");
		btnRemov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selec = list.getSelectedIndex();
				int i = vet[selec] = 0;
				
				DefaultListModel lista = new DefaultListModel();

				for(int c = 0; c<vet.length; c++) {

					String v = ("vet[" + c + "] ->" + vet[c]);
					lista.addElement(v);
				}

				lista.addElement(i);
				list.setModel(lista);
				
				String text = Integer.toString(selec);
				jlabel.setText("Vetor["+ text + "]");
			}
		});
		btnRemov.setBounds(106, 54, 97, 29);
		contentPane.add(btnRemov);
		
		JButton btnOrd = new JButton("Ordenar");
		btnOrd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Arrays.sort(vet);
				
				DefaultListModel lista = new DefaultListModel();
				
				for(int c = 0; c<vet.length; c++) {

					String v = ("vet[" + c + "] ->" + vet[c]);
					lista.addElement(v);
				}
				
				list.setModel(lista);
				
			}
		});
		btnOrd.setBounds(106, 94, 97, 29);
		contentPane.add(btnOrd);
	}
}
