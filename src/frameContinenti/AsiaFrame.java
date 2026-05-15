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
public class AsiaFrame extends JFrame {
     private BufferedImage immagine;
     private JFrame parentFrame;
     private FileRandomNationAsia fileRandomNation = new FileRandomNationAsia();
    private FileRandomNationAsia.Nation randomNation = null;
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
    private JButton btnCina, btnGiappone, btnCoreadelNord, btnCoreadelSud;
    private JButton btnMongolia, btnTaiwan, btnAfghanistan, btnBangladesh, btnBhutan, btnIndia, btnMaldive, btnNepal, btnPakistan, btnSriLanka, btnBrunei, btnCambogia, btnFilippine, btnIndonesia, btnLaos, btnMalaysia;
    private JButton btnMyanmar, btnSingapore, btnThailandia, btnVietnam, btnArabiaSaudita, btnBahrain, btnCipro, btnEmiratiArabiUniti, btnIran, btnIraq, btnIsraele,btnGiordania;
    private JButton btnKuwait,btnLibano, btnOman,btnQatar,btnSiria, btnTurchia, btnYemen, btnKazakistan, btnKirghizistan, btnTagikistan, btnTurkmenistan, btnUzbekistan;

    
    
    public AsiaFrame(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        setTitle("Asia");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        immagine = FunzioniFrame.caricaImmagine("src/images/asia.png");

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

                /*btnArgentina.setBounds((int) (width * 0.48), (int) (height * 0.70), 15, 15);// coordinate del quadratino
                btnBrasile.setBounds((int) (width * 0.58), (int) (height * 0.30), 15, 15);// height più aumenta piu in basso , width piu aumenta piu a destra
                btnCile.setBounds((int) (width * 0.42), (int) (height * 0.61), 15, 15);
                btnPeru.setBounds((int) (width * 0.33), (int) (height * 0.31), 15, 15);
                btnColombia.setBounds((int) (width * 0.36), (int) (height * 0.15), 15, 15);
                btnVenezuela.setBounds((int) (width * 0.43), (int) (height * 0.07), 15, 15);
                btnEcuador.setBounds((int) (width * 0.30), (int) (height * 0.20), 15, 15);
                btnBolivia.setBounds((int) (width * 0.47), (int) (height * 0.42), 15, 15);
                btnParaguay.setBounds((int) (width * 0.54), (int) (height * 0.51), 15, 15);
                btnUruguay.setBounds((int) (width * 0.56), (int) (height * 0.63), 15, 15);
                btnGuyana.setBounds((int) (width * 0.50), (int) (height * 0.09), 15, 15);
                btnSuriname.setBounds((int) (width * 0.53), (int) (height * 0.10), 15, 15);*/
                

            }
        };
        pannelloImmagine.setPreferredSize(new Dimension(800, 600));

        btnCina = new JButton("");
        btnGiappone = new JButton("");
        btnCoreadelNord = new JButton("");
        btnCoreadelSud = new JButton("");
        btnMongolia = new JButton("");
        btnTaiwan = new JButton("");
        btnAfghanistan = new JButton("");
        btnBangladesh = new JButton("");
        btnBhutan = new JButton("");
        btnIndia= new JButton("");
        btnMaldive= new JButton("");
        btnNepal= new JButton("");
        btnPakistan = new JButton("");
        btnSriLanka = new JButton("");
        btnBrunei = new JButton("");
        btnCambogia = new JButton("");
        btnFilippine= new JButton("");
        btnIndonesia= new JButton("");
        btnLaos = new JButton("");
        btnMalaysia = new JButton("");
        btnSingapore= new JButton("");
        btnMyanmar= new JButton("");
        btnThailandia= new JButton("");
        btnVietnam= new JButton("");
        btnArabiaSaudita = new JButton("");
        btnBahrain= new JButton("");
        btnCipro= new JButton("");
        btnEmiratiArabiUniti= new JButton("");
        btnIran= new JButton("");
        btnIraq= new JButton("");
        btnIsraele= new JButton("");
        btnGiordania= new JButton("");
        btnKuwait= new JButton("");
        btnLibano= new JButton("");
        btnOman= new JButton("");
        btnQatar= new JButton("");
        btnSiria= new JButton("");
        btnTurchia= new JButton("");
        btnYemen= new JButton("");
        btnKazakistan= new JButton("");
        btnKirghizistan= new JButton("");
        btnTagikistan= new JButton("");
        btnTurkmenistan= new JButton("");
        btnUzbekistan= new JButton("");
        
        for (JButton button : new JButton[]{
            btnCina, btnGiappone, btnCoreadelNord, btnCoreadelSud, btnMongolia, btnTaiwan, btnAfghanistan, btnBangladesh, btnBhutan, btnIndia, btnMaldive, btnNepal, btnPakistan, btnSriLanka, btnBrunei, btnCambogia, btnFilippine, btnIndonesia, btnLaos, btnMalaysia,
            btnMyanmar, btnSingapore, btnThailandia, btnVietnam, btnArabiaSaudita, btnBahrain, btnCipro, btnEmiratiArabiUniti, btnIran, btnIraq, btnIsraele,btnGiordania, btnKuwait,btnLibano, btnOman,btnQatar,btnSiria, btnTurchia, btnYemen, btnKazakistan, btnKirghizistan, btnTagikistan, btnTurkmenistan, btnUzbekistan
            }) {
            
            pannelloImmagine.add(button);
        }

        
        FunzioniFrame.impostaPulsanteNazione(btnCina, "Cina", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnGiappone, "Giappone", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnCoreadelNord, "Corea del Nord", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnCoreadelSud, "Corea del Sud", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnMongolia, "Mongolia", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnTaiwan, "Taiwan", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnAfghanistan, "Afghanistan", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnBangladesh, "Bangladesh", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnBhutan, "Bhutan", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnIndia, "India", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnMaldive, "Maldive", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnNepal, "Nepal", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnPakistan, "Pakistan", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnSriLanka, "Sri Lanka", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnBrunei, "Brunei", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnCambogia, "Cambogia", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnFilippine, "Filippine", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnIndonesia, "Indonesia", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnLaos, "Laos", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnMalaysia, "Malaysia", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnSingapore, "Singapore", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnThailandia, "Thailandia", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnVietnam, "Vietnam", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnArabiaSaudita, "Arabia Saudita", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnBahrain, "Bahrain", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnCipro, "Cipro", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnEmiratiArabiUniti, "Emirati Arabi Uniti", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnIran, "Iran", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnIraq, "Iraq", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnIsraele, "Israele", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnGiordania, "Giordania", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnKuwait, "Kuwait", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnLibano, "Libano", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnOman, "Oman", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnQatar, "Qatar", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnSiria, "Siria", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnTurchia, "Turchia", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnYemen, "Yemen", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnKazakistan, "Kazakistan", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnKirghizistan, "Kirghizistan", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnTagikistan, "Tagikistan", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnTurkmenistan, "Turkmenistan", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnUzbekistan, "Uzbekistan", randomNation != null ? randomNation.getNameNation() : "");
        FunzioniFrame.impostaPulsanteNazione(btnMyanmar, "Myanmar", randomNation != null ? randomNation.getNameNation() : "");
        



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
                btnCina, btnGiappone, btnCoreadelNord, btnCoreadelSud, btnMongolia, btnTaiwan, btnAfghanistan, btnBangladesh, btnBhutan, btnIndia, btnMaldive, btnNepal, btnPakistan, btnSriLanka, btnBrunei, btnCambogia, btnFilippine, btnIndonesia, btnLaos, btnMalaysia,
            btnMyanmar, btnSingapore, btnThailandia, btnVietnam, btnArabiaSaudita, btnBahrain, btnCipro, btnEmiratiArabiUniti, btnIran, btnIraq, btnIsraele,btnGiordania, btnKuwait,btnLibano, btnOman,btnQatar,btnSiria, btnTurchia, btnYemen, btnKazakistan, btnKirghizistan, btnTagikistan, btnTurkmenistan, btnUzbekistan
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
