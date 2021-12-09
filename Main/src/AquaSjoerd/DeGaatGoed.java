package AquaSjoerd;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.ImageIcon;
import java.net.URL;
public class DeGaatGoed {
    private JButton instellingenButton;
    private JButton homeButton;
    private JButton abonnementButton;
    private JButton statistiekenButton;
    private JButton persoonlijkeGegevensButton;
    private JPanel mainpanel;
    private JButton inlogButton;
    private JLabel tekst;
    int waterGebruikMaand = 283;
    int waterGebruikVandaag= 12;
    double waterGebruikPerUur = 0.76;
    int opgeslagenWaterGebruikPerMaand;
    int opgeslagenWaterGebruikVandaag;
    double opgeslagenWaterGebruikPerUur;
    String naam = "i";
    String wachtwoord = "";
    String adres = "";
    String stad = "";
    String postcode = "";
    String emailadress = "";
    int abonnementsDuur = 1;
    JFrame frameStatistieken = new JFrame();
    JFrame beginFrame = new JFrame("AquaSjoerd");

    public DeGaatGoed() {


        JOptionPane.showMessageDialog(null, "Welkom bij AquaSjoerd! Registreer u eerst voor gebruik van de applicatie.");


        statistiekenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!naam.equals("")) {
                    ImageIcon image = new ImageIcon("C:\\Users\\jacoc\\Dekstop\\goed\\Afbeelding1.png");
                    JLabel plaatje = new JLabel();
                    image = new ImageIcon(this.getClass().getResource("Afbeelding1.png"));

                    plaatje = new JLabel(image);
                    plaatje.setBounds(0, 0, 600, 410);

                    Border border = BorderFactory.createLineBorder(Color.BLACK);

                    JLabel kopnaam = new JLabel();
                    JPanel koppanel = new JPanel();
                    kopnaam.setText("AquaSjoerd");
                    kopnaam.setFont(new Font("Arial", Font.PLAIN, 20));
                    kopnaam.setHorizontalAlignment(JLabel.CENTER);
                    koppanel.setBackground(new Color(94,163,226));
                    koppanel.add(kopnaam);
                    koppanel.setBounds(75, 0, 650, 50);
                    koppanel.setBorder(border);

                    JPanel statistieken = new JPanel();
                    statistieken.setBounds(0, 0, 75, 50);
                    statistieken.setBackground(new Color(94,163,226));
                    JLabel tab = new JLabel();
                    tab.setText("Statistieken");
                    tab.setFont(new Font("Arial", Font.PLAIN, 14));
                    statistieken.add(tab);
                    tab.setHorizontalAlignment(JLabel.CENTER);
                    statistieken.setBorder(border);


                    JLabel verbuikPerUur = new JLabel();
                    verbuikPerUur.setText("Water per uur verbruikt door druppel irrigatie: " + waterGebruikPerUur + " L");
                    verbuikPerUur.setVerticalAlignment(JLabel.BOTTOM);
                    verbuikPerUur.setHorizontalAlignment(JLabel.LEFT);
                    verbuikPerUur.setFont(new Font("Arial", Font.PLAIN, 13));


                    JLabel waterGebruiktVandaag = new JLabel();
                    waterGebruiktVandaag.setText("Water verbruikt aan druppel irrigatie vandaag: " + waterGebruikVandaag + " L");
                    waterGebruiktVandaag.setFont(new Font("Arial", Font.PLAIN, 13));
                    waterGebruiktVandaag.setHorizontalAlignment(JLabel.LEFT);

                    JLabel verbruik = new JLabel();
                    verbruik.setText("Water gebruikt deze maand door de druppel irrigatie: " + waterGebruikMaand + " L ");
                    verbruik.setFont(new Font("Arial", Font.PLAIN, 13));
                    verbruik.setHorizontalAlignment(JLabel.LEFT);

                    JPanel textVak = new JPanel();
                    textVak.setBorder(border);
                    textVak.setBounds(100, 200, 350, 100);
                    textVak.add(verbruik);
                    textVak.add(waterGebruiktVandaag);
                    textVak.add(verbuikPerUur);
                    textVak.setBackground(new Color(94,163,226));

                    JLabel inhoud = new JLabel();
                    inhoud.setText("Water over in de tank ");
                    inhoud.setVerticalAlignment(JLabel.TOP);
                    inhoud.setHorizontalAlignment(JLabel.LEFT);
                    inhoud.setFont(new Font("Arial", Font.PLAIN, 13));

                    JLabel waarde = new JLabel();
                    waarde.setText("75L/250L");
                    waarde.setVerticalAlignment(JLabel.CENTER);
                    waarde.setHorizontalAlignment(JLabel.CENTER);
                    waarde.setFont(new Font("Arial", Font.PLAIN, 13));

                    JPanel inhoudOver = new JPanel();
                    inhoudOver.setBorder(border);
                    inhoudOver.setBounds(550, 50, 150, 350);
                    inhoudOver.add(inhoud);
                    inhoudOver.add(waarde);
                    inhoudOver.setBackground(new Color(94,163,226));

                    //   JOptionPane.showMessageDialog(null, "Welkom op het Statistiekenscherm!");
//            JFrame frameStatistieken = new JFrame();
                    frameStatistieken.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frameStatistieken.setLayout(null);
                    frameStatistieken.setSize(700, 400);
                    frameStatistieken.setResizable(false);
                    frameStatistieken.setTitle("Statistieken");
                    frameStatistieken.setVisible(true);
                    frameStatistieken.add(koppanel);
                    frameStatistieken.add(statistieken);
                    frameStatistieken.add(textVak);
                    frameStatistieken.add(inhoudOver);
                    frameStatistieken.add(plaatje);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Registreer u eerst voor het gebruik");
                }
            }

        });


        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!naam.equals("")) {
                    Border border = BorderFactory.createLineBorder(Color.BLACK);
                    //   JOptionPane.showMessageDialog(null, "Welkom op het Hoofdscherm!");

                    ImageIcon image = new ImageIcon("C:\\Users\\jacoc\\Dekstop\\goed\\Afbeelding1.png");
                    JLabel plaatje = new JLabel();
                    image = new ImageIcon(this.getClass().getResource("Afbeelding1.png"));
                    plaatje = new JLabel(image);
                    plaatje.setBounds(0, 0, 600, 410);

                    JLabel hoofdScherm = new JLabel();
                    hoofdScherm.setText("Hoofdscherm");
                    hoofdScherm.setFont(new Font("Arial", Font.PLAIN, 13));


                    JPanel hoofd = new JPanel();
                    hoofd.setBounds(0, 0, 90, 50);
                    hoofd.setBorder(border);
                    hoofd.setBackground(new Color(94,163,226));
                    hoofd.add(hoofdScherm);


                    JLabel kopje = new JLabel();
                    kopje.setText("AquaSjoerd");
                    kopje.setFont(new Font("Arial", Font.PLAIN, 20));


                    JPanel kopNaam = new JPanel();
                    kopNaam.setBounds(90, 0, 610, 50);
                    kopNaam.setBorder(border);
                    kopNaam.setBackground(new Color(94,163,226));
                    kopNaam.add(kopje);

                    JLabel nieuwsEnInfo = new JLabel();
                    nieuwsEnInfo.setText("Nieuws en info:");
                    nieuwsEnInfo.setFont(new Font("Arial", Font.PLAIN, 12));


                    JPanel nieuwsEnInfoVak = new JPanel();
                    nieuwsEnInfoVak.setBounds(100, 200, 350, 20);
                    nieuwsEnInfoVak.setBorder(border);
                    nieuwsEnInfoVak.setBackground(new Color(94,163,226));
                    nieuwsEnInfoVak.add(nieuwsEnInfo);


                    JPanel info = new JPanel();
                    info.setBounds(100, 200, 350, 80);
                    info.setBorder(border);
                    info.setBackground(new Color(94,163,226));


                    JLabel naamKopje = new JLabel();
                    naamKopje.setText("Statistieken");
                    naamKopje.setFont(new Font("Arial", Font.PLAIN, 12));


                    JPanel statistiekenKopje = new JPanel();
                    statistiekenKopje.setBounds(600, 50, 100, 20);
                    statistiekenKopje.setBorder(border);
                    statistiekenKopje.setBackground(new Color(94,163,226));
                    statistiekenKopje.add(naamKopje);

                    JLabel statistiekenTekst = new JLabel();
                    statistiekenTekst.setText("(Info)");
                    statistiekenTekst.setFont(new Font("Arial", Font.PLAIN, 12));


                    JPanel statistiekenInfo = new JPanel();
                    statistiekenInfo.setBounds(600, 70, 100, 330);
                    statistiekenInfo.setBorder(border);
                    statistiekenInfo.setBackground(new Color(94,163,226));
                    statistiekenInfo.add(statistiekenTekst);

                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frame.setLayout(null);
                    frame.setSize(700, 400);
                    frame.setResizable(false);
                    frame.setTitle("Hoofdscherm");
                    frame.setVisible(true);
                    frame.add(kopNaam);
                    frame.add(hoofd);
                    frame.add(nieuwsEnInfoVak);
                    frame.add(info);
                    frame.add(statistiekenKopje);
                    frame.add(statistiekenInfo);
                    frame.add(plaatje);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Registreer u eerst voor het gebruik");
                }
            }
        });


        instellingenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!naam.equals("")) {
                    Border border = BorderFactory.createLineBorder(Color.BLACK);

                    ImageIcon image = new ImageIcon("C:\\Users\\jacoc\\Dekstop\\goed\\Afbeelding1.png");
                    JLabel plaatje = new JLabel();
                    image = new ImageIcon(this.getClass().getResource("Afbeelding1.png"));
                    plaatje = new JLabel(image);
                    plaatje.setBounds(100, 0, 600, 410);

                    JButton slaStatistiekenOp = new JButton();
                    slaStatistiekenOp.setBounds(10, 70, 150, 100);
                    slaStatistiekenOp.setText("Sla statistieken op");
                    slaStatistiekenOp.setFont(new Font("Arial", Font.PLAIN, 10));

                    JButton opvragenPG = new JButton();
                    opvragenPG.setText("Opvragen Persoonlijke gegevens");
                    opvragenPG.setFont(new Font("Arial", Font.PLAIN, 10));

                    JButton resetStats = new JButton();
                    resetStats.setText("Reset statistieken en machine");
                    resetStats.setFont(new Font("Arial", Font.PLAIN, 10));

                    slaStatistiekenOp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            opgeslagenWaterGebruikPerMaand = waterGebruikMaand;
                            opgeslagenWaterGebruikPerUur = waterGebruikPerUur;
                            opgeslagenWaterGebruikVandaag = waterGebruikVandaag;
                            JOptionPane.showMessageDialog(null, "Uw statistieken zijn opgeslagen!");
                        }
                    });

                    opvragenPG.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JOptionPane.showMessageDialog(null, ("Er is een email verzonden naar " + emailadress + " waarin staat vermeld welke Persoonlijke gegevens wij van u verwerken."));

                        }
                    });

                    resetStats.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JOptionPane.showMessageDialog(null, "Uw statistieken zijn nu gereset!");

                            waterGebruikMaand = 0;
                            waterGebruikVandaag = 0;
                            waterGebruikPerUur = 0.0;
                        }
                    });


                    JPanel hoofd = new JPanel();
                    hoofd.setBounds(0, 50, 200, 400);
                    hoofd.setBorder(border);
                    hoofd.setBackground(new Color(94,163,226));
                    hoofd.add(slaStatistiekenOp);
                    hoofd.add(opvragenPG);
                    hoofd.add(resetStats);

                    JLabel instellingenNaam = new JLabel();
                    instellingenNaam.setText("Instellingen");
                    instellingenNaam.setFont(new Font("Arial", Font.PLAIN, 12));


                    JPanel instellingen = new JPanel();
                    instellingen.setBounds(0, 0, 90, 50);
                    instellingen.setBorder(border);
                    instellingen.setBackground(new Color(94,163,226));
                    instellingen.add(instellingenNaam);


                    JLabel kopNaam = new JLabel();
                    kopNaam.setText("AquaSjoerd");
                    kopNaam.setFont(new Font("Arial", Font.PLAIN, 20));


                    JPanel kop = new JPanel();
                    kop.setBounds(90, 0, 610, 50);
                    kop.setBorder(border);
                    kop.setBackground(new Color(94,163,226));
                    kop.add((kopNaam));


                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frame.setLayout(null);
                    frame.setSize(700, 400);
                    frame.setResizable(false);
                    frame.setTitle("Instellingen");
                    frame.setVisible(true);
                    frame.add(kop);
                    frame.add(instellingen);
                    frame.add(hoofd);
                    frame.add(plaatje);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Registreer u eerst voor het gebruik");
                }

            }
        });
        abonnementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!naam.equals("")){
                    Border border = BorderFactory.createLineBorder(Color.black, 1);
                    ImageIcon image = new ImageIcon("C:\\Users\\jacoc\\Dekstop\\goed\\Afbeelding1.png");
                    JLabel plaatje = new JLabel();
                    image = new ImageIcon(this.getClass().getResource("Afbeelding1.png"));
                    plaatje = new JLabel(image);
                    plaatje.setBounds(0, 0, 600, 410);


                    JButton knop = new JButton();
                    knop.setText("Verlengen");
                    knop.setFont(new Font("Arial", Font.PLAIN, 14));

                    knop.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            Border border = BorderFactory.createLineBorder(Color.BLACK);

                            JButton knop = new JButton();
                            knop.setText("Submit");


                            JPanel buttonPanel = new JPanel();
                            buttonPanel.setBounds(0, 100, 200, 220);
                            buttonPanel.add(knop);

                            JTextField antwoord = new JTextField();
                            antwoord.setPreferredSize(new Dimension(250, 25));
                            String aantal = antwoord.getText();

                            knop.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    JOptionPane.showMessageDialog(null, "Uw aanzoek tot verlenging is verstuurd. Wij zullen z.s.m. contact met u opnemen!");
//                            abonnementsDuur += aantal;
                                }
                            });

                            JPanel antwoordje = new JPanel();
                            antwoordje.setBounds(0, 25, 300, 200);
                            antwoordje.add(antwoord);


                            JLabel label = new JLabel();
                            label.setText("Hoelang wilt u uw abonnement verlengen?");
                            JPanel text = new JPanel();
                            text.setBounds(0, 0, 300, 100);
                            text.add(label);


                            JFrame frame = new JFrame();
                            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                            frame.setLayout(null);
                            frame.setSize(400, 200);
                            frame.setResizable(false);
                            frame.setTitle("Verlengen");
                            frame.setVisible(true);
                            frame.add(text);
                            frame.add(antwoordje);
                            frame.add(buttonPanel);
                        }
                    });


                    JPanel verlengen = new JPanel();
                    verlengen.setBorder(border);
                    verlengen.setBounds(600, 50, 100, 350);
                    verlengen.setBackground(new Color(94,163,226));
                    verlengen.add(knop);

                    JPanel panel1 = new JPanel();
                    JLabel abonnementen = new JLabel();
                    abonnementen.setText("(Abonnementinformatie)");

                    abonnementen.setFont(new Font("Arial", Font.PLAIN, 14));

                    abonnementen.setBackground(new Color(94,163,226));
                    panel1.setBackground(new Color(94,163,226));
                    panel1.setBounds(100, 100, 210, 200);
                    panel1.add(abonnementen);
                    panel1.setBorder(border);

                    JPanel panel2 = new JPanel();
                    JLabel AquaSjoerd = new JLabel();
                    AquaSjoerd.setText("AquaSjoerd");

                    AquaSjoerd.setFont(new Font("Arial", Font.PLAIN, 20));

                    AquaSjoerd.setOpaque(true);
                    AquaSjoerd.setBackground(new Color(94,163,226));
                    panel2.setBackground(new Color(94,163,226));
                    panel2.setBounds(110, 0, 590, 50);
                    panel2.add(AquaSjoerd);
                    panel2.setBorder(border);


                    JLabel plaats = new JLabel();
                    plaats.setFont(new Font("Arial", Font.PLAIN, 14));
                    JPanel panel3 = new JPanel();
                    plaats.setOpaque(true);
                    plaats.setBackground(new Color(94,163,226));
                    panel3.setBackground(new Color(94,163,226));
                    panel3.setBounds(0, 0, 110, 50);
                    panel3.add(plaats);
                    panel3.setBorder(border);
                    plaats.setText("Abonnementen");

                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frame.setLayout(null);
                    frame.setSize(700, 400);
                    frame.setResizable(false);
                    frame.setTitle("Abonnement");
                    frame.setVisible(true);
                    frame.add(panel1);
                    frame.add(panel2);
                    frame.add(panel3);
                    frame.add(plaatje);
                    frame.add(verlengen);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Registreer u eerst voor het gebruik");
                }
            }
        });
        persoonlijkeGegevensButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!naam.equals("")) {
                    Border border = BorderFactory.createLineBorder(Color.black, 1);
                    ImageIcon image = new ImageIcon("C:\\Users\\jacoc\\Dekstop\\goed\\Afbeelding1.png");
                    JLabel plaatje = new JLabel();
                    image = new ImageIcon(this.getClass().getResource("Afbeelding1.png"));
                    plaatje = new JLabel(image);
                    plaatje.setBounds(0, 0, 600, 416);

                    JButton contactInfo = new JButton();
                    contactInfo.setText("Privacy beleid");
                    contactInfo.setFont(new Font("Arial", Font.PLAIN, 10));

                    contactInfo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JOptionPane.showMessageDialog(null, "Wij gebruiken uw Persoonlijke gegevens alleen voor administratieve processen binnen onze startup. Uw gegevens worden ook niet gedeeld.");
                        }
                    });

                    JLabel naam2 = new JLabel();
                    naam2.setText("Uw naam: " + naam);
                    naam2.setFont(new Font("Arial", Font.PLAIN, 16));

                    JLabel adres2 = new JLabel();
                    adres2.setText("Uw adres: " + adres + "(" + stad + ")");
                    adres2.setFont(new Font("Arial", Font.PLAIN, 16));

                    JLabel postcode2 = new JLabel();
                    postcode2.setText("Uw postcode: " + postcode);
                    postcode2.setFont(new Font("Arial", Font.PLAIN, 16));


                    JPanel gegevens = new JPanel();
                    gegevens.setBounds(60, 90, 300, 230);
                    gegevens.setBorder(border);
                    gegevens.setBackground(new Color(81, 156, 224));
                    gegevens.add(naam2);
                    gegevens.add(adres2);
                    gegevens.add(postcode2);

                    JPanel contact = new JPanel();
                    contact.setBounds(600, 50, 100, 350);
                    contact.setBackground(new Color(94,163,226));
                    contact.setBorder(border);
                    contact.add(contactInfo);

                    JLabel typeNaam = new JLabel();
                    typeNaam.setText("Persoonlijke gegevens");
                    typeNaam.setFont(new Font("Arial", Font.PLAIN, 12));


                    JPanel type = new JPanel();
                    type.setBounds(0, 0, 150, 50);
                    type.setBorder(border);
                    type.setBackground(new Color(94,163,226));
                    type.add(typeNaam);

                    JLabel kopNaam = new JLabel();
                    kopNaam.setText("AquaSjoerd");
                    kopNaam.setFont(new Font("Arial", Font.PLAIN, 20));

                    JPanel kop = new JPanel();
                    kop.setBounds(150, 0, 550, 50);
                    kop.setBorder(border);
                    kop.setBackground(new Color(94,163,226));
                    kop.add(kopNaam);




                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frame.setLayout(null);
                    frame.setSize(700, 400);
                    frame.setResizable(false);
                    frame.setTitle("Abonnement");
                    frame.setVisible(true);
                    frame.add(type);
                    frame.add(kop);
                    frame.add(contact);
                    frame.add(gegevens);
                    frame.add(plaatje);

                }
                else {
                    JOptionPane.showMessageDialog(null, "Registreer u eerst voor het gebruik");
                }
            }
        });
        inlogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JButton submitKnop = new JButton();
                submitKnop.setText("Submit");

                JPanel submitPanel = new JPanel();
                submitPanel.setBounds(500, 100,200, 150);
                submitPanel.add(submitKnop);

                JTextField invoerStad= new JTextField();
                invoerStad.setPreferredSize(new Dimension(200,25));


                JLabel stadLabel = new JLabel();
                stadLabel.setText("Voer hier uw stad in: ");
                stadLabel.setFont(new Font("Arial", Font.PLAIN, 12));

                JPanel stadPanel = new JPanel();
                stadPanel.setBounds(250,150,200,75);
                stadPanel.add(stadLabel);
                stadPanel.add(invoerStad);

                JTextField emailInvoer = new JTextField();
                emailInvoer.setPreferredSize(new Dimension(200,25));


                JLabel emailLabel = new JLabel();
                emailLabel.setText("Voer hier uw emailadres in: ");
                emailLabel.setFont(new Font("Arial", Font.PLAIN,12));

                JPanel emailPanel = new JPanel();
                emailPanel.setBounds(0,150,200,75);
                emailPanel.add(emailLabel);
                emailPanel.add(emailInvoer);

                JTextField invoerPostcode= new JTextField();
                invoerPostcode.setPreferredSize(new Dimension(200,25));



                JLabel postcodeLabel = new JLabel();
                postcodeLabel.setText("Voer hier uw postcode in: ");
                postcodeLabel.setFont(new Font("Arial", Font.PLAIN, 12));


                JPanel postcodePanel = new JPanel();
                postcodePanel.setBounds(250,75,200,75);
                postcodePanel.add(postcodeLabel);
                postcodePanel.add(invoerPostcode);

                JTextField adresInvoer = new JTextField();
                adresInvoer.setPreferredSize(new Dimension(200,25));


                JLabel adresLabel = new JLabel();
                adresLabel.setText("Voer hier uw adres in: ");
                adresLabel.setFont(new Font("Arial", Font.PLAIN, 12));

                JPanel adresPanel = new JPanel();
                adresPanel.setBounds(250,0,200,75);
                adresPanel.add(adresLabel);
                adresPanel.add(adresInvoer);

                JTextField invoerWachtwoord = new JTextField();
                invoerWachtwoord.setPreferredSize(new Dimension(200,25));



                JLabel wachtwoordVraag = new JLabel();
                wachtwoordVraag.setText("Voer uw wachtwoord in: ");
                wachtwoordVraag.setFont(new Font("Arial", Font.PLAIN, 12));


                JPanel wachtwoordPanel = new JPanel();
                wachtwoordPanel.setBounds(0,75,200,50);
                wachtwoordPanel.add(wachtwoordVraag);
                wachtwoordPanel.add(invoerWachtwoord);

                JTextField invoerNaam = new JTextField();
                invoerNaam.setPreferredSize(new Dimension(200,25));
                invoerNaam.setBounds(20,50,200,75);

//                JPanel textFieldNaam = new JPanel();
//                textFieldNaam.add(invoerNaam);

                JLabel vulNaamIn = new JLabel();
                vulNaamIn.setText("Voer uw naam in: ");
                vulNaamIn.setFont(new Font("Arial", Font.PLAIN, 12));


                JPanel naamPanel = new JPanel();
                naamPanel.setBounds(0,0,200,75);
                naamPanel.add(vulNaamIn);
                naamPanel.add(invoerNaam);


                JFrame inlogFrame = new JFrame();
                inlogFrame.setTitle("Registratie");
                inlogFrame.setSize(700,300);
                inlogFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                inlogFrame.setResizable(false);
                inlogFrame.setVisible(true);
                inlogFrame.setLayout(null);
                inlogFrame.add(naamPanel);
                inlogFrame.add(wachtwoordPanel);
                inlogFrame.add(adresPanel);
                inlogFrame.add(postcodePanel);
                inlogFrame.add(emailPanel);
                inlogFrame.add(stadPanel);
                inlogFrame.add(submitPanel);


                submitKnop.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        naam = invoerNaam.getText();
                        wachtwoord =invoerWachtwoord.getText();
                        adres = adresInvoer.getText();
                        postcode = invoerPostcode.getText();
                        emailadress = emailInvoer.getText();
                        stad= invoerStad.getText();
                        JOptionPane.showMessageDialog(null, "Bedankt voor uw registratie " + naam);
                        inlogFrame.setVisible(false);

                    }
                });
            }
        });
    }


    public static void main (String[] args){


        JFrame beginFrame = new JFrame("AquaSjoerd");
        beginFrame.setContentPane(new DeGaatGoed().mainpanel);
        beginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        beginFrame.pack();
        beginFrame.setSize(700, 400);
        beginFrame.setResizable(true);
        beginFrame.setVisible(true);
        beginFrame.setResizable(false);


//            JPanel mainpanel = new JPanel();
//            mainpanel.setBounds(0,0,700,400);
//            mainpanel.setBackground(new Color(94,163,226));
//            frame.add(mainpanel);




    }

}



