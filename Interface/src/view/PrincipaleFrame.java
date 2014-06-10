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
import java.util.LinkedList;
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
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.KeyStroke;

import ctrl.AlimentCtrl;
import ctrl.RecetteCtrl;
import ctrl.UniteCtrl;
import bo.*;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.SwingConstants;

public class PrincipaleFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableAlimentFrigo;
	private JTextField textFieldNomAjouterAliment;
	private JTextField textFieldQuantiteAjouterAliment;
	private JPanel panelAcceuil ;
	private JTabbedPane tabbedPaneMain;
	private JPanel panelFrigoAcceuil;
	private JButton btnOuvrirFrigo; 
	private JButton btnNomAjouterAliment;
	private JList listFrigo;
	private JButton btnAceuilVoirRecette;
	private JComboBox comboBoxUniteAjoutAliment;
	private JPanel panelFrigo;
	private JPanel panelJaiFaim;
	private JPanel panelPlanning;
	private JPanel panelRecherche;
	private JPanel panelParametres;
	private JPanel panelAjouterAlimentFrigo;
	private JPanel panelListeAlimentFrigo;
	private JScrollPane scrollPaneFavorisAcceuil;
	private JTextField textFieldMotCleRecherche;
	private JTextField textFieldDureeMinRecherche;
	private JTextField textFieldDureeMaxRecherche;
	private JTextField textFieldNbPersonneParametre;
	private JButton btnFermerFrigo;
	private JList listHistorique;
	private JList listFavoris;
	private JMenu mnFichier;
	private JComboBox comboBoxCouleurParametre;
	
	private JScrollPane scrollPaneListeAlimentFrigo;
	
	private JList<String> listJaiFaim;
	private JTextField textFieldNbRecetteJaiFaim;
	
	
//	private LinkedList<Aliment> aliments;
//	private LinkedList<Categorie> categories;
//	private LinkedList<HeureRepas> heuresrepas;
//	private LinkedList<Recette> recettes;
//	private LinkedList<RecetteAliment> recettesAliments;
//	private LinkedList<Repas> repas;
//	private LinkedList<SousCategorie> sousCategories;
//	private LinkedList<TypeRecette> typesRecette;
//	private LinkedList<Unite> unites;
	

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
		initialize();
	}


	private void initialize() {
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
				tabbedPaneMain.setSelectedIndex(5);
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
		
		tabbedPaneMain = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPaneMain, BorderLayout.CENTER);
		
		panelAcceuil = new JPanel();
		tabbedPaneMain.addTab("Acceuil", null, panelAcceuil, null);
		panelAcceuil.setLayout(null);
		
		panelFrigoAcceuil = new JPanel();
		panelFrigoAcceuil.setBounds(10, 11, 232, 316);
		panelAcceuil.add(panelFrigoAcceuil);
		panelFrigoAcceuil.setLayout(null);
		
		btnOuvrirFrigo = new JButton("Ouvrir mon frigo");
		btnOuvrirFrigo.setBounds(49, 149, 129, 23);
		panelFrigoAcceuil.add(btnOuvrirFrigo);
		
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
		panelFrigoAcceuil.add(listFrigo);
		
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
		panelFrigoAcceuil.add(btnFermerFrigo);
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
		panelAcceuil.add(btnAceuilVoirRecette);
		
		JPanel panelRecetteAcceuil = new JPanel();
		panelRecetteAcceuil.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRecetteAcceuil.setBounds(254, 6, 533, 284);
		panelAcceuil.add(panelRecetteAcceuil);
		panelRecetteAcceuil.setLayout(null);
		
		scrollPaneFavorisAcceuil = new JScrollPane();
		scrollPaneFavorisAcceuil.setBounds(6, 6, 258, 271);
		panelRecetteAcceuil.add(scrollPaneFavorisAcceuil);
		
		listFavoris = new JList();
		listFavoris.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				listHistorique.clearSelection();
			}
		});
		scrollPaneFavorisAcceuil.setViewportView(listFavoris);
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
		
		JScrollPane scrollPaneHistoriqueAcceuil = new JScrollPane();
		scrollPaneHistoriqueAcceuil.setBounds(276, 6, 251, 272);
		panelRecetteAcceuil.add(scrollPaneHistoriqueAcceuil);
		
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
		scrollPaneHistoriqueAcceuil.setViewportView(listHistorique);
		
		panelFrigo = new JPanel();
		tabbedPaneMain.addTab("Gestion frigo", null, panelFrigo, null);
		panelFrigo.setLayout(null);
		
		panelAjouterAlimentFrigo = new JPanel();
		panelAjouterAlimentFrigo.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Ajouter un aliment", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAjouterAlimentFrigo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				enableListeAliment(false);
				enableAjoutElement(true);
				panelFrigo.revalidate();
				panelFrigo.repaint();
			}
		});
	
		
		
		panelAjouterAlimentFrigo.setBounds(12, 11, 279, 156);
		panelFrigo.add(panelAjouterAlimentFrigo);
		panelAjouterAlimentFrigo.setLayout(null);
		
		JLabel lblNomAjouterAliment = new JLabel("Nom");
		lblNomAjouterAliment.setBounds(36, 35, 33, 14);
		panelAjouterAlimentFrigo.add(lblNomAjouterAliment);
		
		textFieldNomAjouterAliment = new JTextField();
		textFieldNomAjouterAliment.setBounds(79, 32, 120, 20);
		panelAjouterAlimentFrigo.add(textFieldNomAjouterAliment);
		textFieldNomAjouterAliment.setColumns(10);
		
		JLabel lblQuantiteAjouterAliment = new JLabel("Quantit\u00E9");
		lblQuantiteAjouterAliment.setBounds(15, 71, 54, 14);
		panelAjouterAlimentFrigo.add(lblQuantiteAjouterAliment);
		
		textFieldQuantiteAjouterAliment = new JTextField();
		textFieldQuantiteAjouterAliment.setBounds(78, 68, 66, 20);
		panelAjouterAlimentFrigo.add(textFieldQuantiteAjouterAliment);
		textFieldQuantiteAjouterAliment.setColumns(10);
		
		JLabel lblUniteAjouterAliment = new JLabel("Unit\u00E9");
		lblUniteAjouterAliment.setBounds(30, 111, 39, 14);
		panelAjouterAlimentFrigo.add(lblUniteAjouterAliment);
		
		comboBoxUniteAjoutAliment = new JComboBox();
		//comboBoxUniteAjoutAliment.setModel(new DefaultComboBoxModel(new String[] {"g", "kg", "Pi\u00E8ces"}));
		UniteCtrl.setUniteList(comboBoxUniteAjoutAliment);
		comboBoxUniteAjoutAliment.setBounds(78, 108, 83, 20);
		panelAjouterAlimentFrigo.add(comboBoxUniteAjoutAliment);
		
		btnNomAjouterAliment = new JButton("");
		btnNomAjouterAliment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String recherche = AlimentCtrl.getAlimentName(textFieldNomAjouterAliment.getText());
				if (recherche == null) {
					JOptionPane.showMessageDialog(null,
							"Aucun aliment trouvé avec '" + textFieldNomAjouterAliment.getText() + "'");
				} else {
					textFieldNomAjouterAliment.setText(recherche);
				}
			}
		});
		btnNomAjouterAliment.setIcon(new ImageIcon("./trouver-recherche-zoom-icone-3738-32.png"));
		btnNomAjouterAliment.setBounds(219, 29, 33, 26);
		btnNomAjouterAliment.setToolTipText("Rechercher dans la liste des aliments");
		
		panelAjouterAlimentFrigo.add(btnNomAjouterAliment);
		
		panelListeAlimentFrigo = new JPanel();
		panelListeAlimentFrigo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				enableListeAliment(true);
				enableAjoutElement(false);
				panelFrigo.revalidate();
				panelFrigo.repaint();
			}
		});
		panelListeAlimentFrigo.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Liste des aliments", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelListeAlimentFrigo.setBounds(357, 11, 421, 245);
		panelFrigo.add(panelListeAlimentFrigo);
		panelListeAlimentFrigo.setLayout(null);
		
		scrollPaneListeAlimentFrigo = new JScrollPane();
		scrollPaneListeAlimentFrigo.setViewportBorder(null);
		scrollPaneListeAlimentFrigo.setBounds(10, 22, 401, 212);
		panelListeAlimentFrigo.add(scrollPaneListeAlimentFrigo);
		
		tableAlimentFrigo = new JTable();
		
		tableAlimentFrigo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				enableListeAliment(true);
				enableAjoutElement(false);
				
				panelFrigo.revalidate();
				panelFrigo.repaint();
				
			}
		});
		
		
		scrollPaneListeAlimentFrigo.setViewportView(tableAlimentFrigo);
		
		tableAlimentFrigo.setModel(remplissageTableProduitFrigo());
		
		JButton btnAnnulerFrigo = new JButton("Annuler");
		btnAnnulerFrigo.setBounds(175, 291, 95, 23);
		panelFrigo.add(btnAnnulerFrigo);
		
		JButton btnEnregistrerFrigo = new JButton("Enregistrer");
		btnEnregistrerFrigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (panelAjouterAlimentFrigo.isEnabled()) {
					AlimentCtrl.ajouterAliment(textFieldNomAjouterAliment.getText(), Integer.valueOf(textFieldQuantiteAjouterAliment.getText()), (String)comboBoxUniteAjoutAliment.getSelectedItem());;
					tableAlimentFrigo.setModel(remplissageTableProduitFrigo());
				}
			}
		});
		btnEnregistrerFrigo.setBounds(366, 291, 143, 23);
		panelFrigo.add(btnEnregistrerFrigo);
		
		JPanel panelDerniereMAJFrigo = new JPanel();
		panelDerniereMAJFrigo.setLayout(null);
		panelDerniereMAJFrigo.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Derni\u00E8re mise \u00E0 jour", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDerniereMAJFrigo.setBounds(12, 178, 279, 80);
		panelFrigo.add(panelDerniereMAJFrigo);
		btnAnnulerFrigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		panelJaiFaim = new JPanel();
		tabbedPaneMain.addTab("J'ai faim", null, panelJaiFaim, null);
		panelJaiFaim.setLayout(null);
		
		JPanel panelBoutonJaiFaim = new JPanel();
		panelBoutonJaiFaim.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBoutonJaiFaim.setBounds(10, 11, 768, 47);
		panelJaiFaim.add(panelBoutonJaiFaim);
		panelBoutonJaiFaim.setLayout(null);
		
		JButton btnRecetteRapide = new JButton("Recette rapide");
		btnRecetteRapide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int nbRecettes = Integer.parseInt(textFieldNbRecetteJaiFaim.getText());
				Vector <Recette> recettes = RecetteCtrl.getRecetteRapide(nbRecettes);
				String[] recettesNoms = new String[nbRecettes];
				for (int i = 0; i < nbRecettes; i++) {
					recettesNoms[i] = recettes.get(i).getNom();
				}
				listJaiFaim.setListData(recettesNoms);
			}
		});
		btnRecetteRapide.setBounds(25, 11, 124, 23);
		panelBoutonJaiFaim.add(btnRecetteRapide);
		
		JButton btnRecetteFavoris = new JButton("Recette parmis favoris");
		btnRecetteFavoris.setBounds(285, 11, 168, 23);
		panelBoutonJaiFaim.add(btnRecetteFavoris);
		
		JButton btnModifierNbPersonne = new JButton("Modifier nbr personnes");
		btnModifierNbPersonne.setBounds(585, 11, 173, 23);
		panelBoutonJaiFaim.add(btnModifierNbPersonne);
		
		JButton btnVoirRecette = new JButton("Voir la recette");
		btnVoirRecette.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Recette r = new Recette();
				r.setNom("Caviar");
				FenetreRecette fr = new FenetreRecette(r);
			}
		});
		btnVoirRecette.setBounds(515, 162, 139, 23);
		panelJaiFaim.add(btnVoirRecette);
		
		listJaiFaim = new JList<String>();
		listJaiFaim.setBorder(null);
		listJaiFaim.setBounds(242, 69, 237, 247);
		panelJaiFaim.add(listJaiFaim);
		
		JLabel lblnbRecetteJaiFaim = new JLabel("nombre de recettes :");
		lblnbRecetteJaiFaim.setBounds(10, 80, 138, 14);
		panelJaiFaim.add(lblnbRecetteJaiFaim);
		
		textFieldNbRecetteJaiFaim = new JTextField();
		textFieldNbRecetteJaiFaim.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldNbRecetteJaiFaim.setText("5");
		textFieldNbRecetteJaiFaim.setBounds(150, 77, 46, 20);
		panelJaiFaim.add(textFieldNbRecetteJaiFaim);
		textFieldNbRecetteJaiFaim.setColumns(10);
		
		panelPlanning = new JPanel();
		tabbedPaneMain.addTab("Planning repas", null, panelPlanning, null);
		panelPlanning.setLayout(null);
		
		JPanel panelPlanning1 = new JPanel();
		panelPlanning1.setBounds(12, 5, 110, 240);
		panelPlanning.add(panelPlanning1);
		
		JPanel panelPlanning2 = new JPanel();
		panelPlanning2.setBounds(136, 5, 110, 240);
		panelPlanning.add(panelPlanning2);
		
		JPanel panelPlanning3 = new JPanel();
		panelPlanning3.setBounds(258, 5, 110, 240);
		panelPlanning.add(panelPlanning3);
		
		JPanel panelPlanning4 = new JPanel();
		panelPlanning4.setBounds(380, 5, 110, 240);
		panelPlanning.add(panelPlanning4);
		
		JPanel panelPlanning5 = new JPanel();
		panelPlanning5.setBounds(502, 5, 110, 240);
		panelPlanning.add(panelPlanning5);
		
		panelParametres = new JPanel();
		tabbedPaneMain.addTab("Param\u00E8tres", null, panelParametres, null);
		panelParametres.setLayout(null);
		
		JPanel panelReglageParametre = new JPanel();
		panelReglageParametre.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelReglageParametre.setBounds(10, 11, 215, 243);
		panelParametres.add(panelReglageParametre);
		panelReglageParametre.setLayout(null);
		
		JLabel lblNbPersonneParametre = new JLabel("Nombre de personne");
		lblNbPersonneParametre.setBounds(10, 21, 125, 14);
		panelReglageParametre.add(lblNbPersonneParametre);
		
		textFieldNbPersonneParametre = new JTextField();
		textFieldNbPersonneParametre.setBounds(147, 18, 42, 20);
		textFieldNbPersonneParametre.setText("1");
		panelReglageParametre.add(textFieldNbPersonneParametre);
		textFieldNbPersonneParametre.setColumns(10);
		
		comboBoxCouleurParametre = new JComboBox();
		comboBoxCouleurParametre.setModel(new DefaultComboBoxModel(new String[] {"Default", "Bleu", "Jaune", "Vert"}));
		comboBoxCouleurParametre.setBounds(117, 73, 92, 26);
		panelReglageParametre.add(comboBoxCouleurParametre);
		
		JLabel lblCouleurInterfaceParametre = new JLabel("Couleur Interface");
		lblCouleurInterfaceParametre.setBounds(10, 78, 109, 16);
		panelReglageParametre.add(lblCouleurInterfaceParametre);
		
		JButton btnEnregistrerParametre = new JButton("Enregistrer");
		btnEnregistrerParametre.setBounds(31, 170, 158, 23);
		panelReglageParametre.add(btnEnregistrerParametre);
		
		JButton btnAnnulerParametre = new JButton("Annuler");
		btnAnnulerParametre.setBounds(67, 200, 90, 20);
		panelReglageParametre.add(btnAnnulerParametre);
		btnEnregistrerParametre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnGestionRecettesFavoris = new JButton("Gestion recettes favoris");
		btnGestionRecettesFavoris.setBounds(246, 21, 166, 23);
		panelParametres.add(btnGestionRecettesFavoris);
		
		JButton btnHistoriqueRecette = new JButton("Historique de recettes");
		btnHistoriqueRecette.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnHistoriqueRecette.setBounds(246, 134, 166, 23);
		panelParametres.add(btnHistoriqueRecette);
		
		JPanel panelFavorisParametre = new JPanel();
		panelFavorisParametre.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelFavorisParametre.setBounds(450, 11, 328, 243);
		panelParametres.add(panelFavorisParametre);
		panelFavorisParametre.setLayout(null);
		
		JList listFavorisParametre = new JList();
		listFavorisParametre.setBounds(21, 11, 285, 184);
		panelFavorisParametre.add(listFavorisParametre);
		
		JButton btnSupprimerFavoris = new JButton("Supprimer");
		btnSupprimerFavoris.setBounds(60, 206, 89, 23);
		panelFavorisParametre.add(btnSupprimerFavoris);
		
		JButton btnVisualiserFavoris = new JButton("Visualiser");
		btnVisualiserFavoris.setBounds(198, 206, 89, 23);
		panelFavorisParametre.add(btnVisualiserFavoris);
		
		JButton btnEffacerHistorique = new JButton("Effacer mon historique");
		btnEffacerHistorique.setBounds(249, 226, 163, 28);
		panelParametres.add(btnEffacerHistorique);
		btnVisualiserFavoris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		panelRecherche = new JPanel();
		tabbedPaneMain.addTab("Rechercher recette", null, panelRecherche, null);
		panelRecherche.setLayout(null);
		
		JPanel panelParametreRecherche = new JPanel();
		panelParametreRecherche.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelParametreRecherche.setBounds(10, 11, 315, 305);
		panelRecherche.add(panelParametreRecherche);
		panelParametreRecherche.setLayout(null);
		
		JLabel lblMotCleRecherche = new JLabel("Mot cl\u00E9");
		lblMotCleRecherche.setBounds(41, 40, 46, 14);
		panelParametreRecherche.add(lblMotCleRecherche);
		
		textFieldMotCleRecherche = new JTextField();
		textFieldMotCleRecherche.setBounds(113, 37, 166, 20);
		panelParametreRecherche.add(textFieldMotCleRecherche);
		textFieldMotCleRecherche.setColumns(10);
		
		JLabel lblDureTotal = new JLabel("Dur\u00E9e total entre");
		lblDureTotal.setBounds(10, 93, 102, 14);
		panelParametreRecherche.add(lblDureTotal);
		
		textFieldDureeMinRecherche = new JTextField();
		textFieldDureeMinRecherche.setColumns(10);
		textFieldDureeMinRecherche.setBounds(113, 90, 36, 20);
		panelParametreRecherche.add(textFieldDureeMinRecherche);
		
		JLabel lblEtRecherche = new JLabel("et");
		lblEtRecherche.setBounds(161, 93, 27, 14);
		panelParametreRecherche.add(lblEtRecherche);
		
		textFieldDureeMaxRecherche = new JTextField();
		textFieldDureeMaxRecherche.setColumns(10);
		textFieldDureeMaxRecherche.setBounds(201, 90, 36, 20);
		panelParametreRecherche.add(textFieldDureeMaxRecherche);
		
		JLabel lblMinRecette = new JLabel("min");
		lblMinRecette.setBounds(247, 93, 46, 14);
		panelParametreRecherche.add(lblMinRecette);
		
		JLabel lblIngredientRecherche = new JLabel("Ingr\u00E9dient");
		lblIngredientRecherche.setBounds(29, 151, 58, 14);
		panelParametreRecherche.add(lblIngredientRecherche);
		
		JTextArea textAreaRechercheRecette = new JTextArea();
		textAreaRechercheRecette.setBounds(113, 151, 180, 70);
		panelParametreRecherche.add(textAreaRechercheRecette);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setBounds(191, 250, 102, 23);
		panelParametreRecherche.add(btnRechercher);
		
		JList listRecetteRecherche = new JList();
		listRecetteRecherche.setBounds(386, 11, 250, 305);
		panelRecherche.add(listRecetteRecherche);
		
		JButton btnVoirRecetteRecherche = new JButton("Voir la recette");
		btnVoirRecetteRecherche.setBounds(646, 149, 116, 23);
		panelRecherche.add(btnVoirRecetteRecherche);
		
		enableAjoutElement(false);
		
		
	
	}
	
	public DefaultTableModel remplissageTableProduitFrigo() {
        Vector<String> titre = new Vector<String>();
        titre.add("Nom");
        titre.add("Quantité ");
        titre.add("Unité");
        titre.add("Supprimer (quantité)");
        titre.add("Ajouter (quantité)");
        
        Vector<Object> matrice = AlimentCtrl.getTableModelFrigo(titre);
        
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
		panelAjouterAlimentFrigo.enable(value);
		textFieldNomAjouterAliment.enable(value);
		textFieldQuantiteAjouterAliment.enable(value);
		comboBoxUniteAjoutAliment.enable(value);
	}
	
	
	public void enableListeAliment(boolean value){
		panelListeAlimentFrigo.enable(value);
		scrollPaneListeAlimentFrigo.enable(value);
		tableAlimentFrigo.setEnabled(value);	
		
	}
}

