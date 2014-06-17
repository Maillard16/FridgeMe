/*
 -------------------------------------------------------------------------------
 Laboratoire : Projet PRO
 Fichier     : PrincipaleFrame.java
 Auteur(s)   : Julien Bignens, Stéphane Maillard, Anthony Roubaty, Yannick Widmer
 			   et Amine Tayaa
 Date        : 05.2014

 But         : Classe principale implémentant la fenêtre de l'application.
 -------------------------------------------------------------------------------
 */

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
import java.awt.event.MouseListener;
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
import ctrl.HistoriqueCtrl;
import ctrl.ParametreCtrl;
import ctrl.RecetteCtrl;
import ctrl.RepasCtrl;
import ctrl.SousCategorieCtrl;
import ctrl.TypeRecetteCtrl;
import ctrl.UniteCtrl;
import bo.*;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class PrincipaleFrame extends JFrame {

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
	private JList<String> listFrigo;
	private JButton btnAcceuilVoirRecette;
	private JPanel panelFrigo;
	private JPanel panelJaiFaim;
	private JPanel panelPlanning;
	private JPanel panelRecherche;
	private JPanel panelParametres;
	private JPanel panelAjouterAlimentFrigo;
	private JPanel panelListeAlimentFrigo;
	private JScrollPane scrollPaneFavorisAcceuil;
	private JTextField textFieldNomRecherche;
	private JTextField textFieldNbPersonneParametre;
	private JButton btnFermerFrigo;
	private JList<String> listHistorique;
	private JList<String> listFavoris;
	private JMenu mnFichier;
	
	private JScrollPane scrollPaneListeAlimentFrigo;
	
	private JList<String> listJaiFaim;
	private JTextField textFieldNbRecetteJaiFaim;
	
	private JLabel lblUniteSelectionAlimentFrigo;
	private JComboBox comboBoxAjoutAlimentFrigo;
	
	private JList<String> listFavorisParametre;
	private JList<String> listHistoriqueParametre;
	
	private JList<String> listRecetteRecherche;	
	
	private JList<String> listSCategorieAutorisee;
	private JList<String> listSCategorieInterdite;
	
	private JScrollPane scrollPaneFrigoAcceuil;
	private JScrollPane scrollPaneFavorisParametre;
	
	private static PrincipaleFrame instance;
	
	// true pour favoris, false pour historique
	private boolean modeListParametre = true;
	private boolean isPlanning = true;
	
	private JTextField textFieldNbPersonneJaiFaim;
	private JTextField textFieldNbMatin1;
	private JTextField textFieldRMatin1;
	private JTextField textFieldNbSoir1;
	private JTextField textFieldRSoir1;
	private JTextField textFieldNbMidi1;
	private JTextField textFieldRMidi1;
	private JTextField textFieldNbMatin2;
	private JTextField textFieldRMatin2;
	private JTextField textFieldNbSoir2;
	private JTextField textFieldRSoir2;
	private JTextField textFieldNbMidi2;
	private JTextField textFieldRMidi2;
	private JTextField textFieldNbMatin3;
	private JTextField textFieldRMatin3;
	private JTextField textFieldNbSoir3;
	private JTextField textFieldRSoir3;
	private JTextField textFieldNbMidi3;
	private JTextField textFieldRMidi3;
	private JTextField textFieldNbMatin4;
	private JTextField textFieldRMatin4;
	private JTextField textFieldNbSoir4;
	private JTextField textFieldRSoir4;
	private JTextField textFieldNbMidi4;
	private JTextField textFieldRMidi4;
	private JTextField textFieldNbMatin5;
	private JTextField textFieldRMatin5;
	private JTextField textFieldNbSoir5;
	private JTextField textFieldRSoir5;
	private JTextField textFieldNbMidi5;
	private JTextField textFieldRMidi5;
	
	private JComboBox comboBoxMatin1;
	private JComboBox comboBoxMatin2;
	private JComboBox comboBoxMatin3;
	private JComboBox comboBoxMatin4;
	private JComboBox comboBoxMatin5;
	
	private JComboBox comboBoxMidi1;
	private JComboBox comboBoxMidi2;
	private JComboBox comboBoxMidi3;
	private JComboBox comboBoxMidi4;
	private JComboBox comboBoxMidi5;
	
	private JComboBox comboBoxSoir1;
	private JComboBox comboBoxSoir2;
	private JComboBox comboBoxSoir3;
	private JComboBox comboBoxSoir4;
	private JComboBox comboBoxSoir5;
	
	private JRadioButton rdbtnMatin1;
	private JRadioButton rdbtnMatin2;
	private JRadioButton rdbtnMatin3;
	private JRadioButton rdbtnMatin4;
	private JRadioButton rdbtnMatin5;
	
	private JRadioButton rdbtnMidi1;
	private JRadioButton rdbtnMidi2;
	private JRadioButton rdbtnMidi3;
	private JRadioButton rdbtnMidi4;
	private JRadioButton rdbtnMidi5;
	
	private JRadioButton rdbtnSoir1;
	private JRadioButton rdbtnSoir2;
	private JRadioButton rdbtnSoir3;
	private JRadioButton rdbtnSoir4;
	private JRadioButton rdbtnSoir5;
	
	private JButton btnMatin1;
	private JButton btnMatin2;
	private JButton btnMatin3;
	private JButton btnMatin4;
	private JButton btnMatin5;
	
	private JButton btnMidi1;
	private JButton btnMidi2;
	private JButton btnMidi3;
	private JButton btnMidi4;
	private JButton btnMidi5;
	
	private JButton btnSoir1;
	private JButton btnSoir2;
	private JButton btnSoir3;
	private JButton btnSoir4;
	private JButton btnSoir5;
	
	private JButton btnAnnulerPlanning;
	private JButton btnEnregistrerPlanning;
	
	private Vector<JRadioButton> rdbtnPlan = new Vector<JRadioButton>();
	private Vector<JTextField> textFieldNbPlan = new Vector<JTextField>();
	private Vector<JComboBox> comboBoxPlan = new Vector<JComboBox>();
	private Vector<JTextField> textFieldRPlan = new Vector<JTextField>();
	private Vector<JButton> btnPlan = new Vector<JButton>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					instance = new PrincipaleFrame();
					instance.endConstruction();
					instance.setVisible(true);
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
		setBounds(100, 100, 940, 600);
		setResizable(false);
		
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
				tabbedPaneMain.setSelectedIndex(4);
			}
		});
		
		JMenuItem mntmSupprimerHistorique = new JMenuItem("Supprimer historique");
		mntmSupprimerHistorique.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Voulez-vous effacer l'historique?") == 0) {
					HistoriqueCtrl.effacerHistorique();
					refreshHistorique();
				}
			}
		});
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
		panelFrigoAcceuil.setBounds(10, 11, 232, 447);
		panelAcceuil.add(panelFrigoAcceuil);
		panelFrigoAcceuil.setLayout(null);
		
		btnOuvrirFrigo = new JButton("Ouvrir mon frigo");
		btnOuvrirFrigo.setBounds(49, 180, 129, 42);
		panelFrigoAcceuil.add(btnOuvrirFrigo);
		
		listFrigo = new JList();
		listFrigo.setModel(remplissageListAlimentFrigo());
		// listFrigo.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Frigo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		listFrigo.setBorder(new TitledBorder(null, "Frigo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnFermerFrigo = new JButton("Fermer mon frigo");
		btnFermerFrigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneFrigoAcceuil.hide();
				btnFermerFrigo.hide();
				btnOuvrirFrigo.show();
			}
		});
		btnFermerFrigo.setBounds(74, 413, 148, 23);
		btnFermerFrigo.hide();
		panelFrigoAcceuil.add(btnFermerFrigo);
		
		scrollPaneFrigoAcceuil = new JScrollPane();
		scrollPaneFrigoAcceuil.setBounds(10, 0, 212, 402);
		scrollPaneFrigoAcceuil.setViewportView(listFrigo);
		panelFrigoAcceuil.add(scrollPaneFrigoAcceuil);
		scrollPaneFrigoAcceuil.hide();
		
		btnOuvrirFrigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPaneFrigoAcceuil.show();
				btnOuvrirFrigo.hide();
				btnFermerFrigo.show();
			}
		});
		
		btnAcceuilVoirRecette = new JButton("Voir cette recette");
		btnAcceuilVoirRecette.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listFavoris.getSelectedIndex() != -1) {
					RecetteCtrl.AfficherRecetteByName((String) listFavoris.getSelectedValue(), ParametreCtrl.getNbPersonne(1));
				} else if( listHistorique.getSelectedIndex() != -1) {
					RecetteCtrl.AfficherRecetteByName((String) listHistorique.getSelectedValue(), ParametreCtrl.getNbPersonne(1));
				}
			}
		});
		btnAcceuilVoirRecette.setBounds(521, 469, 152, 23);
		panelAcceuil.add(btnAcceuilVoirRecette);
		
		JPanel panelRecetteAcceuil = new JPanel();
		panelRecetteAcceuil.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRecetteAcceuil.setBounds(254, 6, 634, 452);
		panelAcceuil.add(panelRecetteAcceuil);
		panelRecetteAcceuil.setLayout(null);
		
		scrollPaneFavorisAcceuil = new JScrollPane();
		scrollPaneFavorisAcceuil.setBounds(6, 6, 301, 435);
		panelRecetteAcceuil.add(scrollPaneFavorisAcceuil);
		
		listFavoris = new JList();
		listFavoris.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				listHistorique.clearSelection();
			}
		});
		scrollPaneFavorisAcceuil.setViewportView(listFavoris);
		listFavoris.setModel(remplissageListFavorisRecette());
		listFavoris.setBorder(new TitledBorder(null, "Recettes Favorites", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPaneHistoriqueAcceuil = new JScrollPane();
		scrollPaneHistoriqueAcceuil.setBounds(316, 6, 308, 435);
		panelRecetteAcceuil.add(scrollPaneHistoriqueAcceuil);
		
		listHistorique = new JList();
		listHistorique.setModel(remplissageListHistoriqueRecette());
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
		
		panelAjouterAlimentFrigo.setBounds(12, 11, 279, 164);
		panelFrigo.add(panelAjouterAlimentFrigo);
		panelAjouterAlimentFrigo.setLayout(null);
		
		JLabel lblNomRechercherAlimentFrigo = new JLabel("Recherche");
		lblNomRechercherAlimentFrigo.setBounds(15, 35, 65, 14);
		panelAjouterAlimentFrigo.add(lblNomRechercherAlimentFrigo);
		
		textFieldNomAjouterAliment = new JTextField();
		textFieldNomAjouterAliment.setBounds(90, 32, 109, 20);
		panelAjouterAlimentFrigo.add(textFieldNomAjouterAliment);
		textFieldNomAjouterAliment.setColumns(10);
		
		JLabel lblQuantiteAjouterAliment = new JLabel("Quantit\u00E9");
		lblQuantiteAjouterAliment.setBounds(15, 97, 54, 14);
		panelAjouterAlimentFrigo.add(lblQuantiteAjouterAliment);
		
		textFieldQuantiteAjouterAliment = new JTextField();
		textFieldQuantiteAjouterAliment.setBounds(90, 94, 66, 20);
		panelAjouterAlimentFrigo.add(textFieldQuantiteAjouterAliment);
		textFieldQuantiteAjouterAliment.setColumns(10);
		
		JLabel lblUniteAjouterAliment = new JLabel("Unit\u00E9");
		lblUniteAjouterAliment.setBounds(15, 125, 39, 14);
		panelAjouterAlimentFrigo.add(lblUniteAjouterAliment);
		
		btnNomAjouterAliment = new JButton("");
		btnNomAjouterAliment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] recherche = AlimentCtrl.getAlimentsNames(textFieldNomAjouterAliment.getText());
				if (recherche.length == 0) {
					JOptionPane.showMessageDialog(null,
							"Aucun aliment trouvé avec '" + textFieldNomAjouterAliment.getText() + "'");
				} else {
					comboBoxAjoutAlimentFrigo.setEnabled(false);
					comboBoxAjoutAlimentFrigo.removeAllItems();
					for (String nomAliment : recherche) {
						comboBoxAjoutAlimentFrigo.addItem(nomAliment);
					}
					Unite unite = UniteCtrl.getUnitebyAlimentName((String)comboBoxAjoutAlimentFrigo.getSelectedItem());
					if (unite == null) {
						lblUniteSelectionAlimentFrigo.setText("aucune");
					} else {
						lblUniteSelectionAlimentFrigo.setText(unite.getNom());
					}
					comboBoxAjoutAlimentFrigo.setEnabled(true);
				}
			}
		});
		btnNomAjouterAliment.setIcon(new ImageIcon("./trouver-recherche-zoom-icone-3738-32.png"));
		btnNomAjouterAliment.setBounds(219, 29, 33, 26);
		btnNomAjouterAliment.setToolTipText("Rechercher dans la liste des aliments");
		
		panelAjouterAlimentFrigo.add(btnNomAjouterAliment);
		
		lblUniteSelectionAlimentFrigo = new JLabel("aucune");
		lblUniteSelectionAlimentFrigo.setBounds(90, 125, 120, 14);
		panelAjouterAlimentFrigo.add(lblUniteSelectionAlimentFrigo);
		
		JLabel lblNomAjouterAlimentFrigo = new JLabel("Nom");
		lblNomAjouterAlimentFrigo.setBounds(15, 66, 65, 14);
		panelAjouterAlimentFrigo.add(lblNomAjouterAlimentFrigo);
		
		comboBoxAjoutAlimentFrigo = new JComboBox();
		comboBoxAjoutAlimentFrigo.setModel(new DefaultComboBoxModel(new String[] {"Aucun"}));
		comboBoxAjoutAlimentFrigo.setBounds(90, 63, 162, 20);
		panelAjouterAlimentFrigo.add(comboBoxAjoutAlimentFrigo);
		
		comboBoxAjoutAlimentFrigo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (comboBoxAjoutAlimentFrigo.isEnabled()) {
					Unite unite = UniteCtrl.getUnitebyAlimentName((String)comboBoxAjoutAlimentFrigo.getSelectedItem());
					if (unite == null) {
						lblUniteSelectionAlimentFrigo.setText("aucune");
					} else {
						lblUniteSelectionAlimentFrigo.setText(unite.getNom());
					}
				}
			}
		});
			
		comboBoxAjoutAlimentFrigo.setEnabled(false);
		
		panelListeAlimentFrigo = new JPanel();

		panelListeAlimentFrigo.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Liste des aliments", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelListeAlimentFrigo.setBounds(347, 11, 552, 447);
		panelFrigo.add(panelListeAlimentFrigo);
		panelListeAlimentFrigo.setLayout(null);
		
		scrollPaneListeAlimentFrigo = new JScrollPane();
		scrollPaneListeAlimentFrigo.setViewportBorder(null);
		scrollPaneListeAlimentFrigo.setBounds(10, 22, 532, 414);
		panelListeAlimentFrigo.add(scrollPaneListeAlimentFrigo);
		
		tableAlimentFrigo = new JTable();		
		
		scrollPaneListeAlimentFrigo.setViewportView(tableAlimentFrigo);
		
		tableAlimentFrigo.setModel(remplissageTableProduitFrigo());
		
		JButton btnAnnulerFrigo = new JButton("Annuler");
		btnAnnulerFrigo.setBounds(502, 469, 95, 23);
		panelFrigo.add(btnAnnulerFrigo);
		
		JButton btnEnregistrerAlimentFrigo = new JButton("Enregistrer");
		btnEnregistrerAlimentFrigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBoxAjoutAlimentFrigo.isEnabled()) {
					if (PrincipaleFrame.isPositiveInteger(textFieldQuantiteAjouterAliment.getText())) {
						AlimentCtrl.ajouterAliment((String)comboBoxAjoutAlimentFrigo.getSelectedItem(), Integer.parseInt(textFieldQuantiteAjouterAliment.getText()));
						tableAlimentFrigo.setModel(remplissageTableProduitFrigo());
						listFrigo.setModel(remplissageListAlimentFrigo());
					}
				}
			}
		});
		btnEnregistrerAlimentFrigo.setBounds(148, 202, 143, 23);
		panelFrigo.add(btnEnregistrerAlimentFrigo);
		
		JButton btnEnregistrerFrigo = new JButton("Enregistrer");
		btnEnregistrerFrigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// On valide la dernière edition si il faut
				if (tableAlimentFrigo.isEditing()) {
					tableAlimentFrigo.getCellEditor().stopCellEditing();
				}
				AlimentCtrl.modifierQuantites(tableAlimentFrigo.getModel());
				tableAlimentFrigo.setModel(remplissageTableProduitFrigo());
				listFrigo.setModel(remplissageListAlimentFrigo());
			}
		});
		btnEnregistrerFrigo.setBounds(698, 469, 143, 23);
		panelFrigo.add(btnEnregistrerFrigo);
		btnAnnulerFrigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableAlimentFrigo.setModel(remplissageTableProduitFrigo());
			}
		});
		
		panelJaiFaim = new JPanel();
		tabbedPaneMain.addTab("J'ai faim", null, panelJaiFaim, null);
		panelJaiFaim.setLayout(null);
		
		JPanel panelBoutonJaiFaim = new JPanel();
		panelBoutonJaiFaim.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBoutonJaiFaim.setBounds(10, 11, 889, 51);
		panelJaiFaim.add(panelBoutonJaiFaim);
		panelBoutonJaiFaim.setLayout(null);
		
		JButton btnRecetteRapide = new JButton("Recette rapide");
		btnRecetteRapide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (PrincipaleFrame.isPositiveInteger(textFieldNbRecetteJaiFaim.getText())) {
					int nbRecettes = Integer.parseInt(textFieldNbRecetteJaiFaim.getText());
					if (nbRecettes > 50) {
						nbRecettes = 50;
					}
					Vector <Recette> recettes = RecetteCtrl.getRecetteRapide(nbRecettes);
					String[] recettesNoms = new String[recettes.size()];
					for (int i = 0; i < recettesNoms.length; i++) {
						recettesNoms[i] = recettes.get(i).getNom();
					}
					listJaiFaim.setListData(recettesNoms);
				}
			}
		});
		btnRecetteRapide.setBounds(179, 11, 124, 23);
		panelBoutonJaiFaim.add(btnRecetteRapide);
		
		JButton btnRecetteFavoris = new JButton("Recette parmi favoris");
		btnRecetteFavoris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (PrincipaleFrame.isPositiveInteger(textFieldNbRecetteJaiFaim.getText())) {
					int nbRecettes = Integer.parseInt(textFieldNbRecetteJaiFaim.getText());
					if (nbRecettes > 50) {
						nbRecettes = 50;
					}
					Vector <Recette> recettes = RecetteCtrl.getRecetteRapideFavoris(nbRecettes);
					String[] recettesNoms = new String[recettes.size()];
					for (int i = 0; i < recettesNoms.length; i++) {
						recettesNoms[i] = recettes.get(i).getNom();
					}
					listJaiFaim.setListData(recettesNoms);
				}
			}
		});
		btnRecetteFavoris.setBounds(532, 11, 168, 23);
		panelBoutonJaiFaim.add(btnRecetteFavoris);
		
		JButton btnVoirRecette = new JButton("Voir la recette");
		btnVoirRecette.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String recette = listJaiFaim.getSelectedValue();
				if (recette != null) {
					RecetteCtrl.AfficherRecetteByName(recette, textFieldNbPersonneJaiFaim.getText());
				}
			}
		});
		btnVoirRecette.setBounds(662, 267, 139, 40);
		panelJaiFaim.add(btnVoirRecette);
		
		listJaiFaim = new JList<String>();
		
		JLabel lblnbRecetteJaiFaim = new JLabel("nombre de recettes :");
		lblnbRecetteJaiFaim.setBounds(10, 80, 138, 14);
		panelJaiFaim.add(lblnbRecetteJaiFaim);
		
		textFieldNbRecetteJaiFaim = new JTextField();
		textFieldNbRecetteJaiFaim.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldNbRecetteJaiFaim.setText("5");
		textFieldNbRecetteJaiFaim.setBounds(150, 77, 46, 20);
		panelJaiFaim.add(textFieldNbRecetteJaiFaim);
		textFieldNbRecetteJaiFaim.setColumns(10);
		
		JScrollPane scrollPaneJaiFaim = new JScrollPane();
		scrollPaneJaiFaim.setBounds(296, 73, 307, 419);
		scrollPaneJaiFaim.setViewportView(listJaiFaim);
		panelJaiFaim.add(scrollPaneJaiFaim);
		
		JLabel lblNbPersonneJaiFaim = new JLabel("nombre de personnes :");
		lblNbPersonneJaiFaim.setBounds(10, 108, 138, 14);
		panelJaiFaim.add(lblNbPersonneJaiFaim);
		
		textFieldNbPersonneJaiFaim = new JTextField();
		textFieldNbPersonneJaiFaim.setText(ParametreCtrl.getNbPersonne(1));
		textFieldNbPersonneJaiFaim.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldNbPersonneJaiFaim.setColumns(10);
		textFieldNbPersonneJaiFaim.setBounds(150, 105, 46, 20);
		panelJaiFaim.add(textFieldNbPersonneJaiFaim);
		
		/**
		 * 	Planning
		 */
		
		// Jour 1
		
		panelPlanning = new JPanel();
		tabbedPaneMain.addTab("Planning repas", null, panelPlanning, null);
		panelPlanning.setLayout(null);
		
		JPanel panelJour1 = new JPanel();
		panelJour1.setBounds(10, 11, 170, 432);
		panelJour1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Jour 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPlanning.add(panelJour1);
		panelJour1.setLayout(null);
		
		JLabel lblMatin1 = new JLabel("Matin");
		lblMatin1.setBounds(10, 23, 46, 14);
		panelJour1.add(lblMatin1);
		
		rdbtnMatin1 = new JRadioButton("");
		rdbtnMatin1.setBounds(143, 19, 21, 23);
		panelJour1.add(rdbtnMatin1);
		
		comboBoxMatin1 = new JComboBox();
		comboBoxMatin1.setBounds(10, 48, 150, 20);
		panelJour1.add(comboBoxMatin1);
		
		textFieldNbMatin1 = new JTextField();
		textFieldNbMatin1.setBounds(104, 20, 33, 20);
		panelJour1.add(textFieldNbMatin1);
		textFieldNbMatin1.setColumns(10);
		
		textFieldRMatin1 = new JTextField();
		textFieldRMatin1.setEditable(false);
		textFieldRMatin1.setBounds(10, 79, 150, 20);
		panelJour1.add(textFieldRMatin1);
		textFieldRMatin1.setColumns(10);
		
		btnMatin1 = new JButton("Voir");
		btnMatin1.setBounds(38, 110, 89, 23);
		panelJour1.add(btnMatin1);
		btnMatin1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String recette = textFieldRMatin1.getText();
				if (!recette.equals("")) {
					RecetteCtrl.AfficherRecetteByName(recette, textFieldNbMatin1.getText());
				}
			}
		});
		
		JLabel lblSoir1 = new JLabel("Soir");
		lblSoir1.setBounds(10, 311, 46, 14);
		panelJour1.add(lblSoir1);
		
		rdbtnSoir1 = new JRadioButton("");
		rdbtnSoir1.setBounds(143, 307, 21, 23);
		panelJour1.add(rdbtnSoir1);
		
		comboBoxSoir1 = new JComboBox();
		comboBoxSoir1.setBounds(10, 336, 150, 20);
		panelJour1.add(comboBoxSoir1);
		
		textFieldNbSoir1 = new JTextField();
		textFieldNbSoir1.setColumns(10);
		textFieldNbSoir1.setBounds(104, 308, 33, 20);
		panelJour1.add(textFieldNbSoir1);
		
		textFieldRSoir1 = new JTextField();
		textFieldRSoir1.setEditable(false);
		textFieldRSoir1.setColumns(10);
		textFieldRSoir1.setBounds(10, 367, 150, 20);
		panelJour1.add(textFieldRSoir1);
		
		btnSoir1 = new JButton("Voir");
		btnSoir1.setBounds(38, 398, 89, 23);
		panelJour1.add(btnSoir1);
		btnSoir1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String recette = textFieldRSoir1.getText();
				if (!recette.equals("")) {
					RecetteCtrl.AfficherRecetteByName(recette, textFieldNbSoir1.getText());
				}
			}
		});
		
		JLabel lblMidi1 = new JLabel("Midi");
		lblMidi1.setBounds(10, 165, 46, 14);
		panelJour1.add(lblMidi1);
		
		rdbtnMidi1 = new JRadioButton("");
		rdbtnMidi1.setBounds(143, 161, 21, 23);
		panelJour1.add(rdbtnMidi1);
		
		comboBoxMidi1 = new JComboBox();
		comboBoxMidi1.setBounds(10, 190, 150, 20);
		panelJour1.add(comboBoxMidi1);
		
		textFieldNbMidi1 = new JTextField();
		textFieldNbMidi1.setColumns(10);
		textFieldNbMidi1.setBounds(104, 162, 33, 20);
		panelJour1.add(textFieldNbMidi1);
		
		textFieldRMidi1 = new JTextField();
		textFieldRMidi1.setEditable(false);
		textFieldRMidi1.setColumns(10);
		textFieldRMidi1.setBounds(10, 221, 150, 20);
		panelJour1.add(textFieldRMidi1);
		
		btnMidi1 = new JButton("Voir");
		btnMidi1.setBounds(38, 252, 89, 23);
		panelJour1.add(btnMidi1);
		btnMidi1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String recette = textFieldRMidi1.getText();
				if (!recette.equals("")) {
					RecetteCtrl.AfficherRecetteByName(recette, textFieldNbMidi1.getText());
				}
			}
		});
		
		// Jour 2
		
		JPanel panelJour2 = new JPanel();
		panelJour2.setLayout(null);
		panelJour2.setBounds(190, 11, 170, 432);
		panelJour2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Jour 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPlanning.add(panelJour2);
		
		JLabel lblMatin2 = new JLabel("Matin");
		lblMatin2.setBounds(10, 23, 46, 14);
		panelJour2.add(lblMatin2);
		
		rdbtnMatin2 = new JRadioButton("");
		rdbtnMatin2.setBounds(143, 19, 21, 23);
		panelJour2.add(rdbtnMatin2);
		
		comboBoxMatin2 = new JComboBox();
		comboBoxMatin2.setBounds(10, 48, 150, 20);
		panelJour2.add(comboBoxMatin2);
		
		textFieldNbMatin2 = new JTextField();
		textFieldNbMatin2.setColumns(10);
		textFieldNbMatin2.setBounds(104, 20, 33, 20);
		panelJour2.add(textFieldNbMatin2);
		
		textFieldRMatin2 = new JTextField();
		textFieldRMatin2.setEditable(false);
		textFieldRMatin2.setColumns(10);
		textFieldRMatin2.setBounds(10, 79, 150, 20);
		panelJour2.add(textFieldRMatin2);
		
		btnMatin2 = new JButton("Voir");
		btnMatin2.setBounds(38, 110, 89, 23);
		panelJour2.add(btnMatin2);
		btnMatin2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String recette = textFieldRMatin2.getText();
				if (!recette.equals("")) {
					RecetteCtrl.AfficherRecetteByName(recette, textFieldNbMatin2.getText());
				}
			}
		});
		
		JLabel lblSoir2 = new JLabel("Soir");
		lblSoir2.setBounds(10, 311, 46, 14);
		panelJour2.add(lblSoir2);
		
		rdbtnSoir2 = new JRadioButton("");
		rdbtnSoir2.setBounds(143, 307, 21, 23);
		panelJour2.add(rdbtnSoir2);
		
		comboBoxSoir2 = new JComboBox();
		comboBoxSoir2.setBounds(10, 336, 150, 20);
		panelJour2.add(comboBoxSoir2);
		
		textFieldNbSoir2 = new JTextField();
		textFieldNbSoir2.setColumns(10);
		textFieldNbSoir2.setBounds(104, 308, 33, 20);
		panelJour2.add(textFieldNbSoir2);
		
		textFieldRSoir2 = new JTextField();
		textFieldRSoir2.setEditable(false);
		textFieldRSoir2.setColumns(10);
		textFieldRSoir2.setBounds(10, 367, 150, 20);
		panelJour2.add(textFieldRSoir2);
		
		btnSoir2 = new JButton("Voir");
		btnSoir2.setBounds(38, 398, 89, 23);
		panelJour2.add(btnSoir2);
		btnSoir2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String recette = textFieldRSoir2.getText();
				if (!recette.equals("")) {
					RecetteCtrl.AfficherRecetteByName(recette, textFieldNbSoir2.getText());
				}
			}
		});
		
		JLabel lblMidi2 = new JLabel("Midi");
		lblMidi2.setBounds(10, 165, 46, 14);
		panelJour2.add(lblMidi2);
		
		rdbtnMidi2 = new JRadioButton("");
		rdbtnMidi2.setBounds(143, 161, 21, 23);
		panelJour2.add(rdbtnMidi2);
		
		comboBoxMidi2 = new JComboBox();
		comboBoxMidi2.setBounds(10, 190, 150, 20);
		panelJour2.add(comboBoxMidi2);
		
		textFieldNbMidi2 = new JTextField();
		textFieldNbMidi2.setColumns(10);
		textFieldNbMidi2.setBounds(104, 162, 33, 20);
		panelJour2.add(textFieldNbMidi2);
		
		textFieldRMidi2 = new JTextField();
		textFieldRMidi2.setEditable(false);
		textFieldRMidi2.setColumns(10);
		textFieldRMidi2.setBounds(10, 221, 150, 20);
		panelJour2.add(textFieldRMidi2);
		
		btnMidi2 = new JButton("Voir");
		btnMidi2.setBounds(38, 252, 89, 23);
		panelJour2.add(btnMidi2);
		btnMidi2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String recette = textFieldRMidi2.getText();
				if (!recette.equals("")) {
					RecetteCtrl.AfficherRecetteByName(recette, textFieldNbMidi2.getText());
				}
			}
		});
		
		// Jour 3
		
		JPanel panelJour3 = new JPanel();
		panelJour3.setLayout(null);
		panelJour3.setBounds(370, 11, 170, 432);
		panelJour3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Jour 3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPlanning.add(panelJour3);
		
		JLabel lblMatin3 = new JLabel("Matin");
		lblMatin3.setBounds(10, 23, 46, 14);
		panelJour3.add(lblMatin3);
		
		rdbtnMatin3 = new JRadioButton("");
		rdbtnMatin3.setBounds(143, 19, 21, 23);
		panelJour3.add(rdbtnMatin3);
		
		comboBoxMatin3 = new JComboBox();
		comboBoxMatin3.setBounds(10, 48, 150, 20);
		panelJour3.add(comboBoxMatin3);
		
		textFieldNbMatin3 = new JTextField();
		textFieldNbMatin3.setColumns(10);
		textFieldNbMatin3.setBounds(104, 20, 33, 20);
		panelJour3.add(textFieldNbMatin3);
		
		textFieldRMatin3 = new JTextField();
		textFieldRMatin3.setEditable(false);
		textFieldRMatin3.setColumns(10);
		textFieldRMatin3.setBounds(10, 79, 150, 20);
		panelJour3.add(textFieldRMatin3);
		
		btnMatin3 = new JButton("Voir");
		btnMatin3.setBounds(38, 110, 89, 23);
		panelJour3.add(btnMatin3);
		btnMatin3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String recette = textFieldRMatin3.getText();
				if (!recette.equals("")) {
					RecetteCtrl.AfficherRecetteByName(recette, textFieldNbMatin3.getText());
				}
			}
		});
		
		JLabel lblSoir3 = new JLabel("Soir");
		lblSoir3.setBounds(10, 311, 46, 14);
		panelJour3.add(lblSoir3);
		
		rdbtnSoir3 = new JRadioButton("");
		rdbtnSoir3.setBounds(143, 307, 21, 23);
		panelJour3.add(rdbtnSoir3);
		
		comboBoxSoir3 = new JComboBox();
		comboBoxSoir3.setBounds(10, 336, 150, 20);
		panelJour3.add(comboBoxSoir3);
		
		textFieldNbSoir3 = new JTextField();
		textFieldNbSoir3.setColumns(10);
		textFieldNbSoir3.setBounds(104, 308, 33, 20);
		panelJour3.add(textFieldNbSoir3);
		
		textFieldRSoir3 = new JTextField();
		textFieldRSoir3.setEditable(false);
		textFieldRSoir3.setColumns(10);
		textFieldRSoir3.setBounds(10, 367, 150, 20);
		panelJour3.add(textFieldRSoir3);
		
		btnSoir3 = new JButton("Voir");
		btnSoir3.setBounds(38, 398, 89, 23);
		panelJour3.add(btnSoir3);
		btnSoir3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String recette = textFieldRSoir3.getText();
				if (!recette.equals("")) {
					RecetteCtrl.AfficherRecetteByName(recette, textFieldNbSoir3.getText());
				}
			}
		});
		
		JLabel lblMidi3 = new JLabel("Midi");
		lblMidi3.setBounds(10, 165, 46, 14);
		panelJour3.add(lblMidi3);
		
		rdbtnMidi3 = new JRadioButton("");
		rdbtnMidi3.setBounds(143, 161, 21, 23);
		panelJour3.add(rdbtnMidi3);
		
		comboBoxMidi3 = new JComboBox();
		comboBoxMidi3.setBounds(10, 190, 150, 20);
		panelJour3.add(comboBoxMidi3);
		
		textFieldNbMidi3 = new JTextField();
		textFieldNbMidi3.setColumns(10);
		textFieldNbMidi3.setBounds(104, 162, 33, 20);
		panelJour3.add(textFieldNbMidi3);
		
		textFieldRMidi3 = new JTextField();
		textFieldRMidi3.setEditable(false);
		textFieldRMidi3.setColumns(10);
		textFieldRMidi3.setBounds(10, 221, 150, 20);
		panelJour3.add(textFieldRMidi3);
		
		btnMidi3 = new JButton("Voir");
		btnMidi3.setBounds(38, 252, 89, 23);
		panelJour3.add(btnMidi3);
		btnMidi3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String recette = textFieldRMidi3.getText();
				if (!recette.equals("")) {
					RecetteCtrl.AfficherRecetteByName(recette, textFieldNbMidi3.getText());
				}
			}
		});
		
		// Jour 4
		
		JPanel panelJour4 = new JPanel();
		panelJour4.setLayout(null);
		panelJour4.setBounds(550, 11, 170, 432);
		panelJour4.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Jour 4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPlanning.add(panelJour4);
		
		JLabel lblMatin4 = new JLabel("Matin");
		lblMatin4.setBounds(10, 23, 46, 14);
		panelJour4.add(lblMatin4);
		
		rdbtnMatin4 = new JRadioButton("");
		rdbtnMatin4.setBounds(143, 19, 21, 23);
		panelJour4.add(rdbtnMatin4);
		
		comboBoxMatin4 = new JComboBox();
		comboBoxMatin4.setBounds(10, 48, 150, 20);
		panelJour4.add(comboBoxMatin4);
		
		textFieldNbMatin4 = new JTextField();
		textFieldNbMatin4.setColumns(10);
		textFieldNbMatin4.setBounds(104, 20, 33, 20);
		panelJour4.add(textFieldNbMatin4);
		
		textFieldRMatin4 = new JTextField();
		textFieldRMatin4.setEditable(false);
		textFieldRMatin4.setColumns(10);
		textFieldRMatin4.setBounds(10, 79, 150, 20);
		panelJour4.add(textFieldRMatin4);
		
		btnMatin4 = new JButton("Voir");
		btnMatin4.setBounds(38, 110, 89, 23);
		panelJour4.add(btnMatin4);
		btnMatin4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String recette = textFieldRMatin4.getText();
				if (!recette.equals("")) {
					RecetteCtrl.AfficherRecetteByName(recette, textFieldNbMatin4.getText());
				}
			}
		});
		
		JLabel lblSoir = new JLabel("Soir");
		lblSoir.setBounds(10, 311, 46, 14);
		panelJour4.add(lblSoir);
		
		rdbtnSoir4 = new JRadioButton("");
		rdbtnSoir4.setBounds(143, 307, 21, 23);
		panelJour4.add(rdbtnSoir4);
		
		comboBoxSoir4 = new JComboBox();
		comboBoxSoir4.setBounds(10, 336, 150, 20);
		panelJour4.add(comboBoxSoir4);
		
		textFieldNbSoir4 = new JTextField();
		textFieldNbSoir4.setColumns(10);
		textFieldNbSoir4.setBounds(104, 308, 33, 20);
		panelJour4.add(textFieldNbSoir4);
		
		textFieldRSoir4 = new JTextField();
		textFieldRSoir4.setEditable(false);
		textFieldRSoir4.setColumns(10);
		textFieldRSoir4.setBounds(10, 367, 150, 20);
		panelJour4.add(textFieldRSoir4);
		
		btnSoir4 = new JButton("Voir");
		btnSoir4.setBounds(38, 398, 89, 23);
		panelJour4.add(btnSoir4);
		btnSoir4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String recette = textFieldRSoir4.getText();
				if (!recette.equals("")) {
					RecetteCtrl.AfficherRecetteByName(recette, textFieldNbSoir4.getText());
				}
			}
		});
		
		JLabel lblMidi4 = new JLabel("Midi");
		lblMidi4.setBounds(10, 165, 46, 14);
		panelJour4.add(lblMidi4);
		
		rdbtnMidi4 = new JRadioButton("");
		rdbtnMidi4.setBounds(143, 161, 21, 23);
		panelJour4.add(rdbtnMidi4);
		
		comboBoxMidi4 = new JComboBox();
		comboBoxMidi4.setBounds(10, 190, 150, 20);
		panelJour4.add(comboBoxMidi4);
		
		textFieldNbMidi4 = new JTextField();
		textFieldNbMidi4.setColumns(10);
		textFieldNbMidi4.setBounds(104, 162, 33, 20);
		panelJour4.add(textFieldNbMidi4);
		
		textFieldRMidi4 = new JTextField();
		textFieldRMidi4.setEditable(false);
		textFieldRMidi4.setColumns(10);
		textFieldRMidi4.setBounds(10, 221, 150, 20);
		panelJour4.add(textFieldRMidi4);
		
		btnMidi4 = new JButton("Voir");
		btnMidi4.setBounds(38, 252, 89, 23);
		panelJour4.add(btnMidi4);
		btnMidi4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String recette = textFieldRMidi4.getText();
				if (!recette.equals("")) {
					RecetteCtrl.AfficherRecetteByName(recette, textFieldNbMidi4.getText());
				}
			}
		});
		
		// Jour 5
		
		JPanel panelJour5 = new JPanel();
		panelJour5.setLayout(null);
		panelJour5.setBounds(730, 11, 170, 432);
		panelJour5.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Jour 5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPlanning.add(panelJour5);
		
		JLabel lblMatin5 = new JLabel("Matin");
		lblMatin5.setBounds(10, 23, 46, 14);
		panelJour5.add(lblMatin5);
		
		rdbtnMatin5 = new JRadioButton("");
		rdbtnMatin5.setBounds(143, 19, 21, 23);
		panelJour5.add(rdbtnMatin5);
		
		comboBoxMatin5 = new JComboBox();
		comboBoxMatin5.setBounds(10, 48, 150, 20);
		panelJour5.add(comboBoxMatin5);
		
		textFieldNbMatin5 = new JTextField();
		textFieldNbMatin5.setColumns(10);
		textFieldNbMatin5.setBounds(104, 20, 33, 20);
		panelJour5.add(textFieldNbMatin5);
		
		textFieldRMatin5 = new JTextField();
		textFieldRMatin5.setEditable(false);
		textFieldRMatin5.setColumns(10);
		textFieldRMatin5.setBounds(10, 79, 150, 20);
		panelJour5.add(textFieldRMatin5);
		
		btnMatin5 = new JButton("Voir");
		btnMatin5.setBounds(38, 110, 89, 23);
		panelJour5.add(btnMatin5);
		btnMatin5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String recette = textFieldRMatin5.getText();
				if (!recette.equals("")) {
					RecetteCtrl.AfficherRecetteByName(recette, textFieldNbMatin5.getText());
				}
			}
		});
		
		JLabel lblSoir5 = new JLabel("Soir");
		lblSoir5.setBounds(10, 311, 46, 14);
		panelJour5.add(lblSoir5);
		
		rdbtnSoir5 = new JRadioButton("");
		rdbtnSoir5.setBounds(143, 307, 21, 23);
		panelJour5.add(rdbtnSoir5);
		
		comboBoxSoir5 = new JComboBox();
		comboBoxSoir5.setBounds(10, 336, 150, 20);
		panelJour5.add(comboBoxSoir5);
		
		textFieldNbSoir5 = new JTextField();
		textFieldNbSoir5.setColumns(10);
		textFieldNbSoir5.setBounds(104, 308, 33, 20);
		panelJour5.add(textFieldNbSoir5);
		
		textFieldRSoir5 = new JTextField();
		textFieldRSoir5.setEditable(false);
		textFieldRSoir5.setColumns(10);
		textFieldRSoir5.setBounds(10, 367, 150, 20);
		panelJour5.add(textFieldRSoir5);
		
		btnSoir5 = new JButton("Voir");
		btnSoir5.setBounds(38, 398, 89, 23);
		panelJour5.add(btnSoir5);
		btnSoir5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String recette = textFieldRSoir5.getText();
				if (!recette.equals("")) {
					RecetteCtrl.AfficherRecetteByName(recette, textFieldNbSoir5.getText());
				}
			}
		});
		
		JLabel lblMidi5 = new JLabel("Midi");
		lblMidi5.setBounds(10, 165, 46, 14);
		panelJour5.add(lblMidi5);
		
		rdbtnMidi5 = new JRadioButton("");
		rdbtnMidi5.setBounds(143, 161, 21, 23);
		panelJour5.add(rdbtnMidi5);
		
		comboBoxMidi5 = new JComboBox();
		comboBoxMidi5.setBounds(10, 190, 150, 20);
		panelJour5.add(comboBoxMidi5);
		
		textFieldNbMidi5 = new JTextField();
		textFieldNbMidi5.setColumns(10);
		textFieldNbMidi5.setBounds(104, 162, 33, 20);
		panelJour5.add(textFieldNbMidi5);
		
		textFieldRMidi5 = new JTextField();
		textFieldRMidi5.setEditable(false);
		textFieldRMidi5.setColumns(10);
		textFieldRMidi5.setBounds(10, 221, 150, 20);
		panelJour5.add(textFieldRMidi5);
		
		btnMidi5 = new JButton("Voir");
		btnMidi5.setBounds(38, 252, 89, 23);
		panelJour5.add(btnMidi5);
		btnMidi5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String recette = textFieldRMidi5.getText();
				if (!recette.equals("")) {
					RecetteCtrl.AfficherRecetteByName(recette, textFieldNbMidi5.getText());
				}
			}
		});
		
		btnAnnulerPlanning = new JButton("Annuler");
		btnAnnulerPlanning.setBounds(251, 453, 154, 39);
		panelPlanning.add(btnAnnulerPlanning);
		btnAnnulerPlanning.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setEmptyPlanning();
			}
		});
		
		btnEnregistrerPlanning = new JButton("");
		btnEnregistrerPlanning.setBounds(460, 453, 190, 39);
		panelPlanning.add(btnEnregistrerPlanning);
		btnEnregistrerPlanning.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (isPlanning == true) {
					dropPlanning();
					setEmptyPlanning();
					btnAnnulerPlanning.setEnabled(true);
				} else {
					if (generatePlanning() == true) {
						setPlanning();
						btnAnnulerPlanning.setEnabled(false);
					}
				}
			}
		});
		
		/**
		 *  Parametres
		 */
		
		panelParametres = new JPanel();
		tabbedPaneMain.addTab("Param\u00E8tres", null, panelParametres, null);
		panelParametres.setLayout(null);
		
		JPanel panelReglageParametre = new JPanel();
		panelReglageParametre.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelReglageParametre.setBounds(10, 11, 215, 104);
		panelParametres.add(panelReglageParametre);
		panelReglageParametre.setLayout(null);
		
		JLabel lblNbPersonneParametre = new JLabel("Nombre de personne");
		lblNbPersonneParametre.setBounds(10, 21, 125, 14);
		panelReglageParametre.add(lblNbPersonneParametre);
		
		textFieldNbPersonneParametre = new JTextField();
		textFieldNbPersonneParametre.setBounds(147, 18, 42, 20);
		textFieldNbPersonneParametre.setText(ParametreCtrl.getNbPersonne(1));
		panelReglageParametre.add(textFieldNbPersonneParametre);
		textFieldNbPersonneParametre.setColumns(10);
		
		JButton btnEnregistrerParametre = new JButton("Enregistrer");
		btnEnregistrerParametre.setBounds(31, 58, 158, 23);
		panelReglageParametre.add(btnEnregistrerParametre);
		btnEnregistrerParametre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ParametreCtrl.updateNbPersonne(textFieldNbPersonneParametre.getText());
				textFieldNbPersonneJaiFaim.setText(ParametreCtrl.getNbPersonne(1));
				if (isPlanning == false) {
					instance.setEmptyPlanning();
				}
			}
		});
		
		JButton btnGestionRecettesFavoris = new JButton("Gestion recettes favoris");
		btnGestionRecettesFavoris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modeListParametre = true;
				scrollPaneFavorisParametre.setViewportView(listFavorisParametre);
			}
		});
		btnGestionRecettesFavoris.setBounds(279, 11, 205, 28);
		panelParametres.add(btnGestionRecettesFavoris);
		
		JButton btnHistoriqueRecette = new JButton("Gestion historique");
		btnHistoriqueRecette.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modeListParametre = false;
				scrollPaneFavorisParametre.setViewportView(listHistoriqueParametre);
			}
		});
		btnHistoriqueRecette.setBounds(279, 50, 205, 28);
		panelParametres.add(btnHistoriqueRecette);
		
		JPanel panelFavorisParametre = new JPanel();
		panelFavorisParametre.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelFavorisParametre.setBounds(508, 11, 391, 481);
		panelParametres.add(panelFavorisParametre);
		panelFavorisParametre.setLayout(null);
		
		listFavorisParametre = new JList();
		listHistoriqueParametre = new JList();
		
		JButton btnSupprimerRecetteParametre = new JButton("Supprimer");
		btnSupprimerRecetteParametre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (modeListParametre == true) {
					String recette = listFavorisParametre.getSelectedValue();
					if (recette != null) {
						RecetteCtrl.setFavori(RecetteCtrl.getRecetteById(RecetteCtrl.getRecetteIdByName(recette)), false);
						refreshFavoris();
					}
				} else {
					String recette = listHistoriqueParametre.getSelectedValue();
					if (recette != null) {
						HistoriqueCtrl.supprimerDeHistorique(listHistoriqueParametre.getSelectedIndex());
						refreshHistorique();
					}
				}
			}
		});
		btnSupprimerRecetteParametre.setBounds(41, 447, 144, 23);
		panelFavorisParametre.add(btnSupprimerRecetteParametre);
		
		JButton btnVisualiserRecetteParametre = new JButton("Voir la recette");
		btnVisualiserRecetteParametre.setBounds(218, 447, 150, 23);
		panelFavorisParametre.add(btnVisualiserRecetteParametre);
		
		scrollPaneFavorisParametre = new JScrollPane();
		scrollPaneFavorisParametre.setViewportView(listFavorisParametre);
		listFavorisParametre.setBorder(new TitledBorder(null, "Favoris", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		listHistoriqueParametre.setBorder(new TitledBorder(null, "Historique", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		listFavorisParametre.setModel(remplissageListFavorisRecette());
		listHistoriqueParametre.setModel(remplissageListHistoriqueRecette());
		scrollPaneFavorisParametre.setBounds(21, 11, 360, 425);
		panelFavorisParametre.add(scrollPaneFavorisParametre);
		
		JButton btnEffacerHistorique = new JButton("Effacer mon historique");
		btnEffacerHistorique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "Voulez-vous effacer l'historique?") == 0) {
					HistoriqueCtrl.effacerHistorique();
					refreshHistorique();
				}
			}
		});
		btnEffacerHistorique.setBounds(279, 89, 205, 28);
		panelParametres.add(btnEffacerHistorique);
		
		JScrollPane scrollPaneSCategorieAutorisee = new JScrollPane();
		scrollPaneSCategorieAutorisee.setBounds(10, 142, 186, 350);
		panelParametres.add(scrollPaneSCategorieAutorisee);
		
		listSCategorieAutorisee = new JList();
		listSCategorieAutorisee.setBorder(new TitledBorder(null, "Autorisé", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		listSCategorieAutorisee.setModel(remplissageListSCategorieAutorisee());
		scrollPaneSCategorieAutorisee.setViewportView(listSCategorieAutorisee);
		
		JScrollPane scrollPaneSCategorieInterdite = new JScrollPane();
		scrollPaneSCategorieInterdite.setBounds(298, 142, 186, 350);
		panelParametres.add(scrollPaneSCategorieInterdite);
		
		listSCategorieInterdite = new JList();
		listSCategorieInterdite.setBorder(new TitledBorder(null, "Interdit", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		listSCategorieInterdite.setModel(remplissageListSCategorieInterdite());
		scrollPaneSCategorieInterdite.setViewportView(listSCategorieInterdite);
		
		JButton btnInterdireCategorie = new JButton(">>");
		btnInterdireCategorie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selection = listSCategorieAutorisee.getSelectedValue();
				if (selection != null) {
					SousCategorieCtrl.setInterdit(selection);
					instance.refreshSousCategorie();
				}
			}
		});
		btnInterdireCategorie.setBounds(206, 261, 82, 23);
		panelParametres.add(btnInterdireCategorie);
		
		JButton btnAutoriserCategorie = new JButton("<<");
		btnAutoriserCategorie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selection = listSCategorieInterdite.getSelectedValue();
				if (selection != null) {
					SousCategorieCtrl.setAutorise(selection);
					instance.refreshSousCategorie();
				}
			}
		});
		btnAutoriserCategorie.setBounds(206, 322, 82, 23);
		panelParametres.add(btnAutoriserCategorie);
		btnVisualiserRecetteParametre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (modeListParametre == true) {
					String recette = listFavorisParametre.getSelectedValue();
					if (recette != null) {
						RecetteCtrl.AfficherRecetteByName(recette, ParametreCtrl.getNbPersonne(1));
					}
				} else {
					String recette = listHistoriqueParametre.getSelectedValue();
					if (recette != null) {
						RecetteCtrl.AfficherRecetteByName(recette, ParametreCtrl.getNbPersonne(1));
					}
				}
			}
		});
		
		panelRecherche = new JPanel();
		tabbedPaneMain.addTab("Rechercher recette", null, panelRecherche, null);
		panelRecherche.setLayout(null);
		
		JPanel panelParametreRecherche = new JPanel();
		panelParametreRecherche.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelParametreRecherche.setBounds(10, 11, 334, 255);
		panelRecherche.add(panelParametreRecherche);
		panelParametreRecherche.setLayout(null);
		
		JLabel lblNomRecherche = new JLabel("Mot cl\u00E9");
		lblNomRecherche.setBounds(41, 40, 46, 14);
		panelParametreRecherche.add(lblNomRecherche);
		
		textFieldNomRecherche = new JTextField();
		textFieldNomRecherche.setBounds(113, 37, 166, 20);
		panelParametreRecherche.add(textFieldNomRecherche);
		textFieldNomRecherche.setColumns(10);
		
		JButton btnRechercher = new JButton("Rechercher Tout");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] recettes = RecetteCtrl.getRecettesNames(textFieldNomRecherche.getText());
				listRecetteRecherche.setListData(recettes);
			}
		});
		btnRechercher.setBounds(113, 98, 166, 37);
		panelParametreRecherche.add(btnRechercher);
		
		JButton btnRechercherFavoris = new JButton("Rechercher Favoris");
		btnRechercherFavoris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] recettes = RecetteCtrl.getRecettesNamesFavoris(textFieldNomRecherche.getText());
				listRecetteRecherche.setListData(recettes);
			}
		});
		btnRechercherFavoris.setBounds(113, 170, 166, 37);
		panelParametreRecherche.add(btnRechercherFavoris);
		
		JButton btnVoirRecetteRecherche = new JButton("Voir la recette");
		btnVoirRecetteRecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String recette = listRecetteRecherche.getSelectedValue();
				if (recette != null) {
					RecetteCtrl.AfficherRecetteByName(recette, ParametreCtrl.getNbPersonne(1));
				}
			}
		});
		btnVoirRecetteRecherche.setBounds(775, 237, 116, 43);
		panelRecherche.add(btnVoirRecetteRecherche);
		
		JScrollPane scrollPaneRecetteRecherche = new JScrollPane();
		scrollPaneRecetteRecherche.setBounds(403, 11, 334, 481);
		panelRecherche.add(scrollPaneRecetteRecherche);
		
		listRecetteRecherche = new JList();
		scrollPaneRecetteRecherche.setViewportView(listRecetteRecherche);
		
	}
	
	private void endConstruction() {
		rdbtnPlan.add(rdbtnMatin1);
		rdbtnPlan.add(rdbtnMatin2);
		rdbtnPlan.add(rdbtnMatin3);
		rdbtnPlan.add(rdbtnMatin4);
		rdbtnPlan.add(rdbtnMatin5);
		rdbtnPlan.add(rdbtnMidi1);
		rdbtnPlan.add(rdbtnMidi2);
		rdbtnPlan.add(rdbtnMidi3);
		rdbtnPlan.add(rdbtnMidi4);
		rdbtnPlan.add(rdbtnMidi5);
		rdbtnPlan.add(rdbtnSoir1);
		rdbtnPlan.add(rdbtnSoir2);
		rdbtnPlan.add(rdbtnSoir3);
		rdbtnPlan.add(rdbtnSoir4);
		rdbtnPlan.add(rdbtnSoir5);
		
		textFieldNbPlan.add(textFieldNbMatin1);
		textFieldNbPlan.add(textFieldNbMatin2);
		textFieldNbPlan.add(textFieldNbMatin3);
		textFieldNbPlan.add(textFieldNbMatin4);
		textFieldNbPlan.add(textFieldNbMatin5);
		textFieldNbPlan.add(textFieldNbMidi1);
		textFieldNbPlan.add(textFieldNbMidi2);
		textFieldNbPlan.add(textFieldNbMidi3);
		textFieldNbPlan.add(textFieldNbMidi4);
		textFieldNbPlan.add(textFieldNbMidi5);
		textFieldNbPlan.add(textFieldNbSoir1);
		textFieldNbPlan.add(textFieldNbSoir2);
		textFieldNbPlan.add(textFieldNbSoir3);
		textFieldNbPlan.add(textFieldNbSoir4);
		textFieldNbPlan.add(textFieldNbSoir5);
		
		comboBoxPlan.add(comboBoxMatin1);
		comboBoxPlan.add(comboBoxMatin2);
		comboBoxPlan.add(comboBoxMatin3);
		comboBoxPlan.add(comboBoxMatin4);
		comboBoxPlan.add(comboBoxMatin5);
		comboBoxPlan.add(comboBoxMidi1);
		comboBoxPlan.add(comboBoxMidi2);
		comboBoxPlan.add(comboBoxMidi3);
		comboBoxPlan.add(comboBoxMidi4);
		comboBoxPlan.add(comboBoxMidi5);
		comboBoxPlan.add(comboBoxSoir1);
		comboBoxPlan.add(comboBoxSoir2);
		comboBoxPlan.add(comboBoxSoir3);
		comboBoxPlan.add(comboBoxSoir4);
		comboBoxPlan.add(comboBoxSoir5);
		
		textFieldRPlan.add(textFieldRMatin1);
		textFieldRPlan.add(textFieldRMatin2);
		textFieldRPlan.add(textFieldRMatin3);
		textFieldRPlan.add(textFieldRMatin4);
		textFieldRPlan.add(textFieldRMatin5);
		textFieldRPlan.add(textFieldRMidi1);
		textFieldRPlan.add(textFieldRMidi2);
		textFieldRPlan.add(textFieldRMidi3);
		textFieldRPlan.add(textFieldRMidi4);
		textFieldRPlan.add(textFieldRMidi5);
		textFieldRPlan.add(textFieldRSoir1);
		textFieldRPlan.add(textFieldRSoir2);
		textFieldRPlan.add(textFieldRSoir3);
		textFieldRPlan.add(textFieldRSoir4);
		textFieldRPlan.add(textFieldRSoir5);
		
		btnPlan.add(btnMatin1);
		btnPlan.add(btnMatin2);
		btnPlan.add(btnMatin3);
		btnPlan.add(btnMatin4);
		btnPlan.add(btnMatin5);
		btnPlan.add(btnMidi1);
		btnPlan.add(btnMidi2);
		btnPlan.add(btnMidi3);
		btnPlan.add(btnMidi4);
		btnPlan.add(btnMidi5);
		btnPlan.add(btnSoir1);
		btnPlan.add(btnSoir2);
		btnPlan.add(btnSoir3);
		btnPlan.add(btnSoir4);
		btnPlan.add(btnSoir5);
		
		if (RepasCtrl.isPlanning()) {
			isPlanning = true;
			btnAnnulerPlanning.setEnabled(false);
			setPlanning();
		} else {
			isPlanning = false;
			setEmptyPlanning();
			btnAnnulerPlanning.setEnabled(true);
		}
	}

	public DefaultTableModel remplissageTableProduitFrigo() {
        Vector<String> titre = new Vector<String>();
        titre.add("Nom");
        titre.add("Quantité ");
        titre.add("Unité");
        titre.add("Supprimer");
        titre.add("Ajouter");
        
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
	
	public AbstractListModel remplissageListFavorisRecette() {
		AbstractListModel mod = new AbstractListModel() {
			String[] values = RecetteCtrl.getRecettesFavorisNames();
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		};
		
		return mod;
	}
	
	public AbstractListModel remplissageListHistoriqueRecette() {
		AbstractListModel mod = new AbstractListModel() {
			String[] values = HistoriqueCtrl.getRecetteHistoriqueNames();
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		};
		
		return mod;
	}
	
	public AbstractListModel remplissageListAlimentFrigo() {
		AbstractListModel mod = new AbstractListModel() {
			String[] values = AlimentCtrl.getAlimentsNamesFrigo();
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		};
		
		return mod;
	}
	
	public AbstractListModel remplissageListSCategorieAutorisee() {
		AbstractListModel mod = new AbstractListModel() {
			String[] values = SousCategorieCtrl.getAllAutorisee();
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		};
		
		return mod;
	}
	
	public AbstractListModel remplissageListSCategorieInterdite() {
		AbstractListModel mod = new AbstractListModel() {
			String[] values = SousCategorieCtrl.getAllInterdite();
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		};
		
		return mod;
	}
	
	public static boolean isPositiveInteger(String str)  
	{  
		  try  
		  {  
		    int i = Integer.parseInt(str);
		    if (i <= 0) {
		    	return false;
		    }
		  }  
		  catch(NumberFormatException nfe)  
		  {  
		    return false;  
		  } 
		  return true;  
	}
	
	public static void refreshFavoris() {
		instance.listFavoris.setModel(instance.remplissageListFavorisRecette());
		instance.listFavorisParametre.setModel(instance.remplissageListFavorisRecette());
	}

	public static void refreshFrigo() {
		instance.tableAlimentFrigo.setModel(instance.remplissageTableProduitFrigo());
		instance.listFrigo.setModel(instance.remplissageListAlimentFrigo());
	}

	public static void refreshHistorique() {
		instance.listHistorique.setModel(instance.remplissageListHistoriqueRecette());
		instance.listHistoriqueParametre.setModel(instance.remplissageListHistoriqueRecette());
	}
	
	public static void refreshSousCategorie() {
		instance.listSCategorieAutorisee.setModel(instance.remplissageListSCategorieAutorisee());
		instance.listSCategorieInterdite.setModel(instance.remplissageListSCategorieInterdite());
	}

	public void setEmptyPlanning() {
		String nbPersonne = ParametreCtrl.getNbPersonne(1);
		for (JTextField t : instance.textFieldNbPlan) {
			t.setText(nbPersonne);
			t.setEditable(true);
		}
		
		for (JTextField t : instance.textFieldRPlan) {
			t.setText("");
		}
		
		for (JComboBox c : instance.comboBoxPlan) {
			c.setEnabled(true);
			c.removeAllItems();
		}
		
		String[] typeRecette = TypeRecetteCtrl.getAllTypeRecetteNames();
		for (String type : typeRecette) {
			for (JComboBox c : instance.comboBoxPlan) {
				c.addItem(type);
			}
		}
		
		for (JRadioButton r : instance.rdbtnPlan) {
			r.setEnabled(true);
			r.setSelected(false);
		}
		
		for (JButton b : instance.btnPlan) {
			b.setEnabled(false);
		}
		
		btnEnregistrerPlanning.setText("Générer planning");
	}
	

	public void setPlanning() {
		instance.setEmptyPlanning();
		
		for (JTextField t : instance.textFieldNbPlan) {
			t.setText("");
			t.setEditable(false);
		}
		
		for (JComboBox c : instance.comboBoxPlan) {
			c.setEnabled(false);
		}
		
		Vector<Repas> repas = RepasCtrl.getPlanning();
		for (Repas r: repas) {
			int index = ((r.getIdHeureRepas() - 1) * 5) + (r.getJour() - 1);
			instance.textFieldNbPlan.get(index).setText("" + r.getNombrePersonne());
			instance.textFieldNbPlan.get(index).setEditable(true);
			instance.rdbtnPlan.get(index).setSelected(true);
			Recette recette = RecetteCtrl.getRecetteById(r.getIdRecette());
			instance.comboBoxPlan.get(index).setSelectedIndex(TypeRecetteCtrl.getIndexByRecette(recette));
			instance.comboBoxPlan.get(index).setEnabled(true);
			instance.textFieldRPlan.get(index).setText(recette.getNom());
			instance.textFieldRPlan.get(index).setCaretPosition(0);
			instance.btnPlan.get(index).setEnabled(true);
		}
		
		btnEnregistrerPlanning.setText("Supprimer planning");
	}
	
	public void dropPlanning() {
		RepasCtrl.dropPlanning();
		instance.isPlanning = false;
	}
	
	public boolean generatePlanning() {
		Vector<Integer> jour = new Vector<Integer>();
		Vector<Integer> heures = new Vector<Integer>();
		Vector<String> nbPersonnes = new Vector<String>();
		Vector<String> types = new Vector<String>();
		
		if (instance.rdbtnMatin1.isSelected() == true) {
			jour.add(1);
			heures.add(1);
			nbPersonnes.add(instance.textFieldNbMatin1.getText());
			types.add((String) instance.comboBoxMatin1.getSelectedItem());
		}
		
		if (instance.rdbtnMatin2.isSelected() == true) {
			jour.add(2);
			heures.add(1);
			nbPersonnes.add(instance.textFieldNbMatin2.getText());
			types.add((String) instance.comboBoxMatin2.getSelectedItem());
		}
		
		if (instance.rdbtnMatin3.isSelected() == true) {
			jour.add(3);
			heures.add(1);
			nbPersonnes.add(instance.textFieldNbMatin3.getText());
			types.add((String) instance.comboBoxMatin3.getSelectedItem());
		}
		
		if (instance.rdbtnMatin4.isSelected() == true) {
			jour.add(4);
			heures.add(1);
			nbPersonnes.add(instance.textFieldNbMatin4.getText());
			types.add((String) instance.comboBoxMatin4.getSelectedItem());
		}
		
		if (instance.rdbtnMatin5.isSelected() == true) {
			jour.add(5);
			heures.add(1);
			nbPersonnes.add(instance.textFieldNbMatin5.getText());
			types.add((String) instance.comboBoxMatin5.getSelectedItem());
		}
		
		if (instance.rdbtnMidi1.isSelected() == true) {
			jour.add(1);
			heures.add(2);
			nbPersonnes.add(instance.textFieldNbMidi1.getText());
			types.add((String) instance.comboBoxMidi1.getSelectedItem());
		}
		
		if (instance.rdbtnMidi2.isSelected() == true) {
			jour.add(2);
			heures.add(2);
			nbPersonnes.add(instance.textFieldNbMidi2.getText());
			types.add((String) instance.comboBoxMidi2.getSelectedItem());
		}
		
		if (instance.rdbtnMidi3.isSelected() == true) {
			jour.add(3);
			heures.add(2);
			nbPersonnes.add(instance.textFieldNbMidi3.getText());
			types.add((String) instance.comboBoxMidi3.getSelectedItem());
		}
		
		if (instance.rdbtnMidi4.isSelected() == true) {
			jour.add(4);
			heures.add(2);
			nbPersonnes.add(instance.textFieldNbMidi4.getText());
			types.add((String) instance.comboBoxMidi4.getSelectedItem());
		}
		
		if (instance.rdbtnMidi5.isSelected() == true) {
			jour.add(5);
			heures.add(2);
			nbPersonnes.add(instance.textFieldNbMidi5.getText());
			types.add((String) instance.comboBoxMidi5.getSelectedItem());
		}
		
		if (instance.rdbtnSoir1.isSelected() == true) {
			jour.add(1);
			heures.add(3);
			nbPersonnes.add(instance.textFieldNbSoir1.getText());
			types.add((String) instance.comboBoxSoir1.getSelectedItem());
		}
		
		if (instance.rdbtnSoir2.isSelected() == true) {
			jour.add(2);
			heures.add(3);
			nbPersonnes.add(instance.textFieldNbSoir2.getText());
			types.add((String) instance.comboBoxSoir2.getSelectedItem());
		}
		
		if (instance.rdbtnSoir3.isSelected() == true) {
			jour.add(3);
			heures.add(3);
			nbPersonnes.add(instance.textFieldNbSoir3.getText());
			types.add((String) instance.comboBoxSoir3.getSelectedItem());
		}
		
		if (instance.rdbtnSoir4.isSelected() == true) {
			jour.add(4);
			heures.add(3);
			nbPersonnes.add(instance.textFieldNbSoir4.getText());
			types.add((String) instance.comboBoxSoir4.getSelectedItem());
		}
		
		if (instance.rdbtnSoir5.isSelected() == true) {
			jour.add(5);
			heures.add(3);
			nbPersonnes.add(instance.textFieldNbSoir5.getText());
			types.add((String) instance.comboBoxSoir5.getSelectedItem());
		}
		
		if (RepasCtrl.generatePlanning(jour, heures, nbPersonnes, types) == true) {
			instance.isPlanning = true;
			return true;
		} else {
			return false;
		}
	}
}
