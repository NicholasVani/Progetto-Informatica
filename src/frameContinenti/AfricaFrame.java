/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frameContinenti;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Nicholas Vani & Vincenzo Spina
 */
public class AfricaFrame extends JFrame {
     private BufferedImage immagine;
     private JFrame parentFrame;
     private FileRandomNationAfrica fileRandomNation = new FileRandomNationAfrica();
    private FileRandomNationAfrica.Nation randomNation = null;
    private ImageIcon bandieraIcon = null;

    private JPanel bandieraPanel;
    private JPanel nomeNazionePanel;
    private JLabel nomeNazione;

    private NazioneControllo nazioneControllo;

     private int incorrectGuesses = 0;
    private JLabel incorrectLabel;
    private int correctGuesses = 0;
    private JLabel correctLabel;
    
    private Thread timerThread;
    private int timeInSeconds = 0;
    private JLabel timerLabel;
    
    private JButton btnAntiguaEBarbuda, btnBahamas, btnBarbados , btnBelize, btnCanada, btnCostaRica, btnCuba;
    private JButton btnDominica, btnElSalvador, btnGiamaica, btnGrenada, btnGroenlandia, btnGuatemala, btnHaiti;
    private JButton btnHonduras, btnMessico, btnNicaragua, btnPanama, btnPortoRico, btnRepubblicaDominicana;
    private JButton btnSaintKittsENevis, btnSaintLucia, btnSaintVincentEGrenadine, btnStatiUniti, btnTrinidadETobago;

 
    public AfricaFrame(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        setTitle("Africa");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        immagine = FunzioniFrame.caricaImmagine("src/images/africa.png");

        Set<String> tutteLeNazioni = new HashSet<>();
        try {
            tutteLeNazioni = fileRandomNation.getAllNations();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Errore nel caricamento delle nazioni");
        }
        nazioneControllo = new NazioneControllo(tutteLeNazioni);

        JPanel pannelloImmagine = creaPannelloImmagine();
        JPanel menuPanel = creaMenuPanel();

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pannelloImmagine, menuPanel);
        splitPane.setDividerSize(0);
        splitPane.setResizeWeight(0.80);
        splitPane.setEnabled(false);
        
        startTimer();
        
        add(splitPane);
        generaNuovaNazione();
        setVisible(true);
    }

    private JPanel creaPannelloImmagine() {
        JPanel pannelloImmagine = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                FunzioniFrame.disegnaImmagine(g, immagine, getWidth(), getHeight());

                int width = getWidth();
                int height = getHeight();

                /*btnAntiguaEBarbuda.setBounds((int) (width * 0.77), (int) (height * 0.78), 5, 5);
                btnBahamas.setBounds((int) (width * 0.65), (int) (height * 0.70), 15, 15);
                btnBarbados.setBounds((int) (width * 0.78), (int) (height * 0.82), 5, 5);
                btnBelize.setBounds((int) (width * 0.57), (int) (height * 0.78), 15, 15);
                btnCanada.setBounds((int) (width * 0.62), (int) (height * 0.50), 15, 15);
                btnCostaRica.setBounds((int) (width * 0.60), (int) (height * 0.85), 15, 15);
                btnCuba.setBounds((int) (width * 0.63), (int) (height * 0.72), 15, 15);
                btnDominica.setBounds((int) (width * 0.76), (int) (height * 0.80), 5, 5);
                btnElSalvador.setBounds((int) (width * 0.56), (int) (height * 0.81), 15, 15);
                btnGiamaica.setBounds((int) (width * 0.65), (int) (height * 0.77), 15, 15);
                btnGrenada.setBounds((int) (width * 0.77), (int) (height * 0.83), 5, 5);
                btnGroenlandia.setBounds((int) (width * 0.80), (int) (height * 0.30), 15, 15);
                btnGuatemala.setBounds((int) (width * 0.55), (int) (height * 0.79), 15, 15);
                btnHaiti.setBounds((int) (width * 0.68), (int) (height * 0.76), 15, 15);
                btnHonduras.setBounds((int) (width * 0.59), (int) (height * 0.79), 15, 15);
                btnMessico.setBounds((int) (width * 0.47), (int) (height * 0.75), 15, 15);
                btnNicaragua.setBounds((int) (width * 0.59), (int) (height * 0.82), 15, 15);
                btnPanama.setBounds((int) (width * 0.62), (int) (height * 0.86), 15, 15);
                btnPortoRico.setBounds((int) (width * 0.73), (int) (height * 0.76), 15, 15);
                btnRepubblicaDominicana.setBounds((int) (width * 0.70), (int) (height * 0.76), 15, 15);
                btnSaintKittsENevis.setBounds((int) (width * 0.75), (int) (height * 0.78), 5, 5);
                btnSaintLucia.setBounds((int) (width * 0.77), (int) (height * 0.81), 5, 5);
                btnSaintVincentEGrenadine.setBounds((int) (width * 0.77), (int) (height * 0.82), 5, 5); 
                btnStatiUniti.setBounds((int) (width * 0.50), (int) (height * 0.60), 15, 15); 
                btnTrinidadETobago.setBounds((int) (width * 0.77), (int) (height * 0.84), 5, 5);*/
                

            }
        };
        pannelloImmagine.setPreferredSize(new Dimension(800, 600));
        
        /*btnAntiguaEBarbuda= new JButton("");
        btnBahamas = new JButton("");
        btnBarbados = new JButton("");
        btnBelize = new JButton("");
        btnCanada = new JButton("");
        btnCostaRica = new JButton("");
        btnCuba = new JButton("");
        btnDominica = new JButton("");
        btnElSalvador = new JButton("");
        btnGiamaica = new JButton("");
        btnGrenada = new JButton("");
        btnGroenlandia = new JButton("");
        btnGuatemala = new JButton("");
        btnHaiti = new JButton("");
        btnHonduras = new JButton("");
        btnMessico = new JButton("");
        btnNicaragua = new JButton("");
        btnPanama = new JButton("");
        btnPortoRico = new JButton("");
        btnRepubblicaDominicana = new JButton("");
        btnSaintKittsENevis = new JButton("");
        btnSaintLucia = new JButton("");
        btnSaintVincentEGrenadine = new JButton("");
        btnStatiUniti = new JButton("");
        btnTrinidadETobago = new JButton("");*/
        
        for (JButton button : new JButton[]{
            btnAntiguaEBarbuda, btnBahamas, btnBarbados , btnBelize, btnCanada, btnCostaRica, btnCuba, btnDominica, btnElSalvador, btnGiamaica, btnGrenada, btnGroenlandia, btnGuatemala, btnHaiti, btnHonduras, btnMessico, btnNicaragua, btnPanama, btnPortoRico, btnRepubblicaDominicana, btnSaintKittsENevis, btnSaintLucia, btnSaintVincentEGrenadine, btnStatiUniti, btnTrinidadETobago}) {
            
            pannelloImmagine.add(button);
        }

        /*FunzioniFrame.impostaPulsanteNazione(btnAntiguaEBarbuda, "Antigua e Barbuda", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnBahamas, "Bahamas", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnBarbados, "Barbados", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnBelize, "Belize", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnCanada, "Canada", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnCostaRica, "Costa Rica", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnCuba, "Cuba", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnDominica, "Dominica", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnElSalvador, "El Salvador", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnGiamaica, "Giamaica", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnGrenada, "Grenada", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnGroenlandia, "Groenlandia", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnGuatemala, "Guatemala", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnHaiti, "Haiti", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnHonduras, "Honduras", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnMessico, "Messico", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnNicaragua, "Nicaragua", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnPanama, "Panama", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnPortoRico, "Porto Rico", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnRepubblicaDominicana, "Repubblica Dominicana", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnSaintKittsENevis, "Saint Kitts e Nevis", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnSaintLucia, "Saint Lucia", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnSaintVincentEGrenadine, "Saint Vincent e Grenadine", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnStatiUniti, "Stati Uniti d'America", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnTrinidadETobago, "Trinidad e Tobago", randomNation != null ? randomNation.getNameNation() : "");*/



        return pannelloImmagine;
    }
     private JPanel creaMenuPanel() {
        JPanel menuPanel = new JPanel(new GridBagLayout());
        menuPanel.setPreferredSize(new Dimension(200, getHeight()));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.NORTH;

        bandieraPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Ombreggiatura
                Graphics2D g2d = (Graphics2D) g;
                int shadowOffset = 5;
                int shadowSize = 10;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(new Color(0, 0, 0, 50)); // Colore nero con trasparenza per l'ombreggiatura
                g2d.fillRoundRect(shadowOffset, getHeight() - shadowSize, getWidth() - shadowOffset * 2, shadowSize, 10, 10);

                // Disegna l'immagine della bandiera
                if (bandieraIcon != null) {
                    FunzioniFrame.disegnaBandiera(g, bandieraIcon, getWidth(), getHeight());
                }
            }
        };

        bandieraPanel.setPreferredSize(new Dimension(150, 100));
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        menuPanel.add(bandieraPanel, gbc);

        JButton nextButton = new JButton("CAMBIA BANDIERA");
        nextButton.addActionListener(e -> {
                generaNuovaNazione();
                incrementaErrato();
                // Continuare
        });
        nextButton.setBackground(Color.BLUE);
        nextButton.setForeground(Color.WHITE);
        nextButton.setFont(new Font("Arial", Font.BOLD, 14));
        nextButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
        nextButton.setPreferredSize(new Dimension(200, 30));
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        menuPanel.add(nextButton, gbc);

        nomeNazionePanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                FunzioniFrame.adjustFontSize((Graphics2D) g, nomeNazione, this);
            }
        };
        nomeNazione = new JLabel("NomeNazione", JLabel.CENTER);
        nomeNazione.setForeground(Color.BLACK);
        nomeNazionePanel.add(nomeNazione, BorderLayout.CENTER);
        nomeNazionePanel.setPreferredSize(new Dimension(200, 50));
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        menuPanel.add(nomeNazionePanel, gbc);

        incorrectLabel = new JLabel("Errate: " + incorrectGuesses, JLabel.CENTER);
        incorrectLabel.setFont(new Font("Arial", Font.BOLD, 28));  // Aumentato il font e reso grassetto
        incorrectLabel.setForeground(Color.RED);  // Colore rosso per maggiore visibilità
        gbc.weightx = 1.0;
        gbc.weighty = 0.005;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        menuPanel.add(incorrectLabel, gbc);

        gbc.anchor = GridBagConstraints.SOUTH;
        
        correctLabel = new JLabel("Corrette: " + correctGuesses, JLabel.CENTER);
        correctLabel.setFont(new Font("Arial", Font.BOLD, 28));  // Aumentato il font e reso grassetto
        correctLabel.setForeground(new Color(0, 77, 0));  // Colore rosso per maggiore visibilità
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        menuPanel.add(correctLabel, gbc);
        
        timerLabel = new JLabel("00:00", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 30));
        timerLabel.setForeground(Color.BLUE); 
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        menuPanel.add(timerLabel, gbc);
        
        
        JButton backButton = new JButton("ESCI");
        backButton.addActionListener(e -> {
            parentFrame.setVisible(true);
            dispose();
        });
        backButton.setBackground(Color.BLUE);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial", Font.BOLD, 12));
        backButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        backButton.setPreferredSize(new Dimension(100, 30));
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.SOUTH;
        menuPanel.add(backButton, gbc);

        return menuPanel;
    }
     private void randomNat() {
        try {
            randomNation = fileRandomNation.getRandomNation();
            if (randomNation != null) {
                bandieraIcon = new ImageIcon(fileRandomNation.imageFolder + randomNation.getPngFile());
                System.out.println("Nazione generata: " + randomNation.getNameNation()); // Stampa la nazione generata
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     private boolean isGeneratingNewNation = false; // Flag per impedire la generazione multipla

    private void generaNuovaNazione() {
        // Se la generazione di una nuova nazione è già in corso, non fare nulla
        if (isGeneratingNewNation) return;

        isGeneratingNewNation = true; // Imposta il flag a true per evitare nuove generazioni

        // Verifica se tutte le nazioni sono state mostrate
        if (nazioneControllo.tutteNazioniMostrate()) {
            // Supponendo che tu abbia una variabile `numeroErrori` che conta gli errori
            stopTimer();
            JOptionPane.showMessageDialog(
                this, 
                "Congratulazioni! Hai indovinato tutte le nazioni sud americane con: " + incorrectGuesses + " errori.\n"+
                "Tempo passato : "+timeInSeconds+" Secondi"
            );
            isGeneratingNewNation = false; // Reset flag
            
            return;
        }

        // Seleziona una nuova nazione casuale che non è stata già mostrata
        String newNation;
        do {
            randomNat(); // Suppongo che questa funzione generi una nazione casuale
            newNation = randomNation.getNameNation(); // Ottieni il nome della nazione generata
        } while (nazioneControllo.isNazioneMostrata(newNation)); // Continua finché non trovi una nuova nazione

        // Aggiungi la nuova nazione alla lista di quelle mostrate
        nazioneControllo.aggiungiNazioneMostrata(newNation);

        // Imposta il nome della nazione nel campo
        nomeNazione.setText(
            "<html>" +
                "<h2 style='text-align: center; margin-bottom: 0px'>Seleziona la nazione:</h2>" +
                "<h1><center><br><span style='font-size:30px; font-weight:bold; color:#1a001a;'>" + newNation + "</span></br></center></h1>" +
            "</html>"
        );

        // Aggiorna lo stato dei pulsanti
        for (JButton button : new JButton[]{
                btnAntiguaEBarbuda, btnBahamas, btnBarbados , btnBelize, btnCanada, btnCostaRica, btnCuba, btnDominica, btnElSalvador, btnGiamaica, btnGrenada, btnGroenlandia, btnGuatemala, btnHaiti, btnHonduras, btnMessico, btnNicaragua, btnPanama, btnPortoRico, btnRepubblicaDominicana, btnSaintKittsENevis, btnSaintLucia, btnSaintVincentEGrenadine, btnStatiUniti, btnTrinidadETobago
        }) {
            String buttonNationName = button.getText();

            // Imposta solo il comportamento per i pulsanti che sono ancora abilitati
            if (button.isEnabled()) {
                // Resetta il colore e riabilita i pulsanti che non sono stati disabilitati
                button.setBackground(null);
                button.setEnabled(true);    // Riabilita il pulsante
                impostaColorazionePulsante(button, buttonNationName, newNation);
            }
        }

        bandieraPanel.repaint(); // Ridisegna il pannello della bandiera
        isGeneratingNewNation = false; // Reset flag
    }
    // Funzione di normalizzazione dei nomi delle nazioni
    private String normalizzaStringa(String str) {
        // Rimuove spazi extra e converte in minuscolo
        String normalized = str.trim().toLowerCase();

        // Normalizzazione degli accenti (opzionale, aggiungi altri accenti se necessario)
        normalized = normalized.replace("é", "e")
                                 .replace("è", "e")
                                 .replace("à", "a")
                                 .replace("ù", "u")
                                 .replace("ò", "o")
                                 .replace("ç", "c");

        return normalized;
    }
     private void impostaColorazionePulsante(JButton button, String nazioneNome, String randomNationNome) {
        // Rimuovi tutti gli ActionListener esistenti
        for (ActionListener al : button.getActionListeners()) {
            button.removeActionListener(al);
        }

        // Aggiungi un nuovo ActionListener
        button.addActionListener(e -> {
            // Normalizza i nomi (minuscolo e senza spazi extra)
            String normalizedNazioneNome = nazioneNome.trim().toLowerCase();
            String normalizedRandomNationNome = randomNationNome.trim().toLowerCase();

            System.out.println("Pulsante premuto: " + nazioneNome);
            if (normalizedNazioneNome.equals(normalizedRandomNationNome)) {
                // Risposta corretta
                button.setBackground(Color.GREEN);
                button.setEnabled(false);  // Rendi disabilitato il pulsante
                incrementaCorretto();
                generaNuovaNazione();     // Genera una nuova nazione
            } else {
                // Risposta errata
                button.setBackground(Color.RED);
                button.setEnabled(false);  // Disabilita il pulsante errato
                incrementaErrato();        // Incrementa il contatore degli errori

                JOptionPane.showMessageDialog(this, "Errato! questa nazione è: " + nazioneNome);
                

                // Riabilita il pulsante dopo un breve intervallo
                Timer timer = new Timer(500, evt -> {
                    button.setBackground(null);  // Reset colore
                    button.setEnabled(true);     // Riabilita il pulsante errato
                });
                timer.setRepeats(false);
                timer.start();
            }
        });
    }

    private void incrementaErrato() {
        incorrectGuesses++;
        // JOptionPane.showMessageDialog(this, "Incorrect. Try again.");
        System.out.println("Errate: " + correctGuesses);
        FunzioniFrame.aggiornaIncorretto(incorrectLabel, incorrectGuesses);
    }
    private void incrementaCorretto() {
        correctGuesses++;
        // JOptionPane.showMessageDialog(this, "Incorrect. Try again.");
        System.out.println("Corrette: " + correctGuesses);
        FunzioniFrame.aggiornaCorretto(correctLabel, correctGuesses);
    }
    private volatile boolean running = false;
    private void startTimer() {
        if (timerThread == null || !timerThread.isAlive()) {
            running = true; // Avvia il timer
            timerThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (running) {
                        try {
                            // Incrementa il tempo ogni secondo
                            timeInSeconds++;

                            // Calcola minuti e secondi
                            int minutes = timeInSeconds / 60;
                            int seconds = timeInSeconds % 60;

                            // Formatta il tempo come "mm:ss"
                            String timeString = String.format("%02d:%02d", minutes, seconds);

                            // Aggiorna l'etichetta del timer nella GUI
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    timerLabel.setText(timeString);
                                }
                            });

                            // Pausa di 1 secondo
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            // Se il thread è interrotto, esce dal ciclo
                            if (!running) {
                                Thread.currentThread().interrupt(); // Imposta il flag di interruzione
                                break; // Esce dal ciclo while
                            }
                        }
                    }
                }
            });
            timerThread.start(); // Avvia il thread
        }
    }
    
    private void stopTimer() {
        running = false; // Ferma il timer
        if (timerThread != null && timerThread.isAlive()) {
            timerThread.interrupt(); // Interrompe il thread se è in pausa
            try {
                timerThread.join(); // Aspetta che il thread finisca
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
