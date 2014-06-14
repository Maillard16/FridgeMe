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

	/**
	 * Create the frame.
	 */
	public RecetteFrame(final Recette recette) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle(recette.getNom());
		setBounds(100, 100, 589, 612);
		contentPaneRecette = new JPanel();
		contentPaneRecette.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneRecette);
		contentPaneRecette.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(12, 33, 104, 15);
		contentPaneRecette.add(lblNom);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(12, 130, 94, 15);
		contentPaneRecette.add(lblDescription);
		
		JLabel lblTempsPrep = new JLabel("Temps préparation");
		lblTempsPrep.setBounds(12, 58, 114, 15);
		contentPaneRecette.add(lblTempsPrep);
		
		JLabel lblTempsCuisson = new JLabel("Temps cuisson");
		lblTempsCuisson.setBounds(12, 84, 114, 15);
		contentPaneRecette.add(lblTempsCuisson);
		
		JLabel lblFavoris = new JLabel("Favoris");
		lblFavoris.setBounds(300, 58, 94, 15);
		contentPaneRecette.add(lblFavoris);
		
		lblImage = new JLabel("Lien pour image");
		lblImage.setBounds(12, 466, 114, 15);
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
		lblImage2.setBounds(136, 466, 410, 15);
		contentPaneRecette.add(lblImage2);
		
		JLabel lblNbPersonne = new JLabel("Nombre de personne");
		lblNbPersonne.setBounds(300, 84, 140, 15);
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
		btnFavoris.setBounds(35, 511, 207, 25);
		contentPaneRecette.add(btnFavoris);
		
		JButton btnConsommerRecette = new JButton("Consommer la recette");
		btnConsommerRecette.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsommerRecette.setBounds(317, 511, 207, 25);
		contentPaneRecette.add(btnConsommerRecette);
		
		JScrollPane scrollPaneDescription = new JScrollPane();
		scrollPaneDescription.setBounds(109, 124, 437, 142);
		contentPaneRecette.add(scrollPaneDescription);
		
		JTextArea textAreaDescription = new JTextArea();
		textAreaDescription.setText(recette.getDescription());
		scrollPaneDescription.setViewportView(textAreaDescription);
		
		JLabel lblNom2 = new JLabel(recette.getNom());
		lblNom2.setBounds(136, 33, 268, 14);
		contentPaneRecette.add(lblNom2);
		
		JLabel lblTempsPrep2 = new JLabel(recette.getTempsPreparation() + " minutes");
		lblTempsPrep2.setBounds(136, 58, 140, 14);
		contentPaneRecette.add(lblTempsPrep2);
		
		JLabel lblTempsCuisson2 = new JLabel(recette.getTempsCuisson() + " minutes");
		lblTempsCuisson2.setBounds(136, 84, 140, 14);
		contentPaneRecette.add(lblTempsCuisson2);
		
		lblFavoris2 = new JLabel();
		lblFavoris2.setBounds(450, 58, 94, 14);
		lblFavoris2.setText(recette.isFavoris() ? "oui" : "non");
		contentPaneRecette.add(lblFavoris2);
		
		JLabel lblNbPersonne2 = new JLabel(recette.getNombrePersonne() + "");
		lblNbPersonne2.setBounds(450, 84, 94, 14);
		contentPaneRecette.add(lblNbPersonne2);
		
		JLabel lblIngrdients = new JLabel("Ingrédients");
		lblIngrdients.setBounds(12, 286, 94, 14);
		contentPaneRecette.add(lblIngrdients);
		
		JScrollPane scrollPaneIngredients = new JScrollPane();
		scrollPaneIngredients.setBounds(109, 286, 437, 142);
		contentPaneRecette.add(scrollPaneIngredients);
		
		JTextArea textAreaIngredients = new JTextArea();
		scrollPaneIngredients.setViewportView(textAreaIngredients);
	}
}
