package AquaSjoerd;

import javax.swing.*;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.ImageIcon;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.IconUIResource;
import java.net.URL;
import com.fazecast.jSerialComm.*;

public class DeGaatGoed {
    private JButton instellingenButton;
    private JButton homeButton;
    private JButton abonnementButton;
    private JButton statistiekenButton;
    private JButton persoonlijkeGegevensButton;
    private JPanel mainpanel;
    private JButton inlogButton;
    private JButton Gewassen;
    private JLabel tekst;
    double waterGebruikMaand;
    double waterGebruikVandaag;
    String tekstGebruikMaand;
    double waterGebruikPerUur;
    double opgeslagenWaterGebruikPerMaand;
    double opgeslagenWaterGebruikVandaag;
    double opgeslagenWaterGebruikPerUur;
    double inhoudBak = 22.0;
    double overigeInhoudBak;
    int oudWaterMaand;
    double vorigeAantalLiters;
    double geenResetLiters;
    JFrame gekframe = new JFrame();
    int intinhoud = 22;
    String andersNaam = "";
    String naam = "";
    String wachtwoord = "";
    String andersKeren = "";
    int volledigVol= 100;
    String adres = "";
    String stad = "";
    String postcode = "";
    String emailadress = "";
    String aantalAndersKeren;
    int aantalGeirrigeerd = 5;
    int abonnementsDuur = 7;
    JFrame frameStatistieken = new JFrame();
    JFrame beginFrame = new JFrame("AquaSjoerd");
    int getalNul = 0;
    int verlengingTeller = 0;
    int registratieTeller =0;
    int andersNummer;
    int hebNodig;
    int ookNodig;
    public static int volume = 0;
    public static int humidity = 0;
    public static String temperatuur = "00.00";
    public static int lichtintensiteit = 0;
    public static int bodemvochtigheid = 0;
    public static String pomp = "uit";
    public static int counter = 0;
    public static int totaleHoeveelheidIrrigatie =0;



    public DeGaatGoed() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/irrigatie", "root", "Rinnegan999!");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM klantendatabaseaquasjoerd.klant;");

            while (resultSet.next()) {
                naam = resultSet.getString("Naam");
                adres = resultSet.getString("Adres");
                postcode= resultSet.getString("Postcode");
                stad = resultSet.getString("stad");
                wachtwoord = resultSet.getString("wachtwoord");
                postcode = resultSet.getString("postcode");
            }
        } catch (SQLException a) {
            JOptionPane.showMessageDialog(null,"Error in de database");
        }
        if (naam == "") {
            JOptionPane.showMessageDialog(null, "Welkom bij AquaSjoerd! Registreer u eerst voor gebruik van de applicatie.");
        }
        else {
            JOptionPane.showMessageDialog(null, "Welkom "+ naam);
        }
        statistiekenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!naam.equals("")) {


                    JLabel plaatje = new JLabel();
                    ImageIcon image = new ImageIcon(this.getClass().getResource("Afbeelding1.png"));

                    plaatje = new JLabel(image);
                    plaatje.setBounds(0, 0, 600, 410);

                    Border border = BorderFactory.createLineBorder(Color.BLACK);

                    JLabel kopnaam = new JLabel();
                    JPanel koppanel = new JPanel();
                    kopnaam.setText("AquaSjoerd");
                    kopnaam.setFont(new Font("Times New Roman", Font.PLAIN, 22));
                    kopnaam.setHorizontalAlignment(JLabel.CENTER);
                    koppanel.setBackground(new Color(94, 163, 226));
                    koppanel.add(kopnaam);
                    koppanel.setBounds(75, 0, 650, 50);
                    koppanel.setBorder(border);

                    JPanel statistieken = new JPanel();
                    statistieken.setBounds(0, 0, 75, 50);
                    statistieken.setBackground(new Color(94, 163, 226));
                    JLabel tab = new JLabel();
                    tab.setText("Statistieken");
                    tab.setFont(new Font("Arial", Font.PLAIN, 14));
                    statistieken.add(tab);
                    tab.setHorizontalAlignment(JLabel.CENTER);
                    statistieken.setBorder(border);
                    JLabel verbuikPerUur = new JLabel();
                    try {

                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/irrigatie", "root", "Rinnegan999!");
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM irrigatie.hoeveelheden;");

                        while (resultSet.next()) {


                            waterGebruikPerUur = (waterGebruikVandaag/24);
                            String text = String.format("%.2f", waterGebruikPerUur);
                            verbuikPerUur.setText("Water per uur verbruikt door druppel irrigatie: " + text + " L");
                        }

                    } catch (SQLException a) {
                        System.out.println("Error in de database");
                    }
                    verbuikPerUur.setVerticalAlignment(JLabel.BOTTOM);
                    verbuikPerUur.setHorizontalAlignment(JLabel.LEFT);
                    verbuikPerUur.setFont(new Font("Arial", Font.PLAIN, 13));


                    JLabel waterGebruiktVandaag = new JLabel();

                    waterGebruiktVandaag.setFont(new Font("Arial", Font.PLAIN, 13));
                    waterGebruiktVandaag.setHorizontalAlignment(JLabel.LEFT);

                    JLabel verbruik = new JLabel();
                    verbruik.setFont(new Font("Arial", Font.ITALIC,14));
                    try {

                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/irrigatie", "root", "Rinnegan999!");
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM irrigatie.hoeveelheden;");

                        while (resultSet.next()) {
                            waterGebruikMaand = inhoudBak - (DeGaatGoed.volume * inhoudBak /100);
                            hebNodig = resultSet.getInt("Liters");
                            tekstGebruikMaand = String.format("%.2f", waterGebruikMaand);
                            verbruik.setFont(new Font("Arial", Font.ITALIC,14));
                            verbruik.setText("Water gebruikt deze maand door de druppel irrigatie: " + tekstGebruikMaand + " L ");

                        }

                    } catch (SQLException a) {
                        System.out.println("Error in de database");
                    }
                    try {

                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/irrigatie", "root", "Rinnegan999!");
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM irrigatie.hoeveelheden;");

                        while (resultSet.next()) {
                            waterGebruikVandaag = resultSet.getInt("Liters");
                            waterGebruikVandaag = (waterGebruikMaand/30);
                            String kaas = String.format("%.2f", waterGebruikVandaag);
                           // waterGebruiktVandaag.setFont(new Font("Arial", Font.ITALIC,14));
                            waterGebruiktVandaag.setText("Water verbruikt aan druppel irrigatie vandaag: " + kaas + " L");
                        oudWaterMaand = resultSet.getInt("Liters");
                        }

                    } catch (SQLException a) {
                        System.out.println("Error in de database");
                    }
                    verbruik.setFont(new Font("Arial", Font.PLAIN, 13));
                    verbruik.setHorizontalAlignment(JLabel.LEFT);

                    JPanel textVak = new JPanel();
                    textVak.setBorder(border);
                    textVak.setBounds(100, 200, 400, 100);
                    textVak.add(verbruik);
                    textVak.add(waterGebruiktVandaag);
                   // textVak.add(verbuikPerUur);
                    textVak.setBackground(new Color(94, 163, 226));

                    JLabel inhoud = new JLabel();
                    inhoud.setText("Water over in de tank ");
                    inhoud.setVerticalAlignment(JLabel.TOP);
                    inhoud.setHorizontalAlignment(JLabel.LEFT);
                    inhoud.setFont(new Font("Arial", Font.ITALIC, 13));

                    JLabel waarde = new JLabel();
                    try {

                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/irrigatie", "root", "Rinnegan999!");
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM irrigatie.hoeveelheden;");

                        while (resultSet.next()) {
                      overigeInhoudBak = inhoudBak * DeGaatGoed.volume / 100;
                         waarde.setText(overigeInhoudBak + "L /" +inhoudBak+"L");

                        }

                    } catch (SQLException a) {
                        System.out.println("Error in de database");
                    }
                    waarde.setVerticalAlignment(JLabel.CENTER);
                    waarde.setHorizontalAlignment(JLabel.CENTER);
                    waarde.setFont(new Font("Arial", Font.PLAIN, 13));

                    JButton refreshKnop = new JButton();
                    refreshKnop.setText("Refresh statistieken");
                    refreshKnop.setBackground(new Color(94, 163, 226));
                    refreshKnop.setBorder(border);

                    try {

                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/irrigatie", "root", "Rinnegan999!");
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM irrigatie.hoeveelheden;");

                        while (resultSet.next()) {
                            geenResetLiters = resultSet.getInt("Liters");
                        }

                    } catch (SQLException a) {
                        System.out.println("Error in de database");
                    }

                    JProgressBar bar = new JProgressBar(0,100);
                    bar.setBounds(0,50,525,50);
                    bar.setStringPainted(true);
                    bar.setValue(DeGaatGoed.volume);
                    bar.setForeground(Color.BLUE);
                    bar.setBackground(Color.BLACK);

                    refreshKnop.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {


                            bar.setValue(DeGaatGoed.volume);
                            verbruik.setText("Water gebruikt deze maand door de druppel irrigatie: " + tekstGebruikMaand + " L ");



                            try {

                                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/irrigatie", "root", "Rinnegan999!");
                                Statement statement = connection.createStatement();
                                ResultSet resultSet = statement.executeQuery("SELECT * FROM irrigatie.hoeveelheden;");

                                while (resultSet.next()) {
                                    geenResetLiters = resultSet.getInt("Liters");
                                    overigeInhoudBak = inhoudBak * DeGaatGoed.volume/100;
                                    waarde.setText(overigeInhoudBak + "L /" +inhoudBak+"L");

                                }

                            } catch (SQLException a) {
                                System.out.println("Error in de database");
                            }
                        }
                    });

                    JLabel humidtyLabel = new JLabel();
                    String humidityGeg = String.format("Luchtvochtigheid: %d %%", DeGaatGoed.humidity);
                    humidtyLabel.setText(humidityGeg);

                    JLabel temperatuurLabel = new JLabel();
                    String temperatuurGeg = String.format("Temperatuur: %s C", DeGaatGoed.temperatuur);
                    temperatuurLabel.setText(temperatuurGeg);

                    JLabel lichtintensiteitLabel = new JLabel();
                    String sterkte;
                    if (DeGaatGoed.lichtintensiteit < 20 ){
                        sterkte = "donker";
                    } else if (DeGaatGoed.lichtintensiteit < 40){
                        sterkte = "dim";
                    } else if (DeGaatGoed.lichtintensiteit < 60){
                        sterkte = "mid";
                    } else if (DeGaatGoed.lichtintensiteit < 80){
                        sterkte = "fel";
                    } else {
                        sterkte = "zeer fel";
                    }
                    String lichtintensiteitGeg = String.format("Lichtsterkte: %d (%s)", DeGaatGoed.lichtintensiteit, sterkte);
                    lichtintensiteitLabel.setText(lichtintensiteitGeg);

                    JLabel bodemLabel = new JLabel();
                    String bodemString = String.format("Bodemvochtigheid: %d", DeGaatGoed.bodemvochtigheid);
                    bodemLabel.setText(bodemString);

                    JLabel pompStatusLabel = new JLabel();
                    String pompStatusString = String.format("Pomp: %s", DeGaatGoed.pomp);
                    pompStatusLabel.setText(pompStatusString);

                    JLabel totaalGeirrigeerdLabel = new JLabel();
                    String totaaleGeirrigeerdString = String.format("Totaal geïrrigeerd: %d L", DeGaatGoed.totaleHoeveelheidIrrigatie);
                    totaalGeirrigeerdLabel.setText(totaaleGeirrigeerdString);

                    JPanel refreshPanel = new JPanel();
                    refreshPanel.setBounds(525, 125, 175, 275);
                    refreshPanel.setBackground(new Color(94, 163, 226));
                    refreshPanel.setBorder(border);
                    refreshPanel.add(humidtyLabel);
                    refreshPanel.add(temperatuurLabel);
                    refreshPanel.add(lichtintensiteitLabel);
                    refreshPanel.add(bodemLabel);
                    refreshPanel.add(pompStatusLabel);
                    refreshPanel.add(totaalGeirrigeerdLabel);

                    JPanel inhoudOver = new JPanel();
                    inhoudOver.setBorder(border);
                    inhoudOver.setBounds(525, 50, 175, 75);
                    inhoudOver.add(inhoud);
                    inhoudOver.add(waarde);
                    inhoudOver.setBackground(new Color(94, 163, 226));
                    inhoudOver.add(refreshKnop);





//                    volledigVol = 0;
//                    double nodigheid = ((inhoudBak-geenResetLiters)/inhoudBak)*100;










//                    if (nodigheid == 0){
//                        bar.setString("De ton is leeg!");
//                    }

                    JPanel progressBarPanel = new JPanel();
                    progressBarPanel.setBounds(0,50,550,50);
                    progressBarPanel.add(bar);


                    frameStatistieken.add(bar);
                    frameStatistieken.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frameStatistieken.setLayout(null);
                    frameStatistieken.setSize(700, 400);
                    frameStatistieken.setResizable(false);
                    frameStatistieken.setTitle("Statistieken");
                    frameStatistieken.setVisible(true);
                    frameStatistieken.add(inhoudOver);
                    frameStatistieken.add(refreshPanel);
                    frameStatistieken.add(koppanel);
                    frameStatistieken.add(statistieken);
                    frameStatistieken.add(textVak);
                //    frameStatistieken.add(progressBarPanel);
                    frameStatistieken.add(plaatje);


                } else {
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


                    JLabel plaatje = new JLabel();
                    ImageIcon image = new ImageIcon(this.getClass().getResource("Afbeelding1.png"));
                    plaatje = new JLabel(image);
                    plaatje.setBounds(0, 0, 600, 410);

                    JLabel hoofdScherm = new JLabel();
                    hoofdScherm.setText("Hoofdscherm");
                    hoofdScherm.setFont(new Font("Arial", Font.PLAIN, 13));


                    JPanel hoofd = new JPanel();
                    hoofd.setBounds(0, 0, 90, 50);
                    hoofd.setBorder(border);
                    hoofd.setBackground(new Color(94, 163, 226));
                    hoofd.add(hoofdScherm);


                    JLabel kopje = new JLabel();
                    kopje.setText("AquaSjoerd");
                    kopje.setFont(new Font("Times New Roman", Font.PLAIN, 22));


                    JPanel kopNaam = new JPanel();
                    kopNaam.setBounds(90, 0, 610, 50);
                    kopNaam.setBorder(border);
                    kopNaam.setBackground(new Color(94, 163, 226));
                    kopNaam.add(kopje);

                    JLabel nieuwsEnInfo = new JLabel();
                    nieuwsEnInfo.setText("Nieuws en info:");
                    nieuwsEnInfo.setFont(new Font("Arial", Font.ITALIC, 12));


                    JPanel nieuwsEnInfoVak = new JPanel();
                    nieuwsEnInfoVak.setBounds(100, 200, 350, 20);
                    nieuwsEnInfoVak.setBorder(border);
                    nieuwsEnInfoVak.setBackground(new Color(94, 163, 226));
                    nieuwsEnInfoVak.add(nieuwsEnInfo);


                    JPanel info = new JPanel();
                    info.setBounds(100, 220, 350, 80);
                    info.setBorder(border);
                    info.setBackground(new Color(94, 163, 226));


                    JLabel echtNieuws = new JLabel();
                    echtNieuws.setText("Al gekeken naar de Black Friday deals van AquaSjoerd?");

                    JLabel meerNieuws = new JLabel();
                    meerNieuws.setText("Volg ons ook op Instagram! @Sjoerd_De_Aap");


                    info.add(echtNieuws);
                    info.add(meerNieuws);

                    JLabel naamKopje = new JLabel();
                    naamKopje.setText(" Opgeslagen statistieken");
                    naamKopje.setFont(new Font("Arial", Font.ITALIC, 12));


                    JPanel statistiekenKopje = new JPanel();
                    statistiekenKopje.setBounds(500, 50, 200, 20);
                    statistiekenKopje.setBorder(border);
                    statistiekenKopje.setBackground(new Color(94, 163, 226));
                    statistiekenKopje.add(naamKopje);


                    JLabel statistiekenTekst = new JLabel();
                    if (opgeslagenWaterGebruikPerMaand > 0) {
                        String limiet = String.format("Water geÏrrigeerd: %.2f L", opgeslagenWaterGebruikPerMaand);
                        statistiekenTekst.setText(limiet);
                    }
                    else {
                        statistiekenTekst.setText("Er is nog niks opgeslagen");
                    }
                    statistiekenTekst.setFont(new Font("Arial", Font.PLAIN, 12));


                    JPanel statistiekenInfo = new JPanel();
                    statistiekenInfo.setBounds(500, 70, 200, 330);
                    statistiekenInfo.setBorder(border);
                    statistiekenInfo.setBackground(new Color(94, 163, 226));
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
                } else {
                    JOptionPane.showMessageDialog(null, "Registreer u eerst voor het gebruik");
                }
            }
        });


        instellingenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!naam.equals("")) {
                    Border border = BorderFactory.createLineBorder(Color.BLACK);


                    JLabel plaatje = new JLabel();
                    ImageIcon image = new ImageIcon(this.getClass().getResource("Afbeelding1.png"));
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

                            try {

                                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/irrigatie", "root", "Rinnegan999!");
                                Statement statement = connection.createStatement();
                                ResultSet resultSet = statement.executeQuery("SELECT * FROM irrigatie.hoeveelheden;");

                                while (resultSet.next()) {
                                    waterGebruikMaand = resultSet.getInt("Liters");
                                    opgeslagenWaterGebruikPerMaand = inhoudBak - (inhoudBak * DeGaatGoed.volume/100);;
                                    opgeslagenWaterGebruikVandaag = opgeslagenWaterGebruikPerMaand/30;

                                }

                            } catch (SQLException a) {
                                System.out.println("Error in de database");
                            }

                            opgeslagenWaterGebruikVandaag = waterGebruikVandaag;
                            JOptionPane.showMessageDialog(null, "Uw statistieken zijn opgeslagen!");
                        }
                    });

                    opvragenPG.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            try {
                                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/irrigatie", "root", "Rinnegan999!");
                                Statement statement = connection.createStatement();
                                ResultSet resultSet = statement.executeQuery("SELECT * FROM klantendatabaseaquasjoerd.klant;");


                                while (resultSet.next()) {
                                    emailadress = resultSet.getString("Emailadres");
                                }
                                JOptionPane.showMessageDialog(null, ("Er is een email verzonden naar " + emailadress + " waarin staat vermeld welke persoonlijke gegevens wij van u verwerken."));


                            } catch (SQLException a) {
                                JOptionPane.showMessageDialog(null,"Error in de database");
                            }


                        }
                    });

                    resetStats.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JOptionPane.showMessageDialog(null, "Uw statistieken zijn nu gereset!");
                            try {

                                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/irrigatie", "root", "Rinnegan999!");
                                Statement statement = connection.createStatement();
                                ResultSet resultSet = statement.executeQuery("SELECT * FROM irrigatie.hoeveelheden;");

                                statement.executeUpdate("insert into hoeveelheden values('"+ getalNul + "')");




                            } catch (SQLException a) {
                                System.out.println("Error in de database");
                            }

                        }
                    });


                    JPanel hoofd = new JPanel();
                    hoofd.setBounds(0, 50, 200, 400);
                    hoofd.setBorder(border);
                    hoofd.setBackground(new Color(94, 163, 226));
                    hoofd.add(slaStatistiekenOp);
                    hoofd.add(opvragenPG);
                    hoofd.add(resetStats);

                    JLabel instellingenNaam = new JLabel();
                    instellingenNaam.setText("Instellingen");
                    instellingenNaam.setFont(new Font("Arial", Font.PLAIN, 12));


                    JPanel instellingen = new JPanel();
                    instellingen.setBounds(0, 0, 90, 50);
                    instellingen.setBorder(border);
                    instellingen.setBackground(new Color(94, 163, 226));
                    instellingen.add(instellingenNaam);


                    JLabel kopNaam = new JLabel();
                    kopNaam.setText("AquaSjoerd");
                    kopNaam.setFont(new Font("Times New Roman", Font.PLAIN, 22));


                    JPanel kop = new JPanel();
                    kop.setBounds(90, 0, 610, 50);
                    kop.setBorder(border);
                    kop.setBackground(new Color(94, 163, 226));
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
                } else {
                    JOptionPane.showMessageDialog(null, "Registreer u eerst voor het gebruik");
                }

            }
        });
        abonnementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!naam.equals("")) {
                    Border border = BorderFactory.createLineBorder(Color.black, 1);

                    JLabel plaatje = new JLabel();
                    ImageIcon image = new ImageIcon(this.getClass().getResource("Afbeelding1.png"));
                    plaatje = new JLabel(image);
                    plaatje.setBounds(0, 0, 600, 410);


                    JButton knop = new JButton();
                    knop.setText("Verlengen");
                    knop.setFont(new Font("Arial", Font.PLAIN, 14));

                    knop.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (verlengingTeller == 0) {
                                Border border = BorderFactory.createLineBorder(Color.BLACK);

                                String[] maandenLijst = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

                                JComboBox lijst = new JComboBox(maandenLijst);


//                        JButton maanden12Knop = new JButton();
//                        maanden12Knop.setText("12 maanden");

//                        JPanel maanden12 = new JPanel();
//                        maanden12.setBounds(300,100,150,100);
//                        maanden12.add(maanden12Knop);
//                        maanden12.add(lijst);

//                        JButton maanden6Knop = new JButton();
//                        maanden6Knop.setText("6 maanden");
//
//                        JPanel maanden6 = new JPanel();
//                        maanden6.setBounds(150,100,150,100);
//                        maanden6.add(maanden6Knop);

//                        JButton maanden3Knop = new JButton();
//                        maanden3Knop.setText("3 maanden");
                                JLabel maandenLabelLel = new JLabel();
                                maandenLabelLel.setText(" Maanden");
                                JPanel maanden3 = new JPanel();
                                maanden3.setBounds(0, 50, 150, 100);
//                        maanden3.add(maanden3Knop);
                                maanden3.add(lijst);
                                maanden3.add(maandenLabelLel);
//                        JButton knop = new JButton();
//                        knop.setText("Submit");
                                JButton submitKnop = new JButton();
                                submitKnop.setText("Submit");

                                JPanel submitButtonPanel = new JPanel();
                                submitButtonPanel.setBounds(150, 50, 75, 50);
                                submitButtonPanel.add(submitKnop);


//
//                        JPanel buttonPanel = new JPanel();
//                        buttonPanel.setBounds(0, 150, 200, 100);
//                        buttonPanel.add(knop);

//                        JTextField antwoord = new JTextField();
//                        antwoord.setPreferredSize(new Dimension(250, 25));
//                        String aantal = antwoord.getText();


                                JPanel antwoordje = new JPanel();
                                antwoordje.setBounds(0, 25, 300, 200);
                                // antwoordje.add(antwoord);


                                JLabel label = new JLabel();
                                label.setText("Hoelang wilt u uw abonnement verlengen?");
                                JPanel text = new JPanel();
                                text.setBounds(0, 0, 300, 100);
                                text.add(label);



                                gekframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                                gekframe.setLayout(null);
                                gekframe.setSize(350, 150);
                                gekframe.setResizable(false);
                                gekframe.setTitle("Verlengen");
                                gekframe.setVisible(true);
                                gekframe.add(text);
                                gekframe.add(antwoordje);
//                      frame.add(buttonPanel);
                                gekframe.add(maanden3);
//                      frame.add(maanden6);
//                      frame.add(maanden12);
                                gekframe.add(submitButtonPanel);

                                submitKnop.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if (verlengingTeller == 0) {
                                            JOptionPane.showMessageDialog(null, "Uw verzoek tot verlenging is verstuurd!");
                                            gekframe.setVisible(false);
                                            verlengingTeller++;
                                        }
                                    }
                                });
                            }

                            else {
                                JOptionPane.showMessageDialog(null, "U heeft recent al een verzoek ingediend, probeer het over een maand weer.");
                            }


                            knop.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    JOptionPane.showMessageDialog(null, "Uw aanzoek tot verlenging is verstuurd. Wij zullen z.s.m. contact met u opnemen!");
                    gekframe.setVisible(false);

                                }
                            });
                        }
                    });


                    JPanel verlengen = new JPanel();
                    verlengen.setBorder(border);
                    verlengen.setBounds(600, 50, 100, 350);
                    verlengen.setBackground(new Color(94, 163, 226));
                    verlengen.add(knop);

                    JPanel panel1 = new JPanel();
                    JLabel abonnementen = new JLabel();
                    abonnementen.setFont(new Font("Arial", Font.ITALIC,14));
                    abonnementen.setText("Abonnementsinformatie");

                    JLabel kosten = new JLabel();
                    kosten.setText("€12,79 per maand");
                    kosten.setFont(new Font("Arial", Font.PLAIN, 15));

                    JLabel aantalMaanden = new JLabel();
                    aantalMaanden.setText("Nog " + abonnementsDuur + " maand(en) over");
                    aantalMaanden.setFont(new Font("Arial", Font.PLAIN, 15));

                    JLabel beginDatum = new JLabel();
                    beginDatum.setText("Startdatum: 13-01-2022");
                    beginDatum.setFont(new Font("Arial", Font.PLAIN, 15));

                    JLabel eindDatum = new JLabel();
                    eindDatum.setText("Einddatum: 13-08-2022");
                    eindDatum.setFont(new Font("Arial", Font.PLAIN, 15));

                    abonnementen.setBackground(new Color(94, 163, 226));
                    panel1.setBackground(new Color(94, 163, 226));
                    panel1.setBounds(100, 100, 210, 200);
                    panel1.add(abonnementen);
                    panel1.setBorder(border);
                    panel1.add(kosten);
                    panel1.add(aantalMaanden);
                    panel1.add(beginDatum);
                    panel1.add(eindDatum);

                    JPanel panel2 = new JPanel();
                    JLabel AquaSjoerd = new JLabel();
                    AquaSjoerd.setText("AquaSjoerd");

                    AquaSjoerd.setFont(new Font("Times New Roman", Font.PLAIN, 22));

                    AquaSjoerd.setOpaque(true);
                    AquaSjoerd.setBackground(new Color(94, 163, 226));
                    panel2.setBackground(new Color(94, 163, 226));
                    panel2.setBounds(110, 0, 590, 50);
                    panel2.add(AquaSjoerd);
                    panel2.setBorder(border);


                    JLabel plaats = new JLabel();
                    plaats.setFont(new Font("Arial", Font.PLAIN, 14));
                    JPanel panel3 = new JPanel();
                    plaats.setOpaque(true);
                    plaats.setBackground(new Color(94, 163, 226));
                    panel3.setBackground(new Color(94, 163, 226));
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
                } else {
                    JOptionPane.showMessageDialog(null, "Registreer u eerst voor het gebruik");
                }
            }
        });
        persoonlijkeGegevensButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!naam.equals("")) {
                    Border border = BorderFactory.createLineBorder(Color.black, 1);

                    JLabel plaatje = new JLabel();
                    ImageIcon image = new ImageIcon(this.getClass().getResource("Afbeelding1.png"));
                    plaatje = new JLabel(image);
                    plaatje.setBounds(0, 0, 600, 416);

                    JButton contactInfo = new JButton();
                    contactInfo.setText("Privacy beleid ");
                    contactInfo.setFont(new Font("Arial", Font.PLAIN, 10));

                    contactInfo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                       JOptionPane.showMessageDialog(null, "Privacy policy\n" +
                               "\n" +
                               "AquaSjoerd\n" +
                               "Rotterdamseweg 137 \n" +
                               "aquasjoerdbv@gmail.com\n" +
                               "\n" +
                               "- Contacteren\n" +
                               "Wij verwerken uw gegevens om deze vervolgens weer te gebruiken voor het mogelijk benodigd contact tussen cliënt en bedrijf.\n" +
                               "\n" +
                               "- Nieuwsbrieven\n" +
                               "Wij verwerken uw gegevens om nieuws over onze actie's en bezigheden naar u over te brengen.\n" +
                               "\n" +
                               "Volgens de AVG principes heeft de cliënt het recht op inzage van zijn/haar persoonsgegevens. \n" +
                               "De cliënt kan vervolgens kiezen voor een correctie of verwijdering van bepaalde gegevens mits dit benodigd lijkt voor de cliënt. \n" +
                               "Verwijdering mag echter alleen als de gegevens als niet relevant worden beschouwd door het bedrijf.\n" +
                               "\n" +
                               "De cliënt heeft recht op dataportabiliteit. Dit houdt in dat de cliënt alle digitale gegevens kan ontvangen.\n" +
                               "\n" +
                               "De cliënt heeft recht op vergetelheid, de cliënt kan vergeten worden.\n" +
                               "\n" +
                               "De cliënt heeft klachtrecht, hij/zij mag bezwaar maken tegen de gegevensverwerking.\n" +
                               "\n" +
                               "De cliënt kan een aanzoek doen tot een kijk op geautomatiseerde besluitsvorming(en) op basis van de persoonsgegevens.\n" +
                               "\n" +
                               "Wij delen de cliënt's persoonsgegevens NIET met derden.\n" +
                               "\n" +
                               "Voor het claimen van de klantrechten is het vereist dat de cliënt hier een aanzoek voor doet. Dit kan via onze klantenservice.\n" +
                               "\n" +
                               "De lengte van de persoonsgegevens bewaring, is een maand groter dan de lengte van het abonnement.\n" +
                               "\n" +
                               "Wij verwijderen uw persoonsgegevens na een maand dat uw abonnement is afgelopen, zodat u zich nog een maand kan bedenken voor verwijdering.\n" +
                               "\n" +
                               "Bij het aanschaffen van AquaSjoerd heeft u onze privacy voorwaarden geaccepteerd.");
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
                    contact.setBackground(new Color(94, 163, 226));
                    contact.setBorder(border);
                    contact.add(contactInfo);

                    JLabel typeNaam = new JLabel();
                    typeNaam.setText("Persoonlijke gegevens");
                    typeNaam.setFont(new Font("Arial", Font.PLAIN, 12));


                    JPanel type = new JPanel();
                    type.setBounds(0, 0, 150, 50);
                    type.setBorder(border);
                    type.setBackground(new Color(94, 163, 226));
                    type.add(typeNaam);

                    JLabel kopNaam = new JLabel();
                    kopNaam.setText("AquaSjoerd");
                    kopNaam.setFont(new Font("Times New Roman", Font.PLAIN, 22));

                    JPanel kop = new JPanel();
                    kop.setBounds(150, 0, 550, 50);
                    kop.setBorder(border);
                    kop.setBackground(new Color(94, 163, 226));
                    kop.add(kopNaam);


                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frame.setLayout(null);
                    frame.setSize(700, 400);
                    frame.setResizable(false);
                    frame.setTitle("Persoonlijke Gegevens");
                    frame.setVisible(true);
                    frame.add(type);
                    frame.add(kop);
                    frame.add(contact);
                    frame.add(gegevens);
                    frame.add(plaatje);

                } else {
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
                submitPanel.setBounds(500, 100, 200, 150);
                submitPanel.add(submitKnop);

                JTextField invoerStad = new JTextField();
                invoerStad.setPreferredSize(new Dimension(200, 25));


                JLabel stadLabel = new JLabel();
                stadLabel.setText("Voer hier uw stad in: ");
                stadLabel.setFont(new Font("Arial", Font.PLAIN, 12));

                JPanel stadPanel = new JPanel();
                stadPanel.setBounds(250, 150, 200, 75);
                stadPanel.add(stadLabel);
                stadPanel.add(invoerStad);

                JTextField emailInvoer = new JTextField();
                emailInvoer.setPreferredSize(new Dimension(200, 25));


                JLabel emailLabel = new JLabel();
                emailLabel.setText("Voer hier uw emailadres in: ");
                emailLabel.setFont(new Font("Arial", Font.PLAIN, 12));

                JPanel emailPanel = new JPanel();
                emailPanel.setBounds(0, 150, 200, 75);
                emailPanel.add(emailLabel);
                emailPanel.add(emailInvoer);

                JTextField invoerPostcode = new JTextField();
                invoerPostcode.setPreferredSize(new Dimension(200, 25));


                JLabel postcodeLabel = new JLabel();
                postcodeLabel.setText("Voer hier uw postcode in: ");
                postcodeLabel.setFont(new Font("Arial", Font.PLAIN, 12));


                JPanel postcodePanel = new JPanel();
                postcodePanel.setBounds(250, 75, 200, 75);
                postcodePanel.add(postcodeLabel);
                postcodePanel.add(invoerPostcode);

                JTextField adresInvoer = new JTextField();
                adresInvoer.setPreferredSize(new Dimension(200, 25));


                JLabel adresLabel = new JLabel();
                adresLabel.setText("Voer hier uw adres in: ");
                adresLabel.setFont(new Font("Arial", Font.PLAIN, 12));


                JPanel wachtwoordPanel = new JPanel();
                JPanel adresPanel = new JPanel();
                wachtwoordPanel.setBounds(250, 0, 200, 75);
                adresPanel.add(adresLabel);
                adresPanel.add(adresInvoer);

                JPasswordField invoerWachtwoord = new JPasswordField();
                invoerWachtwoord.setPreferredSize(new Dimension(200, 25));


                JLabel wachtwoordVraag = new JLabel();
                wachtwoordVraag.setText("Voer uw wachtwoord in: ");
                wachtwoordVraag.setFont(new Font("Arial", Font.PLAIN, 12));

                JCheckBox hashie = new JCheckBox("Laat wachtwoord zien");
                hashie.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (hashie.isSelected()){
                            invoerWachtwoord.setEchoChar((char)0);
                        }
                        else {
                            invoerWachtwoord.setEchoChar('*');
                        }
                    }
                });

                adresPanel.setBounds(0, 75, 200, 50);
                wachtwoordPanel.add(wachtwoordVraag);
                wachtwoordPanel.add(invoerWachtwoord);
                wachtwoordPanel.add(hashie);

                JTextField invoerNaam = new JTextField();
                invoerNaam.setPreferredSize(new Dimension(200, 25));
                invoerNaam.setBounds(20, 50, 200, 75);

//                JPanel textFieldNaam = new JPanel();
//                textFieldNaam.add(invoerNaam);

                JLabel vulNaamIn = new JLabel();
                vulNaamIn.setText("Voer uw naam in: ");
                vulNaamIn.setFont(new Font("Arial", Font.PLAIN, 12));


                JPanel naamPanel = new JPanel();
                naamPanel.setBounds(0, 0, 200, 75);
                naamPanel.add(vulNaamIn);
                naamPanel.add(invoerNaam);


                JFrame inlogFrame = new JFrame();
                inlogFrame.setTitle("Registratie");
                inlogFrame.setSize(700, 300);
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
                        wachtwoord = invoerWachtwoord.getText();
                        adres = adresInvoer.getText();
                        postcode = invoerPostcode.getText();
                        emailadress = emailInvoer.getText();
                        stad = invoerStad.getText();
                        JOptionPane.showMessageDialog(null, "Bedankt voor uw registratie " + naam);
                        inlogFrame.show(false);


                    }
                });
            }
        });
        Gewassen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JButton andersKnop = new JButton();
                andersKnop.setText("Submit");
                andersKnop.setFont(new Font("Arial", Font.ITALIC, 14));

                JTextField andersField = new JTextField();
                andersField.setPreferredSize(new Dimension(100,25));

                JLabel andersLabel = new JLabel();
                andersLabel.setText("Anders: ");
                andersLabel.setFont(new Font("Arial", Font.ITALIC,14));

                JButton ijsbergslaKnop = new JButton();
                ijsbergslaKnop.setText("IJsbergsla");
                ijsbergslaKnop.setFont(new Font("Arial", Font.ITALIC,14));

                JButton wortelKnop = new JButton();
                wortelKnop.setText("    Wortel   ");
                wortelKnop.setFont(new Font("Arial", Font.ITALIC, 14));

                JButton tarweKnop = new JButton();
                tarweKnop.setText("   Tarwe   ");
                tarweKnop.setFont(new Font("Arial", Font.ITALIC,14));

                JButton maisKnop = new JButton();
                maisKnop.setText("     Mais     ");
                maisKnop.setFont(new Font("Arial", Font.ITALIC, 14));

                JButton aardappelKnop = new JButton();
                aardappelKnop.setText("Aardappel");
                aardappelKnop.setFont(new Font("Arial", Font.ITALIC,14));

                JPanel aardappelPanel = new JPanel();
                aardappelPanel.setBounds(0,0, 225, 50);
                aardappelPanel.setBackground(new Color(94, 163, 226));
                aardappelPanel.add(aardappelKnop);

                JPanel maisPanel = new JPanel();
                maisPanel.setBounds(225,0,275,50);
                maisPanel.setBackground(new Color(94, 163, 226));
                maisPanel.add(maisKnop);

                JPanel tarwePanel = new JPanel();
                tarwePanel.setBounds(0,50,225,50);
                tarwePanel.setBackground(new Color(94, 163, 226));
                tarwePanel.add(tarweKnop);

                JPanel wortelPanel = new JPanel();
                wortelPanel.setBounds(225,50,275,50);
                wortelPanel.setBackground(new Color(94, 163, 226));
                wortelPanel.add(wortelKnop);

                JPanel ijsbergslaPanel =new JPanel();
                ijsbergslaPanel.setBounds(0,100, 225, 50);
                ijsbergslaPanel.setBackground(new Color(94, 163, 226));
                ijsbergslaPanel.add(ijsbergslaKnop);

                JPanel andersPanel = new JPanel();
                andersPanel.setBounds(225,100,275,50);
                andersPanel.setBackground(new Color(94, 163, 226));
                andersPanel.add(andersLabel);
                andersPanel.add(andersField);
                andersPanel.add(andersKnop);

                String [] eigenArray = {"Courgette", "Broccoli", "Sojabonen", "Yam"};
                JComboBox keuzeBox = new JComboBox(eigenArray);



                JPanel rarePanel = new JPanel();
                rarePanel.setBounds(0,150,225,100);
                rarePanel.setBackground(new Color(94, 163, 226));
                rarePanel.add(keuzeBox);

                JButton gebruikKnop = new JButton("Gebruik");
                gebruikKnop.setFont(new Font("Arial", Font.ITALIC,14));

                JPanel backgroundPanel = new JPanel();
                backgroundPanel.setBounds(180,150,100,100);
                backgroundPanel.setBackground(new Color(94, 163, 226));
                backgroundPanel.add(gebruikKnop);

                JPanel achtergrondKleur = new JPanel();
                achtergrondKleur.setBounds(280,150,220,100);
                achtergrondKleur.setBackground(new Color(94, 163, 226));


                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setLayout(null);
                frame.setSize(500, 250);
                frame.setResizable(false);
                frame.setTitle("Gewassen");
                frame.setVisible(true);
                frame.add(aardappelPanel);
                frame.add(maisPanel);
                frame.add(tarwePanel);
                frame.add(wortelPanel);
                frame.add(ijsbergslaPanel);
                frame.add(andersPanel);
                frame.add(backgroundPanel);
                frame.add(rarePanel);
                frame.add(achtergrondKleur);


                gebruikKnop.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "AquaSjoerd staat geconfigureerd op uw zelf gemaakte configuratie");
                        frame.setVisible(false);

                    }
                });

                aardappelKnop.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.setVisible(false);
                        try {
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/configuratie", "root", "Rinnegan999!");
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery("select * from configuratie.anders");
                            statement.executeUpdate("insert into configuratie.anders values('aardappel','1','2')");
                        }
                        catch (SQLException a){
                            JOptionPane.showMessageDialog(null, "Error in de invoer, probeer het nog een keer");
                        }
                        JOptionPane.showMessageDialog(null, "AquaSjoerd staat geconfigureerd op het irrigeren van het gewas: aardappel");
                    }
                });

                maisKnop.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.setVisible(false);

                        try {
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/configuratie", "root", "Rinnegan999!");
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery("select * from configuratie.anders");
                            statement.executeUpdate("insert into configuratie.anders values('mais','2','2')");
                        }
                        catch (SQLException a){
                            JOptionPane.showMessageDialog(null, "Error in de invoer, probeer het nog een keer");
                        }




                        JOptionPane.showMessageDialog(null, "AquaSjoerd staat geconfigureerd op het irrigeren van het gewas: mais");
                    }
                });

                tarweKnop.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.setVisible(false);

                        try {
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/configuratie", "root", "Rinnegan999!");
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery("select * from configuratie.anders");
                            statement.executeUpdate("insert into configuratie.anders values('tarwe','3','1')");
                        }
                        catch (SQLException a){
                            JOptionPane.showMessageDialog(null, "Error in de invoer, probeer het nog een keer");
                        }



                        JOptionPane.showMessageDialog(null, "AquaSjoerd staat geconfigureerd op het irrigeren van het gewas: tarwe");
                    }
                });

                wortelKnop.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        try {
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/configuratie", "root", "Rinnegan999!");
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery("select * from configuratie.anders");
                            statement.executeUpdate("insert into configuratie.anders values('wortel','4','2')");
                        }
                        catch (SQLException a){
                            JOptionPane.showMessageDialog(null, "Error in de invoer, probeer het nog een keer");
                        }




                        frame.setVisible(false);
                        JOptionPane.showMessageDialog(null, "AquaSjoerd staat geconfigureerd op het irrigeren van het gewas: wortel");
                    }
                });

                ijsbergslaKnop.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        try {
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/configuratie", "root", "Rinnegan999!");
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery("select * from configuratie.anders");
                            statement.executeUpdate("insert into configuratie.anders values('ijsbergsla','5','1')");
                        }
                        catch (SQLException a){
                            JOptionPane.showMessageDialog(null, "Error in de invoer, probeer het nog een keer");
                        }

                        frame.setVisible(false);
                        JOptionPane.showMessageDialog(null, "AquaSjoerd staat geconfigureerd op het irrigeren van het gewas: ijsbergsla");
                    }
                });

                andersKnop.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        frame.setVisible(false);

                        JOptionPane.showMessageDialog(null, "AquaSjoerd staat geconfigureerd op het irrigeren op een gewas dat niet in het standaard configuratie is beschreven.\n" +
                                "Om dit gewas toe te voegen moet u dit gewas eerst handmatig configureren.\n" +
                                "Voor toekomstige toepassing van deze configuratie kunt u hem opslaan.");

                        String [] irrigatieArray = {"Weinig (1 keer per dag)", "Gemiddeld (3 keer per dag)", "Vaak (5 keer per dag)"};
                        JComboBox irrigatieBox = new JComboBox(irrigatieArray);

                        JButton submiteKnopje = new JButton();
                        submiteKnopje.setText("Opslaan");

                        JLabel hoevaak = new JLabel();
                        hoevaak.setText("Hoe vaak wilt u AquaSjoerd laten irrigeren?");

                        JPanel labelPanel = new JPanel();
                        labelPanel.setBounds(10, 0, 300, 50);
                        labelPanel.add(hoevaak);
                        labelPanel.setBackground(new Color(94, 163, 226));

                        JPanel boxPanel = new JPanel();
                        boxPanel.setBounds(0,50,350,50);
                        boxPanel.add(irrigatieBox);
                        boxPanel.add(submiteKnopje);
                        boxPanel.setBackground(new Color(94, 163, 226));


                        andersNaam = andersField.getText();
                        andersKeren = irrigatieBox.getSelectedItem().toString();


                        if (andersKeren.equals(irrigatieArray[0])){
                            aantalAndersKeren = "1";
                        }
                         if (andersKeren.equals(irrigatieArray[1])){
                            aantalAndersKeren = "3";
                        }
                         if (andersKeren.equals(irrigatieArray[2])){
                            aantalAndersKeren= "5";
                        }

                        try {
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/configuratie", "root", "Rinnegan999!");
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery("SELECT * FROM configuratie.anders;");


                        while (resultSet.next()){

                            andersNummer = resultSet.getInt("nummer");
                            andersNummer++;

                        }

                            statement.executeUpdate("insert into anders values('"+andersNaam +"','" + andersNummer + "','"+ aantalAndersKeren + "')");

                        } catch (SQLException a) {
                            JOptionPane.showMessageDialog(null,"Error in de database");
                        }

                        JPanel achtergrondPaneel = new JPanel();
                        achtergrondPaneel.setBounds(0,0,500,180);
                        achtergrondPaneel.setBackground(new Color(94, 163, 226));


                        JFrame aframe = new JFrame();
                        aframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        aframe.setLayout(null);
                        aframe.setSize(500, 180);
                        aframe.setResizable(false);
                        aframe.setTitle("Registratie nieuw gewas");
                        aframe.setVisible(true);
                        aframe.add(achtergrondPaneel);
                        aframe.add(labelPanel);
                        aframe.add(boxPanel);

                        submiteKnopje.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JOptionPane.showMessageDialog(null, "De configuratie is opgeslagen");
                        aframe.setVisible(false);
                            }
                        });
                    }
                });

            }
        });
    }


    public static void main(String[] args) {

        JFrame beginFrame = new JFrame("AquaSjoerd");
        beginFrame.setContentPane(new DeGaatGoed().mainpanel);
        beginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        beginFrame.pack();
        beginFrame.setSize(700, 400);

        beginFrame.setVisible(true);
        beginFrame.setResizable(false);


        SerialPort[] ports = SerialPort.getCommPorts();
        SerialPort arduino = ports[0];
        for (SerialPort port : ports) {
            if (port.toString().equals("Arduino Uno")) {
                arduino = port;
            }
        }

        arduino.openPort();
        MessageListener listener = new MessageListener();
        arduino.addDataListener(listener);

    }
}

final class MessageListener implements SerialPortMessageListener {
    @Override
    public int getListeningEvents() { return SerialPort.LISTENING_EVENT_DATA_RECEIVED; }

    @Override
    public byte[] getMessageDelimiter() { return new byte[] { (byte)0x0A}; }

    @Override
    public boolean delimiterIndicatesEndOfMessage() { return true; }

    @Override
    public void serialEvent(SerialPortEvent event) {
        byte[] delimitedMessage = event.getReceivedData();
        String message = "";
        for (byte b : delimitedMessage) {
            message += (char) b;
        }
        System.out.print(message);
        String[] variables = message.split(",");
        for (String s : variables) {
            System.out.println(s);
        }
        if (DeGaatGoed.counter > 0) {
            DeGaatGoed.volume = Integer.parseInt(variables[0]);
            DeGaatGoed.humidity = Integer.parseInt(variables[1]);
            DeGaatGoed.temperatuur = variables[2];
            DeGaatGoed.lichtintensiteit = Integer.parseInt(variables[3]);
            DeGaatGoed.bodemvochtigheid = Integer.parseInt(variables[4]);
            if (variables[5].equals("1")){
                DeGaatGoed.pomp = "aan";
            }
            else {
                DeGaatGoed.pomp = "uit";
            }
            Scanner scn = new Scanner(variables[6]);
            DeGaatGoed.totaleHoeveelheidIrrigatie = scn.nextInt();


            System.out.println("Volume: " + DeGaatGoed.volume);
            System.out.println("Humidity: " + DeGaatGoed.humidity);
            System.out.println("Temperature: " + DeGaatGoed.temperatuur);
            System.out.println("Licht: " + DeGaatGoed.lichtintensiteit);
            System.out.println("Bodem: " + DeGaatGoed.bodemvochtigheid);
            System.out.println("pomp: " + DeGaatGoed.pomp);
            System.out.println("totaal: " + DeGaatGoed.totaleHoeveelheidIrrigatie);
        } else {
            DeGaatGoed.counter++;
        }

    }
}
//
//            JPanel mainpanel = new JPanel();
//            mainpanel.setBounds(0,0,700,400);
//            mainpanel.setBackground(new Color(94,163,226));
//            beginFrame.add(mainpanel);

  // connectie mySQL





