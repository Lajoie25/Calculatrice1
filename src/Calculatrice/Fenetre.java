package Calculatrice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame {
    private JPanel container = new JPanel();
    private JPanel nord = new JPanel();
    private JPanel left = new JPanel();
    private JPanel right = new JPanel();
    private JButton un = new JButton("1");
    private JButton deux = new JButton("2");
    private JButton trois = new JButton("3");
    private JButton quatre = new JButton("4");
    private JButton cinq = new JButton("5");
    private JButton six = new JButton("6");
    private JButton sept = new JButton("7");
    private JButton huit = new JButton("8");
    private JButton neuf = new JButton("9");
    private JButton zero = new JButton("0");
    private JButton point = new JButton(".");
    private JButton egale = new JButton("=");
    private JButton c = new JButton("C");
    private JButton plus = new JButton("+");
    private JButton moins = new JButton("-");
    private JButton fois = new JButton("*");
    private JButton div = new JButton("/");
    private final Font police = new Font("Verdana", Font.BOLD, 30);

    private Dimension bntRight = new Dimension(80, 50);
    private Dimension bntLeft = new Dimension(80, 60);

    private final JLabel affichage = new JLabel("0", SwingConstants.RIGHT);
    private boolean onClick = false, update = false;
    private double nbr;

    public Fenetre() {
        super();
        this.setTitle("Calculette");
        this.setSize(390, 410);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        //layout
        container.setLayout(new BorderLayout());

        //NORD
        affichage.setPreferredSize(new Dimension(360, 50));
        affichage.setBackground(Color.white);
        affichage.setFont(police);
        affichage.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        nord.add(affichage);

        //droite
        right.setPreferredSize(new Dimension(100, 300));
        c.setPreferredSize(bntLeft);


        plus.setPreferredSize(bntRight);
        moins.setPreferredSize(bntRight);
        fois.setPreferredSize(bntRight);
        div.setPreferredSize(bntRight);
        right.add(c);
        right.add(plus);
        right.add(moins);
        right.add(fois);
        right.add(div);

        //Gauche
        left.setPreferredSize(new Dimension(280, 300));
        un.setPreferredSize(bntLeft);
        deux.setPreferredSize(bntLeft);
        trois.setPreferredSize(bntLeft);
        quatre.setPreferredSize(bntLeft);
        cinq.setPreferredSize(bntLeft);
        six.setPreferredSize(bntLeft);
        sept.setPreferredSize(bntLeft);
        huit.setPreferredSize(bntLeft);
        neuf.setPreferredSize(bntLeft);
        zero.setPreferredSize(bntLeft);
        point.setPreferredSize(bntLeft);
        egale.setPreferredSize(bntLeft);

        left.add(un);
        left.add(deux);
        left.add(trois);
        left.add(quatre);
        left.add(cinq);
        left.add(six);
        left.add(sept);
        left.add(huit);
        left.add(neuf);
        left.add(zero);
        left.add(point);
        left.add(egale);

        egale.addActionListener(new EgalListener());
        c.addActionListener(new CleanListener());
        plus.addActionListener(new PlusListener());
        moins.addActionListener(new MoinsListener());
        fois.addActionListener(new FoisListener());
        div.addActionListener(new DivListener());

        un.addActionListener(new ClavListener());
        deux.addActionListener(new ClavListener());
        trois.addActionListener(new ClavListener());
        quatre.addActionListener(new ClavListener());
        cinq.addActionListener(new ClavListener());
        six.addActionListener(new ClavListener());
        sept.addActionListener(new ClavListener());
        huit.addActionListener(new ClavListener());
        neuf.addActionListener(new ClavListener());


        container.add(nord, BorderLayout.NORTH);
        container.add(right, BorderLayout.EAST);
        container.add(left, BorderLayout.WEST);
        this.setContentPane(container);
        this.setVisible(true);
    }

    private void Plus() {
        nbr = nbr + Double.parseDouble(affichage.getText());
        affichage.setText(String.valueOf(nbr));
    }

    private void Moins()

    {
        nbr = nbr - Double.parseDouble(affichage.getText());
        affichage.setText(String.valueOf(nbr));
    }

    private void Fois()

    {

        nbr = nbr * Double.parseDouble(affichage.getText());
        affichage.setText(String.valueOf(nbr));
    }

    private void Diviser(){

    nbr = nbr /Double.parseDouble(affichage.getText());
            affichage.setText(String.valueOf(nbr));
}

public class ClavListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String chiffre = ((JButton) actionEvent.getSource()).getText();
        if (update) {
            update = false;
        } else {
            if (!affichage.getText().equals("0"))
                chiffre = affichage.getText() + chiffre;
        }
        affichage.setText(chiffre);
    }
}

class CleanListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        onClick = false;
        update = true;
        affichage.setText("");
    }
}

class PlusListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (onClick) {
            Plus();
            affichage.setText(String.valueOf(nbr));
        } else {
            nbr = Double.parseDouble(affichage.getText());
            onClick = true;
        }
        update = true;
    }
}

public class MoinsListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (onClick) {
            Moins();
            affichage.setText(String.valueOf(nbr));
        } else {
            nbr = Double.parseDouble(affichage.getText());
            onClick = true;
        }
        update = true;
    }
}

class EgalListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
//        calcul();
        try{
            Plus();
        }catch (Exception ignored){}
        try{
            Moins();
        }catch (Exception ignored){}
        try{
            Fois();
        }catch (Exception ignored){}

        update = true;
        onClick = false;
    }
}

public class FoisListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (onClick) {
            Fois();
            affichage.setText(String.valueOf(nbr));
        } else {
            nbr = Double.parseDouble(affichage.getText());
            onClick = true;
        }
        update = true;
    }
}






}
