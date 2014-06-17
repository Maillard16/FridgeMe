package view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JCheckBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import ctrl.RecetteCtrl;
import bo.Recette;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecetteFrame extends JFrame {

	private JPanel contentPaneRecette;
	private JScrollPane scrollDescription;
	private JLabel lblImage;
	private JLabel lblImage2;
	
	private JLabel lblFavoris2;
	private JButton btnFavoris;
	private JTextField textFieldNbConsommateur;

	/**
	 * Create the frame.
	 */
	public RecetteFrame(final Recette recette, String nbPersonne) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle(recette.getNom());
		this.setResizable(false);
		setBounds(100, 100, 727, 664);
		contentPaneRecette = new JPanel();
		contentPaneRecette.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneRecette);
		contentPaneRecette.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(12, 22, 104, 15);
		contentPaneRecette.add(lblNom);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(14, 266, 94, 15);
		contentPaneRecette.add(lblDescription);
		
		JLabel lblTempsPrep = new JLabel("Temps préparation");
		lblTempsPrep.setBounds(12, 47, 114, 15);
		contentPaneRecette.add(lblTempsPrep);
		
		JLabel lblTempsCuisson = new JLabel("Temps cuisson");
		lblTempsCuisson.setBounds(411, 47, 114, 15);
		contentPaneRecette.add(lblTempsCuisson);
		
		JLabel lblFavoris = new JLabel("Favoris");
		lblFavoris.setBounds(138, 566, 94, 15);
		contentPaneRecette.add(lblFavoris);
		
		lblImage = new JLabel("Lien pour image");
		lblImage.setBounds(12, 538, 114, 15);
		contentPaneRecette.add(lblImage);
		
		lblImage2 = new JLabel(recette.getImage());
		lblImage2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				      if (e.getClickCount() > 0) {
				          if (Desktop.isDesktopSupported()) {
				                                try {
				                    String osName = System.getProperty("os.name");
				                    String urlPath = recette.getImage();

				                    if (osName.startsWith("Windows"))
				                        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + urlPath);
				                    else {
				                        String[] browsers = { "firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape" };
				                        String browser = null;
				                        for (int count = 0; count < browsers.length && browser == null; count++)
				                            if (Runtime.getRuntime().exec(new String[] { "which", browsers[count] }).waitFor() == 0)
				                                browser = browsers[count];
				                        Runtime.getRuntime().exec(new String[] { browser, urlPath });
				                    }
				                }
				                catch (Exception ex) {
				                    JOptionPane.showMessageDialog(null, "Error in opening browser" + ":\n" + ex.getLocalizedMessage());
				                }
				        }
				      }
				   
			}
		});
		lblImage2.setBounds(136, 538, 410, 15);
		contentPaneRecette.add(lblImage2);
		
		JLabel lblNbPersonne = new JLabel("Nombre de personne");
		lblNbPersonne.setBounds(411, 22, 140, 15);
		contentPaneRecette.add(lblNbPersonne);
		
		btnFavoris = new JButton();
		if (recette.isFavoris()) {
			btnFavoris.setText("Retirer des favoris");
		} else {
			btnFavoris.setText("Ajouter aux favoris");
		}
		btnFavoris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (recette.isFavoris()) {
					RecetteCtrl.setFavori(recette, false);
					btnFavoris.setText("Ajouter aux favoris");
					lblFavoris2.setText("non");
				} else {
					RecetteCtrl.setFavori(recette, true);
					btnFavoris.setText("Retirer des favoris");
					lblFavoris2.setText("oui");
				}
				PrincipaleFrame.refreshFavoris();
			}
		});
		btnFavoris.setBounds(111, 592, 195, 25);
		contentPaneRecette.add(btnFavoris);
		
		JButton btnConsommerRecette = new JButton("Consommer la recette");
		btnConsommerRecette.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecetteCtrl.consommerRecette(recette, textFieldNbConsommateur.getText());
				PrincipaleFrame.refreshFrigo();
				PrincipaleFrame.refreshHistorique();
			}
		});
		btnConsommerRecette.setBounds(389, 592, 207, 25);
		contentPaneRecette.add(btnConsommerRecette);
		
		JScrollPane scrollPaneDescription = new JScrollPane();
		scrollPaneDescription.setBounds(14, 292, 689, 235);
		contentPaneRecette.add(scrollPaneDescription);
		
		JTextArea textAreaDescription = new JTextArea();
		textAreaDescription.setText(recette.getDescription());
		textAreaDescription.setCaretPosition(0);
		scrollPaneDescription.setViewportView(textAreaDescription);
		
		JLabel lblNom2 = new JLabel(recette.getNom());
		lblNom2.setBounds(136, 22, 268, 14);
		contentPaneRecette.add(lblNom2);
		
		JLabel lblTempsPrep2 = new JLabel(recette.getTempsPreparation() + " minutes");
		lblTempsPrep2.setBounds(136, 47, 140, 14);
		contentPaneRecette.add(lblTempsPrep2);
		
		JLabel lblTempsCuisson2 = new JLabel(recette.getTempsCuisson() + " minutes");
		lblTempsCuisson2.setBounds(561, 47, 140, 14);
		contentPaneRecette.add(lblTempsCuisson2);
		
		lblFavoris2 = new JLabel();
		lblFavoris2.setBounds(242, 566, 94, 14);
		lblFavoris2.setText(recette.isFavoris() ? "oui" : "non");
		contentPaneRecette.add(lblFavoris2);
		
		JLabel lblNbPersonne2 = new JLabel(recette.getNombrePersonne() + "");
		lblNbPersonne2.setBounds(561, 22, 94, 14);
		contentPaneRecette.add(lblNbPersonne2);
		
		JLabel lblIngrdients = new JLabel("Ingrédients");
		lblIngrdients.setBounds(14, 73, 94, 14);
		contentPaneRecette.add(lblIngrdients);
		
		JScrollPane scrollPaneIngredients = new JScrollPane();
		scrollPaneIngredients.setBounds(14, 92, 689, 163);
		contentPaneRecette.add(scrollPaneIngredients);
		
		JTextArea textAreaIngredients = new JTextArea();
		textAreaIngredients.setText(RecetteCtrl.getIngredientsText(recette));
		textAreaIngredients.setCaretPosition(0);
		scrollPaneIngredients.setViewportView(textAreaIngredients);
		
		JLabel lblNbConsommateur = new JLabel("Nombre de personne");
		lblNbConsommateur.setBounds(389, 567, 140, 14);
		contentPaneRecette.add(lblNbConsommateur);
		
		textFieldNbConsommateur = new JTextField();
		textFieldNbConsommateur.setBounds(550, 564, 44, 20);
		contentPaneRecette.add(textFieldNbConsommateur);
		textFieldNbConsommateur.setColumns(10);
		textFieldNbConsommateur.setText(nbPersonne);
	}
}
