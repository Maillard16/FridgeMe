package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import java.awt.Color;

import javax.swing.AbstractListModel;


import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PrincipaleFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel panel ;
	private JTabbedPane tabbedPane;
	private JPanel panel_6;
	private JButton btnOuvrirFrigo; 
	private JButton btnNewButton_3;
	private JList listFrigo;
	private JButton btnAceuilVoirRecette;
	private JComboBox comboBox;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_7;
	private JPanel panel_8;
	private JScrollPane scrollPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnFermerFrigo;
	private JList listHistorique;
	private JList listFavoris;
	private JMenu mnFichier;
	private JComboBox comboBox_1;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					PrincipaleFrame frame = new PrincipaleFrame();
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
	public PrincipaleFrame() {
		setTitle("Fridge Me");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 428);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(-1);
			}
		});
		mnFichier.add(mntmQuitter);
		
		JMenu mnEditer = new JMenu("Editer");
		menuBar.add(mnEditer);
		
		JMenuItem mntmParamtres = new JMenuItem("Param\u00E8tres");
		mntmParamtres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(5);
			}
		});
		
		JMenuItem mntmSupprimerHistorique = new JMenuItem("Supprimer historique");
		mnEditer.add(mntmSupprimerHistorique);
		mnEditer.add(mntmParamtres);
		
		JMenu mnAide = new JMenu("Aide");
		menuBar.add(mnAide);
		
		JMenuItem mntmPropos = new JMenuItem("\u00C0 propos");
		mntmPropos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
		mntmPropos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileReader aPropos = null;
				try {
					aPropos = new FileReader("./A propos.html");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				BufferedReader buffer = null;
				buffer = new BufferedReader(aPropos);
				String txtAPropos = "";
				String txtLu = null;
				
				JFrame popup = new JFrame();
				popup.setTitle("A propos");
				popup.setSize(320, 600);
				popup.show();
				
				JTextPane textPane = new JTextPane();
				textPane.setSize(320, 600);
				textPane.setEditable(false);				
			    textPane.setContentType("text/html");
			    
			    HTMLDocument doc = (HTMLDocument)textPane.getDocument();
			    HTMLEditorKit editorKit = (HTMLEditorKit)textPane.getEditorKit();
			    
				try {
					while((txtLu = buffer.readLine())!= null){
						txtAPropos += txtLu;
					}
					editorKit.insertHTML(doc, doc.getLength(),txtAPropos , 0, 0, null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				popup.getContentPane().add(textPane);
			}
		});
		mnAide.add(mntmPropos);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		panel = new JPanel();
		tabbedPane.addTab("Acceuil", null, panel, null);
		panel.setLayout(null);
		
		panel_6 = new JPanel();
		panel_6.setBounds(10, 11, 232, 316);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		btnOuvrirFrigo = new JButton("Ouvrir mon frigo");
		btnOuvrirFrigo.setBounds(49, 149, 129, 23);
		panel_6.add(btnOuvrirFrigo);
		
		listFrigo = new JList();
		listFrigo.setForeground(Color.BLACK);
		listFrigo.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Frigo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		listFrigo.setModel(new AbstractListModel() {
			String[] values = new String[] {"Tomate", "fromage", "c\u00E9lerie", "orange"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listFrigo.setBounds(10, 0, 212, 279);
		panel_6.add(listFrigo);
		
		btnFermerFrigo = new JButton("Fermer mon frigo");
		btnFermerFrigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listFrigo.hide();
				btnFermerFrigo.hide();
				btnOuvrirFrigo.show();
			}
		});
		btnFermerFrigo.setBounds(74, 287, 148, 23);
		btnFermerFrigo.hide();
		panel_6.add(btnFermerFrigo);
		listFrigo.hide();
		
		btnOuvrirFrigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listFrigo.show();
				btnOuvrirFrigo.hide();
				btnFermerFrigo.show();
			}
		});
		
		btnAceuilVoirRecette = new JButton("Voir cette recette");
		btnAceuilVoirRecette.setBounds(443, 297, 152, 23);
		panel.add(btnAceuilVoirRecette);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(541, 91, 171, -84);
		panel.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_15.setBounds(254, 6, 533, 284);
		panel.add(panel_15);
		panel_15.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 258, 271);
		panel_15.add(scrollPane);
		
		listFavoris = new JList();
		listFavoris.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				listHistorique.clearSelection();
			}
		});
		scrollPane.setViewportView(listFavoris);
		listFavoris.setModel(new AbstractListModel() {
			String[] values = new String[] {"recette favorite 1", "recette favorite 2", "recette favorite 3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listFavoris.setBorder(new TitledBorder(null, "Recettes Favorites", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(276, 6, 251, 272);
		panel_15.add(scrollPane_2);
		
		listHistorique = new JList();
		listHistorique.setModel(new AbstractListModel() {
			String[] values = new String[] {"recette historique 1", "recette historique 2", "recette historique 3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listHistorique.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				listFavoris.clearSelection();
			}
		});
		listHistorique.setBorder(new TitledBorder(null, "Historique", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		scrollPane_2.setViewportView(listHistorique);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Gestion frigo", null, panel_1, null);
		panel_1.setLayout(null);
		
		panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Ajouter un aliment", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				enableListeAliment(false);
				enableAjoutElement(true);
				panel_1.revalidate();
				panel_1.repaint();
			}
		});
	
		
		
		panel_7.setBounds(12, 11, 279, 156);
		panel_1.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(36, 35, 33, 14);
		panel_7.add(lblNom);
		
		textField = new JTextField();
		textField.setBounds(79, 32, 120, 20);
		panel_7.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Quantit\u00E9");
		lblNewLabel.setBounds(15, 71, 54, 14);
		panel_7.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(78, 68, 66, 20);
		panel_7.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUnit = new JLabel("Unit\u00E9");
		lblUnit.setBounds(30, 111, 39, 14);
		panel_7.add(lblUnit);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"g", "kg", "Pi\u00E8ces"}));
		comboBox.setBounds(78, 108, 83, 20);
		panel_7.add(comboBox);
		
		btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("./trouver-recherche-zoom-icone-3738-32.png"));
		btnNewButton_3.setBounds(219, 29, 33, 26);
		btnNewButton_3.setToolTipText("Rechercher dans la liste des aliments");
		
		panel_7.add(btnNewButton_3);
		
		panel_8 = new JPanel();
		panel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				enableListeAliment(true);
				enableAjoutElement(false);
				panel_1.revalidate();
				panel_1.repaint();
			}
		});
		panel_8.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Liste des aliments", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBounds(357, 11, 421, 245);
		panel_1.add(panel_8);
		panel_8.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(null);
		scrollPane_1.setBounds(10, 22, 401, 212);
		panel_8.add(scrollPane_1);
		
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				enableListeAliment(true);
				enableAjoutElement(false);
				
				panel_1.revalidate();
				panel_1.repaint();
				
			}
		});
		
		
		scrollPane_1.setViewportView(table);
		
		table.setModel(remplissageTableProduitFrigo());
		
		JButton btnNewButton_2 = new JButton("Annuler");
		btnNewButton_2.setBounds(175, 291, 95, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setBounds(366, 291, 143, 23);
		panel_1.add(btnEnregistrer);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Derni\u00E8re mise \u00E0 jour", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_9.setBounds(12, 178, 279, 80);
		panel_1.add(panel_9);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		panel_2 = new JPanel();
		tabbedPane.addTab("J'ai faim", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_10.setBounds(10, 11, 768, 47);
		panel_2.add(panel_10);
		panel_10.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("Recette rapide");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_4.setBounds(25, 11, 124, 23);
		panel_10.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Recette parmis favoris");
		btnNewButton_5.setBounds(285, 11, 168, 23);
		panel_10.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Modifier nbr personnes");
		btnNewButton_6.setBounds(585, 11, 173, 23);
		panel_10.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Voir la recette");
		btnNewButton_7.setBounds(515, 162, 139, 23);
		panel_2.add(btnNewButton_7);
		
		JList list_2 = new JList();
		list_2.setBorder(null);
		list_2.setBounds(224, 69, 237, 247);
		panel_2.add(list_2);
		
		panel_3 = new JPanel();
		tabbedPane.addTab("Planning repas", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBounds(12, 5, 110, 240);
		panel_3.add(panel_16);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBounds(136, 5, 110, 240);
		panel_3.add(panel_17);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBounds(258, 5, 110, 240);
		panel_3.add(panel_18);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBounds(380, 5, 110, 240);
		panel_3.add(panel_19);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBounds(502, 5, 110, 240);
		panel_3.add(panel_20);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBounds(624, 5, 110, 240);
		panel_3.add(panel_21);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBounds(747, 5, 110, 240);
		panel_3.add(panel_22);
		
		panel_5 = new JPanel();
		tabbedPane.addTab("Param\u00E8tres", null, panel_5, null);
		panel_5.setLayout(null);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_12.setBounds(10, 11, 215, 243);
		panel_5.add(panel_12);
		panel_12.setLayout(null);
		
		JLabel lblNombreDePersonne = new JLabel("Nombre de personne");
		lblNombreDePersonne.setBounds(10, 21, 125, 14);
		panel_12.add(lblNombreDePersonne);
		
		textField_5 = new JTextField();
		textField_5.setBounds(147, 18, 42, 20);
		textField_5.setText("1");
		panel_12.add(textField_5);
		textField_5.setColumns(10);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Default", "Bleu", "Jaune", "Vert"}));
		comboBox_1.setBounds(117, 73, 92, 26);
		panel_12.add(comboBox_1);
		
		JLabel lblCouleurInterface = new JLabel("Couleur Interface");
		lblCouleurInterface.setBounds(10, 78, 109, 16);
		panel_12.add(lblCouleurInterface);
		
		JButton btnNewButton_10 = new JButton("Enregistrer");
		btnNewButton_10.setBounds(31, 170, 158, 23);
		panel_12.add(btnNewButton_10);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(67, 200, 90, 20);
		panel_12.add(btnAnnuler);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnGestionRecettesFavoris = new JButton("Gestion recettes favoris");
		btnGestionRecettesFavoris.setBounds(246, 21, 166, 23);
		panel_5.add(btnGestionRecettesFavoris);
		
		JButton btnNewButton_9 = new JButton("Historique de recettes");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_9.setBounds(246, 134, 166, 23);
		panel_5.add(btnNewButton_9);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_13.setBounds(450, 11, 328, 243);
		panel_5.add(panel_13);
		panel_13.setLayout(null);
		
		JList list_4 = new JList();
		list_4.setBounds(21, 11, 285, 184);
		panel_13.add(list_4);
		
		JButton btnNewButton_11 = new JButton("Supprimer");
		btnNewButton_11.setBounds(60, 206, 89, 23);
		panel_13.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Visualiser");
		btnNewButton_12.setBounds(198, 206, 89, 23);
		panel_13.add(btnNewButton_12);
		
		JButton btnEffacerMonHistorique = new JButton("Effacer mon historique");
		btnEffacerMonHistorique.setBounds(249, 226, 163, 28);
		panel_5.add(btnEffacerMonHistorique);
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		panel_4 = new JPanel();
		tabbedPane.addTab("Rechercher recette", null, panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_11.setBounds(10, 11, 315, 305);
		panel_4.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblMotCl = new JLabel("Mot cl\u00E9");
		lblMotCl.setBounds(41, 40, 46, 14);
		panel_11.add(lblMotCl);
		
		textField_2 = new JTextField();
		textField_2.setBounds(113, 37, 166, 20);
		panel_11.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDureTotal = new JLabel("Dur\u00E9e total entre");
		lblDureTotal.setBounds(10, 93, 102, 14);
		panel_11.add(lblDureTotal);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(113, 90, 36, 20);
		panel_11.add(textField_3);
		
		JLabel lblEt = new JLabel("et");
		lblEt.setBounds(161, 93, 27, 14);
		panel_11.add(lblEt);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(201, 90, 36, 20);
		panel_11.add(textField_4);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setBounds(247, 93, 46, 14);
		panel_11.add(lblMin);
		
		JLabel lblIngrdient = new JLabel("Ingr\u00E9dient");
		lblIngrdient.setBounds(29, 151, 58, 14);
		panel_11.add(lblIngrdient);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(113, 151, 180, 70);
		panel_11.add(textArea);
		
		JButton btnNewButton_8 = new JButton("Rechercher");
		btnNewButton_8.setBounds(191, 250, 102, 23);
		panel_11.add(btnNewButton_8);
		
		JList list_3 = new JList();
		list_3.setBounds(386, 11, 250, 305);
		panel_4.add(list_3);
		
		JButton btnVoirLaRecette = new JButton("Voir la recette");
		btnVoirLaRecette.setBounds(646, 149, 116, 23);
		panel_4.add(btnVoirLaRecette);
		
		enableAjoutElement(false);
		
		
	
	}
	
	public DefaultTableModel remplissageTableProduitFrigo() {

        Vector<String> titre = new Vector<String>();
        titre.add("Nom");
        titre.add("Quantité ");
        titre.add("Unité");
        titre.add("Supprimer (quantité)");
        titre.add("Ajouter (quantité)");
        
        Vector<Object> matrice = new Vector<Object>();
        for(int i = 0; i < 10; i++){
        	Vector<Object> v= new Vector<Object>();
        	v.add("tomate");
        	v.add("500");
        	v.add("g");
        	
        	matrice.add(v);
        }
        
        DefaultTableModel mod = new DefaultTableModel(matrice, titre){       	
        	@Override
	        public boolean isCellEditable(int row, int columns) {
	            if(columns == 0 || columns == 1 || columns == 2){
	            	return false;
	            }
	            return true;
	        }
        };
        return mod;      
    }
	
	
	
	public void enableAjoutElement(boolean value){
		panel_7.enable(value);
		textField.enable(value);
		textField_1.enable(value);
		comboBox.enable(value);
		table.setEnabled(value);
	}
	
	
	public void enableListeAliment(boolean value){
		panel_8.enable(value);
		scrollPane.enable(value);
		table.setEnabled(value);	
		
	}
}

