import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Tris implements ActionListener {
   Random random = new Random();
   JFrame frame = new JFrame();
   JPanel title_panel = new JPanel();
   JPanel button_panel = new JPanel();
   JLabel textfeild = new JLabel();
   JButton[] buttons = new JButton[9];
   boolean player1_turn;
   boolean isFull=true;




   Tris(){

       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(800,800);
       frame.getContentPane().setBackground(Color.black);
       frame.setVisible(true);

       textfeild.setBackground( Color.white);
       textfeild.setForeground(Color.black);
       textfeild.setFont(new Font("Cali",Font.BOLD,75));
       textfeild.setHorizontalAlignment(JLabel.CENTER);
       textfeild.setText("Tris");
       textfeild.setOpaque(true);

       title_panel.setLayout(new BorderLayout());
       title_panel.setBounds(0,0,800,100);
       title_panel.add(textfeild);

       frame.add(title_panel,BorderLayout.NORTH);
       frame.add(button_panel);

       button_panel.setLayout(new GridLayout(3,3));
       button_panel.setBackground(Color.blue);

       for(int i=0; i<9; i++){
           buttons[i] = new JButton();
           button_panel.add(buttons[i]);
           buttons[i].setBackground(Color.black);
           buttons[i].setFont(new Font("Cali",Font.BOLD,120));
           buttons[i].setFocusable(false);
           buttons[i].addActionListener(this);

           firsTurn();
       }

   }








    @Override
    public void actionPerformed(ActionEvent e) {
       for (int i=0; i<9; i++) {
           if (e.getSource() == buttons[i]) {
               if (player1_turn) {
                   if (buttons[i].getText() == "") {
                       buttons[i].setForeground(new Color(255, 0, 0));
                       buttons[i].setText("X");
                       player1_turn = false;
                       textfeild.setText("Player 2 Turn");
                       check();
                   }
               } else {
                   if (buttons[i].getText() == "") {
                       buttons[i].setForeground(new Color(0, 0, 255));
                       buttons[i].setText("O");
                       player1_turn = true;
                       textfeild.setText("Player 1 Turn");
                       check();
                   }


               }
           }
       }

    }
    public void firsTurn() {

        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textfeild.setText("Player 1 turn");
        } else {
            player1_turn = false;
            textfeild.setText("Player 2 turn");
        }
    }

    public void check(){
       //chek if player 1 has won
        if (
                (buttons[0].getText()=="X") &&
                (buttons[1].getText()=="X")&&
                (buttons[2].getText()=="X")
                ){
            xWins(0,1,2);
        }
        if (
                (buttons[3].getText()=="X") &&
                (buttons[4].getText()=="X")&&
                (buttons[5].getText()=="X")
        ){
            xWins(3,4,5);
        }
        if (
                 (buttons[6].getText()=="X") &&
                 (buttons[7].getText()=="X")&&
                 (buttons[8].getText()=="X")
        ){
            xWins(6,7,8);
        }
        if (
                 (buttons[0].getText()=="X") &&
                 (buttons[3].getText()=="X")&&
                 (buttons[6].getText()=="X")
        ){
            xWins(0,3,6);
        }
        if (
                 (buttons[1].getText()=="X") &&
                 (buttons[4].getText()=="X")&&
                 (buttons[7].getText()=="X")
        ){
            xWins(1,4,7);
        }
        if (
                 (buttons[2].getText()=="X") &&
                 (buttons[5].getText()=="X")&&
                 (buttons[8].getText()=="X")
        ){
            xWins(2,5,8);
        }
        if (
                 (buttons[0].getText()=="X") &&
                 (buttons[4].getText()=="X")&&
                 (buttons[8].getText()=="X")
        ){
            xWins(0,4,8);
        }

        if (
                 (buttons[2].getText()=="X") &&
                 (buttons[4].getText()=="X")&&
                 (buttons[6].getText()=="X")
        ){
            xWins(2,4,6);
        }

        // chek if player 2 has won
        if (
                (buttons[0].getText()=="O") &&
                        (buttons[1].getText()=="O")&&
                        (buttons[2].getText()=="O")
        ){
            yWins(0,1,2);
        }
        if (
                (buttons[3].getText()=="O") &&
                        (buttons[4].getText()=="O")&&
                        (buttons[5].getText()=="O")
        ){
            yWins(3,4,5);
        }
        if (
                (buttons[6].getText()=="O") &&
                        (buttons[7].getText()=="O")&&
                        (buttons[8].getText()=="O")
        ){
            yWins(6,7,8);
        }
        if (
                (buttons[0].getText()=="O") &&
                        (buttons[3].getText()=="O")&&
                        (buttons[6].getText()=="O")
        ){
            yWins(0,3,6);
        }
        if (
                (buttons[1].getText()=="O") &&
                        (buttons[4].getText()=="O")&&
                        (buttons[7].getText()=="O")
        ){
            yWins(1,4,7);
        }
        if (
                (buttons[2].getText()=="O") &&
                        (buttons[5].getText()=="O")&&
                        (buttons[8].getText()=="O")
        ){
            yWins(2,5,8);
        }
        if (
                (buttons[0].getText()=="O") &&
                        (buttons[4].getText()=="O")&&
                        (buttons[8].getText()=="O")
        ){
            yWins(0,4,8);
        }

        if (
                (buttons[2].getText()=="O") &&
                        (buttons[4].getText()=="O")&&
                        (buttons[6].getText()=="O")
        ){
            yWins(2,4,6);
        }

        if (
                (buttons[0].getText()!="") &&
                (buttons[1].getText()!="")&&
                (buttons[2].getText()!="")&&
                (buttons[3].getText()!="") &&
                (buttons[4].getText()!="")&&
                (buttons[5].getText()!="")&&
                (buttons[6].getText()!="") &&
                (buttons[7].getText()!="")&&
                (buttons[8].getText()!="")){
            Draw(0, 1, 2, 3, 4, 5 ,6 ,7, 8);
        }


    }

    public void xWins(int a, int b, int c){


       buttons[a].setBackground(Color.red);
       buttons[b].setBackground(Color.red);
       buttons[c].setBackground(Color.red);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException z) {
            z.printStackTrace();
        }

       for (int i=0; i<9; i++){
            buttons[i].setEnabled(false);
            textfeild.setText(" Congratulation 1");
       }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Restart();
    }

    public void yWins(int a, int b, int c){



        buttons[a].setBackground(Color.red);
        buttons[b].setBackground(Color.red);
        buttons[c].setBackground(Color.red);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException z) {
            z.printStackTrace();
        }

        for (int i=0; i<9; i++){
            buttons[i].setEnabled(false);
            textfeild.setText(" Congratulation 2");
        }

        //Restart();
    }

    public void Draw (int a, int b, int c,int d, int e, int f,int g, int h, int l){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException z) {
            z.printStackTrace();
        }

        buttons[a].setBackground(Color.red);
        buttons[b].setBackground(Color.red);
        buttons[c].setBackground(Color.red);
        buttons[d].setBackground(Color.red);
        buttons[e].setBackground(Color.red);
        buttons[f].setBackground(Color.red);
        buttons[g].setBackground(Color.red);
        buttons[h].setBackground(Color.red);
        buttons[l].setBackground(Color.red);

        for (int i=0; i<9; i++){
            buttons[i].setEnabled(false);
            textfeild.setText("It's a Draw");

        }

        //Restart();
    }

    public void Restart (){


       for (int i=0; i<9; i++){
           buttons[i].setEnabled(true);
           buttons[i].setText("");
           buttons[i].setBackground(Color.black);
       }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException z) {
            z.printStackTrace();
        }
    }
    

}
